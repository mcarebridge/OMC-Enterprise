package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.service.DashboardBusinessService;

public class DashBoardDataController extends BatchJobBaseController
{
	
	private static Logger            logger           = Logger.getLogger(DashBoardDataController.class
	                                                          .getName());
	
	private DashboardBusinessService dashBoardService = new DashboardBusinessService();
	
	@Override
	public Navigation executeLogic()
	{
		logger.log(Level.INFO, "-- Inside DashBoardDataController ---");
		
		Long companyId = requestScope("companyId");
		
		if (null == companyId)
		{
			companyId = sessionScope("companyId");
		}
		String action = requestScope("actionParam");
		logger.log(Level.INFO, "action --" + action);
		if ("inTime".equals(action))
		{
			
			dashBoardService
			        .calculateAndUpdateInTimeDetailsForCurrentShift(companyId);
			
			logger.log(Level.INFO, "Intime calculation complete --" + action);
		} else if ("outTime".equals(action))
		{
			dashBoardService
			        .calculateAndUpdateOutTimeAndEffortDetails(companyId);
		}
		
		return forward("home");
	}
}
