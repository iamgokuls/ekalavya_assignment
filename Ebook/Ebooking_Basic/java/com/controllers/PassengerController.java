package com.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.PassengerDao;
import com.models.Bus;
import com.models.Passenger;



@Controller
public class PassengerController {
	
	@Autowired
	private PassengerDao passdao;
	
	//get all passengers list
	
	@RequestMapping(value="/passenger", method=RequestMethod.GET)
	 @ResponseBody
	    public  ResponseEntity<List<Passenger>>  getPass() {
		 
		 ResponseEntity<List<Bus>> response = new ResponseEntity<>(HttpStatus.OK);
		 List<Passenger> passengers =passdao.selectOp();
			
		 System.out.println(passengers);
	     return response.ok().body(passengers);
	 
	        
		    
	    }
	
	//get a selected passenger info
	
	@GetMapping("/passenger/{pid}")
	 @ResponseBody
	public Passenger getUser(@PathVariable String pid)
	{
		Passenger p=passdao.selectPass(Integer.parseInt(pid));
		System.out.println(p);
		return p; 
	}
	
	

}
