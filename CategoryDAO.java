package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.giftsgallery.model.Category;

@Repository
public interface CategoryDAO
{
	
	public boolean saveOrUpdate(Category category);
	public boolean delete(Category category);
	public boolean get(int id);
	public List<Category> list();	
	
	
}
