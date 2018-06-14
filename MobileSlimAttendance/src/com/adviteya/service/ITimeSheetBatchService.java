package com.adviteya.service;

public interface ITimeSheetBatchService
{
	
	/**
	 * get all the Assignments
	 */
	void getAllAssignments(Long companyId);
	
	/**
	 * Get all the assignments for which there are no consolidated Timesheets
	 */
	void getAllOpenAssignments(Long shiftId);
	
	/**
	 * Create consolidated Timesheet entry for all the Entry timesheets
	 * 
	 * @param companyId
	 */
	void createConsolidatedTimesheetForEntry(Long companyId);
	
	/**
	 * Create consolidated Timesheet entry for all the Exit timesheets
	 * 
	 * @param companyId
	 */
	void createConsolidatedTimesheetForExit(Long companyId);
	
	/**
	 * Update All Orphan timesheets which have been updated even after Max size
	 * of employee has passed
	 */
	void updateOrphanTimesheets();
	
}
