package com.adviteya.controller.humancapital;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.DateUtil;

import com.adviteya.dto.ConsolidatedTimeSheetDTO;
import com.adviteya.service.EmployeeService;
import com.adviteya.service.EntityService;
import com.adviteya.service.TimeSheetBusinessService;

public class ConsolidatedTimesheetReportController extends BaseController
{
	
	private static Logger            logger          = Logger.getLogger(ConsolidatedTimesheetReportController.class
	                                                         .getName());
	
	private EntityService            service         = EntityService
	                                                         .getInstance();
	private TimeSheetBusinessService businessService = new TimeSheetBusinessService();
	private EmployeeService          employeeServise = new EmployeeService();
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		
		pageTitle = "title.detailedPeriodicReport";
		pageHeader = "page.detailedPeriodicReport";
		
		String ConsolidatedNote1 = "page.ConsolidatedNote1";
		String ConsolidatedNote2 = "page.ConsolidatedNote2";
		String action = requestScope("actionParam");
		String startDate = requestScope("startDate");
		String month = requestScope("month");
		String employeeId = requestScope("employeeId");
		String toDate = requestScope("toDate");
		
		SimpleDateFormat monthNameFormat = new SimpleDateFormat("MM-MMMM-yyyy");
		List<String> monthNames = new ArrayList<String>();
		toDate = startDate;
		String _startDate = null;
		Date date = new Date();
		Calendar currentCal = Calendar.getInstance();
		int currentMonthNo = currentCal.get(Calendar.MONTH);
		
		currentCal.add(Calendar.MONTH, -1);
		
		date = currentCal.getTime();
		monthNames.add(monthNameFormat.format(date));
		currentCal = Calendar.getInstance();
		date = currentCal.getTime();
		monthNames.add(monthNameFormat.format(date));
		
		List<ConsolidatedTimeSheetDTO> consolidatedTimeSheetDTOs = new ArrayList<ConsolidatedTimeSheetDTO>();
		Long companyId = sessionScope("companyId");
		logger.log(Level.INFO, companyId.toString());
		
		if (action != null && action.equals("approve"))
		{
			String[] billableEfforts = request
			        .getParameterValues("billableEffort");
			String timesheetIdStr = request.getParameter("timeSheetIds");
			String[] timesheetIds = timesheetIdStr.split(",");
			/*
			 * changes are done in order to avoid duplicate timesheet Id  
			 */
			Set<String> _timesheetid=new TreeSet<String>();
			for(String s:timesheetIds)
			{
				_timesheetid.add(s);
			}
			TreeMap<String, String> approveMap = new TreeMap<String, String>();
			int cnt=0;
			
			for(String a:_timesheetid)
			{
				approveMap.put(a, billableEfforts[cnt]);
				cnt++;			
			}
			
			businessService.approveConsolidatedTimesheets(companyId,
			        approveMap);
		} else if (action != null && action.equals("search"))
		{
			// DateFormat _dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			logger.log(Level.INFO, "Start Date--" + startDate + "   End Date-"
			        + toDate);
			Validators v = new Validators(request);
			
			boolean _eitherMonthOrDateFound = false;
			
			if (validate(v))
			{
				if (employeeId != null
				        && !employeeId.equals("")
				        && employeeServise.isEmployeeExists(companyId,
				                employeeId))
				{
					if (startDate != null && !startDate.equals(""))
					{
						_eitherMonthOrDateFound = true;
						consolidatedTimeSheetDTOs = businessService
						        .getConsolidtaedTimeSheet(companyId, startDate,
						                toDate, employeeId);
						showErrBox = false;
					} else if (month != null && !month.equals(""))
					{
						logger.log(Level.INFO, "Month --" + month
						        + "   Employee Id -" + employeeId);
						_eitherMonthOrDateFound = true;
						String str[] = month.split("-");
						String _digitMonth = str[0];
						String _digitYear = str[2];
						int _numMonth = Integer.parseInt(_digitMonth);
						int _numYear = Integer.parseInt(_digitYear);
						_numMonth--;
						
						Calendar _stDate = Calendar.getInstance();
						_stDate.set(Calendar.DATE, 1);
						_stDate.set(Calendar.MONTH, _numMonth);
						_stDate.set(Calendar.YEAR, _numYear);
						
						Calendar _enDate = Calendar.getInstance();
						_enDate.set(Calendar.MONTH, _numMonth);
						_enDate.set(Calendar.DATE,
						        _enDate.getActualMaximum(Calendar.DATE));
						_enDate.set(Calendar.YEAR, _numYear);
						
						SimpleDateFormat _s = new SimpleDateFormat(
						        "dd-MMM-yyyy");
						while (_stDate.getTimeInMillis() < _enDate
						        .getTimeInMillis())
						{
							logger.log(Level.INFO, "Start Date------->"
							        + _stDate.getTime());
							_startDate = DateUtil.toString(_stDate.getTime(),
							        "MM/dd/yyyy");
							List<ConsolidatedTimeSheetDTO> conDTOs = businessService
							        .getConsolidtaedTimeSheet(companyId,
							                _startDate, _startDate, employeeId);
							
							consolidatedTimeSheetDTOs.addAll(conDTOs);
							_stDate.add(Calendar.DATE, 1);
							
						}
					} else if (!_eitherMonthOrDateFound)
					{
						v.getErrors().put("",
						        "Please select a Date or a Valid Month");
						showErrBox = true;
					}
				} else if (startDate != null && !startDate.equals(""))
				{
					_eitherMonthOrDateFound = true;
					consolidatedTimeSheetDTOs = businessService
					        .getConsolidtaedTimeSheet(companyId, startDate,
					                toDate, employeeId);
				} else
				{
					v.getErrors()
					        .put("",
					                "Employee Not found. Please enter valid Employee Id");
					showErrBox = true;
				}
			} else
			{
				showErrBox = true;
			}
			
			logger.log(Level.INFO, "Size--" + consolidatedTimeSheetDTOs.size());
		}
		
		requestScope("ConsolidatedNote1", ConsolidatedNote1);
		requestScope("ConsolidatedNote2", ConsolidatedNote2);
		requestScope("monthNames", monthNames);
		requestScope("dailyAttendanceRecord", consolidatedTimeSheetDTOs);
		requestScope("month", month);
		
		return forward("consolidatedTimesheetReport.jsp");
	}
	
	private boolean validate(Validators v)
	{
		String employeeId = requestScope("employeeId");
		String startDate = requestScope("startDate");
		String month = requestScope("month");
		
		if (month != null && !month.equals(""))
		{
			if (employeeId.equals(""))
			{
				v.getErrors().put("  ",
				        "Select Employee Id While selecting Month ");
				return false;
			}
		} else if (employeeId != null && employeeId.equals("") && month != null
		        && month.equals("") && startDate.equals(""))
		{
			v.getErrors()
			        .put("  ",
			                "Select Start Date or Start Date and Employee Id or Month and Employee Id");
			
			return false;
		}
		
		return true;
	}
}
