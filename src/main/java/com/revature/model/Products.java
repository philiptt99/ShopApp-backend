package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long product_id;
	
	@Column(name= "product_name", unique=true, nullable=false)
	String name;
	
	@Column(name= "price")
	String price;
	
	@Column(name= "author")
	String author;
	
	@Column(name= "category_id")
	String categoryId;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Products(long product_id, String name, String price, String author, String categoryId) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.categoryId = categoryId;
	}

	


	public long getProduct_id() {
		return product_id;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	
	
	

}
