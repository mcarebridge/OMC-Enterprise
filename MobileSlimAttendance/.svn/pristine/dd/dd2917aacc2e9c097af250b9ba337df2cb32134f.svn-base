package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 1)
public class MA_WeeklyPayrollReport extends AbstractEntity
{
	/**
     * 
     */
	private static final long    serialVersionUID = -1896632770594752736L;
	private ModelRef<MA_Company> companyRef       = new ModelRef<MA_Company>(
	                                                      MA_Company.class);
	private Date                 weekStartDate;
	private Date                 weekEndDate;
	private Text                 weeklyReport;
	private int                  weekNo;
	private long                 noOfRecords;
	
	public int getWeekNo()
	{
		return weekNo;
	}
	
	public void setWeekNo(int weekNo)
	{
		this.weekNo = weekNo;
	}
	
	public Text getWeeklyReport()
	{
		return weeklyReport;
	}
	
	public void setWeeklyReport(Text weeklyReport)
	{
		this.weeklyReport = weeklyReport;
	}
	
	public Date getWeekEndDate()
	{
		return weekEndDate;
	}
	
	public void setWeekEndDate(Date weekEndDate)
	{
		this.weekEndDate = weekEndDate;
	}
	
	public Date getWeekStartDate()
	{
		return weekStartDate;
	}
	
	public void setWeekStartDate(Date weekStartDate)
	{
		this.weekStartDate = weekStartDate;
	}
	
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	public long getNoOfRecords()
	{
		return noOfRecords;
	}
	
	public void setNoOfRecords(long noOfRecords)
	{
		this.noOfRecords = noOfRecords;
	}
	
}
