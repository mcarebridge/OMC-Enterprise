package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

public class EmployeeIndexController extends BaseController
{
	private static Logger logger = Logger.getLogger(AssignmentIndexController.class
	                                     .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		logger.log(Level.INFO, "-- Inside Assignment Index   ---");
		pageTitle = "title.employeeHome";
		pageHeader = "page.employeeHome";
		return forward("employeeIndex.jsp");
	}
}
