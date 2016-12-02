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
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Product;


@Repository(value= "productDAO")
/*@EnableTransactionManagement*/
public class ProductDAOImpl implements ProductDAO
{

	@Autowired
	SessionFactory sessionfactory;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	
	public ProductDAOImpl(SessionFactory sessionfactory)
	{
		super();
		this.sessionfactory= sessionfactory;
		
	}
	 @Transactional
		
     public boolean saveOrUpdate(Product product) {
		Session s=sessionfactory.getCurrentSession();
		 Transaction t=s.beginTransaction();
		 s.saveOrUpdate(product);
		 t.commit();
		 return true;	
		 }
     public ProductDAOImpl() {
 		super();
 		// TODO Auto-generated constructor stub
 	}
   

@Transactional
	public boolean delete1(Product product) {
	
	try {
		Session s=sessionfactory.getCurrentSession();  
		 Transaction t=s.beginTransaction();
		/* sessionfactory.getCurrentSession().delete(product);*/
			
		 s.delete(product);
		t.commit();
		System.out.println("del impl method");
			
			return true;
	} catch (HibernateException e) {
		
		e.printStackTrace();
		return false;
	}
	}


    /*@Transactional*/
	public List<Product> list() {
		System.out.println("list method");
		Session s=sessionfactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		//createCriteria is a depricated method(it helps in getting products list based on criteria)
		
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Product> list=s.createCriteria(Product.class).list();
		tx.commit();
		return list;
		}
	
     /*@Transactional*/
      public Product get(int id) {
		
		String hql="from Product where prod_id=" +id;
		Session s=sessionfactory.getCurrentSession();
		 Transaction t=s.beginTransaction();
     	 Query query=s.createQuery(hql);
		System.out.println("product get meth in impl");
		/*Query query=sessionfactory.getCurrentSession().createQuery(hql);*/
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Product> list=query.list();
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
		}
	
}
