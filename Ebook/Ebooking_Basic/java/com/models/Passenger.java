package com.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="passenger")
public class Passenger {
	
	@Id
	private int pid;
	private String pname;
	private String mobile;
	private String email;
	@OneToMany(mappedBy="passenger")
	private List<Booking> bookings;
	
	Passenger(){}
	
	public Passenger(int pid2, String pname2, String email2, String mobile2) {
		this.pid=pid2;
		this.pname=pname2;
		this.email=email2;
		this.mobile=mobile2;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
