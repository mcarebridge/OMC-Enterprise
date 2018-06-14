package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class MA_Usage extends AbstractEntity
{
	
	/**
	 * 
	 */
	private static final long     serialVersionUID = 1679554549946378209L;
	private ModelRef<MA_Company>  companyRef       = new ModelRef<MA_Company>(
	                                                       MA_Company.class);
	private ModelRef<MA_Location> locationRef      = new ModelRef<MA_Location>(
	                                                       MA_Location.class);
	private double                consumedUnit;
	private int                   createDay;
	private int                   createMonth;
	private int                   createYear;
	
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}
	
	public double getConsumedUnit()
	{
		return consumedUnit;
	}
	
	public void setConsumedUnit(double consumedUnit)
	{
		this.consumedUnit = consumedUnit;
	}
	
	public int getCreateDay()
	{
		return createDay;
	}
	
	public void setCreateDay(int createDay)
	{
		this.createDay = createDay;
	}
	
	public int getCreateMonth()
	{
		return createMonth;
	}
	
	public void setCreateMonth(int createMonth)
	{
		this.createMonth = createMonth;
	}
	
	public int getCreateYear()
	{
		return createYear;
	}
	
	public void setCreateYear(int createYear)
	{
		this.createYear = createYear;
	}
}
