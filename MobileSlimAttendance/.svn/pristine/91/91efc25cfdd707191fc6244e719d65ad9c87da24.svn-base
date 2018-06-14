package com.adviteya.controller.humancapital;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.Navigation;
import org.slim3.util.DateUtil;

import com.adviteya.dto.AssignmentDTO;
import com.adviteya.model.MA_Department;
import com.adviteya.model.MA_Location;
import com.adviteya.service.AssignmentBusinessService;
import com.adviteya.service.EntityService;
import com.adviteya.service.IAssignmentBusinessService;

public class FutureAssignmentController extends BaseController
{
	
	// private Logger logger =
	// Logger.getLogger(CreateAdminUserController.class);
	private static Logger              logger          = Logger.getLogger(AssignmentController.class
	                                                           .getName());
	
	private EntityService              service         = EntityService
	                                                           .getInstance();
	private IAssignmentBusinessService businessService = AssignmentBusinessService
	                                                           .getInstance();
	
	public Navigation executeLogic() throws Exception
	{
		
		try
		{
			
			pageTitle = "title.addAssignment";
			pageHeader = "page.addAssignment";
			
			DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			df2.setTimeZone(TimeZone.getTimeZone("IST"));
			requestScope("currentDate", df2.format(new Date()));
			
			String action = requestScope("actionParam");
			
			Long companyId = sessionScope("companyId");
			logger.log(Level.INFO, "Company Id-" + companyId);
			
			if (null != action && action.equals("addAssignment"))
			{
				businessService
				        .createUpdateAssignment(populateAssingmentListFromrequest(request));
				
			}
			
			List<MA_Location> locations = service
			        .getAllLocationForCompany(companyId);
			List<AssignmentDTO> assignmentDTOs = service
			        .getAllEmployeeFutureAssignment(companyId);
			List<MA_Department> departments = service
			        .getAllDepartmentOfCompany(companyId);
			// service.displayDbCounters();
			
			sessionScope("locationList", locations);
			sessionScope("departmentList", departments);
			requestScope("assignmentList", assignmentDTOs);
			// return forward("assignment.jsp");
			
		} catch (Exception ex)
		{
			logger.log(Level.FINEST, "Error = " + ex.getMessage());
			throw ex;
		}
		
		return forward("futureAssignment.jsp");
	}
	
	private List<AssignmentDTO> populateAssingmentListFromrequest(
	        HttpServletRequest request)
	{
		
		Map testMap = request.getParameterMap();
		String[] validated = (String[]) testMap.get("validated");
		String[] assignmentIds = (String[]) testMap.get("assignmentId");
		String[] employeeIds = (String[]) testMap.get("employeeId");
		String[] shiftsIds = request.getParameterValues("shiftId");
		String[] startDates = (String[]) testMap.get("startDate");
		String[] endDates = request.getParameterValues("endDate");
		String[] departmentIds = request.getParameterValues("departmentId");
		if (null == departmentIds)
		{
			departmentIds = new String[validated.length];
		}
		List<AssignmentDTO> assignmentDTOs = new ArrayList<AssignmentDTO>();
		
		try
		{
			for (int cnt = 0; cnt < validated.length; cnt++)
			{
				if (validated[cnt].equals("true"))
				{
					System.out.println("departmentIds[cnt]="
					        + departmentIds[cnt]);
					AssignmentDTO assignmentDTO = new AssignmentDTO(
					        Long.valueOf(employeeIds[cnt]),
					        Long.valueOf(shiftsIds[cnt]), DateUtil.toDate(
					                startDates[cnt], "MM/dd/yyyy"),
					        DateUtil.toDate(endDates[cnt] + " 23:59",
					                "MM/dd/yyyy kk:mm"), departmentIds[cnt]);
					if (null != assignmentIds[cnt]
					        && !assignmentIds[cnt].equals(""))
					{
						logger.log(Level.INFO, " Update the assignment no"
						        + assignmentIds[cnt]);
						assignmentDTO.setAssignmentId(Long
						        .valueOf(assignmentIds[cnt]));
					}
					
					assignmentDTOs.add(assignmentDTO);
					
				}
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return assignmentDTOs;
		
	}
	
}
