package com.adviteya.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;

import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_Timesheet;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Key;

public class TimesheetReportUtil
{
	
	private static Logger                  logger = Logger.getLogger(TimesheetReportUtil.class
	                                                      .getName());
	private static Map<String, List<Date>> yearlyCalendar;
	
	/**
	 * 
	 * <pre>
	 * This method will create the monthly timecard report for all the emplyoees The reportDate is an input to find the 
	 * report months The report structure is 
	 * ------------------------------------------------------------------------------------------------------------------
	 * Emp Id | Emp Name | Location  |                     Days
	 * ------------------------------------------------------------------------------------------------------------------
	 * |      |          |           |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
	 * __________________________________________________________________________________________________________________
	 * </pre>
	 * 
	 * @param company
	 * @param reportDate
	 */
	
	public static void createMonthlyTimesheetReport(MA_Company company,
	        Date reportDate)
	{
		
		/**
		 * <pre>
		 * Logic 
		 * 1. Generate Month calendar 
		 * 2. Load company object by using method - TimeSheetBusinessService.getTimesheetForCompany 
		 * 3. Update the Timesheet.DailyEffort for - 
		 *      a. Look at the emplyoee start date - any date before should be be blank 
		 *      b. if the any day has been missed show 0 Hrs
		 * </pre>
		 */
		
		generateMonthlyCalendar(reportDate);
		
	}
	
	/**
	 * 
	 * @param company
	 * @param reportDate
	 */
	private static void adjustTimeCard(MA_Company company, Date reportDate)
	{
		
		/**
		 * Get timesheets for a given month for all the eligible company
		 * employees
		 */
		
		Calendar _reportCalendar = Calendar.getInstance();
		_reportCalendar.setTime(reportDate);
		String _reportDateKey = _reportCalendar.get(Calendar.YEAR) + "/"
		        + _reportCalendar.get(Calendar.MONTH);
		
		List<MA_Employee> empList = company.getEmployeeList();
		
		for (Iterator iterator = empList.iterator(); iterator.hasNext();)
		{
			MA_Employee ma_Employee = (MA_Employee) iterator.next();
			List<MA_Assignment> assignmentList = ma_Employee.getAssignments();
			
			for (Iterator iterator2 = assignmentList.iterator(); iterator2
			        .hasNext();)
			{
				MA_Assignment ma_Assignment = (MA_Assignment) iterator2.next();
				List<MA_Timesheet> tSheet = ma_Assignment.getTimesheets();
				
				List _calList = yearlyCalendar.get(_reportDateKey);
				
				// for (Iterator iterator3 = _calList.iterator(); iterator3
				// .hasNext();) {
				//
				// for (Iterator iterator4 = tSheet.iterator(); iterator4
				// .hasNext();) {
				// MA_Timesheet ma_Timesheet =
				// (MA_Timesheet) iterator4.next();
				//
				// Calendar _createdDateCalendar = Calendar.getInstance();
				// _createdDateCalendar.setTime(ma_Timesheet
				// .getCreatedDate());
				//
				// if(!_calList.contains(ma_Timesheet)){
				// MA_Assignment _asgn = new MA_Assignment();
				// }
				// }
				//
				// }
				
			}
		}
		
	}
	
	/**
	 * Create Monthly Calendar for Attendance
	 * 
	 * @param reportDate
	 * @return
	 */
	public static Map<String, List<Date>> generateMonthlyCalendarAsDate(
	        Date reportDate)
	{
		
		// ArrayList<Calendar> _calList = new ArrayList<Calendar>();
		ArrayList<Date> _dateList = new ArrayList<Date>();
		HashMap<String, List<Date>> _h = new HashMap<String, List<Date>>();
		
		Calendar _c = Calendar.getInstance();
		_c.setTime(reportDate);
		
		int min = _c.getActualMinimum(Calendar.DATE);
		int max = _c.getActualMaximum(Calendar.DATE);
		
		logger.log(Level.INFO, min + "----" + max);
		
		while (min <= max)
		{
			
			Calendar c = Calendar.getInstance();
			c.set(_c.get(Calendar.YEAR), _c.get(Calendar.MONTH), min, 0, 0, 0);
			_dateList.add(c.getTime());
			// _calList.add(c);
			min++;
		}
		
		_h.put(_c.get(Calendar.YEAR) + "/" + _c.get(Calendar.MONTH), _dateList);
		
		yearlyCalendar = _h;
		
		return _h;
	}
	
	/**
	 * 
	 * @param reportDate
	 * @return
	 */
	public static List<String> generateMonthlyCalendar(Date reportDate)
	{
		
		// ArrayList<Calendar> _calList = new ArrayList<Calendar>();
		ArrayList<String> _datelList = new ArrayList<String>();
		
		Calendar _c = Calendar.getInstance();
		_c.setTime(reportDate);
		
		int min = _c.getActualMinimum(Calendar.DATE);
		int max = _c.getActualMaximum(Calendar.DATE);
		
		logger.log(Level.INFO, min + "----" + max);
		
		while (min <= max)
		{
			
			Calendar c = Calendar.getInstance();
			c.set(_c.get(Calendar.YEAR), _c.get(Calendar.MONTH), min, 0, 0, 0);
			_datelList.add((c.get(Calendar.MONTH) + 1) + "/"
			        + c.get(Calendar.DATE));
			min++;
		}
		
		return _datelList;
	}
	
	/**
	 * This method converts MA_Timesheet to Timesheet String to be sent to
	 * Mobile phone as CSV Structure of CSV is
	 * 
	 * <pre>
	 * 1. timeSheetDate
	 * 2. timesheetId
	 * 3. assignmentId
	 * 4. shiftId
	 * 5. Location
	 * 6. empId
	 * 7. empCompanyId - This is not companyId, but generated while creating a emp and it can be printed on badge
	 * 8. empPwd
	 * 9. empName(First  Lastname),
	 * 10. empPwd
	 * 11. inTime
	 * 12. outTime
	 * 13. marker
	 * 
	 * 
	 * 
	 * </pre>
	 * 
	 * @param timesheet
	 * @return
	 */
	public static StringBuffer serializeTimesheet(List<MA_Timesheet> timesheet)
	{
		
		logger.log(Level.INFO, "INSIDE serializeTimesheet");
		StringBuffer _timeSheetString = new StringBuffer();
		// TODO : Need to pass Locale so that server time can be converted in
		// to local time or may it should be
		// done at mobile
		
		// Create Header
		_timeSheetString
		        .append("timeSheetDate,timesheetId,assignmentId,shiftId,Location,empId,empCompanyId,empName,empPwd,inTime,outTime,marker");
		_timeSheetString.append("$");
		
		for (Iterator iterator = timesheet.iterator(); iterator.hasNext();)
		{
			
			MA_Timesheet ma_Timesheet = (MA_Timesheet) iterator.next();
			
			if (ma_Timesheet != null)
			{
				MA_Assignment ma_Assignment = ma_Timesheet.getAssignmentRef()
				        .getModel();
				MA_Shift ma_Shift = ma_Assignment.getShiftRef().getModel();
				
				if (ma_Shift == null)
				{
					// ma_Shift = new MA_Shift();
					ma_Shift = ma_Timesheet.getShiftRef().getModel();
				}
				
				MA_Employee ma_Employee = ma_Assignment.getEmployeeRef()
				        .getModel();
				MA_Location ma_Location = ma_Shift.getLocationRef().getModel();
				
				if (ma_Location == null)
				{
					// ma_Location = new MA_Location();
					// ma_Location.setLocationName("-");
					ma_Location = ma_Timesheet.getLocationRef().getModel();
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat(
				        "MM/dd/yyyy kk:mm:ss");
				
				// timeSheetDate
				_timeSheetString.append(ma_Timesheet.getCreatedDate());
				_timeSheetString.append(",");
				// timesheetId
				if (ma_Timesheet.getKey() != null)
				{
					_timeSheetString.append(ma_Timesheet.getKey().getId());
				} else
				{
					_timeSheetString.append("-");
				}
				_timeSheetString.append(",");
				// assignmentId
				_timeSheetString.append(ma_Assignment.getKey().getId());
				_timeSheetString.append(",");
				
				// shiftId
				if (ma_Shift.getKey() == null)
				{
					_timeSheetString.append(0);
				} else
				{
					_timeSheetString.append(ma_Shift.getKey().getId());
				}
				_timeSheetString.append(",");
				
				// Location
				// _timeSheetString.append(ma_Location.getLocationName());
				
				if (ma_Location.getKey() == null)
				{
					_timeSheetString.append(0);
				} else
				{
					_timeSheetString.append(ma_Location.getKey().getId());
				}
				
				_timeSheetString.append(",");
				
				// empId
				_timeSheetString.append(ma_Employee.getKey().getId());
				_timeSheetString.append(",");
				
				// TODO : empCompanyId
				_timeSheetString
				        .append(ma_Employee.getCompanyEmpId() != null ? ma_Employee
				                .getCompanyEmpId() : "-");
				_timeSheetString.append(",");
				
				// empName
				_timeSheetString.append(ma_Employee.getFirstName() + " "
				        + ma_Employee.getLastName());
				_timeSheetString.append(",");
				
				// TODO : empPwd
				_timeSheetString
				        .append(ma_Employee.getEmpPwd() != null ? ma_Employee
				                .getEmpPwd() : "-");
				_timeSheetString.append(",");
				
				// inTime
				if (ma_Timesheet.getInDateTime() != null)
				{
					_timeSheetString.append(sdf.format(ma_Timesheet
					        .getInDateTime()));
				} else
				{
					_timeSheetString.append("-");
				}
				_timeSheetString.append(",");
				
				// outTime
				if (ma_Timesheet.getOutDateTime() != null)
				{
					_timeSheetString.append(sdf.format(ma_Timesheet
					        .getOutDateTime()));
				} else
				{
					_timeSheetString.append("-");
				}
				_timeSheetString.append(",");
				// marker
				_timeSheetString
				        .append(ma_Timesheet.getMarker() != null ? ma_Timesheet
				                .getMarker() : "-");
				
			} else
			{
				_timeSheetString.append("Err in creating timesheet");
			}
			
			_timeSheetString.append("$");
			
		}
		
		return _timeSheetString;
	}
	
	/**
	 * Parse the timesheet received as csv and convert it into MA_Timeet List
	 * 
	 * @param timeSheetReceived
	 * @return
	 * @throws ParseException
	 */
	public static List<MA_Timesheet> parseTimeSheet(String timeSheetReceived,
	        boolean hasPlannedAssignments, String imeiCode,
	        String supervisorUserName, String latLang) throws ParseException
	{
		logger.log(Level.INFO, "Lat lang is : " + latLang);
		logger.log(Level.INFO, "supervisorUserName : " + supervisorUserName);
		GeoPt _attendanceLocation = null;
		Double _d_accuracy = 0D;
		
		if (latLang.equalsIgnoreCase("LOCATION_NOT_FOUND"))
		{
			_attendanceLocation = new GeoPt(0, 0);
			_d_accuracy = -1D;
		} else
		{
			logger.log(Level.INFO, "Lat Long tokenizing -- >" + latLang);
			StringTokenizer _st = new StringTokenizer(latLang, "@");
			String _long = (String) _st.nextElement();
			String _lat = (String) _st.nextElement();
			String _accuracy = (String) _st.nextElement();
			
			Float _f_long = new Float(_long.substring(_long.indexOf(":") + 1,
			        _long.length()).trim());
			Float _f_lat = new Float(_lat.substring(_lat.indexOf(":") + 1,
			        _lat.length()).trim());
			_d_accuracy = new Double(_accuracy.substring(
			        _accuracy.indexOf(":") + 1, _accuracy.length()).trim());
			
			_attendanceLocation = new GeoPt(_f_lat, _f_long);
		}
		
		StringTokenizer _stLine = new StringTokenizer(timeSheetReceived, "$");
		ArrayList<MA_Timesheet> _timeSheetList = new ArrayList();
		
		// ignore header
		_stLine.nextElement();
		
		while (_stLine.hasMoreTokens())
		{
			String _record = (String) _stLine.nextElement();
			
			logger.log(Level.INFO, "Record received -- >" + _record);
			
			System.out.println(_record);
			if (!_record.equalsIgnoreCase("null"))
			{
				StringTokenizer _stRecord = new StringTokenizer(_record, ",");
				
				while (_stRecord.hasMoreTokens())
				{
					
					String _element = (String) _stRecord.nextElement();
					MA_Timesheet _tSheet = new MA_Timesheet();
					// get Id : It will "-" for IN status of Attendance
					if (_element != null)
					{
						if (!_element.equals("0"))
						{
							Key k = Datastore.createKey(MA_Timesheet.class,
							        Long.parseLong(_element.trim()));
							_tSheet.setKey(k);
						}
					}
					
					// get AssignmentId
					_element = (String) _stRecord.nextElement();
					if (_element != null)
					{
						if (!_element.equals("0"))
						{
							Key k = Datastore.createKey(MA_Assignment.class,
							        Long.parseLong(_element.trim()));
							
							MA_Assignment _assgn = new MA_Assignment();
							_assgn.setKey(k);
							
							_tSheet.getAssignmentRef().setModel(_assgn);
						}
					}
					
					// get InDate. Do not update if the data is for OUT time
					_element = (String) _stRecord.nextElement();
					
					if (_element != null && !_element.equals("-"))
					{
						SimpleDateFormat sdf;
						try
						{
							sdf = new SimpleDateFormat("MM/dd/yyyy kk:mm:ss");
							_tSheet.setInDateTime(sdf.parse(_element));
							_tSheet.setCreatedBy(supervisorUserName);
							_tSheet.setCreatedDate(new Date());
						} catch (Exception e)
						{
							// if the data from mobile is in old format
							sdf = new SimpleDateFormat("MM/dd/yyyy kk:mm");
							_tSheet.setInDateTime(sdf.parse(_element));
							_tSheet.setCreatedBy(supervisorUserName);
							_tSheet.setCreatedDate(new Date());
						}
						// _tSheet.setInDateTime(sdf.parse(_element));
						// 04/19/2012 - Change : createDay, year and month
						// should of inTime and not from currentDate
						// This will fix a bug - if a timesheet has been logged
						// in previous day and but synched up next day.
						Calendar _c = Calendar.getInstance();
						_c.setTime(_tSheet.getInDateTime());
						_tSheet.setCreateYear(_c.get(Calendar.YEAR));
						_tSheet.setCreateMonth(_c.get(Calendar.MONTH));
						_tSheet.setCreateDay(_c.get(Calendar.DATE));
						_tSheet.setAttendanceCoordinates(_attendanceLocation);
						_tSheet.setGeoPtAccuracy(_d_accuracy);
					} else
					{
						_tSheet.setInDateTime(null);
					}
					
					// Marker = CURRENT if no timesheet key has been generated
					// and
					// timesheet inDate in NOT NULL
					if (_tSheet.getKey() == null
					        && _tSheet.getInDateTime() != null)
					{
						_tSheet.setMarker("CURRENT");
					}
					
					// get OutDate
					_element = (String) _stRecord.nextElement();
					if (_element != null)
					{
						if (!_element.equals("-"))
						{
							logger.log(Level.INFO,
							        "Updated logic : supervisorUserName : "
							                + supervisorUserName);
							
							try
							{
								SimpleDateFormat sdf = new SimpleDateFormat(
								        "MM/dd/yyyy kk:mm:ss");
								_tSheet.setOutDateTime(sdf.parse(_element));
								_tSheet.setUpdatedBy(supervisorUserName);
								_tSheet.setUpdatedDate(new Date());
							} catch (Exception e)
							{
								// If date in in old format
								SimpleDateFormat sdf = new SimpleDateFormat(
								        "MM/dd/yyyy kk:mm");
								_tSheet.setOutDateTime(sdf.parse(_element));
								_tSheet.setUpdatedBy(supervisorUserName);
								_tSheet.setUpdatedDate(new Date());
							}
							_tSheet.setAttendanceCoordinatesOut(_attendanceLocation);
							_tSheet.setGeoPtAccuracyOut(_d_accuracy);
							_tSheet.setMarker("UPDATED");
						}
					} else
					{
						_tSheet.setOutDateTime(null);
					}
					
					/**
					 * If the company has NO planned Assignments, then only
					 * update location and shift
					 */
					// get Location
					_element = (String) _stRecord.nextElement();
					if (!hasPlannedAssignments)
					{
						if (_element != null)
						{
							if (!_element.equals("-"))
							{
								if (!_element.equals("0"))
								{
									Key locationKey = Datastore.createKey(
									        MA_Location.class,
									        Long.parseLong(_element));
									_tSheet.getLocationRef()
									        .setKey(locationKey);
								}
							}
						}
					}
					
					// get Shift
					_element = (String) _stRecord.nextElement();
					if (!hasPlannedAssignments)
					{
						if (_element != null)
						{
							if (!_element.equals("-"))
							{
								if (!_element.equals("0"))
								{
									Key shiftKey = Datastore.createKey(
									        MA_Shift.class,
									        Long.parseLong(_element));
									_tSheet.getShiftRef().setKey(shiftKey);
								}
							}
						}
					}
					
					_tSheet.setImeiCode(imeiCode);
					
					// add record and update server data if and only if the
					// attendance has been recorded
					
					if (_tSheet.getInDateTime() != null)
					{
						_timeSheetList.add(_tSheet);
					}
				}
				
			}
			
		}
		
		return _timeSheetList;
	}
}
