package com.adviteya.controller.humancapital;

import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_EmailTemplate;
import com.adviteya.model.MA_MailMessage;
import com.adviteya.model.MA_Template;
import com.adviteya.service.CompanyBusinessService;
import com.adviteya.service.EntityService;
import com.adviteya.service.ICompanyBusinessService;
import com.adviteya.util.MailUtil;
import com.google.appengine.api.datastore.Text;

public class CreateCompanyController extends Controller
{
	
	private EntityService           service         = EntityService
	                                                        .getInstance();
	private ICompanyBusinessService businessService = new CompanyBusinessService();
	private static Logger           logger          = Logger.getLogger(CreateCompanyController.class
	                                                        .getName());
	private String                  pageTitle       = "title.newLogin";
	private String                  pageHeader      = "page.newLogin";
	private String                  systemError     = "system.error";
	
	@Override
	public Navigation run() throws Exception
	{
		
		logger.log(Level.INFO, "Start Create Comnay");
		requestScope("pageTitle", pageTitle);
		requestScope("pageHeader", pageHeader);
		
		String action = requestScope("actionParam");
		Long companyId = sessionScope("companyId");
		
		logger.log(Level.INFO, "Company Id = " + companyId);
		logger.log(Level.INFO, "action = " + action);
		try
		{
			
			List<MA_Template> templates = service.getTemplateList();
			requestScope("isManager", sessionScope("isManager"));
			requestScope("templateList", templates);
			requestScope("companyId", companyId);
			
			if (action.equals("createUser"))
			{
				requestScope("initialLoad", "true");
				return forward("createCompany.jsp");
			} else if (action.equals("createCompany"))
			{
				Validators v = new Validators(request);
				String isManager = request.getParameter("isManager");
				if (!validate(v, isManager))
				{
					return forward("createCompany.jsp");
				} else
				{
					String status = businessService
					        .createCompanyDetails(new RequestMap(request));
					
					if (status.equals("success"))
					{
						sessionScope("isManager", null);
						// sendMail(Long.valueOf(companyId));
						return forward("index");
					} else if (status.equals("failure"))
					{
						v.getErrors()
						        .put(null,
						                "Unexpected Error Occured.Please contact system admin");
						return forward("createCompany.jsp");
					}
				}
			} else if (action.equals("confirmUser"))
			{
				String companyId1 = request.getParameter("companyId");
				requestScope("companyId", companyId1);
				boolean accountVerified = businessService
				        .isAccountVerified(Long.valueOf(companyId1));
				requestScope("accountVerified",
				        new Boolean(accountVerified).toString());
				return forward("confirmAdminUser.jsp");
			}
		} catch (Exception e)
		{
			logger.log(Level.SEVERE, e.getMessage(), e);
			requestScope("systemError", systemError);
			requestScope("pageTitle", "page.error");
			return forward("errorPage.jsp");
		}
		
		logger.log(Level.INFO, "End Create Comnay");
		return null;
	}
	
	/**
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v, String isManager)
	{
		logger.log(Level.INFO, "Start validate ");
		
		v.add("template", v.required());
		v.add("uniqueidFlag", v.required());
		v.add("emplyoeePopulation", v.required(), v.integerType());
		
		// if (isManager.equals("N"))
		// {
		// v.add("firstName", v.required(),
		// v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		// v.add("lastName", v.required(),
		// v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		// v.add("phone", v.required(), v.longType());
		// v.add("cell", v.required(), v.longType());
		// v.add("userName", v.required());
		// v.add("userProfile", v.required());
		// v.add("city", v.required());
		// v.add("country", v.required());
		// v.add("state", v.required());
		// v.add("pinCode", v.required(), v.integerType());
		// }
		logger.log(Level.INFO, "End validate   validate= " + v.validate());
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
		MA_EmailTemplate _emailTemplate = MailUtil
		        .getTemplate(IMobileAttendanceConstants.ACCOUNT_CREATION);
		MA_MailMessage _mailMessage = new MA_MailMessage();
		_mailMessage.setMessageSubject(_emailTemplate.getEmailSubject());
		
		String _mailBody = _emailTemplate.getEmailMessage().toString();
		
		_mailBody.replaceAll("$server$", "localhost");
		_mailBody.replace("$accountManagerName$", userName);
		
		_mailMessage.setMessageBody(new Text(_mailBody));
		
		_mailMessage.setSenderName("OneMasterControl Web Sales Team");
		_mailMessage.setSenderAddress("sales@onemastercontrol.com");
		
		Hashtable _toAddress = new Hashtable();
		_toAddress.put(email, userName);
		
		_mailMessage.setToRecipient(_toAddress);
		
		MailUtil.sendMail(_mailMessage);
	}
	
}
