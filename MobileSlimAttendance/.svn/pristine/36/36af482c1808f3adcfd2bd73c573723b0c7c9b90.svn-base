package com.adviteya.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;

import com.adviteya.dto.WeeklyRecordDTO;
import com.adviteya.meta.MA_WeeklyEffortReportMeta;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_WeeklyEffortReport;
import com.adviteya.util.MADateUtil;
import com.google.appengine.api.datastore.Key;

public class WeeklyRecordBusinessService
{
	
	private static WeeklyRecordBusinessService weeklyReportBusinessService;
	private static Logger                      logger = Logger.getLogger(WeeklyRecordBusinessService.class
	                                                          .getName());
	
	private MA_WeeklyEffortReportMeta          w      = new MA_WeeklyEffortReportMeta();
	
	/**
	 * Private Constructor
	 */
	private WeeklyRecordBusinessService()
	{
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static WeeklyRecordBusinessService getInstance()
	{
		
		if (weeklyReportBusinessService == null)
		{
			weeklyReportBusinessService = new WeeklyRecordBusinessService();
		}
		
		return weeklyReportBusinessService;
	}
	
	/**
	 * 
	 * @param input
	 * @param companyId
	 * @return
	 */
	public List<WeeklyRecordDTO> populateWeeklyRecordList(
	        Map<String, Object> input, long companyId)
	{
		
		List<WeeklyRecordDTO> weeklyReportList = new ArrayList<WeeklyRecordDTO>();
		
		Calendar c = Calendar.getInstance();
		Date startDate;
		Date endDate;
		
		GregorianCalendar gc = new GregorianCalendar();
		int year = Integer.parseInt((String) input.get("year"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
		SimpleDateFormat monthName = new SimpleDateFormat("MMMM");
		
		c.clear();
		c.set(year, 0, 1, 0, 0, 0);
		
		List<MA_WeeklyEffortReport> report_list = getWeeklyEffortReport(companyId);
		int count = 0;
		while (year == c.get(Calendar.YEAR))
		{
			Calendar c_copy = Calendar.getInstance();
			c_copy.clear();
			c_copy.setTime(c.getTime());
			count++;
			WeeklyRecordDTO weeklyReport = new WeeklyRecordDTO();
			
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
				Iterator<MA_WeeklyEffortReport> itr1 = report_list.iterator();
				while (itr1.hasNext())
				{
					MA_WeeklyEffortReport report = itr1.next();
					Date report_startDate = report.getWeekStartDate();
					if (dateFormat.format(report_startDate).equalsIgnoreCase(
					        dateFormat.format(startDate))
					        && !report.getWeeklyReport().toString()
					                .equals("<Text: >"))
					{
						weeklyReport.setNoOfRecords(report.getNoOfRecords());
					} else if (weeklyReport.getNoOfRecords() == 0)
					{
						weeklyReport.setNoOfRecords(0);
					}
				}
				weeklyReport.setStartTime(startDate.getTime());
				weeklyReport.setMonthName(monthNo + "-"
				        + monthName.format(startDate));
				weeklyReport.setEndDate(dateFormat.format(endDate));
				weeklyReport.setStartDate(dateFormat.format(startDate));
				weeklyReport.setWeekNo((week < 10 ? "0" + week : Integer
				        .toString(week)));
				
				c.setTime(endDate);
				
				weeklyReportList.add(weeklyReport);
			}
			c.add(Calendar.DATE, 1);
		}
		// logger.log(Level.INFO, "count=" + count);
		return weeklyReportList;
	}
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	public List<MA_WeeklyEffortReport> getWeeklyEffortReport(long companyId)
	{
		Key k = Datastore.createKey(MA_Company.class, companyId);
		List<MA_WeeklyEffortReport> report_list = Datastore.query(w)
		        .filter(w.companyRef.equal(k)).asList();
		
		return report_list;
	}
	
	/**
	 * 
	 * @param companyId
	 * @param weekNo
	 * @return
	 */
	public MA_WeeklyEffortReport getWeeklyEffortReport(long companyId,
	        Date startDate)
	{
		Key k = Datastore.createKey(MA_Company.class, companyId);
		MA_WeeklyEffortReport report = Datastore
		        .query(w)
		        .filter(w.companyRef.equal(k), w.weekStartDate.equal(startDate))
		        .asSingle();
		
		return report;
	}
}
