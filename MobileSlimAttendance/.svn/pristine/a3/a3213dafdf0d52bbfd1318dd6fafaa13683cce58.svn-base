package com.adviteya.controller.humancapital;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.adviteya.dto.MobileAuditTrailDTO;
import com.adviteya.service.MobileRequestService;

/**
 * @author prashant
 * 
 */
public class MobileAuditTrailReportController extends BaseController
{
	
	private static Logger logger = Logger.getLogger(AssignmentController.class
	                                     .getName());
	
	@Override
	public Navigation executeLogic() throws Exception
	{
		// TODO Auto-generated method stub
		
		MobileRequestService businessService = new MobileRequestService();
		
		pageHeader = "page.MobileAuditTrail";
		pageTitle = "title.MobileAuditTrail";
		String action = requestScope("actionParam");
		Long companyId = sessionScope("companyId");
		
		// Locale locale=request.getLocale();
		String startDate = requestScope("startDate");
		String offset = requestScope("timeoffset");
		// for default date
		if (startDate == null)
		{
			SimpleDateFormat _sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date _startDate = new Date();
			startDate = _sdf.format(_startDate);
		}
		List<MobileAuditTrailDTO> mobileAuditTrailList = businessService
		        .populateMobileAuditTrailReport(companyId, startDate, offset);
		
		Collections.sort(mobileAuditTrailList,
		        new Comparator<MobileAuditTrailDTO>() {
			        @Override
			        public int compare(MobileAuditTrailDTO o1,
			                MobileAuditTrailDTO o2)
			        {
				        return o1.compareTo(o2);
			        };
		        });
		
		long timeoffset = Long.parseLong(offset);
		offset = (timeoffset < 0 ? "+" : "-")
		        + Math.abs((int) (timeoffset / 60)) + ""
		        + Math.abs((timeoffset % 60));
		
		TimeZone tz = TimeZone.getTimeZone("GMT" + offset);
		
		requestScope("timeZone", tz.getID());
		
		requestScope("mobileAuditTrailList", mobileAuditTrailList);
		
		requestScope("startDate", startDate);
		return forward("mobileAuditTrailReport.jsp");
	}
	
}
