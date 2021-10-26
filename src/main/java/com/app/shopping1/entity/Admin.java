package com.app.shopping1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "passwrd", nullable = false)
	private String password;

	Admin() {

	}

	public Admin(String admin_name, String password) {
		super();
		this.email = admin_name;
		this.password = password;
	}

	public Admin(String admin_name, String password, List<Category> categories) {
		super();
		this.email = admin_name;
		this.password = password;
		//this.categories = categories;
	}

	public Admin(String admin_name, String password, List<Category> categories, List<Product> products) {
		super();
		this.email = admin_name;
		this.password = password;
//		this.categories = categories;
//		this.products = products;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String admin_name) {
		this.email = admin_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", admin_email=" + email + ", password=" + password + "]";
	}

}
