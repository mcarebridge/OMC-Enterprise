package com.adviteya.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.adviteya.dto.LocationDashboardReportDTO;
import com.adviteya.model.MA_Location;

public class DashboardDisplayBusinessService
{
	DashboardBusinessService businessService = new DashboardBusinessService();
	
	/**
	 * Method returns Todays LocationDashBoardReportDto List
	 * 
	 * @param locations
	 * @return
	 */
	public List<LocationDashboardReportDTO> getCurrentLocationDashboardDtoList(
	        List<MA_Location> locations)
	{
		List<LocationDashboardReportDTO> locationDashboardDtoList = new ArrayList<LocationDashboardReportDTO>();
		
		Iterator<MA_Location> itr = locations.iterator();
		Calendar CurrentCal = Calendar.getInstance();
		
		while (itr.hasNext())
		{
			MA_Location location = itr.next();
			LocationDashboardReportDTO locationDashboardReportDTO = businessService
			        .locationDataCalculator(location.getKey().getId(),
			                CurrentCal);
			
			locationDashboardDtoList.add(locationDashboardReportDTO);
		}
		
		return locationDashboardDtoList;
	}
	
	/**
	 * Method returns YesterDays LocationDashBoardReportDto List
	 * 
	 * @param locations
	 * @return
	 */
	public List<LocationDashboardReportDTO> getYesterdaysLocationDashboardDtoList(
	        List<MA_Location> locations)
	{
		Calendar yesterdaysCal = Calendar.getInstance();
		yesterdaysCal.add(Calendar.DATE, -1);
		List<LocationDashboardReportDTO> locationDashboardDtoList = new ArrayList<LocationDashboardReportDTO>();
		Iterator<MA_Location> itr = locations.iterator();
		
		while (itr.hasNext())
		{
			MA_Location location = itr.next();
			LocationDashboardReportDTO locationDashboardReportDTO = businessService
			        .locationDataCalculator(location.getKey().getId(),
			                yesterdaysCal);
			locationDashboardDtoList.add(locationDashboardReportDTO);
			
		}
		return locationDashboardDtoList;
	}
	
}
