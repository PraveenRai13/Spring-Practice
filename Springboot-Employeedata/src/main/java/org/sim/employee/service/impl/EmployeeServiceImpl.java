package org.sim.employee.service.impl;

import org.sim.employee.model.Employee;
import org.sim.employee.repository.EmployeeRepository;
import org.sim.employee.service.EmployeeService;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

}
