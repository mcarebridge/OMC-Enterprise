package com.adviteya.model;

import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class MA_Country extends AbstractEntity
{
	
	private static final long serialVersionUID = -3112503769295527288L;
	private String            countryName;
	private String            countryCode;
	private String            telephoneCode;
	
	public String getCountryName()
	{
		return countryName;
	}
	
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}
	
	public String getCountryCode()
	{
		return countryCode;
	}
	
	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}
	
	/**
	 * @return the telephoneCode
	 */
	public String getTelephoneCode()
	{
		return telephoneCode;
	}
	
	/**
	 * @param telephoneCode
	 *            the telephoneCode to set
	 */
	public void setTelephoneCode(String telephoneCode)
	{
		this.telephoneCode = telephoneCode;
	}
	
}