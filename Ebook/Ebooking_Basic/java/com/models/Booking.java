package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	private int bookid;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="pid")
	 */
	private int pid;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="bid")
	 */
	private int bid;
	private Date travel_date=new Date();
	private int seat_num;
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public Date getTravel_date() {
		return travel_date;
	}
	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
	}
	public int getSeat_num() {
		return seat_num;
	}
	public void setSeat_num(int seat_num) {
		this.seat_num = seat_num;
	}

}
