package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_ContractorCompany;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_TemplateSkill;
import com.adviteya.service.CompanyBusinessService;
import com.adviteya.service.EmployeeService;
import com.adviteya.service.EntityService;
import com.adviteya.service.ICompanyBusinessService;
import com.adviteya.service.IEmployeeService;

public class AddEmployeeController extends BaseController
{
	
	private static Logger           logger                 = Logger.getLogger(AddEmployeeController.class
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
		
		pageTitle = "title.addEmployee";
		pageHeader = "page.addEmployee";
		
		String action = requestScope("actionParam");
		Long companyId = sessionScope("companyId");
		
		logger.log(Level.INFO, "Company id=" + companyId);
		logger.log(Level.INFO, "Action=" + action);
		
		String uniqueIdFlag = companyBusinessService
		        .getUniqueIdRuleOfCompany(companyId);
		requestScope("uniqueIdFlag", uniqueIdFlag);
		
		String contractorUniqueIdFlag = companyBusinessService
		        .getUniqueIdRuleOfContractorCompany(companyId);
		requestScope("contractorUniqueIdFlag", contractorUniqueIdFlag);
		
		List<MA_TemplateSkill> skillList = service
		        .getCompanySkillList(companyId);
		requestScope("skillList", skillList);
		List<String> city = businessService.getUniqueCityNames(companyId);
		
		// if(action.equals("initialLoad")) {
		requestScope("companyId", companyId);
		requestScope("parentCompanyId", companyId);
		
		requestScope("empCompanyId", "" + companyId + "-");
	
		if (action == null || action.equals("updateEmployee"))
		{
			List<MA_Location> locationList = service
			        .getAllLocationForCompany(companyId);
			sessionScope("locationList", locationList);
			super.pageTitle = "title.addEmployee";
			
			requestScope("initialLoad", "true");
			// return forward("addEmployee.jsp");
		} else if (action.equalsIgnoreCase("addEmployee"))
		{
			String[] dayOfWeeklyOff = request
			        .getParameterValues("dayOfWeeklyOff");
			String weeklyOffStr = "";
			String empCompanyId = request.getParameter("empCompanyId");
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
			}
			String employeeType = (String) request.getParameter("employeeType");
			
			Validators v = new Validators(request);
			if (!validate(v))
			{
				requestScope("companyId", companyId);
				requestScope("empCompanyId", empCompanyId);
				showErrBox = true;
				if (null != employeeType && !employeeType.equals("")
				        && employeeType.equals("2"))
				{
					List<MA_ContractorCompany> contractorList = service
					        .getAllContractorForCompany(companyId);
					requestScope("contractorList", contractorList);
				}
				// requestScope("dayOfWeeklyOffStr", weeklyOffStr);
				// return forward("addEmployee.jsp");
			} else
			{
				Map<String, Object> input = new RequestMap(request);
				String status = businessService.createEmployee(input,
				        dayOfWeeklyOff);
				
				logger.log(Level.INFO, "Create Employee status=" + status);
				if (status.equals("failure"))
				{
					requestScope("empCompanyId", empCompanyId);
					if (null != employeeType && !employeeType.equals("")
					        && employeeType.equals("2"))
					{
						List<MA_ContractorCompany> contractorList = service
						        .getAllContractorForCompany(companyId);
						requestScope("contractorList", contractorList);
					}
					v.getErrors()
					        .put("",
					                "Unexpected Error Occured.Please contact system admin");
					logger.log(Level.INFO,
					        "Unexpected Error Occured.Please contact system admin.");
				} else if (status.equals("employeeIdExists"))
				{
					showErrBox = true;
					requestScope("empCompanyId", empCompanyId);
					if (null != employeeType && !employeeType.equals("")
					        && employeeType.equals("2"))
					{
						List<MA_ContractorCompany> contractorList = service
						        .getAllContractorForCompany(companyId);
						requestScope("contractorList", contractorList);
					}
					v.getErrors().put("", "Employee Id already exists.");
					logger.log(Level.INFO, "Employee Id already exists.");
					
				} else
				{
					String isSupervisor = requestScope("isSuperwiser");
					if ("Y".equals(isSupervisor))
					{
						return forward("assignment");
					}
					weeklyOffStr = "";
					requestScope("createdEmployeeId", status);
					requestScope("initialLoad", "true");
				}
				
			}
			requestScope("dayOfWeeklyOffStr", weeklyOffStr);
		} else if (action.equals("backToMain"))
		{
			return forward("employeeIndex");
		}
		logger.log(Level.INFO, "End executeLogic");
		requestScope("city", city);
		return forward("addEmployee.jsp");
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		logger.log(Level.INFO, "Start Validate Method");
		long companyId1=sessionScope("companyId");
		
		v.add("startDate", v.required());
		v.add("city", v.required());
		v.add("employeeType", v.required());
		v.add("skill", v.required());
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
		String numOfWorkingDaysStr = request.getParameter("numOfWorkingDays");
		
		if (null != numOfWorkingDaysStr && !numOfWorkingDaysStr.equals(""))
		{
			
			int numOfWorkingDays = Integer.valueOf(numOfWorkingDaysStr);
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
		
		String uniqueIdFlag = request.getParameter("uniqueIdFlag");
		String employeeType = request.getParameter("employeeType");
		String contractorUniqueidFlag = request
		        .getParameter("contractorUniqueIdFlag");
		
		if (null != employeeType && !employeeType.equals("")
		        && employeeType.equals("2"))
		{
			v.add("contractorCompany", v.required());
		}
		if (uniqueIdFlag.equals("Y") && null != employeeType
		        && !employeeType.equals("") && !employeeType.equals("2"))
		{
			String companyEmpId = request.getParameter("empCompanyId")
			        + request.getParameter("companyEmpId");
			String companyId = request.getParameter("companyId") + "-";// 1001-2345
			
			if (null != companyEmpId)
			{
				if (!companyEmpId.startsWith(companyId))
				{
					
					v.getErrors().put("invalid.employee.id",
					        "Invalid Employee Id.");
				} else if (companyEmpId.indexOf("-") != companyEmpId
				        .lastIndexOf("-")
				        || companyEmpId.lastIndexOf("-") == companyEmpId
				                .length() - 1)
				{
					v.getErrors().put("invalid.employee.id",
					        "Invalid Employee Id.");
					
				}
				
			}
		}
		
		if (contractorUniqueidFlag.equals("Y") && null != employeeType
		        && !employeeType.equals("") && employeeType.equals("2"))
		{
			String companyEmpId = request.getParameter("empCompanyId")
			        + request.getParameter("companyEmpId");
			String companyId = request.getParameter("contractorCompany") + "-";// 1001-2345
			
			if (null != companyEmpId)
			{
				if (!companyEmpId.startsWith(companyId))
				{
					
					v.getErrors().put("invalid.employee.id",
					        "Invalid Employee Id.");
				} else if (companyEmpId.indexOf("-") != companyEmpId
				        .lastIndexOf("-")
				        || companyEmpId.lastIndexOf("-") == companyEmpId
				                .length() - 1)
				{
					v.getErrors().put("invalid.employee.id",
					        "Invalid Employee Id.");
					
				}
				
			}
		}
		
		String isSuperwiser = request.getParameter("isSuperwiser");
		if (null != isSuperwiser && isSuperwiser.equals("Y"))
		{
			v.add("imeiCode", v.required());
			
			String imeiCode = request.getParameter("imeiCode");
			
			if (null != imeiCode && !imeiCode.trim().equals("")
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
		String companyEmpId = request.getParameter("empCompanyId")
		        + request.getParameter("companyEmpId");
		String emailId = requestScope("emailId");
		if(businessService.isManagerEmailIdUnique(companyId1,emailId,companyEmpId))
		{
			v.getErrors().put("invalid_emailId",
			        "Manager Email Id is already exist.");			
		}		
		
		v.validate();
		if (v.getErrors().size() > 0)
		{
			logger.log(Level.INFO, "Error size=" + v.getErrors().size());
			return false;			
		}
		
		logger.log(Level.INFO, "End Validate method");
		return flag;
	}
	
	private boolean validateInput(String employeeType, String searchCriteria,
	        String searchText)
	{
		
		Validators v = new Validators(request);
		
		if (null != employeeType && !employeeType.trim().equals(""))
		{
			
			if (null != searchCriteria && !searchCriteria.trim().equals(""))
			{
				
				if (searchCriteria.equals("companyEmpId"))
				{
					String companyEmpId = searchText;
					
					if (null != companyEmpId && !companyEmpId.trim().equals(""))
					{
						if (companyEmpId.indexOf("-") == -1
						        || companyEmpId.indexOf("-") != companyEmpId
						                .lastIndexOf("-")
						        || companyEmpId.lastIndexOf("-") == companyEmpId
						                .length() - 1)
						{
							v.getErrors().put("invalid.employee.id",
							        "Invalid Employee Id.");
							return false;
							
						}
						
					} else
					{
						v.getErrors().put("search.criteria.required",
						        "Please enter Employee Id.");
						return false;
					}
				} else if (searchCriteria.equals("firstName"))
				{
					
					String firstName = searchText;
					if (null != firstName && !firstName.trim().equals(""))
					{
						if (firstName.trim().length() < 3)
						{
							v.getErrors()
							        .put("firstname.minimum.length",
							                "Please enter atleast first 3 character of First Name.");
							return false;
						}
						
					} else
					{
						v.getErrors().put("search.criteria.required",
						        "Please enter First Name.");
						return false;
					}
				} else if (searchCriteria.equals("lastName"))
				{
					
					String lastName = searchText;
					if (null != lastName && !lastName.trim().equals(""))
					{
						if (lastName.trim().length() < 3)
						{
							v.getErrors()
							        .put("lastname.minimum.length",
							                "Please enter atleast first 3 character of Last Name.");
							return false;
						}
						
					} else
					{
						v.getErrors().put("search.criteria.required",
						        "Please enter Last Name.");
						return false;
					}
				} else if (searchCriteria.equals("startDate"))
				{
					
					String startDate = searchText;
					if (null == startDate || startDate.trim().equals(""))
					{
						v.getErrors().put("search.criteria.required",
						        "Please select start date.");
						return false;
						
					}
				}
				
				return true;
				
			} else
			{
				return true;
			}
			
		} else
		{
			
			v.getErrors().put("search.criteria.required",
			        "Please select at least one of the employee type.");
			return false;
		}
		
	}
	
}
