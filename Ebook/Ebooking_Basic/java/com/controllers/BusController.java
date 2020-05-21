package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.BusDao;
import com.models.Bus;
import com.models.Passenger;

@RestController
public class BusController {

	@Autowired
	private BusDao bd;
		
	
	// get all bus info
	 
	 @RequestMapping(value="/bus", method=RequestMethod.GET)
	 @ResponseBody
	    public  ResponseEntity<List<Bus>>  getBus() {
		 
		 ResponseEntity<List<Bus>> response = new ResponseEntity<>(HttpStatus.OK);
		 List<Bus> buses =bd.selectOp();
			
		 System.out.println(buses);
	     return response.ok().body(buses);
	 
	        
		    
	    }
	 
	 // get details about a particular bus
	 
	 @GetMapping("/bus/{bid}")
	 @ResponseBody
	public Bus getBus(@PathVariable String bid)
	{
		Bus b=bd.selectBus(Integer.parseInt(bid));
		System.out.println(b);
		return b; 
	}
	 
	 //select bus by class
	 
	 @GetMapping("/bus/byclass/{bus_class}")
	 @ResponseBody
	public List<Bus> getBusByClass(@PathVariable String bus_class)
	{
		List<Bus> buses=bd.selectBusByClass(bus_class);
		System.out.println(buses);
		return buses; 
	}
	 
 //select bus by destination
	 
	 @GetMapping("/bus/bydest/{dest}")
	 @ResponseBody
	public List<Bus> getBusByDest(@PathVariable String dest)
	{
		List<Bus> buses=bd.selectBusByDest(dest);
		System.out.println(buses);
		return buses; 
	}
	 
}
