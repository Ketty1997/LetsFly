package com.letsfly.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.letsfly.dto.FlightDto;
import com.letsfly.model.Flight;
import com.letsfly.model.Route;

public class FlightGenerator {


    private LocalDate fromDate,toDate;
    private List<LocalDate> days = new ArrayList<>();
    private List<Flight> generated = new ArrayList<>();


    public void generateFlights(List<Route> lR){
        Long nD = ChronoUnit.DAYS.between(fromDate, toDate)+1;
        for (Long i = 0L; i < nD; i++) {
            days.add(fromDate.plusDays(i));
        }
        for (LocalDate day : days) {
            String dayString = day.getDayOfWeek().name();
            for (Route route : lR) {
                if (route.getAvailability().contains(dayString)){
                    Flight nF = new Flight();
                    nF.setRoute(route);
                    nF.setDateDeparture(LocalDateTime.of(day,route.getDepartureTime()));
                    nF.setDateArrival(LocalDateTime.of(day, route.getArrivalTime()));
                    if (nF.getDateArrival().isBefore(nF.getDateDeparture()))
                        nF.setDateArrival(nF.getDateArrival().plusDays(1L));
                    generated.add(nF);
                }
            }
        }
    }
    
    
    public List<FlightDto> getGenerated() {
        List<FlightDto> x = new ArrayList<>();
        for (Flight f : generated) {
            x.add(f.toDto());
        }
        return x;
    }


    public LocalDate getFromDate() {
        return fromDate;
    }


    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }


    public LocalDate getToDate() {
        return toDate;
    }


    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }


}
