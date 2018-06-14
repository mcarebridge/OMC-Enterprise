package com.adviteya.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.tools.ant.types.FlexInteger;

import com.adviteya.dto.ConsolidatedTimeSheetDTO;
import com.adviteya.model.MA_Alert;
import com.adviteya.model.MA_ConsolidatedTimesheet;
import com.adviteya.model.MA_Timesheet;

public class AlertBusinessUtil
{
	private static Logger logger        = Logger.getLogger(AlertBusinessUtil.class
            .getName());
	/**
	 * 
	 * @param alert
	 * @return
	 */
	public static MA_Alert populateAlertResourceStrength(MA_Alert alert)
	{
		/**
		 * For a particular shift find the number total number of employees who
		 * are IN
		 */
		logger.log(Level.INFO, "  Start populateAlertResourceStrength");
		DashboardBusinessService _dbs = new DashboardBusinessService();
		Calendar _c = Calendar.getInstance();
		Map _dashboardMap = _dbs.getShiftDashBoardCount(alert.getShiftRef()
		        .getKey().getId(), _c);
		
		Integer _actualNumOfResourceReported = (Integer) _dashboardMap
		        .get("REPORTED_EMPLOYEE_COUNT");
		
		alert.setActualValues(_actualNumOfResourceReported.intValue());
		
		if (_actualNumOfResourceReported.intValue() < alert
		        .getMinValueForAlert()
		        | _actualNumOfResourceReported.intValue() > alert
		                .getMaxValueForAlert())
		{
			alert.setEscalated(true);
		}
		logger.log(Level.INFO, "  End populateAlertResourceStrength");
		return alert;
	}
	
	/**
	 * Report the percentage of employee who are late
	 * 
	 * @param alert
	 * @return
	 */
	public static MA_Alert populateAlertPuncuality(MA_Alert alert)
	{
		/**
		 * For a particular shift find the number total number of employees who
		 * are LATE-IN
		 */
		logger.log(Level.INFO, "  Start populateAlertPuncuality");
		DashboardBusinessService _dbs = new DashboardBusinessService();
		Calendar _c = Calendar.getInstance();
		Map _dashboardMap = _dbs.getShiftDashBoardCount(alert.getShiftRef()
		        .getKey().getId(), _c);
		
		Integer _actualNumOfResourceReported = (Integer) _dashboardMap
		        .get("LATE_IN_PERCENT");
		Integer _utilizationPercent = (Integer) _dashboardMap
		        .get("UTILIZATION_PERCENT");
		
		if (_actualNumOfResourceReported.intValue() < alert
		        .getMinValueForAlert()
		        | _actualNumOfResourceReported.intValue() > alert
		                .getMaxValueForAlert())
		{
			alert.setEscalated(true);
		}
		
		if (_utilizationPercent == 0)
		{
			alert.setActualValues(100);
			alert.setEscalated(true);
		} else
		{
			alert.setActualValues(_actualNumOfResourceReported.intValue());
		}
		logger.log(Level.INFO, "  End populateAlertPuncuality");
		return alert;
	}
	
	/**
	 * @param _alert
	 * @return
	 */
	public static MA_Alert populateAlertFemaleNotCheckedOut(MA_Alert _alert)
	{
		logger.log(Level.INFO, "  Start populateAlertFemaleNotCheckedOut");
		TimeSheetBusinessService businessService = new TimeSheetBusinessService();
	
		Calendar c = Calendar.getInstance();
//		c.clear();
//		c.set(2013, 0, 21, 00, 00);
		String marker = "NO_OUT_TIME";
		
		List<MA_ConsolidatedTimesheet> consolidatedtimesheetList = businessService
		        .getConsolidatedTimeSheetrByMarker(c, _alert.getShiftRef()
		                .getModel(), marker);
		logger.log(Level.INFO, "Consolidated TimeSheet Size= "+consolidatedtimesheetList.size());
		
		List<MA_ConsolidatedTimesheet> femaleEmployeeTimesheets = businessService
		        .getFemaleEmployeeTimesheet(consolidatedtimesheetList);
		
		logger.log(Level.INFO, "Female Employee Consolidated TimeSheet Size= "+femaleEmployeeTimesheets.size());
		
		if(!femaleEmployeeTimesheets.isEmpty())
		{
			_alert.setActualValues(femaleEmployeeTimesheets.size());
			_alert.setEscalated(true);
		}
		logger.log(Level.INFO, "  End populateAlertFemaleNotCheckedOut");
		return _alert;
	}
	
}
