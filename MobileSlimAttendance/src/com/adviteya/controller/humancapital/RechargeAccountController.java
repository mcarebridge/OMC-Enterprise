package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

public class RechargeAccountController extends BaseController
{
	private static Logger logger = Logger.getLogger(RechargeAccountController.class
	                                     .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		logger.log(Level.INFO, "-- Inside Recharge     ---");
		return forward("home");
	}
}
