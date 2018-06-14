package com.adviteya.controller.humancapital;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.service.TimeSheetBusinessService;

public class ConsolidatedTimeSheetController extends BatchJobBaseController
{
	
	private static Logger            logger          = Logger.getLogger(ConsolidatedTimeSheetController.class
	                                                         .getName());
	
	private TimeSheetBusinessService businessService = new TimeSheetBusinessService();
	
	@Override
	public Navigation executeLogic()
	{
		logger.log(Level.INFO, "-- Inside ConsolidatedTimeSheetController ---");
		
		Long companyId = requestScope("companyId");
		
		if (null == companyId)
		{
			companyId = sessionScope("companyId");
		}
		String action = requestScope("actionParam");
		if ("create".equals(action))
		{
			Calendar cal = Calendar.getInstance();
			// cal.add(Calendar.DAY_OF_MONTH, -1);
			logger.log(Level.INFO, "Current Date-- " + cal.toString());
			businessService.createPlannedAssignmentConsolidatedTimeSheet(
			        companyId, cal);
		} else if ("update".equals(action))
		{
			businessService.updatePlannedAssignmentConsolidatedTimeSheet(
			        companyId, Calendar.getInstance(), false);
		}
		businessService.displayDbCounters();
		
		return forward("home");
	}
}
