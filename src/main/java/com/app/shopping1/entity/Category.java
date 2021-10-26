package com.app.shopping1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;
	
	@Column(name = "image")
	private String image;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;

//	@ManyToOne
//	@JoinColumn(name = "admin_id")
//	@JsonIgnore
//	private Admin admin;

	Category() {

	}

	public Category(String name, String description, String image, Admin admin) {
		super();
		this.name = name;
		this.description = description;
		//this.admin = admin;
		this.image = image;
	}

	public Category(String name, String description, String image, List<Product> products, Admin admin) {
		super();
		this.name = name;
		this.description = description;
		this.products = products;
		//this.admin = admin;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String category_name) {
		this.name = category_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category_name=" + name +  ", image=" + image + 
				", description=" + description + ", products="
				+ products + "]";
	}
}
