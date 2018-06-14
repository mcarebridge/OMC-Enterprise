package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.adviteya.model.MA_Department;
import com.adviteya.model.MA_Location;
import com.adviteya.service.DepartmentService;
import com.adviteya.service.EntityService;
import com.adviteya.service.IDepartmentService;

public class CreateDepartmentController extends BaseController
{
	
	private static Logger      logger          = Logger.getLogger(CreateDepartmentController.class
	                                                   .getName());
	private EntityService      service         = EntityService.getInstance();
	// private EntityService service = null;
	private IDepartmentService businessService = new DepartmentService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		logger.log(Level.INFO, "Start executeLogic");
		
		pageTitle = "title.createDepartment";
		pageHeader = "page.createDepartment";
		
		String action = requestScope("actionParam");
		Long companyId = sessionScope("companyId");
		
		List<MA_Location> locationList = (List) sessionScope("locationList");
		if (null == locationList)
		{
			locationList = service.getAllLocationForCompany(companyId);
			sessionScope("locationList", locationList);
		}
		requestScope("companyId", companyId);
		if (action == null)
		{
			
			requestScope("initialLoad", "true");
		} else if (action.equalsIgnoreCase("createDepartment"))
		{
			
			Validators v = new Validators(request);
			if (!validate(v))
			{
				requestScope("companyId", companyId);
				showErrBox = true;
			} else
			{
				String status = null;// businessService.createDepartment(new
				                     // RequestMap(
				// request));
				
				logger.log(Level.INFO, "Create Department status=" + status);
				if (status.equals("failure"))
				{
					v.getErrors()
					        .put("",
					                "Unexpected Error Occured.Please contact system admin");
					logger.log(Level.INFO,
					        "Unexpected Error Occured.Please contact system admin.");
					showErrBox = true;
				} else if (status.equals("departmentIdExists"))
				{
					showErrBox = true;
					v.getErrors().put("", "Department already exists.");
					logger.log(Level.INFO, "Departmen already exists.");
					
				} else
				{
					requestScope("createdDepartmenId", status);
					logger.log(Level.INFO, "createdDepartmenId =" + status);
					requestScope("initialLoad", "true");
				}
				
			}
			
		}
		List<MA_Department> departments = businessService
		        .getAllDepartmentOfCompany(companyId);
		requestScope("departmentList", departments);
		logger.log(Level.INFO, "End executeLogic");
		return forward("createDepartment.jsp");
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		logger.log(Level.INFO, "Start Validate Method");
		
		v.add("departmentName", v.required());
		v.add("description", v.required());
		v.add("location", v.required());
		v.add("active", v.required());
		logger.log(Level.INFO, "End Validate method");
		return v.validate();
	}
	
}
