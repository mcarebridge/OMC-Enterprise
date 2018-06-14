package com.adviteya.remote;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.datasetup.DataFeedReader;
import com.adviteya.model.MA_Address;
import com.adviteya.model.MA_AlertType;
import com.adviteya.model.MA_ApplicationTemplate;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_Department;
import com.adviteya.model.MA_EmailTemplate;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Holiday;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_NatureOfCompany;
import com.adviteya.model.MA_ServerConfiguration;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_State;
import com.adviteya.model.MA_Template;
import com.adviteya.model.MA_TemplateSkill;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.model.MA_User;
import com.adviteya.model.MA_UserProfile;
import com.adviteya.model.MA_WeeklyEffortReport;
import com.adviteya.persistence.AbstractEntityDAO;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class HCRemoteAPITest
{
	
	private String       entityTypes[] = new String[] {
	                                   
	                                   // Transactional entities
	                                   // "MA_WeeklyEffortReport",
	                                   // "MA_Timesheet"
	                                   // "MA_Assignment"
	                                   // "MA_Shift",
	                                   // "MA_Location",
	                                   // "MA_Address",
	                                   // "MA_Employee"
	                                   // "MA_ConsolidatedTimesheet",
	                                   // "MA_DashboardData", "MA_User",
	                                   // "MA_Company",
	                                   // "MA_Department"
	                                   // "MA_TemplateSkill"
	                                   // Look up entities
//	                                   "MA_AlertType",
//	                                    "MA_ApplicationTemplate",
//	                                   "MA_EmailTemplate",
//	                                    "MA_ServerConfiguration",
//	                                    "MA_Country",
	                                    "MA_State"
//	                                    "MA_Holiday",
//	                                    "MA_NatureOfCompany",
//	                                    "MA_UserProfile",
//	                                    "MA_TemplateSkill",
//	                                    "MA_Template",
//	                                    "MA_TimeSheetRule"	                                   
	                                   };
	
	// change the path based on your project setting
	private String       fileLocation  = "testdata/";
	private StringBuffer errReport     = new StringBuffer(
	                                           "Check file location for : <br> ");
	
	public static void main(String[] args) throws IOException
	{
//		RemoteApiOptions options = new RemoteApiOptions().server(
//		        "omcqa1.appspot.com", 443).credentials(
//		        "ppatil@onemastercontrol.com", "XXXXXXXXX");
//		
		 RemoteApiOptions options = new RemoteApiOptions().server("localhost",
		 80).credentials("", "");
		
		RemoteApiInstaller installer = new RemoteApiInstaller();
		installer.install(options);
		try
		{
			HCRemoteAPITest hc = new HCRemoteAPITest();
			hc.addEntity(hc.entityTypes);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			installer.uninstall();
		}
	}
	
	/**
	 * 
	 * @param entityType
	 */
	private void addEntity(String[] entityType) throws Exception
	{
		// Add all
		// GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		DataFeedReader dfr = new DataFeedReader();
		// AbstractEntityDAO.setGtx(gtx);
		String testDataFilepath = fileLocation;
		
		// Start the seq from the lookup entity to transactional entities
		int i = entityType.length - 1;
		
		while (i >= 0)
		{
			String entityTypeName = entityType[i];
			System.out.println("Processing >>>> " + entityTypeName);
			
			StringBuffer sb = new StringBuffer(
			        testDataFilepath.concat(entityType[i].concat(".csv")));
			
			File f = new File(sb.toString());
			
			if (!f.exists())
			{
				errReport.append(entityType[i].concat(".csv") + "<br>");
			}
			
			List entityList = dfr.loadFileDataToEntity(sb.toString(),
			        entityType[i]);
			
			// addEntities(entityList);
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			
			// MA_AssignmentMeta _meta = new MA_AssignmentMeta();
			// AbstractEntityDAO.deleteAll(_meta);
			// gtx.commit();
			
			for (Iterator iterator = entityList.iterator(); iterator.hasNext();)
			{
				gtx = Datastore.beginGlobalTransaction();
				AbstractEntityDAO.setGtx(gtx);
				
				if (entityTypeName.equalsIgnoreCase("MA_Address"))
				{
					MA_Address obj = (MA_Address) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Assignment"))
				{
					MA_Assignment obj = (MA_Assignment) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Company"))
				{
					MA_Company obj = (MA_Company) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Country"))
				{
					MA_Country obj = (MA_Country) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Employee"))
				{
					MA_Employee obj = (MA_Employee) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Location"))
				{
					MA_Location obj = (MA_Location) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Holiday"))
				{
					MA_Holiday obj = (MA_Holiday) iterator.next();
					SimpleDateFormat sdf = new SimpleDateFormat(
					        "yyyy.MM.dd G 'at' HH:mm:ss a z");
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName
				        .equalsIgnoreCase("MA_NatureOfCompany"))
				{
					MA_NatureOfCompany obj = (MA_NatureOfCompany) iterator
					        .next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Shift"))
				{
					MA_Shift obj = (MA_Shift) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_State"))
				{
					MA_State obj = (MA_State) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Country"))
				{
					MA_Country obj = (MA_Country) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_User"))
				{
					MA_User obj = (MA_User) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_UserProfile"))
				{
					MA_UserProfile obj = (MA_UserProfile) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Template"))
				{
					MA_Template obj = (MA_Template) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_TemplateSkill"))
				{
					MA_TemplateSkill obj = (MA_TemplateSkill) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_TimeSheetRule"))
				{
					MA_TimeSheetRule obj = (MA_TimeSheetRule) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Timesheet"))
				{
					MA_Timesheet obj = (MA_Timesheet) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_Department"))
				{
					MA_Department obj = (MA_Department) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName.equalsIgnoreCase("MA_EmailTemplate"))
				{
					MA_EmailTemplate obj = (MA_EmailTemplate) iterator.next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName
				        .equalsIgnoreCase("MA_ApplicationTemplate"))
				{
					MA_ApplicationTemplate obj = (MA_ApplicationTemplate) iterator
					        .next();
					AbstractEntityDAO.addModel(obj);
					
				} else if (entityTypeName
				        .equalsIgnoreCase("MA_WeeklyEffortReport"))
				{
					MA_WeeklyEffortReport obj = (MA_WeeklyEffortReport) iterator
					        .next();
					AbstractEntityDAO.addModel(obj);
				} else if (entityTypeName.equalsIgnoreCase("MA_AlertType"))
				{
					MA_AlertType obj = (MA_AlertType) iterator.next();
					AbstractEntityDAO.addModel(obj);
				} else if (entityTypeName
				        .equalsIgnoreCase("MA_ServerConfiguration"))
				{
					MA_ServerConfiguration obj = (MA_ServerConfiguration) iterator
					        .next();
					AbstractEntityDAO.addModel(obj);
				}
				gtx.commit();
			}
			
			i--;
			// gtx.commit();
		}
		
		// gtx.commit();
		
	}
	
	/**
	 * 
	 * @param entityList
	 * @return
	 */
	private List<Key> addEntities(List entityList)
	{
		
		return AbstractEntityDAO.addModels(entityList);
	}
	
}
