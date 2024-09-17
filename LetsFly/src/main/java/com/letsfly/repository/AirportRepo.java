package com.letsfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsfly.model.Airport;

public interface AirportRepo extends JpaRepository<Airport, Integer> {

}
