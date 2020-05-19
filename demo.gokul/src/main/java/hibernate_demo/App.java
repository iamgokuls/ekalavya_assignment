package hibernate_demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		SessionFactory factory=null;
		Session session = null;
		Transaction tx = null;
		
		try{
			 factory = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Department.class).addAnnotatedClass(Professor.class).buildSessionFactory();
	        }
	        catch (Throwable throwable){
	            System.out.println("Error");
	            throw new ExceptionInInitializerError(throwable);
	        }
		
		session = factory.openSession();
        try{
            tx = session.beginTransaction();
            
			/*
			 * Professor pf=new Professor(); pf.setPid(3); pf.setPname("Ramya");
			 */
            
			/*
			 * Professor pf=session.get(Professor.class,1);
			 * 
			 * Subject s=new Subject(); s.setSid(102); s.setSname("English");
			 * s.setProfessor(pf); //session.save(pf); session.save(s);
			 */
            
			/*
			 * Department dp=new Department(); dp.setDid(202); dp.setDname("EEE");
			 */
            
            Department dp=session.get(Department.class, 201);
            
            Professor pf=new Professor();
            pf.setPid(6);
            pf.setPname("Abcd");
            pf.setDepartment(dp);
            
            session.save(pf);
            //session.save(dp);
            
            tx.commit();
        }
        catch (HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
        finally {
        	System.out.println("success....");
            session.close();
        }

	}

}
