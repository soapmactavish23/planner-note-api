package com.hkprogrammer.api.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hkprogrammer.api.domain.models.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

	List<Activity> findByUserId(Integer userId);
	
}
