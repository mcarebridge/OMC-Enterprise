package com.adviteya.controller.humancapital;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.dto.LocationDashboardReportDTO;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.service.DashboardBusinessService;
import com.adviteya.service.DashboardDisplayBusinessService;
import com.adviteya.service.EntityService;

public class HomeController extends BaseController
{
	private DashboardBusinessService dashBoardService = new DashboardBusinessService();
	private EntityService            service          = EntityService
	                                                          .getInstance();
	private boolean                  showErrBox       = false;
	
	private static Logger            logger           = Logger.getLogger(HomeController.class
	                                                          .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		Long companyId = sessionScope("companyId");
		Calendar cal = Calendar.getInstance();
		// sendMail(companyId);
		List<MA_Location> locations = service
		        .getAllActiveLocationForCompany(companyId);
		sessionScope("locationList", locations);
		String action = requestScope("actionParam");
		
		if ("getLocationDashboard".equals(action))
		{
			
			String locationIdStr = requestScope("locationId");
			
			if (locationIdStr.equals(""))
			{
				Map dashBoardMap = dashBoardService
				        .getDashBoardCount(companyId);
				requestScope("utilization_percent",
				        (Integer) dashBoardMap.get("UTILIZATION_PERCENT"));
				
				requestScope("not_reported_percent",
				        (Integer) dashBoardMap.get("NOT_REPORTED_PERCENT"));
				requestScope("late_in_percent",
				        (Integer) dashBoardMap.get("LATE_IN_PERCENT"));
				requestScope("early_left_percent",
				        (Integer) dashBoardMap.get("EARLY_LEFT_PERCENT"));
				// requestScope("unassigned", (Integer)
				// dashBoradMap.get("UNASSIGNED"));
				requestScope("location_details",
				        (List) dashBoardMap.get("LOCATION_DEATILS"));
				
				requestScope("no_of_assignemnt",
				        (Integer) dashBoardMap.get("NO_OF_ASSIGNEMNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoardMap.get("REPORTED_EMPLOYEE_COUNT"));
				
				requestScope(
				        "no_of_not_reported",
				        (Integer) dashBoardMap.get("NO_OF_ASSIGNEMNT")
				                - (Integer) dashBoardMap
				                        .get("ASG_REPORTED_EMPLOYEE_COUNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoardMap.get("REPORTED_EMPLOYEE_COUNT"));
				requestScope("late_in_employee_count",
				        (Integer) dashBoardMap.get("LATE_IN_EMPLOYEE_COUNT"));
				requestScope("early_out_employee_count",
				        (Integer) dashBoardMap.get("EARLY_OUT_EMPLOYEE_COUNT"));
				
			} else
			{
				
				Map dashBoradMap = dashBoardService.getLocationDashBoardCount(
				        Long.valueOf(locationIdStr), cal, null);
				requestScope("utilization_percent",
				        (Integer) dashBoradMap.get("UTILIZATION_PERCENT"));
				
				requestScope("not_reported_percent",
				        (Integer) dashBoradMap.get("NOT_REPORTED_PERCENT"));
				requestScope("late_in_percent",
				        (Integer) dashBoradMap.get("LATE_IN_PERCENT"));
				requestScope("early_left_percent",
				        (Integer) dashBoradMap.get("EARLY_LEFT_PERCENT"));
				// requestScope("unassigned", (Integer)
				// dashBoradMap.get("UNASSIGNED"));
				
				requestScope("no_of_assignemnt",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				
				requestScope(
				        "no_of_not_reported",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT")
				                - (Integer) dashBoradMap
				                        .get("ASG_REPORTED_EMPLOYEE_COUNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				requestScope("late_in_employee_count",
				        (Integer) dashBoradMap.get("LATE_IN_EMPLOYEE_COUNT"));
				requestScope("early_out_employee_count",
				        (Integer) dashBoradMap.get("EARLY_OUT_EMPLOYEE_COUNT"));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr));
				requestScope("shiftList", shiftList);
				
			}
			
			String locationIdStr1 = requestScope("locationId1");
			String shiftIdStr1 = requestScope("shiftId1");
			if (!locationIdStr1.equals(""))
			{
				
				requestScope(
				        "departmentDashboardRecord",
				        dashBoardService.getLocationDepartmentDashboard(
				                Long.valueOf(locationIdStr1), cal));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr));
				requestScope("shiftList1", shiftList);
				
			} else if (!shiftIdStr1.equals(""))
			{
				
				requestScope(
				        "departmentDashboardRecord",
				        dashBoardService.getShiftDepartmentDashboard(
				                Long.valueOf(shiftIdStr1), cal));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr));
				requestScope("shiftList1", shiftList);
				
			}
			
		} else if ("getLocationShiftDashboard".equals(action))
		{
			
			String shiftIdStr = requestScope("shiftId");
			String locationIdStr = requestScope("locationId");
			
			if (shiftIdStr.equals(""))
			{
				Map dashBoradMap = dashBoardService.getLocationDashBoardCount(
				        Long.valueOf(locationIdStr), cal, null);
				requestScope("utilization_percent",
				        (Integer) dashBoradMap.get("UTILIZATION_PERCENT"));
				
				requestScope("not_reported_percent",
				        (Integer) dashBoradMap.get("NOT_REPORTED_PERCENT"));
				requestScope("late_in_percent",
				        (Integer) dashBoradMap.get("LATE_IN_PERCENT"));
				requestScope("early_left_percent",
				        (Integer) dashBoradMap.get("EARLY_LEFT_PERCENT"));
				// requestScope("unassigned", (Integer)
				// dashBoradMap.get("UNASSIGNED"));
				
				requestScope("no_of_assignemnt",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				
				requestScope(
				        "no_of_not_reported",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT")
				                - (Integer) dashBoradMap
				                        .get("ASG_REPORTED_EMPLOYEE_COUNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				requestScope("late_in_employee_count",
				        (Integer) dashBoradMap.get("LATE_IN_EMPLOYEE_COUNT"));
				requestScope("early_out_employee_count",
				        (Integer) dashBoradMap.get("EARLY_OUT_EMPLOYEE_COUNT"));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr));
				
			} else
			{
				
				Map dashBoradMap = dashBoardService.getShiftDashBoardCount(
				        Long.valueOf(shiftIdStr), cal);
				requestScope("utilization_percent",
				        (Integer) dashBoradMap.get("UTILIZATION_PERCENT"));
				
				requestScope("not_reported_percent",
				        (Integer) dashBoradMap.get("NOT_REPORTED_PERCENT"));
				requestScope("late_in_percent",
				        (Integer) dashBoradMap.get("LATE_IN_PERCENT"));
				requestScope("early_left_percent",
				        (Integer) dashBoradMap.get("EARLY_LEFT_PERCENT"));
				// requestScope("unassigned", (Integer)
				// dashBoradMap.get("UNASSIGNED"));
				
				requestScope("no_of_assignemnt",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				
				requestScope(
				        "no_of_not_reported",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT")
				                - (Integer) dashBoradMap
				                        .get("ASG_REPORTED_EMPLOYEE_COUNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				requestScope("late_in_employee_count",
				        (Integer) dashBoradMap.get("LATE_IN_EMPLOYEE_COUNT"));
				requestScope("early_out_employee_count",
				        (Integer) dashBoradMap.get("EARLY_OUT_EMPLOYEE_COUNT"));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr));
				requestScope("shiftList", shiftList);
				
			}
			
			String locationIdStr1 = requestScope("locationId1");
			String shiftIdStr1 = requestScope("shiftId1");
			
			if (!locationIdStr1.equals(""))
			{
				
				requestScope(
				        "departmentDashboardRecord",
				        dashBoardService.getLocationDepartmentDashboard(
				                Long.valueOf(locationIdStr1), cal));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr));
				requestScope("shiftList1", shiftList);
				
			} else if (!shiftIdStr1.equals(""))
			{
				
				requestScope(
				        "departmentDashboardRecord",
				        dashBoardService.getShiftDepartmentDashboard(
				                Long.valueOf(shiftIdStr1), cal));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr));
				requestScope("shiftList1", shiftList);
				
			}
			
		} else if ("getLocationDepartmentDashboard".equals(action)
		        || "getShiftDepartmentDashboard".equals(action))
		{
			
			String locationIdStr = requestScope("locationId1");
			String shiftIdStr = requestScope("shiftId1");
			
			if ("getLocationDepartmentDashboard".equals(action)
			        && !locationIdStr.equals(""))
			{
				
				requestScope(
				        "departmentDashboardRecord",
				        dashBoardService.getLocationDepartmentDashboard(
				                Long.valueOf(locationIdStr), cal));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr));
				requestScope("shiftList1", shiftList);
				
			} else if ("getShiftDepartmentDashboard".equals(action)
			        && !shiftIdStr.equals(""))
			{
				
				requestScope(
				        "departmentDashboardRecord",
				        dashBoardService.getShiftDepartmentDashboard(
				                Long.valueOf(shiftIdStr), cal));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr));
				requestScope("shiftList1", shiftList);
				
			}
			
			String shiftIdStr1 = requestScope("shiftId");
			String locationIdStr1 = requestScope("locationId");
			
			if (!shiftIdStr1.equals(""))
			{
				
				Map dashBoradMap = dashBoardService.getShiftDashBoardCount(
				        Long.valueOf(shiftIdStr1), cal);
				requestScope("utilization_percent",
				        (Integer) dashBoradMap.get("UTILIZATION_PERCENT"));
				
				requestScope("not_reported_percent",
				        (Integer) dashBoradMap.get("NOT_REPORTED_PERCENT"));
				requestScope("late_in_percent",
				        (Integer) dashBoradMap.get("LATE_IN_PERCENT"));
				requestScope("early_left_percent",
				        (Integer) dashBoradMap.get("EARLY_LEFT_PERCENT"));
				// requestScope("unassigned", (Integer)
				// dashBoradMap.get("UNASSIGNED"));
				
				requestScope("no_of_assignemnt",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				
				requestScope(
				        "no_of_not_reported",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT")
				                - (Integer) dashBoradMap
				                        .get("ASG_REPORTED_EMPLOYEE_COUNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				requestScope("late_in_employee_count",
				        (Integer) dashBoradMap.get("LATE_IN_EMPLOYEE_COUNT"));
				requestScope("early_out_employee_count",
				        (Integer) dashBoradMap.get("EARLY_OUT_EMPLOYEE_COUNT"));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr1));
				requestScope("shiftList", shiftList);
				
			} else if (!locationIdStr1.equals(""))
			{
				
				Map dashBoradMap = dashBoardService.getLocationDashBoardCount(
				        Long.valueOf(locationIdStr1), cal, null);
				requestScope("utilization_percent",
				        (Integer) dashBoradMap.get("UTILIZATION_PERCENT"));
				
				requestScope("not_reported_percent",
				        (Integer) dashBoradMap.get("NOT_REPORTED_PERCENT"));
				requestScope("late_in_percent",
				        (Integer) dashBoradMap.get("LATE_IN_PERCENT"));
				requestScope("early_left_percent",
				        (Integer) dashBoradMap.get("EARLY_LEFT_PERCENT"));
				// requestScope("unassigned", (Integer)
				// dashBoradMap.get("UNASSIGNED"));
				
				requestScope("no_of_assignemnt",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				
				requestScope(
				        "no_of_not_reported",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT")
				                - (Integer) dashBoradMap
				                        .get("ASG_REPORTED_EMPLOYEE_COUNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				requestScope("late_in_employee_count",
				        (Integer) dashBoradMap.get("LATE_IN_EMPLOYEE_COUNT"));
				requestScope("early_out_employee_count",
				        (Integer) dashBoradMap.get("EARLY_OUT_EMPLOYEE_COUNT"));
				List<MA_Shift> shiftList = service
				        .getAllActiveShifForLocation(Long
				                .valueOf(locationIdStr1));
				requestScope("shiftList", shiftList);
				
			} else
			{
				Map dashBoradMap = dashBoardService
				        .getDashBoardCount(companyId);
				requestScope("utilization_percent",
				        (Integer) dashBoradMap.get("UTILIZATION_PERCENT"));
				
				requestScope("not_reported_percent",
				        (Integer) dashBoradMap.get("NOT_REPORTED_PERCENT"));
				requestScope("late_in_percent",
				        (Integer) dashBoradMap.get("LATE_IN_PERCENT"));
				requestScope("early_left_percent",
				        (Integer) dashBoradMap.get("EARLY_LEFT_PERCENT"));
				// requestScope("unassigned", (Integer)
				// dashBoradMap.get("UNASSIGNED"));
				
				requestScope("no_of_assignemnt",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				
				requestScope(
				        "no_of_not_reported",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT")
				                - (Integer) dashBoradMap
				                        .get("ASG_REPORTED_EMPLOYEE_COUNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				requestScope("late_in_employee_count",
				        (Integer) dashBoradMap.get("LATE_IN_EMPLOYEE_COUNT"));
				requestScope("early_out_employee_count",
				        (Integer) dashBoradMap.get("EARLY_OUT_EMPLOYEE_COUNT"));
			}
			
		} else
		{
			Map dashBoradMap = dashBoardService.getDashBoardCount(companyId);
			requestScope("utilization_percent",
			        (Integer) dashBoradMap.get("UTILIZATION_PERCENT"));
			
			requestScope("not_reported_percent",
			        (Integer) dashBoradMap.get("NOT_REPORTED_PERCENT"));
			requestScope("late_in_percent",
			        (Integer) dashBoradMap.get("LATE_IN_PERCENT"));
			requestScope("early_left_percent",
			        (Integer) dashBoradMap.get("EARLY_LEFT_PERCENT"));
			// requestScope("unassigned", (Integer)
			// dashBoradMap.get("UNASSIGNED"));
			
			requestScope("no_of_assignemnt",
			        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT"));
			requestScope("no_of_employee_reported",
			        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
			
			requestScope(
			        "no_of_not_reported",
			        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT")
			                - (Integer) dashBoradMap
			                        .get("ASG_REPORTED_EMPLOYEE_COUNT"));
			requestScope("no_of_employee_reported",
			        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
			requestScope("late_in_employee_count",
			        (Integer) dashBoradMap.get("LATE_IN_EMPLOYEE_COUNT"));
			requestScope("early_out_employee_count",
			        (Integer) dashBoradMap.get("EARLY_OUT_EMPLOYEE_COUNT"));
		}
		
		DashboardDisplayBusinessService businessService = new DashboardDisplayBusinessService();
		List<LocationDashboardReportDTO> locationDashboardDtoList = businessService
		        .getCurrentLocationDashboardDtoList(locations);
		
		requestScope("locationDashboardDtoList", locationDashboardDtoList);
		
		List<LocationDashboardReportDTO> locationDashboardDtoList1 = businessService
		        .getYesterdaysLocationDashboardDtoList(locations);
		requestScope("locationDashboardDtoList1", locationDashboardDtoList1);
				SimpleDateFormat _sdf = new SimpleDateFormat("MMM-dd-yyyy");
		String currentDate = _sdf.format(cal.getTime());
		cal.add(Calendar.DATE, -1);
		String yesterdayDate = _sdf.format(cal.getTime());
		requestScope("today", currentDate);
		requestScope("yesterday", yesterdayDate);
		
		showHeader = true;
		pageHeader = "page.dashboard";
		return forward("homeIndex.jsp");
	}
	
}
