package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.service.UserService;

public class ForgotPasswordController extends BaseController
{
	/**
	 * Logger.
	 */
	private static Logger logger       = Logger.getLogger(ForgotPasswordController.class
	                                           .getName());
	
	private UserService   user         = new UserService();
	private boolean       showErrBox   = false;
	private String        pageTitle    = "title.forgotPassword";
	private String        pageHeader   = "page.forgotPassword";
	
	private int           emailattempt = 0;
	private boolean       attempts     = false;
	private String        userName     = null;
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		logger.log(Level.INFO, "ForgotPasswordController Start executeLogic");
		
		userName = requestScope("userName");
		
		String actionParam = requestScope("actionParam");
		String server = request.getServerName();
		requestScope("server", server);
		requestScope("pageTitle", pageTitle);
		requestScope("pageHeader", pageHeader);
		
		if (actionParam.equalsIgnoreCase("forgotPassword"))
		{
			sessionScope("emailattempt", 0);
			return forward("forgotPassword.jsp");
		} else if (actionParam.equalsIgnoreCase("Cancel"))
		{
			return forward("index.jsp");
		} else if (actionParam.equalsIgnoreCase("submit"))
		{
			Validators v = new Validators(request);
			if (!validate(v))
			{
				attempts = invalidAttempts();
				if (attempts)
				{
					requestScope("actionParam", "actionParam");
					return forward("helpDesk");
				}
				v.getErrors().put("", "Attempts Left: " + (3 - emailattempt));
				v.getErrors()
				        .put("1",
				                "Note : Please ensure you are an active user and your account is active");
				showErrBox = true;
				requestScope("showErrBox", showErrBox);
				// System.out.println(showErrBox);
				return forward("forgotPassword.jsp");
			} else
			{
				boolean registeredUser = user.isRegisteredUser(new RequestMap(
				        request));
				logger.log(Level.INFO, "is regisered user present"
				        + registeredUser);
				if (registeredUser == false)
				{
					attempts = invalidAttempts();
					if (attempts)
					{
						requestScope("actionParam", null);
						logger.log(Level.INFO, "is attempts over" + attempts);
						return forward("helpDesk");
					}
					
					v.getErrors().put("",
					        "Attempts Left: " + (3 - emailattempt));
					v.getErrors()
					        .put("",
					                "Note : Please ensure you are an active user and your account is active");
					showErrBox = true;
					requestScope("showErrBox", showErrBox);
					return forward("forgotPassword.jsp");
				}
				requestScope("forgotPasswordConfirmation",
				        "account.forgotPassword.send");
				return forward("forgotPasswordConfirmation.jsp");
			}
		} else
		{
			return forward("forgotPassword.jsp");
		}
		
	}
	
	/**
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		v.add("userName", v.required(), v.regexp(
		        "^[\\w\\.-]+@([\\w\\-]+\\.)+[aA-zZ]{2,3}$",
		        "Improper email address. Accepted formats abcabc@pqr.com"));
		
		return v.validate();
	}
	
	/*
	 * @param userName
	 * 
	 * @return boolean
	 */
	
	private boolean invalidAttempts()
	{
		emailattempt = sessionScope("emailattempt");
		if (userName != null)
		{
			emailattempt++;
		}
		
		sessionScope("emailattempt", emailattempt);
		
		logger.log(Level.INFO, "ForgotPasswordController Start executeLogic"
		        + emailattempt);
		
		if (emailattempt > 2)
		{
			return true;
		}
		return false;
	}
	
}