package com.app.shopping1.dto;

public class ProductDTO {

	private long id;
	private String name;
	private Integer price;
	private Integer quantity;
	private String description;
	private String image;
	private CategoryDto category;
	
	public ProductDTO(){
		
	}

	public ProductDTO(String name, Integer price, Integer quantity, String description) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
