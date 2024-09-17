package com.letsfly.form;

import java.time.LocalDateTime;

import com.letsfly.model.Flight;

public class FormFlightView {
    private int id;
    private LocalDateTime timeDeparture,timeArrival;
    private String airportDeparture,airportArrival;
    public FormFlightView(Flight f){
        this.airportArrival=f.getRoute().getAirportArrival().getCity();
        this.airportDeparture=f.getRoute().getAirportDeparture().getCity();
        this.timeArrival=f.getDateArrival();
        this.timeDeparture=f.getDateDeparture();
        this.id=f.getId();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getTimeDeparture() {
        return timeDeparture;
    }
    public void setTimeDeparture(LocalDateTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }
    public LocalDateTime getTimeArrival() {
        return timeArrival;
    }
    public void setTimeArrival(LocalDateTime timeArrival) {
        this.timeArrival = timeArrival;
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
    
}
