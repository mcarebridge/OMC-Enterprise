package com.adviteya.service;

import java.util.List;
import java.util.logging.Logger;

import com.adviteya.model.MA_Contract;

public class ContractBusinessService
{
	
	private Logger        logger        = Logger.getLogger(UserBusinessService.class
	                                            .getName());
	private EntityService entityService = EntityService.getInstance();
	
	
	
	
	/**
	 * this method is used to create default contract for the new user
	 * @param companyId
	 */
	public void createDemoContract(long companyId)
    {
	    // TODO Auto-generated method stub
	    
    }




	/**
	 * This method checks that contract is valid or not
	 * 
	 * 
	 * @param companyId
	 * @return
	 */
	public MA_Contract validateContract(long companyId)
    {
	    // TODO Auto-generated method stub
	    return null;
    }




	/**
	 * this method returns contract expiration days;
	 * 
	 * @param companyId
	 * @return 
	 */
	public int calcContractExpirationPeriod(Long companyId)
    {
		   // TODO Auto-generated method stub
		return 0;
	 
	    
    }
	
	
	
	public List<MA_Contract> LoadActiveContractDetails()
	{
		
		return null;
	}
	
	
	
}
