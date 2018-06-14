package com.adviteya.controller.humancapital;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.service.PayRollBusinessService;

public class PayrollAsyncProcessorController extends BaseController
{
	private static final Logger logger = Logger.getLogger(PayrollAsyncProcessorController.class
	                                           .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		String _companyId = requestScope("COMPANYID");
		
		PayRollBusinessService businessService = new PayRollBusinessService();
		String formDate = requestScope("STARTDATE");
		String endDate = requestScope("ENDDATE");
		
		logger.log(Level.INFO, "-- Running QueueController --");
		logger.log(Level.INFO, "-- Running for Company Id = " + _companyId);
		logger.log(Level.INFO, "-- Running for Start Date = " + formDate);
		logger.log(Level.INFO, "-- Running for End Date = " + endDate);
		
		SimpleDateFormat _sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		Date _fromDate = _sdf.parse(formDate);
		Date _endDate = _sdf.parse(endDate);
		
		businessService.storePayrollReport(Long.parseLong(_companyId),
		        _fromDate, _endDate);
		
		return null;
		
	}
}
