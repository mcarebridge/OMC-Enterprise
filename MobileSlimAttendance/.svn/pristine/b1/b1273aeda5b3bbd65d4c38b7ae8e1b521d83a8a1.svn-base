package com.adviteya.persistence;

import java.util.List;

import com.adviteya.model.AbstractEntity;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public interface BaseDAO
{
	
	/**
	 * Use this method to add or update a model
	 * 
	 * @param model
	 * @return
	 */
	Key addModel(AbstractEntity model);
	
	/**
	 * Use this method to add or update a models
	 * 
	 * @param models
	 * @return
	 */
	List<Key> addModels(Iterable<AbstractEntity> models);
	
	/**
	 * 
	 * @param key
	 */
	void deleteModel(Key key);
	
	/**
	 * 
	 * @param keys
	 */
	void deleteModel(List<Key> keys);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	Entity getModel(Key key);
	
	/**
	 * 
	 * @param keys
	 * @return
	 */
	List<Entity> getModels(List<Key> keys);
	
}
