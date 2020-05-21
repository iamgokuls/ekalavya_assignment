package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
	
	// Select all bookings list
	
	@RequestMapping(value="/booking", method=RequestMethod.GET)
	 @ResponseBody
	    public  ResponseEntity<List<Booking>>  getPass() {
		 
		 ResponseEntity<List<Booking>> response = new ResponseEntity<>(HttpStatus.OK);
		 List<Booking> bookings =bd.selectOp();
			
		 System.out.println(bookings);
	     return response.ok().body(bookings);
	 
	        
		    
	    }
	
	//select a particular booking based on bookid
	
	@GetMapping("/booking/{bookid}")
	 @ResponseBody
	public Booking getUser(@PathVariable String bookid)
	{
		Booking b=bd.selectBooking(Integer.parseInt(bookid));
		System.out.println(b);
		return b; 
	}

}
