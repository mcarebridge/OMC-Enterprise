package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.adviteya.model.MA_User;

public abstract class BaseController extends Controller
{
	
	private static Logger logger      = Logger.getLogger(BaseController.class
	                                          .getName());
	String                pageTitle   = "title.welcome";
	String                pageHeader  = "page.Header";
	String                systemError = "system.error";
	boolean               showHeader  = true;
	boolean               showErrBox  = false;
	protected MA_User     user        = null;
	
	protected Navigation run()
	{
		String actionParam = (String) requestScope("actionParam");
		try
		{
			user = (MA_User) sessionScope("currentUser");
			
			if (null == user)
			{
				if (actionParam != null)
				{
					Navigation _navg = executeLogic();
					return _navg;
				} else
				{
					return forward("index");
				}
			} else
			{
				
				Navigation _navg = executeLogic();
				requestScope("pageTitle", pageTitle);
				requestScope("pageHeader", pageHeader);
				requestScope("showHeader", showHeader);
				requestScope("showErrBox", new Boolean(showErrBox).toString());
				return _navg;
			}
			
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
	
	/**
	 * refactoring the method can be made abstract
	 * 
	 * @return
	 * @throws Exception
	 */
	// public Navigation executeLogic() throws Exception
	// {
	//
	// return null;
	// }
	
	public abstract Navigation executeLogic() throws Exception;
	
}
