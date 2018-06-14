package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class MA_InvoiceAdjust extends AbstractEntity
{
	
	/**
	 * 
	 */
	private static final long           serialVersionUID = -5577446661057329283L;
	private ModelRef<MA_Invoice>        invoiceRef       = new ModelRef<MA_Invoice>(
	                                                             MA_Invoice.class);
	private ModelRef<MA_AdjustmentType> adjustmentTypeRef      = new ModelRef<MA_AdjustmentType>(
	                                                             MA_AdjustmentType.class);
	private double adjustmentAmount;
	private String approved;
	private String reasonOfAdjustment;

	
	public double getAdjustmentAmount()
	{
		return adjustmentAmount;
	}
	public void setAdjustmentAmount(double adjustmentAmount)
	{
		this.adjustmentAmount = adjustmentAmount;
	}
	public String getApproved()
	{
		return approved;
	}
	public void setApproved(String approved)
	{
		this.approved = approved;
	}
	public String getReasonOfAdjustment()
	{
		return reasonOfAdjustment;
	}
	public void setReasonOfAdjustment(String reasonOfAdjustment)
	{
		this.reasonOfAdjustment = reasonOfAdjustment;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	public ModelRef<MA_AdjustmentType> getAdjustmentTypeRef()
    {
	    return adjustmentTypeRef;
    }

	public ModelRef<MA_Invoice> getInvoiceRef()
    {
	    return invoiceRef;
    }
	

	
	
}
