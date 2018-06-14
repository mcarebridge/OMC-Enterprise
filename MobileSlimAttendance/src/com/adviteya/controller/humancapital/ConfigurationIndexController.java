package com.adviteya.controller.humancapital;

import org.slim3.controller.Navigation;

public class ConfigurationIndexController extends BaseController
{
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		pageTitle = "title.configurationIndex";
		pageHeader = "page.configurationIndex";
		return forward("configurationIndex.jsp");
	}
	
}
