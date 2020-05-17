package hibernate_demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDao {
	
	 SessionFactory factory=null;
	 Session session = null;
	 Transaction tx = null;
	 
	 StudentDao(){
		 
		 try{
			 factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	        }
	        catch (Throwable throwable){
	            System.out.println("Error");
	            throw new ExceptionInInitializerError(throwable);
	        }
	 }
	 
	 public void insertOp(int sid,String sname,int sem,int age,String mobile,String email){

	        session = factory.openSession();
	        try{
	            tx = session.beginTransaction();
	            //Employee Employee = new Employee(name , salary);
	            //session.save(Employee);
	            Student student=new Student(sid,sname,sem,age,mobile,email);
	            session.save(student);
	            tx.commit();
	        }
	        catch (HibernateException e){
	            if(tx != null) tx.rollback();
	            e.printStackTrace();
	        }
	        finally {
	            session.close();
	        }
	    }


}
