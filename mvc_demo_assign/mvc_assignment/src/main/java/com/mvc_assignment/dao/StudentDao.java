package com.mvc_assignment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mvc_assignment.dto.StudentDto;
import com.mvc_assignment.models.Student;

@Repository
public class StudentDao {
	
	 @Autowired
	 private SessionFactory sessionFactory;
	 private Session session;
	
	 @PostConstruct
	 public void init() {
		 session= sessionFactory.openSession();
	 }
	 
	 public StudentDto exportDto(Student student) {
		 
		 StudentDto s=new StudentDto();
		 
		 s.setId(student.getId());
		 s.setName(student.getName());
		 s.setCity(student.getCity());
		 s.setPhysics(student.getPhysics());
		 s.setChemistry(student.getChemistry());
		 s.setMaths(student.getMaths());
		 
		 return s;
	 }
	 
	 public Student importDto(StudentDto s) {
		 
		 Student student = new Student();
		 
		 student.setId(s.getId());
		 student.setName(s.getName());
		 student.setPhysics(s.getPhysics());
		 student.setChemistry(s.getChemistry());
		 student.setMaths(s.getMaths());
		 
		 return student;
	 }
	
	public List<StudentDto> getStudents(){
		
		List<Student> students=session.createQuery("from com.mvc_assignment.models.Student").list();
		List<StudentDto> result=new ArrayList<>();
		
		for(Student s: students) {
			result.add(exportDto(s));
		}
		return result;
	}
	
	public StudentDto fetchStudent(String id) {
		
		return exportDto(session.get(Student.class, id));
	}

}
