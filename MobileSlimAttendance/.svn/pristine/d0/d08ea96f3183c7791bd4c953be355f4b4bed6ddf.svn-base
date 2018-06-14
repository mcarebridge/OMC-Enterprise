package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Company;
import com.adviteya.service.EntityService;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

/**
 * This controller helps in running a cron job manually
 * 
 * @author deejay
 * 
 */
public class CronJobManualPushController extends Controller implements
        IMobileAttendanceConstants
{
	
	@Override
	public Navigation run() throws Exception
	{
		
		String action = requestScope("actionParam");
		String companyId = requestScope("companyId");
		String dateOfRun = requestScope("currentDate");
		String processName = requestScope("processName");
		
		if (action != null)
		{
			Object args[] = null;
			// @todo : extract all the parameter and add them in the request and
			// invoke queue
			// Invoke the queue
			// start
			TaskOptions _t = TaskOptions.Builder
			        .withUrl("/humancapital/cronJobScheduler");
			_t.param("companyId", companyId);
			_t.param("dateOfRun", dateOfRun);
			_t.param("action", processName);
			_t.param("runMode", "manual");
			Queue queue = QueueFactory.getQueue("omc-scheduled-job");
			queue.add(_t);
			// end
			return null;
		} else
		{
			EntityService service = EntityService.getInstance();
			
			List<MA_Company> companyList = service.getAllActiveCompanyList();
			List<String> companyIds = new ArrayList<String>();
			for (MA_Company c : companyList)
			{
				companyIds.add(new Long(c.getKey().getId()).toString());
			}
			requestScope("companyIds", companyIds);
			;
			
			return forward("cronJobManualPush.jsp");
		}
		
	}
}
