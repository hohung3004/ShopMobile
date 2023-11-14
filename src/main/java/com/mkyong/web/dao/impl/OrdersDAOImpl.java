package com.mkyong.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.web.dao.OrdersDAO;
import com.mkyong.web.entities.Orders;

@Repository
public class OrdersDAOImpl implements OrdersDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Orders> getOrders() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Orders").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public int insertOrder(Orders or) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(or);
			session.getTransaction().commit();
			return or.getId();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return -1;
	}

}
