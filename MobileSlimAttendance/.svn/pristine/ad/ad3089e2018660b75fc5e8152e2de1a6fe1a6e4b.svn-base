package test.adviteya.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Test;

import com.adviteya.dto.PayrollDTO;
import com.adviteya.model.MA_Company;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.service.EntityService;
import com.adviteya.service.PayRollBusinessService;
import com.adviteya.service.TimeSheetBusinessService;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class TestPayrollReport
{
	private static Logger logger  = Logger.getLogger(TimeSheetBusinessService.class
	                                      .getName());
	private EntityService service = EntityService.getInstance();
	PayRollBusinessService businessService=new PayRollBusinessService();
	public static double  readCounter;
	public static double  writeCounter;
	
	@Test
	public void testPayrollReport()
	{
		
		try
		{
			Calendar _startCal = Calendar.getInstance();
			_startCal.clear();
			_startCal.set(Calendar.YEAR, 2012);
			_startCal.set(Calendar.MONTH, 10);
			_startCal.set(Calendar.DATE, 1);
			
			Calendar _endCal=Calendar.getInstance();
			_endCal.clear();
			_endCal.set(Calendar.YEAR, 2012);
			_endCal.set(Calendar.MONTH, 10);
			_endCal.set(Calendar.DATE, 30);
						
			List<PayrollDTO> weeklyPayrollDTOs = getWeeklyPayRollTimeSheet(
			        new Long(8001), _startCal.getTime(), _endCal.getTime());
						
			StringBuffer sb = businessService.convertPayrollDTOtoString(weeklyPayrollDTOs);
			
			String csvString = "Emp Code,Employee Name,Type,Designation,Working days,Present days,WO,C off,PH,PL,CL,Total,Absent days,OT"

			        + '\n'+sb;
			
			Assert.assertNotNull(csvString);
			
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * this method takes Start Date And End Date of week returns Weekly
	 * PayrollDto
	 * 
	 * @param companyId
	 * @param fromDtStr
	 * @param toDtStr
	 * @return
	 * @throws IOException
	 */
	public List<PayrollDTO> getWeeklyPayRollTimeSheet(Long companyId,
	        Date fromDate, Date toDate) throws IOException
	{
		
		RemoteApiOptions options = new RemoteApiOptions().server(
		        "omcdev.appspot.com", 443).credentials(
		        "ppatil@onemastercontrol.com", "javaru!es");
		//
		
		RemoteApiInstaller installer = new RemoteApiInstaller();
		installer.install(options);
				
		MA_Company company = new MA_Company();
		Key companykey = AbstractEntityDAO.createKey(company, companyId);
		company = service.getCompanyObj(companykey);
		
		return  businessService.constructPeriodicPayrollReport(company, fromDate, toDate);
	}
	
	
	
}
