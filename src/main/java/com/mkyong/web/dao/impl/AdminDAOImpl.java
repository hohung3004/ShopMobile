package com.mkyong.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.web.dao.AdminDAO;
import com.mkyong.web.entities.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Admin> loginAmin(String email, String password) {
		Session session = sessionFactory.openSession();
		try {
			
			List list = session.createQuery("from Admin where username = :emailadmin and password = :password")
					.setParameter("emailadmin", email)
					.setParameter("password", password).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
