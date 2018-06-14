package com.adviteya.dto;

import java.io.Serializable;

public class AlertDTO implements Serializable
{
	
	/**
     * 
     */
	private static final long serialVersionUID = 5937034689343527536L;
	private long              alertId;
	private String            alertTypeName;
	private String            alertDescription;
	private String            locationName;
	
	public String getAlertTypeName()
	{
		return alertTypeName;
	}
	
	public void setAlertTypeName(String alertTypeName)
	{
		this.alertTypeName = alertTypeName;
	}
	
	public String getAlertDescription()
	{
		return alertDescription;
	}
	
	public void setAlertDescription(String alertDescription)
	{
		this.alertDescription = alertDescription;
	}
	
	public long getAlertId()
	{
		return alertId;
	}
	
	public void setAlertId(long alertId)
	{
		this.alertId = alertId;
	}
	
}
