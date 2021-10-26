package com.app.shopping1.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.app.shopping1.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Category findByName(String category_name);
	
	

}
