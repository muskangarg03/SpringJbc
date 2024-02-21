package com.springJdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springJdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		//insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r= this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	
	@Override
	public int change(Student student) {
		// update data
		String query = "update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	
	@Override
	public int delete(int StudentId) {
		// delete data
		String query = "delete from student where id=?";
		int r = this.jdbcTemplate.update(query,StudentId);
		return r;
	}
	
	
	@Override
	public Student getStudent(int studentId) {
		// select single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();   // RowMapper is used to convert the resultSet into the object
		Student student= this.jdbcTemplate.queryForObject(query, rowMapper, studentId);	
		
		
		// Creating an Anonymous class for RowMapperImpl
//		Student student= (Student) this.jdbcTemplate.queryForObject(query, new RowMapper() {
//
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {		
//				Student student = new Student();
//				student.setId(rs.getInt(1));
//				student.setName(rs.getString(2));
//				student.setCity(rs.getString(3));		
//				return student;		
//				}
//		}, studentId);
		
		return student;
	}
	
	
	@Override
	public List<Student> getAllStudents() {
		// Selecting multiple students
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
