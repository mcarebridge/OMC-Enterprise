package com.adviteya.controller.humancapital;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.util.DateUtil;

import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.service.EntityService;
import com.adviteya.service.MobileServiceConstants;
import com.adviteya.service.TimeSheetBusinessService;
import com.google.appengine.api.datastore.Key;

public class ReportsController extends BaseController
{
	
	private static Logger logger  = Logger.getLogger(ReportsController.class
	                                      .getName());
	
	private EntityService service = EntityService.getInstance();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		try
		{
			String action = requestScope("actionParam");
			String selectedLocation = requestScope("selectedLocation");
			String selectedShift = requestScope("selectedShift");
			String startDate = requestScope("startDate");
			String toDate = requestScope("toDate");
			String dailyConsolidated = requestScope("dailyConsolidated");
			Date _startDate = null;
			Date _toDate = null;
			String reportType = MobileServiceConstants.DAILY_BREAKUP;
			
			logger.log(Level.INFO, startDate + " -- " + toDate + " --- "
			        + dailyConsolidated + " --- " + selectedLocation + "---"
			        + selectedShift);
			
			Long companyId = sessionScope("companyId");
			logger.log(Level.INFO, companyId.toString());
			
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.set(2011, 10, 1);
			end.set(2011, 11, 1);
			
			// DateFormat _dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			
			if (startDate != null && toDate != null)
			{
				_startDate = DateUtil.toDate(startDate, "MM/dd/yyyy");
				_toDate = DateUtil.toDate(toDate, "MM/dd/yyyy");
				if (dailyConsolidated != null
				        && dailyConsolidated.equalsIgnoreCase("on"))
				{
					reportType = MobileServiceConstants.DAILY_CONSOLIDATED;
				}
			}
			
			MA_Company company = new MA_Company();
			Key k = Datastore.createKey(MA_Company.class, companyId);
			company.setKey(k);
			
			// if(action.equals("initialLoad")) {
			if (action == null)
			{
				List<MA_Location> locationList = service
				        .getAllLocationForCompany(companyId);
				sessionScope("locationList", locationList);
			} else
			{
				if (action.equalsIgnoreCase("loadShiftForLocation"))
				{
					if (selectedLocation != null)
					{
						
						List<MA_Shift> shiftList = service
						        .getAllShifForLocation(Long
						                .valueOf(selectedLocation.trim()));
						requestScope("shiftList", shiftList);
					}
				} else if (action.equalsIgnoreCase("loadTimeData"))
				{
					if (selectedLocation != null && selectedShift != null)
					{
						
						Long _locationKey = Long.parseLong(selectedLocation);
						Long _shiftKey = Long.parseLong(selectedShift);
						
						MA_Location _location = new MA_Location();
						Key _lKey = Datastore.createKey(MA_Location.class,
						        _locationKey);
						_location.setKey(_lKey);
						
						MA_Shift _shift = new MA_Shift();
						Key _sKey = Datastore.createKey(MA_Shift.class,
						        _shiftKey);
						_shift.setKey(_sKey);
						
						TimeSheetBusinessService tbs = new TimeSheetBusinessService();
						// TreeMap<Calendar, MA_Company> dailyAttendanceRecord =
						// tbs
						// .getMonthlyTimesheetForCompanyByEmplyoee(
						// company, _startDate, _toDate,
						// _location, _shift, reportType);
						TreeMap<MA_Employee, TreeMap> empAttendanceRecord = null;/*
																				  * tbs
																				  * .
																				  * getMonthlyTimesheetForCompanyByEmplyoee1
																				  * (
																				  * company
																				  * ,
																				  * _startDate
																				  * ,
																				  * _toDate
																				  * ,
																				  * _location
																				  * ,
																				  * _shift
																				  * ,
																				  * reportType
																				  * )
																				  * ;
																				  */
						
						/***************************************************/
						// tbs.testTreeMap(dailyAttendanceRecord);
						/**************************************************/
						List<MA_Shift> shiftList = service
						        .getAllShifForLocation(Long
						                .valueOf(selectedLocation.trim()));
						requestScope("shiftList", shiftList);
						
						requestScope("empAttendanceRecord", empAttendanceRecord);
					}
				}
			}
			
			requestScope("startDate", startDate);
			requestScope("toDate", toDate);
			
		} catch (Exception ex)
		{
			throw ex;
		}
		
		return forward("reports.jsp");
	}
}
