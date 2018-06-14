/**
 * 
 */
package com.adviteya.persistence;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.model.MA_WeeklyEffortReport;
import com.google.appengine.api.datastore.Key;

/**
 * @author deejay
 * 
 */
public class TimeSheetReportDAO extends AbstractEntityDAO
{
	private static TimeSheetReportDAO timeSheetDAO;
	
	private TimeSheetReportDAO()
	{
	}
	
	public static TimeSheetReportDAO newInstance()
	{
		
		if (timeSheetDAO == null)
		{
			
			timeSheetDAO = new TimeSheetReportDAO();
		}
		return timeSheetDAO;
	}
	
	/**
	 * 
	 * @param weeklyEffortReport
	 */
	public Key storeWeeklyTimeSheets(MA_WeeklyEffortReport weeklyEffortReport)
	{
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		Key _key = addModel(weeklyEffortReport);
		gtx.commit();
		return _key;
	}
}
