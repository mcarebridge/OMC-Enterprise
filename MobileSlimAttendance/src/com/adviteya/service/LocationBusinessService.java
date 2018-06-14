package com.adviteya.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.adviteya.dto.LocationDTO;
import com.adviteya.meta.MA_CountryMeta;
import com.adviteya.meta.MA_HolidayMeta;
import com.adviteya.meta.MA_LocationHolidayMeta;
import com.adviteya.meta.MA_LocationMeta;
import com.adviteya.model.MA_Address;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_Holiday;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_LocationHoliday;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_State;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.util.ServiceUtil;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Key;

public class LocationBusinessService implements ILocationBusinessService
{
	private Logger                 logger              = Logger.getLogger(LocationBusinessService.class
	                                                           .getName());
	private EntityService          entityService       = EntityService
	                                                           .getInstance();
	private MA_HolidayMeta         holidayMeta         = new MA_HolidayMeta();
	private MA_LocationMeta        locationMeta        = new MA_LocationMeta();
	private MA_LocationHolidayMeta locationHolidayMeta = new MA_LocationHolidayMeta();
	
	/*
	 * 
	 * @see
	 * com.adviteya.service.IUserBusinessService#createLocation(com.adviteya
	 * .model .MA_Location)
	 */
	public String createLocation(Map<String, Object> input)
	{
		logger.log(Level.INFO, "Inside createLocation");
		String status = "failure";
		MA_Location location = new MA_Location();
		MA_Address address = new MA_Address();
		input.put("active", "Y");
		BeanUtil.copy(input, location);
		BeanUtil.copy(input, address);
		
		String city = (String) input.get("city");
		
		city = city.substring(0, 1).toUpperCase()
		        + (city.length() > 1 ? city.substring(1).toLowerCase() : "");
		address.setCity(city);
		
		MA_Company company = new MA_Company();
		Long companyId = (Long) input.get("companyId");
		Key k1 = AbstractEntityDAO.createKey(company, companyId);
		company.setKey(k1);
		location.getCompanyRef().setModel(company);
		
		ServiceUtil serviceUtil = new ServiceUtil();
		serviceUtil.populateAddressObj(input, address, company);
		
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		Key k = AbstractEntityDAO.addModel(address);
		location.getAddressRef().setModel(address);
		String timeZoneStr = (String) input.get("timezone");
		
		location.setTimeZone(timeZoneStr);
		
		float latitude = Float.valueOf((String) input.get("latitude"));
		float longitude = Float.valueOf((String) input.get("longitude"));
		GeoPt geoPt = new GeoPt(latitude, longitude);
		location.setGeoPoints(geoPt);
		AbstractEntityDAO.addModel(location);
		gtx.commit();
		status = ("" + k.getId()).trim();
		logger.log(Level.INFO, "createLocation Status-" + status);
		return status;
	}
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	public List<LocationDTO> getLocationListForCompany(Long companyId)
	{
		
		logger.log(Level.INFO, "Inside getLocationListForCompany");
		List<LocationDTO> locationDTOList = new ArrayList<LocationDTO>();
		
		List<MA_Location> locationList = entityService
		        .getAllLocationForCompany(companyId);
		MA_CountryMeta countryMeta = MA_CountryMeta.get();
		Iterator itr = locationList.iterator();
		
		while (itr.hasNext())
		{
			
			LocationDTO locationDTO = new LocationDTO();
			MA_Location location = (MA_Location) itr.next();
			locationDTO.setLocationId(location.getKey().getId());
			locationDTO.setLocationName(location.getLocationName());
			String timeZone = location.getTimeZone();
			
			locationDTO.setTimezone(timeZone);
			
			String status = location.getActive();
			if (null != status && status.equals("Y"))
			{
				locationDTO.setStatus("ACTIVE");
				
			} else
			{
				locationDTO.setStatus("INACTIVE");
			}
			
			MA_Address address = location.getAddressRef().refresh();
			locationDTO.setCity(address.getCity());
			locationDTO.setPinCode(address.getPinCode());
			MA_State state = address.getStateRef().refresh();
			locationDTO.setState(state.getStateName());
			
			String countryCode = state.getCountryCode();
			MA_Country country = Datastore.query(countryMeta)
			        .filter(countryMeta.countryCode.equal(countryCode))
			        .asSingle();
			if (null != country)
			{
				locationDTO.setCountryName(country.getCountryName());
			} else
			{
				locationDTO.setCountryName("-");
			}
			
			locationDTOList.add(locationDTO);
			
		}
		
		logger.log(Level.INFO,
		        "Inside getLocationListForCompany no of locations ="
		                + locationDTOList.size());
		return locationDTOList;
		
	}
	
	/**
	 * 
	 * @param locationId
	 * @return
	 */
	public LocationDTO getLocationDetails(Long locationId)
	{
		
		EntityService es = EntityService.getInstance();
		
		LocationDTO locationDTO = new LocationDTO();
		MA_LocationMeta locationMeta = MA_LocationMeta.get();
		Key k = Datastore.createKey(MA_Location.class, locationId);
		
		MA_Location location = Datastore.query(locationMeta)
		        .filter(locationMeta.key.equal(k)).asSingle();
		
		locationDTO.setLocationId(location.getKey().getId());
		locationDTO.setLocationName(location.getLocationName());
		locationDTO.setStatus(location.getActive());
		MA_Address address = location.getAddressRef().refresh();
		locationDTO.setCity(address.getCity());
		locationDTO.setPinCode(address.getPinCode());
		
		locationDTO.setLine1(address.getLine1());
		locationDTO.setLine2(address.getLine2());
		MA_State state = address.getStateRef().refresh();
		locationDTO.setState(state.getStateName());
		locationDTO.setStateId(state.getKey().getId());
		
		MA_Country _country = es.getCountry(state.getCountryCode());
		
		locationDTO.setCountryId(_country.getKey().getId());
		String timeZone = location.getTimeZone();
		
		locationDTO.setTimezone(timeZone);
		if (null != location.getGeoPoints())
		{
			String temp = "" + location.getGeoPoints().getLatitude();
			locationDTO.setLatitude(temp.trim());
			temp = "" + location.getGeoPoints().getLongitude();
			locationDTO.setLongitude(temp.trim());
		}
		
		return locationDTO;
	}
	
	/*
	 * @see
	 * com.adviteya.service.IUserBusinessService#updateLocation(com.adviteya
	 * .model .MA_Location)
	 */
	public String updateLocation(Map<String, Object> input)
	{
		logger.log(Level.INFO, "Inside createLocation");
		String status = "failure";
		MA_LocationMeta locationMeta = MA_LocationMeta.get();
		String locationIdStr = (String) input.get("locationId");
		Long locationId = Long.valueOf(locationIdStr);
		Key k = Datastore.createKey(MA_Location.class, locationId);
		MA_Location location = Datastore.query(locationMeta)
		        .filter(locationMeta.key.equal(k)).asSingle();
		
		MA_Address address = location.getAddressRef().refresh();
		BeanUtil.copy(input, location);
		BeanUtil.copy(input, address);
		MA_Company company = new MA_Company();
		
		Long companyId = (Long) input.get("companyId");
		Key k1 = AbstractEntityDAO.createKey(company, companyId);
		company.setKey(k1);
		location.getCompanyRef().setModel(company);
		
		ServiceUtil serviceUtil = new ServiceUtil();
		serviceUtil.populateAddressObj(input, address, company);
		
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		Key k2 = AbstractEntityDAO.addModel(address);
		location.getAddressRef().setModel(address);
		String timeZoneStr = (String) input.get("timezone");
		// String[] arr = timeZoneStr.split("$");
		location.setTimeZone(timeZoneStr);
		float latitude = Float.valueOf((String) input.get("latitude"));
		float longitude = Float.valueOf((String) input.get("longitude"));
		GeoPt geoPt = new GeoPt(latitude, longitude);
		location.setGeoPoints(geoPt);
		
		AbstractEntityDAO.addModel(location);
		gtx.commit();
		status = ("" + k.getId()).trim();
		logger.log(Level.INFO, "createLocation Status-" + status);
		return status;
	}
	
	/**
	 * Add selected Holidays for a Location
	 */
	public List<Key> addHolidaysForALocation(String[] selectedHolidayIds,
	        Long locationId)
	{
		logger.log(Level.INFO, "Start addHolidaysForALocation ");
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		ArrayList<Key> keys = new ArrayList();
		
		logger.log(Level.INFO, "selectedHolidayIds.length= "
		        + selectedHolidayIds.length);
		for (int i = 0; i < selectedHolidayIds.length; i++)
		{
			if (selectedHolidayIds[i] != null
			        | selectedHolidayIds[i].length() != 0)
			{
				Key _holidayKey = Datastore.createKey(MA_Holiday.class,
				        Long.parseLong(selectedHolidayIds[i]));
				Key _locationKey = Datastore.createKey(MA_Location.class,
				        locationId.longValue());
				
				MA_Holiday _holiday = Datastore.query(holidayMeta)
				        .filter(holidayMeta.key.equal(_holidayKey)).asSingle();
				
				MA_Location _location = Datastore.query(locationMeta)
				        .filter(locationMeta.key.equal(_locationKey))
				        .asSingle();
				
				MA_LocationHoliday _locationHoliday = new MA_LocationHoliday();
				_locationHoliday.getHolidayRef().setModel(_holiday);
				_locationHoliday.getLocationRef().setModel(_location);
				
				Key _k = AbstractEntityDAO.addModel(_locationHoliday);
				keys.add(_k);
				
			}
		}
		gtx.commit();
		logger.log(Level.INFO, "End addHolidaysForALocation ");
		return keys;
	}
	
	/**
	 * This methods retrieves Holidays for a Location based on the country of
	 * the Location
	 */
	public List<MA_LocationHoliday> getLocationHolidays(Long locationId)
	        throws Exception
	{
		logger.log(Level.INFO, "Start getLocationHolidays");
		Key _locationKey = Datastore.createKey(MA_Location.class,
		        locationId.longValue());
		
		List<MA_LocationHoliday> _locHolidayList = Datastore
		        .query(MA_LocationHoliday.class)
		        .filter(locationHolidayMeta.locationRef.equal(_locationKey))
		        .asList();
		logger.log(Level.INFO, "End getLocationHolidays");
		return _locHolidayList;
	}
	
	/**
	 * 
	 * @param locationId
	 * @return
	 */
	public Key createLocationHoliday(Long locationId,
	        MA_LocationHoliday locationHoliday) throws Exception
	{
		
		Key _locationKey = Datastore.createKey(MA_Location.class,
		        locationId.longValue());
		
		MA_Location _location = Datastore.query(locationMeta)
		        .filter(locationMeta.key.equal(_locationKey)).asSingle();
		
		locationHoliday.getLocationRef().setModel(_location);
		
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		Key _key = AbstractEntityDAO.addModel(locationHoliday);
		gtx.commit();
		return _key;
	}
	
	/**
	 * This method checks for Location specific Holiday and if found return name
	 * of the Holiday
	 * 
	 * @param locationId
	 * @param timesheetDate
	 * @return
	 */
	public static String getHolidayDescForDate(Long locationId,
	        Date timesheetDate)
	{
		String _holidayDesc = null;
		MA_LocationHolidayMeta locationHolidayMeta = new MA_LocationHolidayMeta();
		
		Calendar _tDate = Calendar.getInstance();
		_tDate.setTimeInMillis(timesheetDate.getTime());
		_tDate.set(Calendar.HOUR, 0);
		_tDate.set(Calendar.MINUTE, 0);
		_tDate.set(Calendar.SECOND, 0);
		
		timesheetDate = _tDate.getTime();
		
		Key _locationKey = Datastore.createKey(MA_Location.class,
		        locationId.longValue());
		
		List<MA_LocationHoliday> _locHolidayList = Datastore
		        .query(MA_LocationHoliday.class)
		        .filter(locationHolidayMeta.locationRef.equal(_locationKey))
		        .asList();
		
		for (Iterator iterator = _locHolidayList.iterator(); iterator.hasNext();)
		{
			MA_LocationHoliday ma_LocationHoliday = (MA_LocationHoliday) iterator
			        .next();
			
			if (ma_LocationHoliday.getLocationHolidayDate() != null)
			{
				Calendar _d1 = Calendar.getInstance();
				_d1.setTimeInMillis(ma_LocationHoliday.getLocationHolidayDate()
				        .getTime());
				
				if (_tDate.compareTo(_d1) == 0)
				{
					_holidayDesc = ma_LocationHoliday.getLocationHolidayDesc();
					break;
				}
			} else
			{
				Calendar _d1 = Calendar.getInstance();
				_d1.setTimeInMillis(ma_LocationHoliday.getHolidayRef()
				        .getModel().getHolidayDate().getTime());
				
				if (_tDate.compareTo(_d1) == 0)
				{
					_holidayDesc = ma_LocationHoliday.getHolidayRef()
					        .getModel().getHolidayDesc();
					break;
				}
			}
			
		}
		
		return _holidayDesc;
	}
	
	public int getCurrentAssignmentCountofLocation(Long locationId)
	{
		
		int currentAssignmentCount = 0;
		
		List<MA_Shift> shifts = entityService.getAllShifForLocation(locationId);
		
		Iterator<MA_Shift> itr = shifts.iterator();
		
		int count = 0;
		while (itr.hasNext())
		{
			MA_Shift shift = itr.next();
			
			count = entityService.getCurrentAssignmentCountOfShift(shift);
			currentAssignmentCount += count;
			
		}
		
		return currentAssignmentCount;
	}
	
	public static void main(String[] args)
	{
		String passwd = "aaZZa44@ABC";
		String pattern = "((?=.*[0-9])(?=.*[a-z]) (?=.*[A-Z])(?=.*[@#*=])(?=[\\S]+$).{5,10})";
		System.out.println(passwd.matches(pattern));
	}
	
}
