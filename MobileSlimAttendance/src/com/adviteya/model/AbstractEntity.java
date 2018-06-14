package com.adviteya.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.CreationDate;
import org.slim3.datastore.ModificationDate;

import com.google.appengine.api.datastore.Key;

public class AbstractEntity implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Attribute(primaryKey = true)
	private Key               key;
	
	@Attribute(version = true)
	private Long              version;
	
	@Attribute(listener = CreationDate.class)
	private Date              createdDate;
	
	@Attribute(listener = ModificationDate.class)
	private Date              updatedDate;
	
	// Use user Id
	private String            createdBy;
	
	// Use user Id
	private String            updatedBy;
	
	public Key getKey()
	{
		return key;
	}
	
	public void setKey(Key key)
	{
		this.key = key;
	}
	
	public Long getVersion()
	{
		return version;
	}
	
	public void setVersion(Long version)
	{
		this.version = version;
	}
	
	public Date getCreatedDate()
	{
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}
	
	public Date getUpdatedDate()
	{
		return updatedDate;
	}
	
	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}
	
	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((key == null) ? 0 : key.hashCode()); return
	 * result; }
	 */
	
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (key == null)
		{
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
	
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy()
	{
		return updatedBy;
	}
	
	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}
}
