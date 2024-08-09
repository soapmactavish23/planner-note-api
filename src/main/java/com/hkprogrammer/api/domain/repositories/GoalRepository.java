package com.hkprogrammer.api.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hkprogrammer.api.domain.models.Goal;

public interface GoalRepository extends JpaRepository<Goal, Integer> {

	List<Goal> findByUserIdAndStatus(Integer userId, Boolean status);

}
