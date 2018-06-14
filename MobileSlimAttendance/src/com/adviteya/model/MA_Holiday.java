package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

/**
 * This model stores the Holiday at Country level. The country level Holiday are
 * available to all the Locations within a country. To store - i.e. to pick
 * selected holidays for a location use MA_CustomerHoliday
 * 
 * @author Dheeraj
 * 
 */

@Model(schemaVersion = 1)
public class MA_Holiday extends AbstractEntity
{
	private static final long     serialVersionUID = -374115576660730269L;
	
	private String                countryCode;
	private Date                  holidayDate;
	private String                holidayDesc;
	private ModelRef<MA_Location> locationRef      = new ModelRef<MA_Location>(
	                                                       MA_Location.class);
	
	public Date getHolidayDate()
	{
		return holidayDate;
	}
	
	public void setHolidayDate(Date holidayDate)
	{
		this.holidayDate = holidayDate;
	}
	
	public String getHolidayDesc()
	{
		return holidayDesc;
	}
	
	public void setHolidayDesc(String holidayDesc)
	{
		this.holidayDesc = holidayDesc;
	}
	
	/**
	 * @return the countryCode
	 */
	public String getCountryCode()
	{
		return countryCode;
	}
	
	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}
	
	/**
	 * @return the locationRef
	 */
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}
	
}
