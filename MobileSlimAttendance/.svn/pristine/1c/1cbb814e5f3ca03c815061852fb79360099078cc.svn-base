package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_EmailTemplate;
import com.adviteya.model.MA_MailMessage;
import com.adviteya.model.MA_State;
import com.adviteya.model.MA_Template;
import com.adviteya.model.MA_UserProfile;
import com.adviteya.service.EntityService;
import com.adviteya.service.UserBusinessService;
import com.adviteya.util.MailUtil;
import com.google.appengine.api.datastore.Text;

/**
 * 
 * @author Shailesh
 * 
 */
public class CreateAdminUserController extends Controller implements
        IMobileAttendanceConstants
{
	
	/**
	 * Entity Service.
	 */
	private EntityService       service         = EntityService.getInstance();
	private UserBusinessService businessService = new UserBusinessService();
	private boolean             showErrBox      = false;
	private String              pageTitle       = "title.newLogin";
	private String              pageHeader      = "page.newLogin";
	private String              systemError     = "system.error";
	
	/**
	 * Logger.
	 */
	private static Logger       logger          = Logger.getLogger(CreateAdminUserController.class
	                                                    .getName());
	
	@Override
	public Navigation run() throws Exception
	{
		String action = requestScope("actionParam");
		requestScope("pageTitle", pageTitle);
		requestScope("pageHeader", pageHeader);
		
		try
		{
			// if(action.equals("initialLoad")) {
			if (action == null)
			{
				List<MA_Country> countryList = service.getCounrtyList();
				sessionScope("countryList", countryList);
				List<MA_Template> templates = service.getTemplateList();
				sessionScope("templateList", templates);
				requestScope("stateList", new ArrayList());
				List<MA_UserProfile> profileList = service.getUserProfileList();
				sessionScope("profileList", profileList);
				return forward("createAdminUser.jsp");
			} else
			{
				Validators v = new Validators(request);
				if (!validate(v))
				{
					String state = requestScope("state");
					if (null != state && !state.equals(""))
					{
						String country = requestScope("country");
						List<MA_State> stateList = service
						        .getAllStateForCountry(country);
						requestScope("stateList", stateList);
					}
					showErrBox = true;
					requestScope("showErrBox", showErrBox);
					return forward("createAdminUser.jsp");
				} else
				{
					String status = businessService.createUser(new RequestMap(
					        request));
					if (status.equals("userExists"))
					{
						v.getErrors().put("", "User Already exists");
						showErrBox = true;
						requestScope("showErrBox", showErrBox);
						return forward("createAdminUser.jsp");
					} else
					{
						long companyId = Long.valueOf(status);
						logger.log(Level.INFO, "Company  Id=" + status);
						String userFirstName = requestScope("salutation") + " "
						        + requestScope("firstName") + " "
						        + requestScope("lastName");
						String userName = requestScope("userName");
						sendUserConfirmatonEmail(companyId, userFirstName,
						        userName);
						requestScope("accountCreationSuccess",
						        "account.creation.success");
						requestScope("pageTitle",
						        "title.accountCreationSuccess");
						return forward("accountCreationSuccess.jsp");
					}
				}
				
			}
		} catch (Exception e)
		{
			logger.log(Level.SEVERE, e.getMessage(), e);
			requestScope("systemError", systemError);
			requestScope("pageTitle", "page.error");
			return forward("errorPage.jsp");
		}
		
		//
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		v.add("firstName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("lastName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("gender", v.required());
		/*
		 * Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn ^\\(? :
		 * May start with an option "(" . (\\d{3}): Followed by 3 digits. \\)? :
		 * May have an optional ")" [- ]? : May have an optional "-" after the
		 * first 3 digits or after optional ) character. (\\d{3}) : Followed by
		 * 3 digits. [- ]? : May have another optional "-" after numeric digits.
		 * (\\d{4})$ : ends with four digits.
		 * 
		 * Examples: Matches following phone numbers: (123)456-7890,
		 * 123-456-7890, 1234567890, (123)-456-7890
		 */
		v.add("phone",
		        v.required(),
		        v.regexp(
		                "^\\(?(\\d{3})\\)?[- ]?(\\d{3})?[- ]?(\\d{3})[- ]?(\\d{4})$",
		                "Invalid phone number. Accepted formats (001)123-456-7890 001-123-456-7890, 0011234567890, (001)-(123)-456-7890"));
		v.add("cell",
		        v.required(),
		        v.regexp(
		                "^\\(?(\\d{3})\\)?[- ]?(\\d{3})?[- ]?(\\d{3})[- ]?(\\d{4})$",
		                "Invalid cell number. Accepted formats (001)123-456-7890 001-123-456-7890, 0011234567890, (001)-(123)-456-7890"));
		/*
		 * Email format: A valid email address will have following format:
		 * [\\w\\.-]+: Begins with word characters, (may include periods and
		 * hypens).
		 * 
		 * @: It must have a '@' symbol after initial characters.
		 * ([\\w\\-]+\\.)+: '@' must follow by more alphanumeric characters (may
		 * include hypens.). This part must also have a "." to separate domain
		 * and subdomain names. [A-Z]{2,4}$ : Must end with two to four
		 * alaphabets. (This will allow domain names with 2, 3 and 4 characters
		 * e.g pa, com, net, wxyz)
		 */
		
		v.add("userName", v.required(), v.regexp(
		        "^[\\w\\.-]+@([\\w\\-]+\\.)+[aA-zZ]{2,3}$",
		        "Improper email address. Accepted formats abcabc@pqr.com"));
		v.add("userProfile", v.required());
		v.add("operationFlag", v.required());
		v.add("companyName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("template", v.required());
		v.add("emplyoeePopulation", v.required(), v.integerType());
		v.add("city", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("country", v.required());
		v.add("state", v.required());
		v.add("pinCode", v.required(), v.integerType());
		
		return v.validate();
	}
	
	/**
	 * 
	 * @param companyId
	 * @param userName
	 * @param email
	 */
	private void sendUserConfirmatonEmail(Long companyId, String userName,
	        String email)
	{
		
		logger.log(Level.INFO, "Start sendUserConfirmatonEmail");
		
		logger.log(Level.INFO, "Compnay Id =" + companyId);
		logger.log(Level.INFO, "userName =" + userName);
		logger.log(Level.INFO, "email =" + email);
		MA_EmailTemplate _emailTemplate = MailUtil
		        .getTemplate(IMobileAttendanceConstants.ACCOUNT_CREATION);
		MA_MailMessage _mailMessage = new MA_MailMessage();
		_mailMessage.setMessageSubject(_emailTemplate.getEmailSubject());
		
		String _mailBody = _emailTemplate.getEmailMessage().getValue();
		
		logger.log(Level.INFO, "server name  =" + request.getServerName());
		// _mailBody = StringUtils.replace(_mailBody, "$server$",
		// request.getServerName());
		_mailBody = _mailBody.replace("$server$", request.getServerName());
		
		_mailBody = _mailBody.replace("$accountName$", userName);
		// _mailBody = StringUtils.replace(_mailBody, "$accountManagerName$",
		// userName);
		
		// _mailBody = StringUtils.replace(_mailBody, "$companyId$",
		// companyId.toString(companyId.longValue()));
		
		_mailBody = _mailBody.replace("$companyId$",
		        companyId.toString(companyId.longValue()));
		
		logger.log(Level.INFO, "_mailBody =" + _mailBody);
		
		_mailMessage.setMessageBody(new Text(_mailBody));
		_mailMessage.setSenderName("OneMasterControl");
		_mailMessage.setSenderAddress(DEFAULT_EMAIL_SENDER);
		
		Hashtable _toAddress = new Hashtable();
		_toAddress.put(email, userName);
		
		Hashtable _ccAddress = new Hashtable();
		_ccAddress.put("sales@onemastercontrol.com",
		        "sales@onemastercontrol.com");
		
		_mailMessage.setToRecipient(_toAddress);
		_mailMessage.setCcRecipient(_ccAddress);
		
		MailUtil.sendMail(_mailMessage);
		logger.log(Level.INFO, "End  sendUserConfirmatonEmail");
	}
}
