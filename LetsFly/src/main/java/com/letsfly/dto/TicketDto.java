package com.letsfly.dto;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

import com.letsfly.model.Flight;
import com.letsfly.model.Ticket;
import com.letsfly.model.User;
import com.letsfly.utils.restUtils.DtoInterface;

public class TicketDto implements DtoInterface<Ticket>{
	private int id, flight, user;
	private LocalDate date;
	private LocalTime time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlight() {
		return flight;
	}

	public void setFlight(int flight) {
		this.flight = flight;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalDateTime getDateTime(){
		return LocalDateTime.of(date, time);
	}
	public void setDateTime(LocalDateTime dateTime){
		this.date=dateTime.toLocalDate();
		this.time=dateTime.toLocalTime();
	}
	
	
	@Override
	public Ticket toEntity() {
		Ticket t = new Ticket();
		t.setId(id);
		Flight f = new Flight();
		f.setId(flight);
		t.setFlight(f);
		User u = new User();
		u.setId(user);
		t.setUser(u);
		t.setDate(LocalDateTime.of(date, time));
		return t;
	}




}