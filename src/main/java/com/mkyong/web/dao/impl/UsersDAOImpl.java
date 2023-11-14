package com.mkyong.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.web.dao.UsersDAO;
import com.mkyong.web.entities.Users;

@Repository
public class UsersDAOImpl implements UsersDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Users> getUsers() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Users").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertUser(Users u) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Users> login(String email, String password) {
		Session session = sessionFactory.openSession();
		try {
			
			List list = session.createQuery("from Users where email = :email and password = :password")
					.setParameter("email", email)
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
