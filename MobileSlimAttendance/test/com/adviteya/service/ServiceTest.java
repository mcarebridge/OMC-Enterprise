package com.adviteya.service;

import static org.junit.Assert.assertNull;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_User;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.development.LocalServerEnvironment;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalTaskQueueTestConfig;

public class ServiceTest {

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
}
