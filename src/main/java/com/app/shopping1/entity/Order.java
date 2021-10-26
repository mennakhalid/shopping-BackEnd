package com.app.shopping1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="orderr")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="order_date", nullable = false)
	private String order_date;
	
	@Column(name="shipped_date", nullable = false)
	private String shipped_date;
	
	@Column(name="payment_type", nullable = false)
	private String payment_type;
	
//	@OneToMany(fetch=FetchType.LAZY,
//			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//			 CascadeType.DETACH, CascadeType.REFRESH})
//	private List<CartItem> cartItems;

	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	

	public Order(){
		
	}


	public Order(String order_date, String shipped_date, String payment_type, User user) {
		super();
		this.order_date = order_date;
		this.shipped_date = shipped_date;
		this.payment_type = payment_type;
		//this.cartItems = cartItem;
		this.user = user;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getOrder_date() {
		return order_date;
	}


	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}


	public String getShipped_date() {
		return shipped_date;
	}


	public void setShipped_date(String shipped_date) {
		this.shipped_date = shipped_date;
	}


	public String getPayment_type() {
		return payment_type;
	}


	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}


//	public List<CartItem> getCartItem() {
//		return cartItems;
//	}
//
//
//	public void setCartItem(List<CartItem> cartItem) {
//		this.cartItems = cartItem;
//	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", order_date=" + order_date + ", shipped_date=" + shipped_date + ", payment_type="
				+ payment_type + ", user=" + user + "]";
	}




	
	
	
}
