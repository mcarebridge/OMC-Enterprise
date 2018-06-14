package test.adviteya.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.adviteya.dto.PayrollDTO;
import com.adviteya.model.MA_Company;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.service.PayRollBusinessService;
import com.adviteya.util.WeeklyReportUtil;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class TestReadPayrollReport
{
	@Test
	public void testReadPayrollReport() throws IOException
	{
		RemoteApiOptions options = new RemoteApiOptions().server(
		        "omcdev.appspot.com", 443).credentials(
		        "ppatil@onemastercontrol.com", "javaru!es");
		//
		
		RemoteApiInstaller installer = new RemoteApiInstaller();
		installer.install(options);
		
		Calendar _c = Calendar.getInstance();
		_c.set(2012, 10, 1);
		
	//	WeeklyReportUtil.getPayrollCsvString(102051, _c.getTime());
		
		PayRollBusinessService service=new PayRollBusinessService();
		Map<String, Object> input=new Hashtable<String, Object>();
		
		input.put("year", "2012");
		
		service.populateMonthlyPayrollList(input,new Long(102051) );
		
	}
	
}
