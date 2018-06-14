package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class MA_EscalationHierarchy extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long     serialVersionUID = 4510241119992448766L;
	
	private ModelRef<MA_Company>  companyRef       = new ModelRef<MA_Company>(
	                                                       MA_Company.class);  ;
	private ModelRef<MA_Employee> reporteeEmp      = new ModelRef<MA_Employee>(
	                                                       MA_Employee.class); ;;
	private ModelRef<MA_Employee> managerEmp       = new ModelRef<MA_Employee>(
	                                                       MA_Employee.class); ;;
	private String                active;
	private String                city;
	
	public String getActive()
	{
		return active;
	}
	
	public void setActive(String active)
	{
		this.active = active;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	public ModelRef<MA_Employee> getReporteeEmp()
	{
		return reporteeEmp;
	}
	
	public ModelRef<MA_Employee> getManagerEmp()
	{
		return managerEmp;
	}
	
}
