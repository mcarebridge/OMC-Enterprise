package com.adviteya.model;

import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class MA_ServerConfiguration extends AbstractEntity
{
	
	/**
	 * This class stores the server specifc variables
	 */
	private static final long serialVersionUID = -4291948334563467578L;
	
	private String            configKey;
	private String            configValue;
	private String            description;
	
	/**
	 * @return the configKey
	 */
	public String getConfigKey()
	{
		return configKey;
	}
	
	/**
	 * @param configKey
	 *            the configKey to set
	 */
	public void setConfigKey(String configKey)
	{
		this.configKey = configKey;
	}
	
	/**
	 * @return the configValue
	 */
	public String getConfigValue()
	{
		return configValue;
	}
	
	/**
	 * @param configValue
	 *            the configValue to set
	 */
	public void setConfigValue(String configValue)
	{
		this.configValue = configValue;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
}
