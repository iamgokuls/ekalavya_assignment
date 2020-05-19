package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/good")
public class Demo_ClassLevel_Conroller {
	
	@ResponseBody
	@RequestMapping("/night")
	public String display() {
		return "Good night";
	}

}
