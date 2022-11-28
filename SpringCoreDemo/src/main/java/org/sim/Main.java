package org.sim;

import org.sim.beans.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Emp e = context.getBean("e",Emp.class);
		System.out.println(e.getEno()+"\t"+e.getName()+"\t" +e.getAddress());
		

	}

}
