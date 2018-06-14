package com.adviteya.controller.humancapital;

import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Location;
import com.adviteya.service.EmployeeService;
import com.adviteya.service.EntityService;
import com.adviteya.service.IEmployeeService;

public class CreateContractorController extends BaseController
{
	
	private EntityService    service         = EntityService.getInstance();
	private IEmployeeService businessService = new EmployeeService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		pageTitle = "title.addContractor";
		pageHeader = "page.addContractor";
		
		String action = requestScope("actionParam");
		
		Long companyId = sessionScope("companyId");
		// if(action.equals("initialLoad")) {
		if (action == null)
		{
			List<MA_Location> locationList = service
			        .getAllLocationForCompany(companyId);
			sessionScope("locationList", locationList);
			requestScope("companyId", companyId);
			return forward("createContractor.jsp");
			
		} else
		{
			
			Validators v = new Validators(request);
			if (!validate(v))
			{
				requestScope("companyId", companyId);
				return forward("addEmployee.jsp");
			} else
			{
				String status = businessService.createEmployee(new RequestMap(
				        request), null);
				if (status.equals("failure"))
				{
					v.getErrors()
					        .put(null,
					                "Unexpected Error Occured.Please contact system admin");
				}
				return forward("home");
			}
			
		}
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		
		v.add("startDate", v.required());
		v.add("companyEmpId", v.required());
		v.add("employeeType", v.required());
		
		v.add("firstName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("lastName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("gender", v.required());
		v.add("location", v.required());
		v.add("shift", v.required());
		v.add("minWorkingHrsPerDay", v.required());
		v.add("numOfWorkingDays", v.required());
		v.add("dayOfWeeklyOff", v.required());
		v.add("isSuperwiser", v.required());
		
		return v.validate();
	}
	
}
