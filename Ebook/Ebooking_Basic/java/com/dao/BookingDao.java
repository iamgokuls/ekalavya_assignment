package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.models.Booking;


@Service
public class BookingDao {
	
	SessionFactory factory=null;
	 Session session = null;
	 Transaction tx = null;
	 
	 BookingDao(){
		 
		 try{
			 factory = new Configuration().configure().addAnnotatedClass(Booking.class).buildSessionFactory();
	        }
	        catch (Throwable throwable){
	            System.out.println("Error");
	            throw new ExceptionInInitializerError(throwable);
	        }
	 }
	 
	 public List<Booking> selectOp() {
		 
	 	 session = factory.openSession();
         tx = session.beginTransaction();
         String hql="from com.models.Booking";
         List<Booking> bookings = session.createQuery(hql).list();
         tx.commit();
         session.close();
         System.out.println("succsess");
         return bookings;      	
   
}

}
