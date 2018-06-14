/**
 * 
 */
package com.adviteya.model;

import com.google.appengine.api.datastore.PhoneNumber;

/**
 * @author Dheeraj
 * 
 */
public class MA_PhoneNumber extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long serialVersionUID = 8657799668952700672L;
	private PhoneNumber       phoneNumber;
	private String            phoneType;
	
	/**
	 * @return the phoneNumber
	 */
	public PhoneNumber getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(PhoneNumber phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return the phoneType
	 */
	public String getPhoneType()
	{
		return phoneType;
	}
	
	/**
	 * @param phoneType
	 *            the phoneType to set
	 */
	public void setPhoneType(String phoneType)
	{
		this.phoneType = phoneType;
	}
	
}
