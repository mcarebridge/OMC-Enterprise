package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.model.MA_Contract;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_User;
import com.adviteya.service.CompanyBusinessService;
import com.adviteya.service.ContractBusinessService;
import com.adviteya.service.DashboardBusinessService;
import com.adviteya.service.EntityService;
import com.adviteya.service.ICompanyBusinessService;
import com.adviteya.service.UserBusinessService;

public class LoginController extends Controller
{
	private UserBusinessService      businessService        = new UserBusinessService();
	/**
	 * Logger.
	 */
	private static Logger            logger                 = Logger.getLogger(LoginController.class
	                                                                .getName());
	private DashboardBusinessService dashBoardService       = new DashboardBusinessService();
	private ICompanyBusinessService  companyBusinessService = new CompanyBusinessService();
	private EntityService            service                = EntityService
	                                                                .getInstance();
	
	private boolean                  showErrBox             = false;
	private String                   pageTitle              = "title.welcome";
	private String                   pageHeader             = "page.login";
	private String                   systemError            = "system.error";
	
	@Override
	public Navigation run() throws Exception
	{
		try
		{
			
			requestScope("pageTitle", pageTitle);
			requestScope("pageHeader", pageHeader);
			
			logger.log(Level.INFO, "-- Inside Login Controller ---");
			MA_User user = businessService
			        .authenticateUserLogin(new RequestMap(request));
			boolean _userAuthenticated = false;
			MA_Contract  contract=null;
			String _client = request.getParameter("client");
			ContractBusinessService contractService=new ContractBusinessService();
			/**
			 * This method will only authenticate if the request comes from
			 * browser based client
			 */
			if (user != null)
			{
				if (_client.equalsIgnoreCase("browser"))
				{
					if (user.getUserProfileRef().getModel().getProfileType()
					        .equalsIgnoreCase("MGMT"))
					{
						contract=contractService.validateContract(user.getCompanyRef().getKey().getId());
						// Check the account is active
						if (user.getCompanyRef().getModel().getActive()
						        .equalsIgnoreCase("Y"))
						{
							_userAuthenticated = true;
						}
					}
				}
			}
			
			
			
			if (_userAuthenticated)
			{
				Long companyId = user.getCompanyRef().getKey().getId();
				sessionScope("companyId", companyId);
				sessionScope("companyRef", user.getCompanyRef());
				sessionScope("currentUser", user);
				sessionScope("logoFileName", user.getCompanyRef().getModel()
				        .getLogoFileName());
								
				List<MA_Location> locations = service
				        .getAllActiveLocationForCompany(companyId);
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
				
				logger.log(Level.INFO, "--Checking dashboard values --"
				        + dashBoradMap.get("NO_OF_ASSIGNEMNT") + "--"
				        + dashBoradMap.get("ASG_REPORTED_EMPLOYEE_COUNT"));
				
				Integer _asg_not_reported = (Integer) dashBoradMap
				        .get("NO_OF_ASSIGNEMNT")
				        - (Integer) dashBoradMap
				                .get("ASG_REPORTED_EMPLOYEE_COUNT");
				
				logger.log(Level.INFO, "--_asg_not_reported --"
				        + _asg_not_reported);
				
				requestScope("no_of_not_reported", _asg_not_reported);
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
			} else
			{
				Validators v = new Validators(request);
				requestScope("showErrBox", new Boolean(true).toString());
				v.getErrors().put("invalid.credentials",
				        "Invalid Username or password.");
				
				return forward("index.jsp");
			}
			
		} catch (Exception e)
		{
			logger.log(Level.SEVERE, e.getMessage(), e);
			requestScope("pageTitle", "page.error");
			requestScope("systemError", systemError);
			return forward("errorPage.jsp");
		}
		
	}
}
