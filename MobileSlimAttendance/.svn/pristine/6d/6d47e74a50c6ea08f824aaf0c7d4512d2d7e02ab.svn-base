package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.LocationDTO;
import com.adviteya.dto.ShiftDTO;
import com.adviteya.model.MA_AlertType;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.service.AlertService;
import com.adviteya.service.EmployeeService;
import com.adviteya.service.EntityService;
import com.adviteya.service.LocationBusinessService;
import com.google.appengine.api.datastore.Key;

/**
 * @author developer1
 * 
 */
public class CreateAlertController extends BaseController implements
        IMobileAttendanceConstants
{
	private Logger logger = Logger.getLogger(CreateAlertController.class
	                              .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		EntityService entityService = EntityService.getInstance();
		EmployeeService employeeService=new EmployeeService();
		AlertService service = new AlertService();
		LocationBusinessService locationService = new LocationBusinessService();
		
		pageTitle = "title.createAlert";
		pageHeader = "page.createAlert";
		String action = requestScope("actionParam");
		long companyId = sessionScope("companyId");
		String locationId = requestScope("location");
		String alertTypeId = requestScope("alertType");
		
		List<MA_Location> locationList = new ArrayList<MA_Location>();
		List<MA_AlertType> alertTypeList = new ArrayList<MA_AlertType>();
		List<MA_Shift> shiftlist = new ArrayList<MA_Shift>();
		MA_AlertType alertType = new MA_AlertType();
		
		locationList.addAll(entityService.getAllActiveLocationForCompany(companyId));
		alertTypeList.addAll(service.getAlertType());
		requestScope("locationList", locationList);
		requestScope("alertList", alertTypeList);
		Map<String, Object> input = new RequestMap(request);
		
		if (alertTypeId != null && locationId != null
		        && !alertTypeId.equals("") && !locationId.equals(""))
		{
			Key k2 = Datastore.createKey(MA_AlertType.class,
			        Long.parseLong(alertTypeId));
			alertType = Datastore.get(MA_AlertType.class, k2);
			shiftlist = entityService.getAllActiveShifForLocation(Long
			        .parseLong(locationId));
			requestScope("shiftList", shiftlist);
			List<MA_Employee> managerList= employeeService.getManagerList(companyId);
			requestScope("managerList", managerList);
		
			
		}
		Validators v = new Validators(request);
		if (validate(v, alertType, shiftlist))
		{
			
			if (action != null && action.equals("loadShift")
			        && alertType.getDisplayName().equals(RESOURCE_STRENGTH))
			{
				
				if (shiftlist.isEmpty())
				{
					v.getErrors().put("",
					        "shift is not present for selected location");
					showErrBox = true;
				}
				
			} else if (action != null && action.equals("createAlert"))
			{
				
				boolean isUserCreated = service.createAlert(input, companyId);
				if (isUserCreated)
				{
					return forward("viewAlert");
				} else
				{
					v.getErrors()
					        .put("alertPresent",
					                "Alert is already exist for this alert type and location");
					showErrBox = true;
				}
				
			}
		} else
		{
			showErrBox = true;
			
		}
		requestScope("location", locationId);
		requestScope("alertType", alertType.getDisplayName());
		requestScope("alertTypeId", alertTypeId);
		return forward("createAlert.jsp");
	}
	
	/**
	 * @param v
	 * @param alertType
	 * @param shiftlist
	 * @return
	 */
	private boolean validate(Validators v, MA_AlertType alertType,
	        List<MA_Shift> shiftlist)
	{
		
		String action = requestScope("actionParam");
		
		if (action != null && action.equals("loadShift"))
		{
			v.add("location", v.required());
			v.add("alertType", v.required());
		} else if (action != null && action.equals("createAlert")
		        && alertType.getDisplayName().equals(PUNCTUALITY))
		{
			v.add("location", v.required());
			v.add("alertType", v.required());
			v.add("1stManager", v.required());
			v.add("2ndManager", v.required());
			String _1stManager=requestScope("1stManager");
			String _2ndManager=requestScope("2ndManager");
			
			if (_1stManager.equals(_2ndManager))
			{
				v.getErrors()
				        .put(" ",
				                "First and Second Manager should not be same.");
			}
			v.add("toleranceLevel1",
			        v.required("Tolerance level for escalation is req"));
			v.add("minValue", v.integerType(), v.required());
		} else if (action != null && action.equals("createAlert")
		        && alertType.getDisplayName().equals(RESOURCE_STRENGTH))
		{
			v.add("location", v.required());
			v.add("alertType", v.required());
			v.add("toleranceLevel", v.required());

			for (MA_Shift s : shiftlist)
			{
				v.add(s.getKey().getId() + "tgtValue", v.required(),
				        v.integerType());
				v.add(s.getKey().getId() + "max", v.required(), v.integerType());
				v.add(s.getKey().getId() + "min", v.required(), v.integerType());
				
				
				
				String _1stManager=requestScope(s.getKey().getId() + "1stManager");
				String _2ndManager=requestScope(s.getKey().getId() + "2ndManager");
				
				
				if (v.validate())
				{
					String _tgt = requestScope(s.getKey().getId() + "tgtValue");
					String _min = requestScope(s.getKey().getId() + "min");
					String _max = requestScope(s.getKey().getId() + "max");
					
					int tgt = Integer.parseInt(_tgt);
					int max = Integer.parseInt(_max);
					int min = Integer.parseInt(_min);
					
					if(!(tgt == 0
					        && max == 0
					        && min == 0) )
					{
						v.add(s.getKey().getId() + "1stManager", v.required(" First Manager is Required"));
						v.add(s.getKey().getId() + "2ndManager", v.required(" Second Manager is Required"));
						if (_1stManager.equals(_2ndManager))
						{
							v.getErrors()
							        .put(" ",
							                "First and Second Manager should not be same.");
						}
					}
					if (min > tgt)
					{
						v.getErrors()
						        .put("min>tgt",
						                "Min Value should be less than the target value");
					}
					if (tgt > max)
					{
						v.getErrors()
						        .put("tgt>max",
						                "Max Value should be more than the target value");
					}
				}
	//			i++;
			}
			if (v.getErrors().size() > 0)
			{
				logger.log(Level.INFO, "Error size=" + v.getErrors().size());
				return false;
				
			}
		}else if (action != null && action.equals("createAlert")
		        && alertType.getDisplayName().equals(FEMALE_EMPLOYEE_SECURITY))
		{
			v.add("location", v.required());
			v.add("alertType", v.required());
			
			for (MA_Shift s : shiftlist)
			{
				String _1stManager=requestScope(s.getKey().getId() + "1stManager");
				String _2ndManager=requestScope(s.getKey().getId() + "2ndManager");
				v.add(s.getKey().getId() + "1stManager", v.required(" First Manager is Required"));
				v.add(s.getKey().getId() + "2ndManager", v.required(" Second Manager is Required"));
				
				if (v.validate())
				{
										
						if (_1stManager.equals(_2ndManager))
						{
							v.getErrors()
							        .put(" ",
							                "First and Second Manager should not be same.");
						}
				}
								
			}
			if (v.getErrors().size() > 0)
			{
				logger.log(Level.INFO, "Error size=" + v.getErrors().size());
				return false;
				
			}
		}
		
		return v.validate();
		
	}
	
}