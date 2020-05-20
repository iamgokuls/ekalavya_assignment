package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.BusDao;
import com.models.Bus;

@RestController
public class BusController {

	@Autowired
	private BusDao bd;
		
	
	
	 
	 @RequestMapping(value="/bus", method=RequestMethod.GET)
	 @ResponseBody
	    public  ResponseEntity<List<Bus>>  getBus() {
		 
		 ResponseEntity<List<Bus>> response = new ResponseEntity<>(HttpStatus.OK);
		 List<Bus> buses =bd.selectOp();
			
		 System.out.println(buses);
	     return response.ok().body(buses);
	 
	        
		    
	    }
	 
}
