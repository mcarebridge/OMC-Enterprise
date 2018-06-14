package com.adviteya.controller.humancapital;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Navigation;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

public class TestMobileController extends BatchJobBaseController
{
	
	@Override
	public Navigation executeLogic()
	{
		
		try
		{
			String strCallResult = "";
			HttpServletResponse resp = this.response;
			resp.setContentType("text/plain");
			TaskOptions _t = TaskOptions.Builder
			        .withUrl("/humancapital/processAttendanceData");
			_t.param("emailid", "abc@pqr.com");
			Queue queue = QueueFactory.getQueue("omc-attendance-record-input");
			queue.add(_t);
			strCallResult = "Successfully created a Task in the Queue";
			resp.getWriter().println(strCallResult);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
}
