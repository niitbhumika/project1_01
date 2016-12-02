package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.giftsgallery.model.Supplier;



@Repository (value= "supplierDAO")
@EnableTransactionManagement
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	

	public boolean saveOrUpdate(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean get(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Supplier> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
