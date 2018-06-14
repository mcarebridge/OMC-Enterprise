package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.LocationDTO;
import com.adviteya.dto.ShiftDTO;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.service.EntityService;
import com.adviteya.service.ITimeSheetBusinessService;
import com.adviteya.service.LocationBusinessService;
import com.adviteya.service.ShiftBusinessService;
import com.adviteya.service.TimeSheetBusinessService;

public class AddShiftController extends BaseController
{
	private static Logger        logger          = Logger.getLogger(AddShiftController.class
	                                                     .getName());
	private EntityService        service         = EntityService.getInstance();
	private ShiftBusinessService businessService = new ShiftBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		pageTitle = "title.addShift";
		pageHeader = "page.addShift";
		Long companyId = sessionScope("companyId");
		requestScope("companyId", companyId);
		String action = requestScope("actionParam");
		List<MA_Location> locationList = service
		        .getAllActiveLocationForCompany(companyId);
		sessionScope("locationList", locationList);
		boolean invalid = false;
		
		if (action != null && action.equals("addShift"))
		{
			Validators v = new Validators(request);
			if (validate(v))
			{
				if (!businessService.isShiftDurationValid(new RequestMap(
				        request)))
				{
					ITimeSheetBusinessService businessService = new TimeSheetBusinessService();
					List<MA_TimeSheetRule> timeSheetRules = businessService
					        .getTimesheetRulesOfCompany((Long) requestScope("companyId"));
					MA_TimeSheetRule timesheetRule = new MA_TimeSheetRule();
					timesheetRule
					        .setRuleKey(IMobileAttendanceConstants.MAX_DAILY_EFFORTS);
					MA_TimeSheetRule maxDailyEffortRule = timeSheetRules
					        .get(timeSheetRules.indexOf(timesheetRule));
					long maxDailyEffort = maxDailyEffortRule.getValue();
					int maxDailyHrs = (int) (maxDailyEffort / 3600);
					int maxDailyMin = (int) (maxDailyEffort % 3600);
					String Duration = calculateDuration(new RequestMap(request));
					v.getErrors()
					        .put("",
					                "Maximum daily efforts are "
					                        + maxDailyHrs
					                        + " Hrs "
					                        + maxDailyMin
					                        + " mins. The Shift duration ("
					                        + Duration
					                        + ") should be less than Maximum daily efforts. Please refer Admin setting.");
					showErrBox = true;
					invalid = true;
					
				} else
				{
					invalid = false;
					String message = getshiftDurationMessage(new RequestMap(
					        request));
					
					v.getErrors().put("", message);
					v.getErrors().put(" ", "Press 'Confirm' to save ");
					showErrBox = true;
				}
				
			} else
			{
				invalid = true;
				
				showErrBox = true;
			}
			
		} else if (action != null && action.equals("confirm"))
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
					String status = businessService.createShift(new RequestMap(
					        request));
					requestScope("invalid", "");
					
					invalid = true;
					requestScope("initialLoad", "true");
				}
			} else
			{
				invalid = true;
				showErrBox = true;
			}
		} else
		{
			sessionScope("counter", 0);
			invalid = true;
			requestScope("initialLoad", "true");
		}
		
		List<ShiftDTO> shiftDTOs = businessService
		        .getShiftListForCompany(companyId);
		requestScope("shiftList", shiftDTOs);
		requestScope("invalid", invalid);
		return forward("addShift.jsp");
	}
	
	private String calculateDuration(Map<String, Object> input)
	{
		// TODO Auto-generated method stub
		int start_hrs = Integer.parseInt((String) input.get("start_hrs"));
		int start_min = Integer.parseInt((String) input.get("start_min"));
		int end_hrs = Integer.parseInt((String) input.get("end_hrs"));
		int end_min = Integer.parseInt((String) input.get("end_min"));
		String locationId = (String) input.get("location");
		
		int startTime = start_hrs * 60 + start_min;
		int endTime = end_hrs * 60 + end_min;
		String message = "";
		
		long shiftDuration = 0;
		if (startTime > endTime)
		{
			shiftDuration = (1440 - startTime) + endTime;
		} else
		{
			shiftDuration = endTime - startTime;
		}
		
		int duration_hrs = (int) (shiftDuration / 60);
		int duration_min = (int) (shiftDuration % 60);
		message = duration_hrs + " hrs " + duration_min + " min";
		return message;
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		v.add("location", v.required());
		v.add("shiftName",
		        v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY),
		        v.regexp("^[0-9a-zA-Z-]+$",
		                "Use only Number(0-9),Alphabet(a-z,A-Z) and hypens(-) with no spaces"));
		v.add("start_hrs", v.required(), v.integerType(), v.longRange(0, 23));
		v.add("start_min", v.required(), v.integerType(), v.longRange(0, 59));
		v.add("end_hrs", v.required(), v.integerType(), v.longRange(0, 23));
		v.add("end_min", v.required(), v.integerType(), v.longRange(0, 59));
		
		boolean valid = v.validate();
		requestScope("errorSize", new Integer(v.getErrors().size()));
		return valid;
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public String getshiftDurationMessage(Map<String, Object> input)
	{
		// TODO Auto-generated method stub
		LocationBusinessService locationBusinessService = new LocationBusinessService();
		
		int start_hrs = Integer.parseInt((String) input.get("start_hrs"));
		int start_min = Integer.parseInt((String) input.get("start_min"));
		int end_hrs = Integer.parseInt((String) input.get("end_hrs"));
		int end_min = Integer.parseInt((String) input.get("end_min"));
		String locationId = (String) input.get("location");
		
		int startTime = start_hrs * 60 + start_min;
		int endTime = end_hrs * 60 + end_min;
		String message = "";
		
		long shiftDuration = 0;
		if (startTime > endTime)
		{
			shiftDuration = (1440 - startTime) + endTime;
			message = message + "This shift will end on next day.\n";
		} else
		{
			shiftDuration = endTime - startTime;
		}
		
		int duration_hrs = (int) (shiftDuration / 60);
		int duration_min = (int) (shiftDuration % 60);
		
		LocationDTO location = locationBusinessService.getLocationDetails(Long
		        .parseLong(locationId));
		
		String timeZone = location.getTimezone();
		
		requestScope("timeZone", timeZone);
		
		message = message + "Your shift will start at " + start_hrs + ":"
		        + start_min + " Hrs (" + timeZone + ") \n and will end at "
		        + end_hrs + ":" + end_min + " Hrs (" + timeZone
		        + ").\nTotal duration " + duration_hrs + " hrs " + duration_min
		        + " min.";
		return message;
	}
}
