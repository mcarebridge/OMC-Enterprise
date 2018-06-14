package com.adviteya.controller.humancapital;

import java.util.Calendar;
import java.util.List;

import org.slim3.controller.Navigation;

import com.adviteya.model.MA_Location;
import com.adviteya.service.DashboardBusinessService;
import com.adviteya.service.EntityService;

public class DepartmentDashboardController extends BaseController
{
	private DashboardBusinessService dashBoardService = new DashboardBusinessService();
	private EntityService            service          = EntityService
	                                                          .getInstance();
	private boolean                  showErrBox       = false;
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		Long companyId = sessionScope("companyId");
		Calendar cal = Calendar.getInstance();
		String isDepartment = sessionScope("isDepartment");
		List<MA_Location> locations = service
		        .getAllLocationForCompany(companyId);
		sessionScope("locationList", locations);
		if (isDepartment.equals("Y"))
		{
			
			String action = requestScope("actionParam");
			if (null != action && action.equals("getshiftDepartmentDashbaord"))
			{
				String locationId = request.getParameter("locationId");
				requestScope("departmentDashboardRecord",
				        dashBoardService.getLocationShiftDepartmentDashboard(
				                Long.valueOf(locationId), cal));
				
			}
			
		}
		
		showHeader = true;
		pageHeader = "page.departmentDashboard";
		pageTitle = "title.departmentDashboard";
		return forward("departmentDashboard.jsp");
	}
}
