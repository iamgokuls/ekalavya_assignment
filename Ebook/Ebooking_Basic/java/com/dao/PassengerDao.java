package com.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.models.Passenger;

@Service
public class PassengerDao {
	
	SessionFactory factory=null;
	 Session session = null;
	 Transaction tx = null;
	 
	 PassengerDao(){
		 
		 try{
			 factory = new Configuration().configure().addAnnotatedClass(Passenger.class).buildSessionFactory();
	        }
	        catch (Throwable throwable){
	            System.out.println("Error");
	            throw new ExceptionInInitializerError(throwable);
	        }
	 }
	 
	 public List<Passenger> selectOp() {
		 
		 		session = factory.openSession();
	            tx = session.beginTransaction();
	            String hql="from com.models.Passenger";
	            List<Passenger> passengers = session.createQuery(hql).list();
	            tx.commit();
	            session.close();
	            System.out.println("succsess");
	            return passengers;      	
	      
	 }
	 
	 public Passenger selectPass(int pid) {
		 session = factory.openSession();
         tx = session.beginTransaction();
         Passenger p=session.get(Passenger.class, pid);
         tx.commit();
         session.close();
         System.out.println("succsess");
         return p;
         
	 }

	public void cretePassenger(Passenger user) {
		session = factory.openSession();
        tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
        System.out.println("succsess");
        
		
	}

}
