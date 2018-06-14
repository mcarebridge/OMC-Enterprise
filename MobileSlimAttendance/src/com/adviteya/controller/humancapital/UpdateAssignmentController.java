package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.service.EntityService;

public class UpdateAssignmentController extends BatchJobBaseController
{
	
	private static Logger logger        = Logger.getLogger(ConsolidatedTimeSheetController.class
	                                            .getName());
	
	EntityService         entityService = EntityService.getInstance();
	
	@Override
	public Navigation executeLogic()
	{
		logger.log(Level.INFO, "-- Inside ConsolidatedTimeSheetController ---");
		
		Long companyId = requestScope("companyId");
		
		if (null == companyId)
		{
			companyId = sessionScope("companyId");
		}
		entityService.updateAssignmentStatus(companyId);
		
		return forward("home.jsp");
	}
}
