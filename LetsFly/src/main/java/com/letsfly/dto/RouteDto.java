package com.letsfly.dto;

import java.time.LocalTime;
import java.util.Set;

import com.letsfly.model.Airplane;
import com.letsfly.model.Airport;
import com.letsfly.model.Route;
import com.letsfly.utils.restUtils.DtoInterface;

public class RouteDto implements DtoInterface<Route>{
	private int id, airportDeparture, airportArrival,airplane;

	private Set<String> availability;

	private LocalTime duration,departureTime,arrivalTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAirportDeparture() {
		return airportDeparture;
	}

	public void setAirportDeparture(int airportDeparture) {
		this.airportDeparture = airportDeparture;
	}

	public int getAirportArrival() {
		return airportArrival;
	}

	public void setAirportArrival(int airportArrival) {
		this.airportArrival = airportArrival;
	}

	public int getAirplane() {
		return airplane;
	}

	public void setAirplane(int airplane) {
		this.airplane = airplane;
	}

	public Set<String> getAvailability() {
		return availability;
	}

	public void setAvailability(Set<String> availability) {
		this.availability = availability;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	@Override
	public Route toEntity() {
		Route r = new Route();
		r.setId(id);
		r.setDuration(duration);
		r.setDepartureTime(departureTime);
		r.setAvailability(availability);
		Airport aA = new Airport();
		aA.setId(airportArrival);
		r.setAirportArrival(aA);
		Airport aD = new Airport();
		aD.setId(airportDeparture);
		r.setAirportDeparture(aD);
		Airplane a = new Airplane();
		a.setId(airplane);
		r.setAirplane(a);
		return r;
	}


}