package com.letsfly.form;

import java.time.LocalDateTime;

import com.letsfly.model.Ticket;
import com.letsfly.utils.restUtils.DtoInterface;

public class FormTicketView implements DtoInterface<FormTicketView> {

	private int id;

	private String userName, userSurname, airportDeparture, airportArrival;

	private LocalDateTime departureDate;

	private LocalDateTime arrivalDate;

	@Override
	public FormTicketView toEntity() {
		return null;
	}
	
	public FormTicketView(Ticket ticket) {

		id = ticket.getId();

		userName = ticket.getUser().getName();

		userSurname = ticket.getUser().getSurname();

		airportDeparture = ticket.getFlight().getRoute().getAirportDeparture().getCity();

		airportArrival = ticket.getFlight().getRoute().getAirportArrival().getCity();

		departureDate = ticket.getFlight().getDateDeparture();

		arrivalDate = ticket.getFlight().getDateArrival();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
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

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}