package test.adviteya.mobile.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.datastore.ModelQuery;
import org.slim3.datastore.Sort;
import org.slim3.util.DateUtil;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.meta.MA_ConsolidatedTimesheetMeta;
import com.adviteya.meta.MA_TimeSheetRuleMeta;
import com.adviteya.meta.MA_TimesheetMeta;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_ConsolidatedTimesheet;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.persistence.TimesheetDAO;
import com.adviteya.service.EntityService;
import com.adviteya.service.TimeSheetBusinessService;
import com.adviteya.util.AssignmentHelper;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class TestConsolidatedTimesheetLogic
{
	
	private static Logger logger  = Logger.getLogger(TestConsolidatedTimesheetLogic.class
	                                      .getName());
	
	private EntityService service = EntityService.getInstance();
	
	@Test
	public void testConsolidatedEffortFlag()
	{
		
		// HashMap rulesMap = new HashMap<String, Long>();
		// rulesMap.put(IMobileAttendanceConstants.FLEXIBEL_TIME, new Long(1));
		// rulesMap.put(IMobileAttendanceConstants.LATE_MRK_TOLERANCE, new Long(
		// 900));
		// rulesMap.put(IMobileAttendanceConstants.EARLY_IN_TOLERANCE, new Long(
		// 900));
		// rulesMap.put(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE, new
		// Long(
		// 900));
		// rulesMap.put(IMobileAttendanceConstants.LATE_OUT_TOLERANCE, new Long(
		// 1800));
		// rulesMap.put(IMobileAttendanceConstants.MIN_DAILY_EFFORTS, new Long(
		// 30600));
		// rulesMap.put(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS, new
		// Long(
		// 16200));
		// rulesMap.put(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE, new
		// Long(
		// 900));
		// rulesMap.put(IMobileAttendanceConstants.HALF_DAY_TOLERANCE, new Long(
		// 1800));
		// rulesMap.put(IMobileAttendanceConstants.MIN_HALF_CONTINUOUS_HRS,
		// new Long(18000));
		// rulesMap.put(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS,
		// new Long(10800));
		// rulesMap.put(IMobileAttendanceConstants.OVER_TIME_TOLERANCES, new
		// Long(
		// 1800));
		//
		// Calendar shiftStartTime = Calendar.getInstance();
		// shiftStartTime.set(Calendar.HOUR_OF_DAY, 6);
		// shiftStartTime.set(Calendar.MINUTE, 30);
		// shiftStartTime.set(Calendar.SECOND, 0);
		// shiftStartTime.set(Calendar.MILLISECOND, 0);
		//
		// Calendar shiftEndTime =
		// DateUtil.clearTimePart(Calendar.getInstance());
		// shiftEndTime.set(Calendar.HOUR_OF_DAY, 15);
		// shiftEndTime.set(Calendar.MINUTE, 0);
		// shiftEndTime.set(Calendar.SECOND, 0);
		// shiftEndTime.set(Calendar.MILLISECOND, 0);
		//
		// Calendar _inTime = Calendar.getInstance();
		// _inTime.set(2012, 10, 23, 15, 00, 00);
		// Calendar _outTime = Calendar.getInstance();
		// _outTime.set(2012, 10, 23, 23, 23, 00);
		//
		// MA_ConsolidatedTimesheet consolidatedTimeSheet = new
		// MA_ConsolidatedTimesheet();
		// consolidatedTimeSheet.setInDateTime(_inTime.getTime());
		// consolidatedTimeSheet.setOutDateTime(_outTime.getTime());
		// consolidatedTimeSheet.setInTimeResult(new Integer(1));
		// consolidatedTimeSheet.setOutTimeResult(new Integer(1));
		// consolidatedTimeSheet.setActualDailyEffort(new Double(30580));
		//
		// checkEffort(consolidatedTimeSheet, rulesMap, shiftStartTime,
		// shiftEndTime);
		
//		try
//		{
//			updatePlannedAssignmentConsolidatedTimeSheet(new Long(102051),
//			        Calendar.getInstance(), false);
//		} catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	}
