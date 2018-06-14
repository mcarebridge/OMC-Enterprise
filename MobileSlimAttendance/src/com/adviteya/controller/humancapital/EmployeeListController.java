package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.dto.EmployeeDTO;
import com.adviteya.model.MA_Location;
import com.adviteya.service.EmployeeService;
import com.adviteya.service.EntityService;
import com.adviteya.service.IEmployeeService;

public class EmployeeListController extends BaseController
{
	
	private static Logger    logger          = Logger.getLogger(AddEmployeeController.class
	                                                 .getName());
	private EntityService    service         = EntityService.getInstance();
	// private EntityService service = null;
	private IEmployeeService businessService = new EmployeeService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		logger.log(Level.INFO, "Start executeLogic");
		
		pageTitle = "title.viewEmployees";
		pageHeader = "page.viewEmployee";
		
		String action = requestScope("actionParam");
		Long companyId = sessionScope("companyId");
		
		logger.log(Level.INFO, "Company id=" + companyId);
		logger.log(Level.INFO, "Action=" + action);
		
		// if(action.equals("initialLoad")) {
		requestScope("companyId", companyId);
		requestScope("parentCompanyId", companyId);
		
		requestScope("empCompanyId", "" + companyId + "-");
		
		if (action == null || action.equals("updateEmployee"))
		{
			List<MA_Location> locationList = service
			        .getAllActiveLocationForCompany(companyId);
			sessionScope("locationList", locationList);
			
			requestScope("initialLoad", "true");
			// return forward("addEmployee.jsp");
		} else if (action.equals("backToMain"))
		{
			return forward("employeeIndex");
		}
		List<EmployeeDTO> employeeDTOs = businessService
		        .getAllEmployeeOfCompany(companyId);
		requestScope("employeeList", employeeDTOs);
		logger.log(Level.INFO, "End executeLogic");
		
		return forward("employeeList.jsp");
	}
	
}
