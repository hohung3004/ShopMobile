package com.mkyong.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.web.dao.ProductsDAO;
import com.mkyong.web.entities.Products;

@Repository
public class ProductsDAOImpl implements ProductsDAO{
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public List<Products> getProducts() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Products").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public List<Products> getProducts(Integer offset, Integer maxResult) {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Products").setFirstResult(offset).setMaxResults(maxResult).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public Long getTotalProducts() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("select count (*) from Products").list();
			return (Long) list.get(0);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0L;
	}
	
	
	@Override
	public boolean insertProducts(Products pro) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(pro);
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

	@Override
	public Products getProductsById(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			Products products= session.get(Products.class, id);
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean updateProducts(Products pro) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(pro);
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
	
	@Override
	public boolean deleteProducts(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getProductsById(id));
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
	@Override
	public List<Products> getProductsByName(String productName) {
		Session session = sessionFactory.openSession();
		try {
			if(productName==null || productName.length()==0) {
				productName = "%";
			}else
				productName = "%"+ productName+"%";
			
			List list = session.createQuery("from Products where productName like :productName").setParameter("productName", productName).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Products> menu(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("select * from products where category=1 and subCategory=1").list();
			System.out.println("============================id: "+ id);
		}   catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	
}
