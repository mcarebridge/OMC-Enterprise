/**
 * 
 */
package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.adviteya.dto.ShiftDTO;
import com.adviteya.model.MA_ContractorCompany;
import com.adviteya.model.MA_Department;
import com.adviteya.model.MA_State;
import com.adviteya.service.EntityService;
import com.adviteya.util.JSONUtil;
import com.google.gson.JsonObject;

/**
 * @author Shailesh
 * 
 */
public class JsonRequestController extends Controller
{
	
	private static Logger logger = Logger.getLogger(AddEmployeeController.class
	                                     .getName());
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slim3.controller.Controller#run()
	 */
	@Override
	protected Navigation run() throws Exception
	{
		logger.log(Level.INFO, "Start Json request Controller");
		String action = requestScope("actionParam");
		
		logger.log(Level.INFO, "action= " + action);
		EntityService service = EntityService.getInstance();
		JSONUtil jsonUtil = new JSONUtil();
		if (action.equals("stateListRequest"))
		{
			String countryId = requestScope("countryId");
			
			List<MA_State> stateList = service.getAllStateForCountry(countryId);
			JsonObject json = jsonUtil.convertStaeListToJSON(stateList);
			response.setContentType("text/x-json;charset=UTF-8");
			response.getWriter().write(json.toString());
		} else if (action.equals("shiftListRequest"))
		{
			String locationId = requestScope("locationId");
			String isDepartment = requestScope("isDepartment");
			JsonObject json = null;
			List<ShiftDTO> shiftList = service.getAllShiftDTOForLocation(Long
			        .parseLong(locationId));
			if (null == isDepartment)
			{
				json = jsonUtil.convertShiftListToJSON(shiftList);
			} else
			{
				List<MA_Department> departments = service
				        .getAllDepartmentOfLocation(Long.valueOf(locationId));
				
				json = jsonUtil.convertShiftDepartmentListToJSON(shiftList,
				        departments);
				
			}
			response.setContentType("text/x-json;charset=UTF-8");
			logger.log(Level.INFO, "json string = " + json.toString());
			response.getWriter().write(json.toString());
		} else if (action.equals("contractorListRequest"))
		{
			String companyId = requestScope("companyId");
			List<MA_ContractorCompany> contractorList = service
			        .getAllContractorForCompany(Long.parseLong(companyId));
			JsonObject json = jsonUtil
			        .convertContractorListToJSON(contractorList);
			response.setContentType("text/x-json;charset=UTF-8");
			response.getWriter().write(json.toString());
		}
		return null;
	}
	
}
