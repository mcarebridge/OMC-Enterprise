package com.adviteya.service;

import java.util.List;
import java.util.Map;

import com.adviteya.model.MA_LocationHoliday;
import com.google.appengine.api.datastore.Key;

public interface ILocationBusinessService
{
	
	String createLocation(Map<String, Object> input);
	
	List<Key> addHolidaysForALocation(String[] selectedHolidayIds,
	        Long locationId);
	
	List<MA_LocationHoliday> getLocationHolidays(Long locationId)
	        throws Exception;
	
	Key createLocationHoliday(Long locationId,
	        MA_LocationHoliday locationHoliday) throws Exception;
	
}
