package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.BookingDao;
import com.models.Booking;
import com.models.Bus;
import com.models.Passenger;

@Controller
public class BookingController {
	
	@Autowired
	private BookingDao bd;
		
	
	@RequestMapping("/book_list")
	@ResponseBody
	public String BookingInfo() {
		
		List<Booking> bookings =bd.selectOp();
		
		System.out.println(bookings);
		
		return "Booking list";
	}
	
	@RequestMapping(value="/booking", method=RequestMethod.GET)
	 @ResponseBody
	    public  ResponseEntity<List<Booking>>  getPass() {
		 
		 ResponseEntity<List<Booking>> response = new ResponseEntity<>(HttpStatus.OK);
		 List<Booking> bookings =bd.selectOp();
			
		 System.out.println(bookings);
	     return response.ok().body(bookings);
	 
	        
		    
	    }

}
