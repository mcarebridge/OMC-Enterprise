package com.adviteya.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Tweet implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Attribute(primaryKey = true)
	private Key               key;
	
	@Attribute(version = true)
	private Long              version;
	
	private String            content;
	
	private Date              createdDate      = new Date();
	
	/**
	 * Returns the key.
	 * 
	 * @return the key
	 */
	public Key getKey()
	{
		return key;
	}
	
	/**
	 * Sets the key.
	 * 
	 * @param key
	 *            the key
	 */
	public void setKey(Key key)
	{
		this.key = key;
	}
	
	/**
	 * Returns the version.
	 * 
	 * @return the version
	 */
	public Long getVersion()
	{
		return version;
	}
	
	/**
	 * Sets the version.
	 * 
	 * @param version
	 *            the version
	 */
	public void setVersion(Long version)
	{
		this.version = version;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
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
		Tweet other = (Tweet) obj;
		if (key == null)
		{
			if (other.key != null)
			{
				return false;
			}
		} else if (!key.equals(other.key))
		{
			return false;
		}
		return true;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public Date getCreatedDate()
	{
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}
}
