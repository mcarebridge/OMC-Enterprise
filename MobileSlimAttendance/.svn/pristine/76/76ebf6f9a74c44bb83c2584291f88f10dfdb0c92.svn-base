package test.adviteya.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

public class TestTimeChange {

    @Test
    public void test() {
        
        Calendar localTime = Calendar.getInstance();
       

        int hour = localTime.get(Calendar.HOUR);
        int minute = localTime.get(Calendar.MINUTE);
        int second = localTime.get(Calendar.SECOND);


        // Print the local time

        System.out.printf("Local time  : %02d:%02d:%02d\n", hour, minute, second);


        // Create a calendar object for representing a Germany time zone. Then we
        // wet the time of the calendar with the value of the local time
        String id[]=TimeZone.getAvailableIDs();
        for(String i:id)
        {
            System.out.println(i);
        }
        Calendar germanyTime = new GregorianCalendar(TimeZone.getTimeZone("Etc/GMT-3"));
        germanyTime.setTimeInMillis(localTime.getTimeInMillis());
        hour = germanyTime.get(Calendar.HOUR);
        minute = germanyTime.get(Calendar.MINUTE);
        second = germanyTime.get(Calendar.SECOND);


        // Print the local time in Germany time zone

        System.out.printf("ETC time: %02d:%02d:%02d\n", hour, minute, second);
        
        
       
    }

}
