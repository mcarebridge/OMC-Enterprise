/**
 * 
 */
package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.adviteya.model.MA_Company;
import com.adviteya.service.CronJobService;
import com.adviteya.service.EntityService;
import com.google.appengine.api.datastore.Key;

/**
 * @author deejay
 * 
 */
public class ProcessAttendanceDataController extends BatchJobBaseController
{
	
	/**
     * 
     */
	
	private static final Logger logger = Logger.getLogger(ProcessAttendanceDataController.class
	                                           .getName());
	
	public ProcessAttendanceDataController()
	{
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adviteya.controller.humancapital.BaseController#executeLogic()
	 */
	@Override
	public Navigation executeLogic()
	{
		String _companyId = requestScope("companyId");
		logger.log(Level.INFO, "-- Running ProcessAttendanceDataController --");
		logger.log(Level.INFO, "-- Running for Company Id = " + _companyId);
		
		EntityService _es = EntityService.getInstance();
		Key _companyKey = Datastore.createKey(MA_Company.class,
		        Long.parseLong(_companyId));
		MA_Company ma_Company = _es.getCompanyObj(_companyKey);
		
		CronJobService _cronJobService = CronJobService.getInstance();
		_cronJobService.executeTimeSheetJobSequence(ma_Company);
		return null;
	}
}
