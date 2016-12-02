package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.UserInfo;


@Repository (value= "userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean isValidate(String id, String password)
	{
		if(id.equals("bhu@gmail.com")&&password.equals("bhu"))
			
		{
		  // b=true;
		return true;
		}
		else
		{
		return false;
	    }
	}

	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDAOImpl(SessionFactory sessionfactory)
	{
		super();
		this.sessionFactory= sessionfactory;
	}
	
	/*public boolean saveOrUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean get(int id) {
		// TODO Auto-generated method stub
		return false;
	}*/

	public List<UserInfo> list() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public boolean delete(UserInfo user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean get(int id) {
		// TODO Auto-generated method stub
		return false;
	}
     @Transactional
    public boolean saveOrUpdate(UserInfo user) {
    	 
    		 Session s=sessionFactory.getCurrentSession();
    		 Transaction t=s.beginTransaction();
    		 s.saveOrUpdate(user);
    		 t.commit();
    		 return true;
     
    	  //sessionFactory.getCurrentSession().saveOrUpdate(user);
    	 //return true;
    	 
		// TODO Auto-generated method stub
	     
    	 
    	 
     }     
}
	
	
