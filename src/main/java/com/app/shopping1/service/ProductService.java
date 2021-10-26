package com.app.shopping1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.shopping1.dto.CategoryDto;
import com.app.shopping1.dto.ProductDTO;
import com.app.shopping1.entity.Category;
import com.app.shopping1.entity.Product;
import com.app.shopping1.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	public void edit(Product newProduct) {
		
		productRepo.save(newProduct);
	}
	
	public void delete(String product_name) {
		productRepo.delete(productRepo.findByName(product_name));
	}
	
	public Product FetchProductByName(String product_name) {
		return productRepo.findByName(product_name);
	}
	
	public List<ProductDTO> selectRandomProducts(){
		return productRepo.getRandomProducts()
				.stream()
				.map(this:: getAllCategories)
				.collect(Collectors.toList());

	}
	
	public List<ProductDTO> FetchProductByCategory(Category category){
		return productRepo.findByCategory(category)
				.stream()
				.map(this::getProduct)
				.collect(Collectors.toList());
	}
	
	public List<ProductDTO> searchForProducts(String text){
		//List<ProductDTO> products = new ArrayList<ProductDTO>();
		return productRepo.search(text)
				.stream()
				.map(this::getProduct)
				.collect(Collectors.toList());
	}
	
	private ProductDTO getProduct(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setQuantity(product.getQuantity());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		return productDTO;	
	}
	
	public long countProducts() {
		return productRepo.count();
	}
	
	public List<ProductDTO> getAllProducts(){
		return productRepo.findAll()
				.stream()
				.map(this:: getAllCategories)
				.collect(Collectors.toList());
	}
	
	private ProductDTO getAllCategories(Product product) {
			
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setPrice(product.getPrice());
			productDTO.setQuantity(product.getQuantity());
			productDTO.setImage(product.getImage());
			ModelMapper modelMapper = new ModelMapper();
			CategoryDto categoryDto = modelMapper.map(product.getCategory(), CategoryDto.class);
			productDTO.setCategory(categoryDto);
			return productDTO;	
		}
	

}
