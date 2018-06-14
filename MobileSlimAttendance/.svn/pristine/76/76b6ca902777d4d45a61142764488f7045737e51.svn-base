package com.adviteya.controller.humancapital;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.TimeZoneLocator;

import com.adviteya.model.MA_Company;
import com.adviteya.service.TimeSheetBusinessService;
import com.adviteya.util.TimesheetReportUtil;
import com.google.appengine.api.datastore.Key;

public class TestTimeSheetController extends Controller
{
	
	private static Logger logger = Logger.getLogger(TestTimeSheetController.class
	                                     .getName());
	
	@Override
	protected Navigation run() throws Exception
	{
		
		String action = (String) request.getAttribute("action");
		String clientTimeZone = (String) request.getAttribute("clientTimeZone");
		String companyId = (String) request.getAttribute("companyId");
		
		if (action != null)
		{
			action = action.toUpperCase();
		}
		
		Validators timeSheetRead = new Validators(request);
		timeSheetRead.add("action", timeSheetRead.required());
		timeSheetRead.add("companyId", timeSheetRead.required());
		
		if (timeSheetRead.validate())
		{
			if (action.equals("LOADTIMESHEET"))
			{
				
				loadTimeSheet(companyId);
				
			}
		}
		
		requestScope("now", new Date());
		
		TimeZone tz = TimeZone.getDefault();
		
		if (clientTimeZone != null)
		{
			tz = TimeZone.getTimeZone(clientTimeZone);
		}
		
		TimeZoneLocator.set(tz);
		requestScope("timeZone", TimeZoneLocator.get());
		return forward("testTimeSheet.jsp");
		
	}
	
	/**
	 * Load timesheet
	 */
	private void loadTimeSheet(String companyId)
	{
		
		logger.log(Level.INFO, "-- Loading Timesheet --");
		logger.log(Level.INFO, "-- Load data for Company Id = " + companyId);
		TimeSheetBusinessService tbs = new TimeSheetBusinessService();
		
		MA_Company company = new MA_Company();
		
		Key k = Datastore
		        .createKey(MA_Company.class, Long.parseLong(companyId));
		company.setKey(k);
		// company = tbs.getTimesheetForCompany(company);
		
		// use current date
		Calendar _reportDate = Calendar.getInstance();
		
		// company = tbs.getMonthlyTimesheetForCompanyByEmplyoee(company, null,
		// null, "M");
		// need majar re-work. Stopped for a while
		requestScope("monthlyCalendar",
		        TimesheetReportUtil.generateMonthlyCalendar(_reportDate
		                .getTime()));
		requestScope("company", company);
		
	}
}
