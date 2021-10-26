package com.app.shopping1.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="first_name", nullable = false)
	private String first_name;
	
	@Column(name="last_name", nullable = false)
	private String last_name;
	
	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="country", nullable = false)
	private String country;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone", nullable = false)
	private String phone;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="birthday", nullable = false)
	private Date birthday;
	
	public User() {
		
	}

	public User(String first_name, String last_name, String email, String country, String address, String phone,
			String password, Date birthday) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.country = country;
		this.address = address;
		this.phone = phone;
		this.password = password;
		this.birthday = birthday;
	}




	public Date getBirthday() {
		return birthday;
	}




	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}




	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", country=" + country + ", address=" + address + ", phone=" + phone + ", password=" + password + "]";
	}
	
	
}
