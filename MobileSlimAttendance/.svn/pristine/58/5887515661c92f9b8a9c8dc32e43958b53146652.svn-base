/**
 * 
 */
package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Text;

/**
 * @author deejay
 * 
 */
@Model(schemaVersion = 1)
public class MA_WeeklyEffortReport extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long    serialVersionUID = 7330054921482566497L;
	
	private ModelRef<MA_Company> companyRef       = new ModelRef<MA_Company>(
	                                                      MA_Company.class);
	private Date                 weekStartDate;
	private Date                 weekEndDate;
	private Text                 weeklyReport;
	private int                  weekNo;
	private long                 noOfRecords;
	
	/**
	 * 
	 * @return
	 */
	public int getWeekNo()
	{
		return weekNo;
	}
	
	/**
	 * 
	 * @param weekNo
	 */
	public void setWeekNo(int weekNo)
	{
		this.weekNo = weekNo;
	}
	
	/**
	 * @return the weekStartDate
	 */
	public Date getWeekStartDate()
	{
		return weekStartDate;
	}
	
	/**
	 * @param weekStartDate
	 *            the weekStartDate to set
	 */
	public void setWeekStartDate(Date weekStartDate)
	{
		this.weekStartDate = weekStartDate;
	}
	
	/**
	 * @return the weekEndDate
	 */
	public Date getWeekEndDate()
	{
		return weekEndDate;
	}
	
	/**
	 * @param weekEndDate
	 *            the weekEndDate to set
	 */
	public void setWeekEndDate(Date weekEndDate)
	{
		this.weekEndDate = weekEndDate;
	}
	
	/**
	 * @return the weeklyReport
	 */
	public Text getWeeklyReport()
	{
		return weeklyReport;
	}
	
	/**
	 * @param weeklyReport
	 *            the weeklyReport to set
	 */
	public void setWeeklyReport(Text weeklyReport)
	{
		this.weeklyReport = weeklyReport;
	}
	
	/**
	 * @return the companyRef
	 */
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
