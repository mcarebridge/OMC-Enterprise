package com.adviteya.util;

import java.util.Calendar;
import java.util.logging.Logger;

import com.adviteya.service.CronJobService;

public class MADateUtil
{
	private static Logger logger = Logger.getLogger(CronJobService.class
	                                     .getName());
	
	/**
	 * Get start day of the week
	 * 
	 * @param weekNumber
	 * @return
	 */
	public static Calendar getStartDayOfWeek(int weekNumber, int year)
	{
		// Get calendar, clear it and set week number and year.
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		// calendar.set(Calendar.WEEK_OF_YEAR, weekNumber);
		// calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, 9);
		calendar.set(Calendar.YEAR, year);
		calendar.add(Calendar.DATE, 27);
		return calendar;
	}
	
	/**
	 * Get last day of the week
	 * 
	 * @param weekNumber
	 * @return
	 */
	public static Calendar getLastDayOfWeek(int weekNumber, int year)
	{
		// Get calendar, clear it and set week number and year.
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		// calendar.set(Calendar.WEEK_OF_YEAR, weekNumber);
		calendar.set(Calendar.MONTH, 9);
		calendar.set(Calendar.YEAR, year);
		calendar.add(Calendar.DATE, 31);
		return calendar;
	}
	
	/**
	 * Get start day of the month
	 * 
	 * @param weekNumber
	 * @return
	 */
	public static Calendar getStartDayOfMonth(int monthNumber, int year)
	{
		// Get calendar, clear it and set week number and year.
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, monthNumber);
		calendar.set(Calendar.YEAR, year);
		return calendar;
	}
	
	/**
	 * Get last day of the month
	 * 
	 * @param weekNumber
	 * @return
	 */
	
	public static Calendar getLastDateOfMonth(int monthNumber, int year)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		
		// calendar.set(Calendar.MONTH, monthNumber);
		calendar.set(Calendar.MONTH, monthNumber);
		calendar.set(Calendar.YEAR, year);
		// calendar.set(Calendar.DAY_OF_MONTH,
		// calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		return calendar;
	}
	
	/**
	 * <pre>
	 * This method calculates week start and end date.
	 * It follows following rules :
	 * 
	 * Current Date  Status      Start Date   End Date       Return 
	 * -------------------------------------------------------------
	 * 10/31/2012    EOM         10/21/2012   10/27/2012     null
	 * 11/01/2012    SOM         10/28/2012   10/31/2012     dates - run job     
	 * 11/03/2012    EOW         10/28/2012   10/31/2012     null
	 * 11/04/2012    SOW         11/01/2012   11/03/2012     dates - run job
	 * 11/07/2012    WK-DAY      11/01/2012   10/03/2012     null
	 * 11/30/2012    EOM         11/18/2012   11/24/2012     null
	 * 12/01/2012    SOM         11/25/2012   11/30/2012     dates - run job
	 * 12/31/2012    EOM         12/23/2012   12/29/2012     null
	 * 01/01/2013    SOM         12/30/2012   12/31/2012     dates - run job
	 * </pre>
	 * 
	 * @param _c
	 * 
	 * @return Array of StartDay of week and EndDay of the week based on
	 *         Greogrian Calendar
	 */
	public static Calendar[] getGregorianWeekStartAndEndDates(Calendar c)
	{
		
		boolean som = false;
		boolean sow = false;
		
		Calendar _startEndDates[] = null;
		
		if (c.get(Calendar.DATE) == 1)
		{
			som = true;
		}
		
		if (c.get(Calendar.DAY_OF_WEEK) == 1)
		{
			sow = true;
		}
		
		if (som | sow)
		{
			// Get End Date
			Calendar _endDate = Calendar.getInstance();
			_endDate.clear();
			_endDate.set(Calendar.YEAR, c.get(Calendar.YEAR));
			_endDate.set(Calendar.MONTH, c.get(Calendar.MONTH));
			_endDate.set(Calendar.DATE, c.get(Calendar.DATE));
			
			// Go back One week back
			_endDate.add(Calendar.DATE, -1);
			
			int _dayOfWeek = _endDate.get(Calendar.DAY_OF_WEEK);
			_dayOfWeek--;
			
			Calendar _startDate = Calendar.getInstance();
			_startDate.clear();
			_startDate.set(Calendar.YEAR, _endDate.get(Calendar.YEAR));
			_startDate.set(Calendar.MONTH, _endDate.get(Calendar.MONTH));
			_startDate.set(Calendar.DATE, _endDate.get(Calendar.DATE));
			
			_startDate.add(Calendar.DATE, -_dayOfWeek);
			
			if (_startDate.get(Calendar.MONTH) != _endDate.get(Calendar.MONTH))
			{
				_startDate.set(Calendar.YEAR, _endDate.get(Calendar.YEAR));
				_startDate.set(Calendar.MONTH, _endDate.get(Calendar.MONTH));
				_startDate.set(Calendar.DATE, 1);
			}
			_startEndDates = new Calendar[] { _startDate, _endDate };
		}
		
		return _startEndDates;
	}
	
	public static Calendar[] getDisplayWeekStartAndEndDates(Calendar c)
	{
		Calendar[] _startEndDates = null;
		
		int year = c.get(Calendar.YEAR);
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.clear();
		endDate.clear();
		// end of week
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		startDate.setTime(c.getTime());
		int offset;
		offset = 7 - dayOfWeek;
		c.add(Calendar.DATE, offset);
		endDate.setTime(c.getTime());
		c.setTime(startDate.getTime());
		// start of month
		Calendar cStartMonth = Calendar.getInstance();
		cStartMonth.clear();
		cStartMonth.set(year, c.get(Calendar.MONTH), 1);
		
		if (c.getTime().equals(cStartMonth.getTime()))
		{
			startDate = cStartMonth;
			_startEndDates = new Calendar[] { startDate, endDate };
		} else if ((c.get(Calendar.DAY_OF_WEEK)) == 1)
		{
			Calendar cEndMonth = Calendar.getInstance();
			cEndMonth.clear();
			cEndMonth.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
			        c.getActualMaximum(Calendar.DAY_OF_MONTH), 0, 0, 0);
			
			if (cEndMonth.getTimeInMillis() < endDate.getTimeInMillis())
			{
				endDate = cEndMonth;
			}
			_startEndDates = new Calendar[] { startDate, endDate };
		}
		
		return _startEndDates;
		
	}
}
