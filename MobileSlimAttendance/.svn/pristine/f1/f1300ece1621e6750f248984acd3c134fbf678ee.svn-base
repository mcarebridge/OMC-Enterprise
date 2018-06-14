package com.adviteya.service;

import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adviteya.model.MA_Address;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Country;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_State;
import com.adviteya.model.MA_User;
import com.adviteya.model.MA_UserProfile;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class UserTest {

    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
        new LocalDatastoreServiceTestConfig());

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void testUserCreation() throws Exception {
        //
        MA_User user = new MA_User();
        MA_Employee employee = new MA_Employee();
        MA_Address empAddress = new MA_Address();
        MA_UserProfile userProfile = new MA_UserProfile();

        MA_Company company = new MA_Company();
        MA_Address companyAddress = new MA_Address();
        
        employee.setFirstName("");
        employee.setLastName("");
        employee.setSalutation("");
//        employee.setGender(new Short("1"));
        
        MA_Country country = new MA_Country();
        MA_State state     = new MA_State();
        
        empAddress.setLine1("");
        empAddress.setLine2("");
        empAddress.setCity("");
        empAddress.setPinCode("");
        empAddress.setCity("");
        empAddress.getStateRef().setKey(state.getKey());

        
        
        
        companyAddress.getCompanyRef().setModel(company);
        user.getCompanyRef().setModel(company);
        user.getUserProfileRef().setModel(userProfile);

        // assertThat(service, is(notNullValue()));
    }

    @Test
    public void testAuthenticateNewUser() throws Exception {

        UserBusinessService ubs = new UserBusinessService();
        MA_User user = new MA_User();
        user.setUserName("timaaah");
        user.setPassword("1q2w3e4r");
        user = ubs.authenticateUser(user);
        assertNull(user);

    }
}
