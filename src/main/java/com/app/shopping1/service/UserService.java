package com.app.shopping1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.shopping1.entity.User;
import com.app.shopping1.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}
	
	public User fetchUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User fetchUserByEmailAndPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}
}
