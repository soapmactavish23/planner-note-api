package com.hkprogrammer.api.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hkprogrammer.api.domain.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Boolean existsUserByEmail(String email);
	
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
	Page<User> findByEmailContainingIgnoreCase(String email, Pageable pageable);
	
}
