package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	
	  @GetMapping("/booking/history/{pid}")
	  
	  @ResponseBody public List<Booking> getBookHistory(@PathVariable String pid)
	  {
		  List<Booking> history=bd.selectBookHistory(Integer.parseInt(pid));
		  System.out.println(history); 
		  return history;
	  }
	  
	  //Book bus  tickets
	  @PostMapping("/bookticket")
		@ResponseBody
		 public String addBus(
				 @RequestParam int bookid,
		         @RequestParam int pid ,
		         @RequestParam int bid,
		         @RequestParam String travel_date,
		         @RequestParam int seat_num
	
		
		 )
		{
		     
		     int status=bd.bookTicket(bookid,pid,bid,travel_date,seat_num);
		     if(status==1) {
		    	 return "Ticket booked Succesfully";
		     }
		     else 
		    	 return "No seats left";
		     
		 }
	 

}
