package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.service.CompanyBusinessService;
import com.adviteya.service.EntityService;
import com.adviteya.service.ICompanyBusinessService;
import com.adviteya.service.ITimeSheetBusinessService;
import com.adviteya.service.TimeSheetBusinessService;
import com.google.appengine.api.datastore.Key;

public class ConfigureTimeSheetRuleController extends BaseController
{
	
	private EntityService             service                = EntityService
	                                                                 .getInstance();
	private ITimeSheetBusinessService businessService        = new TimeSheetBusinessService();
	private ICompanyBusinessService   companybusinessService = new CompanyBusinessService();
	private static Logger             logger                 = Logger.getLogger(ConfigureTimeSheetRuleController.class
	                                                                 .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		pageTitle = "title.configureRule";
		pageHeader = "page.configureRule";
		
		String action = requestScope("actionParam");
		String processDay = requestScope("process_month");
		Long companyId = sessionScope("companyId");
		
		if (action == null)
		{
			getTimesheetRules(companyId);
			return forward("configureTimeSheetRule.jsp");
			
		} else if (action.equalsIgnoreCase("configure"))
		{
			Validators v = new Validators(request);
			if (validate(v))
			{
				
				companybusinessService
				        .updateTimeshhetRules(setTimesheetRules(companyId));
				int day = Integer.parseInt(processDay);
				if (day >= 29)
				{
					requestScope("processDay", "show");
				}
				requestScope("actionParam", "logout");
			} else
			{
				showErrBox = true;
			}
		} else
		{
			sessionScope("currentUser", null);
			HttpSession session = request.getSession();
			session.invalidate();
			
			return forward("index.jsp");
		}
		return forward("configureTimeSheetRule.jsp");
	}
	
	/**
	 * 
	 * @param companyId
	 */
	private void getTimesheetRules(Long companyId)
	{
		List<MA_TimeSheetRule> timeSheetRules = businessService
		        .getTimesheetRulesOfCompany(companyId);
		
		logger.log(Level.INFO, "Comnay Id=" + companyId
		        + "        timeSheetRules size=" + timeSheetRules.size());
		MA_TimeSheetRule timsheetRule = new MA_TimeSheetRule();
		// Rule # 1
		timsheetRule.setRuleKey(IMobileAttendanceConstants.MIN_DAILY_EFFORTS);
		MA_TimeSheetRule minDailyEffortRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.MIN_DAILY_EFFORTS,
		        minDailyEffortRule.getValue());
		
		// Rule # 2
		timsheetRule.setRuleKey(IMobileAttendanceConstants.MAX_DAILY_EFFORTS);
		
		MA_TimeSheetRule maxDailyEffortRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.MAX_DAILY_EFFORTS,
		        maxDailyEffortRule.getValue());
		
		// Rule # 3
		timsheetRule.setRuleKey(IMobileAttendanceConstants.LATE_MRK_TOLERANCE);
		MA_TimeSheetRule lateMarkToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.LATE_MRK_TOLERANCE,
		        lateMarkToleranceRule.getValue());
		
		// Rule # 4
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE);
		MA_TimeSheetRule earlyleftToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE,
		        earlyleftToleranceRule.getValue());
		
		// Rule # 5
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS);
		MA_TimeSheetRule halfDayRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS,
		        halfDayRule.getValue());
		
		// Rule # 6
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.MIN_HALF_CONTINUOUS_HRS);
		
		MA_TimeSheetRule halfDayContineousRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.MIN_HALF_CONTINUOUS_HRS,
		        halfDayContineousRule.getValue());
		
		// Rule # 7
		timsheetRule.setRuleKey(IMobileAttendanceConstants.HALF_DAY_TOLERANCE);
		MA_TimeSheetRule halfDayToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.HALF_DAY_TOLERANCE,
		        halfDayToleranceRule.getValue());
		// Rule # 8
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS);
		MA_TimeSheetRule overTimeRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS,
		        overTimeRule.getValue());
		
		// RULE # 9
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.OVER_TIME_TOLERANCES);
		MA_TimeSheetRule overTimeToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.OVER_TIME_TOLERANCES,
		        overTimeToleranceRule.getValue());
		
		// Rule # 10
		timsheetRule.setRuleKey(IMobileAttendanceConstants.FLEXIBEL_TIME);
		MA_TimeSheetRule flexibleTimeRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.FLEXIBEL_TIME,
		        flexibleTimeRule.getValue());
		
		// RULE # 11
		timsheetRule.setRuleKey(IMobileAttendanceConstants.LUNCH_BREAK);
		MA_TimeSheetRule lunchBreakRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.LUNCH_BREAK,
		        lunchBreakRule.getValue());
		
		// RULE # 12
		timsheetRule.setRuleKey(IMobileAttendanceConstants.TEA_BREAK);
		MA_TimeSheetRule teaBreakRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.TEA_BREAK,
		        teaBreakRule.getValue());
		
		// RULE # 13
		timsheetRule.setRuleKey(IMobileAttendanceConstants.PLANNED_ASSIGNMENT);
		MA_TimeSheetRule plannedAssignmentRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.PLANNED_ASSIGNMENT,
		        plannedAssignmentRule.getValue());
		
		// RULE # 14
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.MAX_OVERTIME_PER_PAY_PERIOD);
		MA_TimeSheetRule maxOverTimeRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.MAX_OVERTIME_PER_PAY_PERIOD,
		        maxOverTimeRule.getValue());
		
		// RULE # 15
		timsheetRule.setRuleKey(IMobileAttendanceConstants.EARLY_IN_TOLERANCE);
		MA_TimeSheetRule earlyInTolerranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.EARLY_IN_TOLERANCE,
		        earlyInTolerranceRule.getValue());
		
		// RULE # 16
		timsheetRule.setRuleKey(IMobileAttendanceConstants.LATE_OUT_TOLERANCE);
		MA_TimeSheetRule lateOutToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.LATE_OUT_TOLERANCE,
		        lateOutToleranceRule.getValue());
		
		// RULE # 17
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.DAILY_EFFORT_TOLERANCE);
		MA_TimeSheetRule dailyEffortToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		requestScope(IMobileAttendanceConstants.DAILY_EFFORT_TOLERANCE,
		        dailyEffortToleranceRule.getValue());
		
		// RULE # 18
		timsheetRule.setRuleKey(IMobileAttendanceConstants.BILLING_RULE);
		if (timeSheetRules.indexOf(timsheetRule) != -1)
		{
			
			MA_TimeSheetRule billingRule = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
			requestScope(IMobileAttendanceConstants.BILLING_RULE,
			        billingRule.getValue());
		}
		
		// RULE # 19
		timsheetRule.setRuleKey(IMobileAttendanceConstants.DEPARTMENT_RULE);
		if (timeSheetRules.indexOf(timsheetRule) != -1)
		{
			
			MA_TimeSheetRule departmentRule = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
			requestScope(IMobileAttendanceConstants.DEPARTMENT_RULE,
			        departmentRule.getValue());
		}
		
		// RULE # 20
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.COMPANY_UNIQUEID_RULE);
		if (timeSheetRules.indexOf(timsheetRule) != -1)
		{
			
			MA_TimeSheetRule companyUniqueIdRule = timeSheetRules
			        .get(timeSheetRules.indexOf(timsheetRule));
			requestScope(IMobileAttendanceConstants.COMPANY_UNIQUEID_RULE,
			        companyUniqueIdRule.getValue());
			logger.log(Level.INFO, "companyUniqueIdRule.getValue() ="
			        + companyUniqueIdRule.getValue());
		}
		
		// RULE # 21
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.CONTRACTOR_UNIQUEID_RULE);
		if (timeSheetRules.indexOf(timsheetRule) != -1)
		{
			
			MA_TimeSheetRule contractorUniqueIdRule = timeSheetRules
			        .get(timeSheetRules.indexOf(timsheetRule));
			requestScope(IMobileAttendanceConstants.CONTRACTOR_UNIQUEID_RULE,
			        contractorUniqueIdRule.getValue());
			logger.log(Level.INFO, "contractorUniqueIdRule.getValue() ="
			        + contractorUniqueIdRule.getValue());
		}
		
		// RULE # 22
		timsheetRule.setRuleKey(IMobileAttendanceConstants.PROCESS_DAY);
		if (timeSheetRules.indexOf(timsheetRule) != -1)
		{
			
			MA_TimeSheetRule processDay = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
			requestScope(IMobileAttendanceConstants.PROCESS_DAY,
			        processDay.getValue());
			logger.log(Level.INFO, "contractorUniqueIdRule.getValue() ="
			        + processDay.getValue());
		}
		
		// RULE # 23
		timsheetRule.setRuleKey(IMobileAttendanceConstants.PROCESS_FREQ);
		if (timeSheetRules.indexOf(timsheetRule) != -1)
		{
			
			MA_TimeSheetRule processFreq = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
			requestScope(IMobileAttendanceConstants.PROCESS_FREQ,
			        processFreq.getValue());
			logger.log(Level.INFO, "contractorUniqueIdRule.getValue() ="
			        + processFreq.getValue());
		}
		
	}
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	private List<MA_TimeSheetRule> setTimesheetRules(Long companyId)
	{
		
		List<MA_TimeSheetRule> timeSheetRules = businessService
		        .getTimesheetRulesOfCompany(companyId);
		
		logger.log(Level.INFO, "Inside setTimesheetRule");
		
		MA_Company company = new MA_Company();
		Key companyKey = Datastore.createKey(MA_Company.class, companyId);
		
		String temp = "";
		MA_TimeSheetRule timsheetRule = new MA_TimeSheetRule();
		// Rule # 1
		timsheetRule.setRuleKey(IMobileAttendanceConstants.MIN_DAILY_EFFORTS);
		MA_TimeSheetRule minDailyEffortRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.MIN_DAILY_EFFORTS);
		minDailyEffortRule.setValue(Long.valueOf(temp));
		
		// Rule # 2
		timsheetRule.setRuleKey(IMobileAttendanceConstants.MAX_DAILY_EFFORTS);
		MA_TimeSheetRule maxDailyEffortRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.MAX_DAILY_EFFORTS);
		maxDailyEffortRule.setValue(Long.valueOf(temp));
		
		// Rule # 3
		timsheetRule.setRuleKey(IMobileAttendanceConstants.LATE_MRK_TOLERANCE);
		MA_TimeSheetRule lateMarkToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.LATE_MRK_TOLERANCE);
		lateMarkToleranceRule.setValue(Long.valueOf(temp));
		
		// Rule # 4
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE);
		MA_TimeSheetRule earlyleftToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE);
		earlyleftToleranceRule.setValue(Long.valueOf(temp));
		
		// Rule # 5
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS);
		MA_TimeSheetRule halfDayRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS);
		halfDayRule.setValue(Long.valueOf(temp));
		
		// Rule # 6
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.MIN_HALF_CONTINUOUS_HRS);
		MA_TimeSheetRule halfDayContineousRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.MIN_HALF_CONTINUOUS_HRS);
		halfDayContineousRule.setValue(Long.valueOf(temp));
		
		// Rule # 7
		timsheetRule.setRuleKey(IMobileAttendanceConstants.HALF_DAY_TOLERANCE);
		MA_TimeSheetRule halfDayToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.HALF_DAY_TOLERANCE);
		halfDayToleranceRule.setValue(Long.valueOf(temp));
		// Rule # 8
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS);
		MA_TimeSheetRule overTimeRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS);
		overTimeRule.setValue(Long.valueOf(temp));
		
		// RULE # 9
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.OVER_TIME_TOLERANCES);
		MA_TimeSheetRule overTimeToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.OVER_TIME_TOLERANCES);
		overTimeToleranceRule.setValue(Long.valueOf(temp));
		
		// Rule # 10
		timsheetRule.setRuleKey(IMobileAttendanceConstants.FLEXIBEL_TIME);
		MA_TimeSheetRule flexibleTimeRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.FLEXIBEL_TIME);
		flexibleTimeRule.setValue(Long.valueOf(temp));
		
		// RULE # 11
		timsheetRule.setRuleKey(IMobileAttendanceConstants.LUNCH_BREAK);
		MA_TimeSheetRule lunchBreakRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.LUNCH_BREAK);
		lunchBreakRule.setValue(Long.valueOf(temp));
		
		// RULE # 12
		timsheetRule.setRuleKey(IMobileAttendanceConstants.TEA_BREAK);
		MA_TimeSheetRule teaBreakRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.TEA_BREAK);
		teaBreakRule.setValue(Long.valueOf(temp));
		
		// RULE # 13
		timsheetRule.setRuleKey(IMobileAttendanceConstants.PLANNED_ASSIGNMENT);
		MA_TimeSheetRule plannedAssignmentRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.PLANNED_ASSIGNMENT);
		logger.log(Level.INFO, "PLANNED_ASSIGNMENT=" + temp);
		plannedAssignmentRule.setValue(Long.valueOf(temp));
		
		// RULE # 14
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.MAX_OVERTIME_PER_PAY_PERIOD);
		MA_TimeSheetRule maxOverTimeRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.MAX_OVERTIME_PER_PAY_PERIOD);
		maxOverTimeRule.setValue(Long.valueOf(temp));
		
		// RULE # 15
		timsheetRule.setRuleKey(IMobileAttendanceConstants.EARLY_IN_TOLERANCE);
		MA_TimeSheetRule earlyInTolerranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.EARLY_IN_TOLERANCE);
		earlyInTolerranceRule.setValue(Long.valueOf(temp));
		
		// RULE # 16
		timsheetRule.setRuleKey(IMobileAttendanceConstants.LATE_OUT_TOLERANCE);
		MA_TimeSheetRule lateOutToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.LATE_OUT_TOLERANCE);
		lateOutToleranceRule.setValue(Long.valueOf(temp));
		
		// RULE # 17
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.DAILY_EFFORT_TOLERANCE);
		MA_TimeSheetRule dailyEffortToleranceRule = timeSheetRules
		        .get(timeSheetRules.indexOf(timsheetRule));
		temp = requestScope(IMobileAttendanceConstants.DAILY_EFFORT_TOLERANCE);
		dailyEffortToleranceRule.setValue(Long.valueOf(temp));
		
		// Rule # 18
		
		timsheetRule.setRuleKey(IMobileAttendanceConstants.BILLING_RULE);
		
		MA_TimeSheetRule billingRule = null;
		
		if (timeSheetRules.indexOf(timsheetRule) == -1)
		{
			
			logger.log(Level.INFO, "Rule not found");
			billingRule = new MA_TimeSheetRule();
			billingRule.setRuleKey(IMobileAttendanceConstants.BILLING_RULE);
			billingRule.getCompanyRef().setKey(companyKey);
			timeSheetRules.add(billingRule);
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			Key k1 = AbstractEntityDAO.addModel(billingRule);
			
			logger.log(Level.INFO, "Key=" + k1.getId());
			gtx.commit();
		} else
		{
			billingRule = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
		}
		temp = requestScope(IMobileAttendanceConstants.BILLING_RULE);
		billingRule.setValue(Long.valueOf(temp));
		
		// Rule # 19
		
		temp = requestScope(IMobileAttendanceConstants.DEPARTMENT_RULE);
		timsheetRule.setRuleKey(IMobileAttendanceConstants.DEPARTMENT_RULE);
		
		MA_TimeSheetRule departmentRule = null;
		
		temp = requestScope(IMobileAttendanceConstants.DEPARTMENT_RULE);
		if (timeSheetRules.indexOf(timsheetRule) == -1)
		{
			
			logger.log(Level.INFO, "Create a new departmentRule");
			departmentRule = new MA_TimeSheetRule();
			departmentRule
			        .setRuleKey(IMobileAttendanceConstants.DEPARTMENT_RULE);
			departmentRule.getCompanyRef().setKey(companyKey);
			departmentRule.setValue(Long.valueOf(temp));
			
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			Key k1 = AbstractEntityDAO.addModel(departmentRule);
			
			logger.log(Level.INFO, "Key=" + k1.getId());
			gtx.commit();
			timeSheetRules.add(departmentRule);
		} else
		{
			departmentRule = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
		}
		
		logger.log(Level.INFO, "department Rule Value=" + temp);
		departmentRule.setValue(Long.valueOf(temp));
		
		// Rule # 20
		
		temp = requestScope(IMobileAttendanceConstants.COMPANY_UNIQUEID_RULE);
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.COMPANY_UNIQUEID_RULE);
		
		MA_TimeSheetRule companyUniqueIdRule = null;
		
		temp = request
		        .getParameter(IMobileAttendanceConstants.COMPANY_UNIQUEID_RULE);
		
		logger.log(Level.INFO, "COMPANY_UNIQUEID_RULE =" + temp);
		if (timeSheetRules.indexOf(timsheetRule) == -1)
		{
			
			logger.log(Level.INFO, "Create a new companyUniqueIdRule");
			companyUniqueIdRule = new MA_TimeSheetRule();
			companyUniqueIdRule
			        .setRuleKey(IMobileAttendanceConstants.COMPANY_UNIQUEID_RULE);
			companyUniqueIdRule.getCompanyRef().setKey(companyKey);
			companyUniqueIdRule.setValue(Long.valueOf(temp));
			
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			Key k1 = AbstractEntityDAO.addModel(companyUniqueIdRule);
			
			logger.log(Level.INFO, "Key=" + k1.getId());
			gtx.commit();
			timeSheetRules.add(companyUniqueIdRule);
		} else
		{
			companyUniqueIdRule = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
		}
		
		logger.log(Level.INFO, "companyUniqueIdRule Rule Value=" + temp);
		companyUniqueIdRule.setValue(Long.valueOf(temp));
		
		// Rule # 21
		
		temp = requestScope(IMobileAttendanceConstants.CONTRACTOR_UNIQUEID_RULE);
		timsheetRule
		        .setRuleKey(IMobileAttendanceConstants.CONTRACTOR_UNIQUEID_RULE);
		
		MA_TimeSheetRule contractorUniqueIdRule = null;
		
		temp = requestScope(IMobileAttendanceConstants.CONTRACTOR_UNIQUEID_RULE);
		if (timeSheetRules.indexOf(timsheetRule) == -1)
		{
			
			logger.log(Level.INFO, "Create a new contractorUniqueIdRule");
			contractorUniqueIdRule = new MA_TimeSheetRule();
			contractorUniqueIdRule
			        .setRuleKey(IMobileAttendanceConstants.CONTRACTOR_UNIQUEID_RULE);
			contractorUniqueIdRule.getCompanyRef().setKey(companyKey);
			contractorUniqueIdRule.setValue(Long.valueOf(temp));
			
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			Key k1 = AbstractEntityDAO.addModel(contractorUniqueIdRule);
			
			logger.log(Level.INFO, "Key=" + k1.getId());
			gtx.commit();
			timeSheetRules.add(contractorUniqueIdRule);
		} else
		{
			
			contractorUniqueIdRule = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
		}
		
		logger.log(Level.INFO, "contractorUniqueIdRule Rule Value=" + temp);
		contractorUniqueIdRule.setValue(Long.valueOf(temp));
		
		// Rule # 22
		MA_TimeSheetRule processDayRule = null;
		timsheetRule.setRuleKey(IMobileAttendanceConstants.PROCESS_DAY);
		
		if (requestScope(IMobileAttendanceConstants.PROCESS_FREQ).equals("0"))
		{
			temp = requestScope("process_month");
		} else
		{
			temp = requestScope("process_week");
		}
		
		if (timeSheetRules.indexOf(timsheetRule) == -1)
		{
			
			logger.log(Level.INFO, "Create a new processDayRule");
			processDayRule = new MA_TimeSheetRule();
			processDayRule.setRuleKey(IMobileAttendanceConstants.PROCESS_DAY);
			processDayRule.getCompanyRef().setKey(companyKey);
			processDayRule.setValue(Long.valueOf(temp));
			
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			Key k1 = AbstractEntityDAO.addModel(processDayRule);
			
			logger.log(Level.INFO, "Key=" + k1.getId());
			gtx.commit();
			timeSheetRules.add(processDayRule);
		} else
		{
			
			processDayRule = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
		}
		
		logger.log(Level.INFO, "processDayRule Rule Value=" + temp);
		processDayRule.setValue(Long.valueOf(temp));
		
		// Rule # 23
		MA_TimeSheetRule processFreqRule = null;
		timsheetRule.setRuleKey(IMobileAttendanceConstants.PROCESS_FREQ);
		temp = requestScope(IMobileAttendanceConstants.PROCESS_FREQ);
		if (timeSheetRules.indexOf(timsheetRule) == -1)
		{
			
			logger.log(Level.INFO, "Create a new processFreqRule");
			processFreqRule = new MA_TimeSheetRule();
			processFreqRule.setRuleKey(IMobileAttendanceConstants.PROCESS_FREQ);
			processFreqRule.getCompanyRef().setKey(companyKey);
			processFreqRule.setValue(Long.valueOf(temp));
			
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			Key k1 = AbstractEntityDAO.addModel(processFreqRule);
			
			logger.log(Level.INFO, "Key=" + k1.getId());
			gtx.commit();
			timeSheetRules.add(processFreqRule);
		} else
		{
			processFreqRule = timeSheetRules.get(timeSheetRules
			        .indexOf(timsheetRule));
		}
		
		logger.log(Level.INFO, "processFreqRule Rule Value=" + temp);
		processFreqRule.setValue(Long.valueOf(temp));
		
		logger.log(Level.INFO, "timeSheetRules size =" + timeSheetRules.size());
		
		return timeSheetRules;
		
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		v.add("planned_assignment", v.required());
		v.add("flexibel_time", v.required());
		v.add("min_daily_efforts", v.required());
		v.add("max_daily_efforts", v.required());
		v.add("min_half_day_efforts", v.required());
		v.add("min_half_day_contienous_hrs", v.required());
		v.add("min_over_time_efforts", v.required());
		v.add("max_over_time_per_pay_period", v.required());
		v.add("lunch_break", v.required());
		v.add("tea_break", v.required());
		v.add("daily_effort_tolerance", v.required());
		v.add("over_time_tolerance", v.required());
		v.add("early_in_tolerance", v.required());
		v.add("early_left_tolerance", v.required());
		v.add("late_mark_tolerance", v.required());
		v.add("late_out_tolerance", v.required());
		v.add("daily_effort_tolerance", v.required());
		v.add("billing_rule", v.required());
		v.add("company_uniqueid_rule", v.required());
		v.add("contractor_uniqueid_rule", v.required());
		v.add("process_month", v.required());
		v.add("process_week", v.required());
		v.add("process_freq", v.required());
		
		return v.validate();
	}
	
}
