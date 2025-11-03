package com.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAuction {

	public static void main(String[] args) {

		Bid bid = new Bid();
		// bid.setId(1);
		bid.setAmount(10);
		bid.setTimeStamp("X");

		Bid bid1 = new Bid();
		// bid1.setId(2);
		bid1.setAmount(20);
		bid1.setTimeStamp("XY");

		Bid bid2 = new Bid();
		// bid2.setId(3);
		bid2.setAmount(30);
		bid2.setTimeStamp("XYZ");

		Set bids = new HashSet();
		bids.add(bid);
		bids.add(bid1);
		bids.add(bid2);

		AuctionItem auc = new AuctionItem();
		auc.setId(101);
		auc.setDescription("Remote");
		auc.setBids(bids);

		AuctionItem auc1 = new AuctionItem();
		auc1.setId(102);
		auc1.setDescription("Remote2");
		auc1.setBids(bids);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(auc1);
		tx.commit();
		session.close();

	}

}
