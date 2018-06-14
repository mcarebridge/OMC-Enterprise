package com.adviteya.persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.meta.MA_MobileTransmissionDataMeta;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_MobileTransmissionData;
import com.google.appengine.api.datastore.Key;

/**
 * @author prashant
 * 
 */
public class MobileDataDAO
{
	
	private static Logger        logger = Logger.getLogger(MobileDataDAO.class
	                                            .getName());
	
	private static MobileDataDAO mobileDataDAO;
	
	private MobileDataDAO()
	{
	}
	
	/**
	 * @return
	 */
	public static MobileDataDAO newInstance()
	{
		
		if (mobileDataDAO == null)
		{
			
			mobileDataDAO = new MobileDataDAO();
		}
		return mobileDataDAO;
	}
	
	/**
	 * @param mobileData
	 * @return
	 */
	public Key addMobileData(MA_MobileTransmissionData mobileData)
	{
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		Key k = AbstractEntityDAO.addModel(mobileData);
		gtx.commit();
		
		logger.log(Level.INFO, "create mobile data id-" + k.getId());
		return k;
	}
	
	/**
	 * @param companyId
	 * @param startDate
	 * @return
	 */
	public static List<MA_MobileTransmissionData> getMobileTransmissionData(
	        Long companyId, Date _startDate)
	{
		MA_MobileTransmissionDataMeta m = new MA_MobileTransmissionDataMeta();
		
		Key k = Datastore.createKey(MA_Company.class, companyId);
		// Date _endDate=new Date();
		// long time=_startDate.getTime()+(24*60*60*1000);
		// _endDate.setTime(time);
		
		Calendar c = Calendar.getInstance();
		c.setTime(_startDate);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		List<MA_MobileTransmissionData> report_list = Datastore
		        .query(m)
		        .filter(m.companyRef.equal(k), m.createDay.equal(day),
		                m.createMonth.equal(month), m.createYear.equal(year))
		        .asList();
		// List<MA_MobileTransmissionData> report_list = Datastore
		// .query(m)
		// .filter(m.companyRef.equal(k),
		// m.createdDate.greaterThan(_startDate),m.createdDate.lessThanOrEqual(_endDate))
		// .asList();
		
		return report_list;
		
	}
}
