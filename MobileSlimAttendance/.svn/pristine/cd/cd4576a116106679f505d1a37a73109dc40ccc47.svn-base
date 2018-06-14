/**
 * 
 */
package com.adviteya.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.meta.MA_TemplateMeta;
import com.adviteya.meta.MA_TimeSheetRuleMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Template;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.persistence.AbstractEntityDAO;
import com.google.appengine.api.datastore.Key;

/**
 * @author shweta
 * 
 */
public class CompanyBusinessService implements ICompanyBusinessService,
        IMobileAttendanceConstants
{
	
	private UserBusinessService businessService = new UserBusinessService();
	private EntityService       entityService   = EntityService.getInstance();
	private static Logger       logger          = Logger.getLogger(CompanyBusinessService.class
	                                                    .getName());
	
	public String createCompanyDetails(Map<String, Object> input)
	{
		logger.log(Level.INFO, "Start createCompanyDetails");
		String status = "failure";
		String isManager = (String) input.get("isManager");
		Long emplyoeePopulation = Long.parseLong((String) input
		        .get("emplyoeePopulation"));
		String uniqueidFlag = (String) input.get("uniqueidFlag");
		
		Long companyId = (Long) input.get("companyId");
		
		Key k1 = Datastore.createKey(MA_Company.class, (companyId));
		MA_Company company = entityService.getCompanyObj(k1);
		company.setEmplyoeePopulation(emplyoeePopulation);
		logger.log(Level.INFO, "uniqueidFlag = " + uniqueidFlag);
		company.setUniqueidFlag(uniqueidFlag);
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		
		String templateId = (String) input.get("template");
		Key k3 = Datastore.createKey(MA_Template.class,
		        Long.parseLong(templateId));
		MA_TemplateMeta templateMeta = MA_TemplateMeta.get();
		MA_Template template = Datastore.query(templateMeta)
		        .filter(templateMeta.key.equal(k3)).asSingle();
		
		company.getTemplateRef().setModel(template);
		
		logger.log(Level.INFO, "Template = " + template.getTemplateName());
		
		// TODO : Temp Fix to fix the TimeZone at Company level
		
		TimeZone _tz = TimeZone.getDefault();
		company.setTimeZone(_tz.getDisplayName());
		
		ArrayList<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
		entityList.add(company);
		AbstractEntityDAO.setGtx(gtx);
		List<MA_TimeSheetRule> timeSheetRules = getDefaultTimeSheetRuleConfiguration(company);
		entityList.addAll(timeSheetRules);
		// entityList.add(user);
		AbstractEntityDAO.addModels(entityList);
		gtx.commit();
		status = "success";
		
		logger.log(Level.INFO, "End  createCompanyDetails  status = " + status);
		
		return status;
	}
	
	/**
	 * This method will copy all the default roles and create a copy of the new
	 * company
	 * 
	 * @param company
	 * @return
	 */
	public List<MA_TimeSheetRule> getDefaultTimeSheetRuleConfiguration(
	        MA_Company company)
	{
		
		com.adviteya.meta.MA_TimeSheetRuleMeta timeSheetMeta = new com.adviteya.meta.MA_TimeSheetRuleMeta();
		Key k = Datastore.createKey(MA_Company.class, Long.parseLong("-1"));
		
		List<MA_TimeSheetRule> timeSheetRules = Datastore.query(timeSheetMeta)
		        .filter(timeSheetMeta.companyRef.equal(k)).asList();
		ArrayList<MA_TimeSheetRule> tsheetRuleList = new ArrayList<MA_TimeSheetRule>();
		
		for (Iterator iterator = timeSheetRules.iterator(); iterator.hasNext();)
		{
			MA_TimeSheetRule _defaultTimesheetRule = (MA_TimeSheetRule) iterator
			        .next();
			_defaultTimesheetRule.setKey(null);
			_defaultTimesheetRule.getCompanyRef().setModel(company);
			tsheetRuleList.add(_defaultTimesheetRule);
		}
		
		return tsheetRuleList;
	}
	
	/**
	 * This is a hard coded default company.
	 * 
	 * @deprecated
	 * @param company
	 * @return
	 */
	private List<MA_TimeSheetRule> getTimeSheetRuleConfiguration(
	        MA_Company company)
	{
		
		List<MA_TimeSheetRule> timeSheetRules = new ArrayList<MA_TimeSheetRule>();
		
		// RULE # 1 a. Min # of working hrs for full pay
		MA_TimeSheetRule minDailyEffortRule = new MA_TimeSheetRule();
		minDailyEffortRule
		        .setRuleKey(IMobileAttendanceConstants.MIN_DAILY_EFFORTS);
		minDailyEffortRule.setValue(28800L);
		minDailyEffortRule.getCompanyRef().setModel(company);
		timeSheetRules.add(minDailyEffortRule);
		
		// RULE # 2 c. Max # of working hrs
		MA_TimeSheetRule maxDailyEffortRule = new MA_TimeSheetRule();
		maxDailyEffortRule
		        .setRuleKey(IMobileAttendanceConstants.MAX_DAILY_EFFORTS);
		maxDailyEffortRule.setValue(39600L);
		maxDailyEffortRule.getCompanyRef().setModel(company);
		timeSheetRules.add(maxDailyEffortRule);
		
		// RULE # 3
		MA_TimeSheetRule lateMarkToleranceRule = new MA_TimeSheetRule();
		lateMarkToleranceRule
		        .setRuleKey(IMobileAttendanceConstants.LATE_MRK_TOLERANCE);
		lateMarkToleranceRule.setValue(900L);
		lateMarkToleranceRule.getCompanyRef().setModel(company);
		timeSheetRules.add(lateMarkToleranceRule);
		
		// RULE # 4
		MA_TimeSheetRule earlyleftToleranceRule = new MA_TimeSheetRule();
		earlyleftToleranceRule
		        .setRuleKey(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE);
		earlyleftToleranceRule.setValue(900L);
		timeSheetRules.add(earlyleftToleranceRule);
		
		// RULE # 5
		MA_TimeSheetRule halfDayRule = new MA_TimeSheetRule();
		halfDayRule.setRuleKey(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS);
		halfDayRule.setValue(14400L);
		halfDayRule.getCompanyRef().setModel(company);
		timeSheetRules.add(halfDayRule);
		
		// RULE # 6 b. Min # of continuous working hrs for half day
		MA_TimeSheetRule halfDayContineousRule = new MA_TimeSheetRule();
		halfDayContineousRule
		        .setRuleKey(IMobileAttendanceConstants.MIN_HALF_CONTINUOUS_HRS);
		halfDayContineousRule.setValue(18000L);
		halfDayContineousRule.getCompanyRef().setModel(company);
		timeSheetRules.add(halfDayContineousRule);
		
		// RULE # 7
		MA_TimeSheetRule halfDayToleranceRule = new MA_TimeSheetRule();
		halfDayToleranceRule
		        .setRuleKey(IMobileAttendanceConstants.HALF_DAY_TOLERANCE);
		halfDayToleranceRule.setValue(900L);
		halfDayToleranceRule.getCompanyRef().setModel(company);
		timeSheetRules.add(halfDayToleranceRule);
		
		// RULE # 8 d. Min # of Hrs for overtime
		MA_TimeSheetRule overTimeRule = new MA_TimeSheetRule();
		overTimeRule
		        .setRuleKey(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS);
		overTimeRule.setValue(10800L);
		overTimeRule.getCompanyRef().setModel(company);
		timeSheetRules.add(overTimeRule);
		
		// RULE # 9
		MA_TimeSheetRule overTimeToleranceRule = new MA_TimeSheetRule();
		overTimeToleranceRule
		        .setRuleKey(IMobileAttendanceConstants.OVER_TIME_TOLERANCES);
		overTimeToleranceRule.setValue(900L);
		overTimeToleranceRule.getCompanyRef().setModel(company);
		timeSheetRules.add(overTimeToleranceRule);
		
		/*
		 * MA_TimeSheetRule weeklyOffEfforttTimeRule = new MA_TimeSheetRule();
		 * weeklyOffEfforttTimeRule
		 * .setRuleKey(IMobileAttendanceConstants.WEEKLY_OFF_EFFORTS);
		 * weeklyOffEfforttTimeRule.setValue(28800L);
		 * weeklyOffEfforttTimeRule.getCompanyRef().setModel(company);
		 * timeSheetRules.add(weeklyOffEfforttTimeRule);
		 * 
		 * MA_TimeSheetRule weeklyOffOvertTimeRule = new MA_TimeSheetRule();
		 * weeklyOffOvertTimeRule
		 * .setRuleKey(IMobileAttendanceConstants.WEEKLY_OFF_OVER_TIME_EFFORTS);
		 * weeklyOffOvertTimeRule.setValue(7200L);
		 * weeklyOffOvertTimeRule.getCompanyRef().setModel(company);
		 * timeSheetRules.add(weeklyOffOvertTimeRule);
		 */
		
		// RULE # 10
		MA_TimeSheetRule flexibleTimeRule = new MA_TimeSheetRule();
		flexibleTimeRule.setRuleKey(IMobileAttendanceConstants.FLEXIBEL_TIME);
		flexibleTimeRule.setValue(1L);
		flexibleTimeRule.getCompanyRef().setModel(company);
		timeSheetRules.add(flexibleTimeRule);
		
		// // RULE # 11
		MA_TimeSheetRule lunchBreakRule = new MA_TimeSheetRule();
		lunchBreakRule.setRuleKey(IMobileAttendanceConstants.LUNCH_BREAK);
		lunchBreakRule.setValue(2700L);
		lunchBreakRule.getCompanyRef().setModel(company);
		timeSheetRules.add(lunchBreakRule);
		
		// RULE # 12
		MA_TimeSheetRule teaBreakRule = new MA_TimeSheetRule();
		teaBreakRule.setRuleKey(IMobileAttendanceConstants.TEA_BREAK);
		teaBreakRule.setValue(900L);
		teaBreakRule.getCompanyRef().setModel(company);
		timeSheetRules.add(teaBreakRule);
		
		// RULE # 13
		MA_TimeSheetRule plannedAssignmentRule = new MA_TimeSheetRule();
		plannedAssignmentRule
		        .setRuleKey(IMobileAttendanceConstants.PLANNED_ASSIGNMENT);
		plannedAssignmentRule.setValue(1L);
		plannedAssignmentRule.getCompanyRef().setModel(company);
		timeSheetRules.add(plannedAssignmentRule);
		
		// RULE # 14
		MA_TimeSheetRule maxOverTimeRule = new MA_TimeSheetRule();
		maxOverTimeRule
		        .setRuleKey(IMobileAttendanceConstants.MAX_OVERTIME_PER_PAY_PERIOD);
		maxOverTimeRule.setValue(1L);
		maxOverTimeRule.getCompanyRef().setModel(company);
		timeSheetRules.add(maxOverTimeRule);
		
		// RULE # 15
		MA_TimeSheetRule earlyInTimeRule = new MA_TimeSheetRule();
		earlyInTimeRule
		        .setRuleKey(IMobileAttendanceConstants.EARLY_IN_TOLERANCE);
		earlyInTimeRule.setValue(900L);
		earlyInTimeRule.getCompanyRef().setModel(company);
		timeSheetRules.add(earlyInTimeRule);
		
		// RULE # 16
		MA_TimeSheetRule lateOutToleranceRule = new MA_TimeSheetRule();
		lateOutToleranceRule
		        .setRuleKey(IMobileAttendanceConstants.LATE_OUT_TOLERANCE);
		lateOutToleranceRule.setValue(900L);
		lateOutToleranceRule.getCompanyRef().setModel(company);
		timeSheetRules.add(lateOutToleranceRule);
		
		// RULE # 17
		MA_TimeSheetRule minDailyEffortToleranceRule = new MA_TimeSheetRule();
		minDailyEffortToleranceRule
		        .setRuleKey(IMobileAttendanceConstants.DAILY_EFFORT_TOLERANCE);
		minDailyEffortToleranceRule.setValue(900L);
		minDailyEffortToleranceRule.getCompanyRef().setModel(company);
		timeSheetRules.add(minDailyEffortToleranceRule);
		
		return timeSheetRules;
	}
	
	public void updateTimeshhetRules(List timesheetRules)
	{
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		AbstractEntityDAO.addModels(timesheetRules);
		gtx.commit();
	}
	
	public MA_Company getCompanyDetails(long companyId)
	{
		Key k1 = Datastore.createKey(MA_Company.class, (companyId));
		MA_Company company = entityService.getCompanyObj(k1);
		return company;
	}
	
	public String getDepartmentRuleOfCompany(long companyId)
	{
		
		String isDepartment = "N";
		MA_TimeSheetRuleMeta timeSheetRuleMeta = MA_TimeSheetRuleMeta.get();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		MA_TimeSheetRule departmentRule = Datastore
		        .query(timeSheetRuleMeta)
		        .filter(timeSheetRuleMeta.companyRef.equal(k),
		                timeSheetRuleMeta.ruleKey.equal("department_rule"))
		        .asSingle();
		logger.log(Level.INFO, "departmentRule=" + departmentRule);
		if (null != departmentRule)
		{
			long temp = departmentRule.getValue();
			logger.log(Level.INFO, "temp=" + temp);
			if (temp == 0)
			{
				isDepartment = "Y";
			}
		}
		logger.log(Level.INFO, "isDepartment=" + isDepartment);
		return isDepartment;
		
	}
	
	public String getUniqueIdRuleOfCompany(long companyId)
	{
		
		String uniqueIdFlag = "N";
		MA_TimeSheetRuleMeta timeSheetRuleMeta = MA_TimeSheetRuleMeta.get();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		MA_TimeSheetRule uniqueIdRule = Datastore
		        .query(timeSheetRuleMeta)
		        .filter(timeSheetRuleMeta.companyRef.equal(k),
		                timeSheetRuleMeta.ruleKey
		                        .equal("company_uniqueid_rule")).asSingle();
		logger.log(Level.INFO, "uniqueIdFlag=" + uniqueIdRule);
		if (null != uniqueIdRule)
		{
			long temp = uniqueIdRule.getValue();
			logger.log(Level.INFO, "temp=" + temp);
			if (temp == 0)
			{
				uniqueIdFlag = "Y";
			}
		}
		logger.log(Level.INFO, "uniqueIdFlag=" + uniqueIdFlag);
		return uniqueIdFlag;
		
	}
	
	public String getUniqueIdRuleOfContractorCompany(long companyId)
	{
		
		String uniqueIdFlag = "N";
		MA_TimeSheetRuleMeta timeSheetRuleMeta = MA_TimeSheetRuleMeta.get();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		MA_TimeSheetRule uniqueIdRule = Datastore
		        .query(timeSheetRuleMeta)
		        .filter(timeSheetRuleMeta.companyRef.equal(k),
		                timeSheetRuleMeta.ruleKey
		                        .equal("contractor_uniqueid_rule")).asSingle();
		logger.log(Level.INFO, "uniqueIdFlag=" + uniqueIdRule);
		if (null != uniqueIdRule)
		{
			long temp = uniqueIdRule.getValue();
			logger.log(Level.INFO, "temp=" + temp);
			if (temp == 0)
			{
				uniqueIdFlag = "Y";
			}
		}
		logger.log(Level.INFO, "uniqueIdFlag=" + uniqueIdFlag);
		return uniqueIdFlag;
		
	}
	
	public boolean isAccountVerified(long companyId)
	{
		Key k1 = Datastore.createKey(MA_Company.class, companyId);
		MA_Company company = entityService.getCompanyObj(k1);
		company.setKey(k1);
		boolean accountVerified = company.isAccountVerified();
		return accountVerified;
		
	}
	
}
