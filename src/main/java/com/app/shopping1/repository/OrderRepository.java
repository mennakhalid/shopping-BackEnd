package com.app.shopping1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.shopping1.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
//
//	@Query(
//			value = "INSERT INTO Order (order_date, payment_type, user_id, product_id, quantity, price) "
//					+ "VALUES ();", 
//			nativeQuery = true)
//	public void saveOrder(Order order);
	
}
