package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

public class AssignmentIndexController extends BaseController
{
	private static Logger logger = Logger.getLogger(AssignmentIndexController.class
	                                     .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		logger.log(Level.INFO, "-- Inside Assignment Index   ---");
		pageTitle = "title.addAssignment";
		pageHeader = "page.addAssignment";
		return forward("assignmentIndex.jsp");
	}
}
