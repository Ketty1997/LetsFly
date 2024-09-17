package com.letsfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsfly.model.Airplane;

public interface AirplaneRepo extends JpaRepository<Airplane, Integer> {
	
}
