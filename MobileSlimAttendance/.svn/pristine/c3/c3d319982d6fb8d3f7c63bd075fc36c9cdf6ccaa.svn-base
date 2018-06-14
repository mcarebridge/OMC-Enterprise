package com.adviteya.service;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adviteya.model.MA_Country;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.development.LocalServerEnvironment;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalTaskQueueTestConfig;

public class LookupEntityTest {

    // private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
    // new LocalDatastoreServiceTestConfig());

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
    public void testAddCountry() throws Exception {

        ArrayList<MA_Country> countryList = new ArrayList<MA_Country>();
        MA_Country _c1 = new MA_Country();
        _c1.setCountryName("Denmark");
        countryList.add(_c1);

        MA_Country _c2 = new MA_Country();
        _c2.setCountryName("Austria");
        countryList.add(_c2);

        List<Key> keys = new LookUpEntityService().createCountries(countryList);

        for (int i = 0; i < keys.size(); i++) {

            Key k = (Key) keys.get(i);
            System.out.println("------------" + k.getId());
        }

        assertNotNull(keys);
    }
}
