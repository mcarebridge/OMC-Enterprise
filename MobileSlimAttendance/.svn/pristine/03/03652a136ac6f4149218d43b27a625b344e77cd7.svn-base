/**
 * 
 */
package com.adviteya.persistence;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.datastore.ModelMeta;

import com.adviteya.model.AbstractEntity;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

/**
 * @author Dheeraj
 * 
 */
public abstract class AbstractEntityDAO
{
	
	private static Logger            logger = Logger.getLogger(AbstractEntityDAO.class
	                                                .getName());
	private static GlobalTransaction gtx;
	public static double             readCounter;
	public static double             writeCounter;
	
	/**
	 * @return the gtx
	 */
	public static GlobalTransaction getGtx()
	{
		return gtx;
	}
	
	/**
	 * @param gtx
	 *            the gtx to set
	 */
	public static void setGtx(GlobalTransaction _gtx)
	{
		gtx = _gtx;
		logger.log(Level.INFO, "-- AbstractEntityDAO Read Counter -- "
		        + readCounter);
		logger.log(Level.INFO, "-- AbstractEntityDAO Write Counter -- "
		        + writeCounter);
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public static Key addModel(AbstractEntity model)
	{
		writeCounter++;
		System.out.println("-- AbstractEntityDAO Write Counter -- "
		        + writeCounter);
		return getGtx().put(model);
	}
	
	/**
	 * 
	 * @param models
	 * @return
	 */
	public static List<Key> addModels(Iterable<AbstractEntity> models)
	{
		List<Key> _keys = null;
		_keys = getGtx().put(models);
		writeCounter += _keys.size();
		System.out.println("-- AbstractEntityDAO Write Counter -- "
		        + writeCounter);
		return _keys;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public static void deleteModel(Key key)
	{
		writeCounter++;
		System.out.println("-- AbstractEntityDAO Write Counter -- "
		        + writeCounter);
		getGtx().delete(key);
	}
	
	/**
	 * 
	 * @param models
	 * @return
	 */
	public static void deleteModel(List<Key> keys)
	{
		writeCounter += keys.size();
		System.out.println("-- AbstractEntityDAO Write Counter -- "
		        + writeCounter);
		getGtx().delete(keys);
	}
	
	/**
	 * 
	 * @param modelMeta
	 */
	public static void deleteAll(ModelMeta modelMeta)
	{
		
		List<Entity> e = getAllModels(modelMeta);
		
		for (Iterator iterator = e.iterator(); iterator.hasNext();)
		{
			writeCounter++;
			AbstractEntity abstractEntity = (AbstractEntity) iterator.next();
			deleteModel(abstractEntity.getKey());
		}
		
		System.out.println("-- AbstractEntityDAO Write Counter -- "
		        + writeCounter);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static Entity getModel(Key key)
	{
		readCounter++;
		System.out.println("-- AbstractEntityDAO Read Counter -- "
		        + readCounter);
		return getGtx().get(key);
	}
	
	/**
	 * 
	 * @param keys
	 * @return
	 */
	public static List<Entity> getModels(List<Key> keys)
	{
		readCounter += keys.size();
		System.out.println("-- AbstractEntityDAO Read Counter -- "
		        + readCounter);
		return getGtx().get(keys);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adviteya.persistence.BaseDAO#getModels(java.util.List)
	 */
	public static List<Entity> getAllModels(ModelMeta mmd)
	{
		List<Entity> _e = null;
		_e = Datastore.query(mmd).asList();
		
		int count = Datastore.query(mmd).count();
		logger.log(Level.INFO, "List Size--" + _e.size() + "    count->"
		        + count);
		readCounter += _e.size();
		System.out.println("-- AbstractEntityDAO Read Counter -- "
		        + readCounter);
		return _e;
	}
	
	/**
	 * 
	 * @param obj
	 * @param id
	 * @return
	 */
	public static Key createKey(Object obj, Long id)
	{
		
		return Datastore.createKey(obj.getClass(), id);
		
	}
}
