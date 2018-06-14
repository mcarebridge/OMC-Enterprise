package com.adviteya.model;

import java.util.Date;

import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class MA_Package extends AbstractEntity
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4149930803966569279L;
	
	private int               minEmpCount;
	private int               maxEmpCount;
	private double            standardRate;
	private String            discountType;
	private double            discount;
	private Date              startDate;
	private Date              endDate;
	private boolean           approved;
	
	/**
	 * @return the standardRate
	 */
	public double getStandardRate()
	{
		return standardRate;
	}
	
	/**
	 * @param standardRate
	 *            the standardRate to set
	 */
	public void setStandardRate(double standardRate)
	{
		this.standardRate = standardRate;
	}
	
	/**
	 * @return the discountType
	 */
	public String getDiscountType()
	{
		return discountType;
	}
	
	/**
	 * @param discountType
	 *            the discountType to set
	 */
	public void setDiscountType(String discountType)
	{
		this.discountType = discountType;
	}
	
	/**
	 * @return the discount
	 */
	public double getDiscount()
	{
		return discount;
	}
	
	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(double discount)
	{
		this.discount = discount;
	}
	
	/**
	 * @return the packageName
	 */
	public String getPackageName()
	{
		return packageName;
	}
	
	/**
	 * @param packageName
	 *            the packageName to set
	 */
	public void setPackageName(String packageName)
	{
		this.packageName = packageName;
	}
	
	private String packageName;
	
	/**
	 * @return the approved
	 */
	public boolean isApproved()
	{
		return approved;
	}
	
	/**
	 * @param approved
	 *            the approved to set
	 */
	public void setApproved(boolean approved)
	{
		this.approved = approved;
	}
	
	public int getMinEmpCount()
	{
		return minEmpCount;
	}
	
	public void setMinEmpCount(int minEmpCount)
	{
		this.minEmpCount = minEmpCount;
	}
	
	public int getMaxEmpCount()
	{
		return maxEmpCount;
	}
	
	public void setMaxEmpCount(int maxEmpCount)
	{
		this.maxEmpCount = maxEmpCount;
	}
	
	public Date getStartDate()
	{
		return startDate;
	}
	
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
}
