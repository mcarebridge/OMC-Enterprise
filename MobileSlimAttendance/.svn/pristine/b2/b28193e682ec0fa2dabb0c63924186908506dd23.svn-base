package com.adviteya.service;

import java.util.List;

import com.adviteya.model.MA_TimeSheetRule;
import com.adviteya.model.MA_Timesheet;
import com.adviteya.model.MA_User;

public interface ITimeSheetBusinessService
{
	
	List<MA_Timesheet> synchTimeSheet(List timesheet, MA_User user,
	        boolean hasPlannedAssignments);
	
	List<MA_TimeSheetRule> getTimesheetRulesOfCompany(Long companyId);
	
	void approveTimesheets(Long companyId, String[] timesheetIds,
	        String[] billableEffort);
	
	boolean hasPlannedAssignment(Long companyId);
	
}
