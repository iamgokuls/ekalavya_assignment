package com.mvc_assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc_assignment.dto.StudentDto;
import com.mvc_assignment.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService s;
	
	@GetMapping("/list")
	@ResponseBody
	public List<StudentDto> getlist(){
		return s.getStudents();
	}
	
	@GetMapping("/find")
	@ResponseBody
	public StudentDto fetchStudent(@RequestParam String id) {
		
		return s.fetchStudent(id);
	}

}
