package com.adviteya.controller.humancapital;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.adviteya.dto.PayrollDTO;
import com.adviteya.service.EntityService;
import com.adviteya.service.PayRollBusinessService;

public class WeeklyPayrollReportController extends BaseController
{
	private static Logger          logger          = Logger.getLogger(WeeklyPayrollReportController.class
	                                                       .getName());
	
	private EntityService          service         = EntityService
	                                                       .getInstance();
	
	private PayRollBusinessService businessService = new PayRollBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		pageHeader = "page.weekTimeReport";
		pageTitle = "title.weekTimeReport";
		long companyId = sessionScope("companyId");
		
		String action = requestScope("actionParam");
		Calendar c = Calendar.getInstance();
		if (requestScope("year") == null)
		{
			requestScope("year", new Integer(c.get(Calendar.YEAR)).toString());
		}
		List<PayrollDTO> weeklyPayrollList = businessService
		        .populateWeeklyPayrollList(new RequestMap(request), companyId);
		requestScope("weeklyPayrollList", weeklyPayrollList);
		
		return forward("weeklyPayrollReport.jsp");
	}
}
