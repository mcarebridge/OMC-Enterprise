package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class MA_Receivables extends AbstractEntity
{
	
	/**
	 * 
	 */
	private static final long    serialVersionUID = 7843442372548770772L;
	private ModelRef<MA_Invoice> invoiceRef       = new ModelRef<MA_Invoice>(
	                                                      MA_Invoice.class);
	private double               amountRecievedAmount;                       ;
	private Date                 amountReceivedDate;
	private double               bankCharges;
	private String               clearingBank;
	private String               issuingBank;
	private double               exchangeRate;
	private String               senderCurrency;
	private String               receiverCurrency;
	
	/**
	 * @return the issuingBank
	 */
	public String getIssuingBank()
	{
		return issuingBank;
	}
	
	/**
	 * @param issuingBank
	 *            the issuingBank to set
	 */
	public void setIssuingBank(String issuingBank)
	{
		this.issuingBank = issuingBank;
	}
	
	/**
	 * @return the exchangeRate
	 */
	public double getExchangeRate()
	{
		return exchangeRate;
	}
	
	/**
	 * @param exchangeRate
	 *            the exchangeRate to set
	 */
	public void setExchangeRate(double exchangeRate)
	{
		this.exchangeRate = exchangeRate;
	}
	
	/**
	 * @return the senderCurrency
	 */
	public String getSenderCurrency()
	{
		return senderCurrency;
	}
	
	/**
	 * @param senderCurrency
	 *            the senderCurrency to set
	 */
	public void setSenderCurrency(String senderCurrency)
	{
		this.senderCurrency = senderCurrency;
	}
	
	/**
	 * @return the receiverCurrency
	 */
	public String getReceiverCurrency()
	{
		return receiverCurrency;
	}
	
	/**
	 * @param receiverCurrency
	 *            the receiverCurrency to set
	 */
	public void setReceiverCurrency(String receiverCurrency)
	{
		this.receiverCurrency = receiverCurrency;
	}
	
	public ModelRef<MA_Invoice> getInvoiceRef()
	{
		return invoiceRef;
	}
	
	public Date getAmountReceivedDate()
	{
		return amountReceivedDate;
	}
	
	public void setAmountReceivedDate(Date amountReceivedDate)
	{
		this.amountReceivedDate = amountReceivedDate;
	}
	
	public double getBankCharges()
	{
		return bankCharges;
	}
	
	public void setBankCharges(double bankCharges)
	{
		this.bankCharges = bankCharges;
	}
	
	public String getClearingBank()
	{
		return clearingBank;
	}
	
	public void setClearingBank(String clearingBank)
	{
		this.clearingBank = clearingBank;
	}
	
	public double getAmountRecievedAmount()
	{
		return amountRecievedAmount;
	}
	
	public void setAmountRecievedAmount(double amountRecievedAmount)
	{
		this.amountRecievedAmount = amountRecievedAmount;
	}
	
}
