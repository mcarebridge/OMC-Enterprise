package com.adviteya.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.AssignmentDTO;
import com.adviteya.meta.MA_DepartmentMeta;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Department;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_Shift;
import com.adviteya.persistence.AssignmentDAO;
import com.adviteya.persistence.ShiftDAO;
import com.google.appengine.api.datastore.Key;

public class AssignmentBusinessService implements IAssignmentBusinessService,
        IMobileAttendanceConstants
{
	
	private static AssignmentBusinessService assignmentBusinessService;
	private static Logger                    logger = Logger.getLogger(AssignmentBusinessService.class
	                                                        .getName());
	
	/**
	 * Private Constructor
	 */
	private AssignmentBusinessService()
	{
		
	}
	
	public static AssignmentBusinessService getInstance()
	{
		
		if (assignmentBusinessService == null)
		{
			assignmentBusinessService = new AssignmentBusinessService();
		}
		
		return assignmentBusinessService;
	}
	
	@Override
	public String createUpdateAssignment(List<AssignmentDTO> assignmentList)
	{
		
		logger.log(Level.INFO, "Start createUpdateAssignment ");
		Iterator itr = assignmentList.iterator();
		
		logger.log(Level.INFO, "assignmentList size  =" + assignmentList.size());
		AssignmentDAO assignmentDAO = AssignmentDAO.newInstance();
		List assignments = new ArrayList();
		ShiftDAO shiftDAO = new ShiftDAO();
		MA_DepartmentMeta departmentMeta = MA_DepartmentMeta.get();
		
		DateLocaleConverter dateLocaleConverter = new DateLocaleConverter(
		        Locale.US, "MM/dd/yyyy");
		ConvertUtils.register(dateLocaleConverter, java.util.Date.class);
		
		while (itr.hasNext())
		{
			MA_Assignment assignment = new MA_Assignment();
			AssignmentDTO assignmentDTO = (AssignmentDTO) itr.next();
			if (null != assignmentDTO.getAssignmentId())
			{
				Key assignmentKey = assignmentDAO.createKey(assignment,
				        assignmentDTO.getAssignmentId());
				
				logger.log(Level.INFO, "Update Existing Assignment  ="
				        + assignmentDTO.getAssignmentId());
				assignment = assignmentDAO.getAssignmentObj(assignmentKey);
				
				if (assignment.getStartDate().equals(
				        assignmentDTO.getStartDate())
				        && assignment.getEndDate().equals(
				                assignmentDTO.getEndDate())
				        && assignment.getShiftRef().getKey().getId() == assignmentDTO
				                .getShiftId())
				{
					
					if (null != assignmentDTO.getDepartmentId()
					        && assignmentDTO.getDepartmentId().equals(""))
					{
						assignmentDTO.setDepartmentId(null);
					}
					
					if (null == assignmentDTO.getDepartmentId()
					        && null == assignment.getDeptRef())
					{
						continue;
					} else if (null != assignmentDTO.getDepartmentId()
					        && null == assignment.getDeptRef())
					{
						Key deptKey = Datastore.createKey(MA_Department.class,
						        Long.valueOf(assignmentDTO.getDepartmentId()));
						
						logger.log(Level.INFO, "Departmnet Id  ="
						        + assignmentDTO.getDepartmentId());
						MA_Department department = Datastore
						        .query(departmentMeta)
						        .filter(departmentMeta.key.equal(deptKey))
						        .asSingle();
						assignment.getDeptRef().setModel(department);
						assignments.add(assignment);
					} else if (null == assignmentDTO.getDepartmentId()
					        && null != assignment.getDeptRef())
					{
						assignment.getDeptRef().setKey(null);
						assignments.add(assignment);
					} else if (null != assignmentDTO.getDepartmentId()
					        && null != assignment.getDeptRef())
					{
						Key deptKey = Datastore.createKey(MA_Department.class,
						        Long.valueOf(assignmentDTO.getDepartmentId()));
						if (assignment.getDeptRef().getKey().equals(deptKey))
						{
							continue;
							
						} else
						{
							assignment.getDeptRef().setKey(deptKey);
							assignments.add(assignment);
						}
						
					}
					
				} else
				{
					/*
					 * assignment.setStatus(EXPIRED_ASSIGNMENT);
					 * assignments.add(assignment); MA_Assignment newAssignment
					 * = new MA_Assignment(); BeanUtil.copy(assignmentDTO,
					 * newAssignment); MA_Employee employee = new MA_Employee();
					 * Key empKey = assignmentDAO.createKey(employee,
					 * assignmentDTO.getEmployeeId());
					 * newAssignment.getEmployeeRef().setKey(empKey); MA_Shift
					 * shift = new MA_Shift(); Key shiftKey =
					 * assignmentDAO.createKey(shift,
					 * assignmentDTO.getShiftId());
					 * newAssignment.getShiftRef().setKey(shiftKey);
					 * newAssignment.setStatus(FUTURE_ASSIGNMENT);
					 * assignments.add(newAssignment);
					 */
					// Above logic to create a new assignment on update of
					// existing assignment is removed.
					MA_Shift shift = assignment.getShiftRef().refresh();
					if (shift.getKey().getId() != assignmentDTO.getShiftId())
					{
						Key shiftKey = assignmentDAO.createKey(shift,
						        assignmentDTO.getShiftId());
						shift = shiftDAO.getShiftModel(shiftKey);
					}
					assignment.getShiftRef().setModel(shift);
					
					int hour = shift.getEndHrs();
					int min = shift.getEndMin();
					Calendar cal = Calendar.getInstance();
					cal.setTime(assignmentDTO.getEndDate());
					cal.set(Calendar.HOUR_OF_DAY, hour);
					cal.set(Calendar.MINUTE, min);
					assignment.setEndDate(cal.getTime());
					
					/*
					 * Shailesh :added the following line to change start date
					 * of assignment. Need to verify this logic again.
					 */
					assignment.setStartDate(assignmentDTO.getStartDate());
					
					logger.log(Level.INFO, "assignmentDTO.getAssignmentId()="
					        + assignmentDTO.getAssignmentId());
					if (null != assignmentDTO.getDepartmentId()
					        && !assignmentDTO.getDepartmentId().equals(""))
					{
						Key deptKey = Datastore.createKey(MA_Department.class,
						        Long.valueOf(assignmentDTO.getDepartmentId()));
						MA_Department department = Datastore
						        .query(departmentMeta)
						        .filter(departmentMeta.key.equal(deptKey))
						        .asSingle();
						
						logger.log(Level.INFO, "department======" + department);
						assignment.getDeptRef().setModel(department);
						logger.log(Level.INFO, "Fifth Condition");
					} else
					{
						assignment.getDeptRef().setKey(null);
						logger.log(Level.INFO, "Sixth Condition");
					}
					
					assignments.add(assignment);
					
				}
			} else
			{
				
				logger.log(Level.INFO, "Create New Assignmet");
				BeanUtil.copy(assignmentDTO, assignment);
				
				MA_Employee employee = new MA_Employee();
				Key empKey = assignmentDAO.createKey(employee,
				        assignmentDTO.getEmployeeId());
				
				logger.log(Level.INFO,
				        "Employee Id =" + assignmentDTO.getEmployeeId());
				assignment.getEmployeeRef().setKey(empKey);
				MA_Shift shift = new MA_Shift();
				Key shiftKey = assignmentDAO.createKey(shift,
				        assignmentDTO.getShiftId());
				shift = shiftDAO.getShiftModel(shiftKey);
				assignment.getShiftRef().setModel(shift);
				assignment.setEndDate(getShiftEndDateTime(
				        assignmentDTO.getEndDate(), shift));
				if (assignment.getStartDate().before(new Date()))
				{
					assignment.setStatus(CURRENT_ASSIGNMENT);
					logger.log(Level.INFO, "Create Current assignment");
				} else
				{
					assignment.setStatus(FUTURE_ASSIGNMENT);
					logger.log(Level.INFO, "Create future assignment");
				}
				if (null != assignmentDTO.getDepartmentId()
				        && !assignmentDTO.getDepartmentId().equals(""))
				{
					Key deptKey = Datastore.createKey(MA_Department.class,
					        Long.valueOf(assignmentDTO.getDepartmentId()));
					MA_Department department = Datastore.query(departmentMeta)
					        .filter(departmentMeta.key.equal(deptKey))
					        .asSingle();
					
					assignment.getDeptRef().setModel(department);
				}
				assignments.add(assignment);
			}
			
		}
		logger.log(Level.INFO, "No of assignment created or updated= "
		        + assignments.size());
		assignmentDAO.createUpdateAssignments(assignments);
		
		return null;
	}
	
	/**
	 * 
	 * @param endDate
	 * @param shift
	 * @return
	 */
	public Date getShiftEndDateTime(Date endDate, MA_Shift shift)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.set(Calendar.HOUR_OF_DAY, shift.getEndHrs());
		cal.set(Calendar.MINUTE, shift.getEndMin());
		return cal.getTime();
	}
	
	/**
	 * This method finds all all the locations and their shifts and makes a
	 * string to be sent to a mobile phone
	 * 
	 * @param companyId
	 * @return
	 */
	
	public String getAllShiftByLocation(Long companyId)
	{
		// Get all locations
		
		EntityService es = EntityService.getInstance();
		List<MA_Location> locations = es.getAllLocationForCompany(companyId);
		StringBuffer _sb = new StringBuffer();
		_sb.append("SHIFTKEY");
		_sb.append(",");
		_sb.append("SHIFTNAME");
		_sb.append(",");
		_sb.append("LOCATIONKEY");
		_sb.append(",");
		_sb.append("LOCATION");
		_sb.append(",");
		_sb.append("TIMEZONE");
		_sb.append("|");
		
		for (Iterator iterator = locations.iterator(); iterator.hasNext();)
		{
			MA_Location ma_Location = (MA_Location) iterator.next();
			List<MA_Shift> _shifts = es.getAllShifForLocation(ma_Location
			        .getKey().getId());
			
			for (Iterator iterator2 = _shifts.iterator(); iterator2.hasNext();)
			{
				MA_Shift ma_Shift = (MA_Shift) iterator2.next();
				_sb.append(ma_Shift.getKey().getId());
				_sb.append(",");
				_sb.append(ma_Shift.getShiftName());
				_sb.append(",");
				_sb.append(ma_Shift.getLocationRef().getModel().getKey()
				        .getId());
				_sb.append(",");
				_sb.append(ma_Shift.getLocationRef().getModel()
				        .getLocationName());
				_sb.append(",");
				_sb.append(ma_Shift.getLocationRef().getModel().getTimeZone());
				_sb.append("|");
			}
		}
		return _sb.toString();
	}
	
}
