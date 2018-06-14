package com.adviteya.service;

public interface ICronJobService
{
	void updateAssignmentsForAllCompanies();
	
	void createConsolidatedTimeSheet();
	
	void updateConsolidatedTimeSheet();
	
	void createInTimedashBoardData();
	
	void createOutTimedashBoardData();
}
