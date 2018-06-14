/**
 * 
 */
package com.adviteya.controller.humancapital;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.ModelMeta;

import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_NatureOfCompany;
import com.adviteya.model.MA_State;
import com.adviteya.model.MA_UserProfile;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.service.EntityService;
import com.adviteya.service.LookUpEntityService;
import com.google.appengine.api.datastore.Entity;

/**
 * @author Dheeraj
 * 
 */
public class CreateLookUpEntityController extends Controller
{
	
	private static Logger logger  = Logger.getLogger(CreateLookUpEntityController.class
	                                      .getName());
	
	private EntityService service = EntityService.getInstance();
	
	@Override
	protected Navigation run() throws Exception
	{
		
		List<Entity> entities = null;
		
		String action = (String) request.getAttribute("action");
		String entityType = (String) request.getAttribute("selectedEntityType");
		String entityData = (String) request.getAttribute("entityData");
		
		if (action != null)
		{
			action = action.toUpperCase();
		}
		
		logger.log(Level.INFO, action + "---" + entityType);
		
		Validators v = new Validators(request);
		v.add("action", v.required());
		
		if (v.validate())
		{
			if (!entityType.equalsIgnoreCase("Select a Entity"))
			{
				requestScope("entityType", entityType);
				if (action.equals("READ"))
				{
					v.add("selectedEntityType", v.required());
					if (v.validate())
					{
						entities = readEntity(entityType);
					}
					
				} else if (action.equals("ADDENTITY"))
				{
					v.add("entityData", v.required());
					if (v.validate())
					{
						entities = addEntities(entityType, entityData);
					}
					
				} else if (action.equals("DELETEENTITY"))
				{
					
					deleteEntity(entityType);
				}
				requestScope("entityList", entities);
			}
		}
		
		return forward("createLookUpEntity.jsp");
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
	 * The input data is semi-colon delmited
	 * 
	 * @param entityType
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private List<Entity> addEntities(String entityType, String entityData)
	        throws InstantiationException, IllegalAccessException,
	        ClassNotFoundException
	{
		
		ArrayList<AbstractEntity> entityList = new ArrayList();
		
		if (entityType.equalsIgnoreCase("MA_Country"))
		{
			StringTokenizer st = new StringTokenizer(entityData, "()");
			while (st.hasMoreTokens())
			{
				String value = (String) st.nextElement();
				MA_Country country = new MA_Country();
				country.setCountryName(value);
				entityList.add(country);
			}
		} else if (entityType.equalsIgnoreCase("MA_State"))
		{
			StringTokenizer st1 = new StringTokenizer(entityData, "()");
			while (st1.hasMoreTokens())
			{
				String value = (String) st1.nextElement();
				StringTokenizer st2 = new StringTokenizer(value, ",");
				MA_State state = new MA_State();
				// Add countryId
				state.getCountryRef().setKey(
				        Datastore.createKey(MA_Country.class,
				                (String) st2.nextElement()));
				state.setStateName((String) st2.nextElement());
				entityList.add(state);
			}
		} else if (entityType.equalsIgnoreCase("MA_UserProfile"))
		{
			StringTokenizer st = new StringTokenizer(entityData, "()");
			while (st.hasMoreTokens())
			{
				String value = (String) st.nextElement();
				MA_UserProfile userProfile = new MA_UserProfile();
				userProfile.setUserProfileDesc(value);
				entityList.add(userProfile);
			}
		} else if (entityType.equalsIgnoreCase("MA_NatureOfCompany"))
		{
			StringTokenizer st = new StringTokenizer(entityData, "()");
			while (st.hasMoreTokens())
			{
				String value = (String) st.nextElement();
				MA_NatureOfCompany natureOfCompany = new MA_NatureOfCompany();
				natureOfCompany.setNatureOfBusinessDesce(value);
				entityList.add(natureOfCompany);
			}
		}
		
		// Universal create method
		LookUpEntityService.createEntities(entityList);
		
		return readEntity(entityType);
		
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
