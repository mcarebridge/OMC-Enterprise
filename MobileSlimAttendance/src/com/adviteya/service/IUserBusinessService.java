package com.adviteya.service;

import java.util.Map;

import com.adviteya.model.MA_User;

/**
 * 
 * @author Dheeraj
 * 
 */
public interface IUserBusinessService
{
	
	MA_User authenticateUser(MA_User user);
	
	String createUser(Map<String, Object> input);
	
	void deactivateUser(MA_User user);
	
	void updateUser(MA_User user);
	
	MA_User authenticateUserLogin(Map<String, Object> input);
	
	String createContractorCompanyUser(Map<String, Object> input, Long companyId);
	
	MA_User updatePassword(Long companyId, String password);
	
}
