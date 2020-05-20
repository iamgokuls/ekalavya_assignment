package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.models.Bus;




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

}
