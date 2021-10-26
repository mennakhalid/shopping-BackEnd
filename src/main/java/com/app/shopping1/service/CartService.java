package com.app.shopping1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.shopping1.dto.CartItemDTO;
import com.app.shopping1.dto.ProductDTO;
import com.app.shopping1.entity.CartItem;
import com.app.shopping1.entity.User;
import com.app.shopping1.repository.CartItemRepository;

@Service
public class CartService {

	@Autowired
	private CartItemRepository cartRepo;
	
	public List<CartItemDTO> listCartItem(User user){
		return cartRepo.findByUser(user)
				.stream()
				.map(this::getCartItem)
				.collect(Collectors.toList());
	}
	
	public void save(CartItem cartItem){
		cartRepo.save(cartItem);
	}
	
	public void edit(CartItem cartItem){
		cartRepo.save(cartItem);
	}
	
	public void delete(CartItem cartItem){
		cartRepo.delete(cartItem);
	}
	
	public CartItem getById(long cartId){
		return cartRepo.findById(cartId);
	}
	
	public CartItem FetchCartItemByUserAndProduct(int user_id, int product_id) {
		return cartRepo.findCartItemByUserAndProduct(user_id, product_id);
	}
	
	private CartItemDTO getCartItem(CartItem cartItem) {
		CartItemDTO cartItemDTO = new CartItemDTO();
		cartItemDTO.setId(cartItem.getId());
		cartItemDTO.setQuantity(cartItem.getQuantity());
		ModelMapper modelMapper = new ModelMapper();
		ProductDTO productDTO = modelMapper.map(cartItem.getProduct(), ProductDTO.class);
		cartItemDTO.setProduct(productDTO);
		cartItemDTO.setUser(cartItem.getUser());
		
		return cartItemDTO;
		
	}
	
}
