package com.letsfly.form;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.letsfly.model.*;

public class FormAirportView {
	private String country, city;

	private List<String> weekDays = Arrays.asList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY");

	public class RouteView {
		private String airportDeparture, airportArrival;

		private LocalTime departureTime, arrivalTime;

		private Set<String> availability;

		public RouteView(Route route) {
			airportDeparture = route.getAirportDeparture().getCity();
			airportArrival = route.getAirportArrival().getCity();
			departureTime = route.getDepartureTime();
			arrivalTime = route.getArrivalTime();
			availability = route.getAvailability();
		}

		public String getAirportDeparture() {
			return airportDeparture;
		}

		public void setAirportDeparture(String airportDeparture) {
			this.airportDeparture = airportDeparture;
		}

		public String getAirportArrival() {
			return airportArrival;
		}

		public void setAirportArrival(String airportArrival) {
			this.airportArrival = airportArrival;
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

		public Set<String> getAvailability() {
			return availability;
		}

		public void setAvailability(Set<String> availability) {
			this.availability = availability;
		}

		public boolean isAvailable(String day) {
			return availability.contains(day);
		}
	}

	private List<RouteView> listRouteArrival = new ArrayList<>();

	private List<RouteView> listRouteDeparture = new ArrayList<>();

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<RouteView> getListRouteArrival() {
		return listRouteArrival;
	}

	public void setListRouteArrival(List<RouteView> listRouteArrival) {
		this.listRouteArrival = listRouteArrival;
	}

	public List<RouteView> getListRouteDeparture() {
		return listRouteDeparture;
	}

	public void setListRouteDeparture(List<RouteView> listRouteDeparture) {
		this.listRouteDeparture = listRouteDeparture;
	}

	public FormAirportView(Airport airport) {
		country = airport.getCountry();

		city = airport.getCity();

		for (Route route : airport.getListRouteArrival()) {
			listRouteArrival.add(new RouteView(route));
		}

		for (Route route : airport.getListRouteDeparture()) {
			listRouteDeparture.add(new RouteView(route));
		}
	}

	public List<String> getWeekDays() {
		return weekDays;
	}
}