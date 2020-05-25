package com.mvc_assignment.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mvc_assignment.models.*;

@Configuration
public class HibernateUtil {
	
	 
	 public static  SessionFactory sessionFactory;
	 
	    @Bean
	    public SessionFactory getFactory() {
	    	 try{
		            sessionFactory = new org.hibernate.cfg.Configuration().configure()
		            		.addAnnotatedClass(Student.class)
		            		.buildSessionFactory();
		            //System.out.println("Yes");
		            return sessionFactory;
		        }

		        catch (Throwable e){
		            e.printStackTrace();
		            throw new ExceptionInInitializerError(e);
		        }
	    }
	    
	    public SessionFactory getSessionFactory() {
	    	return sessionFactory;
	    }
	    
	    
	  

}
