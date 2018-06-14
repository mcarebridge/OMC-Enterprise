/**
 * 
 */
package com.adviteya.persistence;

import com.adviteya.meta.MA_CountryMeta;

/**
 * @author Dheeraj
 * 
 */
public class CountryDAO extends AbstractEntityDAO
{
	
	private static CountryDAO countryDAO;
	private MA_CountryMeta    userMeta = new MA_CountryMeta();
	
	private CountryDAO()
	{
	}
	
	public static CountryDAO newInstance()
	{
		
		if (countryDAO == null)
		{
			
			countryDAO = new CountryDAO();
		}
		return countryDAO;
	}
}
