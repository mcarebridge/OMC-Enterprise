package com.adviteya.dto;

import java.io.Serializable;

public class LocationDTO implements Serializable
{
	
	private Long   locationId;
	private String locationName;
	private String status;
	private String city;
	private String pinCode;
	private String state;
	private int    assignmentCount;
	private int    totalInCount;
	private int    totalInAsgCount;
	private int    lateInEmployeeCount   = 0;
	private int    earlyOutEmployeeCount = 0;
	private int    leaveCount            = 0;
	private long   countryId;
	
	private String line1;
	private String line2;
	private long   stateId;
	private String timezone;
	private String active;
	private String countryName;
	private String latitude;
	private String longitude;
	
	/**
	 * @return the locationId
	 */
	public Long getLocationId()
	{
		return locationId;
	}
	
	/**
	 * @param locationId
	 *            the locationId to set
	 */
	public void setLocationId(Long locationId)
	{
		this.locationId = locationId;
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
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}
	
	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
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
	 * @return the pinCode
	 */
	public String getPinCode()
	{
		return pinCode;
	}
	
	/**
	 * @param pinCode
	 *            the pinCode to set
	 */
	public void setPinCode(String pinCode)
	{
		this.pinCode = pinCode;
	}
	
	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}
	
	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	
	public int getAssignmentCount()
	{
		return assignmentCount;
	}
	
	public void setAssignmentCount(int assignmentCount)
	{
		this.assignmentCount = assignmentCount;
	}
	
	public int getTotalInCount()
	{
		return totalInCount;
	}
	
	public void setTotalInCount(int totalInCount)
	{
		this.totalInCount = totalInCount;
	}
	
	public int getLateInEmployeeCount()
	{
		return lateInEmployeeCount;
	}
	
	public void setLateInEmployeeCount(int lateInEmployeeCount)
	{
		this.lateInEmployeeCount = lateInEmployeeCount;
	}
	
	public int getEarlyOutEmployeeCount()
	{
		return earlyOutEmployeeCount;
	}
	
	public void setEarlyOutEmployeeCount(int earlyOutEmployeeCount)
	{
		this.earlyOutEmployeeCount = earlyOutEmployeeCount;
	}
	
	public int getLeaveCount()
	{
		return leaveCount;
	}
	
	public void setLeaveCount(int leaveCount)
	{
		this.leaveCount = leaveCount;
	}
	
	public long getCountryId()
	{
		return countryId;
	}
	
	public void setCountryId(long country)
	{
		this.countryId = country;
	}
	
	public String getLine1()
	{
		return line1;
	}
	
	public void setLine1(String line1)
	{
		this.line1 = line1;
	}
	
	public String getLine2()
	{
		return line2;
	}
	
	public void setLine2(String line2)
	{
		this.line2 = line2;
	}
	
	/**
	 * @return the stateId
	 */
	public long getStateId()
	{
		return stateId;
	}
	
	/**
	 * @param stateId
	 *            the stateId to set
	 */
	public void setStateId(long stateId)
	{
		this.stateId = stateId;
	}
	
	/**
	 * @return the timezone
	 */
	public String getTimezone()
	{
		return timezone;
	}
	
	/**
	 * @param timezone
	 *            the timezone to set
	 */
	public void setTimezone(String timezone)
	{
		this.timezone = timezone;
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
	 * @return the countryName
	 */
	public String getCountryName()
	{
		return countryName;
	}
	
	/**
	 * @param countryName
	 *            the countryName to set
	 */
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}
	
	/**
	 * @return the latitude
	 */
	public String getLatitude()
	{
		return latitude;
	}
	
	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}
	
	/**
	 * @return the longitude
	 */
	public String getLongitude()
	{
		return longitude;
	}
	
	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}
	
	public int getTotalInAsgCount()
	{
		return totalInAsgCount;
	}
	
	public void setTotalInAsgCount(int totalInAsgCount)
	{
		this.totalInAsgCount = totalInAsgCount;
	}
	
}
