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




@Service
public class BusDao {
	
	SessionFactory factory=null;
	 Session session = null;
	 Transaction tx = null;
	 
	 BusDao(){
		 
		 try{
			 factory = new Configuration().configure().addAnnotatedClass(Bus.class).buildSessionFactory();
	        }
	        catch (Throwable throwable){
	            System.out.println("Error");
	            throw new ExceptionInInitializerError(throwable);
	        }
	 }
	 
	 public List<Bus> selectOp() {
		 
	 	 session = factory.openSession();
         tx = session.beginTransaction();
         String hql="from com.models.Bus";
         List<Bus> buses = session.createQuery(hql).list();
         tx.commit();
         session.close();
         System.out.println("succsess");
         return buses;      	
   
   }
	 
	 public Bus selectBus(int bid) {
		 session = factory.openSession();
         tx = session.beginTransaction();
         Bus b=session.get(Bus.class, bid);
         tx.commit();
         session.close();
         System.out.println("succsess");
         return b;
         
	 }
	 
	 public List<Bus> selectBusByClass(String bus_class) {
		 session = factory.openSession();
         tx = session.beginTransaction();
         
         
         Criteria crit = session.createCriteria(Bus.class);
         crit.add(Restrictions.eq("bus_class",bus_class));
         List<Bus> results = crit.list();
         
         tx.commit();
         session.close();
         System.out.println("succsess");
         return results;
         
	 }
	 
	 public List<Bus> selectBusByDest(String toloc) {
		 session = factory.openSession();
         tx = session.beginTransaction();
         
         
         Criteria crit = session.createCriteria(Bus.class);
         crit.add(Restrictions.eq("toloc",toloc));
         List<Bus> results = crit.list();
         
         tx.commit();
         session.close();
         System.out.println("succsess");
         return results;
         
	 }

	public List<Bus> FindBus(String from, String to) {
		
		session = factory.openSession();
        tx = session.beginTransaction();
        
        
        Criteria crit = session.createCriteria(Bus.class);
        crit.add(Restrictions.eq("fromloc",from));
        crit.add(Restrictions.eq("toloc",to));
        List<Bus> results = crit.list();
        
        tx.commit();
        session.close();
        System.out.println("succsess");
        return results;
	}

	public void createBus(Bus bus) {
		
		session = factory.openSession();
        tx = session.beginTransaction();
        
        session.save(bus);
        
        tx.commit();
        session.close();
        System.out.println("succsess");
		
	}
	
	public int seatAvailability(int bid,String travel_date) {
		
		session = factory.openSession();
        tx = session.beginTransaction();
        
        Bus bus=session.get(Bus.class,bid);
        
        Criteria crit = session.createCriteria(Booking.class);
        crit.add(Restrictions.eq("travel_date",travel_date));
        crit.add(Restrictions.eq("bus",bus));
        List<Booking> tickets = crit.list();
        
        int availability=bus.getTotal_seats() - tickets.size();
                
        tx.commit();
        session.close();
        System.out.println("succsess");
		
		return availability;
	}

	

}
