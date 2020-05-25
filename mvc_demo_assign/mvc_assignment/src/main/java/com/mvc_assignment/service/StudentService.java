package com.mvc_assignment.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mvc_assignment.dao.StudentDao;
import com.mvc_assignment.dto.StudentDto;


@Service
public class StudentService {
	
	@Autowired
	StudentDao s;

	
	public List<StudentDto> getStudents() {
		
		return s.getStudents();
	}
	
	public StudentDto fetchStudent(String id) {
		return s.fetchStudent(id);
	}
	
	

}
