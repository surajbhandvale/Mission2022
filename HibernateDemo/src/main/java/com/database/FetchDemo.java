package com.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.database.entity.Address;
import com.database.entity.Student;

public class FetchDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Student student = session.get(Student.class, 105); // get method return null if object not found
												//check inside session or cache for object then hit to DB
		
		Address address = session.load(Address.class, 3); // load method return ObjectNotFound exception if object not found
							//return proxy object and hit to db when any method from object is called...lazy loading
		
		System.out.println("-------------------------------");
		System.out.println(student);
		System.out.println(address.getStreet()+"--"+ address.getCity());
		
		session.close();
		factory.close();
	}

}
