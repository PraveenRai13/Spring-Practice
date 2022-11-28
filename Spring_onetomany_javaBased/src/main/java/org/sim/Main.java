package org.sim;

import java.util.List;

import org.sim.beans.College;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext("AppConfig.class");
		College college = context.getBean("college", College.class);
		List<String> courses=college.getCourses();
		System.out.println(college.getCid()+"\t"+college.getName());
		System.out.println("The courses are");
		for(String course:courses) {
			System.out.println(course);
		}
	}

}
