package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class AddLocationIndexController extends Controller
{
	
	private static Logger logger = Logger.getLogger(AddLocationIndexController.class
	                                     .getName());
	
	@Override
	public Navigation run() throws Exception
	{
		logger.log(Level.INFO, "-- Inside Add Location Index ---");
		return forward("addLocation.jsp");
	}
}
