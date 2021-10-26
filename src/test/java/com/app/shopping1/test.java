package com.app.shopping1;

import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.app.shopping1.entity.CartItem;
import com.app.shopping1.entity.Product;
import com.app.shopping1.entity.User;
import com.app.shopping1.repository.CartItemRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class test {
	
	@Autowired
	private CartItemRepository cartRepo;
	
	@Autowired
	private TestEntityManager entityManger;
	
	@Test
	@Transactional
	void testDatabase() {
		Product product = entityManger.find(Product.class, 2);
		User user = entityManger.find(User.class, 1);
		
		CartItem newItem = new CartItem();
		newItem.setUser(user);
		newItem.setProduct(product);
		newItem.setQuantity(1);
		
		CartItem savedCartItem = cartRepo.save(newItem);
		
		assertTrue(savedCartItem.getId() > 0);
	}

}
