package com.app.shopping1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.shopping1.entity.Admin;
import com.app.shopping1.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	public Admin fetchUserByEmail(String email) {
		return adminRepo.findByEmail(email);
	}
	
	public Admin fetchUserByEmailAndPassword(String email, String password) {
		return adminRepo.findByEmailAndPassword(email, password);
	}
}
