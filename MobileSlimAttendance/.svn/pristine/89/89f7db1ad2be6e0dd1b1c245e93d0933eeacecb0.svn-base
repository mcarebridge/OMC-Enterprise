package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_User;
import com.adviteya.service.CompanyBusinessService;
import com.adviteya.service.DashboardBusinessService;
import com.adviteya.service.EntityService;
import com.adviteya.service.ICompanyBusinessService;
import com.adviteya.service.IUserBusinessService;
import com.adviteya.service.UserBusinessService;

public class ConfirmAdminUserController extends Controller
{
	private IUserBusinessService     userBusinessService    = new UserBusinessService();
	private DashboardBusinessService dashBoardService       = new DashboardBusinessService();
	private ICompanyBusinessService  companyBusinessService = new CompanyBusinessService();
	private EntityService            service                = EntityService
	                                                                .getInstance();
	private String                   pageTitle              = "title.confirmUser";
	
	@Override
	public Navigation run() throws Exception
	{
		Long companyId = Long.valueOf((String) requestScope("companyId"));
		requestScope("pageTitle", pageTitle);
		String password = requestScope("password1");
		
		Validators v = new Validators(request);
		if (!validate(v))
		{
			requestScope("companyId", companyId);
			requestScope("showErrBox", new Boolean(true).toString());
			requestScope("accountVerified", new Boolean(false).toString());
			return forward("confirmAdminUser.jsp");
			
		} else
		{
			
			MA_User _userAuthenticated = userBusinessService.updatePassword(
			        companyId, password);
			
			if (null != _userAuthenticated)
			{
				sessionScope("companyId", companyId);
				sessionScope("companyRef", _userAuthenticated.getCompanyRef());
				sessionScope("currentUser", _userAuthenticated);
				
				List<MA_Location> locations = service
				        .getAllLocationForCompany(companyId);
				sessionScope("locationList", locations);
				
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
				requestScope("location_details",
				        (List) dashBoradMap.get("LOCATION_DEATILS"));
				
				requestScope("no_of_assignemnt",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				
				requestScope(
				        "no_of_not_reported",
				        (Integer) dashBoradMap.get("NO_OF_ASSIGNEMNT")
				                - (Integer) dashBoradMap
				                        .get("REPORTED_EMPLOYEE_COUNT"));
				requestScope("no_of_employee_reported",
				        (Integer) dashBoradMap.get("REPORTED_EMPLOYEE_COUNT"));
				requestScope("late_in_employee_count",
				        (Integer) dashBoradMap.get("LATE_IN_EMPLOYEE_COUNT"));
				requestScope("early_out_employee_count",
				        (Integer) dashBoradMap.get("EARLY_OUT_EMPLOYEE_COUNT"));
				
				String isDepartment = companyBusinessService
				        .getDepartmentRuleOfCompany(companyId);
				sessionScope("isDepartment", isDepartment);
				return forward("home");
			}
		}
		
		return forward("index");
	}
	
	public int checkPasswordStrength(String password)
	{
		int strengthPercentage = 0;
		
		if (null != password && password.trim().length() > 7
		        && password.length() < 13)
		{
			String[] partialRegexChecks = { ".*[a-z]+.*", // lower
			        ".*[A-Z]+.*", // upper
			        ".*[\\d]+.*", // digits
			        ".*[@#$%]+.*" // symbols
			};
			
			if (password.matches(partialRegexChecks[0]))
			{
				strengthPercentage += 50;
			}
			/*
			 * if (password.matches(partialRegexChecks[1])) { strengthPercentage
			 * += 25; }
			 */
			if (password.matches(partialRegexChecks[2]))
			{
				strengthPercentage += 50;
			}
			if (password.matches(partialRegexChecks[3]))
			{
				strengthPercentage += 25;
			}
		}
		return strengthPercentage;
	}
	
	private boolean validate(final Validators v)
	{
		
		String passWord1 = request.getParameter("password1");
		String passWord2 = request.getParameter("password2");
		v.add("password1", v.required());
		v.add("password2", v.required());
		int errorCnt = 0;
		if (null != passWord1 && null != passWord2)
		{
			
			if (!passWord1.equals(passWord2))
			{
				v.getErrors().put("invalid.user.password",
				        "Password and Confirm Password should be same.");
				errorCnt++;
			} else if (passWord1.trim().length() < 8)
			{
				v.getErrors().put("invalid.user.password",
				        "Password length should be atleast 8 characters.");
				errorCnt++;
			} else if (passWord1.trim().length() > 12)
			{
				v.getErrors()
				        .put("invalid.user.password",
				                "Password length should not be more then 12 characters.");
				errorCnt++;
			} else if (!passWord1.matches(".*[\\d]+.*"))
			{
				v.getErrors().put("invalid.user.password",
				        "Password should contain atleast 1 digit.");
				errorCnt++;
			}
		}
		v.validate();
		if (errorCnt > 0)
		{
			return false;
		} else
		{
			return v.validate();
		}
	}
	
}
