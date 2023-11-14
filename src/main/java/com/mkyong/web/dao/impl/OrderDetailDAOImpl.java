package com.mkyong.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.web.dao.OrderDetailDAO;
import com.mkyong.web.entities.OrderDetail;
import com.mkyong.web.entities.Products;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderDetail> getOrderDetails() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from OrderDetail").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertOrderDetail(OrderDetail orDetail) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(orDetail);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
	
	

}
