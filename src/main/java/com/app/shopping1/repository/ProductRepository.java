package com.app.shopping1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.shopping1.dto.ProductDTO;
import com.app.shopping1.entity.Category;
import com.app.shopping1.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Product findByName(String product_name);
	//List<Product> findByOrders(long order_id);
	List<Product> findByCategory(Category category);
	
	@Query(
			value = "SELECT * FROM Product p where LOWER(p.description) like Lower(CONCAT('%',:text,'%'))" +
					"or LOWER(p.name) like Lower(CONCAT('%',:text,'%'))", 
			nativeQuery = true)
	List<Product> search(@Param("text")String text);
	
	@Query(
			value = "SELECT * FROM shopping1.product ORDER BY RAND () LIMIT 6 ",
			nativeQuery = true)
	List<Product> getRandomProducts();

}
