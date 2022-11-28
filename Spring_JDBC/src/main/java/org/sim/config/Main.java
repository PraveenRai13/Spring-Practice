package org.sim.config;

import org.sim.dao.EmpDao;
import org.sim.dao.EmpDaoImpl;
import org.sim.entities.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmpDao dao=context.getBean("Dao", EmpDaoImpl.class);
		dao.insert(new Emp(1, "Praveen", "Mumbai"));
		
	}
}
