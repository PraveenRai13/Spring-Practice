package org.sim.hrmapp.repository;

import java.util.List;

import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.sim.hrmapp.entities.Emp;
import org.springframework.stereotype.Repository;
@Repository("empRepository")
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository{
	private EntityManager em;
	public EmployeeRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}
	@Override
	public void insertEmployee(Emp e) {
		em.persist(e);
		em.flush();
	}

	@Override
	public void deleteEmployee(int eno) {

		Emp e=em.find(Emp.class, eno);
		em.remove(e);
	}

	@Override
	public List<Emp> getEmployees() {
		Query query=em.createQuery("select e from org.sim.hrmapp.entities.Emp e");
		return query.getResultList();
	}

	@Override
	public Emp getEmployee(int eno) {

		return em.find(Emp.class, eno);
	}


}
