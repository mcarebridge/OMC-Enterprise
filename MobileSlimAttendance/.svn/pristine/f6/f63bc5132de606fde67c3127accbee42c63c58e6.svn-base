package test.adviteya.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.adviteya.model.MA_Timesheet;
import com.adviteya.persistence.AbstractEntityDAO;

public class TestUpdateConsolidatedTimesheet {

    @Test
    public void testTimesheet()
    {
        
        List<MA_Timesheet> timesheets=new ArrayList<MA_Timesheet>();
        
        timesheets.add(new MA_Timesheet());
        for (Iterator<MA_Timesheet> iterator2 = timesheets.iterator(); iterator2
                .hasNext();)
        {
            
            System.out.println("hiiii");
            
            MA_Timesheet ma_Timesheet = (MA_Timesheet) iterator2
                    .next();
            
            if(ma_Timesheet!=null)
            {
                try {
                    AbstractEntityDAO.addModel(ma_Timesheet);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        
            }
        }
        System.out.println("bye");
        
    }
    
    
}
