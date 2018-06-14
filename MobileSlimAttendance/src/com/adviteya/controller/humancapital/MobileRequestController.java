/**
 * 
 */
package com.adviteya.controller.humancapital;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.model.MA_Assignment;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_MobileTransmissionData;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.model.MA_User;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.service.AssignmentBusinessService;
import com.adviteya.service.EmployeeService;
import com.adviteya.service.EntityService;
import com.adviteya.service.IAssignmentBusinessService;
import com.adviteya.service.ITimeSheetBusinessService;
import com.adviteya.service.MobileRequestService;
import com.adviteya.service.TimeSheetBusinessService;
import com.adviteya.service.UserBusinessService;
import com.adviteya.util.TimesheetReportUtil;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

/**
 * @author deejay
 * 
 */
public class MobileRequestController extends Controller implements
        IMobileAttendanceConstants
{
	
	private static Logger        logger                = Logger.getLogger(MobileRequestController.class
	                                                           .getName());
	
	private String               authMsg               = MOBILE_SUPERVISOR_AUTHENTICATION_FAILED;
	private String               action;
	private String               status;
	private String               state;
	private String               logError;
	private String               responseData;
	private Key                  dataKey;
	private long                 inTime                = 0;
	private long                 outTime               = 0;
	private MA_User              user                  = null;
	private int                  recordsSend           = 0;
	private MobileRequestService mobileBusinessService = new MobileRequestService();
	MA_MobileTransmissionData    mobileTransData       = null;
	
	@Override
	protected Navigation run() throws Exception
	{
		// TODO Auto-generated method stub
		
		inTime = new Date().getTime();
		action = (String) request.getAttribute("action");
		String textLoginId = (String) request.getAttribute("textLoginId");
		String pwdPasscode = (String) request.getAttribute("pwdPasscode");
		String latLang = (String) request.getAttribute("latLang");
		String mobileData = (String) request.getAttribute("mobileData");
		String imeiCode = (String) request.getAttribute("imeiCode");
		String mobileRecsRcvd = (String) request.getAttribute("mobileRecsSent");
		String supervisorUserName = (String) request
		        .getAttribute("supervisorUserName");
		
		logger.log(Level.INFO, "imeiCode : " + imeiCode);
		logger.log(Level.INFO, "supervisorUserName : " + supervisorUserName);
		logger.log(Level.INFO, "Lat lang is : " + latLang);
		status = "01-OPEN";
		state = "01-OPEN";
		mobileTransData = fillMobileTransmissionData(new RequestMap(request));
		dataKey = mobileBusinessService
		        .addMobileTransmmissionData(mobileTransData);
		response.setHeader("Content-Encoding", "gzip");
		OutputStream o = response.getOutputStream();
		
		response.setContentType("text/html;charset=UTF-8");
		// PrintWriter out = response.getWriter();
		try
		{
			// Authenticate Mobile Supervisor
			if (action.equalsIgnoreCase(VALIDATE_MOBILE_SUPERVISOR))
			{
				
				MA_User _user = authenticateMobileSupervisor(textLoginId,
				        pwdPasscode);
				if (!authMsg.equals(MOBILE_SUPERVISOR_AUTHENTICATION_FAILED))
				{
					ITimeSheetBusinessService tbs = new TimeSheetBusinessService();
					boolean hasPlannedAssignments = tbs
					        .hasPlannedAssignment(_user.getCompanyRef()
					                .getModel().getKey().getId());
					
					response.addHeader("PLANNED_ASSIGNMENTS",
					        Boolean.toString(hasPlannedAssignments));
				}
				response.addHeader("AUTH_MSG", authMsg);
				
			} else if (action.equalsIgnoreCase(IMEI_VALIDATE_MOBILE_SUPERVISOR))
			{
				// Step 1: Store with state = AUTHENTICATING, STATUS : OPEN
				
				status = "02-AUTHN";
				state = "02-INPRG";
				
				mobileTransData = fillMobileTransmissionData(new RequestMap(
				        request));
				dataKey = mobileBusinessService
				        .addMobileTransmmissionData(mobileTransData);
				MA_User _user = authenticateMobileSupervisorUsingIMEI(imeiCode,
				        latLang, supervisorUserName);
				if (!authMsg.equals(MOBILE_SUPERVISOR_AUTHENTICATION_FAILED))
				{
					ITimeSheetBusinessService tbs = new TimeSheetBusinessService();
					boolean hasPlannedAssignments = tbs
					        .hasPlannedAssignment(_user.getCompanyRef()
					                .getModel().getKey().getId());
					
					response.addHeader("PLANNED_ASSIGNMENTS",
					        Boolean.toString(hasPlannedAssignments));
					// Step : 2 : Set State = SUCCESS | FAILURE, STATUS :
					// COMPLETE
					
					state = "03-AU-SC";
					
				} else
				{
					state = "03-AU-FL";
				}
				
				responseData = authMsg;
				status = "03-CMPLT";
				outTime = new Date().getTime();
				mobileTransData = fillMobileTransmissionData(new RequestMap(
				        request));
				mobileBusinessService
				        .addMobileTransmmissionData(mobileTransData);
				response.addHeader("AUTH_MSG", authMsg);
			}
			// Authenticate and Synch server data
			else if (action.equalsIgnoreCase(SYNCH_SERVER_DATA)
			        | action.equalsIgnoreCase(IMEI_SYNCH_SERVER_DATA))
			{
				String _timeSheetString = "";
				if (action.equalsIgnoreCase(SYNCH_SERVER_DATA))
				{
					_timeSheetString = synchServerData(textLoginId,
					        pwdPasscode, mobileData);
				} else if (action.equalsIgnoreCase(IMEI_SYNCH_SERVER_DATA))
				{
					
					status = "02-SYNCH";
					state = "02-INPRG";
					mobileTransData = fillMobileTransmissionData(new RequestMap(
					        request));
					dataKey = mobileBusinessService
					        .addMobileTransmmissionData(mobileTransData);
					_timeSheetString = synchServerDataIMEI(imeiCode, latLang,
					        supervisorUserName, mobileData);
				}
				
				// Invoke the queue
				// start
				TaskOptions _t = TaskOptions.Builder
				        .withUrl("/humancapital/processAttendanceData");
				_t.param(
				        "companyId",
				        Long.toString(user.getCompanyRef().getModel().getKey()
				                .getId()));
				Queue queue = QueueFactory
				        .getQueue("omc-attendance-record-input");
				queue.add(_t);
				// end
				
				IAssignmentBusinessService businessService = AssignmentBusinessService
				        .getInstance();
				String _locationAndShifts = businessService
				        .getAllShiftByLocation(user.getCompanyRef().getModel()
				                .getKey().getId());
				
				StringBuffer _mobileData = new StringBuffer();
				_mobileData.append("(");
				_mobileData.append("LOCATIONANDSHIFT=");
				_mobileData.append(_locationAndShifts);
				_mobileData.append(")");
				_mobileData.append("(");
				_mobileData.append("TIMESHEET=");
				_mobileData.append(_timeSheetString);
				_mobileData.append(")");
				
				String _mobileDataString = _mobileData.toString();
				
				if (_mobileDataString != null)
				{
					
					responseData = _mobileDataString;
					status = "03-CMPLT";
					outTime = new Date().getTime();
					mobileTransData = fillMobileTransmissionData(new RequestMap(
					        request));
					mobileBusinessService
					        .addMobileTransmmissionData(mobileTransData);
					logger.log(Level.INFO, "Data String : " + _mobileDataString);
					response.addHeader("AUTH_MSG", authMsg);
					logger.log(Level.INFO, "ADDED AUTH MSG");
					// out.println(_mobileDataString.toString());
					GZIPOutputStream gz = new GZIPOutputStream(o);
					
					gz.write(_mobileData.toString().getBytes());
					gz.close();
					o.close();
				}
				
			}
		} catch (Exception e)
		{
			// Step : 3 : Set State = SUCCESS | FAILURE, STATUS : ERROR
			logger.log(Level.SEVERE, e.getMessage(), e);
			response.addHeader("AUTH_MSG", MOBILE_SERVER_SYSTEM_ERR);
			logError = e.getClass() + ": " + e.getMessage() + ": "
			        + e.getCause() + "\n" + e.getStackTrace().toString();
			status = "03-ERROR";
			mobileTransData = fillMobileTransmissionData(new RequestMap(request));
			mobileBusinessService.addMobileTransmmissionData(mobileTransData);
		}
		
		return null;
	}
	
	/**
	 * Authenticate a supervisor User if the User has current assignment. This
	 * is needed for copying his assignment details - location and shift in
	 * default assignment user
	 * 
	 * @param loginId
	 * @param password
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	private MA_User authenticateMobileSupervisor(String loginId, String password)
	        throws IOException, ParseException
	{
		
		authMsg = MOBILE_SUPERVISOR_AUTHENTICATION_FAILED;
		UserBusinessService ubs = new UserBusinessService();
		EntityService _ebs = EntityService.getInstance();
		
		MA_User _user = new MA_User();
		_user.setUserName(loginId);
		_user.setPassword(password);
		_user = ubs.authenticateUser(_user);
		
		if (_user != null)
		{
			// Authenticate only SUPERVISORS and it is coming from Android
			// device
			if (_user.getUserProfileRef().getModel().getProfileType()
			        .equalsIgnoreCase("SUPR"))
			{
				MA_Assignment _assignment = _ebs.getEmplyoeeAssignment(_user
				        .getEmployeeRef().getModel(),
				        IMobileAttendanceConstants.CURRENT_ASSIGNMENT);
				
				if (_assignment != null)
				{
					if (_assignment.getStatus() == IMobileAttendanceConstants.CURRENT_ASSIGNMENT)
					{
						authMsg = MOBILE_SUPERVISOR_AUTHENTICATION_SUCCESS;
					}
					
				}
			}
		}
		
		return _user;
	}
	
	/**
	 * This authentication happens based on IMEI code
	 * 
	 * @param imeiCode
	 * @param latLong
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	private MA_User authenticateMobileSupervisorUsingIMEI(String imeiCode,
	        String latLong, String supervisorUserName) throws IOException,
	        ParseException
	{
		
		logger.log(Level.INFO, "authenticateMobileSupervisorUsingIMEI -- "
		        + imeiCode + " -- " + supervisorUserName);
		
		authMsg = MOBILE_SUPERVISOR_AUTHENTICATION_FAILED;
		UserBusinessService ubs = new UserBusinessService();
		EntityService _ebs = EntityService.getInstance();
		String password = "NOT_REQUIRED";
		
		MA_User _user = new MA_User();
		_user.setImeiCode(imeiCode);
		_user.setUserName(supervisorUserName);
		_user = ubs.authenticateUserByIMEI(_user);
		
		if (_user != null)
		{
			// Authenticate only SUPERVISORS and it is coming from Android
			// device
			if (_user.getUserProfileRef().getModel().getProfileType()
			        .equalsIgnoreCase("SUPR"))
			{
				MA_Assignment _assignment = _ebs.getEmplyoeeAssignment(_user
				        .getEmployeeRef().getModel(),
				        IMobileAttendanceConstants.CURRENT_ASSIGNMENT);
				
				if (_assignment != null)
				{
					if (_assignment.getStatus() == IMobileAttendanceConstants.CURRENT_ASSIGNMENT)
					{
						authMsg = MOBILE_SUPERVISOR_AUTHENTICATION_SUCCESS;
					}
					
				}
			}
		}
		
		return _user;
	}
	
	/**
	 * @deprecated Synchronize server data with Mobile sent data
	 * 
	 * @param textLoginId
	 * @param pwdPasscode
	 * @throws ParseException
	 * @throws IOException
	 */
	private String synchServerData(String textLoginId, String pwdPasscode,
	        String mobileData) throws IOException, ParseException
	{
		
		logger.log(Level.INFO, "inside synchServerData");
		
		user = authenticateMobileSupervisor(textLoginId, pwdPasscode);
		String _timeSheetString = null;
		
		if (authMsg.equalsIgnoreCase(MOBILE_SUPERVISOR_AUTHENTICATION_SUCCESS))
		{
			
			ITimeSheetBusinessService tbs = new TimeSheetBusinessService();
			boolean hasPlannedAssignments = tbs.hasPlannedAssignment(user
			        .getCompanyRef().getModel().getKey().getId());
			
			List<MA_Timesheet> timesheets = null;
			logger.log(Level.INFO, "--- AUTHENTICATED, NEXT STEP SYNCH DATA");
			// During the first run there will no table in the mobile, so there
			// would nothing to copy from
			// Mobile
			if (!mobileData.equalsIgnoreCase(FIRST_RUN))
			{
				timesheets = TimesheetReportUtil.parseTimeSheet(mobileData,
				        hasPlannedAssignments, null, null, null);
			}
			
			tbs = new TimeSheetBusinessService();
			List<MA_Timesheet> _timesheets = tbs.synchTimeSheet(timesheets,
			        user, hasPlannedAssignments);
			
			_timeSheetString = TimesheetReportUtil.serializeTimesheet(
			        _timesheets).toString();
		}
		
		logger.log(Level.INFO, _timeSheetString);
		return _timeSheetString;
		
	}
	
	private String synchServerDataIMEI(String imeiCode, String latLang,
	        String supervisorUserName, String mobileData) throws IOException,
	        ParseException
	{
		
		logger.log(Level.INFO, "inside synchServerData");
		logger.log(Level.INFO, "Lat lang is : " + latLang);
		
		user = authenticateMobileSupervisorUsingIMEI(imeiCode, latLang,
		        supervisorUserName);
		String _timeSheetString = null;
		
		if (authMsg.equalsIgnoreCase(MOBILE_SUPERVISOR_AUTHENTICATION_SUCCESS))
		{
			
			ITimeSheetBusinessService tbs = new TimeSheetBusinessService();
			boolean hasPlannedAssignments = tbs.hasPlannedAssignment(user
			        .getCompanyRef().getModel().getKey().getId());
			
			List<MA_Timesheet> timesheets = null;
			logger.log(Level.INFO, "--- AUTHENTICATED, NEXT STEP SYNCH DATA");
			// During the first run there will no table in the mobile, so there
			// would nothing to copy from
			// Mobile
			
			logger.log(Level.INFO, "--Mobile Data Rcvd" + mobileData);
			state = "03-SY-SC";
			if (!mobileData.equalsIgnoreCase(FIRST_RUN))
			{
				timesheets = TimesheetReportUtil.parseTimeSheet(mobileData,
				        hasPlannedAssignments, imeiCode, supervisorUserName,
				        latLang);
			}
			
			if (timesheets != null)
			{
				logger.log(Level.INFO,
				        "--# of Timesheets -- " + timesheets.size());
				recordsSend = timesheets.size();
			} else
			{
				logger.log(Level.INFO, "--# of Timesheets -- " + " null ");
			}
			
			tbs = new TimeSheetBusinessService();
			List<MA_Timesheet> _timesheets = tbs.synchTimeSheet(timesheets,
			        user, hasPlannedAssignments);
			
			_timeSheetString = TimesheetReportUtil.serializeTimesheet(
			        _timesheets).toString();
			
		} else
		{
			state = "03-SY-FL";
		}
		
		return _timeSheetString;
		
	}
	
	/**
	 * Load test timesheet path from filesystem
	 * 
	 * @throws IOException
	 */
	private StringBuffer loadTestTimesheets() throws IOException
	{
		
		StringBuffer timeSheetStream = new StringBuffer();
		
		FileReader fr = null;
		File f = new File("C:/Userlib/WebApp/MobileSlimAttendance/testdata/"
		// + testTimeSheetPath
		        + ".csv");
		if (f.exists())
		{
			try
			{
				fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String eachLine = "";
				int i = 0;
				while (eachLine != null)
				{
					eachLine = br.readLine();
					if (eachLine != null)
					{
						// Omit header
						if (i > 0)
						{
							timeSheetStream.append(eachLine);
							timeSheetStream.append("\n");
						}
					}
					
					i++;
				}
			} finally
			{
				fr.close();
			}
		}
		
		return timeSheetStream;
	}
	
	/**
	 * @param input
	 * @return
	 */
	private MA_MobileTransmissionData fillMobileTransmissionData(
	        Map<String, Object> input)
	{
		EmployeeService businessService = new EmployeeService();
		
		MA_MobileTransmissionData mobileData = new MA_MobileTransmissionData();
		
		String imeiCode = (String) input.get("imeiCode");
		String userName = (String) input.get("textLoginId");
		String empCompanyEmpId = (String) input.get("supervisorUserName");
		String attendanceCoordinates = (String) input.get("latLang");
		String requestData = (String) input.get("mobileData");
		String mobileRecsRcvd = (String) input.get("mobileRecsSent");
		
		logger.log(Level.INFO, "--NO of Records Recieved" + mobileRecsRcvd);
		
		mobileRecsRcvd = mobileRecsRcvd != null ? mobileRecsRcvd : "0";
		
		responseData = responseData != null ? responseData : "-";
		
		long responseTime = -1;
		Float _f_long = 0f;
		Float _f_lat = 0f;
		double accuracy = 0;
		if (empCompanyEmpId == null)
		{
			logger.log(Level.INFO, "   null value");
		} else if (empCompanyEmpId.equalsIgnoreCase(""))
		{
			logger.log(Level.INFO, "   empty string ");
		} else
		{
			logger.log(Level.INFO, " empCompanyId" + empCompanyEmpId);
		}
		MA_Employee employee = null;
		
		MA_Company company = null;
		if (!(empCompanyEmpId.equals("") || empCompanyEmpId.equals(null)))
		{
			employee = businessService.getEmployeeObject(empCompanyEmpId);
			long companyId = Long.parseLong(empCompanyEmpId.substring(0,
			        empCompanyEmpId.indexOf("-")));
			company = new MA_Company();
			Key k1 = AbstractEntityDAO.createKey(company, companyId);
			company.setKey(k1);
		}
		if (!attendanceCoordinates.equalsIgnoreCase("LOCATION_NOT_FOUND"))
		{
			StringTokenizer _st = new StringTokenizer(attendanceCoordinates,
			        "@");
			String _long = (String) _st.nextElement();
			String _lat = (String) _st.nextElement();
			String _accuracy = (String) _st.nextElement();
			
			_f_long = new Float(_long.substring(_long.indexOf(":") + 1,
			        _long.length()).trim());
			_f_lat = new Float(_lat.substring(_lat.indexOf(":") + 1,
			        _lat.length()).trim());
			accuracy = new Double(_accuracy.substring(
			        _accuracy.indexOf(":") + 1, _accuracy.length()).trim());
		}
		GeoPt attendanceLocation = new GeoPt(_f_lat, _f_long);
		
		requestData = "(Action= " + action + ")(IMEI Code= " + imeiCode
		        + ")(User Name= " + userName + ")(Geo Pts ="
		        + attendanceLocation.toString() + ")(Employee Id="
		        + empCompanyEmpId + ")" + requestData;
		
		if (dataKey != null)
		{
			mobileData.setKey(dataKey);
			mobileData.setUpdatedBy("SYSTEM");
		}
		if (outTime != 0)
		{
			responseTime = outTime - inTime;
		}
		Date date = new Date();
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		mobileData.setCreateDay(c.get(Calendar.DAY_OF_MONTH));
		mobileData.setCreateMonth(c.get(Calendar.MONTH));
		mobileData.setCreateYear(c.get(Calendar.YEAR));
		
		mobileData.setCreatedBy("SYSTEM");
		mobileData.setAction(action);
		mobileData.setAttendanceCoordinates(attendanceLocation);
		mobileData.setImeiCode(imeiCode);
		mobileData.setGeoPtAccuracy(accuracy);
		mobileData.setState(state);
		mobileData.setStatus(status);
		mobileData.setRequestData(new Text(requestData));
		mobileData.setResponseData(new Text(responseData));
		mobileData.setLogError(logError);
		mobileData.setResponseTime(responseTime);
		mobileData.setRecordsSend(recordsSend);
		mobileData.setRecordsReceived(Integer.parseInt(mobileRecsRcvd));
		
		mobileData.getEmployeeRef().setModel(employee);
		mobileData.getCompanyRef().setModel(company);
		
		return mobileData;
	}
	
}
