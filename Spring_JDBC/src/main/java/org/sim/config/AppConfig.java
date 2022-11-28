package org.sim.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "org.sim")
public class AppConfig {
	@Bean
public DataSource datasource() {
	DriverManagerDataSource datasource = new DriverManagerDataSource();
	datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	datasource.setUrl("jdbc:mysql://localhost:3306/prav");
	datasource.setUsername("root");
	datasource.setPassword("root");
	return datasource;	
}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate template =new JdbcTemplate();
		template.setDataSource(datasource());
		return template;
		
	}
}
