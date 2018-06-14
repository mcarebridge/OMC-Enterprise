package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.dto.ConsolidatedTimeSheetDTO;
import com.adviteya.service.EntityService;
import com.adviteya.service.IPayRollBusinessService;
import com.adviteya.service.PayRollBusinessService;

public class PayRollTimesheetReportController extends BaseController
{
	
	private static Logger           logger          = Logger.getLogger(ConsolidatedTimesheetReportController.class
	                                                        .getName());
	
	private EntityService           service         = EntityService
	                                                        .getInstance();
	private IPayRollBusinessService businessService = new PayRollBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		pageTitle = "title.detailedPayRollReport";
		pageHeader = "page.detailedPayRollReport";
		
		try
		{
			String action = requestScope("actionParam");
			String startDate = requestScope("startDate");
			String toDate = requestScope("toDate");
			Date _startDate = null;
			Date _toDate = null;
			
			Long companyId = sessionScope("companyId");
			logger.log(Level.INFO, companyId.toString());
			// DateFormat _dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			logger.log(Level.INFO, "Start Date--" + startDate + "   End Date-"
			        + toDate);
			
			if (startDate != null && toDate != null)
			{
				logger.log(Level.INFO, "before report search");
				List<ConsolidatedTimeSheetDTO> consolidatedTimeSheetDTOs = businessService
				        .getPayRollTimeSheet(companyId, startDate, toDate);
				requestScope("dailyAttendanceRecord", consolidatedTimeSheetDTOs);
				
				logger.log(Level.INFO,
				        "Size--" + consolidatedTimeSheetDTOs.size());
			} else
			{
				requestScope("dailyAttendanceRecord", new ArrayList());
			}
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
			logger.log(Level.FINEST, ex.getMessage());
			throw ex;
		}
		
		logger.log(Level.INFO, "before report forward");
		return forward("payRollTimesheetReport.jsp");
	}
	
}
