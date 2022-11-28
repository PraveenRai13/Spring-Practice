package org.sim.cofig;

import org.sim.beans.Emp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class applicationConfiguration {
@Bean(name="emp")
public Emp employee(){
	Emp e = new Emp();
	e.setEno(1);
	e.setName("Praveen");
	e.setLoc("Mumbai");
	return e;
	
}
	
}

