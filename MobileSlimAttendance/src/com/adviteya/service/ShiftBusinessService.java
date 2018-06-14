package com.adviteya.service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.joda.time.DateTimeZone;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.LocationDTO;
import com.adviteya.dto.ShiftDTO;
import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.meta.MA_EmployeeMeta;
import com.adviteya.meta.MA_ShiftMeta;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.model.MA_User;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.ShiftDAO;
import com.google.appengine.api.datastore.Key;

public class ShiftBusinessService implements IShiftBusinessService,
        IMobileAttendanceConstants
{
	private static Logger logger        = Logger.getLogger(ShiftBusinessService.class
	                                            .getName());
	private EntityService entityService = EntityService.getInstance();
	
	/**
     * 
     */
	public String createShift(Map<String, Object> input)
	{
		// TODO Auto-generated method stub
		String status = "failure";
		String locationId = (String) input.get("location");
		String shiftName = (String) input.get("shiftName");
		int start_hrs = Integer.parseInt((String) input.get("start_hrs"));
		int start_min = Integer.parseInt((String) input.get("start_min"));
		int end_hrs = Integer.parseInt((String) input.get("end_hrs"));
		int end_min = Integer.parseInt((String) input.get("end_min"));
		String active = "Y";
		
		MA_Location location = new MA_Location();
		Key k1 = Datastore.createKey(MA_Location.class,
		        Long.parseLong(locationId));
		location = Datastore.get(MA_Location.class, k1);
		
		int[] start_time = convertHHMMFromLocalToGMT(location.getTimeZone(),
		        start_hrs, start_min);
		
		int[] end_time = convertHHMMFromLocalToGMT(location.getTimeZone(),
		        end_hrs, end_min);
		
		MA_Shift shift = new MA_Shift();
		shift.setShiftName(shiftName);
		shift.setStartHrs(start_hrs);
		shift.setStartMin(start_min);
		shift.setEndHrs(end_hrs);
		shift.setEndMin(end_min);
		
		shift.setStartGMTHrs(start_time[0]);
		shift.setStartGMTMin(start_time[1]);
		shift.setEndGMTHrs(end_time[0]);
		shift.setEndGMTMin(end_time[1]);
		
		shift.getLocationRef().setModel(location);
		shift.setActive(active);
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		Key k = AbstractEntityDAO.addModel(shift);
		gtx.commit();
		status = ("" + k.getId()).trim();
		logger.log(Level.INFO, "createShift Status-" + status);
		return status;
		
	}
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	public List<ShiftDTO> getShiftListForCompany(Long companyId)
	{
		LocationBusinessService locationBusinessService = new LocationBusinessService();
		
		logger.log(Level.INFO, "Start getShiftListForCompany");
		List<ShiftDTO> shiftDTOList = new ArrayList<ShiftDTO>();
		LocationBusinessService businessService = new LocationBusinessService();
		List<LocationDTO> locationList = businessService
		        .getLocationListForCompany(companyId);
		Iterator<LocationDTO> itr = locationList.iterator();
		
		while (itr.hasNext())
		{
			LocationDTO location = (LocationDTO) itr.next();
			Long locationId = location.getLocationId();
			List<MA_Shift> shiftList = entityService
			        .getAllShifForLocation(locationId);
			Iterator<MA_Shift> itr1 = shiftList.iterator();
			String timeZone = location.getTimezone();
			while (itr1.hasNext())
			{
				ShiftDTO shiftDTO = new ShiftDTO();
				MA_Shift shift = (MA_Shift) itr1.next();
				int start_hrs = shift.getStartHrs();
				int start_min = shift.getStartMin();
				int end_hrs = shift.getEndHrs();
				int end_min = shift.getEndMin();
				
				float startTime = (start_hrs * 60) + start_min;
				float endTime = (end_hrs * 60) + end_min;
				
				shiftDTO.setShiftId(shift.getKey().getId());
				shiftDTO.setLocationName(location.getLocationName());
				String status = shift.getActive();
				Date createdDate = shift.getCreatedDate();
				
				TimeZone tz = TimeZone.getTimeZone(timeZone);
				long offset = tz.getRawOffset();
				
				shiftDTO.setTimeZone(timeZone);
				
				long time = createdDate.getTime();
				time = time + offset;
				createdDate.setTime(time);
				
				if (null != status && status.equals("Y"))
				{
					shiftDTO.setActive("ACTIVE");
					
				} else
				{
					shiftDTO.setActive("INACTIVE");
				}
				
				shiftDTO.setCreatedDate(DateFormat.getInstance().format(
				        createdDate));
				
				boolean flag = false;
				
				if (endTime < startTime)
				{
					flag = true;
				}
				
				int duration = 0;
				if (flag)
				{
					duration = (int) ((1440 - startTime) + endTime);
				} else
				{
					duration = (int) (endTime - startTime);
				}
				
				int duration_hrs = duration / 60;
				int duration_min = (duration % 60);
				String startHrs = "";
				String startMin = "";
				String endHrs = "";
				String endMin = "";
				String durationHrs = "";
				String durationMin = "";
				
				if ((start_hrs / 10) == 0)
				{
					startHrs = "0" + start_hrs;
				} else
				{
					startHrs = start_hrs + "";
				}
				if ((start_min / 10) == 0)
				{
					startMin = "0" + start_min;
				} else
				{
					startMin = start_min + "";
				}
				if ((end_hrs / 10) == 0)
				{
					endHrs = "0" + end_hrs;
				} else
				{
					endHrs = end_hrs + "";
				}
				if ((end_min / 10) == 0)
				{
					endMin = "0" + end_min;
				} else
				{
					endMin = end_min + "";
				}
				if ((duration_hrs / 10) == 0)
				{
					durationHrs = "0" + duration_hrs;
				} else
				{
					durationHrs = duration_hrs + "";
				}
				if ((duration_min / 10) == 0)
				{
					durationMin = "0" + duration_min;
				} else
				{
					durationMin = duration_min + "";
				}
				shiftDTO.setShiftName(shift.getShiftName());
				shiftDTO.setStartTime(startHrs + ":" + startMin + " Hrs");
				
				if (endTime < startTime)
				{
					shiftDTO.setEndTime(endHrs + ":" + endMin
					        + " Hrs (Next Day)");
				} else
				{
					shiftDTO.setEndTime(endHrs + ":" + endMin + " Hrs");
				}
				shiftDTO.setDuration(durationHrs + " h " + durationMin
				        + " mins");
				
				shiftDTOList.add(shiftDTO);
			}
			
		}
		
		logger.log(Level.INFO,
		        "End getShiftListForCompany no of shifts for the company = "
		                + shiftDTOList.size());
		return shiftDTOList;
	}
	
	/**
	 * This method gets all the employees allocated to a MobileSupervisor
	 * 
	 * @return
	 */
	public static List<MA_Timesheet> getTimesheetsAssignedToMobSupervisor(
	        MA_User user)
	{
		logger.log(Level.INFO,
		        "-- Inside ShiftBusinessService getTimesheetsAssignedToMobSupervisor --");
		/**
		 * <pre>
		 * 1. GET ALL THE SHIFTS FOR THE GIVEN USER 
		 * 2. FOR THE GIVEN LIST OF SHIFT FIND ALL THE EMPLOYEES 
		 * 3. RETURN LIST OF EMPLOYEES
		 * </pre>
		 */
		List<MA_Timesheet> timesheets = ShiftDAO
		        .getTimesheetsAssignedToMobSupervisor(user);
		
		for (int q = 0; q < timesheets.size(); q++)
		{
			MA_Timesheet _t = (MA_Timesheet) timesheets.get(q);
			logger.log(Level.INFO, "Timesheet Asg Id = "
			        + _t.getAssignmentRef().getKey().getId());
		}
		
		return timesheets;
		
	}
	
	/**
	 * This method gets all the employees NOT allocated to a MobileSupervisor
	 * 
	 * @return
	 */
	public static List<MA_Timesheet> getTimesheetsNOTAssignedToMobSupervisor(
	        MA_User user)
	{
		logger.log(Level.INFO,
		        "Inside ShiftBusinessService getTimesheetsNOTAssignedToMobSupervisor");
		
		/**
		 * <pre>
		 * 1. GET ALL THE SHIFTS FOR THE GIVEN USER 
		 * 2. FOR THE GIVEN LIST OF SHIFT FIND ALL THE EMPLOYEES 
		 * 3. RETURN LIST OF EMPLOYEES
		 * </pre>
		 */
		List<MA_Timesheet> timesheets = ShiftDAO
		        .getTimesheetsAssignedWithoutMobSupervisor(user);
		
		for (int q = 0; q < timesheets.size(); q++)
		{
			MA_Timesheet _t = (MA_Timesheet) timesheets.get(q);
			logger.log(Level.INFO, "Timesheet Asg Id"
			        + _t.getAssignmentRef().getKey().getId());
		}
		
		return timesheets;
		
	}
	
	public ShiftDTO getShiftDetails(Long shiftId)
	{
		Key k = Datastore.createKey(MA_Shift.class, shiftId);
		MA_ShiftMeta shiftMeta = MA_ShiftMeta.get();
		MA_Shift shift = Datastore.query(shiftMeta)
		        .filter(shiftMeta.key.equal(k)).asSingle();
		
		ShiftDTO shiftDTO = new ShiftDTO();
		shiftDTO.setShiftId(shift.getKey().getId());
		shiftDTO.setLocationId(shift.getLocationRef().getKey().getId());
		shiftDTO.setShiftName(shift.getShiftName());
		shiftDTO.setStartHrs(shift.getStartHrs() + "");
		shiftDTO.setStartMin(shift.getStartMin() + "");
		shiftDTO.setEndHrs(shift.getEndHrs() + "");
		shiftDTO.setEndMin(shift.getEndMin() + "");
		shiftDTO.setActive(shift.getActive() + "");
		
		return shiftDTO;
	}
	
	/**
     * 
     */
	public String updateShift(Map<String, Object> input)
	{
		// TODO Auto-generated method stub
		String status = "failure";
		String shiftId = (String) input.get("shiftId");
		String locationId = (String) input.get("location");
		String shiftName = (String) input.get("shiftName");
		String start_hrs = (String) input.get("start_hrs");
		String start_min = (String) input.get("start_min");
		String end_hrs = (String) input.get("end_hrs");
		String end_min = (String) input.get("end_min");
		String active = (String) input.get("active");
		
		MA_Location location = new MA_Location();
		Key k1 = Datastore.createKey(MA_Location.class,
		        Long.parseLong(locationId));
		location.setKey(k1);
		
		Key k = Datastore.createKey(MA_Shift.class, Long.valueOf(shiftId));
		MA_ShiftMeta shiftMeta = MA_ShiftMeta.get();
		MA_Shift shift = Datastore.query(shiftMeta)
		        .filter(shiftMeta.key.equal(k)).asSingle();
		shift.setShiftName(shiftName);
		shift.setStartHrs(Integer.parseInt(start_hrs));
		shift.setStartMin(Integer.parseInt(start_min));
		shift.setEndHrs(Integer.parseInt(end_hrs));
		shift.setEndMin(Integer.parseInt(end_min));
		shift.getLocationRef().setModel(location);
		shift.setActive(active);
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		k = AbstractEntityDAO.addModel(shift);
		gtx.commit();
		status = ("" + k.getId()).trim();
		logger.log(Level.INFO, "updateShift Status-" + status);
		return status;
		
	}
	
	/**
	 * 
	 * @param shiftId
	 * @return
	 */
	public int getCurrentAssignmentCountOfShift(Long shiftId)
	{
		
		int currentAssignmentCount = 0;
		
		Key k = Datastore.createKey(MA_Shift.class, shiftId);
		MA_ShiftMeta shiftMeta = MA_ShiftMeta.get();
		MA_Shift shift = Datastore.query(shiftMeta)
		        .filter(shiftMeta.key.equal(k)).asSingle();
		currentAssignmentCount = entityService
		        .getCurrentAssignmentCountOfShift(shift);
		return currentAssignmentCount;
		
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public boolean isShiftDurationValid(Map<String, Object> input)
	{
		ITimeSheetBusinessService businessService = new TimeSheetBusinessService();
		List<MA_TimeSheetRule> timeSheetRules = businessService
		        .getTimesheetRulesOfCompany((Long) input.get("companyId"));
		
		MA_TimeSheetRule timesheetRule = new MA_TimeSheetRule();
		
		timesheetRule.setRuleKey(IMobileAttendanceConstants.MAX_DAILY_EFFORTS);
		
		MA_TimeSheetRule maxDailyEffortRule = timeSheetRules.get(timeSheetRules
		        .indexOf(timesheetRule));
		
		long maxDailyEffort = maxDailyEffortRule.getValue();
		int start_hrs = Integer.parseInt((String) input.get("start_hrs"));
		int start_min = Integer.parseInt((String) input.get("start_min"));
		int end_hrs = Integer.parseInt((String) input.get("end_hrs"));
		int end_min = Integer.parseInt((String) input.get("end_min"));
		
		int startTime = start_hrs * 60 + start_min;
		int endTime = end_hrs * 60 + end_min;
		
		long shiftDuration = 0;
		if (startTime > endTime)
		{
			shiftDuration = (1440 - startTime) + endTime;
			
		} else
		{
			shiftDuration = endTime - startTime;
		}
		
		shiftDuration = shiftDuration * 60;
		if (shiftDuration > maxDailyEffort)
		{
			return false;
		} else
		{
			return true;
		}
	}
	
	/**
	 * This method will return all the Shifts in the database which are eligible
	 * for Alert.
	 * 
	 * @return
	 */
	public static List<MA_Shift> loadActiveShiftsForAlerts()
	{
		MA_ShiftMeta shiftMeta = MA_ShiftMeta.get();
		List<MA_Shift> shifts = Datastore.query(shiftMeta).filter(shiftMeta.active.equal("Y")).asList();
		return shifts;
	}
	
	/**
	 * This method will return all the Shifts for a company which are eligible
	 * for Alert
	 * 
	 * @param company
	 * @return
	 */
	public static List<MA_Shift> loadShiftsForAlerts(MA_Company company)
	{
		return null;
	}
	
	/**
	 * @param timeZone
	 * @param hrs
	 * @param min
	 * @return
	 */
	private int[] convertHHMMFromLocalToGMT(String timeZone, int hrs, int min)
	{
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.HOUR_OF_DAY, hrs);
		cal.set(Calendar.MINUTE, min);
		DateTimeZone jdtz = DateTimeZone.forID(timeZone);
		
		long timeInMil = jdtz.convertLocalToUTC(cal.getTimeInMillis(), false);
		
		cal.clear();
		cal.setTimeInMillis(timeInMil);
		
		int _hrs = cal.get(Calendar.HOUR_OF_DAY);
		int _min = cal.get(Calendar.MINUTE);
		
		int[] time = { _hrs, _min };
		return time;
	}
	
	/**
	 * @param timeZone
	 * @param hrs
	 * @param min
	 * @return
	 */
	private int[] convertHHMMFromGMTtoLocal(String timeZone, int hrs, int min)
	{
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.HOUR_OF_DAY, hrs);
		cal.set(Calendar.MINUTE, min);
		DateTimeZone jdtz = DateTimeZone.forID(timeZone);
		
		long timeInMil = jdtz.convertUTCToLocal(cal.getTimeInMillis());
		cal.clear();
		cal.setTimeInMillis(timeInMil);
		
		int _hrs = cal.get(Calendar.HOUR_OF_DAY);
		int _min = cal.get(Calendar.MINUTE);
		
		int[] time = { _hrs, _min };
		return time;
	}
	
	public static List<MA_Employee> getShiftSupervisor(long shiftId)
	{
		
		List<MA_Employee> employees = new ArrayList<MA_Employee>();
		
		MA_AssignmentMeta a = new MA_AssignmentMeta();
		
		Key k = Datastore.createKey(MA_Shift.class, shiftId);
		
		List<MA_Assignment> assignmentList = Datastore
		        .query(a)
		        .filter(a.shiftRef.equal(k), a.status.equal(CURRENT_ASSIGNMENT))
		        .asList();
		
		for (MA_Assignment assignment : assignmentList)
		{
			if (assignment.getEmployeeRef().getModel().getIsSuperwiser()
			        .equals("Y")
			        && assignment.getEmployeeRef().getModel().getActive()
			                .equals("Y"))
			{
				employees.add(assignment.getEmployeeRef().getModel());
			}
			
		}
		
		return employees;
		
	}
	
	/**
	 * shift time is converted into "hh:mm aa To hh:mm aa"
	 * @param shift
	 * @return
	 */
	public String getshiftTime(MA_Shift shift)
	{
		String startAM_PM = "pm";
		String endAM_PM = "pm";
		String startHrs = "00";
		String endHrs = "00";
		if (shift.getStartHrs() >= 12)
		{
			startHrs = new Integer(shift.getStartHrs() - 12).toString();
		} else
		{
			startAM_PM = "am";
			
			if (shift.getStartHrs() < 10)
			{
				startHrs = "0" + shift.getStartHrs();
			} else
			{
				new Integer(shift.getStartHrs()).toString();
			}
		}
		
		if (shift.getEndHrs() >= 12)
		{
			endHrs = new Integer(shift.getEndHrs() - 12).toString();
		} else
		{
			endAM_PM = "am";
			
			if (shift.getEndHrs() < 10)
			{
				endHrs = "0" + shift.getEndHrs();
			} else
			{
				endHrs = new Integer(shift.getEndHrs()).toString();
			}
		}
		
		String startMin = shift.getStartMin() > 10 ? new Integer(
		        shift.getStartMin()).toString() : "0" + shift.getStartMin();
		String endMin = shift.getEndMin() > 10 ? new Integer(shift.getEndMin())
		        .toString() : "0" + shift.getEndMin();
		
		String shiftTime = startHrs + ":" + startMin + " " + startAM_PM
		        + " To " + endHrs + ":" + endMin + " " + endAM_PM;
		
		return shiftTime;
	}
}
