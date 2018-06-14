package com.adviteya.model;

import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class MA_TimeSheetRuleResult extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long serialVersionUID = -4889695897169038628L;
	
	private String            ruleResultKey;
	private String            ruleResultValue;
	
	/**
	 * @return the ruleResultValue
	 */
	public String getRuleResultValue()
	{
		return ruleResultValue;
	}
	
	/**
	 * @param ruleResultValue
	 *            the ruleResultValue to set
	 */
	public void setRuleResultValue(String ruleResultValue)
	{
		this.ruleResultValue = ruleResultValue;
	}
	
	/**
	 * @return the ruleResultKey
	 */
	public String getRuleResultKey()
	{
		return ruleResultKey;
	}
	
	/**
	 * @param ruleResultKey
	 *            the ruleResultKey to set
	 */
	public void setRuleResultKey(String ruleResultKey)
	{
		this.ruleResultKey = ruleResultKey;
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
		result = prime * result
		        + ((ruleResultKey == null) ? 0 : ruleResultKey.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MA_TimeSheetRuleResult other = (MA_TimeSheetRuleResult) obj;
		if (ruleResultKey == null)
		{
			if (other.ruleResultKey != null)
				return false;
		} else if (!ruleResultKey.equals(other.ruleResultKey))
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
