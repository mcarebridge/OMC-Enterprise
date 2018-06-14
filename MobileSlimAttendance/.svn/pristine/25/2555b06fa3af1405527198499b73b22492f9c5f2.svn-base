package com.adviteya.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class MA_Alert extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long      serialVersionUID   = -4204639320034663148L;
	
	private ModelRef<MA_Location>  locationRef        = new ModelRef<MA_Location>(
	                                                          MA_Location.class);
	
	private ModelRef<MA_Shift>     shiftRef           = new ModelRef<MA_Shift>(
	                                                          MA_Shift.class);
	private ModelRef<MA_AlertType> alertTypeRef       = new ModelRef<MA_AlertType>(
	                                                          MA_AlertType.class);
	private ModelRef<MA_Company>   companyref         = new ModelRef<MA_Company>(
	                                                          MA_Company.class);
	private int                    targetValues;
	@Attribute(persistent = false)
	private int                    actualValues;
	@Attribute(persistent = false)
	private boolean                isEscalated;
	private int                    minValueForAlert;
	private int                    maxValueForAlert;
	private int                    toleranceLevelForEscalation;
	private String                 alertMeans;
	private String                 active;
	private ModelRef<MA_Employee>  firstLevelManager  = new ModelRef<MA_Employee>(
	                                                          MA_Employee.class);
	private ModelRef<MA_Employee>  secondLevelManager = new ModelRef<MA_Employee>(
	                                                          MA_Employee.class);
	
	public ModelRef<MA_Employee> getSecondLevelManager()
	{
		return secondLevelManager;
	}
	
	public ModelRef<MA_Employee> getFirstLevelManager()
	{
		return firstLevelManager;
	}
	
	public int getTargetValues()
	{
		return targetValues;
	}
	
	public void setTargetValues(int targetValues)
	{
		this.targetValues = targetValues;
	}
	
	public int getMinValueForAlert()
	{
		return minValueForAlert;
	}
	
	public void setMinValueForAlert(int minValueForAlert)
	{
		this.minValueForAlert = minValueForAlert;
	}
	
	public int getMaxValueForAlert()
	{
		return maxValueForAlert;
	}
	
	public void setMaxValueForAlert(int maxValueForAlert)
	{
		this.maxValueForAlert = maxValueForAlert;
	}
	
	public int getToleranceLevelForEscalation()
	{
		return toleranceLevelForEscalation;
	}
	
	public void setToleranceLevelForEscalation(int toleranceLevelForEscalation)
	{
		this.toleranceLevelForEscalation = toleranceLevelForEscalation;
	}
	
	public String getAlertMeans()
	{
		return alertMeans;
	}
	
	public void setAlertMeans(String alertMeans)
	{
		this.alertMeans = alertMeans;
	}
	
	public String getActive()
	{
		return active;
	}
	
	public void setActive(String active)
	{
		this.active = active;
	}
	
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}
	
	public ModelRef<MA_Shift> getShiftRef()
	{
		return shiftRef;
	}
	
	public ModelRef<MA_Company> getCompanyref()
	{
		return companyref;
	}
	
	public ModelRef<MA_AlertType> getAlertTypeRef()
	{
		return alertTypeRef;
	}
	
	public int getActualValues()
	{
		return actualValues;
	}
	
	public void setActualValues(int actualValues)
	{
		this.actualValues = actualValues;
	}

	public boolean isEscalated()
	{
		return isEscalated;
	}

	public void setEscalated(boolean isEscalated)
	{
		this.isEscalated = isEscalated;
	}
	
}
