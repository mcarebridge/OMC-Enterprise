package test.adviteya.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.junit.Test;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Alert;
import com.adviteya.model.MA_EmailTemplate;
import com.adviteya.model.MA_MailMessage;
import com.adviteya.service.AlertService;
import com.adviteya.service.CronJobService;
import com.adviteya.service.OMCEmailCommunicatonService;
import com.adviteya.util.MailUtil;
import com.adviteya.util.ServiceUtil;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class TestTransmitShiftAlert implements IMobileAttendanceConstants
{
	@Test
	public void test()
	{
		//testStringReplace();
		transmitShiftAlert(841303);
		
	}
	
	private void transmitShiftAlert(long alertId)
	{
		RemoteApiOptions options = new RemoteApiOptions().server(
		        "omcqa1.appspot.com", 443).credentials(
		        "ppatil@onemastercontrol.com", "javaru!es");
//		
//		 RemoteApiOptions options = new RemoteApiOptions().server("localhost",
//				 80).credentials("", "");
		RemoteApiInstaller installer = new RemoteApiInstaller();
		try
		{
			installer.install(options);
			
		//	OMCEmailCommunicatonService.getInstance().transmitShiftAlert(alertId, "omcdev.appspot.com");
			
			CronJobService.getInstance().executeOMCCommunicator(alertId);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	
		
	}
	
	private void testStringReplace()
	{
		String str="com.adviteya.util.AssignmentHelper hasShiftStarted: *************** Latest Time = 1357379184161 -> 2013.01.05 AD at 09:46:24 UTC---";
		str=str.replace("1357379184161", "000000000");
		System.out.println(str);
		
	}
	
	
}
