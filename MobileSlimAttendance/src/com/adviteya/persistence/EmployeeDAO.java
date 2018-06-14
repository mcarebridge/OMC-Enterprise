package com.adviteya.persistence;

import com.adviteya.meta.MA_EmployeeMeta;

public class EmployeeDAO extends AbstractEntityDAO
{
	
	private static EmployeeDAO employeeDAO;
	private MA_EmployeeMeta    employeeMeta = new MA_EmployeeMeta();
	
	private EmployeeDAO()
	{
	}
	
	public static EmployeeDAO newInstance()
	{
		
		if (employeeDAO == null)
		{
			
			employeeDAO = new EmployeeDAO();
		}
		return employeeDAO;
	}
	
}
