package com.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.database.entity.Address;
import com.database.entity.Student;

/**
 * Welcome to hibernate examples
 *
 *@author surajbhandvale
 */
public class App {
	public static void main(String[] args) throws IOException {

		// for one project there should be one session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Student student = new Student(101, "Suraj", "Kolhapur", null);
		
		Address address = new Address();
		address.setStreet("Kate wasti road");
		address.setCity("Pune");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(23.45);
		
		FileInputStream fis = new FileInputStream("src/main/java/nature.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		address.setImage(data);
		
		
		Transaction transaction = session.beginTransaction();
		session.save(student);
		session.save(address);
		
		transaction.commit();
		session.close();
		
	}
}
