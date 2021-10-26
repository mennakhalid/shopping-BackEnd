package com.app.shopping1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.shopping1.entity.CartItem;
import com.app.shopping1.entity.User;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	public List<CartItem> findByUser(User user);
	public CartItem findById(long id);
	//public void update(long l,CartItem newCartItem);
	
	@Query(
			value = "SELECT * FROM CartItem c where c.user_id = :user_id and c.product_id = :product_id", 
			nativeQuery = true)
	CartItem findCartItemByUserAndProduct(@Param("user_id") int user_id, @Param("product_id") int product_id);
	
}
