package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 2)
public class MA_ContractorCompany extends MA_Company
{
	
	/**
     * 
     */
	private static final long    serialVersionUID = -7075203096258408758L;
	private ModelRef<MA_Company> companyRef       = new ModelRef<MA_Company>(
	                                                      MA_Company.class);
	
	private String               createEmployee;
	private String               viewReports;
	
	private String               status;
	
	/**
	 * @return the companyRef
	 */
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	/**
	 * @return the createEmployee
	 */
	public String getCreateEmployee()
	{
		return createEmployee;
	}
	
	/**
	 * @param createEmployee
	 *            the createEmployee to set
	 */
	public void setCreateEmployee(String createEmployee)
	{
		this.createEmployee = createEmployee;
	}
	
	/**
	 * @return the viewReports
	 */
	public String getViewReports()
	{
		return viewReports;
	}
	
	/**
	 * @param viewReports
	 *            the viewReports to set
	 */
	public void setViewReports(String viewReports)
	{
		this.viewReports = viewReports;
	}
	
}
