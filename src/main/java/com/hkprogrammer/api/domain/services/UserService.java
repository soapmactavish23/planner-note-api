package com.hkprogrammer.api.domain.services;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hkprogrammer.api.domain.models.User;
import com.hkprogrammer.api.domain.repositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository repository;

	public Page<User> search(String name, String email, Pageable pageable) {
		if(name.isBlank()) {
			return repository.findByEmailContainingIgnoreCase(email, pageable);
		} else {
			return repository.findByNameContainingIgnoreCase(name, pageable);
		}
	}
	
	public User findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	@Transactional
	public User create(User obj) {
		return repository.save(obj);
	}
	
	@Transactional
	public User update(User obj) {
		User objSaved = findById(obj.getId());
		
		BeanUtils.copyProperties(obj, objSaved, "id");
		
		return repository.save(objSaved);
	}
	
	@Transactional
	public void changeStatus(Integer id) {
		User obj = findById(id);
		obj.changeStatus();
	}
	
	@Transactional
	public void delete(Integer id) {
		User obj = findById(id);
		repository.deleteById(obj.getId());
	}
	
}
