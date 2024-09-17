package com.letsfly.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.letsfly.dto.FlightDto;
import com.letsfly.utils.restUtils.EntityInterface;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Flight implements Serializable,EntityInterface<FlightDto> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "flight",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Ticket> tickets;
    @ManyToOne
    @JoinColumn(name = "route")
    private Route route;

    private LocalDateTime dateDeparture;

    private LocalDateTime dateArrival;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Route getRoute() {
        return route;
    }
    public void setRoute(Route route) {
        this.route = route;
    }
    public LocalDateTime getDateDeparture() {
        return dateDeparture;
    }
    public void setDateDeparture(LocalDateTime dateDeparture) {
        this.dateDeparture = dateDeparture;
    }
    public LocalDateTime getDateArrival() {
        return dateArrival;
    }
    public void setDateArrival(LocalDateTime dateArrival) {
        this.dateArrival = dateArrival;
    }
    public int getAvailableTickets(){
        return this.route.getAirplane().getCapacity()-tickets.size();
    }
    @Override
    public FlightDto toDto() {
        FlightDto f = new FlightDto();
        f.setId(id);
        f.setRoute(route.getId());
        f.setDateTimeDeparture(dateDeparture);
        f.setDateTimeArrival(dateArrival);
        return f;
    }

}
