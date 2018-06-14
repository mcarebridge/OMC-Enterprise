package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_User;
import com.adviteya.service.EntityService;
import com.adviteya.service.UserBusinessService;

/**
 * 
 * @author Shailesh
 * 
 */
public class CreateContractorCompanyController extends BaseController implements
        IMobileAttendanceConstants
{
	
	/**
	 * Entity Service.
	 */
	private EntityService       service         = EntityService.getInstance();
	private UserBusinessService businessService = new UserBusinessService();
	/**
	 * Logger.
	 */
	private static Logger       logger          = Logger.getLogger(CreateContractorCompanyController.class
	                                                    .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		String action = requestScope("actionParam");
		logger.log(Level.INFO, "Inside CreateContractorCompanyController");
		pageTitle = "title.addContractor";
		pageHeader = "page.addContractor";
		
		Long companyId = sessionScope("companyId");
		// if(action.equals("initialLoad")) {
		if (action == null)
		{
			List<MA_Country> countryList = service.getCounrtyList();
			sessionScope("countryList", countryList);
			requestScope("stateList", new ArrayList());
			
		} else
		{
			Validators v = new Validators(request);
			if (validate(v))
			{
				
				String status = businessService.createContractorCompanyUser(
				        new RequestMap(request), companyId);
				if (status.equals("userExists"))
				{
					v.getErrors().put(null, "User Already exists");
					showErrBox = true;
				} else
				{
					requestScope("createdContractor", "create.contractor");
					requestScope("initialLoad", "true");
				}
				
			} else
			{
				
				requestScope("companyId", companyId);
				showErrBox = true;
			}
			
			//
		}
		List<MA_User> contractorCompanyUsers = businessService
		        .getContractorCompanyUserList(companyId);
		requestScope("contractorComapnyList", contractorCompanyUsers);
		
		return forward("createContractorCompany.jsp");
	}
	
	/**
	 * 
	 * @param v
	 *            Validators
	 * @return boolean
	 */
	private boolean validate(final Validators v)
	{
		
		v.add("companyName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("emplyoeePopulation", v.required(), v.integerType());
		
		v.add("firstName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("lastName", v.required(),
		        v.maxlength(IMobileAttendanceConstants.MAXLENGTH_FIFTY));
		v.add("phone", v.required(), v.longType());
		v.add("cell", v.required(), v.longType());
		v.add("userName", v.required());
		v.add("line1", v.required());
		v.add("city", v.required());
		v.add("country", v.required());
		v.add("state", v.required());
		v.add("pinCode", v.required(), v.integerType());
		
		return v.validate();
	}
	
}
