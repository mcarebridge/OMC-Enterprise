package com.adviteya.model;

import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 1)
public class MA_EmailStore extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long serialVersionUID = 6740774835096025279L;
	
	private String            toAddress;
	private String            ccAddress;
	private String            subjects;
	private Text              emailContent;
	
	public String getToAddress()
	{
		return toAddress;
	}
	
	public void setToAddress(String toAddress)
	{
		this.toAddress = toAddress;
	}
	
	public String getCcAddress()
	{
		return ccAddress;
	}
	
	public void setCcAddress(String ccAddress)
	{
		this.ccAddress = ccAddress;
	}
	
	public String getSubjects()
	{
		return subjects;
	}
	
	public void setSubjects(String subjects)
	{
		this.subjects = subjects;
	}
	
	public Text getEmailContent()
	{
		return emailContent;
	}
	
	public void setEmailContent(Text emailContents)
	{
		this.emailContent = emailContents;
	}
}
