package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class AddShiftIndexController extends Controller
{
	
	private static Logger logger = Logger.getLogger(AddShiftIndexController.class
	                                     .getName());
	
	@Override
	public Navigation run() throws Exception
	{
		logger.log(Level.INFO, "-- Inside Add Shift Index  ---");
		return forward("addShift.jsp");
	}
}
