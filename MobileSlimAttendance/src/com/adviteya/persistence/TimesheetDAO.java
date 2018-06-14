package com.adviteya.persistence;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.meta.MA_TimesheetMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.model.MA_User;
import com.google.appengine.api.datastore.Key;

public class TimesheetDAO extends AbstractEntityDAO
{
	
	private static Logger logger = Logger.getLogger(TimesheetDAO.class
	                                     .getName());
	
	/**
	 * 
	 * @param models
	 * @return
	 */
	public List<Key> addTimesheets(Iterable<AbstractEntity> models, MA_User user)
	{
		
		Iterator itr = models.iterator();
		Calendar _currentDate = Calendar.getInstance();
		int _currDay = _currentDate.get(Calendar.DATE);
		int _currMonth = _currentDate.get(Calendar.MONTH);
		int _currYear = _currentDate.get(Calendar.YEAR);
		
		while (itr.hasNext())
		{
			MA_Timesheet _ts = (MA_Timesheet) itr.next();
			
			GlobalTransaction gtx = Datastore.beginGlobalTransaction();
			setGtx(gtx);
			
			if (_ts.getKey() == null)
			{
				
				/**
				 * This is possible only in this case if two Admin users has
				 * synched up together and same employee tries to enter twice.
				 * This case when the Admin user will sych up we will have two
				 * current records and mobile will not synch up it will give a
				 * error.
				 * 
				 * To solve this - look for the same empId in Current status. If
				 * exists, do not overwrite it
				 */
				MA_TimesheetMeta timesheetMeta = new MA_TimesheetMeta();
				
				MA_Timesheet _timesheet = Datastore
				        .query(timesheetMeta)
				        .filter(timesheetMeta.assignmentRef.equal(_ts
				                .getAssignmentRef().getModel().getKey()),
				                timesheetMeta.marker.equal("CURRENT"),
				                timesheetMeta.createDay.equal(_currDay),
				                timesheetMeta.createMonth.equal(_currMonth),
				                timesheetMeta.createYear.equal(_currYear))
				        .asSingle();
				
				/**
				 * A timesheet record was initiated from phone-1 and closed from
				 * other. 1. The phone-1 recorded the IN data but hasn't been
				 * able to synch for some reason. So The status is 'current' and
				 * timesheet_id is null. In this case the above condition will
				 * work. 2. But the phone - 2 has already closed the attendance
				 * for that day the attendance for that resource is in status =
				 * UPDATE or PROCESSED. 3. But then also the phone-1 can create
				 * a new record for same person and for the same day
				 */
				
				// MA_Timesheet _timesheet1 = Datastore
				// .query(timesheetMeta)
				// .filter(timesheetMeta.assignmentRef.equal(_ts
				// .getAssignmentRef().getModel().getKey()),
				// timesheetMeta.marker.notEqual("CURRENT"),
				// timesheetMeta.createDay.equal(_currDay),
				// timesheetMeta.createMonth.equal(_currMonth),
				// timesheetMeta.createYear.equal(_currYear))
				// .asSingle();
				
				// Now enter record if any only if the both the conditions are
				// met.
				// This is also debar the resource trying to get back to work
				// after the shift record
				// has been processed
				
				readCounter++;
				
				if (_timesheet == null)
				{
					_ts.setCount(new Integer(0));
					addModel(_ts);
				}
				
			} else
			{
				// if the the same record has been sent again with out time, the
				// do not update db
				
				if (_ts.getOutDateTime() != null)
				{
					
					// If same record with Status UPDATED sent again. Do not
					// update db
					MA_TimesheetMeta timesheetMeta = new MA_TimesheetMeta();
					MA_Timesheet _timesheet = Datastore
					        .query(timesheetMeta)
					        .filter(timesheetMeta.key.equal(_ts.getKey()),
					                timesheetMeta.marker.equal("CURRENT"))
					        .asSingle();
					
					readCounter++;
					
					if (_timesheet != null)
					{
						_timesheet.setUpdatedBy(_ts.getUpdatedBy());
						_timesheet.setOutDateTime(_ts.getOutDateTime());
						_timesheet.setMarker(_ts.getMarker());
						long _diff = _ts.getOutDateTime().getTime()
						        - _timesheet.getInDateTime().getTime();
						logger.log(Level.INFO, "Time diff :" + _diff);
						logger.log(Level.INFO, "Daily effort : "
						        + (_diff / 1000));
						_timesheet.setDailyEffort(new Double(_diff / 1000));
						logger.log(Level.INFO,
						        "addTimesheets : Display updated by : "
						                + _timesheet.getUpdatedBy());
						_timesheet.setGeoPtAccuracyOut(_ts
						        .getGeoPtAccuracyOut());
						_timesheet.setAttendanceCoordinatesOut(_ts
						        .getAttendanceCoordinatesOut());
						addModel(_timesheet);
					}
				}
			}
			
			gtx.commit();
		}
		return null;
	}
	
	/**
	 * 
	 * @param models
	 * @return
	 */
	public List<MA_Timesheet> getParitallyFilledTimesheet(
	        List<MA_Timesheet> timesheet)
	{
		return null;
	}
	
	/**
	 * 
	 * @param models
	 * @return
	 */
	public List<MA_Timesheet> getBlankTimesheet(List<MA_Timesheet> timesheet)
	{
		return null;
	}
}
