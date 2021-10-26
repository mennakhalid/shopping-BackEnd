package com.app.shopping1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.shopping1.entity.Order;
import com.app.shopping1.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order save(Order order) {
		return orderRepository.save(order);
	}
}
