package test.adviteya.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.util.DateUtil;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.meta.MA_ConsolidatedTimesheetMeta;
import com.adviteya.meta.MA_TimeSheetRuleMeta;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_ConsolidatedTimesheet;
import com.adviteya.model.MA_Shift;
import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.persistence.AbstractEntityDAO;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class UpdatePastConsolidatedTimesheets
{
	private static Logger logger = Logger.getLogger(UpdatePastConsolidatedTimesheets.class
	                                     .getName());
	
	@Test
	public void testFixPastConsolidateTimesheets()
	{
		try
		{
			
			Calendar _c = Calendar.getInstance();
			_c.set(Calendar.YEAR, 2012);
			_c.set(Calendar.MONTH, 10);
			_c.set(Calendar.DATE, 2);
			
			updatePastPlannedAssignmentConsolidatedTimeSheet(new Long(8001), _c);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param long1
	 * @param instance
	 * @throws IOException
	 */
	private void updatePastPlannedAssignmentConsolidatedTimeSheet(
	        Long companyId, Calendar currentDate) throws IOException
	{
		RemoteApiOptions options = new RemoteApiOptions().server(
		        "omcqa1.appspot.com", 443).credentials(
		        "ppatil@onemastercontrol.com", "javaru!es");
		//
		
		RemoteApiInstaller installer = new RemoteApiInstaller();
		installer.install(options);
		
		Map<String, Long> rulesMap = getTimesheetRulesMapOfCompany(companyId);
		
		Integer createDay = currentDate.get(Calendar.DAY_OF_MONTH);
		Integer createMonth = currentDate.get(Calendar.MONTH);
		Integer createYear = currentDate.get(Calendar.YEAR);
		Integer createHour = currentDate.get(Calendar.HOUR_OF_DAY);
		Integer createMin = currentDate.get(Calendar.MINUTE);
		
		SimpleDateFormat _s = new SimpleDateFormat("MMM-dd-yyyy hh:mm:ss");
		
		MA_ConsolidatedTimesheetMeta consolidatedTimesheetMeta = MA_ConsolidatedTimesheetMeta
		        .get();
		MA_AssignmentMeta assignmentMeta = MA_AssignmentMeta.get();
		
		List<MA_ConsolidatedTimesheet> consolidatedTimeSheetList = Datastore
		        .query(consolidatedTimesheetMeta)
		        .filter(consolidatedTimesheetMeta.createDay.equal(createDay),
		                consolidatedTimesheetMeta.createMonth
		                        .equal(createMonth),
		                consolidatedTimesheetMeta.outDateTime.isNotNull(),
		                consolidatedTimesheetMeta.outTimeResult
		                        .equal(new Integer(-1))).asList();
		
		for (Iterator iterator = consolidatedTimeSheetList.iterator(); iterator
		        .hasNext();)
		{
			MA_ConsolidatedTimesheet consolidatedTimeSheet = (MA_ConsolidatedTimesheet) iterator
			        .next();
			
			MA_Shift shift = consolidatedTimeSheet.getShiftRef().getModel();
			
			Calendar shiftStartTime = Calendar.getInstance();
			shiftStartTime.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));
			shiftStartTime.set(Calendar.MONTH, currentDate.get(Calendar.MONTH));
			shiftStartTime.set(Calendar.DATE, currentDate.get(Calendar.DATE));
			
			shiftStartTime.set(Calendar.HOUR_OF_DAY, shift.getStartHrs());
			shiftStartTime.set(Calendar.MINUTE, shift.getStartMin());
			shiftStartTime.set(Calendar.SECOND, 0);
			shiftStartTime.set(Calendar.MILLISECOND, 0);
			
			Calendar shiftEndTime = Calendar.getInstance();
			shiftEndTime.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));
			shiftEndTime.set(Calendar.MONTH, currentDate.get(Calendar.MONTH));
			shiftEndTime.set(Calendar.DATE, currentDate.get(Calendar.DATE));
			shiftEndTime.set(Calendar.HOUR_OF_DAY, shift.getEndHrs());
			shiftEndTime.set(Calendar.MINUTE, shift.getEndMin());
			shiftEndTime.set(Calendar.SECOND, 0);
			shiftEndTime.set(Calendar.MILLISECOND, 0);
			
			logger.log(
			        Level.INFO,
			        "---->" + shift.getShiftName() + "---"
			                + _s.format(shiftStartTime.getTime()) + "---"
			                + _s.format(shiftEndTime.getTime()));
			
			// If flexible time is not allowed
			if (rulesMap.get(IMobileAttendanceConstants.FLEXIBEL_TIME) == 1)
			{
				boolean lateInFlag = false;
				
				// if (consolidatedTimeSheet.getInTimeResult().intValue() ==
				// IMobileAttendanceConstants.LATE_IN)
				// {
				// lateInFlag = true;
				// }
				
				// Check for out time.
				if (null != consolidatedTimeSheet.getInDateTime())
				{
					Long inTime = consolidatedTimeSheet.getInDateTime()
					        .getTime();
					
					Long lateMark = shiftStartTime.getTimeInMillis()
					        + (rulesMap
					                .get(IMobileAttendanceConstants.LATE_MRK_TOLERANCE) * 1000);
					
					Long earlyIn = shiftStartTime.getTimeInMillis()
					        - (rulesMap
					                .get(IMobileAttendanceConstants.EARLY_IN_TOLERANCE) * 1000);
					
					if (inTime >= earlyIn && inTime <= lateMark)
					{
						
						consolidatedTimeSheet
						        .setInTimeResult(IMobileAttendanceConstants.RIGHT_IN);
						
					} else if (inTime < earlyIn)
					{
						consolidatedTimeSheet
						        .setInTimeResult(IMobileAttendanceConstants.EARLY_IN);
					} else
					{
						consolidatedTimeSheet
						        .setInTimeResult(IMobileAttendanceConstants.LATE_IN);
					}
					
				}
				
				if (null != consolidatedTimeSheet.getOutDateTime())
				{
					
					Long outTime = consolidatedTimeSheet.getOutDateTime()
					        .getTime();
					
					Long earlyOut = shiftEndTime.getTimeInMillis()
					        - (rulesMap
					                .get(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE) * 1000);
					
					Long lateOut = shiftEndTime.getTimeInMillis()
					        + (rulesMap
					                .get(IMobileAttendanceConstants.LATE_OUT_TOLERANCE) * 1000);
					
					if (outTime >= earlyOut && outTime <= lateOut)
					{
						consolidatedTimeSheet
						        .setOutTimeResult(IMobileAttendanceConstants.RIGHT_OUT);
						
					} else if (outTime < earlyOut)
					{
						consolidatedTimeSheet
						        .setOutTimeResult(IMobileAttendanceConstants.EARLY_OUT);
					} else
					{
						consolidatedTimeSheet
						        .setOutTimeResult(IMobileAttendanceConstants.LATE_OUT);
					}
				}
				
			}
			
			/**
			 * This section calculates the FLAG for the daily effort
			 * 
			 * <pre>
			 * 1. TODO : MIN_DAILY_EFFORTS should be calculated from Shift duration rather from Rules
			 * 2. The non-working days should be marked for Leave and WeekEnd
			 * </pre>
			 */
			
			Long timeDiff = 0L;
			if (null != consolidatedTimeSheet.getOutDateTime())
			{
				timeDiff = (consolidatedTimeSheet.getOutDateTime().getTime() - consolidatedTimeSheet
				        .getInDateTime().getTime()) / 1000;
			}
			consolidatedTimeSheet.setDailyEffort(new Double(timeDiff));
			
			// Working hours are less then min daily
			// effort.
			// Double actualDailyEffort = consolidatedTimeSheet
			// .getActualDailyEffort();
			Double actualDailyEffort = new Double(timeDiff);
			consolidatedTimeSheet.setActualDailyEffort(actualDailyEffort);
			
			Double shiftDuration = new Double(
			        (shiftEndTime.getTimeInMillis() / 1000)
			                - (shiftStartTime.getTimeInMillis() / 1000));
			
			// Give a leeway of 15 mins. i.e. if someone
			// has
			// 15 less effort is still counted as Right
			// effort
			
			if (actualDailyEffort < rulesMap
			        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS))
			{
				
				if (actualDailyEffort
				        + rulesMap
				                .get(IMobileAttendanceConstants.EARLY_LEFT_TOLERANCE) < rulesMap
				            .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS))
				{
					
					Long minEffortsForHalfDay = rulesMap
					        .get(IMobileAttendanceConstants.MIN_HALF_DAY_EFFORTS)
					        + rulesMap
					                .get(IMobileAttendanceConstants.HALF_DAY_TOLERANCE);
					
					if (actualDailyEffort < minEffortsForHalfDay)
					{
						
						consolidatedTimeSheet
						        .setEffortResult(IMobileAttendanceConstants.UNPAID_LEAVE);
					} else
					{
						
						if (actualDailyEffort > minEffortsForHalfDay
						        && consolidatedTimeSheet.getDailyEffort() >= rulesMap
						                .get(IMobileAttendanceConstants.MIN_HALF_CONTINUOUS_HRS))
						{
							
							consolidatedTimeSheet
							        .setEffortResult(IMobileAttendanceConstants.HALF_DAY);
						} else
						{
							consolidatedTimeSheet
							        .setEffortResult(IMobileAttendanceConstants.LESS_EFFORT);
						}
						
					}
				}
				
			} else if (actualDailyEffort > (rulesMap
			        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS)
			        + rulesMap
			                .get(IMobileAttendanceConstants.MIN_OVER_TIME_EFFORTS) - rulesMap
			            .get(IMobileAttendanceConstants.OVER_TIME_TOLERANCES)))
			{
				consolidatedTimeSheet
				        .setEffortResult(IMobileAttendanceConstants.OVER_TIME);
				consolidatedTimeSheet
				        .setOverTime(actualDailyEffort
				                - rulesMap
				                        .get(IMobileAttendanceConstants.MIN_DAILY_EFFORTS));
				
			} else
			{
				consolidatedTimeSheet
				        .setEffortResult(IMobileAttendanceConstants.RIGHT_EFFORT);
			}
			// logger.log(Level.INFO, "-- UPDATING CONSOLIDATED TIMEHSEETS --");
			consolidatedTimeSheet.setMarker("UPDATED");
			
			/*********************************************************/
			logger.log(
			        Level.INFO,
			        consolidatedTimeSheet.getKey() + ","
			                + _s.format(consolidatedTimeSheet.getInDateTime())
			                + ","
			                + _s.format(consolidatedTimeSheet.getOutDateTime())
			                + "," + consolidatedTimeSheet.getInTimeResult()
			                + "," + consolidatedTimeSheet.getOutTimeResult()
			                + "," + consolidatedTimeSheet.getEffortResult()
			                + ","
			                + consolidatedTimeSheet.getActualDailyEffort()
			                + "," + consolidatedTimeSheet.getOverTime());
			
		}
		
	}
	
	/**
	 * 
	 * @param companyId
	 * @return
	 * @throws IOException
	 */
	public Map<String, Long> getTimesheetRulesMapOfCompany(Long companyId)
	        throws IOException
	{
		
		MA_TimeSheetRuleMeta timeSheetRuleMeta = MA_TimeSheetRuleMeta.get();
		MA_Company company = new MA_Company();
		Key k1 = AbstractEntityDAO.createKey(company, companyId);
		List<MA_TimeSheetRule> timeSheetRules = Datastore
		        .query(timeSheetRuleMeta)
		        .filter(timeSheetRuleMeta.companyRef.equal(k1)).asList();
		
		Iterator<MA_TimeSheetRule> itr = timeSheetRules.iterator();
		Map<String, Long> rulesMap = new HashMap<String, Long>();
		
		while (itr.hasNext())
		{
			MA_TimeSheetRule timeSheetRule = itr.next();
			rulesMap.put(timeSheetRule.getRuleKey(), timeSheetRule.getValue());
		}
		
		return rulesMap;
	}
	
}
