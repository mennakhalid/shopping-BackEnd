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
@Table(name="cartitem")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="quantity")
	private int quantity;
	
//	@Column(name="order_id")
//	private int order_id;
//	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//			cascade= {CascadeType.DETACH, CascadeType.MERGE,
//					CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinTable(
//			name="order_cartitems",
//			joinColumns = @JoinColumn(name="product_id"),
//			inverseJoinColumns = @JoinColumn(name="order_id"))
//	private List<Order> orders;
	
	public CartItem(){
		
	}

	public CartItem(int quantity, User user) {
		super();
		this.quantity = quantity;
		this.user = user;
	}

	public CartItem(int quantity, Product product, User user) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", quantity=" + quantity + ", product=" + product + ", user=" + user + "]";
	}
	
	
}
