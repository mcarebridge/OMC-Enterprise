package com.adviteya.controller.humancapital;

import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.service.EntityService;

public class ReportsIndexController extends BaseController
{
	
	private static Logger logger  = Logger.getLogger(ReportsController.class
	                                      .getName());
	
	private EntityService service = EntityService.getInstance();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		pageHeader = "page.reportsHome";
		pageTitle = "title.reportsHome";
		String pageSubHeader1 = "page.report.subHeader1";
		String pageSubHeader2 = "page.report.subHeader2";
		String pageSubHeader3 = "page.report.subHeader3";
		
		requestScope("pageSubHeader1", pageSubHeader1);
		requestScope("pageSubHeader2", pageSubHeader2);
		requestScope("pageSubHeader3", pageSubHeader3);
		
		return forward("reportIndex.jsp");
	}
}
