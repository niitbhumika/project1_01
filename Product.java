package com.niit.shoppingcart.giftsgallery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table (name="product")
@Component
public class Product
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prod_id;
	private String prod_name;
	/*@Min(1)*/
	private int prod_price;
	/*@Min(1)*/
	private int quantity;
	@Transient
	private MultipartFile image;
	
	/*@ManyToOne
	@JoinColumn(name = "cat_Id", insertable= false, updatable = false)
	
	private Category category;
	private int cat_Id;
	
	@ManyToOne
	@JoinColumn(name = "sup_Id", insertable = false, updatable = false)
	
	private Supplier supplier;
	
	private int sup_Id;*/
	
	
	/*public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getCat_Id() {
		return cat_Id;
	}
	public void setCat_Id(int cat_Id) {
		this.cat_Id = cat_Id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public int getSup_Id() {
		return sup_Id;
	}
	public void setSup_Id(int sup_Id) {
		this.sup_Id = sup_Id;
	}*/
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
