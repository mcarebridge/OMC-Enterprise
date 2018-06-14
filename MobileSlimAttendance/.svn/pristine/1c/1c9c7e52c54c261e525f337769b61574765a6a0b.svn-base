package test.adviteya.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


import org.junit.Test;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;



public class TestJodaTime {

    @Test
    public void test() {
        DateTime dt = new DateTime();
        String id = dt.getZone().getID();
        System.out.println(dt.toString()+"           "+id);
        
        Integer timeoffset = Integer.parseInt("-330");
        String offset = (timeoffset < 0 ? "+" : "-")
                + Math.abs((int) (timeoffset / 60)) + ""
                + Math.abs((timeoffset % 60));
        
        TimeZone tz = TimeZone.getTimeZone("GMT" + offset);
        
        DateTimeZone jdtz=DateTimeZone.forTimeZone(tz);        
        System.out.println(jdtz);
        
       String tzid[]=TimeZone.getAvailableIDs();
       
       for(String id1 : tzid)
       {
           System.out.println(id1);
       }
        
       
        long time =jdtz.convertLocalToUTC(dt.getMillis(), false);
        System.out.println(time);
       
        
       Calendar cal=Calendar.getInstance();
       cal.clear();
          
       cal.setTimeInMillis(time);
       SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
       String s=sdf.format(cal.getTime());
        System.out.println(cal.getTime()+"         "+s);  
        cal.add(Calendar.MILLISECOND, (-timeoffset*60*1000));
      System.out.println(cal.getTime());
    }
    
   
}
