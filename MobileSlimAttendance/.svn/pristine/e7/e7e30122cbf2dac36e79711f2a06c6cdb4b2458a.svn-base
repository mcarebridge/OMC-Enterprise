package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class MA_TemplateSkill extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long     serialVersionUID = -4011042414815941282L;
	private ModelRef<MA_Template> templateRef      = new ModelRef<MA_Template>(
	                                                       MA_Template.class);
	private String                skill;
	private String                status;
	
	private ModelRef<MA_Company>  companyRef       = new ModelRef<MA_Company>(
	                                                       MA_Company.class);
	
	/**
	 * @return the companyRef
	 */
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
	/**
	 * @return the skill
	 */
	public String getSkill()
	{
		return skill;
	}
	
	/**
	 * @param skill
	 *            the skill to set
	 */
	public void setSkill(String skill)
	{
		this.skill = skill;
	}
	
	/**
	 * @return the templateRef
	 */
	public ModelRef<MA_Template> getTemplateRef()
	{
		return templateRef;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}
	
	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
	
}
