package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class MA_State extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long    serialVersionUID = -3112503769295527287L;
	private String               countryCode;
	private String               stateName;
	private ModelRef<MA_Country> countryRef       = new ModelRef<MA_Country>(
	                                                      MA_Country.class);
	private String               stateCode;
	
	public String getStateName()
	{
		return stateName;
	}
	
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		
		MA_State other = (MA_State) obj;
		
		Key key = getKey();
		
		if (key == null)
		{
			if (other.getKey() != null)
			{
				return false;
			}
		} else if (!key.equals(other.getKey()))
		{
			return false;
		}
		return true;
	}
	
	public ModelRef<MA_Country> getCountryRef()
	{
		return countryRef;
	}
	
	public String getStateCode()
	{
		return stateCode;
	}
	
	public void setStateCode(String stateCode)
	{
		this.stateCode = stateCode;
	}
	
	/**
	 * @return the countryCode
	 */
	public String getCountryCode()
	{
		return countryCode;
	}
	
	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}
	
}