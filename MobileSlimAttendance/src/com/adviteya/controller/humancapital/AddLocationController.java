package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.LocationDTO;
import com.adviteya.dto.TimeZoneDTO;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_State;
import com.adviteya.service.EntityService;
import com.adviteya.service.LocationBusinessService;
import com.adviteya.util.ServiceUtil;

public class AddLocationController extends BaseController implements
        IMobileAttendanceConstants
{
	
	private static Logger           logger          = Logger.getLogger(AddShiftController.class
	                                                        .getName());
	private EntityService           service         = EntityService
	                                                        .getInstance();
	private LocationBusinessService businessService = new LocationBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		/**
		 * Logger.
		 */
		pageTitle = "title.addLocation";
		pageHeader = "page.addLocation";
		String action = requestScope("actionParam");
		Long companyId = sessionScope("companyId");
		requestScope("companyId", companyId);
		if (null == sessionScope("countryList"))
		{
			List<MA_Country> countryList = service.getCounrtyList();
			sessionScope("countryList", countryList);
		}
		if (null == sessionScope("timeZoneList"))
		{
			ServiceUtil serviceUtil = new ServiceUtil();
			List<TimeZoneDTO> timeZoneDTOs = serviceUtil.getTimeZoneList();
			sessionScope("timeZoneList", timeZoneDTOs);
		}
		requestScope("stateList", new ArrayList());
		if (action != null && action.equals("addLocation"))
		{
			Validators v = new Validators(request);
			if (validate(v))
			{
				int counter = sessionScope("counter");
				
				if (counter == Integer
				        .parseInt((String) requestScope("counter")))
				{
					counter++;
					sessionScope("counter", counter);
					String status = businessService
					        .createLocation(new RequestMap(request));
					requestScope("initialLoad", "true");
				}
			} else
			{
				String state = requestScope("state");
				if (null != state && !state.equals(""))
				{
					String country = requestScope("country");
					List<MA_State> stateList = service
					        .getAllStateForCountry(country);
					requestScope("stateList", stateList);
				}
				showErrBox = true;
			}
			
		} else
		{
			sessionScope("counter", 0);
			requestScope("initialLoad", "true");
		}
		List<LocationDTO> locationDTOs = businessService
		        .getLocationListForCompany(companyId);
		requestScope("locationList", locationDTOs);
		
		return forward("addLocation.jsp");
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		v.add("locationName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("line1", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("city", v.required());
		v.add("country", v.required());
		v.add("state", v.required());
		v.add("pinCode", v.required(), v.integerType());
		v.add("timezone", v.required());
		v.add("latitude", v.required(), v.floatType("Invalid Latitude."));
		v.add("longitude", v.required(), v.floatType("Invalid Longitude."));
		String latitude = requestScope("latitude");
		String longitude = requestScope("longitude");
		if (null != latitude)
		{
			if (latitude.indexOf(".") == -1
			        || (latitude.indexOf(".") != latitude.lastIndexOf(".") || latitude
			                .lastIndexOf(".") == latitude.length() - 1))
			{
				v.getErrors().put("invalid.latitude", "Invalid Latitude.");
				
			}
			
		}
		if (null != longitude)
		{
			if (longitude.indexOf(".") == -1
			        || (longitude.indexOf(".") != longitude.lastIndexOf(".") || longitude
			                .lastIndexOf(".") == longitude.length() - 1))
			{
				v.getErrors().put("invalid.longitude", "Invalid Longitude.");
				
			}
			
		}
		
		boolean valid = v.validate();
		requestScope("errorSize", new Integer(v.getErrors().size()));
		return valid;
	}
	
}
