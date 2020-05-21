package com.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="bus")
public class Bus {

	@Id
	private int bid;
	private String bname;
	private String fromloc;
	private String toloc;
	private String bus_class;
	private int total_seats;
	private int amount;
	
	@OneToMany(mappedBy="bus")
	private List<Booking> bookings=new ArrayList<Booking>();
	
	Bus(){}
	
	
	
	public Bus(int bid, String bname, String fromloc, String toloc, String bus_class, int total_seats, int amount) {
		
		this.bid = bid;
		this.bname = bname;
		this.fromloc = fromloc;
		this.toloc = toloc;
		this.bus_class = bus_class;
		this.total_seats = total_seats;
		this.amount = amount;
	}



	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getFromloc() {
		return fromloc;
	}
	public void setFromloc(String fromloc) {
		this.fromloc = fromloc;
	}
	public String getToloc() {
		return toloc;
	}
	public void setToloc(String toloc) {
		this.toloc = toloc;
	}
	public String getBus_class() {
		return bus_class;
	}
	public void setBus_class(String bus_class) {
		this.bus_class = bus_class;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
