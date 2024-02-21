package com.springJdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springJdbc.dao.StudentDao;
import com.springJdbc.dao.StudentDaoImpl;


@Configuration
@ComponentScan(basePackages = {"com.springJdbc.dao"})
public class JdbcConfig {
	
	@Bean("ds")
//	public DriverManagerDataSource getDataSource()
	public DataSource getDataSource()   //DriverManagerDataSource is a child class of DataSource
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;	
	}
	
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	
	@Bean(name={"studentDao"})
	public StudentDao getStudentDao()
	{
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
	}
	

}
