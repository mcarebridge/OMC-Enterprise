package com.adviteya.dto;

public class EmployeeDTO
{
	
	private String companyEmployeeId;
	private long   id;
	private String name;
	private String employeeType;
	private String isSupervisor;
	private long   companyId;
	private String isActive;
	private String imeiCode;
	private String city;
	
	/**
	 * @return the companyEmployeeId
	 */
	public String getCompanyEmployeeId()
	{
		return companyEmployeeId;
	}
	
	/**
	 * @param companyEmployeeId
	 *            the companyEmployeeId to set
	 */
	public void setCompanyEmployeeId(String companyEmployeeId)
	{
		this.companyEmployeeId = companyEmployeeId;
	}
	
	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id)
	{
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return the employeeType
	 */
	public String getEmployeeType()
	{
		return employeeType;
	}
	
	/**
	 * @param employeeType
	 *            the employeeType to set
	 */
	public void setEmployeeType(String employeeType)
	{
		this.employeeType = employeeType;
	}
	
	/**
	 * @return the isSupervisor
	 */
	public String getIsSupervisor()
	{
		return isSupervisor;
	}
	
	/**
	 * @param isSupervisor
	 *            the isSupervisor to set
	 */
	public void setIsSupervisor(String isSupervisor)
	{
		this.isSupervisor = isSupervisor;
	}
	
	/**
	 * @return the companyId
	 */
	public long getCompanyId()
	{
		return companyId;
	}
	
	/**
	 * @param companyId
	 *            the companyId to set
	 */
	public void setCompanyId(long companyId)
	{
		this.companyId = companyId;
	}
	
	/**
	 * @return the isActive
	 */
	public String getIsActive()
	{
		return isActive;
	}
	
	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(String isActive)
	{
		this.isActive = isActive;
	}
	
	public String getImeiCode()
	{
		return imeiCode;
	}
	
	public void setImeiCode(String imeiCode)
	{
		this.imeiCode = imeiCode;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
}
