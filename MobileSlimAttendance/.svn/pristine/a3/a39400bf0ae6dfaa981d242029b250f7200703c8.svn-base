package com.adviteya.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.meta.MA_ShiftMeta;
import com.adviteya.meta.MA_TimesheetMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.model.MA_User;
import com.adviteya.service.EntityService;
import com.adviteya.util.AssignmentHelper;
import com.google.appengine.api.datastore.Key;

public class ShiftDAO extends AbstractEntityDAO implements
        IMobileAttendanceConstants
{
	
	private static Logger logger    = Logger.getLogger(ShiftDAO.class.getName());
	private MA_ShiftMeta  shiftMeta = new MA_ShiftMeta();
	
	/**
	 * Get all the shifts assigned and the employees in that shift. Make User is
	 * authenticated and has fully filled user object.
	 * 
	 * @param model
	 * @return
	 */
	public static List<MA_Timesheet> getTimesheetsAssignedToMobSupervisor(
	        AbstractEntity model)
	{
		MA_ShiftMeta shiftMeta = new MA_ShiftMeta();
		MA_TimesheetMeta timesheetMeta = new MA_TimesheetMeta();
		
		MA_AssignmentMeta assignmentMeta = new MA_AssignmentMeta();
		
		ArrayList<MA_Assignment> assignments = new ArrayList<MA_Assignment>();
		ArrayList<MA_Timesheet> timesheets = new ArrayList<MA_Timesheet>();
		
		MA_User user = (MA_User) model;
		
		MA_Employee _employee = user.getEmployeeRef().getModel();
		
		MA_Assignment _assignmentOfSupervisor = Datastore
		        .query(assignmentMeta)
		        .filter(assignmentMeta.employeeRef.equal(_employee.getKey()),
		                assignmentMeta.status.equal(CURRENT_ASSIGNMENT))
		        .asSingle();
		
		MA_Shift _shiftOfSupervisor = _assignmentOfSupervisor.getShiftRef()
		        .getModel();
		
		MA_Location _locationOfTheSupervisor = _shiftOfSupervisor
		        .getLocationRef().getModel();
		
		logger.log(Level.INFO, "Shift  --- " + _shiftOfSupervisor.getKey());
		
		// Load Assignments
		// TODO : Pick only current Assignment
		Calendar _currentDate = Calendar.getInstance();
		
		_currentDate = AssignmentHelper.adjustTimeZone(_currentDate, true);
		
		_currentDate.set(Calendar.HOUR, 0);
		_currentDate.set(Calendar.MINUTE, 0);
		_currentDate.set(Calendar.SECOND, 0);
		int _currDay = _currentDate.get(Calendar.DATE);
		int _currMonth = _currentDate.get(Calendar.MONTH);
		int _currYear = _currentDate.get(Calendar.YEAR);
		
		assignments.addAll(Datastore
		        .query(assignmentMeta)
		        .filter(assignmentMeta.shiftRef.equal(_shiftOfSupervisor
		                .getKey()),
		                assignmentMeta.status.equal(CURRENT_ASSIGNMENT))
		        .asList());
		/**
		 * Note : If a assignment expires, then no attendance can be recorded
		 * The Emplyoee will not appear in the above mentioned list
		 */
		
		// }
		
		// Load last created Timesheet
		for (Iterator iterator = assignments.iterator(); iterator.hasNext();)
		{
			MA_Assignment _assignment = (MA_Assignment) iterator.next();
			MA_Timesheet _timesheet = Datastore
			        .query(timesheetMeta)
			        .filter(timesheetMeta.assignmentRef.equal(_assignment
			                .getKey()), timesheetMeta.marker.equal("CURRENT"),
			                timesheetMeta.createDay.equal(_currDay),
			                timesheetMeta.createMonth.equal(_currMonth),
			                timesheetMeta.createYear.equal(_currYear))
			        .asSingle();
			
			if (_timesheet == null)
			{
				_timesheet = new MA_Timesheet();
				_timesheet.setCreatedDate(new Date());
			}
			
			_timesheet.getAssignmentRef().setModel(_assignment);
			timesheets.add(_timesheet);
		}
		
		logger.log(Level.INFO, "Size of timesheet - shift same as supervisor="
		        + timesheets.size());
		
		/**
		 * Get all the timesheet which has have planned assignments but their
		 * shift is not same as logged in supervisor. Since we are restricting
		 * shift wise entry - so get only those timesheet which are in CURRENT
		 * state.
		 * 
		 * This takes care of the case where the employee is going out but came
		 * in early shift, but now it is a different shift
		 */
		
		// dj :06/22/2012 - Assumption : the supervisor and employee are in the
		// same location
		
		List<MA_Timesheet> _outGoingTimesheetNotInShift = Datastore
		        .query(timesheetMeta)
		        .filter(timesheetMeta.locationRef.equal(_locationOfTheSupervisor
		                .getKey()), timesheetMeta.marker.equal("CURRENT"),
		                timesheetMeta.createDay.equal(_currDay),
		                timesheetMeta.createMonth.equal(_currMonth),
		                timesheetMeta.createYear.equal(_currYear)).asList();
		
		for (Iterator iterator = _outGoingTimesheetNotInShift.iterator(); iterator
		        .hasNext();)
		{
			MA_Timesheet ma_Timesheet = (MA_Timesheet) iterator.next();
			
			// If the shift of the timesheet is different from shift of
			// supervisor add it in the list
			if (ma_Timesheet.getAssignmentRef().getModel().getStatus() == IMobileAttendanceConstants.CURRENT_ASSIGNMENT)
			{
				if (!ma_Timesheet.getShiftRef().getKey()
				        .equals(_shiftOfSupervisor.getKey()))
				{
					logger.log(Level.INFO, "Timesheet in different shift : "
					        + ma_Timesheet.getKey().getId());
					timesheets.add(ma_Timesheet);
				}
			}
			
		}
		
		logger.log(Level.INFO,
		        "Size of timesheet - shift NOT same as supervisor="
		                + timesheets.size());
		
		return timesheets;
	}
	
	/**
	 * <pre>
	 * Load all the timesheets where there are no assignments
	 * </pre>
	 * 
	 * @param model
	 * @return
	 */
	
	public static List<MA_Timesheet> getTimesheetsAssignedWithoutMobSupervisor(
	        AbstractEntity model)
	{
		
		List<MA_Assignment> assignments = null;
		ArrayList<MA_Timesheet> timesheets = new ArrayList<MA_Timesheet>();
		MA_User user = (MA_User) model;
		
		Key _companyKey = user.getCompanyRef().getModel().getKey();
		EntityService ebs = EntityService.getInstance();
		
		/**
		 * <pre>
		 * This for the situation - 
		 * 1. If there are planned assignments but no
		 * dedicated supervisor then get get CURRENT assignment 
		 * 2. If there are
		 * no planned assignments and no dedicated supervisor then get DEFAULT
		 * assignment
		 * </pre>
		 */
		// get CURRENT assignments
		/**
		 * assignments = ebs.getAllActiveAssignmentsForACompany(new Long(
		 * _companyKey.getId()), true); // get only DEFAULT Assignments if
		 * (assignments.size() == 0) { assignments =
		 * ebs.getAllActiveAssignmentsForACompany(new Long(
		 * _companyKey.getId()), false); }
		 */
		// Get all DEFAULT ASSIGNMENT
		assignments = ebs.getAllActiveAssignmentsForACompany(new Long(
		        _companyKey.getId()), false);
		
		Calendar _currentDate = Calendar.getInstance();
		_currentDate = AssignmentHelper.adjustTimeZone(_currentDate, true);
		
		int _currDay = _currentDate.get(Calendar.DATE);
		int _currMonth = _currentDate.get(Calendar.MONTH);
		int _currYear = _currentDate.get(Calendar.YEAR);
		
		// Load last created Timesheet
		for (Iterator iterator = assignments.iterator(); iterator.hasNext();)
		{
			MA_Assignment _assignment = (MA_Assignment) iterator.next();
			MA_TimesheetMeta timesheetMeta = new MA_TimesheetMeta();
			
			MA_Timesheet _timesheet = Datastore
			        .query(timesheetMeta)
			        .filter(timesheetMeta.assignmentRef.equal(_assignment
			                .getKey()), timesheetMeta.marker.equal("CURRENT"),
			                timesheetMeta.createDay.equal(_currDay),
			                timesheetMeta.createMonth.equal(_currMonth),
			                timesheetMeta.createYear.equal(_currYear))
			        .asSingle();
			
			if (_timesheet == null)
			{
				
				logger.log(Level.INFO, "ShiftDAO --- " + "_timeheet is null");
				_timesheet = new MA_Timesheet();
				_timesheet.setCreatedDate(new Date());
				// dj start
				
				logger.log(Level.INFO, "_assignment.getStatus() =  "
				        + _assignment.getStatus());
				
				if (_assignment.getStatus() == DEFAULT_ASSIGNMENT)
				{
					
					EntityService _ebs = EntityService.getInstance();
					MA_Assignment _userAssignment = _ebs.getEmplyoeeAssignment(
					        user.getEmployeeRef().getModel(),
					        CURRENT_ASSIGNMENT);
					
					logger.log(Level.INFO,
					        "_userAssignment.getShiftRef().getModel().getLocationRef().getModel() =  "
					                + _userAssignment.getShiftRef().getModel()
					                        .getLocationRef().getModel()
					                        .getKey());
					
					logger.log(Level.INFO,
					        "_userAssignment.getShiftRef().getModel() =  "
					                + _userAssignment.getShiftRef().getModel()
					                        .getKey());
					
					_timesheet.getLocationRef().setModel(
					        _userAssignment.getShiftRef().getModel()
					                .getLocationRef().getModel());
					_timesheet.getShiftRef().setModel(
					        _userAssignment.getShiftRef().getModel());
				}
				// dj end
			}
			
			_timesheet.getAssignmentRef().setModel(_assignment);
			
			/**
			 * 06/10/2012 : For default assignment, make location and shift same
			 * as Supervisor. A supervisor always need to have a CURRENT
			 * assignment
			 */
			
			timesheets.add(_timesheet);
		}
		
		return timesheets;
	}
	
	/**
	 * 
	 * @param companykey
	 * @return
	 */
	public MA_Shift getShiftModel(Key shiftKey)
	{
		
		return Datastore.query(shiftMeta).filter(shiftMeta.key.equal(shiftKey))
		        .asSingle();
	}
}
