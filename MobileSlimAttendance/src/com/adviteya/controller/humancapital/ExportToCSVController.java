package com.adviteya.controller.humancapital;

import java.util.Date;

import org.slim3.controller.Navigation;

import com.adviteya.service.DashboardBusinessService;
import com.adviteya.util.WeeklyReportUtil;

public class ExportToCSVController extends BaseController
{
	private DashboardBusinessService dashBoardService = new DashboardBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		long companyId = sessionScope("companyId");
		String action = requestScope("actionParam");
		String csvString = null;
		String reportFileName = null;
		if (action != null && action.equalsIgnoreCase("weeklyTimeRecord"))
		{
			long starttime = Long.parseLong((String) requestScope("startDate"));
			Date startDate = new Date(starttime);
			
			csvString = WeeklyReportUtil.getTimesheetCsvString(companyId,
			        startDate);
			reportFileName = WeeklyReportUtil.getTimesheetFileName(companyId,
			        startDate);
			
		} else if (action != null && action.equalsIgnoreCase("weeklyPayRoll"))
		{
			long starttime = Long.parseLong((String) requestScope("startDate"));
			Date startDate = new Date();
			
			startDate.setTime(starttime);
			
			csvString = WeeklyReportUtil.getPayrollCsvString(companyId,
			        startDate);
			reportFileName = WeeklyReportUtil.getPayrollFileName(companyId,
			        startDate);
			
		}
		
		else
		{
			csvString = requestScope("csvString");
			reportFileName = requestScope("reportFileName");
			
		}
		
		response.setHeader("Content-Disposition", "Attachment;filename="
		        + reportFileName);
		response.setContentType("application/vnd.ms-excel");
		response.getWriter().write(csvString);
		response.getWriter().close();
		return null;
	}
	
}
