package com.adviteya.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slim3.controller.Navigation;

import com.adviteya.controller.humancapital.BaseController;

public class TestController extends BaseController {

    @Override
    public Navigation executeLogic() throws Exception {
              
        String timeZoneId = requestScope("timezone");
        String action = requestScope("actionParam");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm");
       
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
      
        
        String s = requestScope("Current");
        String s1 =requestScope("CurrentTime");

        if (action.equalsIgnoreCase("submit")) {

            DateTime dt = new DateTime(sdf2.parse(s+" "+s1).getTime());
          
            
            
            DateTimeZone jdtz = DateTimeZone.forID(timeZoneId);

             long time =jdtz.convertLocalToUTC(dt.getMillis(), false);
            //long time = jdtz.convertUTCToLocal(dt.getMillis());
            Calendar cal = Calendar.getInstance();
            cal.clear();

            cal.setTimeInMillis(time);

         
            
            requestScope("GMT", sdf.format(new Date(cal.getTimeInMillis())));
            requestScope("GMTTime", sdf1.format(new Date(cal.getTimeInMillis())));
            requestScope("Current", s);
            requestScope("CurrentTime", s1);
        }

        

        Set<String> timezone = DateTimeZone.getAvailableIDs();

        requestScope("timezonelist", timezone);

        return forward("testJodaTime.jsp");
    }

}
