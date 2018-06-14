package com.adviteya.remote;

import java.io.IOException;

import org.slim3.datastore.Datastore;

import com.adviteya.meta.MA_WeeklyEffortReportMeta;
import com.adviteya.model.MA_WeeklyEffortReport;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class ReadRemoteEntityTest
{
	public static void main(String[] args) throws IOException
	{
//		RemoteApiOptions options = new RemoteApiOptions().server(
//		        "omcqa1.appspot.com", 443).credentials(
//		        "hrmastercontrol@gmail.com", "mads1912");
		//
		 RemoteApiOptions options =
		 new RemoteApiOptions().server("localhost", 80).credentials("", "");
		
		RemoteApiInstaller installer = new RemoteApiInstaller();
		installer.install(options);
		MA_WeeklyEffortReportMeta reportMeta = new MA_WeeklyEffortReportMeta();
		
		try
		{
			Key _k = Datastore.createKey(MA_WeeklyEffortReport.class, 1000);
			MA_WeeklyEffortReport _report = Datastore.query(reportMeta)
			        .filter(reportMeta.key.equal(_k)).asSingle();
			
			Text _t =  _report.getWeeklyReport();
			
			System.out.println(_t.getValue());
			
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			installer.uninstall();
		}
		
	}
}
