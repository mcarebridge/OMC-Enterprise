/**
 * 
 */
package com.adviteya.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Email;

/**
 * @author Dheeraj
 * 
 */
@Model(schemaVersion = 1)
public class MA_Address extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long    serialVersionUID = 3781433250672514922L;
	private ModelRef<MA_Company> companyRef       = new ModelRef<MA_Company>(
	                                                      MA_Company.class);
	private ModelRef<MA_State>   stateRef         = new ModelRef<MA_State>(
	                                                      MA_State.class);
	
	private String               line1;
	private String               line2;
	private String               city;
	private String               timeZone;
	private String               nonStandardState;
	
	@Attribute(unindexed = true)
	private Email                emailAddress;
	
	@Attribute(lob = true)
	private MA_PhoneNumber       officePhone[];
	
	private String               pinCode;
	
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	public ModelRef<MA_State> getStateRef()
	{
		return stateRef;
	}
	
	/**
	 * @return the line1
	 */
	public String getLine1()
	{
		return line1;
	}
	
	/**
	 * @param line1
	 *            the line1 to set
	 */
	public void setLine1(String line1)
	{
		this.line1 = line1;
	}
	
	/**
	 * @return the line2
	 */
	public String getLine2()
	{
		return line2;
	}
	
	/**
	 * @param line2
	 *            the line2 to set
	 */
	public void setLine2(String line2)
	{
		this.line2 = line2;
	}
	
	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	 * @return the emailAddress
	 */
	public Email getEmailAddress()
	{
		return emailAddress;
	}
	
	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(Email emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	/**
	 * @return the officePhone
	 */
	public MA_PhoneNumber[] getOfficePhone()
	{
		return officePhone;
	}
	
	/**
	 * @param officePhone
	 *            the officePhone to set
	 */
	public void setOfficePhone(MA_PhoneNumber officePhone[])
	{
		this.officePhone = officePhone;
	}
	
	public String getPinCode()
	{
		return pinCode;
	}
	
	public void setPinCode(String pinCode)
	{
		this.pinCode = pinCode;
	}
	
	/**
	 * @return the timeZone
	 */
	public String getTimeZone()
	{
		return timeZone;
	}
	
	/**
	 * @param timeZone
	 *            the timeZone to set
	 */
	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}
	
	public String getNonStandardState()
	{
		return nonStandardState;
	}
	
	public void setNonStandardState(String nonStandardState)
	{
		this.nonStandardState = nonStandardState;
	}
}
