package com.hkprogrammer.api.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hkprogrammer.api.domain.models.Prayer;

public interface PrayerRepository extends JpaRepository<Prayer, Integer> {

	List<Prayer> findByUserId(Integer userId);
	
}
