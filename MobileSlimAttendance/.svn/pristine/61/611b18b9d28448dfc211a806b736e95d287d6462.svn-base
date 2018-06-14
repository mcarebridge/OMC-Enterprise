package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.LocationDTO;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_State;
import com.adviteya.service.EntityService;
import com.adviteya.service.LocationBusinessService;

public class EditLocationController extends BaseController implements
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
		pageTitle = "title.editLocation";
		pageHeader = "page.editLocation";
		
		String action = requestScope("actionParam");
		Long companyId = sessionScope("companyId");
		requestScope("companyId", companyId);
		if (null == sessionScope("countryList"))
		{
			List<MA_Country> countryList = service.getCounrtyList();
			sessionScope("countryList", countryList);
		}
		
		if ("editLocation".equals(action))
		{
			
			String locationIdStr = requestScope("locationId");
			Long locationId = Long.valueOf(locationIdStr);
			LocationDTO locationDTO = businessService
			        .getLocationDetails(locationId);
			
			requestScope("locationId", locationDTO.getLocationId());
			requestScope("locationName", locationDTO.getLocationName());
			requestScope("line1", locationDTO.getLine1());
			requestScope("line2", locationDTO.getLine2());
			requestScope("city", locationDTO.getCity());
			requestScope("state", locationDTO.getState());
			requestScope("pinCode", locationDTO.getPinCode());
			requestScope("active", locationDTO.getStatus());
			requestScope("country", locationDTO.getCountryId());
			requestScope("latitude", locationDTO.getLatitude());
			requestScope("longitude", locationDTO.getLongitude());
			String countryIdStr = "" + locationDTO.getCountryId();
			requestScope("timezone", locationDTO.getTimezone());
			List<MA_State> stateList = service
			        .getAllStateForCountry(countryIdStr.trim());
			requestScope("state", locationDTO.getStateId());
			requestScope("stateList", stateList);
			return forward("editLocation.jsp");
			
		} else
		{
			
			Validators v = new Validators(request);
			if (validate(v))
			{
				String activeStatus = requestScope("active");
				if (activeStatus.equals("N"))
				{
					Long locationId = Long
					        .valueOf((String) requestScope("locationId"));
					int currentAssignmentCount = businessService
					        .getCurrentAssignmentCountofLocation(locationId);
					logger.log(Level.INFO, "No of current assignments="
					        + currentAssignmentCount);
					if (currentAssignmentCount > 0)
					{
						
						v.getErrors()
						        .put("location.current.assignment",
						                "Location status can not be changed as there are current assignment at this location.");
						
						String countryIdStr = (String) requestScope("country");
						List<MA_State> stateList = service
						        .getAllStateForCountry(countryIdStr.trim());
						requestScope("stateList", stateList);
						requestScope("errorSize", new Integer(v.getErrors()
						        .size()));
						
						logger.log(Level.INFO, "No of erros="
						        + v.getErrors().size());
						showErrBox = true;
						return forward("editLocation.jsp");
					} else
					{
						businessService.updateLocation(new RequestMap(request));
						return forward("addLocation");
					}
				} else
				{
					
					businessService.updateLocation(new RequestMap(request));
					return forward("addLocation");
				}
				
			} else
			{
				
				String countryIdStr = (String) requestScope("country");
				List<MA_State> stateList = service
				        .getAllStateForCountry(countryIdStr.trim());
				showErrBox = true;
				requestScope("stateList", stateList);
			}
		}
		
		return forward("editLocation.jsp");
		
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
		
		v.add("active", v.required());
		
		boolean valid = v.validate();
		requestScope("errorSize", new Integer(v.getErrors().size()));
		return valid;
	}
	
}
