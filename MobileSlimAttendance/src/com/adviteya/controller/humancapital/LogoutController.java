package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Navigation;

import com.adviteya.service.UserBusinessService;

public class LogoutController extends BaseController
{
	private UserBusinessService businessService = new UserBusinessService();
	/**
	 * Logger.
	 */
	private static Logger       logger          = Logger.getLogger(LogoutController.class
	                                                    .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		showHeader = true;
		showErrBox = false;
		logger.log(Level.INFO, "-- Inside Logout ---");
		sessionScope("currentUser", null);
		HttpSession session = request.getSession();
		session.invalidate();
		showHeader = false;
		return forward("index");
	}
}
