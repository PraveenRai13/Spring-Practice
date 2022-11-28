package org.sim;

import org.sim.beans.Address;
import org.sim.beans.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Emp e = context.getBean("e",Emp.class);
		Address address = e.getAddress();
		System.out.println(e.getEno()+"\t"+e.getName());
		System.out.println(address.getDno()+"\t"+address.getStreetName()+"\t"+address.getLoc());
		

	}

}
