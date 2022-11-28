package com.java.DAO;

import java.util.List;

import com.java.persistance.Student;

public interface StudentDAO {
public int addStudent(Student student);
	
	public List<Student> getCollegeClass();
	
	public Student getStudent(int studentId);
	
	public void deleteStudent(int studentId);
	
	public void updateStudent(int studentId);
}
