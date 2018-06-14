package com.adviteya.controller.humancapital;

import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.model.MA_Alert;
import com.adviteya.service.AlertService;

public class ViewAlertController extends BaseController
{
	
	private Logger logger = Logger.getLogger(ViewAlertController.class
	                              .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		pageTitle = "title.viewAlert";
		pageHeader = "page.viewAlert";
		
		AlertService service = new AlertService();
		String action = requestScope("actionParam");
		long companyId = sessionScope("companyId");
		sessionScope("alertList", null);
		List<MA_Alert> alertList = service.getAlertDTOList(companyId);
		requestScope("alertList", alertList);
		
		return forward("viewAlert.jsp");
	}
	
}
