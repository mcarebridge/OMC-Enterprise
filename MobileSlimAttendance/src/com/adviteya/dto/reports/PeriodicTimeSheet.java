package com.adviteya.dto.reports;

import java.util.List;

public class PeriodicTimeSheet
{
	
	Long               employeeId;
	String             employeeName;
	List<TimeSheetDTO> timsheetList;
	
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
	 * @return the timsheetList
	 */
	public List<TimeSheetDTO> getTimsheetList()
	{
		return timsheetList;
	}
	
	/**
	 * @param timsheetList
	 *            the timsheetList to set
	 */
	public void setTimsheetList(List<TimeSheetDTO> timsheetList)
	{
		this.timsheetList = timsheetList;
	}
	
}
