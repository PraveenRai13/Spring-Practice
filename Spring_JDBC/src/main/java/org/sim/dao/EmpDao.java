package org.sim.dao;

import java.util.List;

import org.sim.entities.Emp;

public interface EmpDao {
	void insert(Emp e);
	void delete(int eno);
	List<Emp>getEmployee();
	Emp getEmployee(int eno);
	void update (int eno,Emp e);

}
