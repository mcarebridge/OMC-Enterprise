package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Country;
import com.adviteya.service.EntityService;
import com.adviteya.service.UserService;

public class HelpDeskController extends BaseController
{
	private Logger        logger     = Logger.getLogger(HelpDeskController.class
	                                         .getName());
	private EntityService service    = EntityService.getInstance();
	private UserService   user       = new UserService();
	private boolean       showErrBox = false;
	private String        pageTitle  = "title.helpDesk";
	private String        pageHeader = "page.helpDesk";
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		logger.log(Level.INFO, "  HelpDeskController Start executeLogic");
		String actionParam = requestScope("actionParam");
		String Cancel = requestScope("cancel");
		System.out.println(actionParam);
		
		if (Cancel != null)
		{
			return forward("index.jsp");
		} else if (actionParam.equalsIgnoreCase("Submit"))
		{
			logger.log(Level.INFO, "  in initialization of helpDesk ");
			requestScope("pageTitle", "title.helpDesk");
			requestScope("pageHeader", "page.helpDesk");
			
			List<MA_Country> countryList = service.getCounrtyList();
			sessionScope("countryList", countryList);
			
			requestScope("stateList", new ArrayList());
			
			return forward("helpDesk.jsp");
		} else
		{
			logger.log(Level.INFO, "  in before validation of helpDesk ");
			String userFirstName = requestScope("salutation") + " "
			        + requestScope("firstName") + " "
			        + requestScope("lastName");
			requestScope("userFirstName", userFirstName);
			String server = request.getServerName();
			
			requestScope("server", server);
			
			requestScope("pageTitle", pageTitle);
			requestScope("pageHeader", pageHeader);
			
			Validators v = new Validators(request);
			if (!validate(v))
			{
				logger.log(Level.INFO, "  in after validation of helpDesk ");
				showErrBox = true;
				requestScope("showErrBox", showErrBox);
				return forward("helpDesk.jsp");
				
			} else
			{
				user.sendHelpDeskMail(new RequestMap(request));
				requestScope("HelpDeskConfirmation",
				        "account.HelpDeskMail.send");
				return forward("helpDeskConfirmation.jsp");
			}
		}
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	
	private boolean validate(Validators v)
	{
		
		String alternateEmail = requestScope("alternateEmail");
		String registeredEmail = requestScope("registerEmail");
		if (registeredEmail.equalsIgnoreCase(alternateEmail))
		{
			v.getErrors()
			        .put("",
			                "Registered Email address And Alternate Email address should not be same");
		}
		v.add("firstName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("lastName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("contact",
		        v.required(),
		        v.regexp(
		                "^\\(?(\\d{3})\\)?[- ]?(\\d{3})?[- ]?(\\d{3})[- ]?(\\d{4})$",
		                "Invalid phone number. Accepted formats (001)123-456-7890 001-123-456-7890, 0011234567890, (001)-(123)-456-7890"));
		v.add("alternateEmail", v.required(), v.regexp(
		        "^[\\w\\.-]+@([\\w\\-]+\\.)+[aA-zZ]{2,3}$",
		        "Improper email address. Accepted formats abcabc@pqr.com"));
		v.add("registerEmail", v.required(), v.regexp(
		        "^[\\w\\.-]+@([\\w\\-]+\\.)+[aA-zZ]{2,3}$",
		        "Improper email address. Accepted formats abcabc@pqr.com"));
		v.add("company", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("city", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("country", v.required());
		v.add("state", v.required());
		v.add("comments", v.required());
		return v.validate();
	}
}
