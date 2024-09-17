package com.letsfly.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.letsfly.model.Flight;
import com.letsfly.model.Route;

public interface FlightRepo extends JpaRepository<Flight, Integer> {

        @Query("SELECT CASE WHEN COUNT(f) > 0 THEN TRUE ELSE FALSE END FROM Flight f WHERE f.dateDeparture = :dateDeparture AND f.dateArrival = :dateArrival AND f.route = :route") // Indovina chi ha scritto questa query
        boolean checkIfExist(@Param("dateDeparture") LocalDateTime dateDeparture,
                        @Param("dateArrival") LocalDateTime dateArrival,
                        @Param("route") Route route);

        @Query("SELECT f FROM Flight f WHERE f.dateDeparture BETWEEN :startDate AND :endDate AND f.route IN :routes")// la stessa "mente" che ha scritto questa
        List<Flight> findFlightsByDateRangeAndRoute(
                        @Param("startDate") LocalDateTime startDate,
                        @Param("endDate") LocalDateTime endDate,
                        @Param("routes") List<Route> routes);
        @Query("SELECT f FROM Flight f WHERE f.dateDeparture BETWEEN :startDate AND :endDate")// la stessa "mente" che ha scritto questa
        List<Flight> findFlightsByDateRange(
                        @Param("startDate") LocalDateTime startDate,
                        @Param("endDate") LocalDateTime endDate);
}
