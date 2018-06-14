package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.DateUtil;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_ContractorCompany;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_TemplateSkill;
import com.adviteya.service.CompanyBusinessService;
import com.adviteya.service.EmployeeService;
import com.adviteya.service.EntityService;
import com.adviteya.service.ICompanyBusinessService;
import com.adviteya.service.IEmployeeService;

public class EditEmployeeController extends BaseController
{
	
	private static Logger           logger                 = Logger.getLogger(EditEmployeeController.class
	                                                               .getName());
	private EntityService           service                = EntityService
	                                                               .getInstance();
	// private EntityService service = null;
	private IEmployeeService        businessService        = new EmployeeService();
	
	private ICompanyBusinessService companyBusinessService = new CompanyBusinessService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		logger.log(Level.INFO, "Start executeLogic");
		String action = requestScope("actionParam");
		String selectedEmpoyeeId = requestScope("inactiveEmployeeId");
		
		long companyId = sessionScope("companyId");
		
		logger.log(Level.INFO, "Company id= " + companyId);
		logger.log(Level.INFO, "action= " + action);
		
		requestScope("parentCompanyId", companyId);
		
		List<MA_TemplateSkill> skillList = service
		        .getCompanySkillList(companyId);
		requestScope("skillList", skillList);
		List<String> cities = businessService.getUniqueCityNames(companyId);
		if ("editEmployee".equals(action))
		{
			
			String _empCompanyEmpId = requestScope("_empCompanyEmpId");
			
			String empCompanyId = requestScope("empCompanyId");
			
			logger.log(Level.INFO, "_empCompanyEmpId= " + _empCompanyEmpId);
			logger.log(Level.INFO, "empCompanyId= " + empCompanyId);
			MA_Employee employee = businessService.getEmployeeObject(
			        Long.valueOf(empCompanyId), _empCompanyEmpId);
			
			requestScope("startDate",
			        DateUtil.toString(employee.getStartDate(), "MM/dd/yyyy"));
			requestScope("companyEmpId", employee.getCompanyEmpId());
			requestScope("employeeType", employee.getEmployeeType());
			requestScope("skill", employee.getSkillRef().getKey().getId());
			requestScope("salutation", employee.getSalutation());
			requestScope("firstName", employee.getFirstName());
			requestScope("lastName", employee.getLastName());
			String city = employee.getCity() == null ? "-" : employee.getCity();
			requestScope("city", city);
			
			requestScope("cities", cities);
			requestScope("gender", employee.getGender());
			requestScope("minWorkingHrsPerDay",
			        employee.getMinWorkingHrsPerDay());
			requestScope("numOfWorkingDays", employee.getNumOfWorkingDays());
			requestScope("dayOfWeeklyOffStr", employee.getDayOfWeeklyOff());
			requestScope("imeiCode", employee.getImeiCode());
			requestScope("isManager", "N");
			requestScope("emailId", employee.getEmailId());
			String superVisor = employee.getIsSuperwiser();
			if (null == superVisor)
			{
				superVisor = "N";
			}else if(superVisor.equals("M"))
			{
				superVisor="N";
				requestScope("isManager","Y");
			}
			requestScope("isSuperwiser", superVisor);
			requestScope("dayOfWeeklyOffStr", employee.getDayOfWeeklyOff());
			requestScope("companyId", empCompanyId);
			return forward("editEmployee.jsp");
			
		} else if ("inactivateEmployee".equals(action))
		{
			String delims = "[,]";
			String[] inactivateEmployeeId = selectedEmpoyeeId.split(delims);
			int length = inactivateEmployeeId.length;
			int i;
			if (inactivateEmployeeId[0] != "")
			{
				List<MA_Employee> employees = new ArrayList<MA_Employee>();
				for (i = 0; i < length; i++)
				{
					MA_Employee employee = new MA_Employee();
					employee = businessService.getEmployeeObject(companyId,
					        inactivateEmployeeId[i]);
					
					if (employee == null)
					{
						List<MA_ContractorCompany> contractorCompanies = service
						        .getAllContractorForCompany(companyId);
						Iterator<MA_ContractorCompany> itr = contractorCompanies
						        .iterator();
						
						while (itr.hasNext())
						{
							long contractorId = itr.next().getKey().getId();
							if (employee == null)
							{
								employee = businessService.getEmployeeObject(
								        contractorId, inactivateEmployeeId[i]);
							}
						}
					}
					employees.add(employee);
				}
				businessService.inActivateEmployee(employees);
			} else
			{
				Validators v = new Validators(request);
				v.getErrors().put(" ", "Please, select atleast one Check Box");
				showErrBox = true;
				requestScope("showErrBox", showErrBox);
			}
			return forward("employeeList");
		} else
		{
			Validators v = new Validators(request);
			String[] dayOfWeeklyOff = request
			        .getParameterValues("dayOfWeeklyOff");
			if (!validate(v))
			{
				String _empCompanyEmpId = requestScope("companyId");
				requestScope("companyId", _empCompanyEmpId);
				showErrBox = true;
				String weeklyOffStr = "";
				if (null != dayOfWeeklyOff)
				{
					for (int cnt = 0; cnt < dayOfWeeklyOff.length; cnt++)
					{
						if (!weeklyOffStr.equals(""))
						{
							weeklyOffStr = weeklyOffStr + ",";
						}
						weeklyOffStr = weeklyOffStr + dayOfWeeklyOff[cnt];
					}
					requestScope("dayOfWeeklyOffStr", weeklyOffStr);
				}
				
				requestScope("cities", cities);
				return forward("editEmployee.jsp");
			} else
			{				
				String status = businessService.updateEmployee(new RequestMap(
				        request), dayOfWeeklyOff);
				logger.log(Level.INFO, "update Employee status=" + status);
				if (status.equals("failure"))
				{
					v.getErrors()
					        .put(null,
					                "Unexpected Error Occured.Please contact system admin");
					logger.log(Level.INFO,
					        "Unexpected Error Occured.Please contact system admin");
				}				
				return forward("employeeList");
			}			
		}		
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		
		logger.log(Level.INFO, "Start Validate");
		long companyId1=sessionScope("companyId");
		
		v.add("startDate", v.required());
		v.add("companyEmpId", v.required());
		v.add("employeeType", v.required());
		v.add("skill", v.required());
		v.add("city", v.required());
		v.add("firstName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("lastName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("gender", v.required());
		// v.add("location", v.required());
		// v.add("shift", v.required());
		// v.add("minWorkingHrsPerDay", v.required());
		v.add("numOfWorkingDays", v.required());
		v.add("dayOfWeeklyOff", v.required());
		
		boolean flag = v.validate();
		
		String numOfWrkDay = request.getParameter("numOfWorkingDays");
		if (null != numOfWrkDay && !numOfWrkDay.trim().equals(""))
		{
			
			int numOfWorkingDays = Integer.valueOf(numOfWrkDay);
			String[] dayOfWeeklyOff = request
			        .getParameterValues("dayOfWeeklyOff");
			
			if (null != dayOfWeeklyOff
			        && dayOfWeeklyOff.length != (7 - numOfWorkingDays))
			{
				v.getErrors()
				        .put("invalid.dayOfWeeklyOff",
				                "No of working days and no of weekly off total  should be 7.");
			}
		}
		
		String isSuperwiser = request.getParameter("isSuperwiser");
		if (null != isSuperwiser && isSuperwiser.equals("Y"))
		{			
			v.add("imeiCode", v.required());
			
			/*
			 * if (null == passKey || passKey.trim().equals("")) {
			 * v.getErrors().put("invalid.superwiser.passkey1",
			 * "Passkey is Required."); } if (null == passKeyRetyped ||
			 * passKeyRetyped.trim().equals("")) {
			 * v.getErrors().put("invalid.superwiser.passkey2",
			 * "Retype Passkey is Required."); }
			 */
			
			v.add("imeiCode", v.required());
			String imeiCode = request.getParameter("imeiCode");
			
			if (null != imeiCode && imeiCode.trim().length() > 0
			        && imeiCode.trim().length() != 15)
			{
				v.getErrors().put("invalid.superwiser.imeicode",
				        "Invalid IMEI code");
			}
		}
		
		String isManager = request.getParameter("isManager");
		if (null != isManager && isManager.equals("Y"))
		{
			v.add("emailId", v.required(),v.regexp(
			        "^[\\w\\.-]+@([\\w\\-]+\\.)+[aA-zZ]{2,3}$",
			        "Improper email address. Accepted formats abcabc@pqr.com"));					
		}
		String companyEmpId = requestScope("companyEmpId");
		String emailId = requestScope("emailId");
		
		if(businessService.isManagerEmailIdUnique(companyId1,emailId,companyEmpId))
		{
			v.getErrors().put("invalid_emailId",
			        "Manager Email Id is already exist.");			
		}
		
		v.validate();
		if (v.getErrors().size() > 0)
		{
			logger.log(Level.INFO, "No of Errors=" + v.getErrors().size());
			return false;
		}
		logger.log(Level.INFO, "End Validate");
		return flag;
	}
	
}
