package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 1)
public class MA_Contract extends AbstractEntity
{
	
	/**
	 * 
	 */
	private static final long    serialVersionUID = 675012489399426438L;
	private ModelRef<MA_Company> companyRef       = new ModelRef<MA_Company>(
	                                                      MA_Company.class);
	private ModelRef<MA_Package> packageRef       = new ModelRef<MA_Package>(
	                                                      MA_Package.class);
	private Text                 contractDescription;
	private String               active;
	private Date                 startDate;
	private Date                 endDate;
	private String               billingCycle;
	
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	public ModelRef<MA_Package> getPackageRef()
	{
		return packageRef;
	}
	
	public Text getContractDescription()
	{
		return contractDescription;
	}
	
	public void setContractDescription(Text contractDescription)
	{
		this.contractDescription = contractDescription;
	}
	
	public String getActive()
	{
		return active;
	}
	
	public void setActive(String active)
	{
		this.active = active;
	}
	
	public Date getStartDate()
	{
		return startDate;
	}
	
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
	
	public String getBillingCycle()
	{
		return billingCycle;
	}
	
	public void setBillingCycle(String billingCycle)
	{
		this.billingCycle = billingCycle;
	}
}
