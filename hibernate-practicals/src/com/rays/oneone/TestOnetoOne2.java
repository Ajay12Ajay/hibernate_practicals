package com.rays.oneone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOnetoOne2 {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Employee emp = (Employee) session.get(Employee.class, 1);
		
		Transaction tx = session.beginTransaction();
		session.delete(emp);
		tx.commit();
		session.close();
	}
}
