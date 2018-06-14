package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class MA_ContractorSkill extends AbstractEntity
{
	/**
     * 
     */
	private static final long              serialVersionUID = 7799627204754362737L;
	
	private ModelRef<MA_TemplateSkill>     templateSkillRef = new ModelRef<MA_TemplateSkill>(
	                                                                MA_TemplateSkill.class);
	
	private ModelRef<MA_ContractorCompany> contractorRef    = new ModelRef<MA_ContractorCompany>(
	                                                                MA_ContractorCompany.class);
	
	/**
	 * @return the templateSkillRef
	 */
	public ModelRef<MA_TemplateSkill> getTemplateSkillRef()
	{
		return templateSkillRef;
	}
	
	/**
	 * @return the contractorRef
	 */
	public ModelRef<MA_ContractorCompany> getContractorRef()
	{
		return contractorRef;
	}
	
}
