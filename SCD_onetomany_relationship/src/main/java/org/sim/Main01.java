package org.sim;

import java.util.Set;

import org.sim.beans.Student;
import org.sim.beans.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main01 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext01.xml");
		Student student=context.getBean("student", Student.class);
		Set<Subject> subject= student.getSubjects();
		System.out.println(student.getName()+"\t"+student.getAddress());
		System.out.println("The Subjects are");
		for(Subject subjects:subject) {
			System.out.println(subjects.getSubjectName()+"\t"+subjects.getDuration());
		}
		

	}

}
