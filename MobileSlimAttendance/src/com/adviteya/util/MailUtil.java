package com.adviteya.util;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slim3.datastore.Datastore;

import com.adviteya.meta.MA_EmailTemplateMeta;
import com.adviteya.model.MA_EmailTemplate;
import com.adviteya.model.MA_MailMessage;

public class MailUtil
{
	
	private static Logger logger = Logger.getLogger(MailUtil.class.getName());
	
	/**
	 * 
	 * @param templateId
	 * @return
	 */
	public static MA_EmailTemplate getTemplate(String templateId)
	{
		MA_EmailTemplateMeta _emailTemplateMeta = new MA_EmailTemplateMeta();
		
		MA_EmailTemplate _emailTemplate = Datastore.query(_emailTemplateMeta)
		        .filter(_emailTemplateMeta.templateType.equal(templateId))
		        .asSingle();
		return _emailTemplate;
	}
	
	/**
	 * Send Email
	 * 
	 * @param mailMessage
	 */
	public static void sendMail(MA_MailMessage mailMessage)
	{
		logger.log(Level.INFO, "MailUtil.sendMail");
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		String msgBody = mailMessage.getMessageBody().getValue();
		try
		{
			Map<String, String> _toAddress = mailMessage.getToRecipient();
			Map<String, String> _ccAddress = mailMessage.getCcRecipient();
			
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailMessage.getSenderAddress(),
			        mailMessage.getSenderName()));
			if (null != _toAddress)
			{
				
				Set<String> _toEmail = _toAddress.keySet();
				Iterator<String> _toItr = _toEmail.iterator();
				
				while (_toItr.hasNext())
				{
					String _toEmailAdd = (String) _toItr.next();
					msg.addRecipient(Message.RecipientType.TO,
					        new InternetAddress(_toEmailAdd,
					                (String) _toAddress.get(_toEmailAdd)));
					
				}
			}
			
			if (null != _ccAddress)
			{
				
				Set<String> _ccEmail = _ccAddress.keySet();
				Iterator<String> _ccItr = _ccEmail.iterator();
				
				while (_ccItr.hasNext())
				{
					String _ccEmailAdd = (String) _ccItr.next();
					msg.addRecipient(Message.RecipientType.TO,
					        new InternetAddress(_ccEmailAdd,
					                (String) _toAddress.get(_ccEmailAdd)));
					
				}
			}
			
			msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
			        "helpdesk@onemastercontrol.com"));
			
			msg.setSubject(mailMessage.getMessageSubject());
			
			msg.setContent(msgBody, "text/html");
			Transport.send(msg);
			
		} catch (AddressException e)
		{
			e.printStackTrace();
			logger.log(Level.SEVERE, "AddressException = " + e.getMessage(), e);
			
		} catch (MessagingException e)
		{
			e.printStackTrace();
			logger.log(Level.SEVERE, "MessagingException = " + e.getMessage(),
			        e);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
			logger.log(Level.SEVERE,
			        "UnsupportedEncodingException = " + e.getMessage(), e);
		} catch (Exception e)
		{
			logger.log(Level.SEVERE, "Exception = " + e.getMessage(), e);
			e.printStackTrace();
		}
		logger.log(Level.INFO, "End MailUtil.SendMail");
	}
}
