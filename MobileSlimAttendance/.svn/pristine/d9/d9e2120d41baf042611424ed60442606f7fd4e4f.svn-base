package com.adviteya.persistence;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.meta.MA_AssignmentMeta;
import com.adviteya.model.MA_Assignment;
import com.google.appengine.api.datastore.Key;

public class AssignmentDAO extends AbstractEntityDAO
{
	
	private static AssignmentDAO assignmentDAO;
	private MA_AssignmentMeta    assignmentMeta = new MA_AssignmentMeta();
	
	private AssignmentDAO()
	{
	}
	
	public static AssignmentDAO newInstance()
	{
		
		if (assignmentDAO == null)
		{
			
			assignmentDAO = new AssignmentDAO();
		}
		return assignmentDAO;
	}
	
	public static List<Key> createUpdateAssignments(List assignments)
	{
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		AbstractEntityDAO.setGtx(gtx);
		List<Key> keyList = addModels(assignments);
		readCounter += keyList.size();
		gtx.commit();
		return keyList;
	}
	
	public MA_Assignment getAssignmentObj(Key assignmentkey)
	{
		System.out.println("---- getAssignmentObj");
		readCounter++;
		System.out.println("-- Read Counter -- " + readCounter);
		return Datastore.query(assignmentMeta)
		        .filter(assignmentMeta.key.equal(assignmentkey)).asSingle();
	}
	
}
