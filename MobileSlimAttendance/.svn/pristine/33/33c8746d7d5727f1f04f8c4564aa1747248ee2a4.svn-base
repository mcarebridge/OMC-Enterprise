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
import com.adviteya.dto.ShiftDTO;
import com.adviteya.model.MA_Alert;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Shift;
import com.adviteya.service.AlertService;
import com.adviteya.service.EmployeeService;
import com.adviteya.service.EntityService;
import com.google.appengine.api.datastore.Key;

public class EditAlertController extends BaseController implements
        IMobileAttendanceConstants
{
	private static Logger logger          = Logger.getLogger(EditAlertController.class
	                                              .getName());
	private AlertService  businessService = new AlertService();
	private EntityService entityService   = EntityService.getInstance();
	private EmployeeService employeeService=new EmployeeService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		pageTitle = "title.editAlert";
		pageHeader = "page.editAlert";
		
		String alertIdstr = requestScope("alertId");
		String action = requestScope("actionParam");
		long companyId = sessionScope("companyId");
		
		if (!alertIdstr.equals(""))
		{
			long alertId = Long.parseLong(alertIdstr);
			Key k = Datastore.createKey(MA_Alert.class, alertId);
			MA_Alert alert = Datastore.get(MA_Alert.class, k);
			
			List<MA_Alert> alertlist = (List<MA_Alert>) (sessionScope("alertList") == null ? new ArrayList<MA_Alert>()
			        : sessionScope("alertList"));
			
			if (action.equals("editAlertLocation"))
			{
				alertlist.clear();
				if (alert.getAlertTypeRef().getModel().getDisplayName()
				        .equals(RESOURCE_STRENGTH))
				{
					alertlist.addAll(businessService
					        .loadAlertForLocation(alert));
				} else if (alert.getAlertTypeRef().getModel().getDisplayName()
				        .equals(PUNCTUALITY))
				{
					alertlist.add(alert);
				}else if (alert.getAlertTypeRef().getModel().getDisplayName()
				        .equals(FEMALE_EMPLOYEE_SECURITY))
				{
					alertlist.addAll(businessService
					        .loadAlertForLocation(alert));
				}
				
			} else if (action.equals("editAlertShift"))
			{
				alertlist.clear();
				alertlist.add(alert);
				
			} else if (action.equalsIgnoreCase("updateAlert"))
			{
				
				String alertType = requestScope("alertType");
				Validators v = new Validators(request);
				Long locationId = alert.getLocationRef().getKey().getId();
				List<MA_Shift> shiftlist = entityService
				        .getAllActiveShifForLocation(locationId);
				Map<String, Object> input = new RequestMap(request);
				if (validate(v, alertType, shiftlist))
				{					
					businessService.updateAlert(input, companyId, locationId);
					sessionScope("alertList", null);
					return forward("viewAlert");
				} else
				{
					showErrBox = true;
					
				}
				
			}
			requestScope("tolerance", alert.getToleranceLevelForEscalation());
			String alertType = alert.getAlertTypeRef().getModel()
			        .getDisplayName();
			String location = alert.getLocationRef().getModel()
			        .getLocationName();
			List<MA_Employee> managerList= employeeService.getManagerList(companyId);
			requestScope("managerList", managerList);
			requestScope("alert", alert);
			requestScope("alertType", alertType);
			requestScope("location", location);
			sessionScope("alertList", alertlist);
			
		} else if (action.equalsIgnoreCase("inactivateAlert"))
		{
			String inactiveAlertId = requestScope("inactiveAlertId");
			
			String delims = "[,]";
			String[] alertIds = inactiveAlertId.split(delims);
			if (alertIds[0] != "")
			{
				businessService.inactivateAlertId(alertIds, companyId);				
			} else
			{
				Validators v = new Validators(request);
				v.getErrors().put(" ", "Please, select atleast one Check Box");
				showErrBox = true;
				requestScope("showErrBox", showErrBox);
			}
			return forward("viewAlert");
		}
		
		return forward("editAlert.jsp");
	}
	
	private boolean validate(Validators v, String alertType,
	        List<MA_Shift> shiftlist)
	{		
		if (alertType.equals(PUNCTUALITY))
		{
			v.add("location", v.required());
			v.add("alertType", v.required());
			v.add("toleranceLevel1",
			        v.required("Tolerance level for escalation is req"));
			v.add("minValue", v.integerType(), v.required());
			v.add("1stManager", v.required());
			v.add("2ndManager", v.required());
			
			int minValue=Integer.parseInt((String) requestScope("minValue"));
			int tolerance=Integer.parseInt((String) requestScope("toleranceLevel1"));
			if(minValue>tolerance)
			{
				v.getErrors()
		        .put("punctuality",
		                "Min value Should be greater than Tolerance Level ");
			}
		
		} else if (alertType.equals(RESOURCE_STRENGTH))
		{
			v.add("location", v.required());
			v.add("alertType", v.required());
			v.add("toleranceLevel", v.required());
			for (MA_Shift s : shiftlist)
			{
				if (requestScope(s.getKey().getId() + "id") != null)
				{
					v.add(s.getKey().getId() + "tgtValue", v.required(),
					        v.integerType());
					v.add(s.getKey().getId() + "max", v.required(),
					        v.integerType());
					v.add(s.getKey().getId() + "min", v.required(),
					        v.integerType());
				
					
					String _1stManager=requestScope(s.getKey().getId() + "1stManager");
					String _2ndManager=requestScope(s.getKey().getId() + "2ndManager");
					
					if (v.validate())
					{
						
						String _tgt = requestScope(s.getKey().getId()
						        + "tgtValue");
						String _min = requestScope(s.getKey().getId() + "min");
						String _max = requestScope(s.getKey().getId() + "max");
						
						int tgt = Integer.parseInt(_tgt);
						int max = Integer.parseInt(_max);
						int min = Integer.parseInt(_min);
						
						if(!(tgt == 0
						        && max == 0
						        && min == 0) )
						{
							v.add(s.getKey().getId() + "1stManager", v.required());
							v.add(s.getKey().getId() + "2ndManager", v.required());
							if (_1stManager.equals(_2ndManager))
							{
								v.getErrors()
								        .put(" ",
								                "First and Second Manager should not be same.");
							}
						}
						
						if (min == 0 && tgt != 0)
						{
							v.getErrors()
							        .put("min>tgt",
							                "Min Value should be greater than the Zero");
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
				}
			}
			if (v.getErrors().size() > 0)
			{
				logger.log(Level.INFO, "Error size=" + v.getErrors().size());
				return false;
				
			}
		}else if (alertType.equals(FEMALE_EMPLOYEE_SECURITY))
		{
			v.add("location", v.required());
			v.add("alertType", v.required());
			
			for (MA_Shift s : shiftlist)
			{
				if (requestScope(s.getKey().getId() + "id") != null)
				{
					String _1stManager=requestScope(s.getKey().getId() + "1stManager");
					String _2ndManager=requestScope(s.getKey().getId() + "2ndManager");
					v.add(s.getKey().getId() + "1stManager", v.required());
					v.add(s.getKey().getId() + "2ndManager", v.required());
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