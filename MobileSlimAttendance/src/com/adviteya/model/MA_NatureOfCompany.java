/**
 * 
 */
package com.adviteya.model;

import org.slim3.datastore.Model;

/**
 * @author Dheeraj
 * 
 */
@Model(schemaVersion = 1)
public class MA_NatureOfCompany extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long serialVersionUID = -3038257166915412347L;
	
	private String            natureOfBusinessDesce;
	
	/**
	 * @return the natureOfBusinessDesce
	 */
	public String getNatureOfBusinessDesce()
	{
		return natureOfBusinessDesce;
	}
	
	/**
	 * @param natureOfBusinessDesce
	 *            the natureOfBusinessDesce to set
	 */
	public void setNatureOfBusinessDesce(String natureOfBusinessDesce)
	{
		this.natureOfBusinessDesce = natureOfBusinessDesce;
	}
	
}
