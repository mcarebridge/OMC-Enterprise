package com.adviteya.model;

import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Blob;

@Model(schemaVersion = 4)
public class MA_Company extends AbstractEntity
{
	
	private static final long            serialVersionUID   = 6046415467456400582L;
	private ModelRef<MA_NatureOfCompany> natureOfCompanyRef = new ModelRef<MA_NatureOfCompany>(
	                                                                MA_NatureOfCompany.class);
	
	private ModelRef<MA_Template>        templateRef        = new ModelRef<MA_Template>(
	                                                                MA_Template.class);
	
	private String                       companyName;
	private Long                         emplyoeePopulation;
	private String                       uniqueidFlag;
	
	private Blob                         companyLogo;
	
	@Attribute(persistent = false)
	private List<MA_Location>            locationList;
	
	@Attribute(persistent = false)
	private List<MA_Employee>            employeeList;
	private String                       timeZone;
	private boolean                      accountVerified;
	private String                       logoFileName;
	private String                       active;
	
	/**
	 * @return the natureOfCompanyRef
	 */
	public ModelRef<MA_NatureOfCompany> getNatureOfCompanyRef()
	{
		return natureOfCompanyRef;
	}
	
	/**
	 * @return the templateRef
	 */
	public ModelRef<MA_Template> getTemplateRef()
	{
		return templateRef;
	}
	
	/**
	 * @return the companyName
	 */
	public String getCompanyName()
	{
		return companyName;
	}
	
	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	/**
	 * @return the emplyoeePopulation
	 */
	public Long getEmplyoeePopulation()
	{
		return emplyoeePopulation;
	}
	
	/**
	 * @param emplyoeePopulation
	 *            the emplyoeePopulation to set
	 */
	public void setEmplyoeePopulation(Long emplyoeePopulation)
	{
		this.emplyoeePopulation = emplyoeePopulation;
	}
	
	/**
	 * @return the uniqueidFlag
	 */
	public String getUniqueidFlag()
	{
		return uniqueidFlag;
	}
	
	/**
	 * @param uniqueidFlag
	 *            the uniqueidFlag to set
	 */
	public void setUniqueidFlag(String uniqueidFlag)
	{
		this.uniqueidFlag = uniqueidFlag;
	}
	
	/**
	 * @return the locationList
	 */
	public List<MA_Location> getLocationList()
	{
		return locationList;
	}
	
	/**
	 * @param locationList
	 *            the locationList to set
	 */
	public void setLocationList(List<MA_Location> locationList)
	{
		this.locationList = locationList;
	}
	
	/**
	 * @return the employeeList
	 */
	public List<MA_Employee> getEmployeeList()
	{
		return employeeList;
	}
	
	/**
	 * @param employeeList
	 *            the employeeList to set
	 */
	public void setEmployeeList(List<MA_Employee> employeeList)
	{
		this.employeeList = employeeList;
	}
	
	/**
	 * @return the companyLogo
	 */
	public Blob getCompanyLogo()
	{
		return companyLogo;
	}
	
	/**
	 * @param companyLogo
	 *            the companyLogo to set
	 */
	public void setCompanyLogo(Blob companyLogo)
	{
		this.companyLogo = companyLogo;
	}
	
	/**
	 * @return the timeZone
	 */
	public String getTimeZone()
	{
		return timeZone;
	}
	
	/**
	 * @param timeZone
	 *            the timeZone to set
	 */
	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}
	
	/**
	 * @return the accountVerified
	 */
	public boolean isAccountVerified()
	{
		return accountVerified;
	}
	
	/**
	 * @param accountVerified
	 *            the accountVerified to set
	 */
	public void setAccountVerified(boolean accountVerified)
	{
		this.accountVerified = accountVerified;
	}
	
	public String getLogoFileName()
	{
		return logoFileName;
	}
	
	public void setLogoFileName(String logoFileName)
	{
		this.logoFileName = logoFileName;
	}
	
	public String getActive()
	{
		return active;
	}
	
	public void setActive(String active)
	{
		this.active = active;
	}
}