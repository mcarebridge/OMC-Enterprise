package com.adviteya.controller.humancapital;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.dto.ConsolidatedTimeSheetDTO;
import com.adviteya.service.EntityService;
import com.adviteya.service.IPayRollBusinessService;
import com.adviteya.service.PayRollBusinessService;

public class CurrentDayTimesheetReportController extends BaseController
{
	
	private static Logger           logger          = Logger.getLogger(ConsolidatedTimesheetReportController.class
	                                                        .getName());
	
	private EntityService           service         = EntityService
	                                                        .getInstance();
	private IPayRollBusinessService businessService = new PayRollBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		pageTitle = "title.currentDayTimesheetReport";
		pageHeader = "page.currentDayTimesheetReport";
		String mm = requestScope("MM");
		String dd = requestScope("DD");
		String yy = requestScope("YY");
		
		Calendar cal = Calendar.getInstance();
		
		/**
		 * This logic was introduced to make current timesheet run for multiple
		 * days
		 */
		if (mm != null)
		{
			if (!mm.equalsIgnoreCase("00"))
			{
				cal = Calendar.getInstance();
				cal.set(Calendar.MONTH, new Integer(mm));
				cal.set(Calendar.DATE, new Integer(dd));
				cal.set(Calendar.YEAR, new Integer(yy));
			}
		}
		Long companyId = sessionScope("companyId");
		logger.log(Level.INFO, companyId.toString());
		// DateFormat _dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		logger.log(Level.INFO, "before report search");
		List<ConsolidatedTimeSheetDTO> consolidatedTimeSheetDTOs = businessService
		        .getCurrentDayTimeSheet(companyId, cal);
		requestScope("dailyAttendanceRecord", consolidatedTimeSheetDTOs);
		
		logger.log(Level.INFO, "Size--" + consolidatedTimeSheetDTOs.size());
		
		logger.log(Level.INFO, "before report forward");
		return forward("currentDayTimesheetReport.jsp");
	}
	
}
