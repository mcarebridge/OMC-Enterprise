package com.adviteya.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;

import com.adviteya.meta.MA_TimeSheetRuleMeta;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_TimeSheetRule;

public class AssignmentHelper
{
	private static Logger logger = Logger.getLogger(AssignmentHelper.class
	                                     .getName());
	
	/**
	 * 
	 * @param assignment
	 * @return
	 */
	public static String convertAssignmentToDelimitedStream(
	        List<MA_Assignment> assignment)
	{
		
		StringBuffer _delimitedFile = new StringBuffer();
		
		for (Iterator iterator = assignment.iterator(); iterator.hasNext();)
		{
			MA_Assignment ma_Assignment = (MA_Assignment) iterator.next();
		}
		
		return null;
	}
	
	/**
	 * Provide TimeZone enable Shift Start Time
	 * 
	 * @param shift
	 * @return
	 */
	public static Calendar getShiftStartTime(MA_Shift shift,
	        Calendar effectiveDate)
	{
		MA_Location _location = shift.getLocationRef().getModel();
		// TimeZone _locationTimeZone = TimeZone.getTimeZone(_location
		// .getTimeZone());
		// Err: By Applying timezone it converts it into UTC with Err.
		// Calendar _c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(
		        "yyyy.MM.dd G 'at' HH:mm:ss z");
		
		// Calendar _c = effectiveDate;
		Calendar _c = Calendar.getInstance();
		
		_c.set(Calendar.YEAR, effectiveDate.get(Calendar.YEAR));
		_c.set(Calendar.MONTH, effectiveDate.get(Calendar.MONTH));
		_c.set(Calendar.DATE, effectiveDate.get(Calendar.DATE));
		
		_c.set(Calendar.HOUR, shift.getStartHrs());
		_c.set(Calendar.MINUTE, shift.getStartMin());
		_c.set(Calendar.SECOND, 0);
		
		if (shift.getStartHrs() >= 12)
		{
			_c.set(Calendar.HOUR, (shift.getStartHrs() - 12));
			_c.set(Calendar.AM_PM, Calendar.PM);
		} else
		{
			_c.set(Calendar.AM_PM, Calendar.AM);
		}
		
		logger.log(Level.INFO,
		        "-- Shift Time Before Adjust --" + sdf.format(_c.getTime()));
		Calendar k = adjustTimeZone(_c);
		return k;
	}
	
	/**
	 * Provide TimeZone enable Shift End Time
	 * 
	 * @param shift
	 * @return
	 */
	public static Calendar getShiftEndTime(MA_Shift shift,
	        Calendar effectiveCalendar)
	{
		MA_Location _location = shift.getLocationRef().getModel();
		// TimeZone _locationTimeZone = TimeZone.getTimeZone(_location
		// .getTimeZone());
		// Err: By Applying timezone it converts it into UTC with Err.
		// Calendar _c = Calendar.getInstance();
		// Calendar _c = effectiveCalendar;
		
		Calendar _c = Calendar.getInstance();
		
		_c.set(Calendar.YEAR, effectiveCalendar.get(Calendar.YEAR));
		_c.set(Calendar.MONTH, effectiveCalendar.get(Calendar.MONTH));
		_c.set(Calendar.DATE, effectiveCalendar.get(Calendar.DATE));
		
		_c.set(Calendar.HOUR, shift.getEndHrs());
		_c.set(Calendar.MINUTE, shift.getEndMin());
		_c.set(Calendar.SECOND, 0);
		
		// The end date will be of next day.
		if (hasShiftStarted(shift, effectiveCalendar))
		{
			if (shift.getStartHrs() > shift.getEndHrs())
			{
				_c.add(Calendar.DATE, 1);
			}
		}
		
		if (shift.getEndHrs() >= 12)
		{
			_c.set(Calendar.HOUR, (shift.getEndHrs() - 12));
			_c.set(Calendar.AM_PM, Calendar.PM);
		} else
		{
			_c.set(Calendar.AM_PM, Calendar.AM);
		}
		
		Calendar k = adjustTimeZone(_c);
		return k;
	}
	
	/**
	 * Return true if the shift has started Note : This method tries to convert
	 * system time to local time. But due to current implementation of Java. The
	 * Calendar class converts all local time to UTC time. So all comparison
	 * happens in UTC.
	 * 
	 * @param shift
	 * @return
	 */
	public static boolean hasShiftStarted(MA_Shift shift, Calendar effectiveDate)
	{
		MA_Location _location = shift.getLocationRef().getModel();
		
		// TimeZone _locationTimeZone = TimeZone.getTimeZone(_location
		// .getTimeZone());
		
		// logger.log(Level.INFO,
		// " TimeZone " + _locationTimeZone.getDisplayName());
		
		// Calendar _latestTime = Calendar.getInstance(_locationTimeZone);
		// _latestTime.setTimeZone(_locationTimeZone);
		// Calendar _shiftStartTime = getShiftStartTime(shift);
		// _shiftStartTime.setTimeZone(_locationTimeZone);
		
		// Calendar _latestTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(
		        "yyyy.MM.dd G 'at' HH:mm:ss z");
		// Calendar _latestTime = effectiveDate;
		
		Calendar _latestTime = Calendar.getInstance();

		_latestTime.setTimeInMillis(effectiveDate.getTimeInMillis());
	
//		_latestTime.set(Calendar.YEAR, effectiveDate.get(Calendar.YEAR));
//		_latestTime.set(Calendar.MONTH, effectiveDate.get(Calendar.MONTH));
//		_latestTime.set(Calendar.DATE, effectiveDate.get(Calendar.DATE));
				logger.log(
		        Level.INFO,
		        "*************** Latest Time = "
		                + _latestTime.getTimeInMillis() + " -> "
		                + sdf.format(_latestTime.getTime()) + "---");
		
		Calendar _shiftStartTime = getShiftStartTime(shift, _latestTime);
		
		logger.log(
		        Level.INFO,
		        "***************  Latest Time = "
		                + _latestTime.getTimeInMillis() + " ------ "
		                + "Shift Time = " + _shiftStartTime.getTimeInMillis());
		
		logger.log(
		        Level.INFO,
		        "***************  ShiftStartTime="
		                + _shiftStartTime.getTimeInMillis() + " -> "
		                + sdf.format(_shiftStartTime.getTime()) + "---");
		
		// Note : Both the time in UTC. Local time zone doesn't work
		if (_shiftStartTime.getTimeInMillis() < _latestTime.getTimeInMillis())
		{
			logger.log(Level.INFO, "Shift started");
			return true;
		} else
		{
			logger.log(Level.INFO, "Shift yet to start");
			return false;
		}
	}
	
	/**
	 * Return true if the shift has ended
	 * 
	 * @param shift
	 * @return
	 */
	public static boolean hasShiftEnded(MA_Shift shift,
	        Calendar effectiveCalendar)
	{
		MA_Location _location = shift.getLocationRef().getModel();
		// TimeZone _locationTimeZone = TimeZone.getTimeZone(_location
		// .getTimeZone());
		
		// Calendar _latestTime = Calendar.getInstance();
		Calendar _latestTime = effectiveCalendar;
		Calendar _shiftEndTime = getShiftEndTime(shift, effectiveCalendar);
		
		SimpleDateFormat sdf = new SimpleDateFormat(
		        "yyyy.MM.dd G 'at' HH:mm:ss z");
		
		logger.log(
		        Level.INFO,
		        "#################### latestTime="
		                + _latestTime.getTimeInMillis() + " -> "
		                + sdf.format(_latestTime.getTime()) + "---");
		logger.log(
		        Level.INFO,
		        "#################### _shiftEndTime="
		                + _shiftEndTime.getTimeInMillis() + " -> "
		                + sdf.format(_shiftEndTime.getTime()) + "---");
		
		// Note : Both the time in UTC. Local time zone doesn't work
		if (_shiftEndTime.getTimeInMillis() < _latestTime.getTimeInMillis())
		{
			logger.log(Level.INFO, "Shift Ended");
			return true;
		} else
		{
			logger.log(Level.INFO, "Shift yet to End");
			return false;
		}
	}
	
	/**
	 * 
	 * @param shift
	 * @return
	 */
	public static boolean hasShiftCrossedMaxDuration(MA_Shift shift,
	        Calendar effectiveCalendar)
	{
		
		boolean _maxDurationOver = false;
		
		MA_Location _location = shift.getLocationRef().getModel();
		MA_Company _company = _location.getCompanyRef().getModel();
		
		// Calendar _latestTime = Calendar.getInstance();
		Calendar _latestTime = effectiveCalendar;
		Calendar _shiftStartTime = getShiftStartTime(shift, _latestTime);
		Calendar _shiftEndTime = getShiftEndTime(shift, effectiveCalendar);
		
		MA_TimeSheetRuleMeta _ruleMeta = new MA_TimeSheetRuleMeta();
		MA_TimeSheetRule timeRule = Datastore
		        .query(_ruleMeta)
		        .filter(_ruleMeta.companyRef.equal(_company.getKey()),
		                _ruleMeta.ruleKey.equal("max_daily_efforts"))
		        .asSingle();
		
		Long _maxduration = timeRule.getValue();
		
		logger.log(Level.INFO, "AssignmentHelper : _maxduration "
		        + _maxduration);
		
		long _shiftDuration = (_latestTime.getTimeInMillis() / 1000)
		        - (_shiftStartTime.getTimeInMillis() / 1000);
		
		logger.log(Level.INFO, "AssignmentHelper : _shiftDuration "
		        + _shiftDuration);
		
		if (_shiftDuration > _maxduration.longValue())
		{
			_maxDurationOver = true;
		}
		
		logger.log(Level.INFO, "AssignmentHelper : _maxDurationOver "
		        + _maxDurationOver);
		
		return _maxDurationOver;
		
	}
	
	/**
	 * This is stop gap arrangement as Java Calendar is not working
	 */
	public static Calendar adjustTimeZone(Calendar _c)
	{
		// Hard coded for IST.
		TimeZone _z = _c.getTimeZone();
		System.out.println(_z.getDisplayName());
		_c.add(Calendar.HOUR, -5);
		_c.add(Calendar.MINUTE, -30);
		
		return _c;
	}
	
	/**
	 * This method adjusts the timezone , from Local to UTC and vice versa If
	 * isUTC = true - then supplied Date is in UTC format, else it is in local
	 * format
	 * 
	 * @param _c
	 * @param isUTC
	 * @return
	 */
	public static Calendar adjustTimeZone(Calendar _c, boolean isUTC)
	{
		// Hard coded for IST.
		if (isUTC)
		{
			_c.add(Calendar.HOUR, 5);
			_c.add(Calendar.MINUTE, 30);
		} else
		{
			_c.add(Calendar.HOUR, -5);
			_c.add(Calendar.MINUTE, -30);
		}
		
		return _c;
	}
	
	/**
	 * 
	 * @param shift
	 * @return
	 */
	public static boolean hasNewShiftStarted(MA_Shift shift,
	        Calendar effectiveDate)
	{
		boolean flag = false;
		
		SimpleDateFormat sdf = new SimpleDateFormat(
		        "yyyy.MM.dd G 'at' HH:mm:ss a z");
		
		// Calendar _currentTime = Calendar.getInstance();
		Calendar _currentTime = effectiveDate;
		
		Calendar _shiftStartTime = getShiftStartTime(shift, _currentTime);
		
		Calendar _nextDay = Calendar.getInstance();
		_nextDay.add(Calendar.DATE, 1);
		_nextDay.set(Calendar.HOUR, 0);
		_nextDay.set(Calendar.MINUTE, 0);
		_nextDay.set(Calendar.SECOND, 0);
		_nextDay.set(Calendar.MILLISECOND, 0);
		
		// get next shift time
		if (_currentTime.after(_shiftStartTime) & _currentTime.before(_nextDay))
		{
			flag = true;
		} else
		{
			flag = false;
		}
		
		logger.log(Level.INFO, "Has new Shift started : " + flag);
		return flag;
	}
}
