package org.sim.hrmapp.repository;

import java.util.List;

import org.sim.hrmapp.entities.Emp;

public interface EmployeeRepository {
	void insertEmployee(Emp e);
	void deleteEmployee(int eno);
	List<Emp> getEmployees();
	Emp getEmployee(int eno);
	
}
