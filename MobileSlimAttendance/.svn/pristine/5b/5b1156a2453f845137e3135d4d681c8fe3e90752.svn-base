/**
 * 
 */
package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

/**
 * @author Shailesh
 * 
 */
@Model(schemaVersion = 2)
public class MA_ConsolidatedTimesheet extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long       serialVersionUID = -919208058763345748L;
	
	private ModelRef<MA_Assignment> assignmentRef    = new ModelRef<MA_Assignment>(
	                                                         MA_Assignment.class);
	private ModelRef<MA_Employee>   empModelRef      = new ModelRef<MA_Employee>(
	                                                         MA_Employee.class);
	
	private ModelRef<MA_Location>   locationRef      = new ModelRef<MA_Location>(
	                                                         MA_Location.class);
	private ModelRef<MA_Shift>      shiftRef         = new ModelRef<MA_Shift>(
	                                                         MA_Shift.class);
	
	private Long                    companyId;
	
	private Date                    inDateTime;
	private Date                    outDateTime;
	private Double                  dailyEffort;
	private Integer                 createDay;
	private Integer                 createMonth;
	private Integer                 createYear;
	// Marker will have values CURRENT,UPDATED
	private String                  marker;
	@Attribute(persistent = false)
	private String                  secondsToHHMM;
	private Double                  actualDailyEffort;
	private Double                  overTime;
	private Double                  billableEfforts;
	private Integer                 inTimeResult;
	private Integer                 outTimeResult;
	private Integer                 effortResult;
	private String                  timesheetRuleResult;
	private String                  approved;
	private String                  approvalResult;
	
	/**
	 * @return the assignmentRef
	 */
	public ModelRef<MA_Assignment> getAssignmentRef()
	{
		return assignmentRef;
	}
	
	/**
	 * @return the empModelRef
	 */
	public ModelRef<MA_Employee> getEmpModelRef()
	{
		return empModelRef;
	}
	
	/**
	 * @return the locationRef
	 */
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}
	
	/**
	 * @return the shiftRef
	 */
	public ModelRef<MA_Shift> getShiftRef()
	{
		return shiftRef;
	}
	
	/**
	 * @return the inDateTime
	 */
	public Date getInDateTime()
	{
		return inDateTime;
	}
	
	/**
	 * @param inDateTime
	 *            the inDateTime to set
	 */
	public void setInDateTime(Date inDateTime)
	{
		this.inDateTime = inDateTime;
	}
	
	/**
	 * @return the outDateTime
	 */
	public Date getOutDateTime()
	{
		return outDateTime;
	}
	
	/**
	 * @param outDateTime
	 *            the outDateTime to set
	 */
	public void setOutDateTime(Date outDateTime)
	{
		this.outDateTime = outDateTime;
	}
	
	/**
	 * @return the dailyEffort
	 */
	public Double getDailyEffort()
	{
		return dailyEffort;
	}
	
	/**
	 * @param dailyEffort
	 *            the dailyEffort to set
	 */
	public void setDailyEffort(Double dailyEffort)
	{
		this.dailyEffort = dailyEffort;
	}
	
	public Integer getCreateDay()
	{
		return createDay;
	}
	
	public void setCreateDay(Integer createDay)
	{
		this.createDay = createDay;
	}
	
	public Integer getCreateMonth()
	{
		return createMonth;
	}
	
	public void setCreateMonth(Integer createMonth)
	{
		this.createMonth = createMonth;
	}
	
	public Integer getCreateYear()
	{
		return createYear;
	}
	
	public void setCreateYear(Integer createYear)
	{
		this.createYear = createYear;
	}
	
	/**
	 * @return the marker
	 */
	public String getMarker()
	{
		return marker;
	}
	
	/**
	 * @param marker
	 *            the marker to set
	 */
	public void setMarker(String marker)
	{
		this.marker = marker;
	}
	
	/**
	 * @return the secondsToHHMM
	 */
	public String getSecondsToHHMM()
	{
		return secondsToHHMM;
	}
	
	/**
	 * @param secondsToHHMM
	 *            the secondsToHHMM to set
	 */
	public void setSecondsToHHMM(String timeString)
	{
		if (timeString != null)
		{
			String enc = "UTF-8";
			double time = Double.parseDouble(timeString);
			
			/*
			 * int seconds = (int) (time % 60); int minutes = (int) ((time / 60)
			 * % 60); int hours = (int) ((time / 3600) % 24);
			 */
			int hours = (int) (time / 3600);
			int minutes = (int) ((time % 3600) / 60);
			String minutesStr = (minutes < 10 ? "0" : "") + minutes;
			String hoursStr = (hours < 10 ? "0" : "") + hours;
			secondsToHHMM = (hoursStr + "'" + minutesStr + "''");
		}
	}
	
	/**
	 * @return the actualDailyEffort
	 */
	public Double getActualDailyEffort()
	{
		return actualDailyEffort;
	}
	
	/**
	 * @param actualDailyEffort
	 *            the actualDailyEffort to set
	 */
	public void setActualDailyEffort(Double actualDailyEffort)
	{
		this.actualDailyEffort = actualDailyEffort;
		
		if (actualDailyEffort != null)
			setSecondsToHHMM(actualDailyEffort.toString());
		
	}
	
	/**
	 * @return the billableEfforts
	 */
	public Double getBillableEfforts()
	{
		return billableEfforts;
	}
	
	/**
	 * @param billableEfforts
	 *            the billableEfforts to set
	 */
	public void setBillableEfforts(Double billableEfforts)
	{
		this.billableEfforts = billableEfforts;
	}
	
	/**
	 * @return the timesheetRuleResult
	 */
	public String getTimesheetRuleResult()
	{
		return timesheetRuleResult;
	}
	
	/**
	 * @param timesheetRuleResult
	 *            the timesheetRuleResult to set
	 */
	public void setTimesheetRuleResult(String timesheetRuleResult)
	{
		this.timesheetRuleResult = timesheetRuleResult;
	}
	
	/**
	 * @return the inTimeResult
	 */
	public Integer getInTimeResult()
	{
		return inTimeResult;
	}
	
	/**
	 * @param inTimeResult
	 *            the inTimeResult to set
	 */
	public void setInTimeResult(Integer inTimeResult)
	{
		this.inTimeResult = inTimeResult;
	}
	
	/**
	 * @return the outTimeResult
	 */
	public Integer getOutTimeResult()
	{
		return outTimeResult;
	}
	
	/**
	 * @param outTimeResult
	 *            the outTimeResult to set
	 */
	public void setOutTimeResult(Integer outTimeResult)
	{
		this.outTimeResult = outTimeResult;
	}
	
	/**
	 * @return the effortResult
	 */
	public Integer getEffortResult()
	{
		return effortResult;
	}
	
	/**
	 * @param effortResult
	 *            the effortResult to set
	 */
	public void setEffortResult(Integer effortResult)
	{
		this.effortResult = effortResult;
	}
	
	/**
	 * @return the overTime
	 */
	public Double getOverTime()
	{
		return overTime;
	}
	
	/**
	 * @param overTime
	 *            the overTime to set
	 */
	public void setOverTime(Double overTime)
	{
		this.overTime = overTime;
	}
	
	/**
	 * @return the approved
	 */
	public String getApproved()
	{
		return approved;
	}
	
	/**
	 * @param approved
	 *            the approved to set
	 */
	public void setApproved(String approved)
	{
		this.approved = approved;
	}
	
	/**
	 * @return the approvalResult
	 */
	public String getApprovalResult()
	{
		return approvalResult;
	}
	
	/**
	 * @param approvalResult
	 *            the approvalResult to set
	 */
	public void setApprovalResult(String approvalResult)
	{
		this.approvalResult = approvalResult;
	}
	
	public Long getCompanyId()
	{
		return companyId;
	}
	
	public void setCompanyId(Long companyId)
	{
		this.companyId = companyId;
	}
	
}
