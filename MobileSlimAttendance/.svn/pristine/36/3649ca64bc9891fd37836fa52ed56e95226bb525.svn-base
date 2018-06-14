/**
 * 
 */
package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

/**
 * @author Dheeraj
 * 
 */
@Model(schemaVersion = 3)
public class MA_Shift extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long     serialVersionUID = 6063402954407645735L;
	// Use only the time part - ignore the date
	// private String startTime;
	// Use only the time part - ignore the date
	// private String endTime;
	private String                active;
	private String                shiftName;
	
	private int                   startHrs;
	private int                   startMin;
	private int                   endHrs;
	private int                   endMin;
	private ModelRef<MA_Location> locationRef      = new ModelRef<MA_Location>(
	                                                       MA_Location.class);
	
	private ModelRef<MA_User>     userRef          = new ModelRef<MA_User>(
	                                                       MA_User.class);
	
	private int                   startGMTHrs;
	private int                   startGMTMin;
	private int                   endGMTHrs;
	private int                   endGMTMin;
	/**
	 * @return the locationRef
	 */
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}
	
	/**
	 * @return the userRef
	 */
	public ModelRef<MA_User> getUserRef()
	{
		return userRef;
	}
	
	/**
	 * @return the startTime
	 */
	// public String getStartTime() {
	// return startTime;
	// }
	
	/**
	 * @param startTime
	 *            the startTime to set
	 */
	// public void setStartTime(String startTime) {
	// this.startTime = startTime;
	// }
	
	/**
	 * @return the endTime
	 */
	// public String getEndTime() {
	// return endTime;
	// }
	
	/**
	 * @param endTime
	 *            the endTime to set
	 */
	// public void setEndTime(String endTime) {
	// this.endTime = endTime;
	// }
	
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
	 * @return the startHrs
	 */
	public int getStartHrs()
	{
		return startHrs;
	}
	
	/**
	 * @param startHrs
	 *            the startHrs to set
	 */
	public void setStartHrs(int startHrs)
	{
		this.startHrs = startHrs;
	}
	
	/**
	 * @return the startMin
	 */
	public int getStartMin()
	{
		return startMin;
	}
	
	/**
	 * @param startMin
	 *            the startMin to set
	 */
	public void setStartMin(int startMin)
	{
		this.startMin = startMin;
	}
	
	/**
	 * @return the endHrs
	 */
	public int getEndHrs()
	{
		return endHrs;
	}
	
	/**
	 * @param endHrs
	 *            the endHrs to set
	 */
	public void setEndHrs(int endHrs)
	{
		this.endHrs = endHrs;
	}
	
	/**
	 * @return the endMin
	 */
	public int getEndMin()
	{
		return endMin;
	}
	
	/**
	 * @param endMin
	 *            the endMin to set
	 */
	public void setEndMin(int endMin)
	{
		this.endMin = endMin;
	}

	public int getStartGMTHrs()
    {
	    return startGMTHrs;
    }

	public void setStartGMTHrs(int startGMTHrs)
    {
	    this.startGMTHrs = startGMTHrs;
    }

	public int getStartGMTMin()
    {
	    return startGMTMin;
    }

	public void setStartGMTMin(int startGMTMin)
    {
	    this.startGMTMin = startGMTMin;
    }

	public int getEndGMTHrs()
    {
	    return endGMTHrs;
    }

	public void setEndGMTHrs(int endGMTHrs)
    {
	    this.endGMTHrs = endGMTHrs;
    }

	public int getEndGMTMin()
    {
	    return endGMTMin;
    }

	public void setEndGMTMin(int endGMTMin)
    {
	    this.endGMTMin = endGMTMin;
    }
	
}
