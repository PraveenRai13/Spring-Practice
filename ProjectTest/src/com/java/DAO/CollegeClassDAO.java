package com.java.DAO;

import java.util.List;

import com.java.persistance.CollegeClass;

public interface CollegeClassDAO {
	public int addCollegeClass(CollegeClass collegeClass);
	
	public List<CollegeClass> getCollegeClass();
	
	public CollegeClass	getCollegeClasses(int classId);
	
	public void deleteCollegeClass(int classId);
	
	public void updateCollegeClass(int classId);
}
