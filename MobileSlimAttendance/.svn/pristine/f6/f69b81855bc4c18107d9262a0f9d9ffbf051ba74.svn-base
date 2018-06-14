package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 1)
public class MA_Department extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long     serialVersionUID = -3031027254279468516L;
	
	private ModelRef<MA_Company>  companyRef       = new ModelRef<MA_Company>(
	                                                       MA_Company.class);
	private ModelRef<MA_Location> locationRef      = new ModelRef<MA_Location>(
	                                                       MA_Location.class);
	
	private String                departmentName;
	private Text                  description;
	private String                active;
	
	/**
	 * @return the description
	 */
	public Text getDescription()
	{
		return description;
	}
	
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(Text description)
	{
		this.description = description;
	}
	
	/**
	 * @return the departmentName
	 */
	public String getDepartmentName()
	{
		return departmentName;
	}
	
	/**
	 * @param departmentName
	 *            the departmentName to set
	 */
	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}
	
	/**
	 * @return the companyRef
	 */
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	public String getActive()
	{
		return active;
	}
	
	public void setActive(String active)
	{
		this.active = active;
	}
	
	/**
	 * @return the locationRef
	 */
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}
	
}
