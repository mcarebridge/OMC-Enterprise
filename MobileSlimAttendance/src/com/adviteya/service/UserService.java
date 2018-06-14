package com.adviteya.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_EmailStore;
import com.adviteya.model.MA_EmailTemplate;
import com.adviteya.model.MA_MailMessage;
import com.adviteya.model.MA_User;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.UserDAO;
import com.adviteya.util.MailUtil;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

/**
 * @author Prashant
 * 
 */
public class UserService implements IMobileAttendanceConstants
{
	/**
	 * Logger.
	 */
	private Logger logger     = Logger.getLogger(UserService.class.getName());
	
	private String serverName = null;
	private String email      = null;
	
	public UserService()
	{
	}
	
	/**
	 * @param input
	 * @return boolean
	 */
	public boolean isRegisteredUser(Map<String, Object> input)
	{
		logger.log(Level.INFO, "In UserService method");
		
		boolean regdUser = false;
		
		MA_User user = new MA_User();
		UserDAO userDAO = UserDAO.newInstance();
		
		BeanUtil.copy(input, user);
		
		MA_User user1 = userDAO.getUserDetails(user);
		
		if (userDAO.isUserExists(user))
		{
			String password = user1.getPassword();
			String name = user1.getEmployeeRef().getModel().getFirstName();
			
			MA_Company _company = user1.getCompanyRef().getModel();
			
			if (_company.isAccountVerified()
			        && !(_company.getActive().equalsIgnoreCase("N")))
			{
				input.put("name", name);
				input.put("password", password);
				sendForgotPasswordMail(input);
				regdUser = true;
			}
		}
		return regdUser;
	}
	
	/**
	 * send mail to the user
	 */
	private void sendForgotPasswordMail(Map<String, Object> input)
	{
		logger.log(Level.INFO, "sendMail to user method");
		
		MA_EmailTemplate emailTemplate = MailUtil
		        .getTemplate(IMobileAttendanceConstants.FORGOT_PASSWORD);
		
		MA_MailMessage mailMessage = fillForgotPasswordTemplate(emailTemplate,
		        input);
		;
		
		MA_EmailStore emailStore = new MA_EmailStore();
		
		emailStore.setCcAddress(mailMessage.getCcRecipient().get(
		        "helpDesk@onemastercontrol.com"));
		emailStore.setToAddress(mailMessage.getToRecipient().get(
		        (String) input.get("userName")));
		emailStore.setSubjects(mailMessage.getMessageSubject());
		emailStore.setEmailContent(mailMessage.getMessageBody());
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		Key k = AbstractEntityDAO.addModel(emailStore);
		gtx.commit();
		MailUtil.sendMail(mailMessage);
	}
	
	/**
	 * @param emailTemplate
	 *            ,input
	 * @return MA_MailMessage
	 */
	
	private MA_MailMessage fillForgotPasswordTemplate(
	        MA_EmailTemplate emailTemplate, Map<String, Object> input)
	{
		logger.log(Level.INFO, "in fill FORGOT PASSWORD template");
		
		MA_MailMessage mailMessage = new MA_MailMessage();
		
		mailMessage.setMessageSubject(emailTemplate.getEmailSubject());
		
		String mailBody = emailTemplate.getEmailMessage().getValue();
		Date date = new Date();
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");
		mailBody = mailBody.replace("$Date$", _sdf.format(date));
		mailBody = mailBody.replace("$server$", (String) input.get("server"));
		mailBody = mailBody
		        .replace("$accountName$", (String) input.get("name"));
		mailBody = mailBody.replace("$password$",
		        (String) input.get("password"));
		
		mailMessage.setMessageBody(new Text(mailBody));
		mailMessage.setSenderName("OneMasterControl");
		mailMessage.setSenderAddress(DEFAULT_EMAIL_SENDER);
		
		// System.out.println((String)input.get("userName"));
		Hashtable toAddress = new Hashtable();
		toAddress.put((String) input.get("userName"),
		        (String) input.get("userName"));
		
		Hashtable ccAddress = new Hashtable();
		ccAddress.put("helpDesk@onemastercontrol.com",
		        "helpDesk@onemastercontrol.com");
		
		mailMessage.setToRecipient(toAddress);
		mailMessage.setCcRecipient(ccAddress);
		
		return mailMessage;
	}
	
	/*
	 * @param input
	 */
	
	public void sendHelpDeskMail(Map<String, Object> input)
	{
		MA_EmailTemplate useremailTemplate = MailUtil
		        .getTemplate(IMobileAttendanceConstants.HELP_DESK);
		
		MA_MailMessage usermailMessage = fillHelpDeskTemplate(
		        useremailTemplate, input);
		
		MailUtil.sendMail(usermailMessage);
		MA_EmailStore emailStore = new MA_EmailStore();
		
		String _altEmail = (String) input.get("alternateEmail");
		String _regdEmail = (String) input.get("registerEmail");
		
		emailStore.setCcAddress(_altEmail + "," + _regdEmail);
		emailStore.setToAddress(OMC_HELPDESK_EMAIL);
		emailStore.setSubjects(usermailMessage.getMessageSubject());
		emailStore.setEmailContent(usermailMessage.getMessageBody());
		
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		Key k = AbstractEntityDAO.addModel(emailStore);
		gtx.commit();
		
	}
	
	/*
	 * @param emailTemplate,input
	 * 
	 * @return MA_MailMessage
	 */
	private MA_MailMessage fillHelpDeskTemplate(MA_EmailTemplate emailTemplate,
	        Map<String, Object> input)
	{
		logger.log(Level.INFO, "in fill HELP DESK template");
		
		MA_MailMessage mailMessage = new MA_MailMessage();
		
		mailMessage.setMessageSubject(emailTemplate.getEmailSubject());
		
		String mailBody = emailTemplate.getEmailMessage().getValue();
		
		mailBody = mailBody.replace("$server$", (String) input.get("server"));
		mailBody = mailBody.replace("$accountName$",
		        (String) input.get("userFirstName"));
		mailBody = mailBody.replace("$Company$", (String) input.get("company"));
		mailBody = mailBody.replace("$RegisteredEmail$",
		        (String) input.get("registerEmail"));
		mailBody = mailBody.replace("$AlternativeEmail$",
		        (String) input.get("alternateEmail"));
		mailBody = mailBody.replace("$contact$", (String) input.get("contact"));
		mailBody = mailBody.replace("$City$", (String) input.get("city"));
		mailBody = mailBody.replace("$Country$", (String) input.get("country"));
		mailBody = mailBody.replace("$State$", (String) input.get("state"));
		
		mailBody = mailBody.replace("$Comments$",
		        (String) input.get("comments"));
		Date date = new Date();
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");
		mailBody = mailBody.replace("$Date$", _sdf.format(date));
		
		mailMessage.setMessageBody(new Text(mailBody));
		mailMessage.setSenderName("OneMasterControl");
		mailMessage.setSenderAddress(DEFAULT_EMAIL_SENDER);
		
		Hashtable toAddress = new Hashtable();
		// System.out.println((String)input.get("alternateEmail")+"  "+(String)input.get("userFirstName"));
		
		toAddress.put(OMC_HELPDESK_EMAIL, OMC_HELPDESK_EMAIL);
		
		Hashtable ccAddress = new Hashtable();
		ccAddress.put((String) input.get("alternateEmail"),
		        (String) input.get("alternateEmail"));
		ccAddress.put((String) input.get("registerEmail"),
		        (String) input.get("registerEmail"));
		mailMessage.setToRecipient(toAddress);
		mailMessage.setCcRecipient(ccAddress);
		
		return mailMessage;
	}
}
