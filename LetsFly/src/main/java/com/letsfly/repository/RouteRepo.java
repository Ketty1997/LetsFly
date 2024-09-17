package com.letsfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsfly.model.Airport;
import com.letsfly.model.Route;


public interface RouteRepo extends JpaRepository<Route, Integer> {
    public List<Route> findByAirportArrivalAndAirportDeparture(Airport airportArrival,Airport airportDeparture);
}
