package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.models.Student;
import com.service.StudentService;

@Controller
public class DemoController {
	
	
	@Autowired
	StudentService s;
	
	@GetMapping("/print")
	@ResponseBody
	public String print() {
		return "Inside demo contoller";
		
	}

	@GetMapping("/list")
	@ResponseBody
	public List<Integer> list() {
		//return "Inside demo contoller";
		List<Integer> ls=new ArrayList<>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		return ls;
	}
	
	@GetMapping("/object")
	@ResponseBody
	public DemoClass display() {
		DemoClass dc=new DemoClass();
		dc.setId(15);
		dc.setName("dsfajk");
		return dc;
	}
	
	@GetMapping("/student")
	@ResponseBody
	public Student getById() {
		return s.getById(102);
	}
	
}
