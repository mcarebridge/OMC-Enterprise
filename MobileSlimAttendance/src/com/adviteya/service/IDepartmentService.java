package com.adviteya.service;

import java.util.List;
import java.util.Map;

import com.adviteya.model.MA_Department;

public interface IDepartmentService
{
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public String createDepartment(Map<String, Object> input) throws Exception;
	
	public List<MA_Department> getAllDepartmentOfCompany(long companyId);
	
	String updateDepartment(Map<String, Object> input);
}
