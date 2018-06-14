package test.adviteya.mobile.util;

public interface MobileConstants
{
	
	String              TAG                                         = "MobileAttendanceDBHelper";
	static final String DATABASE_NAME                               = "adviteyaMobileDb";
	static final int    DATABASE_VERSION                            = 5;
	static final String TABLE_MOBILE_SYNC                           = "mobileSync";
	static final String TABLE_LOC_SHIFT_SYNC                        = "locationShiftSync";
	static final String TABLE_LOCAL_AUTH                            = "localAuth";
	
	// Database fields
	static final String KEY_ROWID                                   = "_id";
	static final String TIMESHEET_DATE                              = "timeSheetDate";
	static final String TIMESHEET_ID                                = "timesheetId";
	static final String ASSIGNMENT_ID                               = "assignmentId";
	static final String SHIFT_ID                                    = "shiftId";
	static final String LOCATION                                    = "location";
	static final String EMP_ID                                      = "empId";
	static final String EMPCOMPANY_ID                               = "empCompanyId";
	static final String EMPNAME                                     = "empName";
	static final String EMPPWD                                      = "empPwd";
	static final String INTIME                                      = "inTime";
	static final String OUTTIME                                     = "outTime";
	static final String MARKER                                      = "marker";
	
	// URL
	// static final String BASE_URL =
	// "https://adviteyadev.appspot.com/humancapital/";
	static final String BASE_URL = "http://localhost/humancapital/";
	//static final String BASE_URL                                    = "https://omcdev.appspot.com/humancapital/";
	static final String VALIDATE_MOBILE_SUPERVISOR                  = "mobileRequest?action=VALIDATE_MOBILE_SUPERVISOR";
	static final String IMEI_VALIDATE_MOBILE_SUPERVISOR             = "mobileRequest?action=IMEI_VALIDATE_MOBILE_SUPERVISOR";
	static final String SYNCH_SERVER_DATA                           = "mobileRequest?action=SYNCH_SERVER_DATA";
	static final String IMEI_SYNCH_SERVER_DATA                      = "mobileRequest?action=IMEI_SYNCH_SERVER_DATA";
	
	// Database creation sql statement
	// @deprecated
	// static final String DATABASE_CREATE = "create table " + TABLE_MOBILE_SYNC
	// + " (_id INTEGER primary key autoincrement, "
	// + " companyId INTEGER not null, " + "shiftId INTEGER not null, "
	// + " empId INTEGER not null, " + "empNum TEXT not null, "
	// + " passKey TEXT not null, " + "lastAction text not null, "
	// + " lastActionDateTime TEXT not null, " + "currentAction TEXT ,"
	// + " currentActionDateTime TEXT, " + "createBy TEXT not null, "
	// + " updatedBy TEXT," + "updateDateTime TEXT )";
	
	// Database creation sql statement
	static final String MOBILE_SYNCH_TABLE                          = "create table "
	                                                                        + TABLE_MOBILE_SYNC
	                                                                        + " (_id INTEGER primary key autoincrement, "
	                                                                        + " timeSheetDate TEXT not null,"
	                                                                        + " timesheetId TEXT not null,"
	                                                                        + " assignmentId TEXT not null,"
	                                                                        + " shiftId TEXT not null,"
	                                                                        + " location TEXT not null,"
	                                                                        + " empId TEXT not null,"
	                                                                        + " empCompanyId TEXT not null,"
	                                                                        + " empName TEXT not null,"
	                                                                        + " empPwd TEXT,"
	                                                                        + " inTime TEXT,"
	                                                                        + " outTime TEXT,"
	                                                                        + " marker TEXT )";
	
	// Database creation sql statement for location and shift
	static final String LOC_SHIFT_SYNC_TABLE                        = "create table "
	                                                                        + TABLE_LOC_SHIFT_SYNC
	                                                                        + " (_id INTEGER primary key autoincrement, "
	                                                                        + " locationKey TEXT not null,"
	                                                                        + " location TEXT not null,"
	                                                                        + " shiftKey TEXT not null,"
	                                                                        + " shift TEXT not null,"
	                                                                        + " timeZone TEXT not null"
	                                                                        + " )";
	
	static final String LOCAL_AUTH_TABLE                            = " create table "
	                                                                        + TABLE_LOCAL_AUTH
	                                                                        + " (imeiCode TEXT not null, "
	                                                                        + " userName TEXT not null, "
	                                                                        + " verify TEXT not null, "
	                                                                        + " currentDateTime TEXT not null"
	                                                                        + " )";
	
	// Messages
	static final String MOBILE_SUPERVISOR_AUTHENTICATION_SUCCESS    = "MOBILE_SUPERVISOR_AUTHENTICATION_SUCCESS";
	static final String MOBILE_SUPERVISOR_AUTHENTICATION_FAILED     = "MOBILE_SUPERVISOR_AUTHENTICATION_FAILED";
	static final String MOBILE_SUPERVISOR_AUTHENTICATION_SERVER_ERR = "MOBILE_SUPERVISOR_AUTHENTICATION_SERVER_ERR";
	static final String SERVER_ERR                                  = "Server error. Please click to close";
	static final String CONNECTION_ERR                              = "Connection lost. Please click to close";
	static final String FIRST_RUN                                   = "FIRST_RUN";
	static final String LOGIN_ID_VALIDATION                         = "Login Id is blank";
	static final String PASSCODE_VALIDATION                         = "Emp Passcode is blank";
	static final String ADMIN_USER_VERIFICATION_SUCCESS             = "Admin User authenticated";
	static final String ADMIN_USER_VERIFICATION_FAILED              = "Admin User not authenticated";
	
	static final String ADMIN_USER_SUCCESS                          = "";
	static final String ADMIN_USER_FAIL                             = "";
	
}