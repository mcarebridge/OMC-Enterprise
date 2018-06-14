/**
 * 
 */
package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

/**
 * This Class will store all the Holidays for a location i.e. - 1. Pick and
 * Choose Country specific Holiday or 2. Create your own Holiday
 * 
 * @author Dheeraj
 * 
 */

@Model(schemaVersion = 1)
public class MA_LocationHoliday extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long     serialVersionUID = 3895344782075854907L;
	
	private ModelRef<MA_Location> locationRef      = new ModelRef<MA_Location>(
	                                                       MA_Location.class);
	private ModelRef<MA_Holiday>  holidayRef       = new ModelRef<MA_Holiday>(
	                                                       MA_Holiday.class);
	private Date                  locationHolidayDate;
	private String                locationHolidayDesc;
	
	/**
	 * @return the locationRef
	 */
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}
	
	/**
	 * @return the holidayRef
	 */
	public ModelRef<MA_Holiday> getHolidayRef()
	{
		return holidayRef;
	}
	
	/**
	 * @return the locationHolidayDate
	 */
	public Date getLocationHolidayDate()
	{
		return locationHolidayDate;
	}
	
	/**
	 * @param locationHolidayDate
	 *            the locationHolidayDate to set
	 */
	public void setLocationHolidayDate(Date locationHolidayDate)
	{
		this.locationHolidayDate = locationHolidayDate;
	}
	
	/**
	 * @return the locationHolidayDesc
	 */
	public String getLocationHolidayDesc()
	{
		return locationHolidayDesc;
	}
	
	/**
	 * @param locationHolidayDesc
	 *            the locationHolidayDesc to set
	 */
	public void setLocationHolidayDesc(String locationHolidayDesc)
	{
		this.locationHolidayDesc = locationHolidayDesc;
	}
	
}
