package com.java.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int studentId;
	@Column(name="student_name")
	private String studentName;
	@ManyToOne
	@JoinColumn(name="class_id")
	private CollegeClass CollegeClass;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public CollegeClass getCollegeClass() {
		return CollegeClass;
	}
	public void setCollegeClass(CollegeClass collegeClass) {
		CollegeClass = collegeClass;
	}
	
	
}
