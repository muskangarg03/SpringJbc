package com.springJdbc.dao;

import java.util.List;

import com.springJdbc.entities.Student;

public interface StudentDao {

	public int insert(Student student);
	
	public int change(Student student);
	
	public int delete(int StudentId);
	
	//for selecting the single object
	public Student getStudent(int studentId);
	
	//for selecting multiple objects or rows
	public List<Student> getAllStudents();
	
}

