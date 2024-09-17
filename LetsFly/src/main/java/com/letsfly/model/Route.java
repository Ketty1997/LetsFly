package com.letsfly.model;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

import com.letsfly.dto.RouteDto;
import com.letsfly.utils.SetConverter;
import com.letsfly.utils.TimeUtils;
import com.letsfly.utils.restUtils.EntityInterface;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Route implements Serializable,EntityInterface<RouteDto> {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="airport_departure")
    private Airport airportDeparture;

    @ManyToOne
    @JoinColumn(name="airport_arrival")
    private Airport airportArrival;

    @Convert(converter = SetConverter.class)
    private Set<String> availability;

    private LocalTime duration;

    private LocalTime departureTime;

    @ManyToOne
    @JoinColumn(name="airplane")
    private Airplane airplane;
        
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Airport getAirportDeparture() {
        return airportDeparture;
    }
    public void setAirportDeparture(Airport airportDeparture) {
        this.airportDeparture = airportDeparture;
    }
    public Airport getAirportArrival() {
        return airportArrival;
    }
    public void setAirportArrival(Airport airportArrival) {
        this.airportArrival = airportArrival;
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
    public Airplane getAirplane() {
        return airplane;
    }
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    public LocalTime getArrivalTime(){
        LocalTime arrival = TimeUtils.addLocalTime(duration, departureTime);
        return arrival;
    }
    @Override
    public RouteDto toDto() {
        RouteDto r = new RouteDto();
        r.setId(id);
        r.setAirplane(airplane.getId());
        r.setAirportArrival(airportArrival.getId());
        r.setAirportDeparture(airportDeparture.getId());
        r.setAvailability(availability);
        r.setDepartureTime(departureTime);
        r.setDuration(duration);
        r.setArrivalTime(getArrivalTime()); // Potrebbe causare problemi sta cafonata?
        return r;

    }

}
