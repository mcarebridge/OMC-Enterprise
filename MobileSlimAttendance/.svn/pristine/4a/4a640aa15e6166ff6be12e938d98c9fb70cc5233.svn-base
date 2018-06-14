package com.adviteya.controller.humancapital;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.service.EntityService;
import com.adviteya.service.TimeSheetBusinessService;
import com.google.appengine.api.datastore.Key;

public class TimesheetIndexController extends BaseController
{
	
	private static Logger logger  = Logger.getLogger(TimesheetIndexController.class
	                                      .getName());
	
	private EntityService service = EntityService.getInstance();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		try
		{
			String action = requestScope("actionParam");
			String selectedLocation = requestScope("selectedLocation");
			String selectedShift = requestScope("selectedShift");
			Date _startDate = null;
			Date _toDate = null;
			String yearSelected = (String) requestScope("yearSelected");
			String monthSelected = (String) requestScope("monthSelected");
			
			Long companyId = sessionScope("companyId");
			logger.log(Level.INFO, companyId.toString());
			
			if (yearSelected != null && monthSelected != null)
			{
				int iyearSelected = Integer
				        .parseInt((String) requestScope("yearSelected"));
				int imonthSelected = Integer
				        .parseInt((String) requestScope("monthSelected"));
				Calendar _monthCal = Calendar.getInstance();
				_monthCal.set(iyearSelected, imonthSelected, 1);
				_startDate = _monthCal.getTime();
				_monthCal.set(Calendar.DATE,
				        _monthCal.getMaximum(Calendar.DATE));
				// _monthCal.set(Calendar.DATE, 4);
				_toDate = _monthCal.getTime();
			}
			
			MA_Company company = new MA_Company();
			Key k = Datastore.createKey(MA_Company.class, companyId);
			company.setKey(k);
			
			// if(action.equals("initialLoad")) {
			if (action == null)
			{
				List<MA_Location> locationList = service
				        .getAllLocationForCompany(companyId);
				sessionScope("locationList", locationList);
			} else
			{
				if (action.equalsIgnoreCase("loadShiftForLocation"))
				{
					if (selectedLocation != null)
					{
						
						List<MA_Shift> shiftList = service
						        .getAllShifForLocation(Long
						                .valueOf(selectedLocation.trim()));
						requestScope("shiftList", shiftList);
					}
				} else if (action.equalsIgnoreCase("loadTimeData"))
				{
					if (selectedLocation != null && selectedShift != null)
					{
						
						Long _locationKey = Long.parseLong(selectedLocation);
						Long _shiftKey = Long.parseLong(selectedShift);
						
						MA_Location _location = new MA_Location();
						Key _lKey = Datastore.createKey(MA_Location.class,
						        _locationKey);
						_location.setKey(_lKey);
						
						MA_Shift _shift = new MA_Shift();
						Key _sKey = Datastore.createKey(MA_Shift.class,
						        _shiftKey);
						_shift.setKey(_sKey);
						
						TimeSheetBusinessService tbs = new TimeSheetBusinessService();
						TreeMap<Calendar, MA_Company> dailyAttendanceRecord = null;/*
																				    * tbs
																				    * .
																				    * getMonthlyTimesheetForCompanyByEmplyoee
																				    * (
																				    * company
																				    * ,
																				    * _startDate
																				    * ,
																				    * _toDate
																				    * ,
																				    * _location
																				    * ,
																				    * _shift
																				    * ,
																				    * MobileServiceConstants
																				    * .
																				    * DAILY_CONSOLIDATED
																				    * )
																				    * ;
																				    */
						List<MA_Shift> shiftList = service
						        .getAllShifForLocation(Long
						                .valueOf(selectedLocation.trim()));
						requestScope("shiftList", shiftList);
						
						requestScope("dailyAttendanceRecord",
						        dailyAttendanceRecord);
					}
				}
			}
			
			requestScope("monthSelected", monthSelected);
			requestScope("yearSelected", yearSelected);
			
		} catch (Exception ex)
		{
			throw ex;
		}
		
		return forward("timesheet.jsp");
	}
}
