package com.app.shopping1.dto;

import com.app.shopping1.entity.User;

public class CartItemDTO {
	
	private long id;
	private int quantity;
	private ProductDTO product;
	private User user;
	
	public CartItemDTO() {
	}

	public CartItemDTO(int quantity, ProductDTO product, User user) {
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

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
