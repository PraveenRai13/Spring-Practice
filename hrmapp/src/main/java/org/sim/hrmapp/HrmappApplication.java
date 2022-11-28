package org.sim.hrmapp;

import java.time.LocalDate;

import org.sim.hrmapp.entities.Emp;
import org.sim.hrmapp.repository.EmployeeRepository;
import org.sim.hrmapp.repository.EmployeeRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HrmappApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(HrmappApplication.class, args);
		EmployeeRepository repo = context.getBean("empRepository", EmployeeRepositoryImpl.class);
		Emp e =new Emp();
		/*e.setName("Praveen");
		e.setAddress("Mumbai");
		e.setDateofjoining(LocalDate.of(2015, 11, 01));
		repo.insertEmployee(e);
		repo.deleteEmployee(2);*/
		repo.getEmployees();
	}

}
