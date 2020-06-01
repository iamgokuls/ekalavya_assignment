package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.models.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao sd;
	
	public Student getById(int sid) {
		return sd.getById(sid);
	}
}
