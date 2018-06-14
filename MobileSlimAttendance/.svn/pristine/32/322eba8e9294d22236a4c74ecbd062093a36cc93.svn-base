package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.dto.reports.PeriodicTimeSheet;
import com.adviteya.service.EntityService;
import com.adviteya.service.TimeSheetBusinessService;

public class PeriodicTimesheetReportController extends BaseController
{
	
	private static Logger            logger          = Logger.getLogger(ConsolidatedTimesheetReportController.class
	                                                         .getName());
	private static EntityService     service         = EntityService
	                                                         .getInstance();
	private TimeSheetBusinessService businessService = new TimeSheetBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		logger.log(Level.INFO, "---- Reading service counter -----"
		        + service.readCounter);
		
		try
		{
			pageTitle = "title.monthlyReport";
			pageHeader = "page.monthlyReport";
			
			String action = requestScope("actionParam");
			String startDate = requestScope("startDate");
			Date _startDate = null;
			Date _toDate = null;
			
			Long companyId = sessionScope("companyId");
			logger.log(Level.INFO, companyId.toString());
			
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.set(2011, 10, 1);
			end.set(2011, 11, 1);
			
			// DateFormat _dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			
			if (startDate != null)
			{
				List<PeriodicTimeSheet> employeePeriodicTimeSheets = businessService
				        .getMonthlyTimeSheet(companyId, startDate);
				requestScope("peroidicTimesheetRecord",
				        employeePeriodicTimeSheets);
				
				logger.log(Level.INFO,
				        "Size--" + employeePeriodicTimeSheets.size());
			} else
			{
				requestScope("peroidicTimesheetRecord", new ArrayList());
			}
			
			businessService.displayDbCounters();
			
		} catch (Exception ex)
		{
			throw ex;
		}
		
		return forward("periodicTimesheetReport.jsp");
	}
}
