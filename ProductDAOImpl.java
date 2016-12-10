package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Product;

@Repository(value = "productDAO")
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Autowired
	Product product;

	public ProductDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;

	}

	
@Transactional
	public boolean saveOrUpdate(Product product) {

		try {
			sessionfactory.getCurrentSession().saveOrUpdate(product);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

@Transactional
	public boolean delete1(Product product) {

		try {
			sessionfactory.getCurrentSession().delete(product);
			System.out.println("del impl method");

			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

@Transactional
	public List<Product> list() {
	/*	System.out.println("list method");
		Session s = sessionfactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		List<Product> list = s.createCriteria(Product.class).list();
		System.out.println("list ttt product");
		return list;*/
	String hql = "from Product";
	Query query = sessionfactory.getCurrentSession().createQuery(hql);
	return query.list();

	}


@Transactional
	public Product get(int id) {

		/*String hql = "from Product where prod_id=" + id;
		Session s = sessionfactory.getCurrentSession();
		Transaction t = s.beginTransaction();
		Query query = s.createQuery(hql);
		System.out.println("product get meth in impl");
		List<Product> list = query.list();
		if (list == null) {
			return null;
		} else {
			System.out.println("geeeet product");
			return list.get(0);
		}*/
	
	
	
	String hql = "from Product where prod_id=" + "'" + id + "'";
	Query query = sessionfactory.getCurrentSession().createQuery(hql);
	List<Product> list = query.list();
	if (list == null)

		return null;
	else {
		return list.get(0);
	}}
	

}
