package com.adviteya.util;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.adviteya.dto.ShiftDTO;
import com.adviteya.model.MA_ContractorCompany;
import com.adviteya.model.MA_Department;
import com.adviteya.model.MA_State;
import com.adviteya.persistence.TimesheetDAO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

/**
 * @author Shailesh
 * 
 */
public class JSONUtil
{
	
	private static Logger logger = Logger.getLogger(TimesheetDAO.class
	                                     .getName());
	
	public JsonObject convertStaeListToJSON(List<MA_State> stateList)
	{
		JsonObject json = new JsonObject();
		
		try
		{
			if (stateList == null)
			{
				return json;
			}
			// json.put("stateList", "stateList");
			
			JsonArray data = new JsonArray();
			Iterator<MA_State> itr = stateList.iterator();
			while (itr.hasNext())
			{
				MA_State state = itr.next();
				JsonObject jsonState = new JsonObject();
				jsonState.addProperty("stateId", state.getKey().getId());
				jsonState.addProperty("stateName", state.getStateName());
				data.add(jsonState);
			}
			json.add("stateList", data);
			Gson gson = new Gson();
			logger.log(Level.INFO, gson.toJson(stateList));
			
		} catch (JsonIOException jex)
		{
			jex.printStackTrace();
		}
		
		return json;
	}
	
	public JsonObject convertShiftListToJSON(List<ShiftDTO> shiftList)
	{
		
		JsonObject json = new JsonObject();
		
		try
		{
			if (shiftList == null)
			{
				return json;
			}
			// json.put("stateList", "stateList");
			
			JsonArray data = new JsonArray();
			Iterator<ShiftDTO> itr = shiftList.iterator();
			while (itr.hasNext())
			{
				ShiftDTO shift = itr.next();
				logger.log(Level.INFO, "Shift Active=" + shift.getActive());
				if ("ACTIVE".equals(shift.getActive()))
				{
					JsonObject jsonShift = new JsonObject();
					jsonShift.addProperty("shiftId", shift.getShiftId());
					jsonShift.addProperty("shiftName", shift.getShiftName());
					data.add(jsonShift);
				}
			}
			json.add("shiftList", data);
			
		} catch (JsonIOException jex)
		{
			jex.printStackTrace();
		}
		
		return json;
	}
	
	public JsonObject convertContractorListToJSON(
	        List<MA_ContractorCompany> contractorList)
	{
		JsonObject json = new JsonObject();
		
		try
		{
			if (contractorList == null)
			{
				return json;
			}
			
			JsonArray data = new JsonArray();
			Iterator<MA_ContractorCompany> itr = contractorList.iterator();
			while (itr.hasNext())
			{
				MA_ContractorCompany contractor = itr.next();
				JsonObject jsonContractor = new JsonObject();
				jsonContractor.addProperty("contractorId", contractor.getKey()
				        .getId());
				jsonContractor.addProperty("contractorName",
				        contractor.getCompanyName());
				data.add(jsonContractor);
			}
			json.add("contractorList", data);
			
		} catch (JsonIOException jex)
		{
			jex.printStackTrace();
		}
		
		return json;
	}
	
	public JsonObject convertShiftDepartmentListToJSON(
	        List<ShiftDTO> shiftList, List<MA_Department> departmentList)
	{
		
		JsonObject json = new JsonObject();
		
		try
		{
			if (shiftList == null)
			{
				return json;
			}
			// json.put("stateList", "stateList");
			
			JsonArray shiftdata = new JsonArray();
			Iterator<ShiftDTO> itr = shiftList.iterator();
			while (itr.hasNext())
			{
				ShiftDTO shift = itr.next();
				logger.log(Level.INFO, "Shift Active=" + shift.getActive());
				if ("ACTIVE".equals(shift.getActive()))
				{
					JsonObject jsonShift = new JsonObject();
					jsonShift.addProperty("shiftId", shift.getShiftId());
					jsonShift.addProperty("shiftName", shift.getShiftName());
					shiftdata.add(jsonShift);
				}
			}
			json.add("shiftList", shiftdata);
			
			JsonArray departmentdata = new JsonArray();
			Iterator<MA_Department> itr1 = departmentList.iterator();
			while (itr1.hasNext())
			{
				MA_Department department = itr1.next();
				logger.log(Level.INFO,
				        "department Active=" + department.getActive());
				if ("1".equals(department.getActive()))
				{
					JsonObject jsonDept = new JsonObject();
					jsonDept.addProperty("departmentId", department.getKey()
					        .getId());
					jsonDept.addProperty("departmentName",
					        department.getDepartmentName());
					logger.log(
					        Level.INFO,
					        "department id=" + department.getKey().getId()
					                + "   Department Name= "
					                + department.getDepartmentName());
					departmentdata.add(jsonDept);
				}
			}
			json.add("departmentList", departmentdata);
			
		} catch (JsonIOException jex)
		{
			jex.printStackTrace();
			logger.log(Level.FINEST, "Exception is JSON --" + jex.getMessage());
		}
		
		return json;
	}
}
