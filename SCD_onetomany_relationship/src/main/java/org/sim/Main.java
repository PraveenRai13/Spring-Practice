package org.sim;

import java.util.List;

import org.sim.beans.College;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		College college=context.getBean("college", College.class);
		List<String> course=college.getCourse();
		System.out.println(college.getCid()+"\t"+college.getCollegeName());
		System.out.println("The courses are");
		for(String courses:course) {
		System.out.println(courses);	
		}
	}

}
