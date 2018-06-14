package com.adviteya.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.ShiftDTO;
import com.adviteya.meta.MA_AlertMeta;
import com.adviteya.meta.MA_AlertTriggerLogMeta;
import com.adviteya.meta.MA_AlertTypeMeta;
import com.adviteya.meta.MA_EmployeeMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Alert;
import com.adviteya.model.MA_AlertTriggerLog;
import com.adviteya.model.MA_AlertType;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_MailMessage;
import com.adviteya.model.MA_Shift;
import com.adviteya.persistence.AbstractEntityDAO;
import com.google.appengine.api.datastore.Key;
import com.sun.corba.se.spi.ior.iiop.AlternateIIOPAddressComponent;

public class AlertService implements IMobileAttendanceConstants
{
	
	private Logger logger        = Logger.getLogger(AlertService.class
	                                     .getName());
	EntityService  entityService = EntityService.getInstance();
	
	/**
	 * returns active alert type
	 * 
	 * @return
	 */
	public List<MA_AlertType> getAlertType()
	{
		MA_AlertTypeMeta at = new MA_AlertTypeMeta();
		List<MA_AlertType> alertTypeList = Datastore.query(at)
		        .filter(at.active.equal("Y")).asList();
		return alertTypeList;
		
	}
	
	/**
	 * @param input
	 * @param companyId
	 * @return
	 */
	public boolean createAlert(Map<String, Object> input, long companyId)
	{
		
		logger.log(Level.INFO, "  Start CreateAlert");
		boolean flag = false;
		
		String locationId = (String) input.get("location");
		String alertTypestr = (String) input.get("alertType");
		
		MA_Company company = new MA_Company();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		company.setKey(k);
		
		List<MA_Shift> shiftList = entityService
		        .getAllActiveShifForLocation(Long.valueOf(locationId));
		
		MA_Location location = new MA_Location();
		Key k1 = Datastore.createKey(MA_Location.class,
		        Long.parseLong(locationId));
		location.setKey(k1);
		
		MA_AlertType alertType = new MA_AlertType();
		Key k2 = Datastore.createKey(MA_AlertType.class,
		        Long.parseLong(alertTypestr));
		alertType = Datastore.get(MA_AlertType.class, k2);
		List<AbstractEntity> alertList = new ArrayList<AbstractEntity>();
		
		if (alertType.getDisplayName().equalsIgnoreCase(RESOURCE_STRENGTH))
		{
			int i = 0;
			int tolerance = Integer.parseInt((String) input.get(TOLERANCE));
			for (MA_Shift shift : shiftList)
			{
				if (isAlertExist(location, companyId, alertType, shift))
				{
					MA_Alert alert = new MA_Alert();
					int targetValues = Integer.parseInt((String) input
					        .get(shift.getKey().getId() + "tgtValue"));
					int minValues = Integer.parseInt((String) input.get(shift
					        .getKey().getId() + "min"));
					int maxValues = Integer.parseInt((String) input.get(shift
					        .getKey().getId() + "max"));
					
					if (targetValues != 0)
					{
						long firstManagerId = Long.parseLong((String) input
						        .get(shift.getKey().getId() + "1stManager"));
						long secondManagerId = Long.parseLong((String) input
						        .get(shift.getKey().getId() + "2ndManager"));
						
						MA_Employee firstManager = new MA_Employee();
						Key k3 = Datastore.createKey(MA_Employee.class,
						        firstManagerId);
						firstManager.setKey(k3);
						
						MA_Employee secondManager = new MA_Employee();
						Key k4 = Datastore.createKey(MA_Employee.class,
						        secondManagerId);
						secondManager.setKey(k4);
						
						alert.getFirstLevelManager().setModel(firstManager);
						alert.getSecondLevelManager().setModel(secondManager);
						alert.getAlertTypeRef().setModel(alertType);
						alert.getCompanyref().setModel(company);
						alert.getLocationRef().setModel(location);
						alert.getShiftRef().setModel(shift);
						alert.setTargetValues(targetValues);
						alert.setMinValueForAlert(minValues);
						alert.setMaxValueForAlert(maxValues);
						alert.setToleranceLevelForEscalation(tolerance);
						alert.setActive("Y");
						alertList.add(alert);
					}
					flag = true;
				} else
				{
					flag = flag ? true : false;
				}
				i++;
			}
			
		} else if (alertType.getDisplayName().equalsIgnoreCase(PUNCTUALITY))
		{
			for (MA_Shift shift : shiftList)
			{
				if (isAlertExist(location, companyId, alertType, shift))
				{
					MA_Alert alert = new MA_Alert();
					int tolerance = Integer.parseInt((String) input
					        .get(TOLERANCE1));
					int minValues = Integer.parseInt((String) input
					        .get("minValue"));
					long firstManagerId = Long.parseLong((String) input
					        .get("1stManager"));
					long secondManagerId = Long.parseLong((String) input
					        .get("2ndManager"));
					
					MA_Employee firstManager = new MA_Employee();
					Key k3 = Datastore.createKey(MA_Employee.class,
					        firstManagerId);
					firstManager.setKey(k3);
					
					MA_Employee secondManager = new MA_Employee();
					Key k4 = Datastore.createKey(MA_Employee.class,
					        secondManagerId);
					secondManager.setKey(k4);
					alert.getFirstLevelManager().setModel(firstManager);
					alert.getSecondLevelManager().setModel(secondManager);
					alert.getAlertTypeRef().setModel(alertType);
					alert.getCompanyref().setModel(company);
					alert.setMinValueForAlert(minValues);
					alert.setToleranceLevelForEscalation(tolerance);
					alert.getLocationRef().setModel(location);
					alert.getShiftRef().setModel(shift);
					alert.setActive("Y");
					alertList.add(alert);
					flag = true;
				} else
				{
					flag = false;
				}
			}
			
		} else if (alertType.getDisplayName().equalsIgnoreCase(
		        FEMALE_EMPLOYEE_SECURITY))
		{
			int tolerance = 0;
			int targetValues = 0;
			int minValues = 0;
			int maxValues = 0;
			for (MA_Shift shift : shiftList)
			{
				if (isAlertExist(location, companyId, alertType, shift))
				{
					MA_Alert alert = new MA_Alert();
					
					long firstManagerId = Long.parseLong((String) input
					        .get(shift.getKey().getId() + "1stManager"));
					long secondManagerId = Long.parseLong((String) input
					        .get(shift.getKey().getId() + "2ndManager"));
					
					MA_Employee firstManager = new MA_Employee();
					Key k3 = Datastore.createKey(MA_Employee.class,
					        firstManagerId);
					firstManager.setKey(k3);
					
					MA_Employee secondManager = new MA_Employee();
					Key k4 = Datastore.createKey(MA_Employee.class,
					        secondManagerId);
					secondManager.setKey(k4);
					
					alert.getFirstLevelManager().setModel(firstManager);
					alert.getSecondLevelManager().setModel(secondManager);
					alert.getAlertTypeRef().setModel(alertType);
					alert.getCompanyref().setModel(company);
					alert.getLocationRef().setModel(location);
					alert.getShiftRef().setModel(shift);
					alert.setTargetValues(targetValues);
					alert.setMinValueForAlert(minValues);
					alert.setMaxValueForAlert(maxValues);
					alert.setToleranceLevelForEscalation(tolerance);
					alert.setActive("Y");
					alertList.add(alert);
					
					flag = true;
				} else
				{
					flag = flag ? true : false;
				}
			}
		}
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		AbstractEntityDAO.addModels(alertList);
		gtx.commit();
		return flag;
	}
	
	/**
	 * @param location
	 * @param companyId
	 * @param alertType
	 * @param shift
	 * @return
	 */
	private boolean isAlertExist(MA_Location location, long companyId,
	        MA_AlertType alertType, MA_Shift shift)
	{
		MA_Company company = new MA_Company();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		company.setKey(k);
		
		boolean flag = false;
		MA_AlertMeta a = new MA_AlertMeta();
		MA_Alert alert = Datastore
		        .query(a)
		        .filter(a.companyref.equal(k),
		                a.locationRef.equal(location.getKey()),
		                a.alertTypeRef.equal(alertType.getKey()),
		                a.shiftRef.equal(shift.getKey())).asSingle();
		if (alert == null)
		{
			flag = true;
		}
		return flag;
	}
	
	/**
	 * @param companyId
	 * @return
	 */
	
	public List<MA_Alert> getAlertDTOList(long companyId)
	{
		
		MA_Company company = new MA_Company();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		company.setKey(k);
		
		MA_AlertMeta a = new MA_AlertMeta();
		List<MA_Alert> alertlist = Datastore.query(a)
		        .filter(a.companyref.equal(k)).asList();
		
		return alertlist;
	}
	
	/**
	 * @param input
	 * @param companyId
	 * @param locationId
	 */
	public void updateAlert(Map<String, Object> input, long companyId,
	        Long locationId)
	{
		
		String alertType = (String) input.get("alertType");
		int tolerance = 0;
		int minValues = 0;
		int maxValues = 0;
		int targetValues = 0;
		
		List<MA_Shift> shiftList = entityService
		        .getAllActiveShifForLocation(Long.valueOf(locationId));
		List<AbstractEntity> alertList = new ArrayList<AbstractEntity>();
		if (alertType.equalsIgnoreCase(RESOURCE_STRENGTH))
		{
			
			tolerance = Integer.parseInt((String) input.get(TOLERANCE));
			for (MA_Shift shift : shiftList)
			{
				
				if (input.get(shift.getKey().getId() + "id") != null)
				{
					long alertId = Long.parseLong((String) input.get(shift
					        .getKey().getId() + "id"));
					
					Key k = Datastore.createKey(MA_Alert.class, alertId);
					MA_Alert alert = Datastore.get(MA_Alert.class, k);
					targetValues = Integer.parseInt((String) input.get(shift
					        .getKey().getId() + "tgtValue"));
					minValues = Integer.parseInt((String) input.get(shift
					        .getKey().getId() + "min"));
					maxValues = Integer.parseInt((String) input.get(shift
					        .getKey().getId() + "max"));
					String active = (String) input.get(shift.getKey().getId()
					        + "active");
					long firstManagerId = Long.parseLong((String) input
					        .get(shift.getKey().getId() + "1stManager"));
					long secondManagerId = Long.parseLong((String) input
					        .get(shift.getKey().getId() + "2ndManager"));
					
					MA_Employee firstManager = new MA_Employee();
					Key k3 = Datastore.createKey(MA_Employee.class,
					        firstManagerId);
					firstManager.setKey(k3);
					
					MA_Employee secondManager = new MA_Employee();
					Key k4 = Datastore.createKey(MA_Employee.class,
					        secondManagerId);
					secondManager.setKey(k4);
					alert.getFirstLevelManager().setModel(firstManager);
					alert.getSecondLevelManager().setModel(secondManager);
					alert.setTargetValues(targetValues);
					alert.setMinValueForAlert(minValues);
					alert.setMaxValueForAlert(maxValues);
					alert.setToleranceLevelForEscalation(tolerance);
					alert.setActive(active);
					alertList.add(alert);
				}
			}
		} else if (alertType.equalsIgnoreCase(PUNCTUALITY))
		{
			long alertId = Long.parseLong((String) input.get("alertId"));
			Key k1 = Datastore.createKey(MA_Alert.class, alertId);
			MA_Alert alert = Datastore.get(MA_Alert.class, k1);
			tolerance = Integer.parseInt((String) input.get("toleranceLevel1"));
			
			minValues = Integer.parseInt((String) input.get("minValue"));
			long firstManagerId = Long.parseLong((String) input
			        .get("1stManager"));
			long secondManagerId = Long.parseLong((String) input
			        .get("2ndManager"));
			
			MA_Employee firstManager = new MA_Employee();
			Key k3 = Datastore.createKey(MA_Employee.class, firstManagerId);
			firstManager.setKey(k3);
			
			MA_Employee secondManager = new MA_Employee();
			Key k4 = Datastore.createKey(MA_Employee.class, secondManagerId);
			secondManager.setKey(k4);
			alert.getFirstLevelManager().setModel(firstManager);
			alert.getSecondLevelManager().setModel(secondManager);
			alert.setTargetValues(targetValues);
			alert.setMinValueForAlert(minValues);
			alert.setMaxValueForAlert(maxValues);
			alert.setToleranceLevelForEscalation(tolerance);
			alert.setActive((String) input.get("active"));
			alertList.add(alert);
		} else if (alertType.equalsIgnoreCase(FEMALE_EMPLOYEE_SECURITY))
		{
			for (MA_Shift shift : shiftList)
			{
				if (input.get(shift.getKey().getId() + "id") != null)
				{
					long alertId = Long.parseLong((String) input.get(shift
					        .getKey().getId() + "id"));
					
					Key k = Datastore.createKey(MA_Alert.class, alertId);
					MA_Alert alert = Datastore.get(MA_Alert.class, k);
					
					String active = (String) input.get(shift.getKey().getId()
					        + "active");
					long firstManagerId = Long.parseLong((String) input
					        .get(shift.getKey().getId() + "1stManager"));
					long secondManagerId = Long.parseLong((String) input
					        .get(shift.getKey().getId() + "2ndManager"));
					
					MA_Employee firstManager = new MA_Employee();
					Key k3 = Datastore.createKey(MA_Employee.class,
					        firstManagerId);
					firstManager.setKey(k3);
					
					MA_Employee secondManager = new MA_Employee();
					Key k4 = Datastore.createKey(MA_Employee.class,
					        secondManagerId);
					secondManager.setKey(k4);
					alert.getFirstLevelManager().setModel(firstManager);
					alert.getSecondLevelManager().setModel(secondManager);
					alert.setTargetValues(targetValues);
					alert.setMinValueForAlert(minValues);
					alert.setMaxValueForAlert(maxValues);
					alert.setToleranceLevelForEscalation(tolerance);
					alert.setActive(active);
					alertList.add(alert);
				}
			}
		}
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		AbstractEntityDAO.addModels(alertList);
		gtx.commit();
	}
	
	/**
	 * @param alertId
	 * @param companyId
	 */
	public void inactivateAlertId(String[] alertId, long companyId)
	{
		
		int length = alertId.length;
		int i;
		
		List<AbstractEntity> alertlist = new ArrayList<AbstractEntity>();
		for (i = 0; i < length; i++)
		{
			MA_Alert alert = new MA_Alert();
			Key k = Datastore.createKey(MA_Alert.class,
			        Long.parseLong(alertId[i]));
			alert = Datastore.get(MA_Alert.class, k);
			
			alert.setActive("N");
			
			alertlist.add(alert);
		}
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		AbstractEntityDAO.addModels(alertlist);
		
		gtx.commit();
	}
	
	/**
	 * @param alert
	 * @return
	 */
	public List<MA_Alert> loadAlertForLocation(MA_Alert alert)
	{
		
		MA_Location location = alert.getLocationRef().getModel();
		
		MA_AlertMeta a = new MA_AlertMeta();
		List<MA_Alert> alertList = Datastore
		        .query(a)
		        .filter(a.locationRef.equal(location.getKey()),
		                a.alertTypeRef.equal(alert.getAlertTypeRef().getKey()))
		        .asList();
		
		return alertList;
	}
	
	/**
	 * This method loads all the Alerts for a Shift
	 * 
	 * @param shift
	 * @return
	 */
	public static List<MA_Alert> loadShiftAlerts(MA_Shift shift)
	{
		MA_AlertMeta a = new MA_AlertMeta();
		List<MA_Alert> alertList = Datastore.query(a)
		        .filter(a.shiftRef.equal(shift.getKey())).asList();
		
		return alertList;
	}
	
	/**
	 * 
	 * This method loads all the Alerts used at start of Shift
	 * 
	 * @param shift
	 * @return
	 */
	public static List<MA_Alert> loadShiftStartAlerts(MA_Shift shift)
	{
		MA_AlertMeta a = new MA_AlertMeta();
		List<MA_Alert> alertList = new ArrayList<MA_Alert>();
		MA_Alert alert = getAlertForShift(shift, RESOURCE_STRENGTH);
		if (alert != null)
			alertList.add(alert);
		
		MA_Alert alert1 = getAlertForShift(shift, PUNCTUALITY);
		if (alert1 != null)
			alertList.add(alert1);
		
		return alertList;
		
	}
	
	/**
	 * Analyze if the Shift Alert need to be escalated
	 * 
	 * @param alert
	 */
	public static boolean analyzeShiftAlertForEscalation(MA_Alert alert)
	{
		return false;
	}
	
	/**
	 * 
	 * @param alertId
	 * @return
	 */
	public static MA_Alert loadAlert(long alertId)
	{
		Key alertKey = Datastore.createKey(MA_Alert.class, alertId);
		
		MA_AlertMeta a = new MA_AlertMeta();
		MA_Alert _alert = Datastore.query(a)
		        .filter(a.key.equal(alertKey), a.active.equal("Y")).asSingle();
		if (_alert != null)
		{
			if (_alert.getAlertTypeRef().getModel().getDisplayName()
			        .equalsIgnoreCase(RESOURCE_STRENGTH))
			{
				_alert = AlertBusinessUtil
				        .populateAlertResourceStrength(_alert);
			} else if (_alert.getAlertTypeRef().getModel().getDisplayName()
			        .equalsIgnoreCase(PUNCTUALITY))
			{
				_alert = AlertBusinessUtil.populateAlertPuncuality(_alert);
			} else if (_alert.getAlertTypeRef().getModel().getDisplayName()
			        .equalsIgnoreCase(FEMALE_EMPLOYEE_SECURITY))
			{
				_alert = AlertBusinessUtil
				        .populateAlertFemaleNotCheckedOut(_alert);
			}
		}
		return _alert;
	}
	
	/**
	 * Create a Mail message to be sent
	 * 
	 * @param alert
	 * @param toList
	 * @param ccList
	 * @return
	 */
	public static MA_MailMessage loadAlertMessage(MA_Alert alert,
	        List<MA_Employee> toList, List<MA_Employee> ccList)
	{
		return null;
	}
	
	/**
	 * Fill alert with actual values
	 * 
	 * <pre>
	 * 1. Find alert type
	 * 2. Load alert actual values
	 * </pre>
	 * 
	 * @param _alert
	 * @return
	 */
	public static MA_Alert fillAlertWithActualValues(MA_Alert _alert)
	{
		
		return null;
	}
	
	/**
	 * @param _alert
	 * @return
	 */
	public boolean isValidAlert(MA_Alert _alert)
	{
		boolean flag = false;
		Calendar cal = Calendar.getInstance();
		if (_alert.getAlertTypeRef().getModel().getDisplayName()
		        .equalsIgnoreCase(FEMALE_EMPLOYEE_SECURITY))
		{
			cal.add(Calendar.MINUTE, -60);
		} else
		{
			cal.add(Calendar.MINUTE, -30);
		}
		MA_AlertTriggerLog alertTriggerLog = getAlertTriggerLog(_alert, cal);
		
		if (alertTriggerLog == null || !alertTriggerLog.getSecondAlert())
		{
			flag = true;
			
		}
		
		return flag;
	}
	
	/**
	 * @param alert
	 */
	public void setAlertTriggerLog(MA_Alert alert)
	{
		logger.log(Level.INFO, "  Start of setAlertTriggerLog------------->");
		Calendar cal = Calendar.getInstance();
		
		MA_AlertTriggerLog alertTriggerLog = getAlertTriggerLog(alert, cal);
		
		if (alertTriggerLog == null)
		{
			logger.log(Level.INFO, "  in first alert Log edit------------->");
			
			alertTriggerLog = new MA_AlertTriggerLog();
			
			int day = cal.get(Calendar.DATE);
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			
			alertTriggerLog.setCreateDay(day);
			alertTriggerLog.setCreateMonth(month);
			alertTriggerLog.setCreateYear(year);
			
			MA_Shift shift = Datastore.get(MA_Shift.class, alert.getShiftRef()
			        .getKey());
			
			alertTriggerLog.getAlertRef().setModel(alert);
			alertTriggerLog.setFirstAlert(true);
			alertTriggerLog.setSecondAlert(false);
			alertTriggerLog.setFirstAlertTimeStamp(cal.getTime());
			alertTriggerLog.getShiftRef().setModel(shift);
			
		} else if (alertTriggerLog.getFirstAlert())
		{
			if (alertTriggerLog.getSecondAlert() == null
			        || !alertTriggerLog.getSecondAlert())
			{
				logger.log(Level.INFO,
				        "  in second alert Log edit------------->");
				
				alertTriggerLog.setSecondAlert(true);
				alertTriggerLog.setSecondAlertTimeStamp(cal.getTime());
			}
		}
		
		if (alertTriggerLog != null)
		{
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			AbstractEntityDAO.setGtx(gtx);
			AbstractEntityDAO.addModel(alertTriggerLog);
			gtx.commit();
		}
		logger.log(Level.INFO, "  End of setAlertTriggerLog------------->");
	}
	
	/**
	 * @param alert
	 * @param cal
	 * @return
	 */
	private MA_AlertTriggerLog getAlertTriggerLog(MA_Alert alert, Calendar cal)
	{
		
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		
		MA_AlertTriggerLogMeta atl = new MA_AlertTriggerLogMeta();
		
		MA_AlertTriggerLog alertTriggerLog = Datastore
		        .query(atl)
		        .filter(atl.alertRef.equal(alert.getKey()),
		                atl.createDay.equal(day), atl.createMonth.equal(month),
		                atl.createYear.equal(year),
		                atl.shiftRef.equal(alert.getShiftRef().getKey()))
		        .asSingle();
		
		return alertTriggerLog;
		
	}
	
	/**
	 * @param ma_Shift
	 * @param alertName
	 * @return
	 */
	public static MA_Alert getAlertForShift(MA_Shift ma_Shift, String alertName)
	{
		MA_AlertMeta a = new MA_AlertMeta();
		MA_AlertType alertType = getAlertTypeByName(alertName);
		MA_Alert _alert = Datastore
		        .query(a)
		        .filter(a.shiftRef.equal(ma_Shift.getKey()),
		                a.alertTypeRef.equal(alertType.getKey())).asSingle();
		return _alert;
	}
	
	/**
	 * @param name
	 * @return
	 */
	private static MA_AlertType getAlertTypeByName(String name)
	{
		MA_AlertTypeMeta at = new MA_AlertTypeMeta();
		MA_AlertType alertType = Datastore.query(at)
		        .filter(at.active.equal("Y"), at.displayName.equal(name))
		        .asSingle();
		return alertType;
	}
}
