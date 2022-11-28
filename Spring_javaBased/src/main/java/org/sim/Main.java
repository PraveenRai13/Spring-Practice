package org.sim;

import org.sim.beans.Emp;
import org.sim.cofig.applicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(applicationConfiguration.class);
		Emp e = context.getBean("emp", Emp.class);
		System.out.println(e.getEno()+"\t"+e.getName()+"\t"+e.getLoc());
	}

}
