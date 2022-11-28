package org.sim.configuration;

import java.util.ArrayList;
import java.util.List;

import org.sim.beans.College;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean(name="cources")
	public List<String> courses(){
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("Python");
		courses.add("C#"");"
		return courses;
	}
	@Bean
public College college() {
	College college= new College();
	college.setCid(1);
	college.setName("Simplilearn");
	college.setCourses(courses());
	return college;
}
}
