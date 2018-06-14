package com.adviteya.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.ConsolidatedTimeSheetDTO;
import com.adviteya.meta.MA_AlertMeta;
import com.adviteya.model.MA_Alert;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.model.MA_WeeklyEffortReport;
import com.adviteya.persistence.TimeSheetReportDAO;
import com.adviteya.util.AssignmentHelper;
import com.adviteya.util.MADateUtil;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

/**
 * 
 * @author deejay
 * 
 */
public class CronJobService implements ICronJobService,IMobileAttendanceConstants
{
	private static CronJobService entityService;
	private static Logger         logger  = Logger.getLogger(CronJobService.class
	                                              .getName());
	private EntityService         service = EntityService.getInstance();
	
	/**
	 * Private Constructor
	 */
	private CronJobService()
	{
		
	}
	
	public static CronJobService getInstance()
	{
		
		if (entityService == null)
		{
			entityService = new CronJobService();
		}
		
		return entityService;
	}
	
	/**
	 * Update all the expired Assignments
	 */
	public void updateAssignmentsForAllCompanies()
	{
		List<MA_Company> companies = EntityService.getInstance()
		        .getAllActiveCompanyList();
		for (Iterator<MA_Company> iterator = companies.iterator(); iterator
		        .hasNext();)
		{
			MA_Company ma_Company = (MA_Company) iterator.next();
			logger.log(Level.INFO, "-- updateAssignmentsForAllCompanies -- "
			        + ma_Company.getCompanyName());
			EntityService.getInstance().updateAssignmentStatus(
			        ma_Company.getKey().getId());
		}
		
	}
	
	/**
	 * Populate IN time consolidatedTimeSheet for all the companies
	 */
	public void createConsolidatedTimeSheet()
	{
		List<MA_Company> companies = EntityService.getInstance()
		        .getAllActiveCompanyList();
		
		TimeSheetBusinessService timeSheetBusinessService = new TimeSheetBusinessService();
		
		for (Iterator<MA_Company> iterator = companies.iterator(); iterator
		        .hasNext();)
		{
			MA_Company ma_Company = (MA_Company) iterator.next();
			logger.log(Level.INFO, "-- createConsolidatedTimeSheet -- "
			        + ma_Company.getCompanyName() + " -- "
			        + ma_Company.getKey().getId() + " Template of Company : "
			        + ma_Company.getTemplateRef().getKey());
			
			// TODO : Temp fix to identify the Contracting company
			if (ma_Company.getTemplateRef().getKey() != null)
			{
				timeSheetBusinessService
				        .createPlannedAssignmentConsolidatedTimeSheet(
				                ma_Company.getKey().getId(),
				                Calendar.getInstance());
			}
		}
		
	}
	
	/**
	 * Populate OUT time consolidatedTimeSheet for all the companies
	 */
	public void updateConsolidatedTimeSheet()
	{
		List<MA_Company> companies = EntityService.getInstance()
		        .getAllActiveCompanyList();
		
		TimeSheetBusinessService timeSheetBusinessService = new TimeSheetBusinessService();
		
		for (Iterator<MA_Company> iterator = companies.iterator(); iterator
		        .hasNext();)
		{
			MA_Company ma_Company = (MA_Company) iterator.next();
			logger.log(
			        Level.INFO,
			        "-- updateConsolidatedTimeSheet -- "
			                + ma_Company.getCompanyName() + " -- "
			                + ma_Company.getKey());
			
			// TODO : Temp fix to identify the Contracting company
			if (ma_Company.getTemplateRef().getKey() != null)
			{
				timeSheetBusinessService
				        .updatePlannedAssignmentConsolidatedTimeSheet(
				                ma_Company.getKey().getId(),
				                Calendar.getInstance(), false);
			}
		}
		
	}
	
	/**
	 * Create IN dashboard for all the companies
	 */
	public void createInTimedashBoardData()
	{
		List<MA_Company> companies = EntityService.getInstance()
		        .getAllActiveCompanyList();
		
		DashboardBusinessService dashboardBusinessService = new DashboardBusinessService();
		
		for (Iterator<MA_Company> iterator = companies.iterator(); iterator
		        .hasNext();)
		{
			MA_Company ma_Company = (MA_Company) iterator.next();
			logger.log(Level.INFO, "-- createInTimedashBoardData -- "
			        + ma_Company.getCompanyName() + " -- "
			        + ma_Company.getKey().getId() + " Template of Company : "
			        + ma_Company.getTemplateRef().getKey());
			
			// TODO : Temp fix to identify the Contracting company
			if (ma_Company.getTemplateRef().getKey() != null)
			{
				dashboardBusinessService
				        .calculateAndUpdateInTimeDetailsForCurrentShift(ma_Company
				                .getKey().getId());
			}
		}
		
	}
	
	/**
	 * Create OUT dashboard for all the companies
	 */
	public void createOutTimedashBoardData()
	{
		
		List<MA_Company> companies = EntityService.getInstance()
		        .getAllActiveCompanyList();
		
		DashboardBusinessService dashboardBusinessService = new DashboardBusinessService();
		
		for (Iterator<MA_Company> iterator = companies.iterator(); iterator
		        .hasNext();)
		{
			MA_Company ma_Company = (MA_Company) iterator.next();
			logger.log(
			        Level.INFO,
			        "-- createOutTimedashBoardData -- "
			                + ma_Company.getCompanyName() + " -- "
			                + ma_Company.getKey());
			// TODO : temp fix
			if (ma_Company.getTemplateRef().getKey() != null)
			{
				dashboardBusinessService
				        .calculateAndUpdateOutTimeAndEffortDetails(ma_Company
				                .getKey().getId());
			}
		}
	}
	
	/**
	 * Update all Orphan timesheets
	 */
	public void updateOrphanTimesheets()
	{
		TimeSheetBatchService tbs = TimeSheetBatchService.getInstance();
		tbs.updateOrphanTimesheets();
	}
	
	/**
	 * Run all the timesheet's recorded previous day, but the they have been
	 * synched up in new day
	 */
	public void runPreviousDayTimesheets(Object args[])
	{
		List<MA_Company> companies = new ArrayList<MA_Company>();
		String runMode = (String) args[2];
		
		if (args[1] == null)
		{
			companies.addAll(EntityService.getInstance()
			        .getAllActiveCompanyList());
		} else
		{
			String companyId_str = (String) args[1];
			MA_Company ma_Company = new MA_Company();
			Key companyKey = Datastore.createKey(MA_Company.class,
			        Long.parseLong(companyId_str));
			ma_Company = service.getCompanyObj(companyKey);
			companies.add(ma_Company);
		}
		
		TimeSheetBusinessService timeSheetBusinessService = new TimeSheetBusinessService();
		
		Calendar _c = (Calendar) args[0];
		
		// Calendar _c = Calendar.getInstance();
		_c.add(Calendar.DAY_OF_MONTH, -1);
		
		for (Iterator<MA_Company> iterator = companies.iterator(); iterator
		        .hasNext();)
		{
			MA_Company ma_Company = (MA_Company) iterator.next();
			logger.log(
			        Level.INFO,
			        "-- updateOrphanTimesheets -- "
			                + ma_Company.getCompanyName() + " -- "
			                + ma_Company.getKey());
			
			// TODO : Temp fix to identify the Contracting company
			if (ma_Company.getTemplateRef().getKey() != null)
			{
				timeSheetBusinessService
				        .updatePlannedAssignmentConsolidatedTimeSheet(
				                ma_Company.getKey().getId(),
				                Calendar.getInstance(), true);
			}
		}
	}
	
	/**
	 * Store weekly timeSheet in to entity. This timsheets are not processed but
	 * a snapshot of MA_Timesheet
	 */
	public void storeWeeklyTimesheets(Object args[])
	
	{
		/**
		 * <pre>
		 * Logic : 
		 * 1. Read all Active companies 
		 * 2. Extract timesheet of active employees for a company 
		 * 3. Extract report for each day in the week.
		 * 4. Append report for each day till end of week 
		 * 5. Store Report in CSV format
		 * </pre>
		 */
		logger.log(Level.INFO, " in Store Weekly Timesheets---------> ");
		List<MA_Company> companies = new ArrayList<MA_Company>();
		
		if (args[1] == null)
		{
			companies.addAll(EntityService.getInstance()
			        .getAllActiveCompanyList());
		} else
		{
			String companyId_str = (String) args[1];
			logger.log(Level.INFO, " Company Id: " + companyId_str);
			MA_Company ma_Company = new MA_Company();
			Key companyKey = Datastore.createKey(MA_Company.class,
			        Long.parseLong(companyId_str));
			ma_Company = service.getCompanyObj(companyKey);
			companies.add(ma_Company);
		}
		
		Calendar _c = (Calendar) args[0];
		// Date currentDate = new Date();
		// _c.setTime(currentDate);
		// _c.set(2012, 10, 11, 0, 0, 0);
		// We need to pull out report of last week.
		Calendar _weekStartAndEnd[] = MADateUtil
		        .getGregorianWeekStartAndEndDates(_c);
		
		if (_weekStartAndEnd != null)
		{
			Calendar _weekStart = _weekStartAndEnd[0];
			Calendar _weekEnd = _weekStartAndEnd[1];
			logger.log(
			        Level.INFO,
			        "Running Weekly Job : Start Date is "
			                + _weekStart.getTime() + " and endDate is"
			                + _weekEnd.getTime());
			int weekNumber = _weekStart.get(Calendar.WEEK_OF_YEAR);
			
			Calendar _weekStartCopy = Calendar.getInstance();
			Calendar _weekEndCopy = Calendar.getInstance();
			_weekEndCopy.setTime(_weekEnd.getTime());
			_weekStartCopy.setTime(_weekStart.getTime());
			_weekEnd.add(Calendar.DATE, 1);
			
			for (Iterator<MA_Company> iterator = companies.iterator(); iterator
			        .hasNext();)
			{
				MA_Company ma_Company = (MA_Company) iterator.next();
				
				// TODO : Temp fix to identify the Contracting company
				
				if (ma_Company.getTemplateRef().getKey() != null)
				{
					StringBuffer _weeklyTimeSheetAsCSV = new StringBuffer();
					MA_WeeklyEffortReport _weeklyEffort = new MA_WeeklyEffortReport();
					
					_weekStart.setTime(_weekStartCopy.getTime());
					
					_weeklyEffort.getCompanyRef().setModel(ma_Company);
					_weeklyEffort.setWeekStartDate(_weekStartCopy.getTime());
					
					_weeklyEffort.setCreatedBy("SYSTEM");
					_weeklyEffort.setWeekNo(weekNumber);
					
					int _numOfRec = 0;
					while (_weekStart.before(_weekEnd))
					{
						IPayRollBusinessService businessService = new PayRollBusinessService();
						SimpleDateFormat _sdf = new SimpleDateFormat();
						_sdf.setCalendar(_weekStart);
						
						List<ConsolidatedTimeSheetDTO> consolidatedTimeSheetDTOs = businessService
						        .getCurrentDayTimeSheet(ma_Company.getKey()
						                .getId(), _weekStart);
						_numOfRec += consolidatedTimeSheetDTOs.size();
						_weeklyTimeSheetAsCSV
						        .append(convertTimeDTOtoString(consolidatedTimeSheetDTOs));
						
						_weekStart.add(Calendar.DATE, 1);
					}
					
					_weeklyEffort.setWeekEndDate(_weekEndCopy.getTime());
					_weeklyEffort.setNoOfRecords(_numOfRec);
					_weeklyEffort.setWeeklyReport(new Text(
					        _weeklyTimeSheetAsCSV.toString()));
					
					TimeSheetReportDAO _tSheetReportDAO = TimeSheetReportDAO
					        .newInstance();
					_tSheetReportDAO.storeWeeklyTimeSheets(_weeklyEffort);
				}
			}
		} else
		{
			logger.log(Level.INFO,
			        " <--------------Not a weekend or End of Month : Job not Run---------> ");
		}
	}
	
	/**
	 * 
	 * @param consolidatedTimeSheetDTOs
	 */
	private StringBuffer convertTimeDTOtoString(
	        List<ConsolidatedTimeSheetDTO> consolidatedTimeSheetDTOs)
	{
		StringBuffer _sb = new StringBuffer();
		
		for (Iterator<ConsolidatedTimeSheetDTO> iterator = consolidatedTimeSheetDTOs
		        .iterator(); iterator.hasNext();)
		{
			ConsolidatedTimeSheetDTO consolidatedTimeSheetDTO = (ConsolidatedTimeSheetDTO) iterator
			        .next();
			String _row = "";
			_row += consolidatedTimeSheetDTO.getCompanyEmpId();
			_row += ",";
			_row += consolidatedTimeSheetDTO.getEmployeeName();
			_row += ",";
			if (consolidatedTimeSheetDTO.getLocationName()
			        .equalsIgnoreCase("-"))
			{
				_row += consolidatedTimeSheetDTO.getLocationName();
			} else
			{
				_row += consolidatedTimeSheetDTO.getLocationName() + "("
				        + consolidatedTimeSheetDTO.getTimezone() + ")";
			}
			_row += ",";
			_row += consolidatedTimeSheetDTO.getShiftName();
			_row += ",";
			_row += consolidatedTimeSheetDTO.getDepartmentName();
			_row += ",";
			_row += consolidatedTimeSheetDTO.getCreatedDate();
			_row += ",";
			_row += consolidatedTimeSheetDTO.getAttendanceCoordinatesIn();
			_row += ",";
			_row += consolidatedTimeSheetDTO.getInTime();
			_row += ",";
			_row += consolidatedTimeSheetDTO.getAttendanceCoordinatesOut();
			_row += ",";
			_row += consolidatedTimeSheetDTO.getOutTime();
			_row += "";
			_sb.append(_row);
			_sb.append('\n');
		}
		
		return _sb;
		
	}
	
	/**
	 * 
	 * @param ma_Company
	 */
	public void executeTimeSheetJobSequence(MA_Company ma_Company)
	{
		TimeSheetBusinessService timeSheetBusinessService = new TimeSheetBusinessService();
		DashboardBusinessService dashboardBusinessService = new DashboardBusinessService();
		
		if (ma_Company.getTemplateRef().getKey() != null)
		{
			timeSheetBusinessService
			        .createPlannedAssignmentConsolidatedTimeSheet(ma_Company
			                .getKey().getId(), Calendar.getInstance());
			dashboardBusinessService
			        .calculateAndUpdateInTimeDetailsForCurrentShift(ma_Company
			                .getKey().getId());
			timeSheetBusinessService
			        .updatePlannedAssignmentConsolidatedTimeSheet(ma_Company
			                .getKey().getId(), Calendar.getInstance(), false);
			dashboardBusinessService
			        .calculateAndUpdateOutTimeAndEffortDetails(ma_Company
			                .getKey().getId());
		}
	}
	
	/**
	 * This is the main method which check for shift which are eligible for
	 * alerts and then triggers the alerts and escalation
	 * 
	 * <pre>
	 * Logic :
	 * 1. Get system time in GMT
	 * 2. load shift Vital parameters
	 * 3. examine shift vital parameters for escalation
	 * </pre>
	 * 
	 */
	public void executeStartAlert()
	{
		logger.log(Level.INFO, " Start executeAlert method ");
		List<MA_Shift> _shifts = ShiftBusinessService.loadActiveShiftsForAlerts();
		boolean hasShiftStarted = false;
		
		for (Iterator<MA_Shift> iterator = _shifts.iterator(); iterator
		        .hasNext();)
		{
			MA_Shift ma_Shift = (MA_Shift) iterator.next();
			
			Calendar _currentDate = Calendar.getInstance();
			
			// 30 minutes are subtracted from the current time to check 30
			// minutes elapsed after shift start time.
			
			_currentDate.add(Calendar.MINUTE, -30);
			
			hasShiftStarted = AssignmentHelper.hasShiftStarted(ma_Shift,
			        _currentDate);
			
			if (hasShiftStarted)
			{
				List<MA_Alert> _alerts = AlertService.loadShiftStartAlerts(ma_Shift);
				
				for (Iterator<MA_Alert> iterator2 = _alerts.iterator(); iterator2
				        .hasNext();)
				{
					MA_Alert ma_Alert = (MA_Alert) iterator2.next();
					executeOMCCommunicator(ma_Alert.getKey().getId());
				}
			}
			
		}
		logger.log(Level.INFO, " End executeAlert method ");
	}
	
	/**
	 * This method invokes queue for each message. The employeeIds are
	 * MA_Employee keys separated by comma
	 * 
	 * @param alertId
	 * @param toListEmployeeIds
	 * @param ccListEmployeeIds
	 */
	public void executeOMCCommunicator(long alertId)
	{
		logger.log(Level.INFO, " Start executeOMCCommunicator method ");
		// Invoke the queue
		// start
		TaskOptions _t = TaskOptions.Builder
		        .withUrl("/humancapital/OMCEmailCommunicator");
		_t.param("alertId", Long.toString(alertId));
		Queue queue = QueueFactory.getQueue("omc-email-communicator");
		queue.add(_t);
		// end
		logger.log(Level.INFO, " End executeOMCCommunicator method ");
	}
	
	/**
	 * 
	 * @param o
	 */
	public void storePayrollReport(Object[] o)
	{
		
		// MA_Company company = new MA_Company();
		// TODO : Take off the hard coded value
		// Key k = Datastore.createKey(MA_Company.class, new Long(8001));
		// company.setKey(k);
		
		List<MA_Company> companies = new ArrayList<MA_Company>();
		
		String runMode = (String) o[2];
		
		if (runMode != null && runMode.equals("manual"))
		{
			String companyId_str = (String) o[1];
			logger.log(Level.INFO, " Company Id: " + companyId_str);
			MA_Company ma_Company = new MA_Company();
			Key companyKey = Datastore.createKey(MA_Company.class,
			        Long.parseLong(companyId_str));
			ma_Company = service.getCompanyObj(companyKey);
			companies.add(ma_Company);
			
		} else
		{
			companies.addAll(EntityService.getInstance()
			        .getAllActiveCompanyList());
		}
		
		Calendar _c = (Calendar) o[0];
		
		Iterator<MA_Company> itr = companies.iterator();
		
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
				
				if (_freq == 0)
				{
					if (_c.get(Calendar.DATE) == _date)
					{
						
						int _month = _c.get(Calendar.MONTH);
						int _year = _c.get(Calendar.YEAR);
						
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
					if (_c.get(Calendar.DAY_OF_WEEK) == _date)
					{
						int _month = _c.get(Calendar.MONTH);
						int _year = _c.get(Calendar.YEAR);
						int date = _c.get(Calendar.DATE);
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
	
	/**
	 * 
	 */
	public void executeEndAlert()
	{
		logger.log(Level.INFO, " Start executeEndAlert method ");
		List<MA_Shift> _shifts = ShiftBusinessService.loadActiveShiftsForAlerts();
		
		boolean hasShiftEnded = false;
		
		for (Iterator<MA_Shift> iterator = _shifts.iterator(); iterator
		        .hasNext();)
		{
			MA_Shift ma_Shift = (MA_Shift) iterator.next();
			
			Calendar _currentDate = Calendar.getInstance();
			
			// 1 hour is subtracted from the current time to check 1 hours are
			// elapsed after shift start time.
			
			_currentDate.add(Calendar.HOUR, -1);
			
			hasShiftEnded = AssignmentHelper.hasShiftEnded(ma_Shift,
			        _currentDate);
			
			if (hasShiftEnded)
			{
				MA_Alert _alert =AlertService.getAlertForShift(ma_Shift,FEMALE_EMPLOYEE_SECURITY);
						
				if(_alert!=null)
						executeOMCCommunicator(_alert.getKey().getId());
				
			}
			
		}
		logger.log(Level.INFO, " End executeEndAlert method ");
		
	}
	
}
