package com.adviteya.service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.util.DateUtil;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.MobileAuditTrailDTO;
import com.adviteya.model.MA_MobileTransmissionData;
import com.adviteya.persistence.MobileDataDAO;
import com.google.appengine.api.datastore.Key;

/**
 * @author prashant
 * 
 */
public class MobileRequestService implements IMobileAttendanceConstants
{
	
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getLogger(MobileRequestService.class
	                              .getName());
	
	/**
	 * @param mobileTransData
	 */
	public Key addMobileTransmmissionData(
	        MA_MobileTransmissionData mobileTransData)
	{
		MobileDataDAO mobiletransData = MobileDataDAO.newInstance();
		
		Key k = mobiletransData.addMobileData(mobileTransData);
		
		return k;
	}
	
	/**
	 * @param companyId
	 * @param startDate
	 * @return
	 */
	public List<MobileAuditTrailDTO> populateMobileAuditTrailReport(
	        Long companyId, String startDate, String offset)
	{
		// TODO Auto-generated method stub
		
		Date _startDate = DateUtil.toDate(startDate, "MM/dd/yyyy");
		// long _time = _startDate.getTime()
		// - (Long.parseLong(offset) * 60000);
		// _startDate.setTime(_time);
		
		Calendar c = Calendar.getInstance();
		c.setTime(_startDate);
		
		List<MA_MobileTransmissionData> mobiledatalist = MobileDataDAO
		        .getMobileTransmissionData(companyId, _startDate);
		List<MobileAuditTrailDTO> mobileAuditTrailList = new ArrayList<MobileAuditTrailDTO>();
		logger.log(Level.INFO, "offset" + Long.parseLong(offset));
		Iterator<MA_MobileTransmissionData> itr = mobiledatalist.iterator();
		while (itr.hasNext())
		{
			MobileAuditTrailDTO mobileAuditTrailDTO = new MobileAuditTrailDTO();
			
			MA_MobileTransmissionData mobileData = itr.next();
			String companyEmployeeId = "-";
			String userName = "-";
			String isActive = "-";
			String isSuperwisor = "-";
			if (mobileData.getEmployeeRef() != null)
			{
				companyEmployeeId = mobileData.getEmployeeRef().getModel()
				        .getCompanyEmpId();
				userName = mobileData.getEmployeeRef().getModel()
				        .getFirstName()
				        + " "
				        + mobileData.getEmployeeRef().getModel().getLastName();
				isActive = mobileData.getEmployeeRef().getModel().getActive();
				isSuperwisor = mobileData.getEmployeeRef().getModel()
				        .getIsSuperwiser();
			}
			String action = mobileData.getAction();
			String state = mobileData.getState();
			String status = mobileData.getStatus();
			if (state.equalsIgnoreCase("01-OPEN"))
			{
				state = OPEN;
			} else if (state.equalsIgnoreCase("02-AUTHN"))
			{
				state = STATE_AUTHENTICATING;
			} else if (state.equalsIgnoreCase("03-AU-SC"))
			{
				state = STATE_AUTH_SUCCESS;
			} else if (state.equalsIgnoreCase("03-AU-FL"))
			{
				state = STATE_AUTH_FAIL;
			} else if (state.equalsIgnoreCase("02-SYNCH"))
			{
				state = STATE_SYNCH_DATA;
			} else if (state.equalsIgnoreCase("03-SY-SC"))
			{
				state = STATE_SYNCH_SUCCESS;
			} else if (state.equalsIgnoreCase("03-SY-FL"))
			{
				state = STATE_SYNCH_FAIL;
			} else
			{
				state = "-";
			}
			
			if (status.equalsIgnoreCase("01-OPEN"))
			{
				status = OPEN;
			} else if (status.equalsIgnoreCase("02-INPRG"))
			{
				status = STATUS_IN_PROGRESS;
			} else if (status.equalsIgnoreCase("03-CMPLT"))
			{
				status = STATUS_COMPLETE;
			} else if (status.equalsIgnoreCase("03-ERROR"))
			{
				status = STATUS_ERROR;
			} else
			{
				status = "-";
			}
			if (action.equalsIgnoreCase("IMEI_VALIDATE_MOBILE_SUPERVISOR"))
			{
				action = "USER AUTHENTICATION";
			} else if (action.equalsIgnoreCase("IMEI_SYNCH_SERVER_DATA"))
			{
				action = "SYNCHRONIZE TIMESHEET";
			}
			
			Date createdDate = mobileData.getCreatedDate();
			
			long time = createdDate.getTime()
			        - (Long.parseLong(offset) * 60000);
			
			createdDate.setTime(time);
			mobileAuditTrailDTO.setCreatedTime(time);
			mobileAuditTrailDTO.setState(state);
			mobileAuditTrailDTO.setStatus(status);
			mobileAuditTrailDTO.setAction(action);
			mobileAuditTrailDTO.setImeiCode(mobileData.getImeiCode());
			mobileAuditTrailDTO.setEmpCompanyEmpId(companyEmployeeId);
			mobileAuditTrailDTO.setAttendanceCoordinates(mobileData
			        .getAttendanceCoordinates().toString());
			mobileAuditTrailDTO.setResponseTime(new Long(mobileData
			        .getResponseTime()).toString());
			mobileAuditTrailDTO.setCreatedDate(DateFormat.getInstance().format(
			        createdDate));
			mobileAuditTrailDTO.setUserName(userName);
			
			if (null != isActive)
			{
				mobileAuditTrailDTO.setUserStatus(isActive);
			} else
			{
				/*
				 * as in employee list previously present code;
				 * mobileAuditTrailDTO.setUserStatus("Y");
				 */
				mobileAuditTrailDTO.setUserStatus("N");
			}
			mobileAuditTrailDTO.setIsSuperwiser(isSuperwisor);
			mobileAuditTrailDTO.setKey(mobileData.getKey().getId());
			mobileAuditTrailDTO.setRecordsReceived(mobileData
			        .getRecordsReceived());
			mobileAuditTrailDTO.setRecordsSend(mobileData.getRecordsSend());
			
			mobileAuditTrailList.add(mobileAuditTrailDTO);
			
		}
		
		return mobileAuditTrailList;
	}
}