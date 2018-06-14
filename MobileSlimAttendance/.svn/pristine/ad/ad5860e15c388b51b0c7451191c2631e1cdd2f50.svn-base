package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 3)
public class MA_PayrollReport extends AbstractEntity
{
	/**
     * 
     */
	
	private static final long     serialVersionUID = 3808142184506213222L;
	// @deprecated
	private ModelRef<MA_Company>  companyRef       = new ModelRef<MA_Company>(
	                                                       MA_Company.class);
	private ModelRef<MA_Location> locationRef      = new ModelRef<MA_Location>(
	                                                       MA_Location.class);
	
	private Date                  startDate;
	private Date                  endDate;
	private Text                  Report;
	private int                   intervalNum;
	private long                  noOfRecords;
	private int                   processFreq;
	private int					  monthNo;
	private int					  year;
	
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
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
	
	public Text getReport()
	{
		return Report;
	}
	
	public void setReport(Text report)
	{
		Report = report;
	}
	
	public long getNoOfRecords()
	{
		return noOfRecords;
	}
	
	public void setNoOfRecords(long noOfRecords)
	{
		this.noOfRecords = noOfRecords;
	}
	
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
	public int getProcessFreq()
	{
		return processFreq;
	}
	
	public void setProcessFreq(int processFreq)
	{
		this.processFreq = processFreq;
	}
	
	public int getIntervalNum()
	{
		return intervalNum;
	}
	
	public void setIntervalNum(int intervalNum)
	{
		this.intervalNum = intervalNum;
	}
	
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}

	public int getMonthNo()
    {
	    return monthNo;
    }

	public void setMonthNo(int monthNo)
    {
	    this.monthNo = monthNo;
    }

	public int getYear()
    {
	    return year;
    }

	public void setYear(int year)
    {
	    this.year = year;
    }
}
