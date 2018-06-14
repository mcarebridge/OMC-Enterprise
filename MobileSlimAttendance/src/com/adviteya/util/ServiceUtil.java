package com.adviteya.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.adviteya.dto.TimeZoneDTO;
import com.adviteya.meta.MA_ServerConfigurationMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Address;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_PhoneNumber;
import com.adviteya.model.MA_ServerConfiguration;
import com.adviteya.model.MA_State;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PhoneNumber;

public class ServiceUtil
{
	
	/**
	 * This method converts array of entity to ArrayList of AbstractEntity
	 * 
	 * @param entityArray
	 * @return
	 */
	public static ArrayList<AbstractEntity> getModelAbstractList(
	        AbstractEntity[] entityArray)
	{
		
		ArrayList<AbstractEntity> al = new ArrayList<AbstractEntity>();
		
		for (int i = 0; i < entityArray.length; i++)
		{
			al.add(entityArray[i]);
		}
		
		return al;
	}
	
	public void copy(Map src, List objList)
	{
		
		Iterator itr = objList.iterator();
		while (itr.hasNext())
		{
			BeanUtil.copy(src, itr.next());
		}
		
	}
	
	public void populateAddressObj(Map<String, Object> input,
	        MA_Address address, MA_Company company)
	{
		
		MA_Country country = new MA_Country();
		MA_State state = new MA_State();
		String countryId = (String) input.get("country");
		String stateId = (String) input.get("state");
		Key countryKey = Datastore.createKey(MA_Country.class,
		        Long.parseLong(countryId));
		country.setKey(countryKey);
		
		Key stateKey = Datastore.createKey(MA_State.class,
		        Long.parseLong(stateId));
		state.setKey(stateKey);
		address.getStateRef().setModel(state);
		
		address.getCompanyRef().setModel(company);
		
		// Populate phone no from request.
		MA_PhoneNumber[] officePhone = new MA_PhoneNumber[2];
		
		if (null != input.get("phone"))
		{
			officePhone[0] = new MA_PhoneNumber();
			officePhone[0].setPhoneNumber(new PhoneNumber((String) input
			        .get("phone")));
			officePhone[0].setPhoneType("phone");
		}
		if (null != input.get("cell"))
		{
			officePhone[1] = new MA_PhoneNumber();
			officePhone[1].setPhoneNumber(new PhoneNumber((String) input
			        .get("cell")));
			officePhone[1].setPhoneType("cell");
		}
		
		address.setOfficePhone(officePhone);
		
	}
	
	public List<TimeZoneDTO> getTimeZoneList()
	{
		
		List<TimeZoneDTO> timeZoneList = new ArrayList<TimeZoneDTO>();
		String[] arr = TimeZone.getAvailableIDs();
		
		String[] ids = TimeZone.getAvailableIDs();
		TimeZone tz = null;
		Date today = new Date();
		
		for (int i = 0; i < ids.length; i++)
		{
			tz = TimeZone.getTimeZone(ids[i]);
			TimeZoneDTO dto = new TimeZoneDTO();
			dto.setDescription(tz.getDisplayName());
			dto.setTimeZoneId(tz.getID());
			if (!timeZoneList.contains(dto))
			{
				
				timeZoneList.add(dto);
			}
			
		}
		
		return timeZoneList;
		
	}
	
	
	/**
	 * 
	 * @param serverConfigKey
	 * @return
	 */
	public static MA_ServerConfiguration getServerConfig(String serverConfigKey)
	{
		MA_ServerConfigurationMeta serverMeta = new MA_ServerConfigurationMeta();
		
		MA_ServerConfiguration _serverConfiguration = Datastore
		        .query(serverMeta)
		        .filter(serverMeta.configKey.equal(serverConfigKey)).asSingle();
		
		return _serverConfiguration;
	}
}
