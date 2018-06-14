/**
 * 
 */
package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.GeoPt;

/**
 * @author Dheeraj
 * 
 */
@Model(schemaVersion = 4)
public class MA_Timesheet extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long       serialVersionUID = -919208058763345748L;
	
	private ModelRef<MA_Assignment> assignmentRef    = new ModelRef<MA_Assignment>(
	                                                         MA_Assignment.class);
	private ModelRef<MA_Location>   locationRef      = new ModelRef<MA_Location>(
	                                                         MA_Location.class);
	private ModelRef<MA_Shift>      shiftRef         = new ModelRef<MA_Shift>(
	                                                         MA_Shift.class);
	
	private Date                    inDateTime;
	private Date                    outDateTime;
	private String                  inMode;
	private String                  outMode;
	private Double                  dailyEffort;
	private Integer                 createDay;
	private Integer                 createMonth;
	private Integer                 createYear;
	// Marker will have values CURRENT,UPDATED
	private String                  marker;
	@Attribute(persistent = false)
	private String                  secondsToHHMM;
	private Integer                 count;
	private String                  imeiCode;
	// format LONG:XXXXX@LAT@XXXX@ACU:XXXXX
	// The accuracy is in meters
	private GeoPt                   attendanceCoordinates;
	private Double                  geoPtAccuracy;
	
	private GeoPt                   attendanceCoordinatesOut;
	private Double                  geoPtAccuracyOut;
	
	@Attribute(persistent = false)
	private String                  empCompanyId;
	
	/**
	 * @return the assignmentRef
	 */
	public ModelRef<MA_Assignment> getAssignmentRef()
	{
		return assignmentRef;
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
		if (dailyEffort != null)
			setSecondsToHHMM(dailyEffort.toString());
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
	
	public Integer getCount()
	{
		return count;
	}
	
	public void setCount(Integer count)
	{
		this.count = count;
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
			
			int seconds = (int) (time % 60);
			
			/*
			 * int seconds = (int) (time % 60); int minutes = (int) ((time / 60)
			 * % 60); int hours = (int) ((time / 3600) % 24);
			 */
			int hours = (int) (time / 3600);
			int minutes = (int) ((time % 3600) / 60);
			// String secondsStr = (seconds < 10 ? "0" : "") + seconds;
			String minutesStr = (minutes < 10 ? "0" : "") + minutes;
			String hoursStr = (hours < 10 ? "0" : "") + hours;
			secondsToHHMM = (hoursStr + " hr " + " : " + minutesStr + " min ");
		}
		//
		// this.secondsToHHMM = timeString;
	}
	
	public String getImeiCode()
	{
		return imeiCode;
	}
	
	public void setImeiCode(String imeiCode)
	{
		this.imeiCode = imeiCode;
	}
	
	public GeoPt getAttendanceCoordinates()
	{
		return attendanceCoordinates;
	}
	
	public void setAttendanceCoordinates(GeoPt attendanceCoordinates)
	{
		this.attendanceCoordinates = attendanceCoordinates;
	}
	
	public Double getGeoPtAccuracy()
	{
		return geoPtAccuracy;
	}
	
	public void setGeoPtAccuracy(Double geoPtAccuracy)
	{
		this.geoPtAccuracy = geoPtAccuracy;
	}
	
	public GeoPt getAttendanceCoordinatesOut()
	{
		return attendanceCoordinatesOut;
	}
	
	public void setAttendanceCoordinatesOut(GeoPt attendanceCoordinatesOut)
	{
		this.attendanceCoordinatesOut = attendanceCoordinatesOut;
	}
	
	public Double getGeoPtAccuracyOut()
	{
		return geoPtAccuracyOut;
	}
	
	public void setGeoPtAccuracyOut(Double geoPtAccuracyOut)
	{
		this.geoPtAccuracyOut = geoPtAccuracyOut;
	}
	
	public String getEmpCompanyId()
	{
		return empCompanyId;
	}
	
	public void setEmpCompanyId(String empCompanyId)
	{
		this.empCompanyId = empCompanyId;
	}
	
	public String getInMode()
	{
		return inMode;
	}
	
	public void setInMode(String inMode)
	{
		this.inMode = inMode;
	}
	
	public String getOutMode()
	{
		return outMode;
	}
	
	public void setOutMode(String outMode)
	{
		this.outMode = outMode;
	}
}
