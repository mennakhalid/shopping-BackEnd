package com.app.shopping1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "price", nullable = false)
	private Integer price;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "image")
	private String image;
	
	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "category_id")
	
	private Category category;

	public Product() {

	}

	public Product(String name, Integer uIntegerPrice, Integer quantity, String description, Category category,
			Admin admin) {
		super();
		this.name = name;
		this.price = uIntegerPrice;
		this.quantity = quantity;
		this.description = description;
		this.category = category;
//		this.admin = admin;
	}

	public Product(String name, Integer uIntegerPrice, Integer quantity, String description, Admin admin) {
		super();
		this.name = name;
		this.price = uIntegerPrice;
		this.quantity = quantity;
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer uIntegerPrice) {
		this.price = uIntegerPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", description="
				+ description + ", category=" + category + "]";
	}

}
