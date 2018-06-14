package com.adviteya.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.util.DateUtil;

import com.adviteya.controller.humancapital.CronJobSchedulerController;
import com.adviteya.model.MA_PayrollReport;
import com.adviteya.model.MA_WeeklyEffortReport;
import com.adviteya.model.MA_WeeklyPayrollReport;
import com.adviteya.service.PayRollBusinessService;
import com.adviteya.service.WeeklyRecordBusinessService;

public class WeeklyReportUtil
{
	private static final Logger logger = Logger.getLogger(CronJobSchedulerController.class
            .getName());
	
	/**
	 * 
	 * @param companyId
	 * @param weekNo
	 * @return
	 */
	public static String getTimesheetCsvString(long companyId, Date startDate)
	{
		WeeklyRecordBusinessService businessService = WeeklyRecordBusinessService
                .getInstance();
		MA_WeeklyEffortReport weeklyEffortReport = businessService
		        .getWeeklyEffortReport(companyId, startDate);
		
		String csvString = "Employee Id,Employee Name,Location(TimeZone),Shift,Department,"
		        + "CreatedDate,InTime Geo Points,InTime,Out Time Geo Points,OutTime"
		        + '\n';
		csvString = csvString + weeklyEffortReport.getWeeklyReport().getValue();
		
		return csvString;
	}
	
	/**
	 * 
	 * @param weekNo
	 * @return
	 */
	public static String getTimesheetFileName(long companyId, Date startDate)
	{
		WeeklyRecordBusinessService businessService = WeeklyRecordBusinessService
                .getInstance();
		MA_WeeklyEffortReport weeklyEffortReport = businessService
		        .getWeeklyEffortReport(companyId, startDate);
		
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		int firstDay = c.get(Calendar.DATE);
		Date date = weeklyEffortReport.getWeekEndDate();
		SimpleDateFormat _sdf = new SimpleDateFormat("dd_MMM_yyyy");
		String endDate = _sdf.format(date);
		String reportFileName = "Weekly_Timesheet_" + firstDay + "_" + endDate
		        + ".csv";
		return reportFileName;
	}

	/**
	 * @param companyId
	 * @param startDate
	 * @return
	 */
	public static String getPayrollCsvString(long companyId, Date startDate)
    {
		PayRollBusinessService businessService = new PayRollBusinessService();
		Calendar calendar=DateUtil.toCalendar(startDate);
		logger.log(Level.INFO, "-- Calendar Month :"+calendar.get(Calendar.MONTH));
		MA_PayrollReport payrollReport = businessService
		        .getMonthlyPayrollReport(companyId, calendar.get(Calendar.MONTH));
		
		String csvString = "Emp Code,Employee Name,Type,Designation,Calendar days,Present days,WO,C off,PH,PL,CL,Worked Day,Absent days,OT"
		        + '\n';
		csvString = csvString + payrollReport.getReport().getValue();
		
		return csvString;
	    
    }

	/**
	 * @param companyId
	 * @param startDate
	 * @return
	 */
	
	public static String getPayrollFileName(long companyId, Date startDate)
    {
		PayRollBusinessService businessService = new PayRollBusinessService();
		Calendar calendar=DateUtil.toCalendar(startDate);
				
		SimpleDateFormat _sdf = new SimpleDateFormat("MMMM");
		String month = _sdf.format(calendar.getTime());
		String reportFileName = "Monthly_Payroll_" + month + ".csv";
		return reportFileName;
    }
	
}
