package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class MA_Invoice extends AbstractEntity
{
	
	/**
	 * 
	 */
	private static final long     serialVersionUID = -5775075828671762267L;
	private ModelRef<MA_Company>  companyRef       = new ModelRef<MA_Company>(
	                                                       MA_Company.class);
	private ModelRef<MA_Contract> contractRef      = new ModelRef<MA_Contract>(
	                                                       MA_Contract.class);
	private ModelRef<MA_Location> locationRef      = new ModelRef<MA_Location>(
	                                                       MA_Location.class);
	private double previousBalance;
	private double payementReceived;
	private double adjustment;
	private double currentMonthCharges;
	private Date amountPayDate;
	private double amountPayable;
	private double amountToBePaidAfterDueDate;
	private Date latePaymentAcceptableDate;
	private double latePaymentAmount;
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}

	public ModelRef<MA_Contract> getContractRef()
	{
		return contractRef;
	}
	
	public ModelRef<MA_Location> getLocationRef()
	{
		return locationRef;
	}
	
	public double getPreviousBalance()
	{
		return previousBalance;
	}
	public void setPreviousBalance(double previousBalance)
	{
		this.previousBalance = previousBalance;
	}
	public double getPayementReceived()
	{
		return payementReceived;
	}
	public void setPayementReceived(double payementReceived)
	{
		this.payementReceived = payementReceived;
	}
	public double getAdjustment()
	{
		return adjustment;
	}
	public void setAdjustment(double adjustment)
	{
		this.adjustment = adjustment;
	}
	public double getCurrentMonthCharges()
	{
		return currentMonthCharges;
	}
	public void setCurrentMonthCharges(double currentMonthCharges)
	{
		this.currentMonthCharges = currentMonthCharges;
	}
	public Date getAmountPayDate()
	{
		return amountPayDate;
	}
	public void setAmountPayDate(Date amountPayDate)
	{
		this.amountPayDate = amountPayDate;
	}
	public double getAmountPayable()
	{
		return amountPayable;
	}
	public void setAmountPayable(double amountPayable)
	{
		this.amountPayable = amountPayable;
	}
	public double getAmountToBePaidAfterDueDate()
	{
		return amountToBePaidAfterDueDate;
	}
	public void setAmountToBePaidAfterDueDate(double amountToBePaidAfterDueDate)
	{
		this.amountToBePaidAfterDueDate = amountToBePaidAfterDueDate;
	}
	public Date getLatePaymentAcceptableDate()
	{
		return latePaymentAcceptableDate;
	}
	public void setLatePaymentAcceptableDate(Date latePaymentAcceptableDate)
	{
		this.latePaymentAcceptableDate = latePaymentAcceptableDate;
	}
	public double getLatePaymentAmount()
	{
		return latePaymentAmount;
	}
	public void setLatePaymentAmount(double latePaymentAmount)
	{
		this.latePaymentAmount = latePaymentAmount;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
	
	
	
}
