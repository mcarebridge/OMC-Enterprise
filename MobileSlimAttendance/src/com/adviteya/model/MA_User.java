package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 4)
public class MA_User extends AbstractEntity
{
	
	private static final long        serialVersionUID = -8561833453795964221L;
	private String                   userName;
	private String                   password;
	private String                   imeiCode;
	private String                   licAgreement;
	
	private ModelRef<MA_Company>     companyRef       = new ModelRef<MA_Company>(
	                                                          MA_Company.class);
	
	private ModelRef<MA_UserProfile> userProfileRef   = new ModelRef<MA_UserProfile>(
	                                                          MA_UserProfile.class);
	
	private ModelRef<MA_Employee>    employeeRef      = new ModelRef<MA_Employee>(
	                                                          MA_Employee.class);
	
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public ModelRef<MA_UserProfile> getUserProfileRef()
	{
		return userProfileRef;
	}
	
	public ModelRef<MA_Employee> getEmployeeRef()
	{
		return employeeRef;
	}
	
	public String getImeiCode()
	{
		return imeiCode;
	}
	
	public void setImeiCode(String imeiCode)
	{
		this.imeiCode = imeiCode;
	}
	
	public String getLicAgreement()
	{
		return licAgreement;
	}
	
	public void setLicAgreement(String licAgreement)
	{
		this.licAgreement = licAgreement;
	}
	
}