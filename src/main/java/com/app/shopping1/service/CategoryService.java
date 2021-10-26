package com.app.shopping1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.shopping1.dto.CategoryDto;
import com.app.shopping1.entity.Category;
import com.app.shopping1.repository.CategoryRepository;



@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	
	public Category save(Category category) {
		return categoryRepo.save(category);
	}
	
	public void edit(Category newCategory) {
	
		categoryRepo.save(newCategory);
	}
	
	public void delete(String category_name) {
		
		categoryRepo.delete(categoryRepo.findByName(category_name));
	}
	
	public Category FetchCategoryByName(String category_name) {
		return categoryRepo.findByName(category_name);
	}
	
	public List<CategoryDto> findAll(){
		
		return categoryRepo.findAll()
				.stream()
				.map(this::getAllCategories)
				.collect(Collectors.toList());
	}
	
	private CategoryDto getAllCategories(Category category) {
		
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		categoryDto.setDescription(category.getDescription());
		categoryDto.setImage(category.getImage());
		return categoryDto;
		
	}
		
}

