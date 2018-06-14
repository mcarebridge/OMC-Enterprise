package com.adviteya.dto;

import java.io.Serializable;

public class TimeZoneDTO implements Serializable
{
	
	/**
     * 
     */
	private static final long serialVersionUID = 8389132373118503285L;
	private String            timeZoneId;
	private String            description;
	
	/**
	 * @return the timeZoneId
	 */
	public String getTimeZoneId()
	{
		return timeZoneId;
	}
	
	/**
	 * @param timeZoneId
	 *            the timeZoneId to set
	 */
	public void setTimeZoneId(String timeZoneId)
	{
		this.timeZoneId = timeZoneId;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
		        + ((description == null) ? 0 : description.hashCode());
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeZoneDTO other = (TimeZoneDTO) obj;
		if (description == null)
		{
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
}
