package com.adviteya.service;

import java.util.List;
import java.util.Map;

import org.slim3.util.RequestMap;

import com.adviteya.dto.EmployeeDTO;
import com.adviteya.model.MA_Employee;

public interface IEmployeeService
{
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public String createEmployee(Map<String, Object> input,
	        String[] dayOfWeeklyOff) throws Exception;
	
	public List<EmployeeDTO> getAllEmployeeOfCompany(long companyId);
	
	MA_Employee getEmployeeObject(long companyId, String _empCompanyEmpId);
	
	String updateEmployee(Map<String, Object> input, String[] dayOfWeeklyOff);
	
	public List<MA_Employee> searchEmployee(Long companyId,
	        String employeeType, String firstName, String lastName,
	        String startDate, String companyEmpId, String city);
	
	String inActivateEmployee(List<MA_Employee> employee);
	
	public List<String> getUniqueCityNames(Long companyId);

	public boolean isManagerEmailIdUnique(long companyId1, String emailId, String companyEmpId);
}
