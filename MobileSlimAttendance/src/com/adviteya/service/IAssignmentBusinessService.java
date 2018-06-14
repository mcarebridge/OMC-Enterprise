package com.adviteya.service;

import java.util.List;

import com.adviteya.dto.AssignmentDTO;

public interface IAssignmentBusinessService
{
	
	String createUpdateAssignment(List<AssignmentDTO> assignmentList);
	
	String getAllShiftByLocation(Long companyId);
	
}
