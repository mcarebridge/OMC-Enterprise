/**
 * 
 */
package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Text;

/**
 * @author developer1
 * 
 */
@Model(schemaVersion = 1)
public class MA_MobileTransmissionData extends AbstractEntity
{
	
	/**
     * 
     */
	
	private static final long     serialVersionUID = 3847829299619641721L;
	private ModelRef<MA_Company>  companyRef       = new ModelRef<MA_Company>(
	                                                       MA_Company.class);
	private ModelRef<MA_Employee> employeeRef      = new ModelRef<MA_Employee>(
	                                                       MA_Employee.class);
	
	private String                imeiCode;
	private GeoPt                 attendanceCoordinates;
	private Double                geoPtAccuracy;
	private Text                  requestData;
	private Text                  responseData;
	private long                  responseTime;
	private String                state;
	private String                status;
	private String                action;
	private int                   recordsReceived;
	private int                   recordsSend;
	private String                logError;
	private int                   createDay;
	private int                   createMonth;
	private int                   createYear;
	
	/**
	 * @return
	 */
	public long getResponseTime()
	{
		return responseTime;
	}
	
	/**
	 * @param responseTime
	 */
	public void setResponseTime(long responseTime)
	{
		this.responseTime = responseTime;
	}
	
	/**
	 * @return
	 */
	public String getState()
	{
		return state;
	}
	
	/**
	 * @param state
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	
	/**
	 * @return
	 */
	public String getStatus()
	{
		return status;
	}
	
	/**
	 * @param status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	/**
	 * @return
	 */
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	/**
	 * @return
	 */
	public ModelRef<MA_Employee> getEmployeeRef()
	{
		return employeeRef;
	}
	
	/**
	 * @return
	 */
	public String getImeiCode()
	{
		return imeiCode;
	}
	
	/**
	 * @param imeiCode
	 */
	public void setImeiCode(String imeiCode)
	{
		this.imeiCode = imeiCode;
	}
	
	/**
	 * @return
	 */
	public GeoPt getAttendanceCoordinates()
	{
		return attendanceCoordinates;
	}
	
	/**
	 * @param attendanceCoordinates
	 */
	public void setAttendanceCoordinates(GeoPt attendanceCoordinates)
	{
		this.attendanceCoordinates = attendanceCoordinates;
	}
	
	/**
	 * @return
	 */
	public Double getGeoPtAccuracy()
	{
		return geoPtAccuracy;
	}
	
	/**
	 * @param geoPtAccuracy
	 */
	public void setGeoPtAccuracy(Double geoPtAccuracy)
	{
		this.geoPtAccuracy = geoPtAccuracy;
	}
	
	/**
	 * @return
	 */
	public Text getRequestData()
	{
		return requestData;
	}
	
	/**
	 * @param requestData
	 */
	public void setRequestData(Text requestData)
	{
		this.requestData = requestData;
	}
	
	/**
	 * @return
	 */
	public Text getResponseData()
	{
		return responseData;
	}
	
	/**
	 * @param responseData
	 */
	public void setResponseData(Text responseData)
	{
		this.responseData = responseData;
	}
	
	/**
	 * @return
	 */
	public String getAction()
	{
		return action;
	}
	
	/**
	 * @param action
	 */
	public void setAction(String action)
	{
		this.action = action;
	}
	
	/**
	 * @return
	 */
	public int getRecordsReceived()
	{
		return recordsReceived;
	}
	
	/**
	 * @param recordsReceived
	 */
	public void setRecordsReceived(int recordsReceived)
	{
		this.recordsReceived = recordsReceived;
	}
	
	/**
	 * @return
	 */
	public int getRecordsSend()
	{
		return recordsSend;
	}
	
	/**
	 * @param recordsSend
	 */
	public void setRecordsSend(int recordsSend)
	{
		this.recordsSend = recordsSend;
	}
	
	/**
	 * @return
	 */
	public String getLogError()
	{
		return logError;
	}
	
	/**
	 * @param systemError
	 */
	public void setLogError(String logError)
	{
		this.logError = logError;
	}
	
	/**
	 * @return
	 */
	public int getCreateDay()
	{
		return createDay;
	}
	
	/**
	 * @param createdDay
	 */
	public void setCreateDay(int createDay)
	{
		this.createDay = createDay;
	}
	
	/**
	 * @return
	 */
	public int getCreateMonth()
	{
		return createMonth;
	}
	
	/**
	 * @param createdMonth
	 */
	public void setCreateMonth(int createMonth)
	{
		this.createMonth = createMonth;
	}
	
	/**
	 * @return
	 */
	public int getCreateYear()
	{
		return createYear;
	}
	
	/**
	 * @param createdYear
	 */
	public void setCreateYear(int createYear)
	{
		this.createYear = createYear;
	}
}
