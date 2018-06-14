package com.adviteya.dto;

public class WeeklyRecordDTO
{
	
	private String startDate;
	private String endDate;
	private String activeDownloadReport;
	private String weekNo;
	private long   noOfRecords;
	private String monthName;
	private long   startTime;
	
	public String getStartDate()
	{
		return startDate;
	}
	
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	
	public String getEndDate()
	{
		return endDate;
	}
	
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
	
	public String getActiveDownloadReport()
	{
		return activeDownloadReport;
	}
	
	public void setActiveDownloadReport(String activeDownloadReport)
	{
		this.activeDownloadReport = activeDownloadReport;
	}
	
	public String getWeekNo()
	{
		return weekNo;
	}
	
	public void setWeekNo(String weekNo)
	{
		this.weekNo = weekNo;
	}
	
	public long getNoOfRecords()
	{
		return noOfRecords;
	}
	
	public void setNoOfRecords(long noOfRecords)
	{
		this.noOfRecords = noOfRecords;
	}
	
	public String getMonthName()
	{
		return monthName;
	}
	
	public void setMonthName(String monthName)
	{
		this.monthName = monthName;
	}
	
	public long getStartTime()
	{
		return startTime;
	}
	
	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}
	
}
