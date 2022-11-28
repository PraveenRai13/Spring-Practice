package org.sim.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name",nullable = false)
	private String firstname;
	@Column (name="last_name",nullable = false)
	private String lastname;
	@Column (name="email",nullable = false)
	private String email;
	

}
