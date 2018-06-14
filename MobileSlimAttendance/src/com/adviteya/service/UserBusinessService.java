/**
 * 
 */
package com.adviteya.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.adviteya.meta.MA_ContractorCompanyMeta;
import com.adviteya.meta.MA_TemplateMeta;
import com.adviteya.meta.MA_UserMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Address;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_ContractorCompany;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Template;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.model.MA_User;
import com.adviteya.model.MA_UserProfile;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.UserDAO;
import com.adviteya.util.ServiceUtil;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

/**
 * @author Dheeraj
 * 
 */
public class UserBusinessService implements IUserBusinessService
{
	
	private Logger        logger        = Logger.getLogger(UserBusinessService.class
	                                            .getName());
	private EntityService entityService = EntityService.getInstance();
	
	public MA_User authenticateUser(MA_User user)
	{
		logger.log(Level.INFO, "Inside authenticateUser");
		Key userkey = null;
		Transaction tx = Datastore.beginTransaction();
		
		UserDAO userDAO = (UserDAO) UserDAO.newInstance();
		
		MA_User aunthicatedUser = userDAO.authenticateUser(user);
		if (null != aunthicatedUser)
		{
			
			userkey = aunthicatedUser.getKey();
		}
		tx.commit();
		logger.log(Level.INFO, "authenticateUser  userkey-" + userkey);
		return aunthicatedUser;
		
	}
	
	/**
	 * Authenticate using IMEI code
	 * 
	 * @param user
	 * @return
	 */
	public MA_User authenticateUserByIMEI(MA_User user)
	{
		logger.log(Level.INFO, "Inside authenticateUserByIMEI");
		Key userkey = null;
		Transaction tx = Datastore.beginTransaction();
		
		UserDAO userDAO = (UserDAO) UserDAO.newInstance();
		
		MA_User aunthicatedUser = userDAO.authenticateUserByIMEI(user);
		if (null != aunthicatedUser)
		{		
			userkey = aunthicatedUser.getKey();
		}
		tx.commit();
		logger.log(Level.INFO, "authenticateUser  userkey-" + userkey);
		return aunthicatedUser;
		
	}
	
	/*
	 * First check in the user exists, if not create the User (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.IUserBusinessService#createUser(com.adviteya.model
	 * .MA_User)
	 */
	public String createUser(Map<String, Object> input)
	{
		logger.log(Level.INFO, "Inside createUser");
		String status = "failure";
		
		ContractBusinessService contractService=new ContractBusinessService();
		MA_User user = new MA_User();
		UserDAO userDAO = (UserDAO) UserDAO.newInstance();
		BeanUtil.copy(input, user);
		if (!userDAO.isUserExists(user))
		{
			MA_Company company = new MA_Company();
			MA_Address address = new MA_Address();
			MA_Employee employee = new MA_Employee();
			ServiceUtil serviceUtil = new ServiceUtil();
			List objList = new ArrayList();
			objList.add(company);
			objList.add(address);
			objList.add(employee);
			serviceUtil.copy(input, objList);
			
			Long emplyoeePopulation = Long.parseLong((String) input
			        .get("emplyoeePopulation"));
			company.setEmplyoeePopulation(emplyoeePopulation);
			
			String templateId = (String) input.get("template");
			Key k3 = Datastore.createKey(MA_Template.class,
			        Long.parseLong(templateId));
			MA_TemplateMeta templateMeta = MA_TemplateMeta.get();
			MA_Template template = Datastore.query(templateMeta)
			        .filter(templateMeta.key.equal(k3)).asSingle();
			
			company.getTemplateRef().setModel(template);
			CompanyBusinessService _cbs = new CompanyBusinessService();
			
			// Transaction is starting
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			
			Key k = AbstractEntityDAO.addModel(company);
			company.setKey(k);
			ArrayList<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
			List<MA_TimeSheetRule> timeSheetRules = _cbs
			        .getDefaultTimeSheetRuleConfiguration(company);
			entityList.addAll(timeSheetRules);
			AbstractEntityDAO.addModels(entityList);
			
			serviceUtil.populateAddressObj(input, address, company);
			employee.getCompanyRef().setModel(company);
			user.getCompanyRef().setModel(company);
			MA_UserProfile profile = new MA_UserProfile();
			String profileId = (String) input.get("userProfile");
			Key k1 = Datastore.createKey(MA_UserProfile.class,
			        Long.parseLong(profileId));
			profile.setKey(k1);
			user.getUserProfileRef().setModel(profile);
			
			Key _empKey = AbstractEntityDAO.addModel(employee);
			AbstractEntityDAO.addModel(address);
			user.getEmployeeRef().setModel(employee);
			AbstractEntityDAO.addModel(user);
			
			gtx.commit();
			
			contractService.createDemoContract(company.getKey().getId());
			// Transaction End
			
			status = ("" + k.getId()).trim();
		} else
		{
			status = "userExists";
		}
		logger.log(Level.INFO, "createUser Status-" + status);
		return status;
	}
	
	public void deactivateUser(MA_User user)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void updateUser(MA_User user)
	{
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * TODO - This method is returning company key. The method should be renamed
	 */
	public MA_User authenticateUserLogin(Map<String, Object> input)
	{
		
		logger.log(Level.INFO, "Inside authenticateUserLogin");
		MA_User user = new MA_User();
		BeanUtil.copy(input, user);
		Key companyKey = null;
		Transaction tx = Datastore.beginTransaction();
		
		UserDAO userDAO = (UserDAO) UserDAO.newInstance();
		
		MA_User aunthicatedUser = userDAO.authenticateUser(user);
		tx.commit();
		return aunthicatedUser;
		
	}
	
	public String createContractorCompanyUser(Map<String, Object> input,
	        Long companyId)
	{
		logger.log(Level.INFO, "Inside createContractorCompanyUser");
		String status = "failure";
		MA_User user = new MA_User();
		BeanUtil.copy(input, user);
		if (null == authenticateUser(user))
		{
			Key k1 = Datastore.createKey(MA_Company.class, companyId);
			MA_Company company = entityService.getCompanyObj(k1);
			company.setKey(k1);
			
			MA_ContractorCompany contractorCompany = new MA_ContractorCompany();
			MA_Address address = new MA_Address();
			MA_Employee employee = new MA_Employee();
			ServiceUtil serviceUtil = new ServiceUtil();
			contractorCompany.setViewReports("N");
			contractorCompany.setCreateEmployee("N");
			contractorCompany.setStatus("Y");
			contractorCompany.getCompanyRef().setModel(company);
			List objList = new ArrayList();
			objList.add(contractorCompany);
			objList.add(address);
			objList.add(employee);
			serviceUtil.copy(input, objList);
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			Key k = AbstractEntityDAO.addModel(contractorCompany);
			serviceUtil.populateAddressObj(input, address, contractorCompany);
			employee.getCompanyRef().setModel(contractorCompany);
			user.getCompanyRef().setModel(contractorCompany);
			MA_UserProfile profile = new MA_UserProfile();
			String profileId = (String) input.get("userProfile");
			Key k2 = Datastore.createKey(MA_UserProfile.class, 1006);
			profile.setKey(k2);
			user.getUserProfileRef().setModel(profile);
			ArrayList<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
			entityList.add(employee);
			entityList.add(address);
			entityList.add(user);
			AbstractEntityDAO.addModels(entityList);
			gtx.commit();
			status = ("" + k.getId()).trim();
		} else
		{
			status = "userExists";
		}
		logger.log(Level.INFO, "createContractorCompanyUser Status-" + status);
		return status;
	}
	
	public MA_User updatePassword(Long companyId, String password)
	{
		
		MA_UserMeta userMeta = MA_UserMeta.get();
		Key k1 = Datastore.createKey(MA_Company.class, companyId);
		MA_Company company = entityService.getCompanyObj(k1);
		company.setKey(k1);
		
		MA_User user = Datastore.query(userMeta)
		        .filter(userMeta.companyRef.equal(k1)).asSingle();
		
		user.setPassword(password);
		company.setAccountVerified(true);
		company.setActive("Y");
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		AbstractEntityDAO.addModel(user);
		AbstractEntityDAO.addModel(company);
		gtx.commit();
		
		return user;
		
	}
	
	public List<MA_User> getContractorCompanyUserList(long companyId)
	{
		Key companyKey = Datastore.createKey(MA_Company.class, companyId);
		MA_ContractorCompanyMeta contractorCompanyMeta = MA_ContractorCompanyMeta
		        .get();
		List<MA_ContractorCompany> contractorCompanies = Datastore
		        .query(contractorCompanyMeta)
		        .filter(contractorCompanyMeta.companyRef.equal(companyKey))
		        .asList();
		
		List<MA_User> userList = new ArrayList<MA_User>();
		Iterator<MA_ContractorCompany> iterator = contractorCompanies
		        .iterator();
		MA_UserMeta userMeta = MA_UserMeta.get();
		while (iterator.hasNext())
		{
			MA_ContractorCompany contractorCompany = iterator.next();
			userList.addAll(Datastore
			        .query(userMeta)
			        .filter(userMeta.companyRef.equal(contractorCompany
			                .getKey())).asList());
		}
		return userList;
		
	}
	
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public MA_User loadUser(MA_Employee employee)
	{
		MA_UserMeta _userMeta = new MA_UserMeta();
		MA_User _user = Datastore.query(_userMeta)
		        .filter(_userMeta.userName.equal(employee.getCompanyEmpId()))
		        .asSingle();
		return _user;
	}
}
