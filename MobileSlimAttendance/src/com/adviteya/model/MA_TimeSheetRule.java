package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 1)
public class MA_TimeSheetRule extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long    serialVersionUID = -4889695897169038628L;
	
	private ModelRef<MA_Company> companyRef       = new ModelRef<MA_Company>(
	                                                      MA_Company.class);
	
	private String               ruleKey;
	private Text                 description;
	private Long                 value;
	
	/**
	 * @return the companyRef
	 */
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	/**
	 * @return the ruleKey
	 */
	public String getRuleKey()
	{
		return ruleKey;
	}
	
	/**
	 * @param ruleKey
	 *            the ruleKey to set
	 */
	public void setRuleKey(String ruleKey)
	{
		this.ruleKey = ruleKey;
	}
	
	/**
	 * @return the description
	 */
	public Text getDescription()
	{
		return description;
	}
	
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(Text description)
	{
		this.description = description;
	}
	
	/**
	 * @return the value
	 */
	public Long getValue()
	{
		return value;
	}
	
	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Long value)
	{
		this.value = value;
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
		int result = super.hashCode();
		result = prime * result + ((ruleKey == null) ? 0 : ruleKey.hashCode());
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
		// if (!super.equals(obj))
		// return false;
		if (getClass() != obj.getClass())
			return false;
		MA_TimeSheetRule other = (MA_TimeSheetRule) obj;
		if (ruleKey == null)
		{
			if (other.ruleKey != null)
				return false;
		} else if (!ruleKey.equals(other.ruleKey))
			return false;
		return true;
	}
	
	/*
	 * Min # of working hrs for full pay b. Min # of continuous working hrs for
	 * half day c. Max # of working hrs d. Min # of Hrs for overtime e. Max # of
	 * Hrs per month f. Max overtime Hrs g. Shift tolerance (in mins) h. Company
	 * Holidays i. Lunch time in min j. Tea /coffee break in min k. Tolerance in
	 * mins for Half day l. Tolerance in mins for overtime
	 */
	
}
