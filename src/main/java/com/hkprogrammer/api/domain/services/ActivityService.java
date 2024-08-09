package com.hkprogrammer.api.domain.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hkprogrammer.api.domain.models.Activity;
import com.hkprogrammer.api.domain.repositories.ActivityRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ActivityService {

	private final ActivityRepository repository;
	
	public List<Activity> findAll() {
		return repository.findAll();
	}
	
	public Activity findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	@Transactional
	public Activity create(Activity obj) {
		return repository.save(obj);
	}
	
	@Transactional
	public Activity update(Activity obj) {
		Activity objSaved = findById(obj.getId());
		
		BeanUtils.copyProperties(obj, objSaved, "id");
		
		return repository.save(objSaved);
	}
	
	@Transactional
	public void changeStatus(Integer id) {
		Activity obj = findById(id);
		obj.changeStatus();
	}
	
	@Transactional
	public void delete(Integer id) {
		Activity obj = findById(id);
		repository.deleteById(obj.getId());
	}
		
	
}
