/**
 * 
 */
package com.adviteya.service;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.datastore.ModelMeta;

import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_State;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.CountryDAO;
import com.adviteya.util.ServiceUtil;
import com.google.appengine.api.datastore.Key;

/**
 * @author Dheeraj
 * 
 */
public class LookUpEntityService
{
	
	/*
	 * @de (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.ILookUpEntityService#createCountries(java.util.List)
	 */
	public static List<Key> createCountries(List<MA_Country> countries)
	{
		List<Key> keys = null;
		CountryDAO countryDAO = (CountryDAO) CountryDAO.newInstance();
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		// Can be abstracted
		AbstractEntity[] countryArray = new AbstractEntity[countries.size()];
		countryArray = countries.toArray(countryArray);
		ArrayList<AbstractEntity> al = ServiceUtil
		        .getModelAbstractList(countryArray);
		countryDAO.setGtx(gtx);
		keys = countryDAO.addModels(al);
		
		gtx.commit();
		return keys;
		
	}
	
	/**
	 * 
	 * @param entities
	 * @return
	 */
	public static List<Key> createEntities(List<AbstractEntity> abstractentities)
	{
		List<Key> keys = null;
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		// Can be abstracted
		AbstractEntityDAO.setGtx(gtx);
		
		AbstractEntity[] entityArray = new AbstractEntity[abstractentities
		        .size()];
		entityArray = abstractentities.toArray(entityArray);
		ArrayList<AbstractEntity> al = ServiceUtil
		        .getModelAbstractList(entityArray);
		
		keys = AbstractEntityDAO.addModels(al);
		
		gtx.commit();
		return keys;
		
	}
	
	/**
	 * 
	 * @param entities
	 * @return
	 */
	public static void deleteAllEntities(ModelMeta modelMeta)
	{
		List<Key> keys = null;
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		// Can be abstracted
		AbstractEntityDAO.setGtx(gtx);
		
		AbstractEntityDAO.deleteAll(modelMeta);
		gtx.commit();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.ILookUpEntityService#createCountry(com.adviteya.
	 * model.MA_Country)
	 */
	public static Key createCountry(MA_Country country)
	{
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		CountryDAO countryDAO = (CountryDAO) CountryDAO.newInstance();
		
		countryDAO.setGtx(gtx);
		Key key = countryDAO.addModel(country);
		
		gtx.commit();
		return key;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.ILookUpEntityService#deleteCountries(java.util.List)
	 */
	public static boolean deleteCountries(List<Key> keys)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.ILookUpEntityService#deleteACountry(com.google.appengine
	 * .api.datastore.Key)
	 */
	public static boolean deleteACountry(Key key)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.ILookUpEntityService#createStates(java.util.List)
	 */
	public static List<Key> createStates(List<MA_State> states)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.ILookUpEntityService#createState(com.adviteya.model
	 * .MA_State)
	 */
	public static Key createState(MA_State state)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.ILookUpEntityService#deleteStates(java.util.List)
	 */
	public static boolean deleteStates(List<Key> keys)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.adviteya.service.ILookUpEntityService#deleteAState(com.google.appengine
	 * .api.datastore.Key)
	 */
	public static boolean deleteAState(Key key)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}
