package com.adviteya.model;

import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.GeoPt;

@Model(schemaVersion = 1)
public class MA_Location extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long    serialVersionUID = 1L;
	
	// This is the address where the employee is located. This can be client
	// location address
	private ModelRef<MA_Address> addressRef       = new ModelRef<MA_Address>(
	                                                      MA_Address.class);
	
	private ModelRef<MA_Company> companyRef       = new ModelRef<MA_Company>(
	                                                      MA_Company.class);
	
	private String               locationName;
	private GeoPt                geoPoints;
	private String               active;
	private String               timeZone;
	
	@Attribute(persistent = false)
	private List<MA_Assignment>  assignments;
	
	/**
	 * @return the addressRef
	 */
	public ModelRef<MA_Address> getAddressRef()
	{
		
		return addressRef;
	}
	
	/**
	 * @return the geoPoints
	 */
	public GeoPt getGeoPoints()
	{
		return geoPoints;
	}
	
	/**
	 * @param geoPoints
	 *            the geoPoints to set
	 */
	public void setGeoPoints(GeoPt geoPoints)
	{
		this.geoPoints = geoPoints;
	}
	
	/**
	 * @return the active
	 */
	public String getActive()
	{
		return active;
	}
	
	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(String active)
	{
		this.active = active;
	}
	
	/**
	 * @return the locationName
	 */
	public String getLocationName()
	{
		return locationName;
	}
	
	/**
	 * @param locationName
	 *            the locationName to set
	 */
	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}
	
	/**
	 * @return the companyRef
	 */
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	/**
	 * @return the assignments
	 */
	public List<MA_Assignment> getAssignments()
	{
		return assignments;
	}
	
	/**
	 * @param assignments
	 *            the assignments to set
	 */
	public void setAssignments(List<MA_Assignment> assignments)
	{
		this.assignments = assignments;
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
	
}
