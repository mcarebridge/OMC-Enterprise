package com.adviteya.model;

import java.util.Map;

import com.google.appengine.api.datastore.Text;

public class MA_MailMessage
{
	
	/**
     * 
     */
	private static final long   serialVersionUID = 9058521348411552459L;
	private String              messageSubject;
	private Text                messageBody;
	private String              senderAddress;
	private String              senderName;
	private Map<String, String> toRecipient;
	private Map<String, String> ccRecipient;
	
	public Text getMessageBody()
	{
		return messageBody;
	}
	
	public void setMessageBody(Text messageBody)
	{
		this.messageBody = messageBody;
	}
	
	public String getSenderAddress()
	{
		return senderAddress;
	}
	
	public void setSenderAddress(String senderAddress)
	{
		this.senderAddress = senderAddress;
	}
	
	public String getSenderName()
	{
		return senderName;
	}
	
	public void setSenderName(String senderName)
	{
		this.senderName = senderName;
	}
	
	public Map<String, String> getToRecipient()
	{
		return toRecipient;
	}
	
	public void setToRecipient(Map<String, String> toRecipient)
	{
		this.toRecipient = toRecipient;
	}
	
	public Map<String, String> getCcRecipient()
	{
		return ccRecipient;
	}
	
	public void setCcRecipient(Map<String, String> ccRecipient)
	{
		this.ccRecipient = ccRecipient;
	}
	
	public String getMessageSubject()
	{
		return messageSubject;
	}
	
	public void setMessageSubject(String messageSubject)
	{
		this.messageSubject = messageSubject;
	}
	
}
