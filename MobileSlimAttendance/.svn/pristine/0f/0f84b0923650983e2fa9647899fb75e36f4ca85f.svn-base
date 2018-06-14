package com.adviteya.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.datastore.ModelQuery;
import org.slim3.util.BeanUtil;
import org.slim3.util.DateUtil;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.EmployeeDTO;
import com.adviteya.meta.MA_ContractorCompanyMeta;
import com.adviteya.meta.MA_EmployeeMeta;
import com.adviteya.meta.MA_UserMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_ContractorCompany;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_TemplateSkill;
import com.adviteya.model.MA_User;
import com.adviteya.model.MA_UserProfile;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.UserDAO;
import com.google.appengine.api.datastore.Key;

public class EmployeeService implements IEmployeeService
{
	private static Logger logger        = Logger.getLogger(EmployeeService.class
	                                            .getName());
	private EntityService entityService = EntityService.getInstance();
	
	public String createEmployee(Map<String, Object> input,
	        String[] dayOfWeeklyOff) throws Exception
	{
		logger.log(Level.INFO, "Start createEmployee");
		String status = "failure";
		MA_Company company = new MA_Company();
		String employeeType = (String) input.get("employeeType");
		Long companyId = null;
		MA_Employee employee = new MA_Employee();
		MA_EmployeeMeta employeeMeta = MA_EmployeeMeta.get();
		Key k1 = null;
		System.out.println(input.get("emailId") + "   "
		        + input.get("isManager"));
		String _empCompanyEmpId = (String) input.get("empCompanyId")
		        + (String) input.get("companyEmpId");
		if (employeeType.equals("2"))
		{
			companyId = Long.valueOf((String) input.get("contractorCompany"));
			logger.log(Level.INFO, "companyId=" + companyId);
			k1 = AbstractEntityDAO.createKey(company, companyId);
			company.setKey(k1);
			String contractorUniqueIdFlag = (String) input
			        .get("contractorUniqueIdFlag");
			logger.log(Level.INFO, "uniqueIdFlag=" + contractorUniqueIdFlag);
			if (contractorUniqueIdFlag.equals("N"))
			{
				int empCount = Datastore.query(employeeMeta)
				        .filter(employeeMeta.companyRef.equal(k1)).count() + 1001;
				
				_empCompanyEmpId = companyId + "-" + empCount;
				
			} else
			{
				_empCompanyEmpId = (String) input.get("contractorCompany")
				        + "-" + (String) input.get("companyEmpId");
			}
		} else
		{
			companyId = (Long) input.get("companyId");
			logger.log(Level.INFO, "companyId=" + companyId);
			k1 = AbstractEntityDAO.createKey(company, companyId);
			company.setKey(k1);
			String uniqueIdFlag = (String) input.get("uniqueIdFlag");
			logger.log(Level.INFO, "uniqueIdFlag=" + uniqueIdFlag);
			if (uniqueIdFlag.equals("N"))
			{
				int empCount = Datastore.query(employeeMeta)
				        .filter(employeeMeta.companyRef.equal(k1)).count() + 1001;
				
				_empCompanyEmpId = companyId + "-" + empCount;
				
			}
		}
		
		logger.log(Level.INFO, "Company Employee Id=" + _empCompanyEmpId);
		employee = Datastore
		        .query(employeeMeta)
		        .filter(employeeMeta.companyRef.equal(k1),
		                employeeMeta.companyEmpId.equal(_empCompanyEmpId),
		                employeeMeta.active.notEqual("N")).asSingle();
		
		logger.log(Level.INFO, "employee=" + employee);
		
		if (null != employee)
		{
			status = "employeeIdExists";
		} else
		{
			logger.log(Level.INFO,
			        "Employee dose not exists.Cretae New Employee");
			
			MA_User user = null;
			employee = new MA_Employee();
			MA_TemplateSkill skill = new MA_TemplateSkill();
			
			String startDate = (String) input.get("startDate");
			logger.log(Level.INFO, "startDate String=" + startDate);
			Date stDate = DateUtil.toDate(startDate, "MM/dd/yyyy");
			
			logger.log(Level.INFO, "startDate Date obj =" + stDate);
			
			input.put("startDate", stDate);
			employee.setStartDate(stDate);
			BeanUtil.copy(input, employee);
			
			logger.log(Level.INFO, "All attributes set in employee object");
			employee.getCompanyRef().setModel(company);
			employee.setCompanyEmpId(_empCompanyEmpId);
			String weeklyOffStr = "";
			if (null != dayOfWeeklyOff)
			{
				
				logger.log(Level.INFO, "dayOfWeeklyOff.length="
				        + dayOfWeeklyOff.length);
				for (int cnt = 0; cnt < dayOfWeeklyOff.length; cnt++)
				{
					if (!weeklyOffStr.equals(""))
					{
						weeklyOffStr = weeklyOffStr + ",";
					}
					weeklyOffStr = weeklyOffStr + dayOfWeeklyOff[cnt];
				}
			}
			
			logger.log(Level.INFO, "weeklyOffStr=" + weeklyOffStr);
			employee.setDayOfWeeklyOff(weeklyOffStr);
			
			/*
			 * MA_Location location = new MA_Location(); String locationId =
			 * (String) input.get("location"); Key k2 =
			 * Datastore.createKey(MA_Location.class,
			 * Long.parseLong(locationId)); location.setKey(k2);
			 * employee.getLocationRef().setModel(location);
			 */
			
			/*
			 * MA_Shift shift = new MA_Shift(); String shiftId = (String)
			 * input.get("shift"); Key k3 =Datastore.createKey(
			 * MA_Shift.class,Long.parseLong(shiftId)); shift.setKey(k3);
			 * employee.getShiftRef().setModel(shift);
			 */
			
			String skillId = (String) input.get("skill");
			logger.log(Level.INFO, "skillId=" + skillId);
			Key k3 = Datastore.createKey(MA_TemplateSkill.class,
			        Long.parseLong(skillId));
			skill.setKey(k3);
			
			logger.log(Level.INFO, "skillId Key=" + k3.getId());
			employee.getSkillRef().setModel(skill);
			
			// 03/27/2012 Shailesh added a field in employee entity as active.
			// Every time a user will create a new employee it will be saved
			// with status active.
			
			employee.setActive("Y");
			/**
			 * Shailesh added this code for default assignment to calculate the
			 * consolidated time sheets for planned and unplanned assignment and
			 * also to find out unassigned employee in case of planned
			 * assignment.
			 */
			
			/**
			 * 02/09/2012 - Dheeraj Do not create assignment for User which has
			 * profile type = 'MGMT' if the user is a supervisor or all owed to
			 * post own timesheet, then we need to add a entry in User's entity
			 */
			logger.log(Level.INFO,
			        "(employee.getIsSuperwiser()=" + employee.getIsSuperwiser());
			
			if (employee.getIsSuperwiser() != null
			        && employee.getIsSuperwiser().equalsIgnoreCase("Y"))
			{
				user = new MA_User();
				MA_UserMeta userMeta = new MA_UserMeta();
				MA_UserProfile userProfile = UserDAO.newInstance()
				        .getUserProfile("SUP");
				user.getUserProfileRef().setModel(userProfile);
				// user.setUserName(companyId + "-" + _empCompanyEmpId);
				user.setUserName(_empCompanyEmpId);
				
				user.getCompanyRef().setModel(company);
				
				// Dheeraj - 05/19/2012 : added logic to add IMEI cod
				user.setImeiCode(employee.getImeiCode());
			} else if (input.get("isManager").equals("Y"))
			{
				employee.setIsSuperwiser("M");
				
			}
			
			logger.log(Level.INFO,
			        "Start Createing default assignment for employee");
			MA_Assignment assignment = new MA_Assignment();
			Calendar cal = Calendar.getInstance();
			Date assstartDate = DateUtil.clearTimePart(cal.getTime());
			
			/**
			 * The default assignment end date is 90 days.
			 * 
			 * TODO : Need to move it to Rule Engine
			 */
			
			cal.add(Calendar.DAY_OF_MONTH, 90);
			assignment.setStartDate(assstartDate);
			assignment.setEndDate(DateUtil.clearTimePart(cal.getTime()));
			assignment.setStatus(IMobileAttendanceConstants.DEFAULT_ASSIGNMENT);
			
			logger.log(Level.INFO,
			        "End Createing default assignment for employee");
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			Key k = AbstractEntityDAO.addModel(employee);
			
			if (employee.getIsSuperwiser() != null)
			{
				if (employee.getIsSuperwiser().equalsIgnoreCase("Y"))
				{
					user.getEmployeeRef().setKey(k);
					AbstractEntityDAO.addModel(user);
				}
			}
			
			assignment.getEmployeeRef().setKey(k);
			Key asskey = AbstractEntityDAO.addModel(assignment);
			gtx.commit();
			
			logger.log(Level.INFO, "Employee Key=" + k.getId());
			logger.log(Level.INFO, "Assignemnt  Key=" + asskey.getId());
			status = _empCompanyEmpId;// (companyId +"-" + k.getId()).trim();
			
		}
		logger.log(Level.INFO, "createEmployee Status-" + status);
		return status;
		
	}
	
	public List<EmployeeDTO> getAllEmployeeOfCompany(long companyId)
	{
		logger.log(Level.INFO, "start getAllEmployeeOfCompany ");
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
		
		List<MA_Employee> employees = entityService
		        .getAllEmployeeForCompany(companyId);
		
		Iterator<MA_Employee> itr = employees.iterator();
		
		while (itr.hasNext())
		{
			MA_Employee employee = itr.next();
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(employee.getKey().getId());
			employeeDTO.setName(employee.getFirstName() + " "
			        + employee.getLastName());
			employeeDTO.setCompanyEmployeeId(employee.getCompanyEmpId());
			String city = employee.getCity() == null ? "-" : employee.getCity();
			employeeDTO.setCity(city);
			employeeDTO.setCompanyId(employee.getCompanyRef().getKey().getId());
			String superVisor = employee.getIsSuperwiser();
			
			if (null == superVisor)
			{
				superVisor = "N";
			}
			
			employeeDTO.setIsSupervisor(superVisor);
			
			if (employee.getEmployeeType().trim().equals("1"))
			{
				employeeDTO.setEmployeeType("Permanent");
			} else if (employee.getEmployeeType().trim().equals("2"))
			{
				employeeDTO.setEmployeeType("Contractor");
			} else if (employee.getEmployeeType().trim().equals("3"))
			{
				employeeDTO.setEmployeeType("Individual Contractor");
			}
			
			if (null != employee.getActive())
			{
				employeeDTO.setIsActive(employee.getActive());
			} else
			{
				/*
				 * previously present code; employeeDTO.setIsActive("Y");
				 */
				employeeDTO.setIsActive("N");
			}
			
			employeeList.add(employeeDTO);
		}
		logger.log(Level.INFO, "end getAllEmployeeOfCompany size"
		        + employeeList.size());
		return employeeList;
		
	}
	
	/**
	 * 
	 */
	public MA_Employee getEmployeeObject(long companyId, String _empCompanyEmpId)
	{
		MA_Company company = new MA_Company();
		Key companyKey = AbstractEntityDAO.createKey(company, companyId);
		MA_Employee employee = new MA_Employee();
		MA_EmployeeMeta employeeMeta = MA_EmployeeMeta.get();
		employee = Datastore
		        .query(employeeMeta)
		        .filter(employeeMeta.companyRef.equal(companyKey),
		                employeeMeta.companyEmpId.equal(_empCompanyEmpId))
		        .asSingle();
		
		return employee;
	}
	
	/**
	 * 
	 */
	
	public boolean isEmployeeExists(long companyId, String _empCompanyEmpId)
	{
		boolean flag = false;
		MA_Employee employee = getEmployeeObject(companyId, _empCompanyEmpId);
		
		if (employee != null)
		{
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * 
	 * @param _empCompanyEmpId
	 * @return
	 */
	public MA_Employee getEmployeeObject(String _empCompanyEmpId)
	{
		String _companyId = _empCompanyEmpId.substring(0,
		        _empCompanyEmpId.indexOf("-"));
		
		return getEmployeeObject(Long.parseLong(_companyId), _empCompanyEmpId);
	}
	
	/**
	 * 
	 */
	public String updateEmployee(Map<String, Object> input,
	        String[] dayOfWeeklyOff)
	{
		logger.log(Level.INFO, "Start updateEmployee");
		String status = "failure";
		MA_Company company = new MA_Company();
		String employeeType = (String) input.get("employeeType");
		Long companyId = Long.valueOf((String) input.get("companyId"));
		
		// if (employeeType.equals("2"))
		// {
		// companyId = Long.valueOf((String) input.get("contractorCompany"));
		// } else
		// {
		// companyId = (Long) input.get("companyId");
		// }
		
		logger.log(Level.INFO, "companyId=" + companyId);
		
		Key k1 = AbstractEntityDAO.createKey(company, companyId);
		company.setKey(k1);
		
		MA_EmployeeMeta employeeMeta = MA_EmployeeMeta.get();
		String _empCompanyEmpId = (String) input.get("companyEmpId");
		MA_Employee employee = Datastore
		        .query(employeeMeta)
		        .filter(employeeMeta.companyRef.equal(k1),
		                employeeMeta.companyEmpId.equal(_empCompanyEmpId))
		        .asSingle();
		
		logger.log(Level.INFO, "employee=" + employee);
		String isSupervisor = (String) input.get("isSuperwiser");
		MA_User user = null;
		MA_UserMeta userMeta = new MA_UserMeta();
		user = Datastore.query(userMeta)
		        .filter(userMeta.userName.equal(employee.getCompanyEmpId()))
		        .asSingle();
		
		// The user will be null for a non-supervisor
		
		// Check whether employee is supervisor or not.
		logger.log(Level.INFO, "isSupervisor=" + isSupervisor);
		if (null != isSupervisor)
		{
			logger.log(Level.INFO,
			        "employee.getIsSuperwiser()=" + employee.getIsSuperwiser());
			if (employee.getIsSuperwiser() != null)
			{
				
				// The new role is different from previous
				
				if (!employee.getIsSuperwiser().equalsIgnoreCase(isSupervisor))
				{
					if (isSupervisor.equals("Y"))
					{
						MA_UserProfile userProfile = UserDAO.newInstance()
						        .getUserProfile("SUP");
						if (null == user)
						{
							user = new MA_User();
						}
						user.getUserProfileRef().setModel(userProfile);
						user.setUserName(_empCompanyEmpId);
						
						user.getCompanyRef().setModel(company);
						user.setImeiCode((String) input.get("imeiCode"));
						user.getEmployeeRef().setKey(employee.getKey());
						employee.setImeiCode((String) input.get("imeiCode"));
						
					} else if (input.get("isManager").equals("M"))
					{
						employee.setIsSuperwiser("M");
						input.put("isSuperwiser", "M");
						
					}
					
				} else
				{
					if (employee.getIsSuperwiser().equalsIgnoreCase("Y"))
					{
						user.setImeiCode((String) input.get("imeiCode"));
					}
				}
			}
			// TODO: This block may not get executed
			else
			{
				if (isSupervisor.equals("Y"))
				{
					MA_UserProfile userProfile = UserDAO.newInstance()
					        .getUserProfile("SUP");
					user = new MA_User();
					user.getUserProfileRef().setModel(userProfile);
					user.setUserName(_empCompanyEmpId);
					user.getCompanyRef().setModel(company);
					user.setImeiCode((String) input.get("imeiCode"));
					user.getEmployeeRef().setKey(employee.getKey());
				} else if (input.get("isManager").equals("M"))
				{
					employee.setIsSuperwiser("M");
					input.put("isSuperwiser", "M");
					user.setImeiCode(null);
					employee.setImeiCode(null);
				}
			}
			
		} else if (input.get("isManager").equals("Y"))
		{
			employee.setIsSuperwiser("M");
			input.put("isSuperwiser", "M");
			
		}
		
		MA_TemplateSkill skill = new MA_TemplateSkill();
		
		String startDate = (String) input.get("startDate");
		Date stDate = DateUtil.toDate(startDate, "MM/dd/yyyy");
		
		String active = (String) input.get("active");
		logger.log(Level.INFO, "active=" + active);
		if (null != active)
		{
			// System.out.println("Make employee inactive  " + active);
			employee.setActive(active);
			employee.setInActiveDate(new Date());
		}
		input.put("startDate", stDate);
		
		employee.setStartDate(stDate);
		BeanUtil.copy(input, employee);
		
		employee.getCompanyRef().setModel(company);
		employee.setCompanyEmpId(_empCompanyEmpId);
		String weeklyOffStr = "";
		if (null != dayOfWeeklyOff)
		{
			for (int cnt = 0; cnt < dayOfWeeklyOff.length; cnt++)
			{
				if (!weeklyOffStr.equals(""))
				{
					weeklyOffStr = weeklyOffStr + ",";
				}
				weeklyOffStr = weeklyOffStr + dayOfWeeklyOff[cnt];
			}
		}
		
		logger.log(Level.INFO, "weeklyOffStr=" + weeklyOffStr);
		employee.setDayOfWeeklyOff(weeklyOffStr);
		
		String skillId = (String) input.get("skill");
		logger.log(Level.INFO, "skillId=" + skillId);
		Key k3 = Datastore.createKey(MA_TemplateSkill.class,
		        Long.parseLong(skillId));
		skill.setKey(k3);
		employee.getSkillRef().setModel(skill);
		
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		Key k = AbstractEntityDAO.addModel(employee);
		
		if (null != user)
		{
			AbstractEntityDAO.addModel(user);
		}
		
		gtx.commit();
		status = ("" + k.getId()).trim();
		logger.log(Level.INFO, "updateEmployee Status-" + status);
		
		return status;
		
	}
	
	public List<MA_Employee> searchEmployee(Long companyId,
	        String employeeType, String firstName, String lastName,
	        String startDate, String companyEmpId, String city)
	{
		
		logger.log(Level.INFO, "Start searchEmployee");
		ArrayList<MA_Employee> masterList = new ArrayList<MA_Employee>();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		MA_EmployeeMeta employeeMeta = MA_EmployeeMeta.get();
		
		Date stDate = DateUtil.toDate(startDate, "MM/dd/yyyy");
		
		logger.log(Level.INFO, "employeeType=" + employeeType);
		
		if (null != employeeType)
		{
			
			if (employeeType.equals("1"))
			{
				
				ModelQuery<MA_Employee> query = Datastore
				        .query(MA_Employee.class);
				List<MA_Employee> filteredEmployeeList = new ArrayList<MA_Employee>();
				query.filter(employeeMeta.companyRef.equal(k),
				
				employeeMeta.active.equal("Y"),
				
				employeeMeta.companyEmpId.notEqual(null));
				
				if (companyEmpId != null && !companyEmpId.trim().equals(""))
				{
					query.filterInMemory(employeeMeta.companyEmpId
					        .equal(companyEmpId));
				}
				if (firstName != null && !firstName.trim().equals(""))
				{
					logger.log(Level.INFO, "firstName=" + firstName);
					query.filterInMemory(employeeMeta.firstName
					        .startsWith(firstName));
					
				}
				
				if (lastName != null && !lastName.trim().equals(""))
				{
					query.filterInMemory(employeeMeta.lastName
					        .startsWith(lastName));
				}
				if (stDate != null)
				{
					query.filterInMemory(employeeMeta.startDate
					        .greaterThanOrEqual(stDate));
				}
				if (city != null)
				{
					query.filterInMemory(employeeMeta.city.equal(city));
				}
				
				filteredEmployeeList = query.asList();
				
				logger.log(Level.INFO, "filteredEmployeeList size="
				        + filteredEmployeeList);
				
				masterList.addAll(filteredEmployeeList);
				
			} else if (employeeType.equals("2"))
			{
				
				MA_ContractorCompanyMeta _c = new MA_ContractorCompanyMeta();
				List<MA_ContractorCompany> _contractingCompanyList = Datastore
				        .query(_c).filter(_c.companyRef.equal(k)).asList();
				
				for (Iterator<MA_ContractorCompany> iterator = _contractingCompanyList
				        .iterator(); iterator.hasNext();)
				{
					MA_ContractorCompany ma_ContractorCompany = (MA_ContractorCompany) iterator
					        .next();
					
					ModelQuery<MA_Employee> query = Datastore
					        .query(MA_Employee.class);
					List<MA_Employee> filteredEmployeeList = new ArrayList<MA_Employee>();
					query.filter(employeeMeta.companyRef
					        .equal(ma_ContractorCompany.getKey()),
					        employeeMeta.active.equal("Y"),
					        employeeMeta.companyEmpId.notEqual(null));
					
					if (companyEmpId != null && !companyEmpId.trim().equals(""))
					{
						query.filterInMemory(employeeMeta.companyEmpId
						        .equal(companyEmpId));
					}
					if (firstName != null && !firstName.trim().equals(""))
					{
						logger.log(Level.INFO, "firstName=" + firstName);
						query.filterInMemory(employeeMeta.firstName
						        .startsWith(firstName));
						
					}
					
					if (lastName != null && !lastName.trim().equals(""))
					{
						query.filterInMemory(employeeMeta.lastName
						        .startsWith(lastName));
					}
					if (stDate != null)
					{
						query.filterInMemory(employeeMeta.startDate
						        .greaterThanOrEqual(stDate));
					}
					if (city != null)
					{
						query.filterInMemory(employeeMeta.city.equal(city));
					}
					filteredEmployeeList = query.asList();
					
					masterList.addAll(filteredEmployeeList);
				}
				
			} else
			{
				
				ModelQuery<MA_Employee> query1 = Datastore
				        .query(MA_Employee.class);
				List<MA_Employee> filteredEmployeeList = new ArrayList<MA_Employee>();
				query1.filter(employeeMeta.companyRef.equal(k),
				        employeeMeta.companyEmpId.notEqual(null));
				
				if (companyEmpId != null && !companyEmpId.trim().equals(""))
				{
					query1.filterInMemory(employeeMeta.companyEmpId
					        .equal(companyEmpId));
				}
				if (firstName != null && !firstName.trim().equals(""))
				{
					logger.log(Level.INFO, "firstName=" + firstName);
					query1.filterInMemory(employeeMeta.firstName
					        .startsWith(firstName));
					
				}
				
				if (lastName != null && !lastName.trim().equals(""))
				{
					query1.filterInMemory(employeeMeta.lastName
					        .startsWith(lastName));
				}
				if (stDate != null)
				{
					query1.filterInMemory(employeeMeta.startDate
					        .greaterThanOrEqual(stDate));
				}
				if (city != null)
				{
					query1.filterInMemory(employeeMeta.city.equal(city));
				}
				filteredEmployeeList = query1.asList();
				
				logger.log(Level.INFO, "filteredEmployeeList size="
				        + filteredEmployeeList.size());
				masterList.addAll(filteredEmployeeList);
				
				MA_ContractorCompanyMeta _c = new MA_ContractorCompanyMeta();
				List<MA_ContractorCompany> _contractingCompanyList = Datastore
				        .query(_c).filter(_c.companyRef.equal(k)).asList();
				
				for (Iterator<MA_ContractorCompany> iterator = _contractingCompanyList
				        .iterator(); iterator.hasNext();)
				{
					MA_ContractorCompany ma_ContractorCompany = (MA_ContractorCompany) iterator
					        .next();
					
					ModelQuery<MA_Employee> query2 = Datastore
					        .query(MA_Employee.class);
					List<MA_Employee> filteredEmployeeList2 = new ArrayList<MA_Employee>();
					query2.filter(employeeMeta.companyRef
					        .equal(ma_ContractorCompany.getKey()));
					
					if (companyEmpId != null && !companyEmpId.trim().equals(""))
					{
						query2.filterInMemory(employeeMeta.companyEmpId
						        .equal(companyEmpId));
					}
					if (firstName != null && !firstName.trim().equals(""))
					{
						logger.log(Level.INFO, "firstName=" + firstName);
						query2.filterInMemory(employeeMeta.firstName
						        .startsWith(firstName));
						
					}
					
					if (lastName != null && !lastName.trim().equals(""))
					{
						query2.filterInMemory(employeeMeta.lastName
						        .startsWith(lastName));
					}
					if (stDate != null)
					{
						query2.filterInMemory(employeeMeta.startDate
						        .greaterThanOrEqual(stDate));
					}
					if (city != null)
					{
						query2.filterInMemory(employeeMeta.city.equal(city));
					}
					filteredEmployeeList2 = query2.asList();
					
					masterList.addAll(filteredEmployeeList2);
				}
				
			}
			
		}
		
		List<MA_Employee> inactiveEmployeeList = new ArrayList<MA_Employee>();
		Iterator<MA_Employee> itr = masterList.iterator();
		while (itr.hasNext())
		{
			MA_Employee employee = itr.next();
			if ("N".equals(employee.getActive()) | employee.getActive() == null)
			{
				inactiveEmployeeList.add(employee);
			}
		}
		masterList.removeAll(inactiveEmployeeList);
		return masterList;
	}
	
	/**
	 * IMEI code has be a unique for a mobile and for a company. Since same
	 * mobile can be used for multiple users in same company.
	 * 
	 * The combination of userid and imei code should be unique.
	 * 
	 * @return
	 */
	public static boolean isIMEICodeUnique(String userName, String imeiCode)
	{
		return true;
	}
	
	@Override
	public String inActivateEmployee(List<MA_Employee> employees)
	{
		String status = "failure";
		logger.log(Level.INFO, "Start inactivateEmployee");
		Iterator<MA_Employee> itr = employees.iterator();
		ArrayList<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
		while (itr.hasNext())
		{
			Date endDate = new Date();
			
			MA_Employee employee = itr.next();
			employee.setActive("N");
			employee.setInActiveDate(endDate);
			entityList.add(employee);
			
		}
		
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		List<Key> k = AbstractEntityDAO.addModels(entityList);
		
		gtx.commit();
		
		Iterator<Key> it = k.iterator();
		while (it.hasNext())
		{
			status = ("" + it.next().getId()).trim();
			logger.log(Level.INFO, "updateEmployee Status-" + status);
		}
		return status;
	}
	
	/**
	 * 
	 * @param companyId
	 * @param currentDate
	 * @return
	 */
	public List<MA_Employee> getAllActiveEmployeeForCompany(Long companyId,
	        Calendar currentDate)
	{
		MA_EmployeeMeta e = new MA_EmployeeMeta();
		ArrayList<MA_Employee> masterList = new ArrayList<MA_Employee>();
		
		Key k = Datastore.createKey(MA_Company.class, companyId);
		
		// Get Direct Emplyoees, except the emplyoees who are controlling the
		// ops
		List<MA_Employee> _active_employee_list = Datastore.query(e)
		        .filter(e.companyRef.equal(k), e.active.equal("Y")).asList();
		masterList.addAll(_active_employee_list);
		List<MA_Employee> employee_list = Datastore
		        .query(e)
		        .filter(e.companyRef.equal(k),
		                e.inActiveDate.greaterThan(currentDate.getTime()))
		        .asList();
		
		// Get Contractors
		MA_ContractorCompanyMeta _c = new MA_ContractorCompanyMeta();
		List<MA_ContractorCompany> _contractingCompanyList = Datastore
		        .query(_c).filter(_c.companyRef.equal(k)).asList();
		
		for (Iterator<MA_ContractorCompany> iterator = _contractingCompanyList
		        .iterator(); iterator.hasNext();)
		{
			MA_ContractorCompany ma_ContractorCompany = (MA_ContractorCompany) iterator
			        .next();
			
			// Get All active employees
			List<MA_Employee> _active_contractor_employee_list = Datastore
			        .query(e)
			        .filter(e.companyRef.equal(ma_ContractorCompany.getKey()),
			                e.active.equal("Y")).asList();
			
			masterList.addAll(_active_contractor_employee_list);
			
			List<MA_Employee> _inactive_employee_list = Datastore
			        .query(e)
			        .filter(e.companyRef.equal(ma_ContractorCompany.getKey()),
			                e.active.equal("N"),
			                e.inActiveDate.greaterThan(currentDate.getTime()))
			        .asList();
			
			masterList.addAll(_inactive_employee_list);
			
		}
		
		masterList.addAll(employee_list);
		
		// readCounter += employee_list.size();
		
		return masterList;
		
	}
	
	@Override
	public List<String> getUniqueCityNames(Long companyId)
	{
		EntityService service = EntityService.getInstance();
		
		List<MA_Location> locations = service
		        .getAllActiveLocationForCompany(companyId);
		
		Set<String> cities = new HashSet<String>();
		
		Iterator<MA_Location> itr = locations.iterator();
		
		while (itr.hasNext())
		{
			MA_Location location = itr.next();
			String city = location.getAddressRef().getModel().getCity();
			city = city.substring(0, 1).toUpperCase()
			        + (city.length() > 1 ? city.substring(1).toLowerCase() : "");
			cities.add(city);
		}
		
		List<String> cityList = new ArrayList<String>(cities);
		return cityList;
	}
	
	public List<MA_Employee> getManagerList(long companyId)
	{
		
		Key Key = Datastore.createKey(MA_Company.class, companyId);
		MA_EmployeeMeta e = new MA_EmployeeMeta();
		List<MA_Employee> managers = Datastore.query(e)
		        .filter(e.companyRef.equal(Key), e.isSuperwiser.equal("M"))
		        .asList();
		return managers;
	}
	
	@Override
	public boolean isManagerEmailIdUnique(long companyId, String emailId,
	        String companyEmpId)
	{
		boolean flag = false;
		Key k = Datastore.createKey(MA_Company.class, companyId);
		MA_EmployeeMeta e = new MA_EmployeeMeta();
		List<MA_Employee> managerList = Datastore
		        .query(e)
		        .filter(e.companyRef.equal(k),
		                e.companyEmpId.notEqual(companyEmpId),
		                e.isSuperwiser.equal("M")).asList();
		
		for (MA_Employee manager : managerList)
		{
			if (manager.getEmailId().equalsIgnoreCase(emailId))
			{
				flag = true;
			}
			
		}
		
		return flag;
		
	}
	
}
