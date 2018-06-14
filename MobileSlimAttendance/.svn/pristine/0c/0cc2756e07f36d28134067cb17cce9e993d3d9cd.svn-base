/**
 * 
 */
package com.adviteya.controller.humancapital;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.adviteya.model.MA_Holiday;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_LocationHoliday;
import com.adviteya.service.EntityService;
import com.adviteya.service.ILocationBusinessService;
import com.adviteya.service.LocationBusinessService;

/**
 * @author Dheeraj
 * 
 */
public class AddHolidayForLocationController extends BaseController
{
	private static Logger logger = Logger.getLogger(AddHolidayForLocationController.class
	                                     .getName());
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adviteya.controller.humancapital.BaseController#executeLogic()
	 */
	@Override
	public Navigation executeLogic() throws Exception
	{
		pageTitle = "title.addHolidaysForLocation";
		pageHeader = "page.addHolidaysForLocation";
		
		Long companyId = sessionScope("companyId");
		String action = requestScope("actionParam");
		String locationId = requestScope("location");
		
		logger.log(Level.INFO, "Company Id=" + companyId);
		logger.log(Level.INFO, "action=" + action);
		logger.log(Level.INFO, "locationId=" + locationId);
		if (action.equalsIgnoreCase("addHolidayForLocation"))
		{
			EntityService _eb = EntityService.getInstance();
			
			List<MA_Location> _countryWideLocations = _eb
			        .getAllLocationForCompany(companyId);
			sessionScope("locationList", _countryWideLocations);
			
		} else if (action.equalsIgnoreCase("loadHolidays"))
		{
			requestScope("locationId", locationId);
			List<MA_Holiday> countryHolidays = loadHolidays(locationId);
			logger.log(Level.INFO,
			        "countryHolidays.size=" + countryHolidays.size());
			requestScope("countryHolidays", countryHolidays);
			
			ILocationBusinessService lb = new LocationBusinessService();
			List<MA_LocationHoliday> locationHolidays = lb
			        .getLocationHolidays(new Long(locationId));
			
			logger.log(Level.INFO,
			        "locationHolidays.size=" + locationHolidays.size());
			requestScope("selectedHolidays",
			        getSelectedHolidayKey(locationHolidays));
			requestScope("locationHolidays", locationHolidays);
			
		} else
		{
			Validators v = new Validators(request);
			
			if (validate(v, action))
			{
				
				if (action.equalsIgnoreCase("createHolidays"))
				{
					
					ILocationBusinessService lb = new LocationBusinessService();
					String[] _holidayId = request
					        .getParameterValues("holidayId");
					lb.addHolidaysForALocation(_holidayId, new Long(locationId));
					List<MA_LocationHoliday> locationHolidayList = lb
					        .getLocationHolidays(new Long(locationId));
					
					requestScope("selectedHolidays",
					        getSelectedHolidayKey(locationHolidayList));
					
					EntityService _es = EntityService.getInstance();
					List<MA_Holiday> countryHolidays = _es
					        .loadBaseHolidaysForLocation(Long
					                .parseLong(locationId));
					
					requestScope("countryHolidays", countryHolidays);
					requestScope("locationHolidays", locationHolidayList);
					requestScope("locationId", locationId);
				} else if (action.equalsIgnoreCase("createLocationHolidays"))
				{
					
					MA_LocationHoliday _locationHoliday = new MA_LocationHoliday();
					String holidayDateStr = request.getParameter("holidayDate");
					SimpleDateFormat _sdf = new SimpleDateFormat("MM/dd/yyyy");
					
					Date _locationHolidayDate = _sdf.parse(holidayDateStr);
					
					_locationHoliday
					        .setLocationHolidayDate(_locationHolidayDate);
					_locationHoliday.setLocationHolidayDesc(request
					        .getParameter("locationSpecificHoliday"));
					createLocationHolidays(locationId, _locationHoliday);
					
					ILocationBusinessService lb = new LocationBusinessService();
					List<MA_LocationHoliday> locationHolidays = lb
					        .getLocationHolidays(new Long(locationId));
					
					EntityService _es = EntityService.getInstance();
					List<MA_Holiday> countryHolidays = _es
					        .loadBaseHolidaysForLocation(Long
					                .parseLong(locationId));
					
					requestScope("countryHolidays", countryHolidays);
					requestScope("selectedHolidays",
					        getSelectedHolidayKey(locationHolidays));
					requestScope("locationHolidays", locationHolidays);
				}
			} else
			{
				showErrBox = true;
			}
		}
		
		return forward("addHolidayForLocation.jsp");
	}
	
	/**
	 * 
	 * @param locationId
	 */
	private void createLocationHolidays(String locationId,
	        MA_LocationHoliday locationHoliday) throws Exception
	{
		ILocationBusinessService lb = new LocationBusinessService();
		lb.createLocationHoliday(new Long(locationId), locationHoliday);
	}
	
	/**
	 * 
	 * @param locationId
	 */
	private List<MA_Holiday> loadHolidays(String locationId)
	{
		logger.log(Level.INFO, "Start loadHolidays");
		EntityService _es = EntityService.getInstance();
		List<MA_Holiday> countryHolidays = _es.loadBaseHolidaysForLocation(Long
		        .parseLong(locationId));
		logger.log(Level.INFO, "End loadHolidays");
		return countryHolidays;
	}
	
	/**
	 * The method return comma seperated String of Keys. This is used to show
	 * checkbox selected
	 * 
	 * @param locationHolidays
	 * @return
	 */
	private String getSelectedHolidayKey(
	        List<MA_LocationHoliday> locationHolidays)
	{
		logger.log(Level.INFO, "Start getSelectedHolidayKey");
		
		String selectedHolidays = "";
		
		for (Iterator iterator = locationHolidays.iterator(); iterator
		        .hasNext();)
		{
			MA_LocationHoliday ma_LocationHoliday = (MA_LocationHoliday) iterator
			        .next();
			if (ma_LocationHoliday.getLocationHolidayDesc() == null)
			{
				selectedHolidays += ma_LocationHoliday.getHolidayRef()
				        .getModel().getKey().getId()
				        + ",";
			}
			
		}
		logger.log(Level.INFO, "End getSelectedHolidayKey  selectedHolidays = "
		        + selectedHolidays);
		return selectedHolidays;
	}
	
	private boolean validate(final Validators v, String action)
	{
		
		String locationId = request.getParameter("location");
		if (null == locationId || locationId.equals(""))
		{
			v.getErrors().put("locationId.required",
			        "Please select a location.");
		}
		
		if (action.equalsIgnoreCase("createHolidays"))
		{
			String[] holidayId = request.getParameterValues("holidayId");
			if (null == holidayId || holidayId.length == 0)
			{
				v.getErrors().put("holiday.required",
				        "Please select atleast one Holiday.");
			}
		}
		if (action.equalsIgnoreCase("createLocationHolidays"))
		{
			v.add("holidayDate", v.required());
			v.add("locationSpecificHoliday", v.required());
			
		}
		
		boolean valid = v.validate();
		requestScope("errorSize", new Integer(v.getErrors().size()));
		if (v.getErrors().size() > 0)
		{
			logger.log(Level.INFO, "Error size=" + v.getErrors().size());
			return false;
			
		}
		return valid;
	}
	
}
