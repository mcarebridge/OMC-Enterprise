package com.adviteya.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import com.adviteya.dto.PayrollDTO;
import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.meta.MA_ConsolidatedTimesheetMeta;
import com.adviteya.meta.MA_PayrollReportMeta;
import com.adviteya.meta.MA_TimeSheetRuleMeta;
import com.adviteya.meta.MA_TimesheetMeta;
import com.adviteya.meta.MA_WeeklyPayrollReportMeta;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_ConsolidatedTimesheet;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_PayrollReport;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.model.MA_WeeklyPayrollReport;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.util.MADateUtil;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

/**
 * @author Dheeraj
 * 
 */
public class PayRollBusinessService implements IPayRollBusinessService,
        MobileServiceConstants
{
	
	private static Logger   logger          = Logger.getLogger(TimeSheetBusinessService.class
	                                                .getName());
	private EntityService   service         = EntityService.getInstance();
	private EmployeeService businessService = new EmployeeService();
	
	public static double    readCounter;
	public static double    writeCounter;
	
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
			logger.log(Level.INFO, timeSheetRule.getRuleKey() + "="
			        + timeSheetRule.getValue());
		}
		
		return rulesMap;
	}
	
	/**
	 * 
	 * 
	 */
	public List<ConsolidatedTimeSheetDTO> getCurrentDayTimeSheet(
	        Long companyId, Calendar currentDate)
	{
		List<MA_Employee> employees = businessService
		        .getAllActiveEmployeeForCompany(companyId, currentDate);
		logger.log(Level.INFO, "  size  " + employees.size());
		MA_Company company = new MA_Company();
		Key companykey = AbstractEntityDAO.createKey(company, companyId);
		company = service.getCompanyObj(companykey);
		TimeZone _localTimeZone = TimeZone.getDefault();
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		
		List<ConsolidatedTimeSheetDTO> consolidatedTimeSheetDTOs = new ArrayList<ConsolidatedTimeSheetDTO>();
		
		Iterator<MA_Employee> iterator = employees.iterator();
		
		while (iterator.hasNext())
		{
			// logger.log(Level.INFO, "  1st While  ");
			MA_Employee employee = iterator.next();
			
			String employeeName = employee.getFirstName() + "  "
			        + employee.getLastName();
			String companyEmpId = employee.getCompanyEmpId();
			
			logger.log(Level.INFO, "companyEmpId=" + companyEmpId);
			MA_Shift shift = null;
			MA_Assignment employee_assignment = Datastore
			        .query(assignmentMeta)
			        .filter(assignmentMeta.employeeRef.equal(employee.getKey()),
			                assignmentMeta.status.equal(CURRENT_ASSIGNMENT))
			        .asSingle();
			
			if (null == employee_assignment)
			{
				employee_assignment = Datastore
				        .query(assignmentMeta)
				        .filter(assignmentMeta.employeeRef.equal(employee
				                .getKey()),
				                assignmentMeta.status.equal(DEFAULT_ASSIGNMENT))
				        .asSingle();
			}
			
			// logger.log(Level.INFO, "employee_assignment=" +
			// employee_assignment);
			if (null != employee_assignment
			        && (employee_assignment.getStatus() == CURRENT_ASSIGNMENT | employee_assignment
			                .getStatus() == DEFAULT_ASSIGNMENT))
			{
				String departmentName = "-";
				if (null != employee_assignment.getDeptRef().getModel())
				{
					if (employee_assignment.getDeptRef().getModel()
					        .getDepartmentName() != null)
					{
						departmentName = employee_assignment.getDeptRef()
						        .getModel().getDepartmentName();
					} else
					{
						departmentName = "-";
					}
				}
				
				if (employee_assignment.getStatus() == CURRENT_ASSIGNMENT)
				{
					// logger.log(Level.INFO, "Current Assignment");
					shift = employee_assignment.getShiftRef().getModel();
					// if (AssignmentHelper.hasShiftStarted(shift))
					// {
					List<MA_Timesheet> timesheets = getTimesheetsInADay(
					        employee_assignment.getKey(), currentDate);
					
					if (null != timesheets && timesheets.size() > 0)
					{
						Iterator<MA_Timesheet> itr = timesheets.iterator();
						// logger.log(Level.INFO,
						// "No of timesheets for emploee="
						// + timesheets.size());
						
						while (itr.hasNext())
						{
							MA_Timesheet timesheet = itr.next();
							ConsolidatedTimeSheetDTO timeSheetDTO = new ConsolidatedTimeSheetDTO();
							timeSheetDTO.setEmployeeName(employeeName);
							timeSheetDTO.setCompanyEmpId(companyEmpId);
							timeSheetDTO.setShiftName(shift.getShiftName());
							timeSheetDTO.setLocationName(shift.getLocationRef()
							        .getModel().getLocationName());
							timeSheetDTO.setTimezone(shift.getLocationRef()
							        .getModel().getTimeZone());
							timeSheetDTO.setDepartmentName(departmentName);
							
							// Calendar _cCreated = Calendar
							// .getInstance(_localTimeZone);
							Calendar _cCreated = currentDate;
							
							if (null != timesheet.getCreatedDate())
							{
								_cCreated.setTimeInMillis(timesheet
								        .getCreatedDate().getTime());
								_cCreated.setTimeZone(_localTimeZone);
								
								timeSheetDTO.setCreatedDate(DateUtil.toString(
								        _cCreated.getTime(), "MMM-dd-yyyy"));
							}
							
							// logger.log(Level.INFO,
							// "shift name="
							// + shift.getShiftName()
							// + "  location name= "
							// + shift.getLocationRef().getModel()
							// .getLocationName());
							if (null != timesheet.getInDateTime())
							{
								// Calendar _cIn = Calendar
								// .getInstance(_localTimeZone);
								Calendar _cIn = currentDate;
								_cIn.setTimeInMillis(timesheet.getInDateTime()
								        .getTime());
								_cIn.setTimeZone(_localTimeZone);
								
								timeSheetDTO
								        .setInTime(DateUtil.toString(
								                _cIn.getTime(),
								                "MMM-dd-yyyy  hh:mm a"));
							} else
							{
								timeSheetDTO.setInTime("-");
							}
							
							if (timesheet.getAttendanceCoordinates() != null)
							{
								timeSheetDTO
								        .setAttendanceCoordinatesIn(timesheet
								                .getAttendanceCoordinates()
								                .toString());
							} else
							{
								timeSheetDTO.setAttendanceCoordinatesIn("-");
							}
							if (null != timesheet.getOutDateTime())
							{
								// Calendar _cOut = Calendar
								// .getInstance(_localTimeZone);
								
								Calendar _cOut = currentDate;
								_cOut.setTimeInMillis(timesheet
								        .getOutDateTime().getTime());
								_cOut.setTimeZone(_localTimeZone);
								timeSheetDTO
								        .setOutTime(DateUtil.toString(
								                _cOut.getTime(),
								                "MMM-dd-yyyy  hh:mm a"));
							} else
							{
								timeSheetDTO.setOutTime("-");
							}
							
							if (timesheet.getAttendanceCoordinatesOut() != null)
							{
								timeSheetDTO
								        .setAttendanceCoordinatesOut(timesheet
								                .getAttendanceCoordinatesOut()
								                .toString());
							} else
							{
								timeSheetDTO.setAttendanceCoordinatesOut("-");
							}
							consolidatedTimeSheetDTOs.add(timeSheetDTO);
						}
						
					} else
					{
						ConsolidatedTimeSheetDTO timeSheetDTO = new ConsolidatedTimeSheetDTO();
						timeSheetDTO.setEmployeeName(employeeName);
						timeSheetDTO.setCompanyEmpId(companyEmpId);
						timeSheetDTO.setShiftName(shift.getShiftName());
						timeSheetDTO.setLocationName(shift.getLocationRef()
						        .getModel().getLocationName());
						timeSheetDTO.setTimezone(shift.getLocationRef()
						        .getModel().getTimeZone());
						
						timeSheetDTO.setDepartmentName(departmentName);
						
						timeSheetDTO.setInTime("-");
						timeSheetDTO.setOutTime("-");
						timeSheetDTO.setAttendanceCoordinatesIn("-");
						timeSheetDTO.setAttendanceCoordinatesOut("-");
						
						// Calendar _cCreated = Calendar
						// .getInstance(_localTimeZone);
						timeSheetDTO.setCreatedDate(DateUtil.toString(
						        currentDate.getTime(), "MMM-dd-yyyy"));
						consolidatedTimeSheetDTOs.add(timeSheetDTO);
						
					}
					
					// }
					
				} else
				{
					
					// logger.log(Level.INFO, "Default Assignment");
					List<MA_Timesheet> timesheets = getTimesheetsInADay(
					        employee_assignment.getKey(), currentDate);
					
					// logger.log(Level.INFO, "No of timesheets for emploee="
					// + timesheets.size());
					if (null != timesheets && timesheets.size() > 0)
					{
						Iterator<MA_Timesheet> itr = timesheets.iterator();
						while (itr.hasNext())
						{
							MA_Timesheet timesheet = itr.next();
							shift = timesheet.getShiftRef().getModel();
							ConsolidatedTimeSheetDTO timeSheetDTO = new ConsolidatedTimeSheetDTO();
							timeSheetDTO.setEmployeeName(employeeName);
							timeSheetDTO.setCompanyEmpId(companyEmpId);
							
							if (null != shift)
							{
								timeSheetDTO.setShiftName(shift.getShiftName());
								timeSheetDTO.setLocationName(shift
								        .getLocationRef().getModel()
								        .getLocationName());
								timeSheetDTO.setTimezone(shift.getLocationRef()
								        .getModel().getTimeZone());
								timeSheetDTO.setDepartmentName(departmentName);
								// logger.log(Level.INFO,
								// "shift name="
								// + shift.getShiftName()
								// + "  location name= "
								// + shift.getLocationRef()
								// .getModel()
								// .getLocationName());
							} else
							{
								timeSheetDTO.setShiftName("No shift");
								timeSheetDTO.setLocationName("No location");
								timeSheetDTO.setDepartmentName("No Department");
								timeSheetDTO.setTimezone("No timezone");
							}
							
							// Calendar _cCreated = Calendar
							// .getInstance(_localTimeZone);
							timeSheetDTO.setCreatedDate(DateUtil.toString(
							        currentDate.getTime(), "MMM-dd-yyyy"));
							
							if (null != timesheet.getInDateTime())
							{
								
								Calendar _cIn = Calendar
								        .getInstance(_localTimeZone);
								_cIn.setTimeInMillis(timesheet.getInDateTime()
								        .getTime());
								_cIn.setTimeZone(_localTimeZone);
								
								timeSheetDTO
								        .setInTime(DateUtil.toString(
								                _cIn.getTime(),
								                "MMM-dd-yyyy  hh:mm a"));
							} else
							{
								timeSheetDTO.setInTime("-");
							}
							if (timesheet.getAttendanceCoordinates() != null)
							{
								
								timeSheetDTO
								        .setAttendanceCoordinatesIn(timesheet
								                .getAttendanceCoordinates()
								                .toString());
							} else
							{
								timeSheetDTO.setAttendanceCoordinatesIn("-");
							}
							if (null != timesheet.getOutDateTime())
							{
								Calendar _cOut = Calendar
								        .getInstance(_localTimeZone);
								_cOut.setTimeInMillis(timesheet
								        .getOutDateTime().getTime());
								_cOut.setTimeZone(_localTimeZone);
								timeSheetDTO
								        .setOutTime(DateUtil.toString(
								                _cOut.getTime(),
								                "MMM-dd-yyyy  hh:mm a"));
								
							} else
							{
								timeSheetDTO.setOutTime("-");
							}
							if (timesheet.getAttendanceCoordinatesOut() != null)
							{
								timeSheetDTO
								        .setAttendanceCoordinatesOut(timesheet
								                .getAttendanceCoordinatesOut()
								                .toString());
							} else
							{
								
								timeSheetDTO.setAttendanceCoordinatesOut("-");
							}
							consolidatedTimeSheetDTOs.add(timeSheetDTO);
						}
						
					} else
					{
						logger.log(Level.INFO, "No Timesheet Entry.");
						ConsolidatedTimeSheetDTO timeSheetDTO = new ConsolidatedTimeSheetDTO();
						timeSheetDTO.setEmployeeName(employeeName);
						timeSheetDTO.setCompanyEmpId(companyEmpId);
						timeSheetDTO.setShiftName("-");
						timeSheetDTO.setLocationName("-");
						timeSheetDTO.setTimezone("-");
						timeSheetDTO.setDepartmentName("-");
						timeSheetDTO.setInTime("-");
						timeSheetDTO.setOutTime("-");
						timeSheetDTO.setAttendanceCoordinatesIn("-");
						timeSheetDTO.setAttendanceCoordinatesOut("-");
						// Calendar _cCreated = Calendar
						// .getInstance(_localTimeZone);
						Calendar _cCreated = currentDate;
						timeSheetDTO.setCreatedDate(DateUtil.toString(
						        _cCreated.getTime(), "MMM-dd-yyyy"));
						consolidatedTimeSheetDTOs.add(timeSheetDTO);
						
					}
				}
				
			}
			
		}
		
		return consolidatedTimeSheetDTOs;
		
	}
	
	/**
	 * @param time
	 * @return
	 */
	public String getSecondsToHHMM(Double time)
	{
		String secondsToHHMM = "0";
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
	 * @param time
	 * @return
	 */
	public float getSecondsToDecimal(Double time)
	{
		float timeInDecimal = 0.00f;
		if (time != null)
		{
			timeInDecimal = (float) (time / 3600);
			
		}
		
		return (float) timeInDecimal;
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
	
	/**
	 * Returns list of consolidatedTimesheetDTO Between Start Date and To Date
	 * 
	 * @param companyId
	 *            ,fromDtStr,toDtStr
	 * @return List<ConsolidatedTimeSheetDTO>
	 * 
	 */
	
	public List<ConsolidatedTimeSheetDTO> getPayRollTimeSheet(Long companyId,
	        String fromDtStr, String toDtStr)
	{
		
		List<MA_Employee> employees = service
		        .getAllEmployeeForCompany(companyId);
		MA_Company company = new MA_Company();
		Key companykey = AbstractEntityDAO.createKey(company, companyId);
		company = service.getCompanyObj(companykey);
		
		// @TOD Temp fix for Testing TimeZone
		
		Map<String, Long> rulesMap = getTimesheetRulesMapOfCompany(companyId);
		
		Long minEffortsForHalfDay = rulesMap
		        .get(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS);
		
		Long minDailyEfforts = rulesMap
		        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS);
		
		Long minOverTimeEfforts = rulesMap
		        .get(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS);
		
		Long billingRule = rulesMap
		        .get(IMobileAttendanceConstants.BILLING_RULE);
		
		logger.log(Level.INFO, "Billing rule=" + billingRule);
		
		TimeZone _localTimeZone = TimeZone.getDefault();
		
		Date fromDate = DateUtil.toDate(fromDtStr, "MM/dd/yyyy");
		Date toDate = DateUtil.toDate(toDtStr, "MM/dd/yyyy");
		Calendar cal = DateUtil.toCalendar(toDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		toDate = new Date(cal.getTimeInMillis());
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		
		List<ConsolidatedTimeSheetDTO> consolidatedTimeSheetDTOs = new ArrayList<ConsolidatedTimeSheetDTO>();
		
		Iterator<MA_Employee> iterator = employees.iterator();
		
		while (iterator.hasNext())
		{
			logger.log(Level.INFO, "  1st While  ");
			MA_Employee employee = iterator.next();
			
			String employeeName = employee.getFirstName() + "  "
			        + employee.getLastName();
			Long employeeId = employee.getKey().getId();
			String companyEmpId = employee.getCompanyEmpId();
			String designation = employee.getSkillRef().getModel().getSkill();
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
				logger.log(Level.INFO, "  2nd While  ");
				MA_Assignment assignment = assignmentIterator.next();
				
				if (assignment.getStatus() != FUTURE_ASSIGNMENT)
				{
					MA_Shift shift = assignment.getShiftRef().refresh();
					
					// Get Location and TimeZones
					MA_Location _location = null;
					_location = (shift == null) ? null : shift.getLocationRef()
					        .refresh();
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
					                        .greaterThanOrEqual(fromDate),
					                consolidatedTimesheetMeta.approved
					                        .equal("Y")).asList();
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
							timeSheetDTO.setDesignation(designation);
							
							if (employee.getEmployeeType().trim().equals("1"))
							{
								timeSheetDTO.setEmployeeType("Permanent");
							} else if (employee.getEmployeeType().trim()
							        .equals("2"))
							{
								timeSheetDTO.setEmployeeType("Contractor");
							}
							String shiftName = null;
							
							logger.log(Level.INFO, "assignmentShiftName = "
							        + assignmentShiftName);
							if (assignmentShiftName.equals("-"))
							{
								shift = consolidatedTimesheet.getShiftRef()
								        .refresh();
								
								logger.log(Level.INFO, "Shift Id = "
								        + shift.getKey().getId());
								shiftName = shift.getShiftName();
								_location = shift.getLocationRef().refresh();
								locationName = _location.getLocationName();
								
								_localTimeZone = TimeZone.getTimeZone(_location
								        .getTimeZone());
								
							} else
							{
								shiftName = assignmentShiftName;
							}
							timeSheetDTO.setLocationName(locationName);
							timeSheetDTO.setShiftName(shiftName);
							timeSheetDTO.setCompanyEmpId(companyEmpId);
							
							Calendar _cCreated = Calendar
							        .getInstance(_localTimeZone);
							
							if (null != consolidatedTimesheet.getCreatedDate())
							{
								_cCreated.setTimeInMillis(consolidatedTimesheet
								        .getCreatedDate().getTime());
								_cCreated.setTimeZone(_localTimeZone);
								timeSheetDTO.setCreatedDate(DateUtil.toString(
								        _cCreated.getTime(), "MM-dd-yyyy"));
								
							}
							Calendar _cIn = Calendar
							        .getInstance(_localTimeZone);
							
							logger.log(
							        Level.INFO,
							        "consolidatedTimesheet.getInDateTime()="
							                + consolidatedTimesheet
							                        .getInDateTime());
							if (consolidatedTimesheet.getInDateTime() != null)
							{
								_cIn.setTimeInMillis(consolidatedTimesheet
								        .getInDateTime().getTime());
								_cIn.setTimeZone(_localTimeZone);
								
								timeSheetDTO.setInTime(DateUtil.toString(
								        _cIn.getTime(), "MM-dd-yyyy  hh:mm a"));
								timeSheetDTO.setInTimeDayOfWeek(DateUtil
								        .toString(_cIn.getTime(), "EEE"));
							} else
							{
								
								timeSheetDTO.setInTime("-");
								timeSheetDTO.setInTimeDayOfWeek("-");
								timeSheetDTO.setOutTimeDayOfWeek("-");
								timeSheetDTO
								        .setEffortResult(IMobileAttendanceConstants.NOT_REPORTED);
							}
							
							Calendar _cOut = null;
							
							logger.log(
							        Level.INFO,
							        "consolidatedTimesheet.getOutDateTime()="
							                + consolidatedTimesheet
							                        .getOutDateTime());
							if (consolidatedTimesheet.getOutDateTime() != null)
							{
								_cOut = Calendar.getInstance(_localTimeZone);
								_cOut.setTimeInMillis(consolidatedTimesheet
								        .getOutDateTime().getTime());
								_cOut.setTimeZone(_localTimeZone);
								timeSheetDTO
								        .setOutTime(DateUtil.toString(
								                _cOut.getTime(),
								                "MM-dd-yyyy  hh:mm a"));
								timeSheetDTO.setOutTimeDayOfWeek(DateUtil
								        .toString(_cIn.getTime(), "EEE"));
							} else
							{
								
								timeSheetDTO.setOutTime("-");
								
								if (consolidatedTimesheet.getInDateTime() != null)
								{
									timeSheetDTO
									        .setEffortResult(IMobileAttendanceConstants.NO_OUT_TIME);
								}
								
							}
							
							timeSheetDTO
							        .setActualEffort(getSecondsToHHMM(consolidatedTimesheet
							                .getActualDailyEffort()));
							timeSheetDTO
							        .setOverTime(getSecondsToHHMM(consolidatedTimesheet
							                .getOverTime()));
							timeSheetDTO
							        .setApprovalResult(consolidatedTimesheet
							                .getApprovalResult());
							
							// 03/28/2012 Shailesh Following code is a for a new
							// report format.
							
							String approvedEffortResult = consolidatedTimesheet
							        .getApprovalResult();
							
							if (billingRule == 1)
							{
								
								if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.FULL_DAY_STR))
								{
									timeSheetDTO
									        .setRegularEffort(getSecondsToHHMM(consolidatedTimesheet
									                .getActualDailyEffort()));
									timeSheetDTO
									        .setLeave(IMobileAttendanceConstants.ZERO_HRS);
									
								} else if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.HALF_DAY_STR))
								{
									
									timeSheetDTO
									        .setRegularEffort(getSecondsToHHMM(consolidatedTimesheet
									                .getActualDailyEffort()));
									timeSheetDTO
									        .setLeave(getSecondsToHHMM(new Double(
									                minEffortsForHalfDay)));
									
								} else if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.OVER_TIME_STR))
								{
									
									timeSheetDTO
									        .setRegularEffort(getSecondsToHHMM(new Double(
									                minDailyEfforts)));
									timeSheetDTO
									        .setLeave(IMobileAttendanceConstants.ZERO_HRS);
									timeSheetDTO
									        .setOverTime(getSecondsToHHMM(consolidatedTimesheet
									                .getActualDailyEffort()
									                - new Double(
									                        minDailyEfforts)));
								}
								
								else if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.UNPAID_LEAVE_STR))
								{
									timeSheetDTO
									        .setRegularEffort(IMobileAttendanceConstants.ZERO_HRS);
									timeSheetDTO
									        .setLeave(getSecondsToHHMM(new Double(
									                minDailyEfforts)));
								}
								
								else if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.UNRESOLVED_STR))
								{
									
									timeSheetDTO
									        .setRegularEffort(IMobileAttendanceConstants.ZERO_HRS);
									timeSheetDTO
									        .setLeave(IMobileAttendanceConstants.ZERO_HRS);
								}
								
							} else
							{
								
								if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.FULL_DAY_STR))
								{
									
									timeSheetDTO
									        .setRegularEffort(getSecondsToHHMM(new Double(
									                minDailyEfforts)));
									timeSheetDTO
									        .setLeave(IMobileAttendanceConstants.ZERO_HRS);
									timeSheetDTO
									        .setActualEffort(getSecondsToHHMM(new Double(
									                minDailyEfforts)));
									
								} else if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.HALF_DAY_STR))
								{
									
									timeSheetDTO
									        .setRegularEffort(getSecondsToHHMM(new Double(
									                minEffortsForHalfDay)));
									timeSheetDTO
									        .setLeave(getSecondsToHHMM(new Double(
									                minEffortsForHalfDay)));
									timeSheetDTO
									        .setActualEffort(getSecondsToHHMM(new Double(
									                minEffortsForHalfDay)));
									
								} else if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.OVER_TIME_STR))
								{
									
									timeSheetDTO
									        .setRegularEffort(getSecondsToHHMM(new Double(
									                minDailyEfforts)));
									timeSheetDTO
									        .setLeave(IMobileAttendanceConstants.ZERO_HRS);
									timeSheetDTO
									        .setOverTime(getSecondsToHHMM(new Double(
									                minOverTimeEfforts)));
									timeSheetDTO
									        .setActualEffort(getSecondsToHHMM(new Double(
									                minDailyEfforts
									                        + minOverTimeEfforts)));
								}
								
								else if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.UNPAID_LEAVE_STR))
								{
									
									timeSheetDTO
									        .setRegularEffort(IMobileAttendanceConstants.ZERO_HRS);
									timeSheetDTO
									        .setLeave(getSecondsToHHMM(new Double(
									                minDailyEfforts)));
								}
								
								else if (approvedEffortResult
								        .equals(IMobileAttendanceConstants.UNRESOLVED_STR))
								{
									
									timeSheetDTO
									        .setRegularEffort(IMobileAttendanceConstants.ZERO_HRS);
									timeSheetDTO
									        .setLeave(IMobileAttendanceConstants.ZERO_HRS);
								}
							}
							
							consolidatedTimeSheetDTOs.add(timeSheetDTO);
							
						}
						
					}
					
				}
			}
		}
		
		return consolidatedTimeSheetDTOs;
	}
	
	/**
	 * Returns Timesheet Of Given Date
	 * 
	 * @param assignmentKey
	 * @param createDate
	 * @return
	 */
	private List<MA_Timesheet> getTimesheetsInADay(Key assignmentKey,
	        Calendar createDate)
	{
		
		logger.log(Level.INFO, "   Start getTimesheetsInADay  ");
		
		MA_TimesheetMeta timesheetMeta = MA_TimesheetMeta.get();
		
		ModelQuery<MA_Timesheet> query = Datastore.query(MA_Timesheet.class);
		query.sort(new Sort("createdDate"));
		
		List<MA_Timesheet> timesheets = query
		        .filter(timesheetMeta.assignmentRef.equal(assignmentKey),
		                timesheetMeta.createDay.equal(createDate
		                        .get(Calendar.DAY_OF_MONTH)),
		                timesheetMeta.createMonth.equal(createDate
		                        .get(Calendar.MONTH)),
		                timesheetMeta.createYear.equal(createDate
		                        .get(Calendar.YEAR))).asList();
		logger.log(Level.INFO, "   in getTimesheetsInADay  ");
		return timesheets;
	}
	
	/**
	 * Returns list of PayrollDTO
	 * 
	 * @param input
	 * @param companyId
	 * @return
	 */
	public List<PayrollDTO> populateWeeklyPayrollList(
	        Map<String, Object> input, long companyId)
	{
		
		List<PayrollDTO> weeklyPayrollReportList = new ArrayList<PayrollDTO>();
		
		Calendar c = Calendar.getInstance();
		Date startDate;
		Date endDate;
		
		int year = Integer.parseInt((String) input.get("year"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
		SimpleDateFormat monthName = new SimpleDateFormat("MMMM");
		
		c.clear();
		c.set(year, 0, 1, 0, 0, 0);
		
		List<MA_WeeklyPayrollReport> report_list = getWeeklyPayrollReport(companyId);
		
		while (year == c.get(Calendar.YEAR))
		{
			Calendar c_copy = Calendar.getInstance();
			c_copy.clear();
			c_copy.setTime(c.getTime());
			
			PayrollDTO weeklyPayrollReport = new PayrollDTO();
			
			Calendar _cWeekStartAndEndDate[] = MADateUtil
			        .getDisplayWeekStartAndEndDates(c_copy);
			
			if (_cWeekStartAndEndDate != null)
			{
				Calendar _start = _cWeekStartAndEndDate[0];
				Calendar _end = _cWeekStartAndEndDate[1];
				// c.set(year, month, date, hourOfDay, minute, second);
				startDate = _start.getTime();
				endDate = _end.getTime();
				int week = _start.get(Calendar.WEEK_OF_YEAR);
				int month = _start.get(Calendar.MONTH) + 1;
				String monthNo = (month < 10 ? "0" + month : Integer
				        .toString(month));
				Iterator<MA_WeeklyPayrollReport> itr1 = report_list.iterator();
				while (itr1.hasNext())
				{
					MA_WeeklyPayrollReport report = itr1.next();
					Date report_startDate = report.getWeekStartDate();
					if (dateFormat.format(report_startDate).equalsIgnoreCase(
					        dateFormat.format(startDate))
					        && !report.getWeeklyReport().toString()
					                .equals("<Text: >"))
					{
						weeklyPayrollReport.setNoOfRecords(report
						        .getNoOfRecords());
					} else if (weeklyPayrollReport.getNoOfRecords() == 0)
					{
						weeklyPayrollReport.setNoOfRecords(0);
					}
				}
				weeklyPayrollReport.setStartTime(startDate.getTime());
				weeklyPayrollReport.setMonthName(monthNo + "-"
				        + monthName.format(startDate));
				weeklyPayrollReport.setEndDate(dateFormat.format(endDate));
				weeklyPayrollReport.setStartDate(dateFormat.format(startDate));
				weeklyPayrollReport.setWeekNo((week < 10 ? "0" + week : Integer
				        .toString(week)));
				
				c.setTime(endDate);
				
				weeklyPayrollReportList.add(weeklyPayrollReport);
			}
			c.add(Calendar.DATE, 1);
		}
		
		return weeklyPayrollReportList;
	}
	
	/**
	 * This method reads the ConsolidatedTimesheet and based on the approved
	 * recrods it create the Payroll for the company.
	 * 
	 * @param company
	 * @param fromDtStr
	 * @param toDtStr
	 * @return
	 */
	public List<PayrollDTO> constructPeriodicPayrollReport(MA_Company company,
	        Date fromDate, Date toDate)
	{
		EmployeeService businessService = new EmployeeService();
		
		long companyId = company.getKey().getId();
		
		// @TOD Temp fix for Testing TimeZone
		
		Map<String, Long> rulesMap = getTimesheetRulesMapOfCompany(companyId);
		
		Long minDailyEfforts = rulesMap
		        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS);
		
		Long billingRule = rulesMap
		        .get(IMobileAttendanceConstants.BILLING_RULE);
		
		logger.log(Level.INFO, "Billing rule=" + billingRule);
		
		Calendar fromCal = DateUtil.toCalendar(fromDate);
		List<MA_Employee> employees = businessService
		        .getAllActiveEmployeeForCompany(companyId, fromCal);
		
		Calendar toCal = DateUtil.toCalendar(toDate);
		toCal.add(Calendar.DAY_OF_MONTH, 1);
		toDate = new Date(toCal.getTimeInMillis());
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		
		List<PayrollDTO> weeklyPayrollDTOs = new ArrayList<PayrollDTO>();
		
		Iterator<MA_Employee> iterator = employees.iterator();
		
		while (iterator.hasNext())
		{
			logger.log(Level.INFO, "  1st While ");
			
			MA_Employee employee = iterator.next();
			
			String employeeName = employee.getFirstName() + "  "
			        + employee.getLastName();
			
			String companyEmpId = employee.getCompanyEmpId();
			String designation = employee.getSkillRef().getModel().getSkill();
			String overTime = "-";
			int presentDays = 0;
			int weeklyOff = 0;
			int compOff = 0;
			int paidLeave = 0;
			int casualLeave = 0;
			int unpaidLeave = 0;
			int locationHoliday = 0;
			double OTSeconds = 0;
			float timeInDeecimal = 0.00f;
			
			// int noOfDays = fromCal.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			long noOfDays = (toCal.getTimeInMillis() - fromCal
			        .getTimeInMillis()) / (24 * 60 * 60 * 1000);
			
			PayrollDTO timeSheetDTO = new PayrollDTO();
			timeSheetDTO.setCompanyEmpId(companyEmpId);
			timeSheetDTO.setEmployeeName(employeeName);
			timeSheetDTO.setDesignation(designation);
			
			// workingDays = getworkingDaysofWeek(employee, fromDate, toDate);
			
			if (employee.getEmployeeType().trim().equals("1"))
			{
				timeSheetDTO.setEmployeeType("Permanent");
			} else if (employee.getEmployeeType().trim().equals("2"))
			{
				timeSheetDTO.setEmployeeType("Contractor");
			}
			
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
				logger.log(Level.INFO, "  2nd While  ");
				MA_Assignment assignment = assignmentIterator.next();
				
				if (assignment.getStatus() != FUTURE_ASSIGNMENT)
				{
					List<MA_ConsolidatedTimesheet> consolidatedTimesheets = Datastore
					        .query(consolidatedTimesheetMeta)
					        .filter(consolidatedTimesheetMeta.assignmentRef.equal(assignment
					                .getKey()),
					                consolidatedTimesheetMeta.createdDate
					                        .greaterThanOrEqual(fromDate),
					                consolidatedTimesheetMeta.approved
					                        .equal("Y")).asList();
					readCounter += consolidatedTimesheets.size();
					
					logger.log(Level.INFO, "read counter" + readCounter);
					
					Iterator<MA_ConsolidatedTimesheet> timesheetIterator = consolidatedTimesheets
					        .iterator();
					while (timesheetIterator.hasNext())
					{
						
						MA_ConsolidatedTimesheet consolidatedTimesheet = timesheetIterator
						        .next();
						
						String approvedEffortResult = consolidatedTimesheet
						        .getApprovalResult();
						if (approvedEffortResult != null)
						{
							
							if (approvedEffortResult
							        .equals(IMobileAttendanceConstants.FULL_DAY_STR))
							{
								presentDays += 1;
								
							} else if (approvedEffortResult
							        .equals(IMobileAttendanceConstants.HALF_DAY_STR))
							{
								presentDays += 0.5;
								
							} else if (approvedEffortResult
							        .equals(IMobileAttendanceConstants.OVER_TIME_STR))
							{
								presentDays += 1;
								OTSeconds += consolidatedTimesheet
								        .getActualDailyEffort()
								        - new Double(minDailyEfforts);
							} else if (approvedEffortResult
							        .equals(IMobileAttendanceConstants.UNPAID_LEAVE_STR))
							{
								unpaidLeave++;
							}
							
							else if (approvedEffortResult
							        .equals(IMobileAttendanceConstants.PAID_LEAVE_STR))
							{
								paidLeave++;
								
							} else if (approvedEffortResult
							        .equals(IMobileAttendanceConstants.COMP_OFF_STR))
							{
								compOff++;
							} else if (approvedEffortResult
							        .equals(IMobileAttendanceConstants.CASUAL_LEAVE_STR))
							{
								casualLeave++;
							} else if (approvedEffortResult
							        .equals(IMobileAttendanceConstants.WEEKLY_OFF_STR))
							{
								weeklyOff++;
							} else if (approvedEffortResult
							        .equals(IMobileAttendanceConstants.LOCATION_HOLIDAY_STR))
							{
								locationHoliday++;
							}
						}
					}
					
				}
			}
			int totalDays = presentDays + paidLeave + casualLeave + compOff
			        + weeklyOff + locationHoliday;
			float absentDays = noOfDays - totalDays;
			overTime = getSecondsToHHMM(OTSeconds);
			timeInDeecimal = getSecondsToDecimal(OTSeconds);
			
			timeSheetDTO.setOtInDecimal(timeInDeecimal);
			timeSheetDTO.setTotalDays(totalDays);
			timeSheetDTO.setPresentDays(presentDays);
			timeSheetDTO.setUnpaidLeave(unpaidLeave);
			timeSheetDTO.setLocationHolidays(locationHoliday);
			timeSheetDTO.setCompOff(compOff);
			timeSheetDTO.setWeeklyOff(weeklyOff);
			timeSheetDTO.setCalendarDays(noOfDays);
			timeSheetDTO.setPaidLeave(paidLeave);
			timeSheetDTO.setOverTime(overTime);
			timeSheetDTO.setCasualLeave(casualLeave);
			timeSheetDTO.setAbsentDays(absentDays);
			weeklyPayrollDTOs.add(timeSheetDTO);
		}
		
		return weeklyPayrollDTOs;
	}
	
	/**
	 * gets list of weeklyPayrollReportDTO and Convert into String Buffer
	 * 
	 * @param weeklyPayrollDTOs
	 * @return
	 */
	public StringBuffer convertPayrollDTOtoString(
	        List<PayrollDTO> weeklyPayrollDTOs)
	{
		
		StringBuffer _sb = new StringBuffer();
		
		for (Iterator<PayrollDTO> iterator = weeklyPayrollDTOs.iterator(); iterator
		        .hasNext();)
		{
			PayrollDTO weeklyPayrollDTO = (PayrollDTO) iterator.next();
			DecimalFormat df = new DecimalFormat("###.#");
			String _row = "";
			_row = weeklyPayrollDTO.getCompanyEmpId();
			_row += ",";
			_row += weeklyPayrollDTO.getEmployeeName();
			_row += ",";
			_row += weeklyPayrollDTO.getEmployeeType();
			_row += ",";
			_row += weeklyPayrollDTO.getDesignation();
			_row += ",";
			_row += weeklyPayrollDTO.getCalendarDays();
			_row += ",";
			_row += weeklyPayrollDTO.getPresentDays();
			_row += ",";
			_row += weeklyPayrollDTO.getWeeklyOff();
			_row += ",";
			_row += weeklyPayrollDTO.getCompOff();
			_row += ",";
			_row += weeklyPayrollDTO.getLocationHolidays();
			_row += ",";
			_row += weeklyPayrollDTO.getPaidLeave();
			_row += ",";
			_row += weeklyPayrollDTO.getCasualLeave();
			_row += ",";
			_row += weeklyPayrollDTO.getTotalDays();
			_row += ",";
			_row += weeklyPayrollDTO.getAbsentDays();
			_row += ",";
			_row += df.format(weeklyPayrollDTO.getOtInDecimal());
			_row += "\n";
			_sb.append(_row);
		}
		
		return _sb;
	}
	
	/**
	 * @param companyId
	 * @return
	 */
	private List<MA_WeeklyPayrollReport> getWeeklyPayrollReport(long companyId)
	{
		MA_WeeklyPayrollReportMeta p = new MA_WeeklyPayrollReportMeta();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		List<MA_WeeklyPayrollReport> report_list = Datastore.query(p)
		        .filter(p.companyRef.equal(k)).asList();
		
		return report_list;
	}
	
	/**
	 * @param companyId
	 * @param startDate
	 * @return
	 */
	public MA_WeeklyPayrollReport getWeeklyEffortReport(long companyId,
	        Date startDate)
	{
		MA_WeeklyPayrollReportMeta p = new MA_WeeklyPayrollReportMeta();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		MA_WeeklyPayrollReport report = Datastore
		        .query(p)
		        .filter(p.companyRef.equal(k), p.weekStartDate.equal(startDate))
		        .asSingle();
		
		return report;
	}
	
	/**
	 * 
	 * @param input
	 * @param companyId
	 * @return
	 */
	public List<PayrollDTO> populateMonthlyPayrollList(
	        Map<String, Object> input, long companyId)
	{
		List<PayrollDTO> monthlyPayrollReportList = new ArrayList<PayrollDTO>();
		
		Calendar c = Calendar.getInstance();
		Date startDate;
		Date endDate;
		
		int year = Integer.parseInt((String) input.get("year"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
		SimpleDateFormat monthName = new SimpleDateFormat("MMMM");
		
		c.clear();
		c.set(year, 0, 1, 0, 0, 0);
		
		List<MA_PayrollReport> report_list = getMonthlyPayrollReport(companyId);
		
		while (year == c.get(Calendar.YEAR))
		{
			PayrollDTO monthlyPayrollReport = new PayrollDTO();
			
			Calendar _start = Calendar.getInstance();
			Calendar _end = Calendar.getInstance();
			_start.clear();
			_end.clear();
			
			_start.setTime(c.getTime());
			
			c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			_end.setTime(c.getTime());
			
			// c.set(year, month, date, hourOfDay, minute, second);
			startDate = _start.getTime();
			endDate = _end.getTime();
			
			int month = _start.get(Calendar.MONTH);
			String monthNo = (month < 10 ? "0" + month : Integer
			        .toString(month));
			Iterator<MA_PayrollReport> itr1 = report_list.iterator();
			while (itr1.hasNext())
			{
				MA_PayrollReport report = itr1.next();
				
				if (month == report.getMonthNo()
				        && !report.getReport().toString().equals("<Text: >") && year==report.getYear())
				{
					monthlyPayrollReport
					        .setNoOfRecords(report.getNoOfRecords());
					// System.out.println(startDate);
					
				} else if (monthlyPayrollReport.getNoOfRecords() == 0)
				{
					monthlyPayrollReport.setNoOfRecords(0);
				}
			}
			monthlyPayrollReport.setStartTime(startDate.getTime());
			monthlyPayrollReport.setMonthName(monthNo + "-"
			        + monthName.format(startDate));
			monthlyPayrollReport.setEndDate(dateFormat.format(endDate));
			monthlyPayrollReport.setStartDate(dateFormat.format(startDate));
			
			c.setTime(endDate);
			
			monthlyPayrollReportList.add(monthlyPayrollReport);
			logger.log(Level.INFO, "Date" + c.getTime());
			c.add(Calendar.MONTH, 1);
			c.set(Calendar.DATE, 1);
		}
		return monthlyPayrollReportList;
	}
	
	/**
	 * <pre>
	 * Reads data from database
	 * </pre>
	 * 
	 * @param companyId
	 * @return
	 */
	private List<MA_PayrollReport> getMonthlyPayrollReport(long companyId)
	{
		MA_PayrollReportMeta p = new MA_PayrollReportMeta();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		List<MA_PayrollReport> report = Datastore.query(p)
		        .filter(p.companyRef.equal(k)).asList();
		
		return report;
	}
	
	/**
	 * @param companyId
	 * @param StartDate
	 * @return
	 */
	public MA_PayrollReport getMonthlyPayrollReport(long companyId, int month)
	{
		MA_PayrollReportMeta p = new MA_PayrollReportMeta();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		MA_PayrollReport report = Datastore.query(p)
		        .filter(p.companyRef.equal(k), p.monthNo.equal(month))
		        .asSingle();
		
		return report;
	}
	
	/**
	 * Calculate the Payroll report and store the in MA_PayrollReport
	 * 
	 * @param companyId
	 * @param _fromDate
	 * @param _endDate
	 */
	public void storePayrollReport(long companyId, Date _fromDate, Date _endDate)
	{
		MA_PayrollReport monthlyPayroll = new MA_PayrollReport();
		MA_Company company = new MA_Company();
		Key companykey = AbstractEntityDAO.createKey(company, companyId);
		company = service.getCompanyObj(companykey);
		
		List<PayrollDTO> monthlyPayrollDTO = constructPeriodicPayrollReport(
		        company, _fromDate, _endDate);
		
		int noOfRecords = monthlyPayrollDTO.size();
		
		StringBuffer _monthlyPayrollAsCSV = convertPayrollDTOtoString(monthlyPayrollDTO);
		Calendar fromcal = DateUtil.toCalendar(_fromDate);
		
		monthlyPayroll.setStartDate(_fromDate);
		monthlyPayroll.setEndDate(_endDate);
		monthlyPayroll.getCompanyRef().setModel(company);
		monthlyPayroll.setCreatedBy("queue_process");
		monthlyPayroll.setNoOfRecords(noOfRecords);
		monthlyPayroll.setReport(new Text(_monthlyPayrollAsCSV.toString()));
		monthlyPayroll.setIntervalNum(fromcal.get(Calendar.MONTH));
		monthlyPayroll.setMonthNo(fromcal.get(Calendar.MONTH));
		monthlyPayroll.setYear(fromcal.get(Calendar.YEAR));
		
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		AbstractEntityDAO.addModel(monthlyPayroll);
		gtx.commit();
		
	}
}