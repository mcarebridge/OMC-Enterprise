package com.adviteya.remote;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.adviteya.dto.ConsolidatedTimeSheetDTO;
import com.adviteya.service.MonthWeekTest;
import com.adviteya.service.PayRollBusinessService;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class ReadTimesheetTest {
    public static void main(String[] args) throws IOException {
        
        
      
        
        
//        RemoteApiOptions options =
//            new RemoteApiOptions()
//                .server("omcqa1.appspot.com", 443)
//                .credentials("hrmastercontrol@gmail.com", "xxxxxx");
        //
         RemoteApiOptions options =
         new RemoteApiOptions().server("localhost", 80).credentials("", "");

        WritableWorkbook workbook =
            Workbook.createWorkbook(new File("output.xls"));
        RemoteApiInstaller installer = new RemoteApiInstaller();
        installer.install(options);
        try {

            PayRollBusinessService prbs = new PayRollBusinessService();

            WritableSheet sheet = workbook.createSheet("First Sheet", 0);

            Long companyId = new Long(252051);
            Calendar currentDate = Calendar.getInstance();
            currentDate.set(Calendar.DATE, 1);
            currentDate.set(Calendar.MONTH, 7);
            currentDate.set(Calendar.YEAR, 2012);

            List<ConsolidatedTimeSheetDTO> consolidateTimeSheet =
                prbs.getCurrentDayTimeSheet(companyId, currentDate);

            Iterator iterator = consolidateTimeSheet.iterator();
            for (int i = 0; iterator.hasNext(); i++) {

                System.out.println("----------------> i = " + i);
                ConsolidatedTimeSheetDTO consolidatedTimeSheetDTO =
                    (ConsolidatedTimeSheetDTO) iterator.next();

                Label label =
                    new Label(i, 1, consolidatedTimeSheetDTO
                        .getCompanyEmpId()
                        .toString());
                sheet.addCell(label);

                label =
                    new Label(i, 2, consolidatedTimeSheetDTO.getEmployeeName());
                sheet.addCell(label);

                label = new Label(i, 3, consolidatedTimeSheetDTO.getInTime());
                sheet.addCell(label);

                label = new Label(i, 4, consolidatedTimeSheetDTO.getOutTime());
                sheet.addCell(label);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workbook.write();
            try {
                workbook.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            installer.uninstall();
        }
    }
}
