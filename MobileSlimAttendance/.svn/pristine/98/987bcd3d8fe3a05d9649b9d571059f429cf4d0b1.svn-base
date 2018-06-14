package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller
{
	private static Logger logger      = Logger.getLogger(IndexController.class
	                                          .getName());
	
	private String        pageTitle   = "title.welcome";
	private String        pageHeader  = "page.login";
	boolean               showHeader  = true;
	boolean               showErrBox  = false;
	private String        systemError = "system.error";
	
	@Override
	public Navigation run() throws Exception
	{
		try
		{
			requestScope("pageTitle", pageTitle);
			requestScope("pageHeader", pageHeader);
			
			logger.log(Level.INFO, "-- Inside Index ---");
			return forward("index.jsp");
		} catch (Exception e)
		{
			logger.log(Level.SEVERE, e.getMessage(), e);
			requestScope("systemError", systemError);
			requestScope("pageTitle", "page.error");
			response.setHeader("Cache-Control", "no-cache");
			sessionScope("currentUser", null);
			HttpSession session = request.getSession();
			session.invalidate();
			return forward("errorPage.jsp");
		}
		
	}
}
