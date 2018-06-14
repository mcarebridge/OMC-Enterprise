package com.adviteya.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class MonthWeekTest
{
	/**
	 * @throws Exception
	 */
	@Test
	public void testWeekStart() throws Exception
	{
		Calendar _c = Calendar.getInstance();
						
		// We know week number and year.
		int week = _c.get(Calendar.WEEK_OF_YEAR);
		int year = _c.get(Calendar.YEAR);
		System.out.println(week+""+year);
		// Get calendar, clear it and set week number and year.
//		Calendar calendar = Calendar.getInstance();
//		calendar.clear();
//		calendar.set(Calendar.WEEK_OF_YEAR, week);
//		calendar.set(Calendar.YEAR, year);
		
		//first day of month
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, 10);
		calendar.set(Calendar.YEAR, 2012);
		
	    	
		
		// Now get the first day of week.
		Date date = calendar.getTime();
		
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		_sdf.setCalendar(calendar);
		
		System.out.println("Start ----->" + _sdf.format(date));
		
	//	calendar.add(Calendar.DATE, 7);
		//last day of month
		Calendar calendar1 = Calendar.getInstance();
		calendar1.clear();
		calendar1.set(Calendar.MONTH, 10);
		calendar1.set(Calendar.YEAR, 2012);
	    calendar1.set(Calendar.DAY_OF_MONTH, calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));
	    	
		date = calendar1.getTime();
		
		_sdf.setCalendar(calendar1);
		
		System.out.println("End ----->" + _sdf.format(date));
	}
	
	
	
	/**
	 * @throws Exception
	 */
	@Test
	public void testMonthStart() throws Exception
	{
		
// c = get current date
//		Is it start of the Month
//		Yes
//		   Startdate = start of the month
//			from this get week and find the end of the week data		
//		   End date = end of week
//		    Run code
//		No
//		  If start date = start of the week
//		  Find end of the month
//		  If end of month <	end of week
//		     End Date = end of week
//		   Else
//		     End date = end of the week
//		Else
//		   Exit
		
		Calendar c=Calendar.getInstance();
		c.clear();
		c.set(2012, 11, 23, 0, 0,0);
		
		int week = c.get(Calendar.WEEK_OF_YEAR);
		int year = c.get(Calendar.YEAR);
		Date startDate;
		Date date;
		Date endDate;
		//end of week
		int firstDay = c.get(Calendar.DAY_OF_WEEK);
		date = c.getTime();
		startDate = date;
		int offset;
		offset = 7 - firstDay;
		c.add(Calendar.DATE, offset);
		date = c.getTime();
		c.setTime(startDate);
		//start of month
		Calendar cStartMonth=Calendar.getInstance();
		cStartMonth.clear();
		cStartMonth.set(year, c.get(Calendar.MONTH), 1);
		
		System.out.println("current Date "+c.getTime()+"\n start Month "+cStartMonth.getTime()+"\n end week "+ date);
		if(c.getTime().equals(cStartMonth.getTime()))
		{
			startDate=cStartMonth.getTime();
			endDate=date;
			
			System.out.println("Start Date is "+startDate+" \n and endDate is"+endDate+"   1");
			
		}else if((c.get(Calendar.DAY_OF_WEEK))==1)
		{
			System.out.println("Last Day of month "+c.getActualMaximum(Calendar.DAY_OF_MONTH));
			Calendar cEndMonth = Calendar.getInstance();
			cEndMonth.clear();
			cEndMonth.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.getActualMaximum(Calendar.DAY_OF_MONTH) , 0, 0, 0);
			cEndMonth.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			System.out.println(" end of month "+cEndMonth.getTime());
			if(cEndMonth.getTimeInMillis()>date.getTime())
			{
				endDate=date;
				System.out.println("Start Date is "+startDate+" and endDate is"+endDate+"  2");
			}else				
			{
				endDate=cEndMonth.getTime();
				System.out.println("Start Date is "+startDate+" and endDate is"+endDate+"  3");
			}
			
		}else{
			System.out.println("no operation");
		}
		
		
		
		
		
	}
}
