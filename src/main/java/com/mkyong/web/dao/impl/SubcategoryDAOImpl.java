package com.mkyong.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.web.dao.SubcategoryDAO;
import com.mkyong.web.entities.Subcategory;

@Repository
public class SubcategoryDAOImpl implements SubcategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Subcategory> getSubcategories() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Subcategory").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertSubcategory(Subcategory sub) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(sub);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Subcategory getSubcategoryById(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			Subcategory subcategory= session.get(Subcategory.class, id);
			return subcategory;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean updateSubcategory(Subcategory sub) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(sub);
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
	public boolean deleteSubcategory(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getSubcategoryById(id));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Subcategory> getSubcategoriesByName(String subcategory) {
		Session session = sessionFactory.openSession();
		try {
			if(subcategory==null || subcategory.length()==0) {
				subcategory = "%";
			}else
				subcategory = "%"+ subcategory+"%";
			
			List list = session.createQuery("from Subcategory where subcategory like :subcategory").setParameter("subcategory", subcategory).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
