package com.adviteya.controller.humancapital;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.model.MA_Alert;
import com.adviteya.service.AlertService;
import com.adviteya.service.CronJobService;
import com.adviteya.service.OMCEmailCommunicatonService;

public class OMCEmailCommunicatorController extends BatchJobBaseController
{
	private static Logger logger = Logger.getLogger(OMCEmailCommunicatorController.class
	                                     .getName());
	
	@Override
	public Navigation executeLogic()
	{
		logger.log(Level.INFO, " In OMCEmailCommunicatorController ");
		// TODO Auto-generated method stub
		String alertId = requestScope("alertId");
		String server = request.getServerName();
		OMCEmailCommunicatonService _service = OMCEmailCommunicatonService
		        .getInstance();
		AlertService alertService = new AlertService();
		
		MA_Alert alert = AlertService.loadAlert(Long.parseLong(alertId));
		
		if (alert != null)
		{
			logger.log(Level.INFO, " Alert Id= "+alert.getKey().getId());
			boolean isValidAlert = alertService.isValidAlert(alert);
			
			if (isValidAlert)
			{
				logger.log(Level.INFO, "Current Alert Is Valid ");
				_service.transmitShiftAlert(alert, server);
			}
		}
		return null;
	}
}
