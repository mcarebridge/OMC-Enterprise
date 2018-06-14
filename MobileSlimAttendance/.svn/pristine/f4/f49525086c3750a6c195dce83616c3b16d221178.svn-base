package com.adviteya.service;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.adviteya.dto.ConsolidatedTimeSheetDTO;
import com.adviteya.util.MADateUtil;

public class TimeSheetTest {
    
    private static Logger         logger = Logger.getLogger(TimeSheetTest.class
        .getName());
    @Test
    public void testTimeSheet() {
        
//        CronJobService cronJob=CronJobService.getInstance();
//        
//        cronJob.storeWeeklyTimesheets();
        
        Calendar _c = Calendar.getInstance();
        int weekNumber = _c.get(Calendar.WEEK_OF_YEAR);
        int year = _c.get(Calendar.YEAR);
        // We need to pull out report of last week.
        Calendar _weekStart = MADateUtil
                .getStartDayOfWeek(weekNumber - 1, year);
        Calendar _weekEnd = MADateUtil.getLastDayOfWeek(weekNumber - 1, year);

        while (_weekStart.before(_weekEnd))
        {
            IPayRollBusinessService businessService = new PayRollBusinessService();
            SimpleDateFormat _sdf = new SimpleDateFormat();
            _sdf.setCalendar(_weekStart);
            logger.log(Level.INFO, "Extarcting reports for ---------> "
                    + _sdf.format(_weekStart.getTime()));
            
//            List<ConsolidatedTimeSheetDTO> consolidatedTimeSheetDTOs = businessService
//                    .getCurrentDayTimeSheet(
//                            ma_Company.getKey().getId(), _weekStart);
//            
//            _weeklyTimeSheetAsCSV
//                    .append(convertTimeDTOtoString(consolidatedTimeSheetDTOs));
//            
            _weekStart.add(Calendar.DATE, 1);
        }
        
       
    }
}
