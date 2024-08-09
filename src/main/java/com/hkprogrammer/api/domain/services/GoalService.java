package com.hkprogrammer.api.domain.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hkprogrammer.api.domain.models.Goal;
import com.hkprogrammer.api.domain.repositories.GoalRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GoalService {

	private final GoalRepository repository;
	
	public List<Goal> findAll() {
		return repository.findAll();
	}
	
	public Goal findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	@Transactional
	public Goal create(Goal obj) {
		return repository.save(obj);
	}
	
	@Transactional
	public Goal update(Goal obj) {
		Goal objSaved = findById(obj.getId());
		
		BeanUtils.copyProperties(obj, objSaved, "id");
		
		return repository.save(objSaved);
	}
	
	@Transactional
	public void changeStatus(Integer id) {
		Goal obj = findById(id);
		obj.changeStatus();
	}
	
	@Transactional
	public void delete(Integer id) {
		Goal obj = findById(id);
		repository.deleteById(obj.getId());
	}
	
}
