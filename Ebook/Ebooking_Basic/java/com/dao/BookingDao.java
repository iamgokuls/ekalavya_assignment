package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.models.Booking;
import com.models.Bus;
import com.models.Passenger;
import com.dao.PassengerDao;


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
	 
	 public Booking selectBooking(int bookid) {
		 session = factory.openSession();
         tx = session.beginTransaction();
         Booking b=session.get(Booking.class, bookid);
         tx.commit();
         session.close();
         System.out.println("succsess");
         return b;
         
	 }

	public List<Booking> selectBookHistory(int pid) {
		
		 session = factory.openSession();
         tx = session.beginTransaction();
         
         Passenger pass=new PassengerDao().selectPass(pid);
         
         Criteria crit = session.createCriteria(Booking.class);
         crit.add(Restrictions.eq("passenger",pass));
         List<Booking> results = crit.list();
         
         tx.commit();
         session.close();
         System.out.println("succsess");
         return results;
	}

}
