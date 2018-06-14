 package com.adviteya.controller.humancapital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.service.CronJobService;
import com.adviteya.service.EntityService;
import com.adviteya.service.ITimeSheetBusinessService;
import com.adviteya.service.TimeSheetBusinessService;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

/**
 * This controller class the is main class which runs all the cron job.
 * 
 * TODO : need to lick this with security configure through web.xml
 * 
 * @author deejay
 * 
 */
public class CronJobSchedulerController extends BatchJobBaseController
        implements IMobileAttendanceConstants
{
	
	private static final Logger logger = Logger.getLogger(CronJobSchedulerController.class
	                                           .getName());
	
	@Override
	public Navigation executeLogic()
	{
		String action = requestScope("action");
		String companyId = requestScope("companyId");
		String dateOfRun = requestScope("dateOfRun");
		String runMode = (String) (requestScope("runeMode") == null ? "auto"
		        : requestScope("runeMode"));
		Calendar _c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		if (dateOfRun != null)
		{
			logger.log(Level.INFO, "-- inside Date run  --");
			
			try
			{
				Date date = sdf.parse(dateOfRun);
				_c.setTime(date);
			} catch (ParseException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Object o[] = new Object[] { _c, companyId, runMode };
		logger.log(Level.INFO, "-- Running Updated Scheduler --");
		logger.log(Level.INFO, "-- Running Scheduler -- action = " + action);
		CronJobService _cronJobService = CronJobService.getInstance();
		
		if (action.equalsIgnoreCase(UPDATE_ASSIGNMENT))
		{
			_cronJobService.updateAssignmentsForAllCompanies();
		} else if (action.equalsIgnoreCase(CREATE_CONSOLIDATE_TIMESHEET))
		{
			_cronJobService.createConsolidatedTimeSheet();
		} else if (action.equalsIgnoreCase(UPDATE_CONSOLIDATE_TIMESHEET))
		{
			_cronJobService.updateConsolidatedTimeSheet();
		} else if (action.equalsIgnoreCase(INTIME_DASHBOARD))
		{
			_cronJobService.createInTimedashBoardData();
		} else if (action.equalsIgnoreCase(OUTTIME_DASHBOARD))
		{
			_cronJobService.createOutTimedashBoardData();
		} else if (action.equalsIgnoreCase(ORPHAN_TIMESHEET))
		{
			_cronJobService.updateOrphanTimesheets();
		} else if (action.equalsIgnoreCase(UPDATE_PREV_TIMESHEET))
		{
			_cronJobService.runPreviousDayTimesheets(o);
		} else if (action.equalsIgnoreCase(STORE_WEEKLY_REPORT))
		{
			_cronJobService.storeWeeklyTimesheets(o);
		} else if (action.equalsIgnoreCase(STORE_PAYROLL_REPORT))
		{
			_cronJobService.storePayrollReport(o);
		} else if (action.equalsIgnoreCase(EXECUTE_SHIFT_START_ALERT))
		{
			_cronJobService.executeStartAlert();
		}else if (action.equalsIgnoreCase(EXECUTE_SHIFT_END_ALERT))
		{
			_cronJobService.executeEndAlert();
		}
		
		return null;
	}
	
	/**
	 * @deprecated TODO : Stores the payroll Report
	 */
	private void storePayrollReport()
	{
		
		// MA_Company company = new MA_Company();
		// TODO : Take off the hard coded value
		// Key k = Datastore.createKey(MA_Company.class, new Long(8001));
		// company.setKey(k);
		
		List<MA_Company> _companies = EntityService.getInstance()
		        .getAllActiveCompanyList();
		
		Iterator<MA_Company> itr = _companies.iterator();
		
		while (itr.hasNext())
		{
			MA_Company _company = itr.next();
			
			long companyId = _company.getKey().getId();
			
			ITimeSheetBusinessService timeSheetService = new TimeSheetBusinessService();
			MA_TimeSheetRule timesheetRule = new MA_TimeSheetRule();
			MA_TimeSheetRule timesheetRule1 = new MA_TimeSheetRule();
			List<MA_TimeSheetRule> timeSheetRules = timeSheetService
			        .getTimesheetRulesOfCompany(_company.getKey().getId());
			
			// TODO : Fix the problem of obtaining the start & end date based on
			// Admin rules
			
			timesheetRule.setRuleKey(IMobileAttendanceConstants.PROCESS_DAY);
			timesheetRule1.setRuleKey(IMobileAttendanceConstants.PROCESS_FREQ);
			
			if (timeSheetRules.indexOf(timesheetRule) != -1
			        && timeSheetRules.indexOf(timesheetRule1) != -1)
			{
				MA_TimeSheetRule processDay = timeSheetRules.get(timeSheetRules
				        .indexOf(timesheetRule));
				MA_TimeSheetRule processFreq = timeSheetRules
				        .get(timeSheetRules.indexOf(timesheetRule1));
				int _freq = processFreq.getValue().intValue();
				int _date = processDay.getValue().intValue();
				
				logger.log(Level.INFO, "contractorUniqueIdRule.getValue() ="
				        + processDay.getValue());
				
				Calendar _cal = Calendar.getInstance();
				
				if (_freq == 0)
				{
					if (_cal.get(Calendar.DATE) == _date)
					{
						
						int _month = _cal.get(Calendar.MONTH);
						int _year = _cal.get(Calendar.YEAR);
						
						Calendar _fromCal = Calendar.getInstance();
						_fromCal.clear();
						_fromCal.set(_year, (_month - 1), _date, 0, 0, 0);
						
						Calendar _toCal = Calendar.getInstance();
						_toCal.clear();
						_toCal.set(_year, _month, _date - 1);
						
						SimpleDateFormat _sdf = new SimpleDateFormat(
						        "MM/dd/yyyy");
						// Invoke the queue
						// start
						logger.log(Level.INFO,
						        "------------Invoke the queue-----------");
						TaskOptions _t = TaskOptions.Builder
						        .withUrl("/humancapital/payrollAsyncProcessor");
						_t.param("COMPANYID", new Long(companyId).toString());
						_t.param("STARTDATE", _sdf.format(_fromCal.getTime()));
						_t.param("ENDDATE", _sdf.format(_toCal.getTime()));
						_t.param("actionParam", "payrollAsyncProcessor");
						Queue queue = QueueFactory
						        .getQueue("omc-payroll-record-input");
						queue.add(_t);
						// end
					}
				} else if (_freq == 1)
				{
					if (_cal.get(Calendar.DAY_OF_WEEK) == _date)
					{
						int _month = _cal.get(Calendar.MONTH);
						int _year = _cal.get(Calendar.YEAR);
						int date = _cal.get(Calendar.DATE);
						Calendar _fromCal = Calendar.getInstance();
						_fromCal.clear();
						_fromCal.set(_year, _month, date, 0, 0, 0);
						_fromCal.add(Calendar.DATE, -7);
						
						Calendar _toCal = Calendar.getInstance();
						_toCal.clear();
						_toCal.set(_year, _month, date - 1, 0, 0, 0);
						
						SimpleDateFormat _sdf = new SimpleDateFormat(
						        "MM/dd/yyyy");
						// Invoke the queue
						// start
						logger.log(Level.INFO,
						        "------------Invoke the queue-----------");
						TaskOptions _t = TaskOptions.Builder
						        .withUrl("/humancapital/payrollAsyncProcessor");
						_t.param("COMPANYID", new Long(companyId).toString());
						_t.param("STARTDATE", _sdf.format(_fromCal.getTime()));
						_t.param("ENDDATE", _sdf.format(_toCal.getTime()));
						_t.param("actionParam", "payrollAsyncProcessor");
						Queue queue = QueueFactory
						        .getQueue("omc-payroll-record-input");
						queue.add(_t);
					}
				}
				
			}
		}
	}
}
