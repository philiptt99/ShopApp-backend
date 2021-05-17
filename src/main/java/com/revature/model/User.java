package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="shop_user")
public class User {
	
	@Id
	@Column(name = "user_id")
	@SequenceGenerator(name="mysequence", initialValue=1000)
	@GeneratedValue( strategy = GenerationType.IDENTITY, generator="mysequence")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	long user_id;
	
	@Column(name= "user_name", unique=true, nullable=false)
	String name;
	
	@Column(name= "email")
	String email;
	
	@Column(name= "category")
	String category;
	
	@Column(name= "password")
	String password;
	
	@Column(name= "created_at")
	String created_at;
	
	@Column(name= "login_token")
	String login_token;
	
	@Column(name= "type")
	String type;
	
	@Column(name= "address")
	String address;
	
	@Column(name= "is_email_verified")
	String is_email_verified;
	
	@Column(name= "mobile")
	String mobile;

	public User() {
		
	}
	
	
	public long getUser_id() {
		return user_id;
	}


	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	public String getIs_email_verified() {
		return is_email_verified;
	}


	public void setIs_email_verified(String is_email_verified) {
		this.is_email_verified = is_email_verified;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getLogin_token() {
		return login_token;
	}

	public void setLogin_token(String login_token) {
		this.login_token = login_token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIs_email_veried() {
		return is_email_verified;
	}

	public void setIs_email_veried(String is_email_verified) {
		this.is_email_verified = is_email_verified;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", category=" + category
				+ ", password=" + password + ", created_at=" + created_at + ", login_token=" + login_token + ", type="
				+ type + ", address=" + address + ", is_email_verified=" + is_email_verified + ", mobile=" + mobile
				+ "]";
	}

	
	

}
