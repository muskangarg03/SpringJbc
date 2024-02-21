package com.springJdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springJdbc.dao.StudentDao;
import com.springJdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started......." );
        
        //spring jdbc -> JdbcTemplate
        
        //For config.xml
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/springJdbc/config.xml");
  
        //For Annotation
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        
        
//        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
//        
//        //insert query
//        String query = "insert into student(id,name,city) values(?,?,?)";
//        
//        //fire query
//        int result=template.update(query,456,"Darsh Garg","UP");
//        System.out.println("No. of records inserted: "+result);
   
        
        
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
    
        //Insert
//        Student student = new Student();
//        student.setId(222);
//        student.setName("Ram");
//        student.setCity("Mathura");
//        
//        int result = studentDao.insert(student);
//        System.out.println("Stuent Added :" +result);
  
    
        //Update
//        Student student =  new Student();
//        student.setId(456);
//        student.setName("Darsh");
//        student.setCity("Sikandara");
//        int result = studentDao.change(student);
//        System.out.println("Data Change :"+result);
        
        
        //Delete
//        int result = studentDao.delete(666);
//        System.out.println("Data deleted :"+result);
        
        
        //Select Single Data
//        Student student = studentDao.getStudent(111);
//        System.out.println(student);
        
        
        //Selecting multiple Data
        List<Student> students = studentDao.getAllStudents();
        for(Student s : students)
        {
        	System.out.println(s);
        }
        
    }
    
}
