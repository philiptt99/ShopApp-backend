package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "add_to_cart")
public class AddtoCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="addcart_id")
	long addCartId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name= "proId")
	Products product;
	
	@Column(name= "qty")
	int qty;
	
	@Column(name= "price")
	double price;
	
	@Column(name= "added_date")
	String added_date;
	
	
	@Column(name= "user_id")
	long userId;
	
	public AddtoCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AddtoCart(long addCartId, Products product, int qty, double price, String added_date, long userId) {
		super();
		this.addCartId = addCartId;
		this.product = product;
		this.qty = qty;
		this.price = price;
		this.added_date = added_date;
		this.userId = userId;
	}


	public long getAddCartId() {
		return addCartId;
	}


	public void setAddCartId(long addCartId) {
		this.addCartId = addCartId;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAdded_date() {
		return added_date;
	}
	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}
	
	

}
