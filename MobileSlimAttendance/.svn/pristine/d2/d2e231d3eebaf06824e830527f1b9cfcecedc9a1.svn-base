package com.adviteya.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.datastore.ModelQuery;
import org.slim3.datastore.Sort;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.LocationDTO;
import com.adviteya.dto.LocationDashboardReportDTO;
import com.adviteya.dto.ShiftDashboardReportDTO;
import com.adviteya.dto.reports.DepartmentDashboardDTO;
import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.meta.MA_ConsolidatedTimesheetMeta;
import com.adviteya.meta.MA_DashboardDataMeta;
import com.adviteya.meta.MA_LocationMeta;
import com.adviteya.meta.MA_ShiftMeta;
import com.adviteya.meta.MA_TimesheetMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_ConsolidatedTimesheet;
import com.adviteya.model.MA_DashboardData;
import com.adviteya.model.MA_Department;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.util.AssignmentHelper;
import com.google.appengine.api.datastore.Key;

public class DashboardBusinessService implements IDashBoardBusinessService
{
	private static Logger logger        = Logger.getLogger(DashboardBusinessService.class
	                                            .getName());
	private EntityService entityService = EntityService.getInstance();
	
	/**
	 * This method calculates the dashboard data after the shift has started
	 * 
	 * @param companyId
	 * @return
	 */
	public int calculateAndUpdateInTimeDetailsForCurrentShift(Long companyId)
	{
		
		logger.log(Level.INFO,
		        "Start calculateAndUpdateInTimeDetailsForCurrentShift");
		List<MA_Location> locationList = entityService
		        .getAllLocationForCompany(companyId);
		Iterator locationIterator = locationList.iterator();
		
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		Calendar currentDateTime = Calendar.getInstance();
		Integer createDay = currentDateTime.get(Calendar.DAY_OF_MONTH);
		Integer createMonth = currentDateTime.get(Calendar.MONTH);
		Integer createYear = currentDateTime.get(Calendar.YEAR);
		MA_DashboardDataMeta dashboardDataMeta = MA_DashboardDataMeta.get();
		List<String> filterTypes = new ArrayList<String>();
		filterTypes.add(IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT);
		filterTypes.add(IMobileAttendanceConstants.RIGHT_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.RIGHT_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT);
		AssignmentHelper helper = new AssignmentHelper();
		while (locationIterator.hasNext())
		{
			MA_Location location = (MA_Location) locationIterator.next();
			Long locationId = location.getKey().getId();
			List<MA_Shift> shiftList = entityService
			        .getAllShifForLocation(locationId);
			
			// logger.log(Level.INFO, "Shift Size--" + shiftList.size());
			Iterator shiftIterator = shiftList.iterator();
			
			while (shiftIterator.hasNext())
			{
				
				MA_Shift shift = (MA_Shift) shiftIterator.next();
				// TODO : Why do we need to wait for the shift to start.?
				if (helper.hasShiftStarted(shift, currentDateTime))
				{
					Calendar shiftStartTime = Calendar.getInstance();
					shiftStartTime.set(Calendar.HOUR_OF_DAY,
					        shift.getStartHrs());
					shiftStartTime.set(Calendar.MINUTE, shift.getStartMin());
					shiftStartTime.set(Calendar.SECOND, 0);
					shiftStartTime.set(Calendar.MILLISECOND, 0);
					
					// TODO : Temp fix to get the ShiftTime in GMT
					shiftStartTime = AssignmentHelper
					        .adjustTimeZone(shiftStartTime);
					
					MA_DashboardData noOfAssignment = new MA_DashboardData();
					noOfAssignment
					        .setFilterType(IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT);
					MA_DashboardData noOfRightInEmployee = new MA_DashboardData();
					noOfRightInEmployee
					        .setFilterType(IMobileAttendanceConstants.RIGHT_IN_EMPLOYEE_COUNT);
					MA_DashboardData noOfRightInAsgEmployee = new MA_DashboardData();
					noOfRightInAsgEmployee
					        .setFilterType(IMobileAttendanceConstants.RIGHT_IN_ASG_EMPLOYEE_COUNT);
					
					MA_DashboardData noOfEarlyInEmployee = new MA_DashboardData();
					noOfEarlyInEmployee
					        .setFilterType(IMobileAttendanceConstants.EARLY_IN_EMPLOYEE_COUNT);
					
					MA_DashboardData noOfEarlyInAsgEmployee = new MA_DashboardData();
					noOfEarlyInAsgEmployee
					        .setFilterType(IMobileAttendanceConstants.EARLY_IN_ASG_EMPLOYEE_COUNT);
					
					MA_DashboardData noLateInEmployee = new MA_DashboardData();
					noLateInEmployee
					        .setFilterType(IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT);
					
					MA_DashboardData noLateInAsgEmployee = new MA_DashboardData();
					noLateInAsgEmployee
					        .setFilterType(IMobileAttendanceConstants.LATE_IN_ASG_EMPLOYEE_COUNT);
					
					MA_DashboardData noOfTotalInEmployee = new MA_DashboardData();
					noOfTotalInEmployee
					        .setFilterType(IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT);
					
					// Fetach the list of Dashboard data to verify whether the
					// batch
					// job is executed twice.
					List<MA_DashboardData> dashboardDataList = Datastore
					        .query(dashboardDataMeta)
					        .filter(dashboardDataMeta.shiftRef.equal(shift
					                .getKey()),
					                dashboardDataMeta.createDay
					                        .equal(createDay),
					                dashboardDataMeta.createMonth
					                        .equal(createMonth),
					                dashboardDataMeta.createYear
					                        .equal(createYear),
					                dashboardDataMeta.filterType
					                        .in(filterTypes)).asList();
					if (null != dashboardDataList
					        && dashboardDataList.size() > 0)
					{
						int index = dashboardDataList.indexOf(noOfAssignment);
						
						logger.log(Level.INFO, "Index of noOfAssignment="
						        + index);
						if (index != -1)
						{
							noOfAssignment = dashboardDataList.get(index);
						}
						
						index = dashboardDataList.indexOf(noOfRightInEmployee);
						logger.log(Level.INFO, "Index of noOfRightInEmployee="
						        + index);
						if (index != -1)
						{
							noOfRightInEmployee = dashboardDataList.get(index);
						}
						
						index = dashboardDataList
						        .indexOf(noOfRightInAsgEmployee);
						logger.log(Level.INFO,
						        "Index of noOfRightInAsgEmployee=" + index);
						if (index != -1)
						{
							noOfRightInAsgEmployee = dashboardDataList
							        .get(index);
						}
						
						index = dashboardDataList.indexOf(noOfEarlyInEmployee);
						logger.log(Level.INFO, "Index of noOfEarlyInEmployee="
						        + index);
						if (index != -1)
						{
							noOfEarlyInEmployee = dashboardDataList.get(index);
						}
						
						index = dashboardDataList
						        .indexOf(noOfEarlyInAsgEmployee);
						logger.log(Level.INFO, "Index of noOfEarlyInEmployee="
						        + index);
						if (index != -1)
						{
							noOfEarlyInAsgEmployee = dashboardDataList
							        .get(index);
						}
						
						index = dashboardDataList.indexOf(noLateInEmployee);
						logger.log(Level.INFO, "Index of noLateInEmployee="
						        + index);
						if (index != -1)
						{
							noLateInEmployee = dashboardDataList.get(index);
						}
						
						index = dashboardDataList.indexOf(noLateInAsgEmployee);
						logger.log(Level.INFO, "Index of noLateInAsgEmployee="
						        + index);
						if (index != -1)
						{
							noLateInAsgEmployee = dashboardDataList.get(index);
						}
						
						index = dashboardDataList.indexOf(noOfTotalInEmployee);
						logger.log(Level.INFO, "Index of noOfTotalInEmployee="
						        + index);
						
						if (index != -1)
						{
							noOfTotalInEmployee = dashboardDataList.get(index);
						}
						
					}
					
					// if ((shiftStartTime.getTimeInMillis() + 30000) <
					// currentDateTime
					// .getTimeInMillis())
					if (AssignmentHelper
					        .hasShiftStarted(shift, currentDateTime))
					{
						logger.log(Level.INFO,
						        "-- Starting Shift Start Time --");
						ArrayList<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
						
						int assignmentCount = Datastore
						        .query(assignmentMeta)
						        .filter(assignmentMeta.shiftRef.equal(shift
						                .getKey()),
						                assignmentMeta.status
						                        .equal(IMobileAttendanceConstants.CURRENT_ASSIGNMENT))
						        .count();
						
						noOfAssignment.setCount(assignmentCount);
						noOfAssignment.setCreateDay(createDay);
						noOfAssignment.setCreateMonth(createMonth);
						noOfAssignment.setCreateYear(createYear);
						noOfAssignment.getShiftRef().setModel(shift);
						entityList.add(noOfAssignment);
						
						int rightInEmployeeCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.inTimeResult
						                        .equal(IMobileAttendanceConstants.RIGHT_IN),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						
						noOfRightInEmployee
						        .setFilterType(IMobileAttendanceConstants.RIGHT_IN_EMPLOYEE_COUNT);
						noOfRightInEmployee.setCount(rightInEmployeeCount);
						noOfRightInEmployee.setCreateDay(createDay);
						noOfRightInEmployee.setCreateMonth(createMonth);
						noOfRightInEmployee.setCreateYear(createYear);
						noOfRightInEmployee.getShiftRef().setModel(shift);
						
						entityList.add(noOfRightInEmployee);
						// Get right -in with asg
						entityList.add(getTotalEmpIN_inAShift(
						        noOfRightInAsgEmployee.getKey(), shift, 1,
						        true, currentDateTime));
						
						int earlyInEmployeeCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.inTimeResult
						                        .equal(IMobileAttendanceConstants.EARLY_IN),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						
						noOfEarlyInEmployee
						        .setFilterType(IMobileAttendanceConstants.EARLY_IN_EMPLOYEE_COUNT);
						noOfEarlyInEmployee.setCount(earlyInEmployeeCount);
						noOfEarlyInEmployee.setCreateDay(createDay);
						noOfEarlyInEmployee.setCreateMonth(createMonth);
						noOfEarlyInEmployee.setCreateYear(createYear);
						noOfEarlyInEmployee.getShiftRef().setModel(shift);
						entityList.add(noOfEarlyInEmployee);
						
						// Get early -in with asg
						entityList.add(getTotalEmpIN_inAShift(
						        noOfEarlyInAsgEmployee.getKey(), shift, 2,
						        true, currentDateTime));
						
						int lateInEmployeeCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.inTimeResult
						                        .equal(IMobileAttendanceConstants.LATE_IN),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						
						noLateInEmployee
						        .setFilterType(IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT);
						noLateInEmployee.setCount(lateInEmployeeCount);
						noLateInEmployee.setCreateDay(createDay);
						noLateInEmployee.setCreateMonth(createMonth);
						noLateInEmployee.setCreateYear(createYear);
						noLateInEmployee.getShiftRef().setModel(shift);
						entityList.add(noLateInEmployee);
						
						// Get Late -in with asg
						entityList.add(getTotalEmpIN_inAShift(
						        noLateInAsgEmployee.getKey(), shift, 3, true,
						        currentDateTime));
						
						int totalInCount = rightInEmployeeCount
						        + earlyInEmployeeCount + lateInEmployeeCount;
						
						noOfTotalInEmployee
						        .setFilterType(IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT);
						noOfTotalInEmployee.setCount(totalInCount);
						noOfTotalInEmployee.setCreateDay(createDay);
						noOfTotalInEmployee.setCreateMonth(createMonth);
						noOfTotalInEmployee.setCreateYear(createYear);
						noOfTotalInEmployee.getShiftRef().setModel(shift);
						
						entityList.add(noOfTotalInEmployee);
						
						logger.log(Level.INFO, "Entity List Size--"
						        + entityList.size());
						
						GlobalTransaction gtx = Datastore
						        .beginGlobalTransaction();
						AbstractEntityDAO.setGtx(gtx);
						AbstractEntityDAO.addModels(entityList);
						gtx.commit();
					}
				}
			}
			
		}
		
		logger.log(Level.INFO,
		        "End calculateAndUpdateInTimeDetailsForCurrentShift");
		return 0;
	}
	
	/**
	 * <pre>
	 * This method calculated the number of emplyees in a shift with the states:
	 * RIGHT_IN, LATE_IN
	 * </pre>
	 * 
	 * @param shift
	 * @param attendanceStateFlag
	 * @param isAssigned
	 * @return
	 */
	public MA_DashboardData getTotalEmpIN_inAShift(Key dashboardKey,
	        MA_Shift shift, int attendanceStateFlag, boolean isAssigned,
	        Calendar refDate)
	{
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		
		Integer createDay = refDate.get(Calendar.DAY_OF_MONTH);
		Integer createMonth = refDate.get(Calendar.MONTH);
		Integer createYear = refDate.get(Calendar.YEAR);
		
		int countWithCurrentAssignemnt = 0;
		int count = 0;
		List<MA_ConsolidatedTimesheet> _consolidatedTimesheet = null;
		String _filter = null;
		
		if (isAssigned)
		{
			_consolidatedTimesheet = Datastore
			        .query(consolidatedTimesheetMeta)
			        .filter(consolidatedTimesheetMeta.shiftRef.equal(shift
			                .getKey()),
			                consolidatedTimesheetMeta.inTimeResult
			                        .equal(attendanceStateFlag),
			                consolidatedTimesheetMeta.createDay
			                        .equal(createDay),
			                consolidatedTimesheetMeta.createMonth
			                        .equal(createMonth),
			                consolidatedTimesheetMeta.createYear
			                        .equal(createYear)).asList();
			
			for (Iterator iterator = _consolidatedTimesheet.iterator(); iterator
			        .hasNext();)
			{
				MA_ConsolidatedTimesheet ma_ConsolidatedTimesheet = (MA_ConsolidatedTimesheet) iterator
				        .next();
				if (ma_ConsolidatedTimesheet.getAssignmentRef().getModel()
				        .getStatus() == IMobileAttendanceConstants.CURRENT_ASSIGNMENT)
				{
					countWithCurrentAssignemnt++;
				}
			}
			
			count = countWithCurrentAssignemnt;
			
			switch (attendanceStateFlag)
			{
				case 1:
					_filter = IMobileAttendanceConstants.RIGHT_IN_ASG_EMPLOYEE_COUNT;
					break;
				case 2:
					_filter = IMobileAttendanceConstants.EARLY_IN_ASG_EMPLOYEE_COUNT;
					break;
				case 3:
					_filter = IMobileAttendanceConstants.LATE_IN_ASG_EMPLOYEE_COUNT;
					break;
			}
			
		} else
		{
			count = Datastore
			        .query(consolidatedTimesheetMeta)
			        .filter(consolidatedTimesheetMeta.shiftRef.equal(shift
			                .getKey()),
			                consolidatedTimesheetMeta.inTimeResult
			                        .equal(attendanceStateFlag),
			                consolidatedTimesheetMeta.createDay
			                        .equal(createDay),
			                consolidatedTimesheetMeta.createMonth
			                        .equal(createMonth),
			                consolidatedTimesheetMeta.createYear
			                        .equal(createYear)).count();
			
			switch (attendanceStateFlag)
			{
				case 1:
					_filter = IMobileAttendanceConstants.RIGHT_IN_EMPLOYEE_COUNT;
					break;
				case 2:
					_filter = IMobileAttendanceConstants.EARLY_IN_EMPLOYEE_COUNT;
					break;
				case 3:
					_filter = IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT;
					break;
			}
		}
		
		MA_DashboardData _dashBoardWithFilter = new MA_DashboardData();
		_dashBoardWithFilter.setKey(dashboardKey);
		_dashBoardWithFilter.setFilterType(_filter);
		_dashBoardWithFilter.setCount(count);
		_dashBoardWithFilter.setCreateDay(createDay);
		_dashBoardWithFilter.setCreateMonth(createMonth);
		_dashBoardWithFilter.setCreateYear(createYear);
		_dashBoardWithFilter.getShiftRef().setModel(shift);
		
		return _dashBoardWithFilter;
	}
	
	/**
	 * 
	 * @param dashboardKey
	 * @param shift
	 * @param attendanceStateFlag
	 * @param isAssigned
	 * @param refDate
	 * @return
	 */
	public MA_DashboardData getTotalEmpOUT_inAShift(Key dashboardKey,
	        MA_Shift shift, int attendanceStateFlag, boolean isAssigned,
	        Calendar refDate)
	{
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		
		Integer createDay = refDate.get(Calendar.DAY_OF_MONTH);
		Integer createMonth = refDate.get(Calendar.MONTH);
		Integer createYear = refDate.get(Calendar.YEAR);
		
		int countWithCurrentAssignemnt = 0;
		int count = 0;
		List<MA_ConsolidatedTimesheet> _consolidatedTimesheet = null;
		String _filter = null;
		
		if (isAssigned)
		{
			_consolidatedTimesheet = Datastore
			        .query(consolidatedTimesheetMeta)
			        .filter(consolidatedTimesheetMeta.shiftRef.equal(shift
			                .getKey()),
			                consolidatedTimesheetMeta.outTimeResult
			                        .equal(attendanceStateFlag),
			                consolidatedTimesheetMeta.createDay
			                        .equal(createDay),
			                consolidatedTimesheetMeta.createMonth
			                        .equal(createMonth),
			                consolidatedTimesheetMeta.createYear
			                        .equal(createYear)).asList();
			
			for (Iterator iterator = _consolidatedTimesheet.iterator(); iterator
			        .hasNext();)
			{
				MA_ConsolidatedTimesheet ma_ConsolidatedTimesheet = (MA_ConsolidatedTimesheet) iterator
				        .next();
				if (ma_ConsolidatedTimesheet.getAssignmentRef().getModel()
				        .getStatus() == IMobileAttendanceConstants.CURRENT_ASSIGNMENT)
				{
					countWithCurrentAssignemnt++;
				}
			}
			
			count = countWithCurrentAssignemnt;
			
			switch (attendanceStateFlag)
			{
				case 1:
					_filter = IMobileAttendanceConstants.RIGHT_OUT_ASG_EMPLOYEE_COUNT;
					break;
				case 2:
					_filter = IMobileAttendanceConstants.EARLY_OUT_ASG_EMPLOYEE_COUNT;
					break;
				case 3:
					_filter = IMobileAttendanceConstants.LATE_OUT_ASG_EMPLOYEE_COUNT;
					break;
			}
			
		} else
		{
			count = Datastore
			        .query(consolidatedTimesheetMeta)
			        .filter(consolidatedTimesheetMeta.shiftRef.equal(shift
			                .getKey()),
			                consolidatedTimesheetMeta.outTimeResult
			                        .equal(attendanceStateFlag),
			                consolidatedTimesheetMeta.createDay
			                        .equal(createDay),
			                consolidatedTimesheetMeta.createMonth
			                        .equal(createMonth),
			                consolidatedTimesheetMeta.createYear
			                        .equal(createYear)).count();
			
			switch (attendanceStateFlag)
			{
				case 1:
					_filter = IMobileAttendanceConstants.RIGHT_OUT_EMPLOYEE_COUNT;
					break;
				case 2:
					_filter = IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT;
					break;
				case 3:
					_filter = IMobileAttendanceConstants.LATE_OUT_EMPLOYEE_COUNT;
					break;
			}
		}
		
		MA_DashboardData _dashBoardWithFilter = new MA_DashboardData();
		_dashBoardWithFilter.setKey(dashboardKey);
		_dashBoardWithFilter.setFilterType(_filter);
		_dashBoardWithFilter.setCount(count);
		_dashBoardWithFilter.setCreateDay(createDay);
		_dashBoardWithFilter.setCreateMonth(createMonth);
		_dashBoardWithFilter.setCreateYear(createYear);
		_dashBoardWithFilter.getShiftRef().setModel(shift);
		
		return _dashBoardWithFilter;
	}
	
	/**
	 * This method calculates the dashboard data after the shift has ended
	 * 
	 * @param companyId
	 * @return
	 */
	public int calculateAndUpdateOutTimeAndEffortDetails(Long companyId)
	{
		logger.log(Level.INFO,
		        "Start calculateAndUpdateOutTimeAndEffortDetails");
		List<MA_Location> locationList = entityService
		        .getAllLocationForCompany(companyId);
		Iterator locationIterator = locationList.iterator();
		
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		
		MA_DashboardDataMeta dashboardDataMeta = MA_DashboardDataMeta.get();
		List<String> filterTypes = new ArrayList<String>();
		filterTypes.add(IMobileAttendanceConstants.RIGHT_OUT_EMPLOYEE_COUNT);
		filterTypes
		        .add(IMobileAttendanceConstants.RIGHT_OUT_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT);
		filterTypes
		        .add(IMobileAttendanceConstants.EARLY_OUT_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_OUT_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_OUT_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.RIGHT_EFFORT_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LESS_EFFORT_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.OVER_TIME_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT);
		AssignmentHelper helper = new AssignmentHelper();
		while (locationIterator.hasNext())
		{
			
			MA_Location location = (MA_Location) locationIterator.next();
			// TimeZone _tz = TimeZone.getTimeZone(location.getTimeZone());
			Calendar currentDateTime = Calendar.getInstance();
			// currentDateTime.setTimeZone(_tz);
			Integer createDay = currentDateTime.get(Calendar.DAY_OF_MONTH);
			Integer createMonth = currentDateTime.get(Calendar.MONTH);
			Integer createYear = currentDateTime.get(Calendar.YEAR);
			
			Long locationId = location.getKey().getId();
			List<MA_Shift> shiftList = entityService
			        .getAllShifForLocation(locationId);
			Iterator shiftIterator = shiftList.iterator();
			while (shiftIterator.hasNext())
			{
				MA_Shift shift = (MA_Shift) shiftIterator.next();
				
				if (helper.hasShiftEnded(shift, currentDateTime))
				{
					Calendar shiftEndTime = Calendar.getInstance();
					// Convert the ShiftTime to server's default TimeZone
					shiftEndTime.setTimeZone(TimeZone.getDefault());
					shiftEndTime.set(Calendar.HOUR_OF_DAY, shift.getEndHrs());
					shiftEndTime.set(Calendar.MINUTE, shift.getEndMin());
					shiftEndTime.set(Calendar.SECOND, 0);
					shiftEndTime.set(Calendar.MILLISECOND, 0);
					
					// TODO : Get the shift end time in the same time zone.
					shiftEndTime = AssignmentHelper
					        .adjustTimeZone(shiftEndTime);
					
					// TODO : DJ : How this is being used ? Is it needed
					// DateUtil.clearDatePart(currentDateTime);
					// DateUtil.clearDatePart(shiftEndTime);
					
					MA_DashboardData noOfRightOutEmployee = new MA_DashboardData();
					noOfRightOutEmployee
					        .setFilterType(IMobileAttendanceConstants.RIGHT_OUT_EMPLOYEE_COUNT);
					
					MA_DashboardData noOfRightOutAsgEmployee = new MA_DashboardData();
					noOfRightOutAsgEmployee
					        .setFilterType(IMobileAttendanceConstants.RIGHT_OUT_ASG_EMPLOYEE_COUNT);
					
					MA_DashboardData noEarlyOutEmployee = new MA_DashboardData();
					noEarlyOutEmployee
					        .setFilterType(IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT);
					
					MA_DashboardData noEarlyOutAsgEmployee = new MA_DashboardData();
					noEarlyOutAsgEmployee
					        .setFilterType(IMobileAttendanceConstants.EARLY_OUT_ASG_EMPLOYEE_COUNT);
					
					MA_DashboardData noLateOutEmployee = new MA_DashboardData();
					noLateOutEmployee
					        .setFilterType(IMobileAttendanceConstants.LATE_OUT_EMPLOYEE_COUNT);
					
					MA_DashboardData noLateOutAsgEmployee = new MA_DashboardData();
					noLateOutAsgEmployee
					        .setFilterType(IMobileAttendanceConstants.LATE_OUT_ASG_EMPLOYEE_COUNT);
					
					MA_DashboardData noOflessEffortEmployee = new MA_DashboardData();
					noOflessEffortEmployee
					        .setFilterType(IMobileAttendanceConstants.LESS_EFFORT_EMPLOYEE_COUNT);
					MA_DashboardData noRightEffort = new MA_DashboardData();
					noRightEffort
					        .setFilterType(IMobileAttendanceConstants.RIGHT_EFFORT_EMPLOYEE_COUNT);
					MA_DashboardData noOfoverTimeEmployee = new MA_DashboardData();
					noOfoverTimeEmployee
					        .setFilterType(IMobileAttendanceConstants.OVER_TIME_EMPLOYEE_COUNT);
					
					// Fetach the list of Dashboard data to verify whether the
					// batch
					// job is executed twice.
					List<MA_DashboardData> dashboardDataList = Datastore
					        .query(dashboardDataMeta)
					        .filter(dashboardDataMeta.shiftRef.equal(shift
					                .getKey()),
					                dashboardDataMeta.createDay
					                        .equal(createDay),
					                dashboardDataMeta.createMonth
					                        .equal(createMonth),
					                dashboardDataMeta.createYear
					                        .equal(createYear),
					                dashboardDataMeta.filterType
					                        .in(filterTypes)).asList();
					
					if (null != dashboardDataList
					        && dashboardDataList.size() > 0)
					{
						int index = dashboardDataList
						        .indexOf(noOfRightOutEmployee);
						if (index != -1)
						{
							noOfRightOutEmployee = dashboardDataList.get(index);
						}
						
						index = dashboardDataList
						        .indexOf(noOfRightOutAsgEmployee);
						if (index != -1)
						{
							noOfRightOutAsgEmployee = dashboardDataList
							        .get(index);
						}
						
						index = dashboardDataList.indexOf(noEarlyOutEmployee);
						if (index != -1)
						{
							noEarlyOutEmployee = dashboardDataList.get(index);
						}
						
						index = dashboardDataList
						        .indexOf(noEarlyOutAsgEmployee);
						if (index != -1)
						{
							noEarlyOutAsgEmployee = dashboardDataList
							        .get(index);
						}
						
						index = dashboardDataList.indexOf(noLateOutEmployee);
						if (index != -1)
						{
							noLateOutEmployee = dashboardDataList.get(index);
						}
						
						index = dashboardDataList.indexOf(noLateOutAsgEmployee);
						if (index != -1)
						{
							noLateOutAsgEmployee = dashboardDataList.get(index);
						}
						
						index = dashboardDataList
						        .indexOf(noOflessEffortEmployee);
						if (index != -1)
						{
							noOflessEffortEmployee = dashboardDataList
							        .get(index);
						}
						index = dashboardDataList.indexOf(noRightEffort);
						if (index != -1)
						{
							noRightEffort = dashboardDataList.get(index);
						}
						index = dashboardDataList.indexOf(noOfoverTimeEmployee);
						if (index != -1)
						{
							noOfoverTimeEmployee = dashboardDataList.get(index);
						}
						
					}
					
					if (AssignmentHelper.hasShiftEnded(shift, currentDateTime))
					{
						logger.log(Level.INFO,
						        "-- Starting Out Dash board creation --");
						
						ArrayList<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
						
						int rightOutEmployeeCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.outTimeResult
						                        .equal(IMobileAttendanceConstants.RIGHT_OUT),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						
						noOfRightOutEmployee.setCount(rightOutEmployeeCount);
						noOfRightOutEmployee.setCreateDay(createDay);
						noOfRightOutEmployee.setCreateMonth(createMonth);
						noOfRightOutEmployee.setCreateYear(createYear);
						noOfRightOutEmployee.getShiftRef().setModel(shift);
						entityList.add(noOfRightOutEmployee);
						
						// Get right -OUT with asg
						entityList.add(getTotalEmpOUT_inAShift(
						        noOfRightOutAsgEmployee.getKey(), shift, 1,
						        true, currentDateTime));
						
						int earlyOutEmployeeCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.outTimeResult
						                        .equal(IMobileAttendanceConstants.EARLY_OUT),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						
						noEarlyOutEmployee.setCount(earlyOutEmployeeCount);
						noEarlyOutEmployee.setCreateDay(createDay);
						noEarlyOutEmployee.setCreateMonth(createMonth);
						noEarlyOutEmployee.setCreateYear(createYear);
						noEarlyOutEmployee.getShiftRef().setModel(shift);
						entityList.add(noEarlyOutEmployee);
						
						// Get EARLY -OUT with asg
						entityList.add(getTotalEmpOUT_inAShift(
						        noEarlyOutAsgEmployee.getKey(), shift, 2, true,
						        currentDateTime));
						
						int lateOutEmployeeCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.outTimeResult
						                        .equal(IMobileAttendanceConstants.LATE_OUT),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						
						noLateOutEmployee.setCount(lateOutEmployeeCount);
						noLateOutEmployee.setCreateDay(createDay);
						noLateOutEmployee.setCreateMonth(createMonth);
						noLateOutEmployee.setCreateYear(createYear);
						noLateOutEmployee.getShiftRef().setModel(shift);
						entityList.add(noLateOutEmployee);
						
						// Get LATE -OUT with asg
						entityList.add(getTotalEmpOUT_inAShift(
						        noEarlyOutAsgEmployee.getKey(), shift, 3, true,
						        currentDateTime));
						
						int rightEffortCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.effortResult
						                        .equal(IMobileAttendanceConstants.RIGHT_EFFORT),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						
						noRightEffort.setCount(rightEffortCount);
						noRightEffort.setCreateDay(createDay);
						noRightEffort.setCreateMonth(createMonth);
						noRightEffort.setCreateYear(createYear);
						noRightEffort.getShiftRef().setModel(shift);
						entityList.add(noRightEffort);
						
						int lessEffortEmployeeOutCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.effortResult
						                        .equal(IMobileAttendanceConstants.LESS_EFFORT),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						
						noOflessEffortEmployee
						        .setCount(lessEffortEmployeeOutCount);
						noOflessEffortEmployee.setCreateDay(createDay);
						noOflessEffortEmployee.setCreateMonth(createMonth);
						noOflessEffortEmployee.setCreateYear(createYear);
						noOflessEffortEmployee.getShiftRef().setModel(shift);
						entityList.add(noOflessEffortEmployee);
						
						int overTimeEmployeeCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.effortResult
						                        .equal(IMobileAttendanceConstants.OVER_TIME),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						
						noOfoverTimeEmployee.setCount(overTimeEmployeeCount);
						noOfoverTimeEmployee.setCreateDay(createDay);
						noOfoverTimeEmployee.setCreateMonth(createMonth);
						noOfoverTimeEmployee.setCreateYear(createYear);
						noOfoverTimeEmployee.getShiftRef().setModel(shift);
						entityList.add(noOfoverTimeEmployee);
						
						int employeeOnLeaveCount = Datastore
						        .query(consolidatedTimesheetMeta)
						        .filter(consolidatedTimesheetMeta.shiftRef
						                .equal(shift.getKey()),
						                consolidatedTimesheetMeta.effortResult
						                        .equal(IMobileAttendanceConstants.UNPAID_LEAVE),
						                consolidatedTimesheetMeta.createDay
						                        .equal(createDay),
						                consolidatedTimesheetMeta.createMonth
						                        .equal(createMonth),
						                consolidatedTimesheetMeta.createYear
						                        .equal(createYear)).count();
						MA_DashboardData noOfemployeeOnLeave = new MA_DashboardData();
						noOfemployeeOnLeave
						        .setFilterType(IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT);
						noOfemployeeOnLeave.setCount(employeeOnLeaveCount);
						noOfemployeeOnLeave.setCreateDay(createDay);
						noOfemployeeOnLeave.setCreateMonth(createMonth);
						noOfemployeeOnLeave.setCreateYear(createYear);
						noOfemployeeOnLeave.getShiftRef().setModel(shift);
						entityList.add(noOfemployeeOnLeave);
						
						GlobalTransaction gtx = Datastore
						        .beginGlobalTransaction();
						AbstractEntityDAO.setGtx(gtx);
						AbstractEntityDAO.addModels(entityList);
						
						gtx.commit();
					}
					
				}
				
			}
			
		}
		
		logger.log(Level.INFO, "End calculateAndUpdateOutTimeAndEffortDetails");
		
		return 0;
		
	}
	
	public Map getDashBoardCount(Long companyId)
	{
		
		logger.log(Level.INFO, "Start getDashBoardCount");
		int assignmentCount = 0;
		int lateInEmployeeCount = 0;
		int earlyOutEmployeeCount = 0;
		int totalInEmployeeCount = 0;
		int totalInAsgEmployeeCount = 0;
		int leaveCount = 0;
		
		Calendar currentDateTime = Calendar.getInstance();
		Integer createDay = currentDateTime.get(Calendar.DAY_OF_MONTH);
		Integer createMonth = currentDateTime.get(Calendar.MONTH);
		Integer createYear = currentDateTime.get(Calendar.YEAR);
		MA_DashboardDataMeta dashboardDataMeta = MA_DashboardDataMeta.get();
		
		List<String> filterTypes = new ArrayList<String>();
		filterTypes.add(IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT);
		filterTypes.add(IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.RIGHT_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT);
		List<MA_Location> locationList = entityService
		        .getAllLocationForCompany(companyId);
		Iterator locationIterator = locationList.iterator();
		
		List<LocationDTO> locationDTOs = new ArrayList<LocationDTO>();
		while (locationIterator.hasNext())
		{
			MA_Location location = (MA_Location) locationIterator.next();
			Long locationId = location.getKey().getId();
			List<MA_Shift> shiftList = entityService
			        .getAllShifForLocation(locationId);
			Iterator shiftIterator = shiftList.iterator();
			
			int locationAssignmentCount = 0;
			int LocationEmployeeInCount = 0;
			int LocationEmployeeAsgInCount = 0;
			int locationLateInEmployeeCount = 0;
			int locationEarlyOutEmployeeCount = 0;
			int locationLeaveCount = 0;
			while (shiftIterator.hasNext())
			{
				
				MA_Shift shift = (MA_Shift) shiftIterator.next();
				List<MA_DashboardData> MA_DashboardDataList = Datastore
				        .query(dashboardDataMeta)
				        .filter(dashboardDataMeta.shiftRef
				                .equal(shift.getKey()),
				                dashboardDataMeta.createDay.equal(createDay),
				                dashboardDataMeta.createMonth
				                        .equal(createMonth),
				                dashboardDataMeta.createYear.equal(createYear),
				                dashboardDataMeta.filterType.in(filterTypes))
				        .asList();
				
				Iterator<MA_DashboardData> dashBoardDataIterator = MA_DashboardDataList
				        .iterator();
				while (dashBoardDataIterator.hasNext())
				{
					
					MA_DashboardData _dashBoardData = dashBoardDataIterator
					        .next();
					if (_dashBoardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT))
					{
						assignmentCount += _dashBoardData.getCount();
						locationAssignmentCount += _dashBoardData.getCount();
					} else if (_dashBoardData.getFilterType().equals(
					        IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT))
					{
						totalInEmployeeCount += _dashBoardData.getCount();
						LocationEmployeeInCount += _dashBoardData.getCount();
					} else if (_dashBoardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT))
					{
						earlyOutEmployeeCount += _dashBoardData.getCount();
					} else if (_dashBoardData.getFilterType().equals(
					        IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT))
					{
						lateInEmployeeCount += _dashBoardData.getCount();
						locationLateInEmployeeCount += _dashBoardData
						        .getCount();
					} else if (_dashBoardData.getFilterType().equals(
					        IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT))
					{
						leaveCount += _dashBoardData.getCount();
						locationLeaveCount += _dashBoardData.getCount();
					} else if (_dashBoardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.RIGHT_IN_ASG_EMPLOYEE_COUNT))
					{
						totalInAsgEmployeeCount += _dashBoardData.getCount();
						LocationEmployeeAsgInCount += _dashBoardData.getCount();
					} else if (_dashBoardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.EARLY_IN_ASG_EMPLOYEE_COUNT))
					{
						totalInAsgEmployeeCount += _dashBoardData.getCount();
						LocationEmployeeAsgInCount += _dashBoardData.getCount();
					} else if (_dashBoardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.LATE_IN_ASG_EMPLOYEE_COUNT))
					{
						totalInAsgEmployeeCount += _dashBoardData.getCount();
						LocationEmployeeAsgInCount += _dashBoardData.getCount();
					}
					
				}
				
			}
			
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocationId(locationId);
			locationDTO.setLocationName(location.getLocationName());
			locationDTO.setAssignmentCount(locationAssignmentCount);
			locationDTO.setTotalInCount(LocationEmployeeInCount);
			locationDTO.setTotalInAsgCount(LocationEmployeeAsgInCount);
			locationDTO.setLateInEmployeeCount(locationLateInEmployeeCount);
			locationDTO.setEarlyOutEmployeeCount(locationEarlyOutEmployeeCount);
			locationDTO.setLeaveCount(locationLeaveCount);
			locationDTOs.add(locationDTO);
			
		}
		
		Integer utilizationPercent = new Integer(0);
		Integer lateInPercent = new Integer(0);
		Integer earlyLeftPercent = new Integer(0);
		Integer notReportedPercent = new Integer(0);
		int tempAssignmentCount = assignmentCount;
		int tempTotalInEmployeeCount = totalInEmployeeCount;
		if (assignmentCount == 0)
		{
			assignmentCount = 1;
		}
		
		// utilizationPercent = (int) (((double) totalInEmployeeCount /
		// assignmentCount) * 100);
		utilizationPercent = (int) (((double) totalInAsgEmployeeCount / assignmentCount) * 100);
		notReportedPercent = (int) (((double) (assignmentCount - totalInAsgEmployeeCount) / assignmentCount) * 100);
		
		if (totalInEmployeeCount == 0)
		{
			totalInEmployeeCount = 1;
		}
		lateInPercent = (int) (((double) lateInEmployeeCount / totalInEmployeeCount) * 100);
		earlyLeftPercent = (int) (((double) earlyOutEmployeeCount / totalInEmployeeCount) * 100);
		
		Map dashboardMap = new HashMap();
		
		Key companykey = Datastore.createKey(MA_Company.class, companyId);
		MA_DashboardData MA_DashboardData = Datastore
		        .query(dashboardDataMeta)
		        .filter(dashboardDataMeta.createDay.equal(createDay),
		                dashboardDataMeta.createMonth.equal(createMonth),
		                dashboardDataMeta.createYear.equal(createYear),
		                dashboardDataMeta.filterType
		                        .equal(IMobileAttendanceConstants.UNASSIGNED_EMPLOYEE_COUNT),
		                dashboardDataMeta.companyRef.equal(companykey))
		        .asSingle();
		LocationDTO unassginedLocationDTO = new LocationDTO();
		unassginedLocationDTO.setLocationName("UnAllocated");
		if (null != MA_DashboardData)
		{
			unassginedLocationDTO.setAssignmentCount(MA_DashboardData
			        .getCount());
			dashboardMap.put("UNASSIGNED", MA_DashboardData.getCount());
		} else
		{
			unassginedLocationDTO.setAssignmentCount(new Integer(-1));
			dashboardMap.put("UNASSIGNED", new Integer(-1));
		}
		
		MA_DashboardData notReportedDashboardData = Datastore
		        .query(dashboardDataMeta)
		        .filter(dashboardDataMeta.createDay.equal(createDay),
		                dashboardDataMeta.createMonth.equal(createMonth),
		                dashboardDataMeta.createYear.equal(createYear),
		                dashboardDataMeta.filterType
		                        .equal(IMobileAttendanceConstants.NOT_REPORTED_EMPLOYEE_COUNT),
		                dashboardDataMeta.companyRef.equal(companykey))
		        .asSingle();
		LocationDTO notReportedLocationDTO = new LocationDTO();
		notReportedLocationDTO.setLocationName("Not Reported");
		if (null != MA_DashboardData)
		{
			notReportedLocationDTO.setAssignmentCount(notReportedDashboardData
			        .getCount());
			dashboardMap.put("NOT_REPORTED",
			        notReportedDashboardData.getCount());
		} else
		{
			notReportedLocationDTO.setAssignmentCount(new Integer(0));
			dashboardMap.put("NOT_REPORTED", new Integer(0));
		}
		
		dashboardMap.put("UTILIZATION_PERCENT", utilizationPercent);
		
		logger.log(Level.INFO, "notReportedPercent=" + notReportedPercent);
		dashboardMap.put("NOT_REPORTED_PERCENT", notReportedPercent);
		dashboardMap.put("LATE_IN_PERCENT", lateInPercent);
		dashboardMap.put("EARLY_LEFT_PERCENT", earlyLeftPercent);
		dashboardMap.put("LOCATION_DEATILS", locationDTOs);
		
		dashboardMap.put("NO_OF_ASSIGNEMNT", tempAssignmentCount);
		dashboardMap.put("REPORTED_EMPLOYEE_COUNT", tempTotalInEmployeeCount);
		dashboardMap
		        .put("ASG_REPORTED_EMPLOYEE_COUNT", totalInAsgEmployeeCount);
		dashboardMap.put("LATE_IN_EMPLOYEE_COUNT", lateInEmployeeCount);
		dashboardMap.put("EARLY_OUT_EMPLOYEE_COUNT", earlyOutEmployeeCount);
		logger.log(Level.INFO, "End getDashBoardCount");
		return dashboardMap;
		
	}
	
	/**
	 * 
	 * @param createDay
	 * @param createMonth
	 * @param createYear
	 * @param shift
	 * @param filterType
	 * @return
	 */
	private MA_DashboardData getDashBoradDataObject(Integer createDay,
	        Integer createMonth, Integer createYear, MA_Shift shift,
	        String filterType)
	{
		
		MA_DashboardDataMeta dashboardDataMeta = MA_DashboardDataMeta.get();
		MA_DashboardData dashboardData = Datastore
		        .query(dashboardDataMeta)
		        .filter(dashboardDataMeta.shiftRef.equal(shift.getKey()),
		                dashboardDataMeta.createDay.equal(createDay),
		                dashboardDataMeta.createMonth.equal(createMonth),
		                dashboardDataMeta.createYear.equal(createYear),
		                dashboardDataMeta.filterType.equal(filterType))
		        .asSingle();
		
		return dashboardData;
	}
	
	/**
	 * <pre>
	 * This method will create a dashbaord like
	 *  ------------------------------------------------------------------------
	 *  | Location = xxxx, Shift = yyyy											|
	 * 	------------------------------------------------------------------------
	 * 	|Department    | Planned |  Actual  |  Excess / Less | Excess / Less (%)|
	 * 	|-----------------------------------------------------------------------
	 * 	|			   |		 |			|				 |					|
	 * 	|			   |         |          |                |                  |
	 *  -------------------------------------------------------------------------
	 * </pre
	 */
	public List<DepartmentDashboardDTO> createDepartmentFulfillmentDashboard(
	        Long companyId, Calendar currentDate)
	{
		/**
		 * <pre>
		 * 1. The user will supply Location and Shift
		 * 2. For all the department and for that location and shift
		 *  a. Get all the Assignments which are CURRENT and not DEFAULT
		 *  b. count all the assignments
		 *  c. Read each assignments and fine timesheets, if found increase the counter
		 * </pre>
		 */
		List<DepartmentDashboardDTO> departmentDashboardDTOs = new ArrayList<DepartmentDashboardDTO>();
		List<MA_Location> locationList = entityService
		        .getAllLocationForCompany(companyId);
		Iterator<MA_Location> locationIterator = locationList.iterator();
		NumberFormat formatter = new DecimalFormat("#0.0");
		while (locationIterator.hasNext())
		{
			MA_Location location = locationIterator.next();
			String locationName = location.getLocationName();
			List<MA_Shift> shiftList = entityService
			        .getAllShifForLocation(location.getKey().getId());
			Iterator<MA_Shift> shiftIterator = shiftList.iterator();
			List<MA_Department> departments = entityService
			        .getAllDepartmentOfLocation(location.getKey().getId());
			while (shiftIterator.hasNext())
			{
				MA_Shift shift = shiftIterator.next();
				String shiftName = shift.getShiftName();
				MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
				Iterator<MA_Department> departmentIterator = departments
				        .iterator();
				while (departmentIterator.hasNext())
				{
					MA_Department department = departmentIterator.next();
					DepartmentDashboardDTO departmentDashboardDTO = new DepartmentDashboardDTO();
					departmentDashboardDTO.setDepartmentName(department
					        .getDepartmentName());
					departmentDashboardDTO.setShiftName(shiftName);
					departmentDashboardDTO.setLocationName(locationName);
					
					List<MA_Assignment> assignmentList = Datastore
					        .query(assignmentMeta)
					        .filter(assignmentMeta.shiftRef.equal(shift
					                .getKey()),
					                assignmentMeta.deptRef.equal(department
					                        .getKey()),
					                assignmentMeta.status
					                        .equal(IMobileAttendanceConstants.CURRENT_ASSIGNMENT))
					        .asList();
					int plannedCount = assignmentList.size();
					departmentDashboardDTO.setPlanned(plannedCount);
					
					Iterator<MA_Assignment> assignemntIterator = assignmentList
					        .iterator();
					
					int actualCount = 0;
					
					while (assignemntIterator.hasNext())
					{
						MA_Assignment assignment = assignemntIterator.next();
						List<MA_Timesheet> timesheets = getTimesheetsInADay(
						        assignment.getKey(), currentDate);
						if (null != timesheets && timesheets.size() > 0)
						{
							actualCount++;
						}
						
					}
					
					departmentDashboardDTO.setActual(actualCount);
					int excessLess = actualCount - plannedCount;
					departmentDashboardDTO.setExcessLess(excessLess);
					double excessLessPercent = 0;
					if (plannedCount > 0)
					{
						excessLessPercent = (excessLess / plannedCount) * 100;
					}
					
					departmentDashboardDTO.setExcessLessPercent(formatter
					        .format(excessLessPercent));
					departmentDashboardDTOs.add(departmentDashboardDTO);
				}
			}
		}
		
		return departmentDashboardDTOs;
		
	}
	
	public List<DepartmentDashboardDTO> getAllLocationShiftDepartmentDashboard(
	        Long locationId, Calendar currentDate)
	
	{
		return null;
	}
	
	/**
	 * This method returns location level employees count based on their state.
	 * For each location it also fetches the number of Shift level details too.
	 * 
	 * @param locationId
	 * @param currentDate
	 */
	public LocationDashboardReportDTO locationDataCalculator(Long locationId,
	        Calendar currentDate)
	{
		logger.log(Level.INFO, "Start getDashBoardCount");
		
		//
		int earlyInEmployeeCount = 0;
		int rightInEmployeeCount = 0;
		int lateInEmployeeCount = 0;
		int earlyOUTEmployeeCount = 0;
		int rightOUTEmployeeCount = 0;
		int lateOUTEmployeeCount = 0;
		int totalINEmployeeCount = 0;
		int totalOUTEmployeeCount = 0;
		int leaveCount = 0;
		int totalInAsgEmployeeCount = 0;
		
		LocationDashboardReportDTO locatonDashBoard = new LocationDashboardReportDTO();
		
		Calendar currentDateTime = Calendar.getInstance();
		currentDateTime.clear();
		currentDateTime.setTime(currentDate.getTime());
		
		Key k = Datastore
		        .createKey(MA_Location.class, Long.valueOf(locationId));
		MA_LocationMeta locationMeta = MA_LocationMeta.get();
		MA_Location location = Datastore.query(locationMeta)
		        .filter(locationMeta.key.equal(k)).asSingle();
		
		List<MA_Shift> shiftList = entityService
		        .getAllActiveShifForLocation(location.getKey().getId());
		Iterator<MA_Shift> shiftIterator = shiftList.iterator();
		ArrayList<ShiftDashboardReportDTO> shiftDashboardList = new ArrayList<ShiftDashboardReportDTO>();
		
		while (shiftIterator.hasNext())
		{
			int _shiftTotalInEmployeeCount = 0;
			MA_Shift shift = (MA_Shift) shiftIterator.next();
			
			ShiftDashboardReportDTO shiftDashBoard = getShiftDashboardReportDTO(
			        shift, currentDateTime);
			
			totalINEmployeeCount += shiftDashBoard.getTotalNumOfEmployeesIN();
			earlyInEmployeeCount += shiftDashBoard.getEmployeeEarlyIN();
			rightInEmployeeCount += shiftDashBoard.getEmployeeRightIN();
			lateInEmployeeCount += shiftDashBoard.getEmployeeLateIN();
			earlyOUTEmployeeCount += shiftDashBoard.getEmployeeEarlyOUT();
			rightOUTEmployeeCount += shiftDashBoard.getEmployeeRightOUT();
			lateOUTEmployeeCount += shiftDashBoard.getEmployeeLateOUT();
			totalOUTEmployeeCount += shiftDashBoard.getTotalNumOfEmployeesOUT();
			
			shiftDashboardList.add(shiftDashBoard);
		}
		int noOutTime=totalINEmployeeCount-totalOUTEmployeeCount;
		locatonDashBoard.setLocation(location);
		locatonDashBoard.setEmployeeEarlyIN(earlyInEmployeeCount);
		locatonDashBoard.setEmployeeLateIN(lateInEmployeeCount);
		locatonDashBoard.setEmployeeRightIN(rightInEmployeeCount);
		locatonDashBoard.setTotalNumOfEmployeesIN(totalINEmployeeCount);
		
		locatonDashBoard.setEmployeeEarlyOUT(earlyOUTEmployeeCount);
		locatonDashBoard.setEmployeeLateOUT(lateOUTEmployeeCount);
		locatonDashBoard.setEmployeeRightOUT(rightOUTEmployeeCount);
		locatonDashBoard.setTotalNumOfEmployeesOUT(totalOUTEmployeeCount);
		locatonDashBoard.setNoOutTime(noOutTime); 
		locatonDashBoard.setShiftDashboardList(shiftDashboardList);
		
		return locatonDashBoard;
		
	}
	
	public ShiftDashboardReportDTO getShiftDashboardReportDTO(MA_Shift shift,
	        Calendar currentDateTime)
	{
		MA_DashboardDataMeta dashboardDataMeta = MA_DashboardDataMeta.get();
		ShiftDashboardReportDTO shiftDashBoard = new ShiftDashboardReportDTO();
		
		List<String> filterTypes = new ArrayList<String>();
		filterTypes.add(IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT);
		filterTypes.add(IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_OUT_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.RIGHT_OUT_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.RIGHT_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT);
		
		Integer createDay = currentDateTime.get(Calendar.DAY_OF_MONTH);
		Integer createMonth = currentDateTime.get(Calendar.MONTH);
		Integer createYear = currentDateTime.get(Calendar.YEAR);
		int assignmentCount = 0;
		int _shiftTotalOutEmployeeCount = 0;
		
		shiftDashBoard.setShift(shift);
		AssignmentHelper assignmentHelper = new AssignmentHelper();
		
		/*
		 * following line removed from the old code to get all shift Data. if
		 * (assignmentHelper.hasShiftStarted(shift, currentDate)) {
		 */
		
		List<MA_DashboardData> MA_DashboardDataList = Datastore
		        .query(dashboardDataMeta)
		        .filter(dashboardDataMeta.shiftRef.equal(shift.getKey()),
		                dashboardDataMeta.createDay.equal(createDay),
		                dashboardDataMeta.createMonth.equal(createMonth),
		                dashboardDataMeta.createYear.equal(createYear),
		                dashboardDataMeta.filterType.in(filterTypes)).asList();
		
		Iterator<MA_DashboardData> dashBoradDataIterator = MA_DashboardDataList
		        .iterator();
		while (dashBoradDataIterator.hasNext())
		{
			MA_DashboardData maDashboardData = dashBoradDataIterator.next();
			if (maDashboardData.getFilterType().equals(
			        IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT))
			{
				assignmentCount += maDashboardData.getCount();
			} else if (maDashboardData.getFilterType().equals(
			        IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT))
			{
				shiftDashBoard.setTotalNumOfEmployeesIN(maDashboardData
				        .getCount());
				// totalINEmployeeCount += maDashboardData.getCount();
			} else if (maDashboardData.getFilterType().equals(
			        IMobileAttendanceConstants.EARLY_IN_EMPLOYEE_COUNT))
			{
				shiftDashBoard.setEmployeeEarlyIN(maDashboardData.getCount());
				// earlyInEmployeeCount += maDashboardData.getCount();
			} else if (maDashboardData.getFilterType().equals(
			        IMobileAttendanceConstants.RIGHT_IN_EMPLOYEE_COUNT))
			{
				shiftDashBoard.setEmployeeRightIN(maDashboardData.getCount());
				// rightInEmployeeCount += maDashboardData.getCount();
			} else if (maDashboardData.getFilterType().equals(
			        IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT))
			{
				shiftDashBoard.setEmployeeLateIN(maDashboardData.getCount());
				// lateInEmployeeCount += maDashboardData.getCount();
			} else if (maDashboardData.getFilterType().equals(
			        IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT))
			{
				shiftDashBoard.setEmployeeEarlyOUT(maDashboardData.getCount());
				// earlyOUTEmployeeCount += maDashboardData.getCount();
				// totalOUTEmployeeCount += maDashboardData.getCount();
				_shiftTotalOutEmployeeCount += maDashboardData.getCount();
			} else if (maDashboardData.getFilterType().equals(
			        IMobileAttendanceConstants.RIGHT_OUT_EMPLOYEE_COUNT))
			{
				shiftDashBoard.setEmployeeRightOUT(maDashboardData.getCount());
				// rightOUTEmployeeCount += maDashboardData.getCount();
				// totalOUTEmployeeCount += maDashboardData.getCount();
				_shiftTotalOutEmployeeCount += maDashboardData.getCount();
			} else if (maDashboardData.getFilterType().equals(
			        IMobileAttendanceConstants.LATE_OUT_EMPLOYEE_COUNT))
			{
				shiftDashBoard.setEmployeeLateOUT(maDashboardData.getCount());
				// lateOUTEmployeeCount += maDashboardData.getCount();
				// totalOUTEmployeeCount += maDashboardData.getCount();
				_shiftTotalOutEmployeeCount += maDashboardData.getCount();
			} else if (maDashboardData.getFilterType().equals(
			        IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT))
			{
				// leaveCount += maDashboardData.getCount();
			}
		}
		// }
		int noOutTime=shiftDashBoard.getTotalNumOfEmployeesIN()-_shiftTotalOutEmployeeCount;
		shiftDashBoard.setNoOutTime(noOutTime);
		shiftDashBoard.setTotalNumOfEmployeesOUT(_shiftTotalOutEmployeeCount);
		return shiftDashBoard;
	}
	
	/**
	 * 
	 * @param locationId
	 * @param currentDate
	 * @return
	 */
	public List<DepartmentDashboardDTO> getLocationShiftDepartmentDashboard(
	        Long locationId, Calendar currentDate)
	{
		
		List<DepartmentDashboardDTO> departmentDashboardDTOs = new ArrayList<DepartmentDashboardDTO>();
		Key k = Datastore
		        .createKey(MA_Location.class, Long.valueOf(locationId));
		MA_LocationMeta locationMeta = MA_LocationMeta.get();
		MA_Location location = Datastore.query(locationMeta)
		        .filter(locationMeta.key.equal(k)).asSingle();
		
		String locationName = location.getLocationName();
		List<MA_Shift> shiftList = entityService.getAllShifForLocation(location
		        .getKey().getId());
		Iterator<MA_Shift> shiftIterator = shiftList.iterator();
		
		NumberFormat formatter = new DecimalFormat("#0.0");
		
		while (shiftIterator.hasNext())
		{
			MA_Shift shift = shiftIterator.next();
			if ("Y".equalsIgnoreCase(shift.getActive()))
			{
				String shiftName = shift.getShiftName();
				MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
				List<MA_Department> departments = entityService
				        .getAllDepartmentOfLocation(location.getKey().getId());
				
				Iterator<MA_Department> departmentIterator = departments
				        .iterator();
				while (departmentIterator.hasNext())
				{
					MA_Department department = departmentIterator.next();
					DepartmentDashboardDTO departmentDashboardDTO = new DepartmentDashboardDTO();
					departmentDashboardDTO.setDepartmentName(department
					        .getDepartmentName());
					departmentDashboardDTO.setShiftName(shiftName);
					departmentDashboardDTO.setLocationName(locationName);
					
					List<MA_Assignment> assignmentList = Datastore
					        .query(assignmentMeta)
					        .filter(assignmentMeta.shiftRef.equal(shift
					                .getKey()),
					                assignmentMeta.deptRef.equal(department
					                        .getKey()),
					                assignmentMeta.status
					                        .equal(IMobileAttendanceConstants.CURRENT_ASSIGNMENT))
					        .asList();
					int plannedCount = assignmentList.size();
					departmentDashboardDTO.setPlanned(plannedCount);
					
					Iterator<MA_Assignment> assignemntIterator = assignmentList
					        .iterator();
					
					int actualCount = 0;
					
					while (assignemntIterator.hasNext())
					{
						MA_Assignment assignment = assignemntIterator.next();
						List<MA_Timesheet> timesheets = getTimesheetsInADay(
						        assignment.getKey(), currentDate);
						if (null != timesheets && timesheets.size() > 0)
						{
							actualCount++;
						}
						
					}
					
					departmentDashboardDTO.setActual(actualCount);
					int excessLess = actualCount - plannedCount;
					departmentDashboardDTO.setExcessLess(excessLess);
					double excessLessPercent = 0;
					if (plannedCount > 0)
					{
						excessLessPercent = ((double) excessLess / (double) plannedCount) * 100;
					}
					
					departmentDashboardDTO.setExcessLessPercent(formatter
					        .format(excessLessPercent));
					departmentDashboardDTOs.add(departmentDashboardDTO);
				}
			}
		}
		
		return departmentDashboardDTOs;
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
	 * 
	 * @param locationId
	 * @param currentDate
	 * @param shiftId
	 * @return
	 */
	public Map getLocationDashBoardCount(Long locationId, Calendar currentDate,
	        Long shiftId)
	{
		
		logger.log(Level.INFO, "Start getDashBoardCount");
		int assignmentCount = 0;
		int lateInEmployeeCount = 0;
		int earlyOutEmployeeCount = 0;
		int totalInEmployeeCount = 0;
		int leaveCount = 0;
		int totalInAsgEmployeeCount = 0;
		
		Calendar currentDateTime = Calendar.getInstance();
		Integer createDay = currentDateTime.get(Calendar.DAY_OF_MONTH);
		Integer createMonth = currentDateTime.get(Calendar.MONTH);
		Integer createYear = currentDateTime.get(Calendar.YEAR);
		MA_DashboardDataMeta dashboardDataMeta = MA_DashboardDataMeta.get();
		
		List<String> filterTypes = new ArrayList<String>();
		filterTypes.add(IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT);
		filterTypes.add(IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.RIGHT_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_IN_ASG_EMPLOYEE_COUNT);
		
		Key k = Datastore
		        .createKey(MA_Location.class, Long.valueOf(locationId));
		MA_LocationMeta locationMeta = MA_LocationMeta.get();
		MA_Location location = Datastore.query(locationMeta)
		        .filter(locationMeta.key.equal(k)).asSingle();
		
		List<MA_Shift> shiftList = entityService.getAllShifForLocation(location
		        .getKey().getId());
		Iterator<MA_Shift> shiftIterator = shiftList.iterator();
		int locationAssignmentCount = 0;
		int LocationEmployeeInCount = 0;
		int locationLateInEmployeeCount = 0;
		int LocationEarlyOutEmployeeCount = 0;
		int locationLeaveCount = 0;
		while (shiftIterator.hasNext())
		{
			
			MA_Shift shift = (MA_Shift) shiftIterator.next();
			
			AssignmentHelper assignmentHelper = new AssignmentHelper();
			if (assignmentHelper.hasShiftStarted(shift, currentDate))
			{
				
				List<MA_DashboardData> MA_DashboardDataList = Datastore
				        .query(dashboardDataMeta)
				        .filter(dashboardDataMeta.shiftRef
				                .equal(shift.getKey()),
				                dashboardDataMeta.createDay.equal(createDay),
				                dashboardDataMeta.createMonth
				                        .equal(createMonth),
				                dashboardDataMeta.createYear.equal(createYear),
				                dashboardDataMeta.filterType.in(filterTypes))
				        .asList();
				
				Iterator<MA_DashboardData> dashBoradDataIterator = MA_DashboardDataList
				        .iterator();
				while (dashBoradDataIterator.hasNext())
				{
					
					MA_DashboardData maDashboardData = dashBoradDataIterator
					        .next();
					if (maDashboardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT))
					{
						assignmentCount += maDashboardData.getCount();
						locationAssignmentCount += maDashboardData.getCount();
					} else if (maDashboardData.getFilterType().equals(
					        IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT))
					{
						totalInEmployeeCount += maDashboardData.getCount();
						LocationEmployeeInCount += maDashboardData.getCount();
					} else if (maDashboardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT))
					{
						earlyOutEmployeeCount += maDashboardData.getCount();
					} else if (maDashboardData.getFilterType().equals(
					        IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT))
					{
						lateInEmployeeCount += maDashboardData.getCount();
						locationLateInEmployeeCount += maDashboardData
						        .getCount();
					} else if (maDashboardData.getFilterType().equals(
					        IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT))
					{
						leaveCount += maDashboardData.getCount();
						locationLeaveCount += maDashboardData.getCount();
					} else if (maDashboardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.RIGHT_IN_ASG_EMPLOYEE_COUNT))
					{
						totalInAsgEmployeeCount += maDashboardData.getCount();
					} else if (maDashboardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.EARLY_IN_ASG_EMPLOYEE_COUNT))
					{
						totalInAsgEmployeeCount += maDashboardData.getCount();
					} else if (maDashboardData
					        .getFilterType()
					        .equals(IMobileAttendanceConstants.LATE_IN_ASG_EMPLOYEE_COUNT))
					{
						totalInAsgEmployeeCount += maDashboardData.getCount();
					}
					
				}
				
			}
			
		}
		
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocationId(locationId);
		locationDTO.setLocationName(location.getLocationName());
		locationDTO.setAssignmentCount(locationAssignmentCount);
		locationDTO.setTotalInCount(LocationEmployeeInCount);
		locationDTO.setLateInEmployeeCount(locationLateInEmployeeCount);
		locationDTO.setEarlyOutEmployeeCount(LocationEarlyOutEmployeeCount);
		locationDTO.setLeaveCount(locationLeaveCount);
		
		Integer utilizationPercent = new Integer(0);
		Integer lateInPercent = new Integer(0);
		Integer earlyLeftPercent = new Integer(0);
		Integer notReportedPercent = new Integer(0);
		int tempAssignmentCount = assignmentCount;
		int tempTotalInEmployeeCount = totalInEmployeeCount;
		if (assignmentCount == 0)
		{
			assignmentCount = 1;
		}
		
		utilizationPercent = (int) (((double) totalInEmployeeCount / assignmentCount) * 100);
		notReportedPercent = (int) (((double) (assignmentCount - totalInAsgEmployeeCount) / assignmentCount) * 100);
		
		if (totalInEmployeeCount == 0)
		{
			totalInEmployeeCount = 1;
		}
		lateInPercent = (int) (((double) lateInEmployeeCount / totalInEmployeeCount) * 100);
		earlyLeftPercent = (int) (((double) earlyOutEmployeeCount / totalInEmployeeCount) * 100);
		
		Map dashboardMap = new HashMap();
		
		dashboardMap.put("UTILIZATION_PERCENT", utilizationPercent);
		dashboardMap.put("LATE_IN_PERCENT", lateInPercent);
		dashboardMap.put("NOT_REPORTED_PERCENT", notReportedPercent);
		dashboardMap.put("EARLY_LEFT_PERCENT", earlyLeftPercent);
		dashboardMap.put("LOCATION_DEATILS", locationDTO);
		
		dashboardMap.put("NO_OF_ASSIGNEMNT", tempAssignmentCount);
		dashboardMap
		        .put("ASG_REPORTED_EMPLOYEE_COUNT", totalInAsgEmployeeCount);
		dashboardMap.put("REPORTED_EMPLOYEE_COUNT", tempTotalInEmployeeCount);
		dashboardMap.put("LATE_IN_EMPLOYEE_COUNT", lateInEmployeeCount);
		dashboardMap.put("EARLY_OUT_EMPLOYEE_COUNT", earlyOutEmployeeCount);
		
		logger.log(Level.INFO, "End getDashBoardCount");
		return dashboardMap;
		
	}
	
	/**
	 * 
	 * @param shiftId
	 * @param currentDate
	 * @return
	 */
	public Map getShiftDashBoardCount(Long shiftId, Calendar currentDate)
	{
		
		logger.log(Level.INFO, "Start getShiftDashBoardCount");
		int assignmentCount = 0;
		int lateInEmployeeCount = 0;
		int earlyOutEmployeeCount = 0;
		int totalInEmployeeCount = 0;
		int leaveCount = 0;
		int totalInAsgEmployeeCount = 0;
		
		Calendar currentDateTime = Calendar.getInstance();
		Integer createDay = currentDateTime.get(Calendar.DAY_OF_MONTH);
		Integer createMonth = currentDateTime.get(Calendar.MONTH);
		Integer createYear = currentDateTime.get(Calendar.YEAR);
		MA_DashboardDataMeta dashboardDataMeta = MA_DashboardDataMeta.get();
		
		List<String> filterTypes = new ArrayList<String>();
		filterTypes.add(IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT);
		filterTypes.add(IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.RIGHT_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.EARLY_IN_ASG_EMPLOYEE_COUNT);
		filterTypes.add(IMobileAttendanceConstants.LATE_IN_ASG_EMPLOYEE_COUNT);
		
		Key k = Datastore.createKey(MA_Shift.class, shiftId);
		MA_ShiftMeta shiftMeta = MA_ShiftMeta.get();
		MA_Shift shift = Datastore.query(shiftMeta)
		        .filter(shiftMeta.key.equal(k)).asSingle();
		
		logger.log(Level.INFO, "shift id=" + shiftId);
		int locationAssignmentCount = 0;
		int LocationEmployeeInCount = 0;
		int locationLateInEmployeeCount = 0;
		int LocationEarlyOutEmployeeCount = 0;
		int locationLeaveCount = 0;
		
		AssignmentHelper assignmentHelper = new AssignmentHelper();
		if (assignmentHelper.hasShiftStarted(shift, currentDate))
		{
			
			List<MA_DashboardData> MA_DashboardDataList = Datastore
			        .query(dashboardDataMeta)
			        .filter(dashboardDataMeta.shiftRef.equal(shift.getKey()),
			                dashboardDataMeta.createDay.equal(createDay),
			                dashboardDataMeta.createMonth.equal(createMonth),
			                dashboardDataMeta.createYear.equal(createYear),
			                dashboardDataMeta.filterType.in(filterTypes))
			        .asList();
			
			Iterator<MA_DashboardData> dashBoradDataIterator = MA_DashboardDataList
			        .iterator();
			while (dashBoradDataIterator.hasNext())
			{
				
				MA_DashboardData maDashboardData = dashBoradDataIterator.next();
				if (maDashboardData.getFilterType().equals(
				        IMobileAttendanceConstants.EMPLOYEE_ASSIGNMENT_COUNT))
				{
					assignmentCount += maDashboardData.getCount();
					locationAssignmentCount += maDashboardData.getCount();
				} else if (maDashboardData.getFilterType().equals(
				        IMobileAttendanceConstants.TOTAL_IN_EMPLOYEE_COUNT))
				{
					totalInEmployeeCount += maDashboardData.getCount();
					LocationEmployeeInCount += maDashboardData.getCount();
				} else if (maDashboardData.getFilterType().equals(
				        IMobileAttendanceConstants.EARLY_OUT_EMPLOYEE_COUNT))
				{
					earlyOutEmployeeCount += maDashboardData.getCount();
				} else if (maDashboardData.getFilterType().equals(
				        IMobileAttendanceConstants.LATE_IN_EMPLOYEE_COUNT))
				{
					lateInEmployeeCount += maDashboardData.getCount();
					locationLateInEmployeeCount += maDashboardData.getCount();
				} else if (maDashboardData.getFilterType().equals(
				        IMobileAttendanceConstants.LEAVE_EMPLOYEE_COUNT))
				{
					leaveCount += maDashboardData.getCount();
					locationLeaveCount += maDashboardData.getCount();
				} else if (maDashboardData.getFilterType().equals(
				        IMobileAttendanceConstants.RIGHT_IN_ASG_EMPLOYEE_COUNT))
				{
					totalInAsgEmployeeCount += maDashboardData.getCount();
				} else if (maDashboardData.getFilterType().equals(
				        IMobileAttendanceConstants.EARLY_IN_ASG_EMPLOYEE_COUNT))
				{
					totalInAsgEmployeeCount += maDashboardData.getCount();
				} else if (maDashboardData.getFilterType().equals(
				        IMobileAttendanceConstants.LATE_IN_ASG_EMPLOYEE_COUNT))
				{
					totalInAsgEmployeeCount += maDashboardData.getCount();
				}
				
			}
			
		}
		
		Integer utilizationPercent = new Integer(0);
		Integer lateInPercent = new Integer(0);
		Integer earlyLeftPercent = new Integer(0);
		Integer notReportedPercent = new Integer(0);
		int tempAssignmentCount = assignmentCount;
		int tempTotalInEmployeeCount = totalInEmployeeCount;
		if (assignmentCount == 0)
		{
			assignmentCount = 1;
		}
		
		utilizationPercent = (int) (((double) totalInEmployeeCount / assignmentCount) * 100);
		notReportedPercent = (int) (((double) (assignmentCount - totalInAsgEmployeeCount) / assignmentCount) * 100);
		
		if (totalInEmployeeCount == 0)
		{
			totalInEmployeeCount = 1;
		}
		
		lateInPercent = (int) (((double) lateInEmployeeCount / totalInEmployeeCount) * 100);
		earlyLeftPercent = (int) (((double) earlyOutEmployeeCount / totalInEmployeeCount) * 100);
		
		Map<String, Integer> dashboardMap = new HashMap();
		
		dashboardMap.put("UTILIZATION_PERCENT", utilizationPercent);
		dashboardMap.put("LATE_IN_PERCENT", lateInPercent);
		dashboardMap.put("NOT_REPORTED_PERCENT", notReportedPercent);
		dashboardMap.put("EARLY_LEFT_PERCENT", earlyLeftPercent);
		
		dashboardMap.put("NO_OF_ASSIGNEMNT", tempAssignmentCount);
		dashboardMap
		        .put("ASG_REPORTED_EMPLOYEE_COUNT", totalInAsgEmployeeCount);
		dashboardMap.put("REPORTED_EMPLOYEE_COUNT", tempTotalInEmployeeCount);
		dashboardMap.put("LATE_IN_EMPLOYEE_COUNT", lateInEmployeeCount);
		dashboardMap.put("EARLY_OUT_EMPLOYEE_COUNT", earlyOutEmployeeCount);
		
		logger.log(Level.INFO, "End getShiftDashBoardCount");
		return dashboardMap;
		
	}
	
	/**
	 * 
	 * @param shiftId
	 * @param currentDate
	 * @return
	 */
	public List<DepartmentDashboardDTO> getShiftDepartmentDashboard(
	        Long shiftId, Calendar currentDate)
	{
		
		List<DepartmentDashboardDTO> departmentDashboardDTOs = new ArrayList<DepartmentDashboardDTO>();
		Key k = Datastore.createKey(MA_Shift.class, Long.valueOf(shiftId));
		MA_ShiftMeta shiftMeta = MA_ShiftMeta.get();
		MA_Shift shift = Datastore.query(shiftMeta)
		        .filter(shiftMeta.key.equal(k)).asSingle();
		
		MA_Location location = shift.getLocationRef().getModel();
		String locationName = location.getLocationName();
		NumberFormat formatter = new DecimalFormat("#0.0");
		
		if ("Y".equalsIgnoreCase(shift.getActive()))
		{
			String shiftName = shift.getShiftName();
			MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
			List<MA_Department> departments = entityService
			        .getAllDepartmentOfLocation(location.getKey().getId());
			
			Iterator<MA_Department> departmentIterator = departments.iterator();
			while (departmentIterator.hasNext())
			{
				MA_Department department = departmentIterator.next();
				DepartmentDashboardDTO departmentDashboardDTO = new DepartmentDashboardDTO();
				departmentDashboardDTO.setDepartmentName(department
				        .getDepartmentName());
				departmentDashboardDTO.setShiftName(shiftName);
				departmentDashboardDTO.setLocationName(locationName);
				
				List<MA_Assignment> assignmentList = Datastore
				        .query(assignmentMeta)
				        .filter(assignmentMeta.shiftRef.equal(shift.getKey()),
				                assignmentMeta.deptRef.equal(department
				                        .getKey()),
				                assignmentMeta.status
				                        .equal(IMobileAttendanceConstants.CURRENT_ASSIGNMENT))
				        .asList();
				int plannedCount = assignmentList.size();
				departmentDashboardDTO.setPlanned(plannedCount);
				
				Iterator<MA_Assignment> assignemntIterator = assignmentList
				        .iterator();
				
				int actualCount = 0;
				
				while (assignemntIterator.hasNext())
				{
					MA_Assignment assignment = assignemntIterator.next();
					List<MA_Timesheet> timesheets = getTimesheetsInADay(
					        assignment.getKey(), currentDate);
					if (null != timesheets && timesheets.size() > 0)
					{
						actualCount++;
					}
					
				}
				
				departmentDashboardDTO.setActual(actualCount);
				int excessLess = actualCount - plannedCount;
				departmentDashboardDTO.setExcessLess(excessLess);
				double excessLessPercent = 0;
				if (plannedCount > 0)
				{
					excessLessPercent = ((double) excessLess / (double) plannedCount) * 100;
				}
				
				departmentDashboardDTO.setExcessLessPercent(formatter
				        .format(excessLessPercent));
				departmentDashboardDTO.setExcessLessPercentNum(Math
				        .round(excessLessPercent));
				departmentDashboardDTOs.add(departmentDashboardDTO);
			}
		}
		
		return departmentDashboardDTOs;
	}
	
	public List<DepartmentDashboardDTO> getLocationDepartmentDashboard(
	        Long locationId, Calendar currentDate)
	{
		
		List<DepartmentDashboardDTO> departmentDashboardDTOs = new ArrayList<DepartmentDashboardDTO>();
		Key k = Datastore
		        .createKey(MA_Location.class, Long.valueOf(locationId));
		MA_LocationMeta locationMeta = MA_LocationMeta.get();
		MA_Location location = Datastore.query(locationMeta)
		        .filter(locationMeta.key.equal(k)).asSingle();
		
		String locationName = location.getLocationName();
		List<MA_Shift> shiftList = entityService.getAllShifForLocation(location
		        .getKey().getId());
		
		NumberFormat formatter = new DecimalFormat("#0.0");
		List<MA_Department> departments = entityService
		        .getAllDepartmentOfLocation(location.getKey().getId());
		
		Iterator<MA_Department> departmentIterator = departments.iterator();
		while (departmentIterator.hasNext())
		{
			MA_Department department = departmentIterator.next();
			DepartmentDashboardDTO departmentDashboardDTO = new DepartmentDashboardDTO();
			departmentDashboardDTO.setDepartmentName(department
			        .getDepartmentName());
			// departmentDashboardDTO.setShiftName(shiftName);
			departmentDashboardDTO.setLocationName(locationName);
			
			int actualCount = 0;
			int plannedCount = 0;
			Iterator<MA_Shift> shiftIterator = shiftList.iterator();
			while (shiftIterator.hasNext())
			{
				MA_Shift shift = shiftIterator.next();
				if ("Y".equalsIgnoreCase(shift.getActive()))
				{
					MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
					List<MA_Assignment> assignmentList = Datastore
					        .query(assignmentMeta)
					        .filter(assignmentMeta.shiftRef.equal(shift
					                .getKey()),
					                assignmentMeta.deptRef.equal(department
					                        .getKey()),
					                assignmentMeta.status
					                        .equal(IMobileAttendanceConstants.CURRENT_ASSIGNMENT))
					        .asList();
					plannedCount = plannedCount + assignmentList.size();
					
					Iterator<MA_Assignment> assignemntIterator = assignmentList
					        .iterator();
					
					while (assignemntIterator.hasNext())
					{
						MA_Assignment assignment = assignemntIterator.next();
						List<MA_Timesheet> timesheets = getTimesheetsInADay(
						        assignment.getKey(), currentDate);
						if (null != timesheets && timesheets.size() > 0)
						{
							actualCount++;
						}
						
					}
					
					// }
				}
			}
			departmentDashboardDTO.setPlanned(plannedCount);
			departmentDashboardDTO.setActual(actualCount);
			int excessLess = actualCount - plannedCount;
			departmentDashboardDTO.setExcessLess(excessLess);
			double excessLessPercent = 0;
			if (plannedCount > 0)
			{
				excessLessPercent = ((double) excessLess / (double) plannedCount) * 100;
			}
			
			departmentDashboardDTO.setExcessLessPercent(formatter
			        .format(excessLessPercent));
			
			departmentDashboardDTO.setExcessLessPercentNum(Math
			        .round(excessLessPercent));
			departmentDashboardDTOs.add(departmentDashboardDTO);
			
		}
		
		return departmentDashboardDTOs;
	}
	
	/**
	 * This class calculates the Dashboard field Data
	 * 
	 * @author deejay
	 * 
	 */
	private class DashboardCalcData
	{
		
		private int assignmentCount         = 0;
		private int lateInEmployeeCount     = 0;
		private int earlyOutEmployeeCount   = 0;
		private int totalInEmployeeCount    = 0;
		private int leaveCount              = 0;
		private int totalInAsgEmployeeCount = 0;
		
		/**
		 * @return the assignmentCount
		 */
		public int getAssignmentCount()
		{
			return assignmentCount;
		}
		
		/**
		 * @param assignmentCount
		 *            the assignmentCount to set
		 */
		public void setAssignmentCount(int assignmentCount)
		{
			this.assignmentCount = assignmentCount;
		}
		
		/**
		 * @return the lateInEmployeeCount
		 */
		public int getLateInEmployeeCount()
		{
			return lateInEmployeeCount;
		}
		
		/**
		 * @param lateInEmployeeCount
		 *            the lateInEmployeeCount to set
		 */
		public void setLateInEmployeeCount(int lateInEmployeeCount)
		{
			this.lateInEmployeeCount = lateInEmployeeCount;
		}
		
		/**
		 * @return the earlyOutEmployeeCount
		 */
		public int getEarlyOutEmployeeCount()
		{
			return earlyOutEmployeeCount;
		}
		
		/**
		 * @param earlyOutEmployeeCount
		 *            the earlyOutEmployeeCount to set
		 */
		public void setEarlyOutEmployeeCount(int earlyOutEmployeeCount)
		{
			this.earlyOutEmployeeCount = earlyOutEmployeeCount;
		}
		
		/**
		 * @return the totalInEmployeeCount
		 */
		public int getTotalInEmployeeCount()
		{
			return totalInEmployeeCount;
		}
		
		/**
		 * @param totalInEmployeeCount
		 *            the totalInEmployeeCount to set
		 */
		public void setTotalInEmployeeCount(int totalInEmployeeCount)
		{
			this.totalInEmployeeCount = totalInEmployeeCount;
		}
		
		/**
		 * @return the leaveCount
		 */
		public int getLeaveCount()
		{
			return leaveCount;
		}
		
		/**
		 * @param leaveCount
		 *            the leaveCount to set
		 */
		public void setLeaveCount(int leaveCount)
		{
			this.leaveCount = leaveCount;
		}
		
		/**
		 * @return the totalInAsgEmployeeCount
		 */
		public int getTotalInAsgEmployeeCount()
		{
			return totalInAsgEmployeeCount;
		}
		
		/**
		 * @param totalInAsgEmployeeCount
		 *            the totalInAsgEmployeeCount to set
		 */
		public void setTotalInAsgEmployeeCount(int totalInAsgEmployeeCount)
		{
			this.totalInAsgEmployeeCount = totalInAsgEmployeeCount;
		}
		
	}
	
}
