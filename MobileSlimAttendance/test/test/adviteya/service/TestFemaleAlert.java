package test.adviteya.service;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.adviteya.service.CronJobService;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class TestFemaleAlert {

	@Test
	public void test() {
		testFemeleAlert();
	}

	private void testFemeleAlert() {
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
			
			CronJobService.getInstance().executeOMCCommunicator(891801);
			
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
