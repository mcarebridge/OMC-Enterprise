package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.dto.reports.PeriodicTimeSheet;
import com.adviteya.service.TimeSheetBusinessService;

public class EmployeeTimeCardController extends BaseController
{
	private static Logger            logger          = Logger.getLogger(EmployeeTimeCardController.class
	                                                         .getName());
	private TimeSheetBusinessService businessService = new TimeSheetBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		String startDate = requestScope("startDate");
		Long companyId = sessionScope("companyId");
		
		if (startDate != null)
		{
			List<PeriodicTimeSheet> employeeTimeCard = businessService
			        .getEmployeeTimeCard(companyId, startDate);
			requestScope("peroidicTimesheetRecord", employeeTimeCard);
			
		} else
		{
			requestScope("peroidicTimesheetRecord", new ArrayList());
		}
		
		return forward("employeeTimeCard.jsp");
	}
	
}
