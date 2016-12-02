package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.UserInfo;

@Repository (value= "categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {

	
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean get(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}
	 @Transactional
	   
	public boolean saveOrUpdate(Category category) {
		 Session s=sessionFactory.getCurrentSession();
		 Transaction t=s.beginTransaction();
		 s.saveOrUpdate(category);
		 t.commit();
		 return true;
	}

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		
		super();
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}
}
