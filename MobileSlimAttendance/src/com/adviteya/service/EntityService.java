package com.adviteya.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;
import org.slim3.util.DateUtil;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.dto.AssignmentDTO;
import com.adviteya.dto.ShiftDTO;
import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.meta.MA_CompanyMeta;
import com.adviteya.meta.MA_ContractorCompanyMeta;
import com.adviteya.meta.MA_CountryMeta;
import com.adviteya.meta.MA_DepartmentMeta;
import com.adviteya.meta.MA_EmployeeMeta;
import com.adviteya.meta.MA_HolidayMeta;
import com.adviteya.meta.MA_LocationMeta;
import com.adviteya.meta.MA_NatureOfCompanyMeta;
import com.adviteya.meta.MA_ShiftMeta;
import com.adviteya.meta.MA_StateMeta;
import com.adviteya.meta.MA_TemplateMeta;
import com.adviteya.meta.MA_TemplateSkillMeta;
import com.adviteya.meta.MA_UserProfileMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_ContractorCompany;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_Department;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Holiday;
import com.adviteya.model.MA_Location;
import com.adviteya.model.MA_NatureOfCompany;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_State;
import com.adviteya.model.MA_Template;
import com.adviteya.model.MA_TemplateSkill;
import com.adviteya.model.MA_UserProfile;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.AssignmentDAO;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class EntityService implements IMobileAttendanceConstants
{
	
	private static Logger            logger                = Logger.getLogger(EntityService.class
	                                                               .getName());
	
	private MA_StateMeta             t                     = new MA_StateMeta();
	private MA_CountryMeta           c                     = new MA_CountryMeta();
	private MA_UserProfileMeta       p                     = new MA_UserProfileMeta();
	private MA_NatureOfCompanyMeta   n                     = new MA_NatureOfCompanyMeta();
	private MA_LocationMeta          l                     = new MA_LocationMeta();
	private MA_CompanyMeta           companyMeta           = new MA_CompanyMeta();
	private MA_ShiftMeta             s                     = new MA_ShiftMeta();
	private MA_EmployeeMeta          e                     = new MA_EmployeeMeta();
	private MA_AssignmentMeta        a                     = new MA_AssignmentMeta();
	private MA_TemplateMeta          templateMeta          = new MA_TemplateMeta();
	private MA_ContractorCompanyMeta contractorCompanyMeta = new MA_ContractorCompanyMeta();
	private MA_TemplateSkillMeta     skillMeta             = new MA_TemplateSkillMeta();
	private MA_HolidayMeta           holidayMeta           = new MA_HolidayMeta();
	private MA_LocationMeta          locationMeta          = new MA_LocationMeta();
	private MA_DepartmentMeta        departmentMeta        = new MA_DepartmentMeta();
	
	private static EntityService     entityService;
	
	public static double             readCounter;
	public static double             writeCounter;
	
	/**
	 * Private Constructor
	 */
	private EntityService()
	{
		
	}
	
	public static EntityService getInstance()
	{
		
		if (entityService == null)
		{
			entityService = new EntityService();
		}
		
		return entityService;
	}
	
	public AbstractEntity addState(Map<String, Object> input)
	{
		
		MA_State state = new MA_State();
		MA_Country country = new MA_Country();
		String countryId = (String) input.get("selectedCountry");
		Key k = Datastore
		        .createKey(MA_Country.class, Long.parseLong(countryId));
		country.setKey(k);
		state.getCountryRef().setModel(country);
		
		BeanUtil.copy(input, state);
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		gtx.put(state, country);
		gtx.commit();
		return state;
	}
	
	/**
	 * TODO : uses deprecated method for transation
	 * 
	 * @param input
	 * @return
	 */
	public AbstractEntity addCountry(Map<String, Object> input)
	{
		
		MA_Country country = new MA_Country();
		BeanUtil.copy(input, country);
		Transaction tx = Datastore.beginTransaction();
		writeCounter++;
		Datastore.put(country);
		tx.commit();
		return country;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<MA_State> getStateList()
	{
		readCounter++;
		return Datastore.query(t).asList();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<MA_Country> getCounrtyList()
	{
		readCounter++;
		return Datastore.query(c).asList();
	}
	
	/**
	 * Return Country by country Code
	 * 
	 * @param countryCode
	 * @return
	 */
	public MA_Country getCountry(String countryCode)
	{
		readCounter++;
		return Datastore.query(c).filter(c.countryCode.equal(countryCode))
		        .asSingle();
	}
	
	/**
	 * 
	 */
	public void deleteEmptyValues()
	{
		
		List<Key> keys = Datastore.query(t).filter(t.stateName.equal(null))
		        .asKeyList();
		Transaction tx = Datastore.beginTransaction();
		Datastore.delete(keys);
		tx.commit();
		
		keys = Datastore.query(c).filter(c.countryName.equal(null)).asKeyList();
		for (int i = 0; i < keys.size(); i++)
		{
			Transaction tx1 = Datastore.beginTransaction();
			Datastore.delete(keys.get(i));
			tx1.commit();
		}
	}
	
	/**
	 * 
	 * @param countryId
	 * @return
	 */
	public List<MA_State> getAllStateForCountry(String countryId)
	{
		
		MA_State state = new MA_State();
		MA_Country country = new MA_Country();
		Key k = Datastore
		        .createKey(MA_Country.class, Long.parseLong(countryId));
		country.setKey(k);
		
		MA_Country _country = Datastore.query(c).filter(c.key.equal(k))
		        .asSingle();
		
		state.getCountryRef().setModel(country);
		List<MA_State> ma_State = Datastore.query(t)
		        .filter(t.countryCode.equal(_country.getCountryCode()))
		        .asList();
		return ma_State;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<MA_UserProfile> getUserProfileList()
	{
		return Datastore.query(p).asList();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<MA_NatureOfCompany> getNatureOfCompanyList()
	{
		return Datastore.query(n).asList();
	}
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	public List<MA_Location> getAllLocationForCompany(Long companyId)
	{
		
		logger.log(Level.INFO, "Start getAllLocationForCompany");
		MA_Company company = new MA_Company();
		MA_Location location = new MA_Location();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		company.setKey(k);
		location.getCompanyRef().setModel(company);
		List<MA_Location> location_list = Datastore.query(l)
		        .filter(l.companyRef.equal(k)).asList();
		readCounter++;
		logger.log(Level.INFO, "End getAllLocationForCompany");
		return location_list;
	}
	
	/**
	 * 
	 * @param companykey
	 * @return
	 */
	public MA_Company getCompanyObj(Key companykey)
	{
		readCounter++;
		return Datastore.query(companyMeta)
		        .filter(companyMeta.key.equal(companykey)).asSingle();
	}
	
	/**
	 * 
	 * @param locationId
	 * @return
	 */
	public List<MA_Shift> getAllShifForLocation(Long locationId)
	{
		logger.log(Level.INFO, "Start getAllShifForLocation");
		Key k = Datastore.createKey(MA_Location.class, locationId);
		List<MA_Shift> shift_list = Datastore.query(s)
		        .filter(s.locationRef.equal(k)).asList();
		
		logger.log(Level.INFO, "End getAllShifForLocation");
		return shift_list;
		
	}
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	public List<MA_Employee> getAllEmployeeForCompany(Long companyId)
	{
		ArrayList<MA_Employee> masterList = new ArrayList();
		
		Key k = Datastore.createKey(MA_Company.class, companyId);
		
		// Get Direct Emplyoees, except the emplyoees who are controlling the
		// ops
		List<MA_Employee> employee_list = Datastore.query(e)
		        .filter(e.companyRef.equal(k), e.companyEmpId.notEqual(null))
		        .asList();
		
		// Get Contractors
		MA_ContractorCompanyMeta _c = new MA_ContractorCompanyMeta();
		List<MA_ContractorCompany> _contractingCompanyList = Datastore
		        .query(_c).filter(_c.companyRef.equal(k)).asList();
		
		for (Iterator iterator = _contractingCompanyList.iterator(); iterator
		        .hasNext();)
		{
			MA_ContractorCompany ma_ContractorCompany = (MA_ContractorCompany) iterator
			        .next();
			List<MA_Employee> _cont_employee_list = Datastore
			        .query(e)
			        .filter(e.companyRef.equal(ma_ContractorCompany.getKey()),
			                e.companyEmpId.notEqual(null)).asList();
			// if (masterList == null)
			// {
			// masterList = _cont_employee_list;
			// } else
			// {
			// masterList.addAll(_cont_employee_list);
			// }
			masterList.addAll(_cont_employee_list);
		}
		
		masterList.addAll(employee_list);
		
		readCounter += employee_list.size();
		
		return masterList;
	}
	
	/**
	 * Get all the Active employees for an employees
	 * 
	 * @param companyId
	 * @return
	 */
	public List<MA_Employee> getAllActiveEmployeesForCompany(Long companyId)
	{
		ArrayList<MA_Employee> masterList = new ArrayList();
		
		Key k = Datastore.createKey(MA_Company.class, companyId);
		
		// Get Direct Emplyoees, except the emplyoees who are controlling the
		// ops
		List<MA_Employee> employee_list = Datastore
		        .query(e)
		        .filter(e.companyRef.equal(k), e.companyEmpId.notEqual(null),
		                e.active.equal("Y")).asList();
		
		// Get Contractors
		MA_ContractorCompanyMeta _c = new MA_ContractorCompanyMeta();
		List<MA_ContractorCompany> _contractingCompanyList = Datastore
		        .query(_c).filter(_c.companyRef.equal(k)).asList();
		
		for (Iterator iterator = _contractingCompanyList.iterator(); iterator
		        .hasNext();)
		{
			MA_ContractorCompany ma_ContractorCompany = (MA_ContractorCompany) iterator
			        .next();
			List<MA_Employee> _cont_employee_list = Datastore
			        .query(e)
			        .filter(e.companyRef.equal(ma_ContractorCompany.getKey()),
			                e.active.equal("Y"), e.companyEmpId.notEqual(null))
			        .asList();
			masterList.addAll(_cont_employee_list);
		}
		
		masterList.addAll(employee_list);
		
		readCounter += employee_list.size();
		
		return masterList;
	}
	
	/**
	 * TODO : This method will throw error for Default Assignment
	 * 
	 * @param companyId
	 * @return
	 */
	public List<AssignmentDTO> getAllEmployeeAssignment(Long companyId)
	{
		// This method need to be made as batch job
		// updateAssignmentStatus(companyId);
		
		List<AssignmentDTO> assignmentList = new ArrayList<AssignmentDTO>();
		List<MA_Employee> employees = getAllActiveEmployeesForCompany(companyId);
		Calendar _currentDate = Calendar.getInstance();
		DateUtil.clearTimePart(_currentDate);
		
		Iterator<MA_Employee> itr = employees.iterator();
		while (itr.hasNext())
		{
			MA_Employee employee = itr.next();
			Key k = employee.getKey();
			AssignmentDTO assignmentDTO = new AssignmentDTO();
			assignmentDTO.setEmployeeId(k.getId());
			assignmentDTO.setEmployeeType(employee.getEmployeeType());
			assignmentDTO.setSupervisor(employee.getIsSuperwiser());
			assignmentDTO.setFirstName(employee.getFirstName());
			assignmentDTO.setLastName(employee.getLastName());
			assignmentDTO.setGender(employee.getGender());
			assignmentDTO.setCompanyEmpId(employee.getCompanyEmpId());
			
			List<MA_Assignment> employee_assignment = Datastore
			        .query(a)
			        .filter(a.employeeRef.equal(k),
			                a.status.greaterThan(EXPIRED_ASSIGNMENT)).asList();
			
			if (null != employee_assignment && employee_assignment.size() > 0)
			{
				Iterator<MA_Assignment> empAssignmentIterator = employee_assignment
				        .iterator();
				
				while (empAssignmentIterator.hasNext())
				{
					MA_Assignment assignment = empAssignmentIterator.next();
					
					assignmentDTO.setAssignmentId(assignment.getKey().getId());
					MA_Shift shift = assignment.getShiftRef().refresh();
					assignmentDTO.setShiftId(shift.getKey().getId());
					MA_Location location = shift.getLocationRef().refresh();
					assignmentDTO.setLocationId(location.getKey().getId());
					logger.log(Level.INFO, " assignment.getDeptRef()= "
					        + assignment.getDeptRef().getModel());
					if (null != assignment.getDeptRef().getModel())
					{
						assignmentDTO.setDepartmentId(("" + assignment
						        .getDeptRef().getKey().getId()).trim());
						
						logger.log(Level.INFO,
						        " assignmentDTO.getDepartmentId= "
						                + assignmentDTO.getDepartmentId());
					}
					assignmentDTO
					        .setShiftList(getAllShiftDTOForLocation(location
					                .getKey().getId()));
					assignmentDTO
					        .setDepartmentList(getAllDepartmentOfLocation(location
					                .getKey().getId()));
					assignmentDTO.setStartDt(DateUtil.toString(
					        assignment.getStartDate(), "MM/dd/yyyy"));
					assignmentDTO.setEndDt(DateUtil.toString(
					        assignment.getEndDate(), "MM/dd/yyyy"));
					if (assignment.getStatus() == CURRENT_ASSIGNMENT)
					{
						Calendar cal = new GregorianCalendar(
						        TimeZone.getTimeZone(location.getTimeZone()));
						int startHour = shift.getStartHrs();
						int startMin = shift.getStartMin();
						int startMinFromMidnight = (startHour * 60) + startMin
						        - 60;
						int currentMin = (cal.HOUR_OF_DAY * 60) + cal.MINUTE;
						
						int endHour = shift.getEndHrs();
						int endMin = shift.getEndMin();
						int endMinFromMidnight = (startHour * 60) + startMin
						        - 60;
						
						if (startMinFromMidnight < currentMin
						        && currentMin < endMinFromMidnight)
						{
							assignmentDTO.setLocked("Y");
						}
						
						assignmentDTO.setEditable("N");
						assignmentDTO.setStatus("CURRENT");
					} else
					{
						
						assignmentDTO.setStatus("ASSIGNED");
						assignmentDTO.setEditable("Y");
						
					}
					
				}
				
			} else
			{
				assignmentDTO.setStatus("OPEN");
				assignmentDTO.setEditable("Y");
			}
			
			assignmentList.add(assignmentDTO);
		}
		
		return assignmentList;
	}
	
	/**
	 * This method just returns all Assignments. If the "includeCurrent" = true
	 * - get only current if "includeCurrent"
	 * 
	 * @param companyId
	 * @return
	 */
	public List<MA_Assignment> getAllActiveAssignmentsForACompany(
	        Long companyId, boolean includeCurrent)
	{
		logger.log(Level.INFO, "-- Company Key -- " + companyId);
		List<MA_Employee> employees = getAllEmployeeForCompany(companyId);
		
		ArrayList<MA_Assignment> assignmentList = new ArrayList();
		
		for (Iterator iterator = employees.iterator(); iterator.hasNext();)
		{
			MA_Employee ma_Employee = (MA_Employee) iterator.next();
			logger.log(Level.INFO, "-- Employee Key -- "
			        + ma_Employee.getKey().getId());
			MA_Assignment _currentAssignment = null;
			if (includeCurrent)
			{
				_currentAssignment = Datastore
				        .query(a)
				        .filter(a.employeeRef.equal(ma_Employee.getKey()),
				                a.status.equal(CURRENT_ASSIGNMENT)).asSingle();
			}
			if (_currentAssignment != null)
			{
				assignmentList.add(_currentAssignment);
			} else
			{
				// Logic :
				// 1. First check if there is any current assignment if "yes"
				// then do not load the
				// the "default" assignment
				// 2. If no current assignment found - load default assignment
				
				MA_Assignment _assignment = Datastore
				        .query(a)
				        .filter(a.employeeRef.equal(ma_Employee.getKey()),
				                a.status.equal(CURRENT_ASSIGNMENT)).asSingle();
				
				if (_assignment == null)
				{
					_assignment = Datastore
					        .query(a)
					        .filter(a.employeeRef.equal(ma_Employee.getKey()),
					                a.status.equal(DEFAULT_ASSIGNMENT))
					        .asSingle();
					if (_assignment != null)
					{
						assignmentList.add(_assignment);
					}
				}
				
			}
			
		}
		
		return assignmentList;
	}
	
	/**
	 * Update the status of assignment. This method will be used as batch job
	 * which will update assignment status periodically.
	 * 
	 * @param companyId
	 */
	public void updateAssignmentStatus(Long companyId)
	{
		
		logger.log(Level.INFO, "Start updateAssignmentStatus");
		List<MA_Employee> employees = getAllEmployeeForCompany(companyId);
		List updateAssignentList = new ArrayList();
		Calendar _currentDate = Calendar.getInstance();
		DateUtil.clearTimePart(_currentDate);
		Date _currentDateTime = _currentDate.getTime();
		
		Iterator<MA_Employee> itr = employees.iterator();
		while (itr.hasNext())
		{
			MA_Employee employee = itr.next();
			Key k = employee.getKey();
			
			List<MA_Assignment> employee_assignment = Datastore
			        .query(a)
			        .filter(a.employeeRef.equal(k),
			                a.status.notEqual(EXPIRED_ASSIGNMENT)).asList();
			readCounter++;
			
			if (null != employee_assignment && employee_assignment.size() > 0)
			{
				
				Iterator<MA_Assignment> empAssignmentIterator = employee_assignment
				        .iterator();
				
				while (empAssignmentIterator.hasNext())
				{
					MA_Assignment assignment = empAssignmentIterator.next();
					
					/**
					 * Modlog : dj : 06/17/2012 If the assignment is expiring
					 * and employee is still active then extend the default
					 * assignment by 90 days and expire the current assignment
					 */
					
					if (assignment.getEndDate().before(_currentDateTime))
					{
						if (assignment.getStatus() == CURRENT_ASSIGNMENT)
						{
							assignment.setStatus(EXPIRED_ASSIGNMENT);
						} else if (assignment.getStatus() == DEFAULT_ASSIGNMENT)
						{
							String _empActive = assignment.getEmployeeRef()
							        .getModel().getActive();
							
							if (_empActive != null)
							{
								if (_empActive.equalsIgnoreCase("Y"))
								{
									Calendar _asgEndDate = Calendar
									        .getInstance();
									_asgEndDate
									        .setTime(assignment.getEndDate());
									_asgEndDate.add(Calendar.DATE, 90);
									assignment
									        .setEndDate(_asgEndDate.getTime());
								}
							}
						}
						updateAssignentList.add(assignment);
						
					} else if (assignment.getStartDate().compareTo(
					        _currentDateTime) <= 0
					        && assignment.getStatus() == FUTURE_ASSIGNMENT)
					{
						assignment.setStatus(CURRENT_ASSIGNMENT);
						updateAssignentList.add(assignment);
					}
					
				}
			}
		}
		
		AssignmentDAO assignmentDAO = AssignmentDAO.newInstance();
		assignmentDAO.createUpdateAssignments(updateAssignentList);
	}
	
	public List<ShiftDTO> getAllShiftDTOForLocation(Long locationId)
	{
		logger.log(Level.INFO, "Start getAllShiftDTOForLocation");
		List<MA_Shift> shift_list = getAllShifForLocation(locationId);
		Iterator itr1 = shift_list.iterator();
		List<ShiftDTO> shiftDTOList = new ArrayList<ShiftDTO>();
		while (itr1.hasNext())
		{
			ShiftDTO shiftDTO = new ShiftDTO();
			MA_Shift shift = (MA_Shift) itr1.next();
			String startTimeStr = "";
			if (shift.getStartHrs() < 10)
			{
				startTimeStr = startTimeStr + "0" + shift.getStartHrs();
			} else
			{
				startTimeStr = startTimeStr + shift.getStartHrs();
			}
			if (shift.getStartMin() < 10)
			{
				startTimeStr = startTimeStr + "0" + shift.getStartMin();
			} else
			{
				startTimeStr = startTimeStr + shift.getStartMin();
			}
			String tempval = "" + shift.getKey().getId() + startTimeStr.trim();
			shiftDTO.setShiftId(Long.valueOf(tempval));
			shiftDTO.setShiftName(shift.getShiftName());
			
			String status = shift.getActive();
			if (null != status && status.equals("Y"))
			{
				shiftDTO.setActive("ACTIVE");
				
			} else
			{
				shiftDTO.setActive("INACTIVE");
			}
			shiftDTOList.add(shiftDTO);
		}
		logger.log(Level.INFO, "End getAllShiftDTOForLocation");
		return shiftDTOList;
		
	}
	
	public List<MA_Template> getTemplateList()
	{
		return Datastore.query(templateMeta).asList();
	}
	
	public List<MA_ContractorCompany> getAllContractorForCompany(Long companyId)
	{
		Key k = Datastore.createKey(MA_ContractorCompany.class, companyId);
		List<MA_ContractorCompany> contractor_list = Datastore
		        .query(contractorCompanyMeta)
		        .filter(contractorCompanyMeta.companyRef.equal(k),
		                contractorCompanyMeta.status.equal("Y")).asList();
		return contractor_list;
	}
	
	public List<MA_TemplateSkill> getCompanySkillList(Long companyId)
	{
		MA_Company company = new MA_Company();
		Key k1 = AbstractEntityDAO.createKey(company, companyId);
		company = getCompanyObj(k1);
		List<MA_TemplateSkill> skillList = Datastore.query(skillMeta)
		        .filter(skillMeta.companyRef.equal(k1)).asList();
		
		if (null == skillList || skillList.size() < 1)
		{
			Key templateKey = Datastore.createKey(MA_Template.class, company
			        .getTemplateRef().getKey().getId());
			skillList = Datastore.query(skillMeta)
			        .filter(skillMeta.templateRef.equal(templateKey)).asList();
		}
		
		return skillList;
	}
	
	public void displayDbCounters()
	{
		
		AbstractEntityDAO.readCounter += readCounter;
		AbstractEntityDAO.writeCounter += writeCounter;
		
		logger.log(Level.INFO, "-- EntityService Read Counter -- "
		        + AbstractEntityDAO.readCounter);
		logger.log(Level.INFO, "-- EntityService Write Counter -- "
		        + AbstractEntityDAO.writeCounter);
	}
	
	/**
	 * 
	 * @param countryCode
	 * @return
	 */
	public List<MA_Holiday> getHolidayForACountry(String countryCode)
	{
		logger.log(Level.INFO, "Start getHolidayForACountry");
		List<MA_Holiday> holidayList = Datastore.query(holidayMeta)
		        .filter(holidayMeta.countryCode.equal(countryCode))
		        .sort(holidayMeta.holidayDate.asc).asList();
		logger.log(Level.INFO, "End getHolidayForACountry");
		return holidayList;
	}
	
	/**
	 * Load all the Company Holiday and Location Holidays for the give Location
	 * 
	 * @param locationId
	 * @return
	 */
	public List<MA_Holiday> loadBaseHolidaysForLocation(long locationId)
	{
		logger.log(Level.INFO, "Start loadBaseHolidaysForLocation");
		Key k = Datastore.createKey(MA_Location.class, locationId);
		MA_Location location = Datastore.query(locationMeta)
		        .filter(locationMeta.key.equal(k)).asSingle();
		
		return getHolidayForACountry(location.getAddressRef().getModel()
		        .getStateRef().getModel().getCountryCode());
		
	}
	
	/**
	 * 
	 * @param shift
	 * @return
	 */
	public int getCurrentAssignmentCountOfShift(MA_Shift shift)
	{
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		int count = Datastore
		        .query(assignmentMeta)
		        .filter(assignmentMeta.shiftRef.equal(shift.getKey()),
		                assignmentMeta.status
		                        .equal(IMobileAttendanceConstants.CURRENT_ASSIGNMENT))
		        .count();
		return count;
		
	}
	
	/**
	 * This method return all the created Companies
	 * 
	 * @return
	 */
	public List<MA_Company> getAllCompanyList()
	{
		MA_CompanyMeta _companyMeta = new MA_CompanyMeta();
		return Datastore.query(_companyMeta).asList();
	}
	
	/**
	 * Get all Active Companies
	 * 
	 * @return
	 */
	public List<MA_Company> getAllActiveCompanyList()
	{
		MA_CompanyMeta _companyMeta = new MA_CompanyMeta();
		return Datastore.query(_companyMeta)
		        .filter(_companyMeta.active.equal("Y")).asList();
	}
	
	/**
	 * 
	 * @param company
	 * @return
	 */
	public List<MA_Department> getAllDepartmentForCompany(MA_Company company)
	{
		return null;
	}
	
	public List<MA_Department> getAllDepartmentOfCompany(long companyId)
	{
		logger.log(Level.INFO, "Start getAllDepartmentOfCompany");
		Key k = Datastore.createKey(MA_Company.class, companyId);
		List<MA_Department> departmentList = Datastore.query(departmentMeta)
		        .filter(departmentMeta.companyRef.equal(k)).asList();
		
		logger.log(Level.INFO, "End getAllDepartmentOfCompany");
		return departmentList;
		
	}
	
	public List<MA_Department> getAllDepartmentOfLocation(long locationId)
	{
		logger.log(Level.INFO, "Start getAllDepartmentOfLocation");
		Key k = Datastore.createKey(MA_Location.class, locationId);
		List<MA_Department> departmentList = Datastore.query(departmentMeta)
		        .filter(departmentMeta.locationRef.equal(k)).asList();
		logger.log(Level.INFO, "End getAllDepartmentOfLocation");
		return departmentList;
		
	}
	
	/**
	 * TODO : This method will throw error for Default Assignment
	 * 
	 * @param companyId
	 * @return
	 */
	public List<AssignmentDTO> getAllEmployeeFutureAssignment(Long companyId)
	{
		// This method need to be made as batch job
		// updateAssignmentStatus(companyId);
		List<AssignmentDTO> assignmentList = new ArrayList<AssignmentDTO>();
		try
		{
			logger.log(Level.INFO, "Start getAllEmployeeFutureAssignment");
			
			List<MA_Employee> employees = getAllEmployeeForCompany(companyId);
			Calendar _currentDate = Calendar.getInstance();
			DateUtil.clearTimePart(_currentDate);
			
			logger.log(Level.INFO, "employees.size() =" + employees.size());
			
			Iterator<MA_Employee> itr = employees.iterator();
			int cnt = 0;
			while (itr.hasNext())
			{
				MA_Employee employee = itr.next();
				Key k = employee.getKey();
				AssignmentDTO assignmentDTO = new AssignmentDTO();
				assignmentDTO.setEmployeeId(k.getId());
				assignmentDTO.setEmployeeType(employee.getEmployeeType());
				assignmentDTO.setFirstName(employee.getFirstName());
				assignmentDTO.setLastName(employee.getLastName());
				assignmentDTO.setGender(employee.getGender());
				assignmentDTO.setCompanyEmpId(employee.getCompanyEmpId());
				
				logger.log(Level.INFO,
				        "Employee Id= " + employee.getCompanyEmpId());
				logger.log(Level.INFO, "counter= " + cnt);
				cnt++;
				MA_Assignment current_assignment = Datastore
				        .query(a)
				        .filter(a.employeeRef.equal(k),
				                a.status.equal(CURRENT_ASSIGNMENT)).asSingle();
				
				MA_Assignment future_assignment = Datastore
				        .query(a)
				        .filter(a.employeeRef.equal(k),
				                a.status.equal(FUTURE_ASSIGNMENT)).asSingle();
				
				logger.log(Level.INFO, "current_assignment ="
				        + current_assignment);
				logger.log(Level.INFO, "future_assignment ="
				        + future_assignment);
				
				if (null != current_assignment && null == future_assignment)
				{
					logger.log(Level.INFO, "Found Current Assignment");
					MA_Shift shift = current_assignment.getShiftRef().refresh();
					assignmentDTO.setShiftId(shift.getKey().getId());
					MA_Location location = shift.getLocationRef().refresh();
					assignmentDTO.setLocationId(location.getKey().getId());
					logger.log(Level.INFO, " assignment.getDeptRef()= "
					        + current_assignment.getDeptRef().getModel());
					if (null != current_assignment.getDeptRef().getModel())
					{
						assignmentDTO.setDepartmentId(("" + current_assignment
						        .getDeptRef().getKey().getId()).trim());
						
						logger.log(Level.INFO,
						        " assignmentDTO.getDepartmentId= "
						                + assignmentDTO.getDepartmentId());
					}
					assignmentDTO
					        .setShiftList(getAllShiftDTOForLocation(location
					                .getKey().getId()));
					assignmentDTO
					        .setDepartmentList(getAllDepartmentOfLocation(location
					                .getKey().getId()));
					
					Date newassignmentStartDate = DateUtil
					        .clearTimePart(current_assignment.getEndDate());
					
					Calendar c = Calendar.getInstance();
					c.setTime(newassignmentStartDate);
					c.add(Calendar.DATE, 1);
					
					assignmentDTO.setStartDt(DateUtil.toString(
					        new Date(c.getTimeInMillis()), "MM/dd/yyyy"));
					
					assignmentDTO.setStatus("OPEN");
					assignmentDTO.setEditable("Y");
					
				} else if (null != future_assignment)
				{
					logger.log(Level.INFO, "Found Future Assignment");
					MA_Shift shift = future_assignment.getShiftRef().refresh();
					assignmentDTO.setShiftId(shift.getKey().getId());
					MA_Location location = shift.getLocationRef().refresh();
					assignmentDTO.setLocationId(location.getKey().getId());
					logger.log(Level.INFO, " assignment.getDeptRef()= "
					        + future_assignment.getDeptRef().getModel());
					if (null != future_assignment.getDeptRef().getModel())
					{
						assignmentDTO.setDepartmentId(("" + future_assignment
						        .getDeptRef().getKey().getId()).trim());
						
						logger.log(Level.INFO,
						        " assignmentDTO.getDepartmentId= "
						                + assignmentDTO.getDepartmentId());
					}
					assignmentDTO
					        .setShiftList(getAllShiftDTOForLocation(location
					                .getKey().getId()));
					assignmentDTO
					        .setDepartmentList(getAllDepartmentOfLocation(location
					                .getKey().getId()));
					assignmentDTO.setStartDt(DateUtil.toString(
					        future_assignment.getStartDate(), "MM/dd/yyyy"));
					assignmentDTO.setEndDt(DateUtil.toString(
					        future_assignment.getEndDate(), "MM/dd/yyyy"));
					
					assignmentDTO.setStatus("ASSIGNED");
					assignmentDTO.setEditable("Y");
					
				} else
				{
					logger.log(Level.INFO, "No Current Or Future Assignment");
					Calendar c = Calendar.getInstance();
					c.add(Calendar.DATE, 1);
					assignmentDTO.setStartDt(DateUtil.toString(
					        new Date(c.getTimeInMillis()), "MM/dd/yyyy"));
					assignmentDTO.setStatus("OPEN");
					assignmentDTO.setEditable("Y");
				}
				
				assignmentList.add(assignmentDTO);
				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			
			logger.log(Level.INFO, "Exception -->" + e.getMessage());
			
		}
		return assignmentList;
		
	}
	
	/**
	 * Get an emplyoee's assignment
	 * 
	 * @param key
	 * @return
	 */
	public MA_Assignment getEmplyoeeAssignment(MA_Employee employee,
	        Integer status)
	{
		MA_Assignment _assignment = Datastore
		        .query(a)
		        .filter(a.employeeRef.equal(employee.getKey()),
		                a.status.equal(status)).asSingle();
		
		return _assignment;
	}
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	public List<MA_Location> getAllActiveLocationForCompany(Long companyId)
	{
		
		logger.log(Level.INFO, "Start getAllLocationForCompany");
		MA_Company company = new MA_Company();
		MA_Location location = new MA_Location();
		Key k = Datastore.createKey(MA_Company.class, companyId);
		company.setKey(k);
		location.getCompanyRef().setModel(company);
		List<MA_Location> location_list = Datastore.query(l)
		        .filter(l.companyRef.equal(k), l.active.equal("Y")).asList();
		readCounter++;
		logger.log(Level.INFO, "End getAllLocationForCompany");
		return location_list;
	}
	
	public List<MA_Shift> getAllActiveShifForLocation(long locationId)
	{
		logger.log(Level.INFO, "Start getAllShifForLocation");
		Key k = Datastore.createKey(MA_Location.class, locationId);
		List<MA_Shift> shift_list = Datastore.query(s)
		        .filter(s.locationRef.equal(k), s.active.equal("Y")).asList();
		
		logger.log(Level.INFO, "End getAllShifForLocation");
		return shift_list;
		
	}
	
	
	
	
}
