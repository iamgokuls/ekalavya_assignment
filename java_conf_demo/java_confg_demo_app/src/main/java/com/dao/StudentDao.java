package com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.models.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		}
		catch(HibernateException e) {
			return sessionFactory.openSession();
		}
	}
	
	public Student getById(int sid) {
		
		return getSession().get(Student.class, sid);
	}
}
