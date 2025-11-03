package com.rays.crud;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestUpdate {

	public static void main(String[] args) {

		UserDTO dto = new UserDTO();

		dto.setId(2);
		dto.setFirstName("Ani");
		dto.setLastName("Raj");
		dto.setLoginId("Ani@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("Indore");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();
	}

}
