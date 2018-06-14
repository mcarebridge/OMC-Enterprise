package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.ShiftDTO;
import com.adviteya.model.MA_Location;
import com.adviteya.service.EntityService;
import com.adviteya.service.ShiftBusinessService;

public class EditShiftController extends BaseController
{
	private static Logger        logger          = Logger.getLogger(AddShiftController.class
	                                                     .getName());
	private EntityService        service         = EntityService.getInstance();
	private ShiftBusinessService businessService = new ShiftBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		pageTitle = "title.editShift";
		pageHeader = "page.editShift";
		
		Long companyId = sessionScope("companyId");
		String action = requestScope("actionParam");
		List<MA_Location> locationList = service
		        .getAllLocationForCompany(companyId);
		sessionScope("locationList", locationList);
		
		if ("editShift".equals(action))
		{
			String shiftIdStr = requestScope("shiftId");
			ShiftDTO shiftDto = businessService.getShiftDetails(Long
			        .valueOf(shiftIdStr));
			
			requestScope("shiftName", shiftDto.getShiftName());
			requestScope("location", shiftDto.getLocationId());
			requestScope("start_hrs", shiftDto.getStartHrs());
			requestScope("start_min", shiftDto.getStartMin());
			requestScope("end_hrs", shiftDto.getEndHrs());
			requestScope("end_min", shiftDto.getEndMin());
			
			requestScope("shiftId", shiftDto.getShiftId());
			
			if ("Y".equals(shiftDto.getActive()))
			{
				requestScope("active", "Y");
			} else
			{
				requestScope("active", "N");
			}
			
		}
		
		else
		{
			Validators v = new Validators(request);
			if (validate(v))
			{
				String activeStatus = requestScope("active");
				if (activeStatus.equals("N"))
				{
					String shiftId = (String) requestScope("shiftId");
					
					int currentAssignmentCount = businessService
					        .getCurrentAssignmentCountOfShift(Long
					                .valueOf(shiftId));
					
					logger.log(Level.INFO, "No of current assignments="
					        + currentAssignmentCount);
					if (currentAssignmentCount > 0)
					{
						v.getErrors()
						        .put("shift.current.assignment",
						                "Shift status can not be changed as there are current assignment at this shift.");
						requestScope("errorSize", new Integer(v.getErrors()
						        .size()));
					} else
					{
						
						businessService.updateShift(new RequestMap(request));
						return forward("addShift");
					}
				} else
				{
					businessService.updateShift(new RequestMap(request));
					return forward("addShift");
				}
				
			}
			
		}
		
		return forward("editShift.jsp");
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
		v.add("shiftName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("start_hrs", v.required(), v.integerType(), v.longRange(0, 23));
		v.add("start_min", v.required(), v.integerType(), v.longRange(0, 59));
		v.add("end_hrs", v.required(), v.integerType(), v.longRange(0, 23));
		v.add("end_min", v.required(), v.integerType(), v.longRange(0, 59));
		v.add("active", v.required());
		
		boolean valid = v.validate();
		requestScope("errorSize", new Integer(v.getErrors().size()));
		return valid;
	}
}
