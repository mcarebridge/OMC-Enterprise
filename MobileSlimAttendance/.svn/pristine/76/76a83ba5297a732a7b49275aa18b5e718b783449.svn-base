package com.adviteya.controller.humancapital;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.adviteya.dto.WeeklyRecordDTO;
import com.adviteya.service.EntityService;
import com.adviteya.service.WeeklyRecordBusinessService;

public class WeeklyTimeRecordController extends BaseController
{
	
	private static Logger               logger          = Logger.getLogger(WeeklyTimeRecordController.class
	                                                            .getName());
	
	private EntityService               service         = EntityService
	                                                            .getInstance();
	private WeeklyRecordBusinessService businessService = WeeklyRecordBusinessService
	                                                            .getInstance();
	
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
		List<WeeklyRecordDTO> weeklyReport = businessService
		        .populateWeeklyRecordList(new RequestMap(request), companyId);
		requestScope("weeklyReportList", weeklyReport);
		
		return forward("weeklyTimeRecord.jsp");
		
	}
	
}
