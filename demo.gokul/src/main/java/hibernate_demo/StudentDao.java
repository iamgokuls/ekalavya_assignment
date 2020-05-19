package hibernate_demo;

import java.util.Iterator;
import java.util.List;

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
	 
	 public void updateOp(int sid,String email) {
		 
		 session = factory.openSession();
		 try{
	            tx = session.beginTransaction();
	            Student student=(Student)session.get(Student.class, sid);
	            student.setEmail(email);
	            session.update(student);
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
	 
	 public void deleteOp(int sid) {
		 
		 session = factory.openSession();
		 try{
	            tx = session.beginTransaction();
	            Student student=session.get(Student.class, sid);
	            session.delete(student);
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
	 
	 public void selectOp() {
		 
		 session = factory.openSession();
		 
		 try{
	            tx = session.beginTransaction();
	            String hql="from hibernate_demo.Student";
	            List<Student> students = session.createQuery(hql).list();
	            
	            for(Iterator<Student> itr = students.iterator(); itr.hasNext();){
	                Student s = itr.next();
	                System.out.println("Name:" + s.getSname());
	                System.out.println("Age:" + s.getAge());
	                System.out.println("Sem:" + s.getSem());
	                System.out.println("Mobile:" + s.getMobile());
	                System.out.println("email:" + s.getEmail());
	                System.out.println("\n");
	            }
	            
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
