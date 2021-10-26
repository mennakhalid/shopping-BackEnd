package com.app.shopping1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.shopping1.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findByEmail(String email);

	Admin findByEmailAndPassword(String email, String password);
	
}
