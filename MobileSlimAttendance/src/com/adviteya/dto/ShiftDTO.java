package com.adviteya.dto;

public class ShiftDTO
{
	
	private Long   shiftId;
	private String shiftName;
	private String locationName;
	private String startTime;
	private String endTime;
	private Long   locationId;
	private String active;
	private String startHrs;
	private String startMin;
	private String endHrs;
	private String endMin;
	private String duration;
	private String createdDate;
	private String timeZone;
	
	public String getDuration()
	{
		return duration;
	}
	
	public void setDuration(String string)
	{
		duration = string;
	}
	
	/**
	 * @return the shiftId
	 */
	public Long getShiftId()
	{
		return shiftId;
	}
	
	/**
	 * @param shiftId
	 *            the shiftId to set
	 */
	public void setShiftId(Long shiftId)
	{
		this.shiftId = shiftId;
	}
	
	/**
	 * @return the shiftName
	 */
	public String getShiftName()
	{
		return shiftName;
	}
	
	/**
	 * @param shiftName
	 *            the shiftName to set
	 */
	public void setShiftName(String shiftName)
	{
		this.shiftName = shiftName;
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
	 * @return the startTime
	 */
	public String getStartTime()
	{
		return startTime;
	}
	
	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}
	
	/**
	 * @return the endTime
	 */
	public String getEndTime()
	{
		return endTime;
	}
	
	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}
	
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
	 * @return the startHrs
	 */
	public String getStartHrs()
	{
		return startHrs;
	}
	
	/**
	 * @param startHrs2
	 *            the startHrs to set
	 */
	public void setStartHrs(String startHrs2)
	{
		this.startHrs = startHrs2;
	}
	
	/**
	 * @return the startMin
	 */
	public String getStartMin()
	{
		return startMin;
	}
	
	/**
	 * @param startMin
	 *            the startMin to set
	 */
	public void setStartMin(String startMin)
	{
		this.startMin = startMin;
	}
	
	/**
	 * @return the endHrs
	 */
	public String getEndHrs()
	{
		return endHrs;
	}
	
	/**
	 * @param endHrs
	 *            the endHrs to set
	 */
	public void setEndHrs(String endHrs)
	{
		this.endHrs = endHrs;
	}
	
	/**
	 * @return the endMin
	 */
	public String getEndMin()
	{
		return endMin;
	}
	
	/**
	 * @param endMin
	 *            the endMin to set
	 */
	public void setEndMin(String endMin)
	{
		this.endMin = endMin;
	}
	
	public String getCreatedDate()
	{
		return createdDate;
	}
	
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}
	
	public String getTimeZone()
	{
		return timeZone;
	}
	
	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}
	
}
