package com.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.database.entity.Certificate;
import com.database.entity.Student;


public class EmbedDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		
		Certificate certi = new Certificate("java Programming", "3 months");
		Student s1 = new Student(123, "Aman", "Mumbai", certi);
		
		Certificate certi1 = new Certificate("Hibernate", "2 months");
		Student s2 = new Student(125, "Ravi", "Delhi", certi1);
		
		Transaction tx = session.beginTransaction();
		
		session.save(s1);
		session.save(s2);
		
		tx.commit();
		
		session.close();
		factory.close();
	}

}
