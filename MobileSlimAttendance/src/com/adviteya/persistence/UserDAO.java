package com.adviteya.persistence;

import org.slim3.datastore.Datastore;

import com.adviteya.meta.MA_UserMeta;
import com.adviteya.meta.MA_UserProfileMeta;
import com.adviteya.model.AbstractEntity;
import com.adviteya.model.MA_User;
import com.adviteya.model.MA_UserProfile;
import com.google.appengine.api.datastore.Key;

public class UserDAO extends AbstractEntityDAO
{
	
	private static UserDAO userDAO;
	private MA_UserMeta    userMeta = new MA_UserMeta();
	
	private UserDAO()
	{
	}
	
	public static UserDAO newInstance()
	{
		
		if (userDAO == null)
		{
			
			userDAO = new UserDAO();
		}
		return userDAO;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public MA_User authenticateUser(AbstractEntity model)
	{
		
		Key userKey = null;
		MA_User user = (MA_User) model;
		MA_User result_user = null;
		// Map keyMap = new HashMap();
		result_user = Datastore
		        .query(userMeta)
		        .filter(userMeta.userName.equal(user.getUserName()),
		                userMeta.password.equal(user.getPassword())).asSingle();
		return result_user;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public MA_User authenticateUserByIMEI(AbstractEntity model)
	{
		
		Key userKey = null;
		MA_User user = (MA_User) model;
		MA_User result_user = null;
		// Map keyMap = new HashMap();
		result_user = Datastore
		        .query(userMeta)
		        .filter(userMeta.imeiCode.equal(user.getImeiCode()),
		                userMeta.userName.equal(user.getUserName())).asSingle();
		return result_user;
	}
	
	/**
	 * Return the UserProfile object based on profileId
	 * 
	 * @param profileId
	 * @return
	 */
	public MA_UserProfile getUserProfile(String profileId)
	{
		
		MA_UserProfileMeta userProfileMeta = new MA_UserProfileMeta();
		
		MA_UserProfile userprofile = Datastore
		        .query(userProfileMeta)
		        .filter(userProfileMeta.profileId.equal(profileId.toUpperCase()))
		        .asSingle();
		
		return userprofile;
		
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public boolean isUserExists(AbstractEntity model)
	{
		
		boolean flag = false;
		MA_User user = (MA_User) model;
		MA_User result_user = null;
		// Map keyMap = new HashMap();
		result_user = Datastore.query(userMeta)
		        .filter(userMeta.userName.equal(user.getUserName())).asSingle();
		if (null != result_user)
		{
			flag = true;
		}
		return flag;
	}
	
	/*
	 * Return the User object
	 * 
	 * @param model
	 * 
	 * @return MA_User
	 */
	
	public MA_User getUserDetails(AbstractEntity model)
	{
		MA_User user = (MA_User) model;
		MA_User result_user = null;
		result_user = Datastore.query(userMeta)
		        .filter(userMeta.userName.equal(user.getUserName())).asSingle();
		return result_user;
	}
	
}
