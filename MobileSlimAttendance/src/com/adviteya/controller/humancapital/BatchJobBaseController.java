package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public abstract class BatchJobBaseController extends Controller
{
	private static Logger logger = Logger.getLogger(BatchJobBaseController.class
	                                     .getName());
	
	protected Navigation run()
	{
		logger.log(Level.INFO,
		        " BatchJobBaseController is Started." );
		// try
		// {
		
		return executeLogic();
		
		// } catch (Exception e)
		// {
		// e.toString();
		// logger.log(Level.FINEST, "Error--" + e.toString());
		// }
		
		// return null;
		
	}
	
	public abstract Navigation executeLogic();
	
}
