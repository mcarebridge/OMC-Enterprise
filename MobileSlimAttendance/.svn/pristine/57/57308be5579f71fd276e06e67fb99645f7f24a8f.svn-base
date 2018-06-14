package com.adviteya.controller.humancapital;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.datastore.ModelMeta;
import org.slim3.util.TimeZoneLocator;

import com.adviteya.datasetup.DataFeedReader;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.TimesheetDAO;
import com.adviteya.service.EntityService;
import com.adviteya.service.LookUpEntityService;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class TestDataController extends Controller
{
	
	private static Logger logger        = Logger.getLogger(TestDataController.class
	                                            .getName());
	
	private EntityService service       = EntityService.getInstance();
	private StringBuffer  errReport     = new StringBuffer(
	                                            "Check file location for : <br> ");
	
	private String        entityTypes[] = new String[] {
	        // Transactional entities
	        // "MA_Timesheet", "MA_Assignment", "MA_Shift", "MA_Location",
	        // "MA_Address", "MA_Employee", "MA_ConsolidatedTimesheet",
	        // "MA_DashboardData", "MA_User",
	        // "MA_Company",
	        // Look Up Values
	        "MA_Country", "MA_State", "MA_Holiday", "MA_NatureOfCompany",
	        "MA_UserProfile", "MA_TemplateSkill", "MA_Template",
	        "MA_TimeSheetRule"
	                                    // "MA_Department"
	                                    };
	
	private String        fileLocation  = "";
	
	@Override
	protected Navigation run() throws Exception
	{
		String action = (String) request.getAttribute("action");
		String entityType = (String) request.getAttribute("selectedEntityType");
		String entityData = (String) request.getAttribute("entityData");
		String clientTimeZone = (String) request.getAttribute("clientTimeZone");
		fileLocation = (String) request.getAttribute("fileLocation");
		
		List<Entity> entities = null;
		
		if (action != null)
		{
			action = action.toUpperCase();
		}
		
		logger.log(Level.INFO, action + "---" + entityType + "--- "
		        + fileLocation + "--" + clientTimeZone);
		
		Validators v = new Validators(request);
		v.add("action", v.required());
		v.add("fileLocation", v.required());
		
		Validators read = new Validators(request);
		read.add("action", read.required());
		
		if (v.validate())
		{
			if (!entityType.equalsIgnoreCase("Select a Entity"))
			{
				requestScope("entityType", entityType);
				// ADD A ENTITY
				if (action.equals("ADDENTITY"))
				{
					String _e[] = new String[] { entityType };
					addEntity(_e);
				}
				// DELETE A ENTITY
				else if (action.equals("DELETEENTITY"))
				{
					deleteEntity(entityType);
				}
			}// end-if
			
		}
		
		if (read.validate())
		{
			if (!entityType.equalsIgnoreCase("Select a Entity"))
			{
				requestScope("entityType", entityType);
				// Read a Entity
				if (action.equals("READ"))
				{
					read.add("selectedEntityType", read.required());
					if (read.validate())
					{
						entities = readEntity(entityType);
					}
				}
			}
			
			if (action.equals("ADDENTITIES"))
			{
				addEntity(entityTypes);
			} else if (action.equals("DELETEENTITIES"))
			{
				cleanAll();
			}
		}
		
		requestScope("errMessage", errReport.toString());
		requestScope("entityList", entities);
		requestScope("fileLocation", fileLocation);
		requestScope("now", new Date());
		
		TimeZone tz = TimeZone.getDefault();
		
		if (clientTimeZone != null)
		{
			tz = TimeZone.getTimeZone(clientTimeZone);
		}
		
		TimeZoneLocator.set(tz);
		requestScope("timeZone", TimeZoneLocator.get());
		return forward("createLookUpEntity.jsp");
	}
	
	/**
	 * 
	 * @param entityType
	 */
	private void addEntity(String[] entityType) throws Exception
	{
		// Add all
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		DataFeedReader dfr = new DataFeedReader();
		AbstractEntityDAO.setGtx(gtx);
		String testDataFilepath = fileLocation;
		
		// Start the seq from the lookup entity to transactional entities
		int i = entityType.length - 1;
		
		while (i >= 0)
		{
			
			StringBuffer sb = new StringBuffer(
			        testDataFilepath.concat(entityType[i].concat(".csv")));
			File f = new File(sb.toString());
			
			if (!f.exists())
			{
				errReport.append(entityType[i].concat(".csv") + "<br>");
			}
			
			// if(entityType[i].equalsIgnoreCase("MA_Timesheet_In") |
			// entityType[i].equalsIgnoreCase("MA_Timesheet_Out")){
			// entityType[i] = "MA_Timesheet";
			// }
			
			List entityList = dfr.loadFileDataToEntity(sb.toString(),
			        entityType[i]);
			
			logger.log(Level.INFO, entityList.size() + "---" + entityType[i]);
			
			addEntities(entityList);
			i--;
		}
		
		gtx.commit();
		
	}
	
	/**
	 * 
	 * @param entityList
	 */
	private void addTimesheets(List entityList)
	{
		// TODO Auto-generated method stub
		TimesheetDAO timeDAO = new TimesheetDAO();
		timeDAO.addTimesheets(entityList, null);
		
	}
	
	private List<Key> addEntities(List entityList)
	{
		
		return AbstractEntityDAO.addModels(entityList);
	}
	
	/**
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	
	private void cleanAll() throws InstantiationException,
	        IllegalAccessException, ClassNotFoundException
	{
		
		for (int i = 0; i < entityTypes.length; i++)
		{
			logger.log(Level.INFO, "-----Inside cleanAll --" + entityTypes[i]);
			String metaName = "com.adviteya.meta." + entityTypes[i] + "Meta";
			Object o = Class.forName(metaName).newInstance();
			ModelMeta md = (ModelMeta) o;
			LookUpEntityService.deleteAllEntities(md);
			
		}
	}
	
	/**
	 * 
	 * @param entityType
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private List<Entity> readEntity(String entityType)
	        throws InstantiationException, IllegalAccessException,
	        ClassNotFoundException
	{
		
		List<Entity> entities = null;
		String metaName = "com.adviteya.meta." + entityType + "Meta";
		Object o = Class.forName(metaName).newInstance();
		ModelMeta md = (ModelMeta) o;
		entities = AbstractEntityDAO.getAllModels(md);
		return entities;
	}
	
	/**
	 * Delete all
	 * 
	 * @param entityType
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	private void deleteEntity(String entityType) throws InstantiationException,
	        IllegalAccessException, ClassNotFoundException
	{
		
		String metaName = "com.adviteya.meta." + entityType + "Meta";
		Object o = Class.forName(metaName).newInstance();
		ModelMeta md = (ModelMeta) o;
		LookUpEntityService.deleteAllEntities(md);
	}
	
}
