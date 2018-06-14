/**
 * 
 */
package com.adviteya.service;

import java.util.List;

import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_State;
import com.google.appengine.api.datastore.Key;

/**
 * @author Dheeraj
 * 
 */
public interface ILookUpEntityService
{
	
	// Country CRUD
	public List<Key> createCountries(List<MA_Country> contries);
	
	Key createCountry(MA_Country country);
	
	boolean deleteCountries(List<Key> keys);
	
	boolean deleteACountry(Key key);
	
	// State CRUD
	
	List<Key> createStates(List<MA_State> states);
	
	Key createState(MA_State state);
	
	boolean deleteStates(List<Key> keys);
	
	boolean deleteAState(Key key);
	
}
