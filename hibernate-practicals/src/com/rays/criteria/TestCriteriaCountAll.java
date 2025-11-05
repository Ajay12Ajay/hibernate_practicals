package com.rays.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.rays.user.UserDTO;

public class TestCriteriaCountAll {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDTO.class);

		ProjectionList p = Projections.projectionList();

		 p.add(Projections.count("lastName"));

		p.add(Projections.rowCount());

		criteria.setProjection(p);
		
		List list = criteria.list();
		Object[] row = (Object[]) list.get(0);
		System.out.println("Count(lastName): " + row[0]);
		System.out.println("Row count: " + row[1]);


//		List list = criteria.list();
//
//		Iterator it = list.iterator();
//
//		while (it.hasNext()) {
//
//			Object dto = (Object) it.next();
//			System.out.println(dto);
//		}
		tx.commit();
		session.close();
	}
}