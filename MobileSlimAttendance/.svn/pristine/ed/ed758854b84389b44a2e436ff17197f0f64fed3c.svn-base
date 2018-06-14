package com.adviteya.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.joda.time.DateTimeZone;

import com.adviteya.constants.IMobileAttendanceConstants;
import com.adviteya.controller.humancapital.OMCEmailCommunicatorController;
import com.adviteya.dto.ShiftDashboardReportDTO;
import com.adviteya.model.MA_Alert;
import com.adviteya.model.MA_AlertType;
import com.adviteya.model.MA_ConsolidatedTimesheet;
import com.adviteya.model.MA_EmailTemplate;
import com.adviteya.model.MA_Employee;
import com.adviteya.model.MA_MailMessage;
import com.adviteya.model.MA_Shift;
import com.adviteya.util.MailUtil;
import com.adviteya.util.ServiceUtil;
import com.google.appengine.api.blobstore.BlobstoreServicePb.BlobstoreService.ServerConfig;
import com.google.appengine.api.datastore.Text;

public class OMCEmailCommunicatonService implements IOMCCommuncationService,
		IMobileAttendanceConstants {
	private static Logger logger = Logger
			.getLogger(OMCEmailCommunicatonService.class.getName());
	private static OMCEmailCommunicatonService emailCommunicationService;

	private OMCEmailCommunicatonService() {
	}

	public static OMCEmailCommunicatonService getInstance() {

		if (emailCommunicationService == null) {
			emailCommunicationService = new OMCEmailCommunicatonService();
		}

		return emailCommunicationService;
	}

	/**
	 * <pre>
	 * 1. Load alert
	 * 2. Check if it needs escalation
	 * 3. Send mail - if it needs escalation, then copy the manager
	 * </pre>
	 * 
	 * @param server
	 */

	public void transmitShiftAlert(MA_Alert _alert, String server) {
		logger.log(Level.INFO,
				" Start transmitShiftAlert method and  alertId---->"
						+ _alert.getKey().getId());
		MA_AlertType alertType = _alert.getAlertTypeRef().getModel();

		MA_EmailTemplate _emailTemplate = MailUtil.getTemplate(alertType
				.getAlertKey());
		AlertService alertService = new AlertService();
		Text _mailMessageText = _emailTemplate.getEmailMessage();

		String _mailMessageString = _mailMessageText.getValue();

		MA_MailMessage _mailMessage = new MA_MailMessage();

		HashMap<String, String> _toAddress = new HashMap<String, String>();

		String firstManagerEmailId = _alert.getFirstLevelManager().getModel()
				.getEmailId();
		String secondManagerEmailId = _alert.getSecondLevelManager().getModel()
				.getEmailId();
		String companyLogo = _alert.getCompanyref().getModel()
				.getLogoFileName();
		String companyName = _alert.getCompanyref().getModel().getCompanyName();

		_toAddress.put(firstManagerEmailId, firstManagerEmailId);
		_mailMessage.setToRecipient(_toAddress);

		// set sender name and address
		String _emailSender = ServiceUtil.getServerConfig(OMC_EMAIL_SENDER)
				.getConfigValue();
		_mailMessage.setSenderAddress(_emailSender);
		String _emailSenderName = ServiceUtil.getServerConfig(
				OMC_EMAIL_SENDER_NAME).getConfigValue();
		_mailMessage.setSenderName(_emailSenderName);

		// check if it is escalated
		if (_alert.isEscalated()) {
			HashMap<String, String> _ccAddress = new HashMap<String, String>();
			_ccAddress.put(secondManagerEmailId, secondManagerEmailId);
			_mailMessage.setCcRecipient(_ccAddress);
		}

		// set Date and time For the Email

		String timeZone = _alert.getLocationRef().getModel().getTimeZone();
		Calendar cal = Calendar.getInstance();
		DateTimeZone jdtz = DateTimeZone.forID(timeZone);
		long timeInMil = jdtz.convertUTCToLocal(cal.getTimeInMillis());
		cal.clear();
		cal.setTimeInMillis(timeInMil);
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy hh:mm aa");
		String dateTime = sdf.format(cal.getTime());

		_mailMessage.setMessageSubject(_emailTemplate.getEmailSubject() + "-"
				+ dateTime + " (" + timeZone + ")");
		_mailMessageString = _mailMessageString.replace(DATE_TIME, dateTime
				+ " (" + timeZone + ")");
		_mailMessageString = _mailMessageString.replace(SERVER, server);
		_mailMessageString = _mailMessageString.replace(COMPANY_LOGO,
				companyLogo);
		_mailMessageString = _mailMessageString.replace(COMPANY_NAME,
				companyName);
		// Replace mail message string with right values
		_mailMessageString = _mailMessageString.replace(ACCOUNTNAME, _alert
				.getFirstLevelManager().getModel().getFirstName()
				+ " " + _alert.getFirstLevelManager().getModel().getLastName());

		_mailMessageString = _mailMessageString.replace(LOCATION_NAME, _alert
				.getLocationRef().getModel().getLocationName());

		_mailMessageString = _mailMessageString.replace(SHIFT, _alert
				.getShiftRef().getModel().getShiftName());

		String ShiftTime = new ShiftBusinessService().getshiftTime(_alert
				.getShiftRef().getModel());

		_mailMessageString = _mailMessageString.replace(SHIFT_TIME, ShiftTime);

		List<MA_Employee> supervisorlist = ShiftBusinessService
				.getShiftSupervisor(_alert.getShiftRef().getKey().getId());

		String supervisorNames = "";

		if (!supervisorlist.isEmpty()) {
			for (MA_Employee employee : supervisorlist) {
				if (!supervisorNames.equalsIgnoreCase(""))
					supervisorNames += ",";
				supervisorNames += employee.getFirstName()
						+ employee.getLastName();
			}
		} else {
			supervisorNames = "No supervisor is assigned";
		}

		_mailMessageString = _mailMessageString.replace(SHIFT_SUPERVISOR_NAME,
				supervisorNames);

		_mailMessageString = _mailMessageString.replace(SHIFT_MANAGER_NAME,
				_alert.getFirstLevelManager().getModel().getFirstName()
						+ " "
						+ _alert.getFirstLevelManager().getModel()
								.getLastName());

		// Replace mail message String with proper values depending on Alertype
		// And Shift start/end Time.

		DashboardBusinessService DashboardBusinessService = new DashboardBusinessService();

		ShiftDashboardReportDTO shiftDashboardReportDTO = DashboardBusinessService
				.getShiftDashboardReportDTO(_alert.getShiftRef().getModel(),
						cal);
		if (_alert.getAlertTypeRef().getModel().getDisplayName()
				.equals(PUNCTUALITY)) {
			_mailMessageString = fillPunctualityAlert(_mailMessageString,
					_alert);
			_mailMessageString = setDashboardValuesForStartShift(
					_mailMessageString, _alert, shiftDashboardReportDTO);
		} else if (_alert.getAlertTypeRef().getModel().getDisplayName()
				.equals(RESOURCE_STRENGTH)) {
			_mailMessageString = fillResourceStrengthAlert(_mailMessageString,
					_alert);
			_mailMessageString = setDashboardValuesForStartShift(
					_mailMessageString, _alert, shiftDashboardReportDTO);

		} else if (_alert.getAlertTypeRef().getModel().getDisplayName()
				.equals(FEMALE_EMPLOYEE_SECURITY)) {
			_mailMessageString = fillFemaleEmplyeeSecurityAlert(
					_mailMessageString, _alert);
			_mailMessageString = setDashboardValuesForEndShift(
					_mailMessageString, _alert, shiftDashboardReportDTO);
			if (_alert.getActualValues() > 0) {
				_mailMessageString = setFemaleEmployeeNames(_mailMessageString, _alert);
			} else {
				_mailMessageString = _mailMessageString.replace(
						FEMALE_EMPLOYEE_NAMES,
						"All Female Employee(s) are Checked Out");
			}
		}

		_mailMessageText = new Text(_mailMessageString);

		_mailMessage.setMessageBody(_mailMessageText);

		MailUtil.sendMail(_mailMessage);

		alertService.setAlertTriggerLog(_alert);

		logger.log(Level.INFO, " End transmitShiftAlert method ");
	}

	/**
	 * @param _mailMessageString
	 * @param _alert
	 * @return
	 */
	private String setFemaleEmployeeNames(String _mailMessageString,
			MA_Alert _alert) {

		TimeSheetBusinessService businessService = new TimeSheetBusinessService();

		Calendar c = Calendar.getInstance();
//		c.clear();
//		c.set(2013, 0, 21, 00, 00);
		String marker = "NO_OUT_TIME";

		List<MA_ConsolidatedTimesheet> consolidatedtimesheetList = businessService
				.getConsolidatedTimeSheetrByMarker(c, _alert.getShiftRef()
						.getModel(), marker);
		List<MA_ConsolidatedTimesheet> femaleEmployeeTimesheets = businessService
				.getFemaleEmployeeTimesheet(consolidatedtimesheetList);

		String femaleEmployeeNames = "";
		for (MA_ConsolidatedTimesheet timesheet : femaleEmployeeTimesheets) {

			if (!femaleEmployeeNames.equals("")) {
				femaleEmployeeNames += ",";
			}
			MA_Employee employee = timesheet.getAssignmentRef().getModel()
					.getEmployeeRef().getModel();
			femaleEmployeeNames += employee.getFirstName() + " "
					+ employee.getLastName();
		}

		_mailMessageString = _mailMessageString.replace(FEMALE_EMPLOYEE_NAMES,
				femaleEmployeeNames);

		return _mailMessageString;
	}

	/**
	 * @param _mailMessageString
	 * @param _alert
	 * @return
	 */
	private String fillFemaleEmplyeeSecurityAlert(String _mailMessageString,
			MA_Alert _alert) {
		logger.log(Level.INFO, " Female Employee Security Alert Id---->"
				+ _alert.getKey().getId());
		_mailMessageString = _mailMessageString.replace(ACTUAL_RESOURCE,
				Integer.toString(_alert.getActualValues()));
		return _mailMessageString;
	}

	/**
	 * @param _mailMessageString
	 * @param _alert
	 * @return
	 */

	private String fillResourceStrengthAlert(String _mailMessageString,
			MA_Alert _alert) {

		_mailMessageString = _mailMessageString.replace(MIN_EXPECTED_RESOURCE,
				Integer.toString(_alert.getMinValueForAlert()));
		_mailMessageString = _mailMessageString.replace(MAX_EXPECTED_RESOURCE,
				Integer.toString(_alert.getMaxValueForAlert()));
		_mailMessageString = _mailMessageString.replace(ACTUAL_RESOURCE,
				Integer.toString(_alert.getActualValues()));
		return _mailMessageString;
	}

	/**
	 * @param _mailMessageString
	 * @param _alert
	 * @return
	 */

	private String fillPunctualityAlert(String _mailMessageString,
			MA_Alert _alert) {

		_mailMessageString = _mailMessageString.replace(
				"$minExpectedResourcesLable$", "Late In (Max): ");
		_mailMessageString = _mailMessageString.replace(
				"$actualResourcesLable$", "Late In (Actual): ");

		_mailMessageString = _mailMessageString.replace(MIN_EXPECTED_RESOURCE,
				Integer.toString(_alert.getMinValueForAlert()) + "%");

		_mailMessageString = _mailMessageString.replace(ACTUAL_RESOURCE,
				Integer.toString(_alert.getActualValues()) + "%");
		return _mailMessageString;
	}

	/**
	 * @param _mailMessageString
	 * @param _alert
	 * @param shiftDashboardReportDTO
	 * @return
	 */

	private String setDashboardValuesForStartShift(String _mailMessageString,
			MA_Alert _alert, ShiftDashboardReportDTO shiftDashboardReportDTO) {

		_mailMessageString = _mailMessageString.replace("$EarlyIN$",
				new Integer(shiftDashboardReportDTO.getEmployeeEarlyIN())
						.toString());
		_mailMessageString = _mailMessageString.replace("$RightIN$",
				new Integer(shiftDashboardReportDTO.getEmployeeRightIN())
						.toString());
		_mailMessageString = _mailMessageString.replace("$LateIN$",
				new Integer(shiftDashboardReportDTO.getEmployeeLateIN())
						.toString());
		_mailMessageString = _mailMessageString.replace("$totalIN$",
				new Integer(shiftDashboardReportDTO.getTotalNumOfEmployeesIN())
						.toString());

		return _mailMessageString;
	}

	/**
	 * @param _mailMessageString
	 * @param _alert
	 * @param shiftDashboardReportDTO
	 * @return
	 */

	private String setDashboardValuesForEndShift(String _mailMessageString,
			MA_Alert _alert, ShiftDashboardReportDTO shiftDashboardReportDTO) {
		_mailMessageString = _mailMessageString.replace("$EarlyOUT$",
				new Integer(shiftDashboardReportDTO.getEmployeeEarlyOUT())
						.toString());
		_mailMessageString = _mailMessageString.replace("$RightOUT$",
				new Integer(shiftDashboardReportDTO.getEmployeeRightOUT())
						.toString());
		_mailMessageString = _mailMessageString.replace("$LateOUT$",
				new Integer(shiftDashboardReportDTO.getEmployeeLateOUT())
						.toString());
		_mailMessageString = _mailMessageString
				.replace(
						"$totalOUT$",
						new Integer(shiftDashboardReportDTO
								.getTotalNumOfEmployeesOUT()).toString());

		return _mailMessageString;
	}
}
