package com.adviteya.model;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 5)
public class MA_Employee extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long          serialVersionUID = 7056013968248204215L;
	
	private ModelRef<MA_Company>       companyRef       = new ModelRef<MA_Company>(
	                                                            MA_Company.class);
	private ModelRef<MA_Location>      locationRef      = new ModelRef<MA_Location>(
	                                                            MA_Location.class);
	private ModelRef<MA_TemplateSkill> skillRef         = new ModelRef<MA_TemplateSkill>(
	                                                            MA_TemplateSkill.class);
	
	private String                     firstName;
	private String                     lastName;
	private String                     salutation;
	private String                     companyEmpId;
	private String                     empPwd;
	private Date                       startDate;
	private String                     employeeType;
	// "Y"-supervisor "N"-not Supervisor "M"-Manager
	private String                     isSuperwiser;
	
	// 0-M,1-F,2-Others
	
	private String                     gender;
	
	// Minimum number of days a employee need to work daily
	private Integer                    minWorkingHrsPerDay;
	
	// Minimum of num of working days in a week
	private Integer                    numOfWorkingDays;
	
	// The day of weekly off
	private String                     dayOfWeeklyOff;
	
	// Can a employee shift his/her weekly off. This will effect the timesheet.
	// If the weekly off is flexible
	// it will be left to manager's judgement to decide the timesheet approval
	private boolean                    weeklyOffFlexible;
	
	private String                     imeiCode;
	
	@Attribute(persistent = false)
	private List<MA_Assignment>        assignments;
	
	private String                     active;
	
	private Date                       inActiveDate;
	private String                     city;
	private String					   emailId;	
	/**
	 * @return the companyRef
	 */
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	/**
	 * @return the locationRef
	 */
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}
	
	/**
	 * @return the skillRef
	 */
	public ModelRef<MA_TemplateSkill> getSkillRef()
	{
		return skillRef;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 * @return the gender
	 */
	public String getGender()
	{
		return gender;
	}
	
	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	/**
	 * @return the minWorkingHrsPerDay
	 */
	public Integer getMinWorkingHrsPerDay()
	{
		return minWorkingHrsPerDay;
	}
	
	/**
	 * @param minWorkingHrsPerDay
	 *            the minWorkingHrsPerDay to set
	 */
	public void setMinWorkingHrsPerDay(Integer minWorkingHrsPerDay)
	{
		this.minWorkingHrsPerDay = minWorkingHrsPerDay;
	}
	
	/**
	 * @return the numOfWorkingDays
	 */
	public Integer getNumOfWorkingDays()
	{
		return numOfWorkingDays;
	}
	
	/**
	 * @param numOfWorkingDays
	 *            the numOfWorkingDays to set
	 */
	public void setNumOfWorkingDays(Integer numOfWorkingDays)
	{
		this.numOfWorkingDays = numOfWorkingDays;
	}
	
	/**
	 * @return the dayOfWeeklyOff
	 */
	public String getDayOfWeeklyOff()
	{
		return dayOfWeeklyOff;
	}
	
	/**
	 * @param dayOfWeeklyOff
	 *            the dayOfWeeklyOff to set
	 */
	public void setDayOfWeeklyOff(String dayOfWeeklyOff)
	{
		this.dayOfWeeklyOff = dayOfWeeklyOff;
	}
	
	/**
	 * @return the salutation
	 */
	public String getSalutation()
	{
		return salutation;
	}
	
	/**
	 * @param salutation
	 *            the salutation to set
	 */
	public void setSalutation(String salutation)
	{
		this.salutation = salutation;
	}
	
	/**
	 * @return the weeklyOffFlexible
	 */
	public boolean isWeeklyOffFlexible()
	{
		return weeklyOffFlexible;
	}
	
	/**
	 * @param weeklyOffFlexible
	 *            the weeklyOffFlexible to set
	 */
	public void setWeeklyOffFlexible(boolean weeklyOffFlexible)
	{
		this.weeklyOffFlexible = weeklyOffFlexible;
	}
	
	/**
	 * @return the assignments
	 */
	public List<MA_Assignment> getAssignments()
	{
		return assignments;
	}
	
	/**
	 * @param assignments
	 *            the assignments to set
	 */
	public void setAssignments(List<MA_Assignment> assignments)
	{
		this.assignments = assignments;
	}
	
	/**
	 * @return the startDate
	 */
	public Date getStartDate()
	{
		return startDate;
	}
	
	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
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
	 * @return the companyEmpId
	 */
	public String getCompanyEmpId()
	{
		return companyEmpId;
	}
	
	/**
	 * @param companyEmpId
	 *            the companyEmpId to set
	 */
	public void setCompanyEmpId(String companyEmpId)
	{
		this.companyEmpId = companyEmpId;
	}
	
	/**
	 * @return the isSuperwiser
	 */
	public String getIsSuperwiser()
	{
		return isSuperwiser;
	}
	
	/**
	 * @param isSuperwiser
	 *            the isSuperwiser to set
	 */
	public void setIsSuperwiser(String isSuperwiser)
	{
		this.isSuperwiser = isSuperwiser;
	}
	
	/**
	 * @return the empPwd
	 */
	public String getEmpPwd()
	{
		return empPwd;
	}
	
	/**
	 * @param empPwd
	 *            the empPwd to set
	 */
	public void setEmpPwd(String empPwd)
	{
		this.empPwd = empPwd;
	}
	
	/**
	 * @return the active
	 */
	public String getActive()
	{
		return active;
	}
	
	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(String active)
	{
		this.active = active;
	}
	
	public String getImeiCode()
	{
		return imeiCode;
	}
	
	public void setImeiCode(String imeiCode)
	{
		this.imeiCode = imeiCode;
	}
	
	/**
	 * @return the inActiveDate
	 */
	public Date getInActiveDate()
	{
		return inActiveDate;
	}
	
	/**
	 * @param inActiveDate
	 *            the inActiveDate to set
	 */
	public void setInActiveDate(Date inActiveDate)
	{
		this.inActiveDate = inActiveDate;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}

	public String getEmailId()
    {
	    return emailId;
    }

	public void setEmailId(String emailId)
    {
	    this.emailId = emailId;
    }
	
}
