package com.adviteya.dto;

public class ConsolidatedTimeSheetDTO
{
	
	private Long    employeeId;
	private String  employeeName;
	private String  locationName;
	private String  shiftName;
	private String  inTime;
	private String  inTimeDayOfWeek;
	private String  outTime;
	private String  outTimeDayOfWeek;
	private String  dailyEffort;
	private String  actualEffort;
	private String  overTime;
	private String  result;
	private Integer inTimeResult;
	private Integer outTimeResult;
	private Integer effortResult;
	private Long    timesheetId;
	private String  approved;
	private String  approvalResult;
	private boolean weeklyOff;
	private String  holidayDesc;
	private boolean holiday;
	private String  companyEmpId;
	
	// 03/28/2012 Shailesh -Following fields are added to show fields on new
	// report.
	private String  regularEffort;
	private String  leave;
	private String  employeeType;
	private String  createdDate;
	private String  departmentName;
	private String  designation;
	
	private String  attendanceCoordinatesIn;
	private String  attendanceCoordinatesOut;
	private String  timeZone;
	private long    noOfReports;
	
	/**
	 * 
	 * @return
	 */
	public String getAttendanceCoordinatesIn()
	{
		return attendanceCoordinatesIn;
	}
	
	/**
	 * 
	 * @param attendanceCoordinatesIn
	 */
	public void setAttendanceCoordinatesIn(String attendanceCoordinatesIn)
	{
		attendanceCoordinatesIn = (attendanceCoordinatesIn != null && !attendanceCoordinatesIn
		        .equals("null")) ? attendanceCoordinatesIn.replaceAll(",", "/")
		        : "NA";
		
		this.attendanceCoordinatesIn = attendanceCoordinatesIn;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAttendanceCoordinatesOut()
	{
		return attendanceCoordinatesOut;
	}
	
	/**
	 * 
	 * @param attendanceCoordinatesOut
	 */
	public void setAttendanceCoordinatesOut(String attendanceCoordinatesOut)
	{
		attendanceCoordinatesOut = (attendanceCoordinatesOut != null && !attendanceCoordinatesOut
		        .equals("null")) ? attendanceCoordinatesOut
		        .replaceAll(",", "/") : "NA";
		
		this.attendanceCoordinatesOut = attendanceCoordinatesOut;
	}
	
	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId()
	{
		return employeeId;
	}
	
	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(Long employeeId)
	{
		this.employeeId = employeeId;
	}
	
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName()
	{
		return employeeName;
	}
	
	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}
	
	/**
	 * @return the locationName
	 */
	public String getLocationName()
	{
		return locationName;
	}
	
	/**
	 * @param locationName
	 *            the locationName to set
	 */
	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}
	
	/**
	 * @return the shiftName
	 */
	public String getShiftName()
	{
		return shiftName;
	}
	
	/**
	 * @param shiftName
	 *            the shiftName to set
	 */
	public void setShiftName(String shiftName)
	{
		this.shiftName = shiftName;
	}
	
	/**
	 * @return the inTime
	 */
	public String getInTime()
	{
		return inTime;
	}
	
	/**
	 * @param inTime
	 *            the inTime to set
	 */
	public void setInTime(String inTime)
	{
		this.inTime = inTime;
	}
	
	/**
	 * @return the outTime
	 */
	public String getOutTime()
	{
		return outTime;
	}
	
	/**
	 * @param outTime
	 *            the outTime to set
	 */
	public void setOutTime(String outTime)
	{
		this.outTime = outTime;
	}
	
	/**
	 * @return the dailyEffort
	 */
	public String getDailyEffort()
	{
		return dailyEffort;
	}
	
	/**
	 * @param dailyEffort
	 *            the dailyEffort to set
	 */
	public void setDailyEffort(String dailyEffort)
	{
		this.dailyEffort = dailyEffort;
	}
	
	/**
	 * @return the actualEffort
	 */
	public String getActualEffort()
	{
		return actualEffort;
	}
	
	/**
	 * @param actualEffort
	 *            the actualEffort to set
	 */
	public void setActualEffort(String actualEffort)
	{
		this.actualEffort = actualEffort;
	}
	
	/**
	 * @return the result
	 */
	public String getResult()
	{
		return result;
	}
	
	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result)
	{
		this.result = result;
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
	public String getOverTime()
	{
		return overTime;
	}
	
	/**
	 * @param overTime
	 *            the overTime to set
	 */
	public void setOverTime(String overTime)
	{
		this.overTime = overTime;
	}
	
	/**
	 * @return the timesheetId
	 */
	public Long getTimesheetId()
	{
		return timesheetId;
	}
	
	/**
	 * @param timesheetId
	 *            the timesheetId to set
	 */
	public void setTimesheetId(Long timesheetId)
	{
		this.timesheetId = timesheetId;
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
	
	public String getInTimeDayOfWeek()
	{
		return inTimeDayOfWeek;
	}
	
	public void setInTimeDayOfWeek(String inTimeDayOfWeek)
	{
		this.inTimeDayOfWeek = inTimeDayOfWeek;
	}
	
	public String getOutTimeDayOfWeek()
	{
		return outTimeDayOfWeek;
	}
	
	public void setOutTimeDayOfWeek(String outTimeDayOfWeek)
	{
		this.outTimeDayOfWeek = outTimeDayOfWeek;
	}
	
	/**
	 * @return the holidayDesc
	 */
	public String getHolidayDesc()
	{
		return holidayDesc;
	}
	
	/**
	 * @param holidayDesc
	 *            the holidayDesc to set
	 */
	public void setHolidayDesc(String holidayDesc)
	{
		this.holidayDesc = holidayDesc;
	}
	
	/**
	 * @return the holiday
	 */
	public boolean isHoliday()
	{
		return holiday;
	}
	
	/**
	 * @param holiday
	 *            the holiday to set
	 */
	public void setHoliday(boolean holiday)
	{
		this.holiday = holiday;
	}
	
	/**
	 * @return the weeklyOff
	 */
	public boolean isWeeklyOff()
	{
		return weeklyOff;
	}
	
	/**
	 * @param weeklyOff
	 *            the weeklyOff to set
	 */
	public void setWeeklyOff(boolean weeklyOff)
	{
		this.weeklyOff = weeklyOff;
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
	 * @return the regularEffort
	 */
	public String getRegularEffort()
	{
		return regularEffort;
	}
	
	/**
	 * @param regularEffort
	 *            the regularEffort to set
	 */
	public void setRegularEffort(String regularEffort)
	{
		this.regularEffort = regularEffort;
	}
	
	/**
	 * @return the leave
	 */
	public String getLeave()
	{
		return leave;
	}
	
	/**
	 * @param leave
	 *            the leave to set
	 */
	public void setLeave(String leave)
	{
		this.leave = leave;
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
	 * @return the createdDate
	 */
	public String getCreatedDate()
	{
		return createdDate;
	}
	
	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
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
	 * @return the designation
	 */
	public String getDesignation()
	{
		return designation;
	}
	
	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTimezone()
	{
		return timeZone;
	}
	
	/**
	 * 
	 * @param timezone
	 */
	public void setTimezone(String timezone)
	{
		this.timeZone = timezone;
	}
	
	public long getNoOfReports()
	{
		return noOfReports;
	}
	
	public void setNoOfReports(long noOfReports)
	{
		this.noOfReports = noOfReports;
	}
	
}
