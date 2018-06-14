package com.adviteya.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.datastore.ModelQuery;
import org.slim3.datastore.Sort;
import org.slim3.util.DateUtil;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.ConsolidatedTimeSheetDTO;
import com.adviteya.dto.reports.PeriodicTimeSheet;
import com.adviteya.dto.reports.TimeSheetDTO;
import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.meta.MA_ConsolidatedTimesheetMeta;
import com.adviteya.meta.MA_DashboardDataMeta;
import com.adviteya.meta.MA_TimeSheetRuleMeta;
import com.adviteya.meta.MA_TimesheetMeta;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_ConsolidatedTimesheet;
import com.adviteya.model.MA_DashboardData;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_LocationHoliday;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.model.MA_User;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.TimesheetDAO;
import com.adviteya.util.AssignmentHelper;
import com.google.appengine.api.datastore.Key;

/**
 * @author Dheeraj
 * 
 */
public class TimeSheetBusinessService implements ITimeSheetBusinessService,
        MobileServiceConstants
{
	
	private static Logger logger  = Logger.getLogger(TimeSheetBusinessService.class
	                                      .getName());
	private EntityService service = EntityService.getInstance();
	public static double  readCounter;
	public static double  writeCounter;
	
	public List<MA_Timesheet> synchTimeSheet(List timesheets, MA_User user,
	        boolean hasPlannedAssignments)
	{
		logger.log(Level.INFO, "TimeSheetBusinessService.synchTimeSheet");
		/**
		 * Logic :
		 * 
		 * 1. Insert Timesheets </br>
		 * 
		 * 2. getPartiallyFilledTimesheets </br>
		 * 
		 * 3. getBlankTimesheets </br>
		 * 
		 */
		// GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		
		TimesheetDAO tsDAO = new TimesheetDAO();
		// tsDAO.setGtx(gtx);
		
		if (timesheets != null && timesheets.size() > 0)
		{
			
			tsDAO.addTimesheets(timesheets, user);
			logger.log(Level.INFO, "Added timesheets " + timesheets.size());
		}
		
		// gtx.commit();
		
		List<MA_Timesheet> _timesheets = ShiftBusinessService
		        .getTimesheetsAssignedToMobSupervisor(user);
		
		/**
		 * If in the rules the user has allowed "NO Planned assignments", send
		 * unassigned emp data for validation Else the only assigned users will
		 * be authenticated by mobile phone.
		 */
		
		if (!hasPlannedAssignments)
		{
			_timesheets.addAll(ShiftBusinessService
			        .getTimesheetsNOTAssignedToMobSupervisor(user));
		}
		return _timesheets;
	}
	
	public Map<String, Long> getTimesheetRulesMapOfCompany(Long companyId)
	{
		
		MA_TimeSheetRuleMeta timeSheetRuleMeta = MA_TimeSheetRuleMeta.get();
		MA_Company company = new MA_Company();
		Key k1 = AbstractEntityDAO.createKey(company, companyId);
		List<MA_TimeSheetRule> timeSheetRules = Datastore
		        .query(timeSheetRuleMeta)
		        .filter(timeSheetRuleMeta.companyRef.equal(k1)).asList();
		
		Iterator<MA_TimeSheetRule> itr = timeSheetRules.iterator();
		Map<String, Long> rulesMap = new HashMap<String, Long>();
		
		while (itr.hasNext())
		{
			MA_TimeSheetRule timeSheetRule = itr.next();
			rulesMap.put(timeSheetRule.getRuleKey(), timeSheetRule.getValue());
		}
		
		return rulesMap;
	}
	
	/**
	 * 
	 */
	public List<MA_TimeSheetRule> getTimesheetRulesOfCompany(Long companyId)
	{
		
		MA_TimeSheetRuleMeta timeSheetRuleMeta = MA_TimeSheetRuleMeta.get();
		MA_Company company = new MA_Company();
		Key k1 = AbstractEntityDAO.createKey(company, companyId);
		List<MA_TimeSheetRule> timeSheetRules = Datastore
		        .query(timeSheetRuleMeta)
		        .filter(timeSheetRuleMeta.companyRef.equal(k1)).asList();
		
		return timeSheetRules;
	}
	
	/**
	 * <pre>
	 * 	This is a important business method which does the following :
	 * 1. Pick all the updated timesheets and update consoliated timesheet.
	 * 2. This is being triggered by a batch job and runs after regular interval
	 * 3. It intakes the current date and false (true | false) for previousDay. If the previous day flag is false - then it will execute all the timesheet scanned in the 
	 *  current day. If the previous day flag is 'Y' then it will set the date for the previous day and will not check if the shift has ended.
	 * 
	 * </pre>
	 * 
	 * @param companyId
	 * @param currentDate
	 */
	public void updatePlannedAssignmentConsolidatedTimeSheet(Long companyId,
	        Calendar currentDateOrig, boolean previousDay)
	{
		
		logger.log(Level.INFO,
		        "START updatePlannedAssignmentConsolidatedTimeSheet");
		
		// List<MA_Employee> employees = service
		// .getAllEmployeeForCompany(companyId);
		
		List<MA_Employee> employees = service
		        .getAllActiveEmployeesForCompany(companyId);
		
		MA_Company company = new MA_Company();
		Key companykey = AbstractEntityDAO.createKey(company, companyId);
		company = service.getCompanyObj(companykey);
		// TODO : Pick only non-contracting companies
		
		Map<String, Long> rulesMap = getTimesheetRulesMapOfCompany(companyId);
		
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		
		Iterator<MA_Employee> iterator = employees.iterator();
		logger.log(Level.INFO, "size of emp : " + employees.size());
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		MA_TimesheetMeta timesheetMeta = MA_TimesheetMeta.get();
		int count = 0;
		while (iterator.hasNext())
		{
			
			// currentDate = Calendar.getInstance();
			
			Calendar currentDate = Calendar.getInstance();
			Date _d = new Date(currentDateOrig.getTimeInMillis());
			currentDate.setTime(_d);
			
			Integer createDay = currentDate.get(Calendar.DAY_OF_MONTH);
			Integer createMonth = currentDate.get(Calendar.MONTH);
			Integer createYear = currentDate.get(Calendar.YEAR);
			Integer createHour = currentDate.get(Calendar.HOUR_OF_DAY);
			Integer createMin = currentDate.get(Calendar.MINUTE);
			
			MA_Employee employee = iterator.next();
			List timsheetsToUpdate = new ArrayList();
			logger.log(Level.INFO, "Employee Id= " + employee.getCompanyEmpId());
			
			// Get the current assignment of the employee.This Scenario
			// will
			// cover the conditions where company has planned
			// assignments.
			MA_Assignment employee_assignment = Datastore
			        .query(assignmentMeta)
			        .filter(assignmentMeta.employeeRef.equal(employee.getKey()),
			                assignmentMeta.status.equal(CURRENT_ASSIGNMENT))
			        .asSingle();
			
			if (employee_assignment == null)
			{
				employee_assignment = Datastore
				        .query(assignmentMeta)
				        .filter(assignmentMeta.employeeRef.equal(employee
				                .getKey()),
				                assignmentMeta.status.equal(DEFAULT_ASSIGNMENT))
				        .asSingle();
			}
			
			if (null != employee_assignment)
			{
				boolean _shiftHasEnded = false;
				
				// If employee has planned current assignment.
				logger.log(Level.INFO, "employee_assignment-"
				        + employee_assignment.getKey().getId());
				boolean lateInFlag = false;
				
				MA_Shift shift = employee_assignment.getShiftRef().getModel();
				
				/**
				 * If a shift spans a day - then we need to get
				 * consolidatedTimeSheet of the previous day
				 */
				SimpleDateFormat sdf = new SimpleDateFormat(
				        "yyyy.MM.dd G 'at' HH:mm:ss a z");
				
				logger.log(
				        Level.INFO,
				        "Current time before adjustment "
				                + sdf.format(currentDate.getTime()));
				
				if (!previousDay)
				{
					if (shift != null)
					{
						// dj - chg : 1 - 04/16/2012
						logger.log(
						        Level.INFO,
						        "Shift start and end timings "
						                + shift.getStartHrs() + " -- "
						                + shift.getEndHrs());
						
						_shiftHasEnded = AssignmentHelper.hasShiftEnded(shift,
						        currentDate);
						
						// Known defect : If the an outtime is record in next
						// day
						// i.e after end time, this logic will not work
						if (shift.getStartHrs() > shift.getEndHrs())
						{
							// Date : 04/20/2012 : This logic is needed in any
							// case.
							// even if the shift end hrs is not of
							// next day, but it the job in next day, but before
							// the
							// shift start, reduce a day from the
							// current time.
							if (!AssignmentHelper.hasNewShiftStarted(shift,
							        currentDate))
							{
								currentDate.add(Calendar.DAY_OF_MONTH, -1);
								createDay = currentDate
								        .get(Calendar.DAY_OF_MONTH);
								createMonth = currentDate.get(Calendar.MONTH);
								createYear = currentDate.get(Calendar.YEAR);
							}
							
						}
					}
				}
				
				logger.log(
				        Level.INFO,
				        "Current time after adjustment "
				                + sdf.format(currentDate.getTime()));
				
				ArrayList<String> _consolidatedMarkers = new ArrayList<String>();
				_consolidatedMarkers.add("CURRENT");
				_consolidatedMarkers.add("NO_OUT_TIME");
				
				MA_ConsolidatedTimesheet consolidatedTimeSheet = Datastore
				        .query(consolidatedTimesheetMeta)
				        .filter(consolidatedTimesheetMeta.assignmentRef.equal(employee_assignment
				                .getKey()),
				                consolidatedTimesheetMeta.createDay
				                        .equal(createDay),
				                consolidatedTimesheetMeta.createMonth
				                        .equal(createMonth),
				                consolidatedTimesheetMeta.createYear
				                        .equal(createYear),
				                consolidatedTimesheetMeta.marker
				                        .in(_consolidatedMarkers)).asSingle();
				
				logger.log(Level.INFO, "consolidatedTimeSheet found =  "
				        + consolidatedTimeSheet);
				
				/**
				 * consolidatedTimeSheet will be 'null' if the shift crosses
				 * mid-night. In such cases we need to move createDay back by a
				 * day.
				 */
				if (consolidatedTimeSheet == null)
				{
					currentDate.add(Calendar.DAY_OF_MONTH, -1);
					createDay = currentDate.get(Calendar.DAY_OF_MONTH);
					createMonth = currentDate.get(Calendar.MONTH);
					createYear = currentDate.get(Calendar.YEAR);
					
					consolidatedTimeSheet = Datastore
					        .query(consolidatedTimesheetMeta)
					        .filter(consolidatedTimesheetMeta.assignmentRef.equal(employee_assignment
					                .getKey()),
					                consolidatedTimesheetMeta.createDay
					                        .equal(createDay),
					                consolidatedTimesheetMeta.createMonth
					                        .equal(createMonth),
					                consolidatedTimesheetMeta.createYear
					                        .equal(createYear),
					                consolidatedTimesheetMeta.marker
					                        .in(_consolidatedMarkers))
					        .asSingle();
				}
				
				// Shift is null for DEFAULT_ASSIGNMENT
				if (consolidatedTimeSheet != null)
				{
					logger.log(Level.INFO, "consolidatedTimeSheet key =  "
					        + consolidatedTimeSheet.getKey().getId());
					logger.log(
					        Level.INFO,
					        "---currentDate====="
					                + sdf.format(currentDate.getTime()));
					
					if (shift == null)
					{
						shift = consolidatedTimeSheet.getShiftRef().getModel();
						// Get back to current date for finding if the shift has
						// ended
						if (previousDay)
						{
							_shiftHasEnded = true;
							// Check for night shift
							if (shift.getStartHrs() > shift.getEndHrs())
							{
								currentDate.add(Calendar.DAY_OF_MONTH, -1);
							}
						} else
						{
							// currentDate.add(Calendar.DAY_OF_MONTH, 1);
							_shiftHasEnded = AssignmentHelper.hasShiftEnded(
							        shift, currentDate);
							// Check for night shift
							if (shift.getStartHrs() > shift.getEndHrs())
							{
								currentDate.add(Calendar.DAY_OF_MONTH, -1);
							}
						}
						
					}
					
					if (_shiftHasEnded)
					{
						if (null != consolidatedTimeSheet)
						{
							logger.log(Level.INFO, "consolidatedTimeSheet-"
							        + consolidatedTimeSheet.getKey().getId());
							
							ModelQuery<MA_Timesheet> query = Datastore
							        .query(MA_Timesheet.class);
							query.sort(new Sort("createdDate"));
							
							ArrayList<String> _stringPara = new ArrayList<String>();
							_stringPara.add("UPDATED");
							_stringPara.add("NO_OUT_TIME");
							_stringPara.add("CURRENT");
							
							// Get all the timesheets for a employee for the day
							List<MA_Timesheet> timesheets = query
							        .filter(timesheetMeta.assignmentRef.equal(employee_assignment
							                .getKey()),
							                timesheetMeta.createDay
							                        .equal(createDay),
							                timesheetMeta.createMonth
							                        .equal(createMonth),
							                timesheetMeta.createYear
							                        .equal(createYear),
							                timesheetMeta.marker
							                        .in(_stringPara)).asList();
							
							if (null != timesheets && timesheets.size() > 0)
							{
								Iterator<MA_Timesheet> timesheetIterator = timesheets
								        .iterator();
								// Read all the timesheets and calculate the
								// effort
								while (timesheetIterator.hasNext())
								{
									MA_Timesheet timesheet = timesheetIterator
									        .next();
									
									/**
									 * For Unplanned assignments get ShiftRef
									 * from Timesheets
									 */
									
									consolidatedTimeSheet
									        .setOutDateTime(timesheet
									                .getOutDateTime());
									
									// Note : Commented this logic for some
									// reasons timesheet.dailyEffort is null
									// This is a bug.
									// Double dailyEffort = timesheet
									// .getDailyEffort();
									// if (null == dailyEffort)
									// {
									//
									// dailyEffort = new Double(0);
									// }
									
									Double dailyEffort = new Double(0);
									
									if (timesheet.getOutDateTime() != null)
									{
										long _diff = timesheet.getOutDateTime()
										        .getTime()
										        - timesheet.getInDateTime()
										                .getTime();
										
										dailyEffort = new Double(_diff / 1000);
										
									}
									
									consolidatedTimeSheet
									        .setActualDailyEffort(consolidatedTimeSheet
									                .getActualDailyEffort()
									                + dailyEffort);
									
									logger.log(Level.INFO,
									        "timesheet.getDailyEffort()-"
									                + dailyEffort);
									logger.log(Level.INFO,
									        "timesheet.getMarker()-"
									                + timesheet.getMarker());
									
									if (!timesheet.getMarker()
									        .equals("CURRENT"))
									{
										timesheet.setMarker("PROCESSED");
										timsheetsToUpdate.add(timesheet);
									}
								}
								
								// Situation : If the outtime has been recorded
								// after the shift has ended, the outtime will
								// be zero
								// Do not update the records, if the Outtime is
								// zero.
								//
								
								logger.log(
								        Level.INFO,
								        "consolidatedTimeSheet.getActualDailyEffort() ="
								                + consolidatedTimeSheet
								                        .getActualDailyEffort());
								
								if (consolidatedTimeSheet
								        .getActualDailyEffort() > 0)
								{
									// Check the consolidated timesheet against
									// timesheets
									// rules.
									
									// At this point the shift is still depicts
									// local time.
									
									Calendar shiftStartTime = Calendar
									        .getInstance();
									shiftStartTime.set(Calendar.HOUR_OF_DAY,
									        shift.getStartHrs());
									shiftStartTime.set(Calendar.MINUTE,
									        shift.getStartMin());
									shiftStartTime.set(Calendar.SECOND, 0);
									shiftStartTime.set(Calendar.MILLISECOND, 0);
									
									Calendar shiftEndTime = DateUtil
									        .clearTimePart(Calendar
									                .getInstance());
									shiftEndTime.set(Calendar.HOUR_OF_DAY,
									        shift.getEndHrs());
									shiftEndTime.set(Calendar.MINUTE,
									        shift.getEndMin());
									shiftEndTime.set(Calendar.SECOND, 0);
									shiftEndTime.set(Calendar.MILLISECOND, 0);
									
									// If flexible time is not allowed
									if (rulesMap
									        .get(IMobileAttendanceConstants.FLEXIBEL_TIME) == 1)
									{
										
										if (consolidatedTimeSheet
										        .getInTimeResult().intValue() == IMobileAttendanceConstants.LATE_IN)
										{
											lateInFlag = true;
										}
										
										// Check for out time.
										if (lateInFlag)
										{
											Long inTime = consolidatedTimeSheet
											        .getInDateTime().getTime();
											
											Long lateMark = shiftStartTime
											        .getTimeInMillis()
											        + (rulesMap
											                .get(IMobileAttendanceConstants.LATE_MRK_TOLERANCE) * 1000);
											
											Long earlyIn = shiftStartTime
											        .getTimeInMillis()
											        - (rulesMap
											                .get(IMobileAttendanceConstants.EARLY_IN_TOLERANCE) * 1000);
											
											if (inTime >= earlyIn
											        && inTime <= lateMark)
											{
												
												consolidatedTimeSheet
												        .setInTimeResult(IMobileAttendanceConstants.RIGHT_IN);
												
											} else if (inTime < earlyIn)
											{
												consolidatedTimeSheet
												        .setInTimeResult(IMobileAttendanceConstants.EARLY_IN);
											} else
											{
												consolidatedTimeSheet
												        .setInTimeResult(IMobileAttendanceConstants.LATE_IN);
											}
											
										}
										
										if (null != consolidatedTimeSheet
										        .getOutDateTime())
										{
											
											Long outTime = consolidatedTimeSheet
											        .getOutDateTime().getTime();
											
											Long earlyOut = shiftEndTime
											        .getTimeInMillis()
											        - (rulesMap
											                .get(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE) * 1000);
											
											Long lateOut = shiftEndTime
											        .getTimeInMillis()
											        + (rulesMap
											                .get(IMobileAttendanceConstants.LATE_OUT_TOLERANCE) * 1000);
											
											if (outTime >= earlyOut
											        && outTime <= lateOut)
											{
												consolidatedTimeSheet
												        .setOutTimeResult(IMobileAttendanceConstants.RIGHT_OUT);
												
											} else if (outTime < earlyOut)
											{
												consolidatedTimeSheet
												        .setOutTimeResult(IMobileAttendanceConstants.EARLY_OUT);
											} else
											{
												consolidatedTimeSheet
												        .setOutTimeResult(IMobileAttendanceConstants.LATE_OUT);
											}
										}
										
									}
									
									/**
									 * This section calculates the FLAG for the
									 * daily effort
									 * 
									 * <pre>
									 * 1. TODO : MIN_DAILY_EFFORTS should be calculated from Shift duration rather from Rules
									 * 2. The non-working days should be marked for Leave and WeekEnd
									 * </pre>
									 */
									
									Long timeDiff = 0L;
									if (null != consolidatedTimeSheet
									        .getOutDateTime())
									{
										timeDiff = (consolidatedTimeSheet
										        .getOutDateTime().getTime() - consolidatedTimeSheet
										        .getInDateTime().getTime()) / 1000;
									}
									consolidatedTimeSheet
									        .setDailyEffort(new Double(timeDiff));
									
									// Working hours are less then min daily
									// effort.
									Double actualDailyEffort = consolidatedTimeSheet
									        .getActualDailyEffort();
									
									Double shiftDuration = new Double(
									        (shiftEndTime.getTimeInMillis() / 1000)
									                - (shiftStartTime
									                        .getTimeInMillis() / 1000));
									
									// Give a leeway of 15 mins. i.e. if someone
									// has
									// 15 less effort is still counted as Right
									// effort
									
									if (actualDailyEffort < rulesMap
									        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS))
									{
										
										if (actualDailyEffort
										        + rulesMap
										                .get(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE) < rulesMap
										            .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS))
										{
											
											Long minEffortsForHalfDay = rulesMap
											        .get(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS)
											        + rulesMap
											                .get(IMobileAttendanceConstants.HALF_DAY_TOLERANCE);
											
											if (actualDailyEffort < minEffortsForHalfDay)
											{
												
												consolidatedTimeSheet
												        .setEffortResult(IMobileAttendanceConstants.UNPAID_LEAVE);
											} else
											{
												
												if (actualDailyEffort > minEffortsForHalfDay
												        && consolidatedTimeSheet
												                .getDailyEffort() >= rulesMap
												                .get(IMobileAttendanceConstants.MIN_HALF_CONTINUOUS_HRS))
												{
													
													consolidatedTimeSheet
													        .setEffortResult(IMobileAttendanceConstants.HALF_DAY);
												} else
												{
													consolidatedTimeSheet
													        .setEffortResult(IMobileAttendanceConstants.LESS_EFFORT);
													
												}
												
											}
										} else
										{
											consolidatedTimeSheet
											        .setEffortResult(IMobileAttendanceConstants.RIGHT_EFFORT);
										}
										
									} else if (actualDailyEffort > (rulesMap
									        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS)
									        + rulesMap
									                .get(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS) - rulesMap
									            .get(IMobileAttendanceConstants.OVER_TIME_TOLERANCES)))
									{
										consolidatedTimeSheet
										        .setEffortResult(IMobileAttendanceConstants.OVER_TIME);
										consolidatedTimeSheet
										        .setOverTime(actualDailyEffort
										                - rulesMap
										                        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS));
										
									} else
									{
										consolidatedTimeSheet
										        .setEffortResult(IMobileAttendanceConstants.RIGHT_EFFORT);
									}
									logger.log(Level.INFO,
									        "-- UPDATING CONSOLIDATED TIMEHSEETS --");
									consolidatedTimeSheet
									        .setUpdatedBy("SYSTEM");
									consolidatedTimeSheet.setMarker("UPDATED");
								}// end-if - check if outTime > 0
							} else
							{
								// TODO: 11/25/2012 : Temp fix. Add if - else
								// logic
								
								if (consolidatedTimeSheet.getOutDateTime() == null)
								{
									
									consolidatedTimeSheet
									        .setOutTimeResult(IMobileAttendanceConstants.NA);
									consolidatedTimeSheet
									        .setEffortResult(IMobileAttendanceConstants.UNPAID_LEAVE);
									consolidatedTimeSheet.setMarker("NO_OUT_TIME");
								} else
								{
									consolidatedTimeSheet.setMarker("UPDATED");
								}
							}
							
							logger.log(
							        Level.INFO,
							        createDay
							                + ","
							                + employee.getKey().getId()
							                + ","
							                + consolidatedTimeSheet
							                        .getActualDailyEffort()
							                + ","
							                + consolidatedTimeSheet
							                        .getSecondsToHHMM());
							TimesheetDAO tsDAO = new TimesheetDAO();
							GlobalTransaction gtx = Datastore
							        .beginGlobalTransaction();
							tsDAO.setGtx(gtx);
							// Mark all the timesheets as processed
							// tsDAO.addModels(timsheetsToUpdate);
							
							for (Iterator iterator2 = timesheets.iterator(); iterator2
							        .hasNext();)
							{
								MA_Timesheet ma_Timesheet = (MA_Timesheet) iterator2
								        .next();
								tsDAO.addModel(ma_Timesheet);
							}
							
							tsDAO.addModel(consolidatedTimeSheet);
							gtx.commit();
							count++;
						}
					}// end-if Has Shift ended
				}// end-if check consolidated timesheet is not null
			}// end-if emplyoee-assignment not null
		}
		
		logger.log(Level.INFO, "updated consolidatedTimeSheet count--" + count);
		
		logger.log(Level.INFO,
		        "End updatePlannedAssignmentConsolidatedTimeSheet");
	}
	
	/**
	 * This method creates ConsolidatedTimeSheets after receing the IN time.s
	 * 
	 * @param companyId
	 * @param currentDate
	 */
	public void createPlannedAssignmentConsolidatedTimeSheet(Long companyId,
	        Calendar currentDate)
	{
		
		// try
		// {
		logger.log(Level.INFO,
		        "START createPlannedAssignmentConsolidatedTimeSheet company id="
		                + companyId);
		TimesheetDAO tsDAO = new TimesheetDAO();
		MA_Company company = new MA_Company();
		Key companykey = AbstractEntityDAO.createKey(company, companyId);
		company = service.getCompanyObj(companykey);
		
		logger.log(
		        Level.INFO,
		        "-- createPlannedAssignmentConsolidatedTimeSheet -- "
		                + company.getCompanyName() + " -- "
		                + company.getKey().getId() + " Nature of Company : "
		                + company.getTemplateRef().getKey());
		
		// This is avoid all the contracting companies
		if (company.getTemplateRef().getKey() != null)
		{
			
			// List<MA_Employee> employees = service
			// .getAllEmployeeForCompany(companyId);
			
			List<MA_Employee> employees = service
			        .getAllActiveEmployeesForCompany(companyId);
			
			// Contracting companies will be having any rules
			
			Map<String, Long> rulesMap = getTimesheetRulesMapOfCompany(companyId);
			
			Iterator<MA_Employee> empList = employees.iterator();
			logger.log(Level.INFO, "size of emp : " + employees.size());
			MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
			Integer createDay = currentDate.get(Calendar.DAY_OF_MONTH);
			Integer createMonth = currentDate.get(Calendar.MONTH);
			Integer createYear = currentDate.get(Calendar.YEAR);
			
			int noOfUnassignedEmployee = 0;
			int noOfNotReportedEmployee = 0;
			MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
			        .get();
			int count = 0;
			while (empList.hasNext())
			{
				int _day = 1;
				MA_Employee employee = empList.next();
				
				MA_Assignment employee_assignment = Datastore
				        .query(assignmentMeta)
				        .filter(assignmentMeta.employeeRef.equal(employee
				                .getKey()),
				                assignmentMeta.status.equal(CURRENT_ASSIGNMENT))
				        .asSingle();
				
				if (null == employee_assignment)
				{
					employee_assignment = Datastore
					        .query(assignmentMeta)
					        .filter(assignmentMeta.employeeRef.equal(employee
					                .getKey()),
					                assignmentMeta.status
					                        .equal(DEFAULT_ASSIGNMENT))
					        .asSingle();
				}
				
				MA_ConsolidatedTimesheet consolidatedTimeSheet = null;
				if (null != employee_assignment)
				{
					consolidatedTimeSheet = Datastore
					        .query(consolidatedTimesheetMeta)
					        .filter(consolidatedTimesheetMeta.assignmentRef.equal(employee_assignment
					                .getKey()),
					                consolidatedTimesheetMeta.createDay
					                        .equal(createDay),
					                consolidatedTimesheetMeta.createMonth
					                        .equal(createMonth),
					                consolidatedTimesheetMeta.createYear
					                        .equal(createYear)).asSingle();
				}
				
				boolean runJob = false;
				
				if (consolidatedTimeSheet == null)
				{
					runJob = true;
					consolidatedTimeSheet = new MA_ConsolidatedTimesheet();
				} else
				{
					if (consolidatedTimeSheet.getMarker().equalsIgnoreCase(
					        NOT_REPORTED))
					{
						runJob = true;
					}
				}
				
				if (runJob)
				{
					
					logger.log(Level.INFO, "First run of the batch job");
					consolidatedTimeSheet.setCreateDay(createDay);
					consolidatedTimeSheet.setCreateMonth(createMonth);
					consolidatedTimeSheet.setCreateYear(createYear);
					consolidatedTimeSheet.setApproved("N");
					consolidatedTimeSheet.setActualDailyEffort(new Double(0));
					consolidatedTimeSheet.setCreatedBy("SYSTEM");
					consolidatedTimeSheet.setCompanyId(companyId);
					
					// If employee has planned current assignment.
					// Dheeraj : added the OR condition for DEFAULT_ASSIGNMENT
					// Every employee will have a assignment
					
					MA_Shift shift = null;
					
					if (null != employee_assignment
					        && (employee_assignment.getStatus() == CURRENT_ASSIGNMENT | employee_assignment
					                .getStatus() == DEFAULT_ASSIGNMENT))
					{
						
						logger.log(Level.INFO, " Emp iD : "
						        + employee.getKey().getId()
						        + " Assignment Id : "
						        + employee_assignment.getKey().getId());
						consolidatedTimeSheet.getAssignmentRef().setModel(
						        employee_assignment);
						// shift = (shift == null) ? timesheet.getShiftRef()
						// .getModel() : shift;
						if (employee_assignment.getStatus() == CURRENT_ASSIGNMENT)
						{
							shift = employee_assignment.getShiftRef()
							        .getModel();
							
							// TODO : Run again till the middle of the shift
							// and do
							// not run for the shifts which have not yet started
							if (AssignmentHelper.hasShiftStarted(shift,
							        currentDate))
							{
								consolidatedTimeSheet.getShiftRef().setModel(
								        shift);
								
								List<MA_Timesheet> timesheets = getTimesheetsInADay(
								        employee_assignment.getKey(),
								        currentDate);
								
								logger.log(Level.INFO,
								        "CURRENT_ASSIGNMENT # Of timesheets found : "
								                + timesheets.size());
								
								if (null != timesheets && timesheets.size() > 0)
								{
									MA_Timesheet timesheet = timesheets.get(0);
									consolidatedTimeSheet
									        .setInDateTime(timesheet
									                .getInDateTime());
									if (rulesMap
									        .get(IMobileAttendanceConstants.FLEXIBEL_TIME) == 1)
									{
										consolidatedTimeSheet = fillConsolidatedTimesheetForINTime(
										        consolidatedTimeSheet, shift,
										        rulesMap);
									}// END-IF Flexible time
									timesheet.setCount(new Integer(1));
									consolidatedTimeSheet.setMarker("CURRENT");
									GlobalTransaction gtx = Datastore
									        .beginGlobalTransaction();
									tsDAO.setGtx(gtx);
									Key _tsheetKey = tsDAO.addModel(timesheet);
									Key _consolidatedTimeSheetKey = tsDAO
									        .addModel(consolidatedTimeSheet);
									gtx.commit();
								}// end-if timesheets are found
								else
								{
									consolidatedTimeSheet
									        .setMarker("NOT_REPORTED");
									GlobalTransaction gtx = Datastore
									        .beginGlobalTransaction();
									tsDAO.setGtx(gtx);
									tsDAO.addModel(consolidatedTimeSheet);
									gtx.commit();
									noOfNotReportedEmployee++;
								}
							}// end-if check if shift has started
						} else if (employee_assignment.getStatus() == DEFAULT_ASSIGNMENT)
						{
							noOfUnassignedEmployee++;
							List<MA_Timesheet> timesheets = getTimesheetsInADay(
							        employee_assignment.getKey(), currentDate);
							
							logger.log(Level.INFO,
							        "DEFAULT_ASSIGNMENT # Of timesheets found : "
							                + timesheets.size());
							
							if (null != timesheets && timesheets.size() > 0)
							{
								MA_Timesheet timesheet = timesheets.get(0);
								consolidatedTimeSheet.setInDateTime(timesheet
								        .getInDateTime());
								shift = (shift == null) ? timesheet
								        .getShiftRef().getModel() : shift;
								consolidatedTimeSheet.getShiftRef().setModel(
								        shift);
								if (null != shift)
								{
									
									fillConsolidatedTimesheetForINTime(
									        consolidatedTimeSheet, shift,
									        rulesMap);
									timesheet.setCount(new Integer(1));
									consolidatedTimeSheet.setMarker(CURRENT);
									GlobalTransaction gtx = Datastore
									        .beginGlobalTransaction();
									tsDAO.setGtx(gtx);
									tsDAO.addModel(timesheet);
									tsDAO.addModel(consolidatedTimeSheet);
									gtx.commit();
								} else
								{
									logger.log(
									        Level.FINEST,
									        "Shift Refrence is null for Default assignment Timesheet.This is an exception scneario.");
								}
							}// end-if timesheets found
							else
							{
								consolidatedTimeSheet.setMarker(NOT_REPORTED);
								GlobalTransaction gtx = Datastore
								        .beginGlobalTransaction();
								tsDAO.setGtx(gtx);
								tsDAO.addModel(consolidatedTimeSheet);
								gtx.commit();
								noOfNotReportedEmployee++;
								
							}// end else - no timesheets found
						}
					}
				}
			}
			
			logger.log(Level.INFO, company.getCompanyName()
			        + " unassignedcount=" + noOfUnassignedEmployee);
			
			MA_DashboardDataMeta dashboardDataMeta = MA_DashboardDataMeta.get();
			MA_DashboardData maDashBoard = Datastore
			        .query(dashboardDataMeta)
			        .filter(dashboardDataMeta.createDay.equal(createDay),
			                dashboardDataMeta.createMonth.equal(createMonth),
			                dashboardDataMeta.createYear.equal(createYear),
			                dashboardDataMeta.filterType
			                        .equal(IMobileAttendanceConstants.UNASSIGNED_EMPLOYEE_COUNT),
			                dashboardDataMeta.companyRef.equal(companykey))
			        .asSingle();
			if (null == maDashBoard)
			{
				maDashBoard = new MA_DashboardData();
			}
			
			maDashBoard
			        .setFilterType(IMobileAttendanceConstants.UNASSIGNED_EMPLOYEE_COUNT);
			maDashBoard.setCount(noOfUnassignedEmployee);
			maDashBoard.setCreateDay(createDay);
			maDashBoard.setCreateMonth(createMonth);
			maDashBoard.setCreateYear(createYear);
			maDashBoard.getCompanyRef().setModel(company);
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			tsDAO.setGtx(gtx);
			Key key = tsDAO.addModel(maDashBoard);
			gtx.commit();
			
			// 04/04/2012 Shailesh :Code to inser Not reported employee count in
			// Dashboard Entity.
			
			MA_DashboardData notReportedaDashBoard = Datastore
			        .query(dashboardDataMeta)
			        .filter(dashboardDataMeta.createDay.equal(createDay),
			                dashboardDataMeta.createMonth.equal(createMonth),
			                dashboardDataMeta.createYear.equal(createYear),
			                dashboardDataMeta.filterType
			                        .equal(IMobileAttendanceConstants.NOT_REPORTED_EMPLOYEE_COUNT),
			                dashboardDataMeta.companyRef.equal(companykey))
			        .asSingle();
			if (null == notReportedaDashBoard)
			{
				notReportedaDashBoard = new MA_DashboardData();
			}
			
			notReportedaDashBoard
			        .setFilterType(IMobileAttendanceConstants.NOT_REPORTED_EMPLOYEE_COUNT);
			notReportedaDashBoard.setCount(noOfNotReportedEmployee);
			notReportedaDashBoard.setCreateDay(createDay);
			notReportedaDashBoard.setCreateMonth(createMonth);
			notReportedaDashBoard.setCreateYear(createYear);
			notReportedaDashBoard.getCompanyRef().setModel(company);
			gtx = Datastore.beginGlobalTransaction();
			tsDAO.setGtx(gtx);
			Key key1 = tsDAO.addModel(notReportedaDashBoard);
			gtx.commit();
			logger.log(Level.INFO, "created consolidatedTimeSheet count--"
			        + count);
			logger.log(Level.INFO,
			        "END createPlannedAssignmentConsolidatedTimeSheet");
		}// end-if - omit contracting companies
	}
	
	/**
	 * 
	 * @param assignmentKey
	 * @param createDate
	 * @return
	 */
	private List<MA_Timesheet> getTimesheetsInADay(Key assignmentKey,
	        Calendar createDate)
	{
		
		MA_TimesheetMeta timesheetMeta = MA_TimesheetMeta.get();
		
		ModelQuery<MA_Timesheet> query = Datastore.query(MA_Timesheet.class);
		query.sort(new Sort("createdDate"));
		query.limit(1);
		List<MA_Timesheet> timesheets = query
		        .filter(timesheetMeta.assignmentRef.equal(assignmentKey),
		                timesheetMeta.createDay.equal(createDate
		                        .get(Calendar.DAY_OF_MONTH)),
		                timesheetMeta.createMonth.equal(createDate
		                        .get(Calendar.MONTH)),
		                timesheetMeta.createYear.equal(createDate
		                        .get(Calendar.YEAR))).asList();
		
		return timesheets;
	}
	
	/**
	 * This methods fill the consolidatedtimesheet for the IN data
	 * 
	 * @param consolidatedTimeSheet
	 * @param shift
	 * @param rulesMap
	 * @return
	 */
	private MA_ConsolidatedTimesheet fillConsolidatedTimesheetForINTime(
	        MA_ConsolidatedTimesheet consolidatedTimeSheet, MA_Shift shift,
	        Map<String, Long> rulesMap)
	{
		Calendar shiftStartTime = Calendar.getInstance();
		shiftStartTime.set(Calendar.HOUR_OF_DAY, shift.getStartHrs());
		shiftStartTime.set(Calendar.MINUTE, shift.getStartMin());
		shiftStartTime.set(Calendar.SECOND, 0);
		shiftStartTime.set(Calendar.MILLISECOND, 0);
		
		Long inTime = consolidatedTimeSheet.getInDateTime().getTime();
		
		Long lateMark = shiftStartTime.getTimeInMillis()
		        + (rulesMap.get(IMobileAttendanceConstants.LATE_MRK_TOLERANCE) * 1000);
		Long earlyIn = shiftStartTime.getTimeInMillis()
		        - (rulesMap.get(IMobileAttendanceConstants.EARLY_IN_TOLERANCE) * 1000);
		
		if (inTime >= earlyIn && inTime <= lateMark)
		{
			
			consolidatedTimeSheet
			        .setInTimeResult(IMobileAttendanceConstants.RIGHT_IN);
			
		} else if (inTime < earlyIn)
		{
			consolidatedTimeSheet
			        .setInTimeResult(IMobileAttendanceConstants.EARLY_IN);
		} else
		{
			consolidatedTimeSheet
			        .setInTimeResult(IMobileAttendanceConstants.LATE_IN);
		}
		
		return consolidatedTimeSheet;
	}
	
	/**
	 * This method prints the ConsolidatedTimeSheet for a given time period
	 * 
	 * @param companyId
	 * @param fromDtStr
	 * @param toDtStr
	 * @return
	 */
	public List<ConsolidatedTimeSheetDTO> getConsolidtaedTimeSheet(
	        Long companyId, String fromDtStr, String toDtStr, String empIdStr)
	        throws Exception
	{
		Date fromDate = DateUtil.toDate(fromDtStr, "MM/dd/yyyy");
		Calendar fromCal = Calendar.getInstance();
		fromCal.clear();
		fromCal.setTime(fromDate);
		
		List<MA_Employee> employees = null;
		List<MA_LocationHoliday> locationholidays = new ArrayList<MA_LocationHoliday>();
		
		EmployeeService businessService = new EmployeeService();
		if (empIdStr != null && !empIdStr.equals(""))
		{
			MA_Employee employee = businessService.getEmployeeObject(companyId,
			        empIdStr);
			employees = new ArrayList<MA_Employee>();
			employees.add(employee);
		} else
		{
			
			employees = businessService.getAllActiveEmployeeForCompany(
			        companyId, fromCal);
		}
		
		MA_Company company = new MA_Company();
		Key companykey = AbstractEntityDAO.createKey(company, companyId);
		company = service.getCompanyObj(companykey);
		
		// @TOD Temp fix for Testing TimeZone
		
		TimeZone _localTimeZone = TimeZone.getDefault();
		
		Date toDate = DateUtil.toDate(toDtStr, "MM/dd/yyyy");
		
		Calendar cal = DateUtil.toCalendar(toDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		toDate = new Date(cal.getTimeInMillis());
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		LocationBusinessService locationService = new LocationBusinessService();
		List<ConsolidatedTimeSheetDTO> consolidatedTimeSheetDTOs = new ArrayList<ConsolidatedTimeSheetDTO>();
		
		Iterator<MA_Employee> empList = employees.iterator();
		
		while (empList.hasNext())
		{
			logger.log(Level.INFO, "  1st While  ");
			MA_Employee employee = empList.next();
			
			Map<Date, String> locationholidayMap = new HashMap<Date, String>();
			
			// Get weekly off. This is delimited by ;
			String _weeklyOff = employee.getDayOfWeeklyOff();
			
			logger.log(Level.INFO, " Employye Weekly off = " + _weeklyOff);
			// Convert it into Array
			StringTokenizer _st = new StringTokenizer(_weeklyOff, ",");
			ArrayList<Integer> _weeklyOffs = new ArrayList<Integer>();
			
			while (_st.hasMoreElements())
			{
				String _wklyOff = (String) _st.nextElement();
				_weeklyOffs.add(new Integer(_wklyOff));
			}
			
			logger.log(Level.INFO, " Employye Weekly off  Array size= "
			        + _weeklyOffs.size());
			
			String employeeName = employee.getFirstName() + "  "
			        + employee.getLastName();
			Long employeeId = employee.getKey().getId();
			String employeeGender = employee.getGender();
			
			String companyEmpId = employee.getCompanyEmpId();
			List<MA_Assignment> employee_assignments = Datastore
			        .query(assignmentMeta)
			        .filter(assignmentMeta.employeeRef.equal(employee.getKey()),
			                assignmentMeta.endDate.greaterThanOrEqual(fromDate))
			        .asList();
			
			readCounter += employee_assignments.size();
			
			Iterator<MA_Assignment> assignmentIterator = employee_assignments
			        .iterator();
			
			while (assignmentIterator.hasNext())
			{
				
				MA_Assignment assignment = assignmentIterator.next();
				
				logger.log(Level.INFO,
				        "  2nd While   Assignemnt Id = assignment id "
				                + assignment.getKey().getId());
				if (assignment.getStatus() != FUTURE_ASSIGNMENT)
				{
					
					logger.log(Level.INFO, "assignment.getShiftRef()"
					        + assignment.getShiftRef());
					MA_Shift shift = null;
					if (null != assignment.getShiftRef())
					{
						shift = assignment.getShiftRef().refresh();
					}
					
					// Get Location and TimeZones
					MA_Location _location = null;
					_location = (shift == null) ? null : shift.getLocationRef()
					        .refresh();
					if (_location != null)
					{
						locationholidays = locationService
						        .getLocationHolidays(_location.getKey().getId());
						
						Iterator<MA_LocationHoliday> holidayItr = locationholidays
						        .iterator();
						
						while (holidayItr.hasNext())
						{
							MA_LocationHoliday holiday = holidayItr.next();
							
							locationholidayMap.put(
							        holiday.getLocationHolidayDate(),
							        holiday.getLocationHolidayDesc());
							
						}
					}
					
					_localTimeZone = (_location == null) ? TimeZone
					        .getDefault() : TimeZone.getTimeZone(_location
					        .getTimeZone());
					
					String assignmentShiftName = (shift == null) ? "-" : shift
					        .getShiftName();
					String locationName = (shift == null) ? "-" : shift
					        .getLocationRef().getModel().getLocationName();
					List<MA_ConsolidatedTimesheet> consolidatedTimesheets = Datastore
					        .query(consolidatedTimesheetMeta)
					        .filter(consolidatedTimesheetMeta.assignmentRef.equal(assignment
					                .getKey()),
					                consolidatedTimesheetMeta.createdDate
					                        .greaterThanOrEqual(fromDate))
					        // consolidatedTimesheetMeta.marker.equal("UPDATED"))
					        // // Dj - no need to restricted only updated,
					        .asList();
					
					logger.log(Level.INFO, "consolidatedTimesheets size"
					        + consolidatedTimesheets.size());
					readCounter += consolidatedTimesheets.size();
					
					Iterator<MA_ConsolidatedTimesheet> timesheetIterator = consolidatedTimesheets
					        .iterator();
					while (timesheetIterator.hasNext())
					{
						
						MA_ConsolidatedTimesheet consolidatedTimesheet = timesheetIterator
						        .next();
						if (consolidatedTimesheet.getCreatedDate().compareTo(
						        toDate) <= 0)
						{
							logger.log(Level.INFO,
							        "Consolidated Timesheet Id = "
							                + consolidatedTimesheet.getKey()
							                        .getId());
							ConsolidatedTimeSheetDTO timeSheetDTO = new ConsolidatedTimeSheetDTO();
							timeSheetDTO.setEmployeeId(employeeId);
							timeSheetDTO.setEmployeeName(employeeName);
							timeSheetDTO
							        .setActualEffort(getSecondsToHHMM(consolidatedTimesheet
							                .getActualDailyEffort()));
							timeSheetDTO
							        .setDailyEffort(getSecondsToHHMM(consolidatedTimesheet
							                .getDailyEffort()));
							timeSheetDTO
							        .setOverTime(getSecondsToHHMM(consolidatedTimesheet
							                .getOverTime()));
							timeSheetDTO.setInTimeResult(consolidatedTimesheet
							        .getInTimeResult());
							timeSheetDTO.setOutTimeResult(consolidatedTimesheet
							        .getOutTimeResult());
							timeSheetDTO.setEffortResult(consolidatedTimesheet
							        .getEffortResult());
							timeSheetDTO.setTimesheetId(consolidatedTimesheet
							        .getKey().getId());
							timeSheetDTO.setApproved(consolidatedTimesheet
							        .getApproved());
							timeSheetDTO
							        .setApprovalResult(consolidatedTimesheet
							                .getApprovalResult());
							
							Calendar _cCreated = Calendar
							        .getInstance(_localTimeZone);
							
							if (null != consolidatedTimesheet.getCreatedDate())
							{
								_cCreated.setTimeInMillis(consolidatedTimesheet
								        .getCreatedDate().getTime());
								_cCreated.setTimeZone(_localTimeZone);
								
								timeSheetDTO.setCreatedDate(DateUtil.toString(
								        _cCreated.getTime(), "MMM-dd-yyyy"));
								
							}
							
							String shiftName = null;
							
							// 03/20/2012 Shailesh:This is a fix to
							// show location and shift name of report.
							logger.log(Level.INFO, "assignmentShiftName = "
							        + assignmentShiftName);
							if (assignmentShiftName.equals("-"))
							{
								logger.log(Level.INFO,
								        "consolidatedTimesheet.getShiftRef.getModel = "
								                + consolidatedTimesheet
								                        .getShiftRef()
								                        .getModel());
								
								if (consolidatedTimesheet.getShiftRef()
								        .getModel() != null)
								{
									shift = consolidatedTimesheet.getShiftRef()
									        .getModel();
									logger.log(Level.INFO, "Shift Id = "
									        + shift.getKey().getId());
									shiftName = shift.getShiftName();
									_location = shift.getLocationRef()
									        .refresh();
									locationName = _location.getLocationName();
									
									_localTimeZone = TimeZone
									        .getTimeZone(_location
									                .getTimeZone());
								} else
								{
									shiftName = "-";
									locationName = "-";
								}
								
							} else
							{
								shiftName = assignmentShiftName;
							}
							timeSheetDTO.setLocationName(locationName);
							timeSheetDTO.setShiftName(shiftName);
							timeSheetDTO.setCompanyEmpId(companyEmpId);
							Calendar _cIn = Calendar
							        .getInstance(_localTimeZone);
							
							logger.log(
							        Level.INFO,
							        "consolidatedTimesheet.getInDateTime = "
							                + consolidatedTimesheet
							                        .getInDateTime());
							if (consolidatedTimesheet.getInDateTime() != null)
							{
								
								_cIn.setTimeInMillis(consolidatedTimesheet
								        .getInDateTime().getTime());
								_cIn.setTimeZone(_localTimeZone);
								
								timeSheetDTO
								        .setInTime(DateUtil.toString(
								                _cIn.getTime(),
								                "MMM-dd-yyyy  hh:mm a"));
								timeSheetDTO.setInTimeDayOfWeek(DateUtil
								        .toString(_cIn.getTime(), "EEE"));
								timeSheetDTO.setOutTimeDayOfWeek(DateUtil
								        .toString(_cIn.getTime(), "EEE"));
							} else
							{
								
								timeSheetDTO.setInTime("-");
								timeSheetDTO.setInTimeDayOfWeek("-");
								timeSheetDTO.setOutTimeDayOfWeek("-");
								timeSheetDTO
								        .setEffortResult(IMobileAttendanceConstants.UNPAID_LEAVE);
							}
							
							logger.log(
							        Level.INFO,
							        "consolidatedTimesheet.getOutDateTime = "
							                + consolidatedTimesheet
							                        .getOutDateTime());
							
							if (consolidatedTimesheet.getOutDateTime() != null)
							{
								Calendar _cOut = Calendar
								        .getInstance(_localTimeZone);
								_cOut.setTimeInMillis(consolidatedTimesheet
								        .getOutDateTime().getTime());
								_cOut.setTimeZone(_localTimeZone);
								timeSheetDTO
								        .setOutTime(DateUtil.toString(
								                _cOut.getTime(),
								                "MMM-dd-yyyy  hh:mm a"));
							} else
							{
								
								timeSheetDTO.setOutTime("-");
								
								if (consolidatedTimesheet.getInDateTime() != null)
								{
									timeSheetDTO
									        .setInTimeResult(IMobileAttendanceConstants.NA);
									timeSheetDTO
									        .setEffortResult(IMobileAttendanceConstants.NO_OUT_TIME);
								}
								
							}
							
							Integer _dayOfWeek = new Integer(
							        _cCreated.get(Calendar.DAY_OF_WEEK)) - 1;
							
							logger.log(Level.INFO, " Employye Weekly off = "
							        + _weeklyOff + " Day of the week = "
							        + _dayOfWeek);
							
							if (_weeklyOffs.contains(_dayOfWeek))
							{
								timeSheetDTO.setWeeklyOff(true);
								timeSheetDTO
								        .setEffortResult(IMobileAttendanceConstants.WEEKLY_OFF);
								logger.log(Level.INFO, "Weekly off = true");
							} else
							{
								timeSheetDTO.setWeeklyOff(false);
								logger.log(Level.INFO, "Weekly off = false");
							}
							
							String _holidayDesc = "Working Day";
							timeSheetDTO.setHolidayDesc(_holidayDesc);
							timeSheetDTO.setHoliday(false);
							logger.log(Level.INFO, "Location = " + _location);
							if (_location != null)
							{
								Calendar currentDate = Calendar.getInstance();
								currentDate.clear();
								currentDate.set(Calendar.DATE,
								        consolidatedTimesheet.getCreateDay());
								currentDate.set(Calendar.MONTH,
								        consolidatedTimesheet.getCreateMonth());
								currentDate.set(Calendar.YEAR,
								        consolidatedTimesheet.getCreateYear());
								
								_holidayDesc = locationholidayMap
								        .get(currentDate.getTime());
								
								logger.log(Level.INFO, "_holidayDesc="
								        + _holidayDesc);
								if (_holidayDesc != null)
								{
									timeSheetDTO.setHoliday(true);
									timeSheetDTO
									        .setEffortResult(IMobileAttendanceConstants.lOCATION_HOLIDAY);
									timeSheetDTO.setHolidayDesc(_holidayDesc);
								} else
								{
									timeSheetDTO.setHoliday(false);
									if (timeSheetDTO.isWeeklyOff())
									{
										timeSheetDTO
										
										.setHolidayDesc("Weekly Off");
										
										logger.log(Level.INFO,
										        "Set _holidayDesc=Weekly Off");
									}
								}
							} else
							{
								timeSheetDTO.setHoliday(false);
							}
							
							logger.log(Level.INFO, "Holiday desc final value= "
							        + timeSheetDTO.getHolidayDesc());
							
							consolidatedTimeSheetDTOs.add(timeSheetDTO);
							
						}
						
					}// 145108
					
				}
			}// Assignemnt iterator loop end
		}// Employee iterator loop end
		
		return consolidatedTimeSheetDTOs;
		
	}
	
	/**
	 * @param companyId
	 * @param fromDtStr
	 * @return
	 */
	public List<PeriodicTimeSheet> getMonthlyTimeSheet(Long companyId,
	        String fromDtStr)
	{
		logger.log(Level.INFO, "Start getMonthlyTimeSheet");
		List<MA_Employee> employees = service
		        .getAllEmployeeForCompany(companyId);
		MA_Company company = new MA_Company();
		Key companykey = AbstractEntityDAO.createKey(company, companyId);
		company = service.getCompanyObj(companykey);
		Date fromDate = DateUtil.toDate(fromDtStr, "MM/dd/yyyy");
		Calendar cal = DateUtil.toCalendar(fromDate);
		
		int nofOfDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		cal.add(Calendar.DAY_OF_MONTH, nofOfDaysInMonth);
		
		Date toDate = new Date(cal.getTimeInMillis());
		
		logger.log(Level.INFO, "To date=" + toDate.toGMTString());
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		
		List<PeriodicTimeSheet> employeePeriodicTimeSheets = new ArrayList<PeriodicTimeSheet>();
		
		Iterator<MA_Employee> iterator = employees.iterator();
		
		logger.log(Level.INFO, "No of Employees=" + employees.size());
		
		logger.log(Level.INFO, "No of days in Month=" + nofOfDaysInMonth);
		
		while (iterator.hasNext())
		{
			MA_Employee employee = iterator.next();
			
			PeriodicTimeSheet periodicTimesheet = new PeriodicTimeSheet();
			
			List<TimeSheetDTO> timesheets = new ArrayList<TimeSheetDTO>();
			
			for (int cnt = 0; cnt < nofOfDaysInMonth; cnt++)
			{
				TimeSheetDTO timeSheetDTO = new TimeSheetDTO();
				timeSheetDTO.setResult("INACTIVE");
				timesheets.add(timeSheetDTO);
			}
			periodicTimesheet.setTimsheetList(timesheets);
			
			String employeeName = employee.getFirstName() + "  "
			        + employee.getLastName();
			Long employeeId = employee.getKey().getId();
			periodicTimesheet.setEmployeeId(employeeId);
			periodicTimesheet.setEmployeeName(employeeName);
			List<MA_Assignment> employee_assignments = Datastore
			        .query(assignmentMeta)
			        .filter(assignmentMeta.employeeRef.equal(employee.getKey()),
			                assignmentMeta.endDate.greaterThanOrEqual(fromDate))
			        .asList();
			logger.log(Level.INFO,
			        "No of Assignemnts=" + employee_assignments.size());
			Iterator<MA_Assignment> assignmentIterator = employee_assignments
			        .iterator();
			
			while (assignmentIterator.hasNext())
			{
				MA_Assignment assignment = assignmentIterator.next();
				
				logger.log(Level.INFO,
				        "Assignemnts Status=" + assignment.getStatus());
				if (assignment.getStatus() != FUTURE_ASSIGNMENT)
				{
					
					List<MA_ConsolidatedTimesheet> consolidatedTimesheets = Datastore
					        .query(consolidatedTimesheetMeta)
					        .filter(consolidatedTimesheetMeta.assignmentRef.equal(assignment
					                .getKey()),
					                consolidatedTimesheetMeta.createdDate
					                        .greaterThanOrEqual(fromDate))
					        .asList();
					logger.log(Level.INFO, "No of consolidatedTimesheets="
					        + consolidatedTimesheets.size());
					readCounter += consolidatedTimesheets.size();
					
					Iterator<MA_ConsolidatedTimesheet> timesheetIterator = consolidatedTimesheets
					        .iterator();
					while (timesheetIterator.hasNext())
					{
						MA_ConsolidatedTimesheet consolidatedTimesheet = timesheetIterator
						        .next();
						if (consolidatedTimesheet.getCreatedDate().compareTo(
						        toDate) <= 0)
						{
							TimeSheetDTO timeSheetDTO = periodicTimesheet
							        .getTimsheetList().get(
							                consolidatedTimesheet
							                        .getCreateDay() - 1);
							timeSheetDTO.setEffort(consolidatedTimesheet
							        .getSecondsToHHMM());
							// String[] arr = consolidatedTimesheet
							// .getTimesheetRuleResult().split(",");
							// timeSheetDTO.setResult(arr[2]);
							logger.log(
							        Level.INFO,
							        "Consolidated Timesheet Resulte="
							                + consolidatedTimesheet
							                        .getTimesheetRuleResult());
						}
						
					}
					
				}
			}
			
			employeePeriodicTimeSheets.add(periodicTimesheet);
		}
		logger.log(Level.INFO, "End getMonthlyTimeSheet");
		return employeePeriodicTimeSheets;
		
	}
	
	/**
	 * @param time
	 * @return
	 */
	public String getSecondsToHHMM(Double time)
	{
		String secondsToHHMM = "-";
		if (time != null)
		{
			int hours = (int) (time / 3600);
			int minutes = (int) ((time % 3600) / 60);
			String minutesStr = (minutes < 10 ? "0" : "") + minutes;
			String hoursStr = (hours < 10 ? "0" : "") + hours;
			secondsToHHMM = (hoursStr + "'" + minutesStr + "''");
		}
		
		return secondsToHHMM;
	}
	
	/**
	 * 
	 */
	public void displayDbCounters()
	{
		
		AbstractEntityDAO.readCounter += readCounter;
		AbstractEntityDAO.writeCounter += writeCounter;
		
		logger.log(Level.INFO, "-- TimeSheetBusinessService Read Counter -- "
		        + AbstractEntityDAO.readCounter);
		logger.log(Level.INFO, "-- TimeSheetBusinessService Write Counter -- "
		        + AbstractEntityDAO.writeCounter);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.ITimeSheetBusinessService#approveTimesheets(java
	 * .lang.Long, java.lang.String[], java.lang.String[])
	 */
	public void approveTimesheets(Long companyId, String[] timesheetIds,
	        String[] billableEffort)
	{
		
		logger.log(Level.INFO, "Start approveTimesheets");
		Map<String, Long> rulesMap = getTimesheetRulesMapOfCompany(companyId);
		
		// TODO : Need urgent remidiation. This mindailyEffort must come from
		// shoft
		// Long mindailyEffort = rulesMap
		// .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS);
		
		Long halfDay = rulesMap
		        .get(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS);
		Long overTimeEffort = rulesMap
		        .get(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS);
		
		// Long totalOverTimeEffort = mindailyEffort + overTimeEffort;
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		
		for (int cnt = 0; cnt < timesheetIds.length; cnt++)
		{
			Long timesheetId = Long.valueOf(timesheetIds[cnt]);
			Long effort = Long.valueOf(billableEffort[cnt]);
			Key k1 = Datastore.createKey(MA_ConsolidatedTimesheet.class,
			        timesheetId);
			MA_ConsolidatedTimesheet consolidatedTimesheet = Datastore
			        .query(consolidatedTimesheetMeta)
			        .filter(consolidatedTimesheetMeta.key.equal(k1)).asSingle();
			
			MA_Shift shift = consolidatedTimesheet.getShiftRef().getModel();
			
			// At this point the shift is still depicts local time.
			/*
			 * Calendar shiftStartTime = Calendar.getInstance();
			 * shiftStartTime.set(Calendar.HOUR_OF_DAY, shift.getStartHrs());
			 * shiftStartTime.set(Calendar.MINUTE, shift.getStartMin());
			 * shiftStartTime.set(Calendar.SECOND, 0);
			 * shiftStartTime.set(Calendar.MILLISECOND, 0);
			 * 
			 * Calendar shiftEndTime = DateUtil.clearTimePart(Calendar
			 * .getInstance()); shiftEndTime.set(Calendar.HOUR_OF_DAY,
			 * shift.getEndHrs()); shiftEndTime.set(Calendar.MINUTE,
			 * shift.getEndMin()); shiftEndTime.set(Calendar.SECOND, 0);
			 * shiftEndTime.set(Calendar.MILLISECOND, 0);
			 */
			
			// Long mindailyEffort = (shiftEndTime.getTimeInMillis() -
			// shiftStartTime
			// .getTimeInMillis()) / 1000;
			
			Long mindailyEffort = rulesMap
			        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS);
			
			Long totalOverTimeEffort = mindailyEffort + overTimeEffort;
			
			logger.log(Level.INFO, "Timesheet Id =" + timesheetId
			        + " effort=  " + effort);
			if (effort == 5 || effort == 6)
			{
				consolidatedTimesheet.setBillableEfforts(new Double(0));
				if (effort == 5)
				{
					consolidatedTimesheet.setApprovalResult("UNPAID LEAVE");
				} else if (effort == 11)
				{
					consolidatedTimesheet.setApprovalResult("PAID LEAVE");
				} else if (effort == 12)
				{
					consolidatedTimesheet.setApprovalResult("COMP-OFF");
				} else if (effort == 13)
				{
					consolidatedTimesheet
					        .setBillableEfforts(new Double(halfDay));
					consolidatedTimesheet.setApprovalResult("CASUAL LEAVE");
				} else if (effort == 14)
				{
					consolidatedTimesheet.setApprovalResult("WEEKLY OFF");
				} else if (effort == 15)
				{
					consolidatedTimesheet.setApprovalResult("LOCATION HOLIDAY");
				} else
				{
					consolidatedTimesheet.setApprovalResult("UNRESOLVED");
				}
			} else if (effort == 1)
			{
				consolidatedTimesheet.setBillableEfforts(new Double(
				        mindailyEffort));
				consolidatedTimesheet.setApprovalResult("FULL DAY");
			} else if (effort == 3)
			{
				consolidatedTimesheet.setBillableEfforts(new Double(
				        totalOverTimeEffort));
				consolidatedTimesheet.setApprovalResult("OVER TIME");
			} else if (effort == 4)
			{
				consolidatedTimesheet.setBillableEfforts(new Double(halfDay));
				consolidatedTimesheet.setApprovalResult("HALF DAY");
			}
			consolidatedTimesheet.setApproved("Y");
			
			TimesheetDAO tsDAO = new TimesheetDAO();
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			tsDAO.setGtx(gtx);
			tsDAO.addModel(consolidatedTimesheet);
			gtx.commit();
			
		}
		logger.log(Level.INFO, "End approveTimesheets");
	}
	
	/**
	 * This method return true is the the Company has planned assignments
	 */
	public boolean hasPlannedAssignment(Long companyId)
	{
		boolean hasPlannedAssignment = false;
		
		MA_TimeSheetRuleMeta timeSheetRuleMeta = MA_TimeSheetRuleMeta.get();
		MA_Company company = new MA_Company();
		Key k1 = AbstractEntityDAO.createKey(company, companyId);
		
		MA_TimeSheetRule timeSheetRule = Datastore
		        .query(timeSheetRuleMeta)
		        .filter(timeSheetRuleMeta.companyRef.equal(k1),
		                timeSheetRuleMeta.ruleKey
		                        .equal(IMobileAttendanceConstants.PLANNED_ASSIGNMENT))
		        .asSingle();
		
		if (timeSheetRule == null)
		{
			
		} else if (timeSheetRule.getValue().longValue() == PLANNED_ASSIGNMENTS)
		{
			hasPlannedAssignment = true;
		}
		
		return hasPlannedAssignment;
	}
	
	/**
	 * 
	 * @param companyId
	 * @param startDate
	 * @return
	 */
	public List<PeriodicTimeSheet> getEmployeeTimeCard(Long companyId,
	        String startDate)
	{
		EmployeeService businessService = new EmployeeService();
		
		MA_Company company = new MA_Company();
		Key companykey = AbstractEntityDAO.createKey(company, companyId);
		company = service.getCompanyObj(companykey);
		Date fromDate = DateUtil.toDate(startDate, "MM/dd/yyyy");
		Calendar cal = DateUtil.toCalendar(fromDate);
		
		int month = cal.get(Calendar.MONTH);
		int nofOfDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		cal.add(Calendar.DAY_OF_MONTH, nofOfDaysInMonth);
		
		List<MA_Employee> employees = businessService
		        .getAllActiveEmployeeForCompany(companyId, cal);
		
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		
		List<PeriodicTimeSheet> employeePeriodicTimeSheets = new ArrayList<PeriodicTimeSheet>();
		
		Iterator<MA_Employee> iterator = employees.iterator();
		
		while (iterator.hasNext())
		{
			MA_Employee employee = iterator.next();
			
			PeriodicTimeSheet periodicTimesheet = new PeriodicTimeSheet();
			
			List<TimeSheetDTO> timesheets = new ArrayList<TimeSheetDTO>();
			
			for (int cnt = 0; cnt < nofOfDaysInMonth; cnt++)
			{
				TimeSheetDTO timeSheetDTO = new TimeSheetDTO();
				timeSheetDTO.setResult("INACTIVE");
				timesheets.add(timeSheetDTO);
			}
			periodicTimesheet.setTimsheetList(timesheets);
			
			String employeeName = employee.getFirstName() + "  "
			        + employee.getLastName();
			Long employeeId = employee.getKey().getId();
			periodicTimesheet.setEmployeeId(employeeId);
			periodicTimesheet.setEmployeeName(employeeName);
			
			List<MA_Assignment> employee_assignments = Datastore
			        .query(assignmentMeta)
			        .filter(assignmentMeta.employeeRef.equal(employee.getKey()),
			                assignmentMeta.endDate.greaterThanOrEqual(fromDate),
			                assignmentMeta.endDate.lessThan(cal.getTime()))
			        .asList();
			Iterator<MA_Assignment> assignmentIterator = employee_assignments
			        .iterator();
			
			while (assignmentIterator.hasNext())
			{
				MA_Assignment assignment = assignmentIterator.next();
				
				if (assignment.getStatus() != FUTURE_ASSIGNMENT)
				{
					List<MA_ConsolidatedTimesheet> consolidatedTimesheets = Datastore
					        .query(consolidatedTimesheetMeta)
					        .filter(consolidatedTimesheetMeta.assignmentRef.equal(assignment
					                .getKey()),
					                consolidatedTimesheetMeta.createMonth
					                        .equal(month)).asList();
					logger.log(Level.INFO, "No of consolidatedTimesheets="
					        + consolidatedTimesheets.size());
					readCounter += consolidatedTimesheets.size();
					
					Iterator<MA_ConsolidatedTimesheet> timesheetIterator = consolidatedTimesheets
					        .iterator();
					while (timesheetIterator.hasNext())
					{
						MA_ConsolidatedTimesheet consolidatedTimesheet = timesheetIterator
						        .next();
						
						TimeSheetDTO timeSheetDTO = periodicTimesheet
						        .getTimsheetList()
						        .get(consolidatedTimesheet.getCreateDay() - 1);
						timeSheetDTO.setEffort(consolidatedTimesheet
						        .getSecondsToHHMM());
						// String[] arr = consolidatedTimesheet
						// .getTimesheetRuleResult().split(",");
						// timeSheetDTO.setResult(arr[2]);
						logger.log(
						        Level.INFO,
						        "Consolidated Timesheet Resulte="
						                + consolidatedTimesheet
						                        .getTimesheetRuleResult());
					}
					
				}
				
			}
			
			employeePeriodicTimeSheets.add(periodicTimesheet);
			
		}
		
		return employeePeriodicTimeSheets;
	}
	
	/**
	 * @param companyId
	 * @param timesheetIds
	 * @param billableEffort
	 */
	public void approveConsolidatedTimesheets(Long companyId,
	        Map<String, String> approveMap)
	{
		
		logger.log(Level.INFO, "Start approveTimesheets");
		Map<String, Long> rulesMap = getTimesheetRulesMapOfCompany(companyId);
		
		Long halfDay = rulesMap
		        .get(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS);
		Long overTimeEffort = rulesMap
		        .get(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS);
		
		// Long totalOverTimeEffort = mindailyEffort + overTimeEffort;
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		logger.log(Level.INFO, "----Timesheet Id =" + approveMap.size());
		
		Iterator<Entry<String, String>> itr1 = approveMap.entrySet().iterator();
		
		while (itr1.hasNext())
		{
			Entry<String, String> s = itr1.next();
			
			Long timesheetId = Long.valueOf(s.getKey());
			Long effort = Long.valueOf(s.getValue());
			Key k1 = Datastore.createKey(MA_ConsolidatedTimesheet.class,
			        timesheetId);
			MA_ConsolidatedTimesheet consolidatedTimesheet = Datastore
			        .query(consolidatedTimesheetMeta)
			        .filter(consolidatedTimesheetMeta.key.equal(k1)).asSingle();
			
			MA_Shift shift = consolidatedTimesheet.getShiftRef().getModel();
			
			Long mindailyEffort = rulesMap
			        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS);
			
			Long totalOverTimeEffort = mindailyEffort + overTimeEffort;
			
			logger.log(Level.INFO, "----Timesheet Id =" + timesheetId
			        + " effort=  " + effort + "----");
			double billableEfforts = 0;
			
			String approvedResult = "UNRESOLVED";
			switch (effort.intValue())
			{
				case 1:
					billableEfforts = new Double(mindailyEffort);
					approvedResult = "FULL DAY";
					break;
				case 2:
					billableEfforts = new Double(halfDay);
					approvedResult = "HALF DAY";
					break;
				case 3:
					billableEfforts = new Double(totalOverTimeEffort);
					approvedResult = "OVER TIME";
					break;
				case 4:
					billableEfforts = new Double(halfDay);
					approvedResult = "HALF DAY";
					break;
				case 5:
					approvedResult = "UNPAID LEAVE";
					break;
				case 6:
					approvedResult = "UNRESOLVED";
					break;
				case 11:
					approvedResult = "PAID LEAVE";
					break;
				case 12:
					approvedResult = "COMP-OFF";
					break;
				case 13:
					approvedResult = "CASUAL LEAVE";
					break;
				case 14:
					approvedResult = "WEEKLY OFF";
					break;
				case 15:
					approvedResult = "LOCATION HOLIDAY";
					break;
				default:
					approvedResult = "UNRESOLVED";
					break;
			
			}
			consolidatedTimesheet.setBillableEfforts(billableEfforts);
			consolidatedTimesheet.setApprovalResult(approvedResult);
			consolidatedTimesheet.setApproved("Y");
			
			TimesheetDAO tsDAO = new TimesheetDAO();
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			tsDAO.setGtx(gtx);
			tsDAO.addModel(consolidatedTimesheet);
			gtx.commit();
			
		}
		logger.log(Level.INFO, "End approveTimesheets");
	}
	
	/**
	 * 
	 * 
	 * @param companyId
	 * @param cal
	 * @param model
	 * @return
	 */
	public List<MA_ConsolidatedTimesheet> getConsolidatedTimeSheetrByMarker(
	        Calendar cal, MA_Shift model, String marker)
	{
		logger.log(Level.INFO, "Start getConsolidatedTimeSheetrByMarker");
		int createDay = cal.get(Calendar.DATE);
		int createMonth = cal.get(Calendar.MONTH);
		int createYear = cal.get(Calendar.YEAR);
		
		MA_ConsolidatedTimesheetMeta c = new MA_ConsolidatedTimesheetMeta();
		
		List<MA_ConsolidatedTimesheet> consolidatedList = Datastore
		        .query(c)
		        .filter(c.createDay.equal(createDay),
		                c.createMonth.equal(createMonth),
		                c.createYear.equal(createYear),
		                c.shiftRef.equal(model.getKey()),
		                c.marker.equal(marker)).asList();
		
		logger.log(Level.INFO, "End getConsolidatedTimeSheetrByMarker");
		return consolidatedList;
	}
	
	/**
	 * @param consolidatedtimesheetList
	 * @return
	 */
	public List<MA_ConsolidatedTimesheet> getFemaleEmployeeTimesheet(
	        List<MA_ConsolidatedTimesheet> consolidatedtimesheetList)
	{
		logger.log(Level.INFO, "Start getFemaleEmployeeTimesheet");
		List<MA_ConsolidatedTimesheet> list = new ArrayList<MA_ConsolidatedTimesheet>();
		
		for (MA_ConsolidatedTimesheet timesheet : consolidatedtimesheetList)
		{
			
			MA_Employee employee = timesheet.getAssignmentRef().getModel()
			        .getEmployeeRef().getModel();
			
			if (employee.getGender().equals("F"))
			{
				list.add(timesheet);
			}
			
		}
		logger.log(Level.INFO, "End getFemaleEmployeeTimesheet");
		return list;
	}
}
