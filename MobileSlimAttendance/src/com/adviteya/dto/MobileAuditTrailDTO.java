package com.adviteya.dto;

/**
 * @author prashant
 * 
 */
public class MobileAuditTrailDTO implements Comparable<MobileAuditTrailDTO>
{
	
	private long   key;
	private String action;
	private String status;
	private String state;
	private String imeiCode;
	private String empCompanyEmpId;
	private String attendanceCoordinates;
	private String responseTime;
	private String createdDate;
	private String userName;
	private String userStatus;
	private String isSuperwiser;
	private int    recordsReceived;
	private int    recordsSend;
	private String timeZone;
	private long   createdTime;
	
	public String getAttendanceCoordinates()
	{
		return attendanceCoordinates;
	}
	
	public void setAttendanceCoordinates(String attendanceCoordinates)
	{
		this.attendanceCoordinates = attendanceCoordinates;
	}
	
	public String getResponseTime()
	{
		return responseTime;
	}
	
	public void setResponseTime(String responseTime)
	{
		this.responseTime = responseTime;
	}
	
	public String getCreatedDate()
	{
		return createdDate;
	}
	
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}
	
	public String getAction()
	{
		return action;
	}
	
	public void setAction(String action)
	{
		this.action = action;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String getImeiCode()
	{
		return imeiCode;
	}
	
	public void setImeiCode(String imeiCode)
	{
		this.imeiCode = imeiCode;
	}
	
	public String getEmpCompanyEmpId()
	{
		return empCompanyEmpId;
	}
	
	public void setEmpCompanyEmpId(String empCompanyEmpId)
	{
		this.empCompanyEmpId = empCompanyEmpId;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getUserStatus()
	{
		return userStatus;
	}
	
	public void setUserStatus(String userStatus)
	{
		this.userStatus = userStatus;
	}
	
	public String getIsSuperwiser()
	{
		return isSuperwiser;
	}
	
	public void setIsSuperwiser(String isSuperwiser)
	{
		this.isSuperwiser = isSuperwiser;
	}
	
	public long getKey()
	{
		return key;
	}
	
	public void setKey(long key)
	{
		this.key = key;
	}
	
	public int getRecordsReceived()
	{
		return recordsReceived;
	}
	
	public void setRecordsReceived(int recordsReceived)
	{
		this.recordsReceived = recordsReceived;
	}
	
	public int getRecordsSend()
	{
		return recordsSend;
	}
	
	public void setRecordsSend(int recordsSend)
	{
		this.recordsSend = recordsSend;
	}
	
	public String getTimeZone()
	{
		return timeZone;
	}
	
	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}
	
	@Override
	public int compareTo(MobileAuditTrailDTO o)
	{
		if (this.createdTime > o.createdTime)
		{
			return 1;
		} else if (this.createdTime < o.createdTime)
		{
			return -1;
		} else
		{
			return 0;
		}
	}
	
	public long getCreatedTime()
	{
		return createdTime;
	}
	
	public void setCreatedTime(long createdTime)
	{
		this.createdTime = createdTime;
	}
	
}
