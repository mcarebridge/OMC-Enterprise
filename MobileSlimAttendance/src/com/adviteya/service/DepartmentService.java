package com.adviteya.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.dto.EmployeeDTO;
import com.adviteya.meta.MA_DepartmentMeta;
import com.adviteya.model.MA_Department;
import com.adviteya.model.MA_Location;
import com.adviteya.persistence.AbstractEntityDAO;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

public class DepartmentService implements IDepartmentService
{
	private static Logger logger        = Logger.getLogger(DepartmentService.class
	                                            .getName());
	private EntityService entityService = EntityService.getInstance();
	
	public String createDepartment(Map<String, Object> input) throws Exception
	{
		logger.log(Level.INFO, "Start createDepartmrnt");
		String status = "failure";
		MA_Location location = new MA_Location();
		Long locationId = Long.valueOf((String) input.get("location"));
		String departmentName = (String) input.get("departmentName");
		logger.log(Level.INFO, "locationId=" + locationId);
		Key k1 = AbstractEntityDAO.createKey(location, locationId);
		location.setKey(k1);
		MA_DepartmentMeta departmentMeta = MA_DepartmentMeta.get();
		MA_Department department = Datastore
		        .query(departmentMeta)
		        .filter(departmentMeta.locationRef.equal(k1),
		                departmentMeta.departmentName.equal(departmentName
		                        .trim())).asSingle();
		
		if (null != department)
		{
			status = "departmentIdExists";
		} else
		{
			logger.log(Level.INFO,
			        "Employee dose not exists.Cretae New Employee");
			String description = (String) input.get("description");
			System.out.println("description=" + description);
			String active = (String) input.get("active");
			department = new MA_Department();
			department.getLocationRef().setModel(location);
			department.setDepartmentName(departmentName);
			department.setDescription(new Text(description));
			department.setActive(active);
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			Key k = AbstractEntityDAO.addModel(department);
			
			gtx.commit();
			
			logger.log(Level.INFO, "Department Key=" + k.getId());
			status = "" + k.getId();
			
		}
		logger.log(Level.INFO, "createDepartment Status-" + status);
		return status;
		
	}
	
	public List<MA_Department> getAllDepartmentOfCompany(long companyId)
	{
		logger.log(Level.INFO, "start getAllEmployeeOfCompany ");
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
		List<MA_Department> departments = new ArrayList<MA_Department>();
		List<MA_Location> locations = entityService
		        .getAllLocationForCompany(companyId);
		Iterator<MA_Location> locationIterator = locations.iterator();
		MA_DepartmentMeta departmentMeta = MA_DepartmentMeta.get();
		while (locationIterator.hasNext())
		{
			MA_Location location = locationIterator.next();
			List<MA_Department> locationDeptList = Datastore
			        .query(departmentMeta)
			        .filter(departmentMeta.locationRef.equal(location.getKey()))
			        .asList();
			departments.addAll(locationDeptList);
		}
		
		logger.log(Level.INFO, "end getAllDepartmentOfCompany size"
		        + departments.size());
		return departments;
		
	}
	
	public String updateDepartment(Map<String, Object> input)
	{
		return null;
	}
}
