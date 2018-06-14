/**
 * 
 */
package com.adviteya.model;

import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

/**
 * @author Shailesh
 * 
 */
@Model(schemaVersion = 1)
public class MA_DashboardData extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long    serialVersionUID = -4368887673093191039L;
	private String               filterType;
	private Integer              count;
	private Integer              createDay;
	private Integer              createMonth;
	private Integer              createYear;
	private ModelRef<MA_Shift>   shiftRef         = new ModelRef<MA_Shift>(
	                                                      MA_Shift.class);
	private ModelRef<MA_Company> companyRef       = new ModelRef<MA_Company>(
	                                                      MA_Company.class);
	
	/**
	 * @return the filterType
	 */
	public String getFilterType()
	{
		return filterType;
	}
	
	/**
	 * @param filterType
	 *            the filterType to set
	 */
	public void setFilterType(String filterType)
	{
		this.filterType = filterType;
	}
	
	public ModelRef<MA_Shift> getShiftRef()
	{
		return shiftRef;
	}
	
	/**
	 * @return the count
	 */
	public Integer getCount()
	{
		return count;
	}
	
	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count)
	{
		this.count = count;
	}
	
	/**
	 * @return the createDay
	 */
	public Integer getCreateDay()
	{
		return createDay;
	}
	
	/**
	 * @param createDay
	 *            the createDay to set
	 */
	public void setCreateDay(Integer createDay)
	{
		this.createDay = createDay;
	}
	
	/**
	 * @return the createMonth
	 */
	public Integer getCreateMonth()
	{
		return createMonth;
	}
	
	/**
	 * @param createMonth
	 *            the createMonth to set
	 */
	public void setCreateMonth(Integer createMonth)
	{
		this.createMonth = createMonth;
	}
	
	/**
	 * @return the createYear
	 */
	public Integer getCreateYear()
	{
		return createYear;
	}
	
	/**
	 * @param createYear
	 *            the createYear to set
	 */
	public void setCreateYear(Integer createYear)
	{
		this.createYear = createYear;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
		        + ((filterType == null) ? 0 : filterType.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		
		if (this == obj)
			return true;
		
		// if (!super.equals(obj))
		// return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		MA_DashboardData other = (MA_DashboardData) obj;
		
		if (filterType == null)
		{
			if (other.filterType != null)
				return false;
			
		} else if (!filterType.equals(other.filterType))
			return false;
		return true;
	}
	
	public ModelRef<MA_Company> getCompanyRef()
	{
		return companyRef;
	}
	
}
