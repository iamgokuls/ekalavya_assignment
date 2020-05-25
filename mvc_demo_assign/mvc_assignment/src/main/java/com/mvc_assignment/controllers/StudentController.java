package com.mvc_assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc_assignment.dto.StudentDto;
import com.mvc_assignment.service.StudentService;
import com.mvc_assignment.util.TotalMarkRequest;
import com.mvc_assignment.util.TotalMarkResponse;

@Controller
public class StudentController {
	
	@Autowired
	StudentService s;
	
	// list all students
	@GetMapping("/list")
	@ResponseBody
	public List<StudentDto> getlist(){
		return s.getStudents();
	}
	
	// list student by Id
	@GetMapping("/find")
	@ResponseBody
	public StudentDto fetchStudent(@RequestParam String id) {
		
		return s.fetchStudent(id);
	}
	
	// Get total mark of student with specified Id
	@PostMapping(value="/total", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TotalMarkResponse findtotal(@RequestBody TotalMarkRequest totalmarkrequest) {
		
		TotalMarkResponse response=s.calculate_total(totalmarkrequest);
		
		return response;
	}
	

}
