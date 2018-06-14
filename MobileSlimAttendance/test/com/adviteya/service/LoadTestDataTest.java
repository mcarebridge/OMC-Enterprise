package com.adviteya.service;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adviteya.datasetup.DataFeedReader;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_State;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.development.LocalServerEnvironment;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalTaskQueueTestConfig;

public class LoadTestDataTest {

    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
        new LocalTaskQueueTestConfig()) {
        @Override
        protected LocalServerEnvironment newLocalServerEnvironment() {
            final LocalServerEnvironment lse =
                super.newLocalServerEnvironment();
            return new LocalServerEnvironment() {
                public File getAppDir() {
                    return new File("war");
                }

                public String getAddress() {
                    return lse.getAddress();
                }

                public int getPort() {
                    return lse.getPort();
                }

                public void waitForServerToStart() throws InterruptedException {
                    lse.waitForServerToStart();
                }

                public boolean enforceApiDeadlines() {
                    // TODO Auto-generated method stub
                    return false;
                }

                public boolean simulateProductionLatencies() {
                    // TODO Auto-generated method stub
                    return false;
                }

                public String getHostName() {
                    // TODO Auto-generated method stub
                    return null;
                }
            };
        }
    };

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void testDataload() {

        String testDataFilepath =
            "C:/Userlib/Userlib/devarea/adviteya/Testdata/";
        DataFeedReader dfr = new DataFeedReader();

        /**
         * Sequence of loading testdata 1. country 2. state 3. Nature of Company
         * 4. User Profile 5. User 6. Company 7. Employee 8. Address 9. Location
         * 10. Shift 11. Timesheet
         * 
         */
        // 1. Load Countries
        List entityList = null;
        try {
            entityList = dfr.loadFileDataToEntity(
                testDataFilepath.concat("country.csv"),
                "MA_Country");
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("######### Add Countries :" + entityList.size());

        for (int i = 0; i < entityList.size(); i++) {

            MA_Country c = (MA_Country) entityList.get(i);
            System.out.println(c.getKey().getId());
        }

        try {
            entityList =
                dfr.loadFileDataToEntity(
                    testDataFilepath.concat("state.csv"),
                    "MA_State");
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        for (int i = 0; i < entityList.size(); i++) {

            MA_State s = (MA_State) entityList.get(i);
            System.out.println(s.getCountryRef().getKey().getId());
        }
        

        assertFalse(entityList.isEmpty());

    }
}
