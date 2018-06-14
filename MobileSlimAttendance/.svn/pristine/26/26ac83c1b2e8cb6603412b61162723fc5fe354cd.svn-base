package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class MA_AlertTriggerLog extends AbstractEntity
{
	
	/**
	 * 
	 */
	private static final long  serialVersionUID = 983286306937990589L;
	
	private ModelRef<MA_Alert> alertRef         = new ModelRef<MA_Alert>(
	                                                    MA_Alert.class);
	private ModelRef<MA_Shift> shiftRef         = new ModelRef<MA_Shift>(
	                                                    MA_Shift.class);
	
	private Integer            createDay;
	private Integer            createMonth;
	private Integer            createYear;

	private Boolean            firstAlert;
	

	private Boolean            secondAlert;
	private Date               firstAlertTimeStamp;
	private Date               secondAlertTimeStamp;
	
	public Integer getCreateDay()
	{
		return createDay;
	}
	
	public void setCreateDay(Integer createDay)
	{
		this.createDay = createDay;
	}
	
	public Integer getCreateMonth()
	{
		return createMonth;
	}
	
	public void setCreateMonth(Integer createMonth)
	{
		this.createMonth = createMonth;
	}
	
	public Integer getCreateYear()
	{
		return createYear;
	}
	
	public void setCreateYear(Integer createYear)
	{
		this.createYear = createYear;
	}
	

	
	public Boolean getFirstAlert()
	{
		return firstAlert;
	}

	public void setFirstAlert(Boolean firstAlert)
	{
		this.firstAlert = firstAlert;
	}

	public Boolean getSecondAlert()
	{
		return secondAlert;
	}

	public void setSecondAlert(Boolean secondAlert)
	{
		this.secondAlert = secondAlert;
	}

	public ModelRef<MA_Shift> getShiftRef()
	{
		return shiftRef;
	}
	

	
	public Date getFirstAlertTimeStamp()
	{
		return firstAlertTimeStamp;
	}
	
	public void setFirstAlertTimeStamp(Date firstAlertTimeStamp)
	{
		this.firstAlertTimeStamp = firstAlertTimeStamp;
	}
	
	public Date getSecondAlertTimeStamp()
	{
		return secondAlertTimeStamp;
	}
	
	public void setSecondAlertTimeStamp(Date secondAlertTimeStamp)
	{
		this.secondAlertTimeStamp = secondAlertTimeStamp;
	}
	
	public ModelRef<MA_Alert> getAlertRef()
	{
		return alertRef;
	}
	
}
