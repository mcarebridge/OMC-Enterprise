/**
 * 
 */
package com.adviteya.model;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

/**
 * @author Dheeraj
 * 
 */
@Model(schemaVersion = 2)
public class MA_Assignment extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long       serialVersionUID = 4740707521889540290L;
	private ModelRef<MA_Employee>   employeeRef      = new ModelRef<MA_Employee>(
	                                                         MA_Employee.class);
	private ModelRef<MA_Shift>      shiftRef         = new ModelRef<MA_Shift>(
	                                                         MA_Shift.class);
	
	private ModelRef<MA_Department> deptRef          = new ModelRef<MA_Department>(
	                                                         MA_Department.class);
	
	// Assignment start and End date
	private Date                    startDate;
	private Date                    endDate;
	private int                     status;
	
	@Attribute(persistent = false)
	private List<MA_Timesheet>      timesheets;
	
	/**
	 * @return the employeeRef
	 */
	public ModelRef<MA_Employee> getEmployeeRef()
	{
		return employeeRef;
	}
	
	/**
	 * @return the shiftRef
	 */
	public ModelRef<MA_Shift> getShiftRef()
	{
		return shiftRef;
	}
	
	/**
	 * 
	 * @return
	 */
	public ModelRef<MA_Department> getDeptRef()
	{
		return deptRef;
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
	 * @return the endDate
	 */
	public Date getEndDate()
	{
		return endDate;
	}
	
	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
	
	/**
	 * @return the timesheets
	 */
	public List<MA_Timesheet> getTimesheets()
	{
		return timesheets;
	}
	
	/**
	 * @param timesheets
	 *            the timesheets to set
	 */
	public void setTimesheets(List<MA_Timesheet> timesheets)
	{
		this.timesheets = timesheets;
	}
	
	/**
	 * @return the status
	 */
	public int getStatus()
	{
		return status;
	}
	
	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}
	
}
