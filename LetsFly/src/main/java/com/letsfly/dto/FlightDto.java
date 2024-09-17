package com.letsfly.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.letsfly.model.Flight;
import com.letsfly.model.Route;
import com.letsfly.utils.restUtils.DtoInterface;

public class FlightDto implements DtoInterface<Flight>{
	private int id, route;
	

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateDeparture;
	private LocalTime timeDeparture;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateArrival;
	private LocalTime timeArrival;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoute() {
		return route;
	}
	public void setRoute(int route) {
		this.route = route;
	}
	public LocalDate getDateDeparture() {
		return dateDeparture;
	}
	public void setDateDeparture(LocalDate dateDeparture) {
		this.dateDeparture = dateDeparture;
	}
	public LocalDate getDateArrival() {
		return dateArrival;
	}
	public void setDateArrival(LocalDate dateArrival) {
		this.dateArrival = dateArrival;
	}
	public LocalDateTime getDateTimeArrival(){
		return LocalDateTime.of(dateArrival, timeArrival);
	}
	public LocalDateTime getDateTimeDeparture(){
		return LocalDateTime.of(dateDeparture, timeDeparture);
	}
	public LocalTime getTimeDeparture() {
		return timeDeparture;
	}
	public void setTimeDeparture(LocalTime timeDeparture) {
		this.timeDeparture = timeDeparture;
	}
	public LocalTime getTimeArrival() {
		return timeArrival;
	}
	public void setTimeArrival(LocalTime timeArrival) {
		this.timeArrival = timeArrival;
	}
	public void setDateTimeArrival(LocalDateTime arrival){
		this.dateArrival=arrival.toLocalDate();
		this.timeArrival=arrival.toLocalTime();
	}
	public void setDateTimeDeparture(LocalDateTime departure){
		this.dateDeparture=departure.toLocalDate();
		this.timeDeparture=departure.toLocalTime();
	}
	@Override
	public Flight toEntity() {
		Flight f = new Flight();
		f.setDateArrival(LocalDateTime.of(dateArrival, timeArrival));
		f.setDateDeparture(LocalDateTime.of(dateDeparture,timeDeparture));
		f.setId(id);
		Route r = new Route();
		r.setId(route);
		f.setRoute(r);
		return f;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + route;
		result = prime * result + ((dateDeparture == null) ? 0 : dateDeparture.hashCode());
		result = prime * result + ((dateArrival == null) ? 0 : dateArrival.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightDto other = (FlightDto) obj;
		if (id != other.id)
			return false;
		if (route != other.route)
			return false;
		if (dateDeparture == null) {
			if (other.dateDeparture != null)
				return false;
		} else if (!dateDeparture.equals(other.dateDeparture))
			return false;
		if (dateArrival == null) {
			if (other.dateArrival != null)
				return false;
		} else if (!dateArrival.equals(other.dateArrival))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FlightDto [id=" + id + ", route=" + route + ", dateDeparture=" + dateDeparture + ", dateArrival="
				+ dateArrival + "]";
	}
	
	
}