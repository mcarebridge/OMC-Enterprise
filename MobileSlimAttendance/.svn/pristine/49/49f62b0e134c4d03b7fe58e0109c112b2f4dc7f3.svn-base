package com.adviteya.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.meta.MA_LocationMeta;
import com.adviteya.meta.MA_ShiftMeta;
import com.adviteya.meta.MA_TimesheetMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.TimesheetDAO;
import com.adviteya.util.AssignmentHelper;
import com.google.appengine.api.datastore.Key;

public class TimeSheetBatchService implements ITimeSheetBatchService
{
	
	private static Logger                logger = Logger.getLogger(TimeSheetBatchService.class
	                                                    .getName());
	private static TimeSheetBatchService batchService;
	
	/**
	 * Private Constructor
	 */
	private TimeSheetBatchService()
	{
		
	}
	
	public static TimeSheetBatchService getInstance()
	{
		
		if (batchService == null)
		{
			batchService = new TimeSheetBatchService();
		}
		
		return batchService;
	}
	
	@Override
	public void getAllAssignments(Long companyId)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void getAllOpenAssignments(Long shiftId)
	{
		
		MA_Shift shift = new MA_Shift();
		Key shiftkey = AbstractEntityDAO.createKey(shift, shiftId);
		
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		MA_TimesheetMeta timesheetMeta = MA_TimesheetMeta.get();
		
	}
	
	/**
	 * 
	 * @param shiftKey
	 * @return
	 */
	private List<MA_Assignment> getAllPlannedAssignments(Key shiftKey)
	{
		
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		List<MA_Assignment> plannedAssignments = Datastore
		        .query(assignmentMeta)
		        .filter(assignmentMeta.shiftRef.equal(shiftKey)).asList();
		return plannedAssignments;
	}
	
	/**
	 * 
	 * @param shiftKey
	 * @return
	 */
	private List<MA_Assignment> getAllUnPlannedAssignments(
	        List<MA_Employee> employees)
	{
		
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		ArrayList<MA_Assignment> unplannedAssignments = new ArrayList();
		
		for (Iterator iterator = employees.iterator(); iterator.hasNext();)
		{
			MA_Employee _employee = (MA_Employee) iterator.next();
			MA_Assignment _unplannedAssignment = Datastore
			        .query(assignmentMeta)
			        .filter(assignmentMeta.employeeRef.equal(_employee.getKey()))
			        .asSingle();
			
			if (_unplannedAssignment.getShiftRef() == null)
			{
				unplannedAssignments.add(_unplannedAssignment);
			}
		}
		
		return unplannedAssignments;
	}
	
	@Override
	public void createConsolidatedTimesheetForEntry(Long shiftId)
	{
		Calendar _currentDate = Calendar.getInstance();
		MA_Shift shift = new MA_Shift();
		Key shiftkey = AbstractEntityDAO.createKey(shift, shiftId);
		MA_ShiftMeta shiftMeta = MA_ShiftMeta.get();
		
		MA_Shift _shift = Datastore.query(shiftMeta)
		        .filter(shiftMeta.key.equal(shiftkey)).asSingle();
		
		MA_Company _company = _shift.getLocationRef().getModel()
		        .getCompanyRef().getModel();
		
		EntityService _es = EntityService.getInstance();
		List<MA_Employee> _employees = _es.getAllEmployeeForCompany(_company
		        .getKey().getId());
		
		if (AssignmentHelper.hasShiftStarted(_shift, _currentDate)
		        & !(AssignmentHelper.hasShiftEnded(_shift, _currentDate)))
		{
			
			List<MA_Assignment> plannedassignments = getAllPlannedAssignments(shiftkey);
			for (Iterator iterator = plannedassignments.iterator(); iterator
			        .hasNext();)
			{
				MA_Assignment ma_Assignment = (MA_Assignment) iterator.next();
				List<MA_Timesheet> _timesheets = getPresentTimesheets(ma_Assignment
				        .getKey());
				
				populateConsolidatedTimesheet(_timesheets);
				
			}
			
		}
		
	}
	
	private void populateConsolidatedTimesheet(List<MA_Timesheet> _timesheets)
	{
		
	}
	
	@Override
	public void createConsolidatedTimesheetForExit(Long shiftId)
	{
		// TODO Auto-generated method stub
		
	}
	
	private List<MA_Timesheet> getPresentTimesheets(Key assignmentKey)
	{
		
		MA_TimesheetMeta timesheetMeta = MA_TimesheetMeta.get();
		Calendar _c = Calendar.getInstance();
		_c = AssignmentHelper.adjustTimeZone(_c);
		
		List<MA_Timesheet> plannedAssignments = Datastore
		        .query(timesheetMeta)
		        .filter(timesheetMeta.assignmentRef.equal(assignmentKey),
		                timesheetMeta.createDay.equal(_c.get(Calendar.DATE)),
		                timesheetMeta.createMonth.equal(_c.get(Calendar.MONTH)),
		                timesheetMeta.createYear.equal(_c.get(Calendar.YEAR)))
		        .sort(timesheetMeta.inDateTime.asc).asList();
		
		return plannedAssignments;
	}
	
	/**
	 * 
	 */
	public void updateOrphanTimesheets()
	{
		/**
		 * <pre>
		 * Logic:
		 * 1. Get all the Locations
		 * 2. Get all the Shifts in that location
		 * 3. Has shift's max durations has elapsed
		 * 	  if true - run job
		 * 	  else do nothing
		 * </pre>
		 */
		
		Calendar _currentDate = Calendar.getInstance();
		
		MA_LocationMeta locationMeta = new MA_LocationMeta();
		MA_ShiftMeta metaShiftMeta = new MA_ShiftMeta();
		MA_TimesheetMeta metaTimeSheet = new MA_TimesheetMeta();
		
		List<MA_Location> allLocations = Datastore.query(locationMeta).asList();
		
		for (Iterator iterator = allLocations.iterator(); iterator.hasNext();)
		{
			MA_Location ma_Location = (MA_Location) iterator.next();
			List<MA_Shift> shiftsInLocation = Datastore
			        .query(metaShiftMeta)
			        .filter(metaShiftMeta.locationRef.equal(ma_Location
			                .getKey())).asList();
			
			for (Iterator iterator2 = shiftsInLocation.iterator(); iterator2
			        .hasNext();)
			{
				try
				{
					MA_Shift ma_Shift = (MA_Shift) iterator2.next();
					
					if (AssignmentHelper.hasShiftCrossedMaxDuration(ma_Shift,
					        _currentDate))
					{
						List<MA_Timesheet> _openTimesheets = Datastore
						        .query(metaTimeSheet)
						        .filter(metaTimeSheet.shiftRef.equal(ma_Shift
						                .getKey()),
						                metaTimeSheet.marker.equal("CURRENT"))
						        .asList();
						
						ArrayList<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
						
						for (Iterator iterator3 = _openTimesheets.iterator(); iterator3
						        .hasNext();)
						{
							MA_Timesheet ma_Timesheet = (MA_Timesheet) iterator3
							        .next();
							ma_Timesheet.setMarker("UPDATED");
							ma_Timesheet.setUpdatedBy("SYSTEM");
							entityList.add(ma_Timesheet);
						}
						
						GlobalTransaction gtx = Datastore
						        .beginGlobalTransaction();
						TimesheetDAO tsDAO = new TimesheetDAO();
						tsDAO.setGtx(gtx);
						tsDAO.addModels(entityList);
						gtx.commit();
					}
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
}
