package com.letsfly.model;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.letsfly.dto.TicketDto;
import com.letsfly.utils.restUtils.EntityInterface;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket implements Serializable,EntityInterface<TicketDto> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name="flight")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Flight getFlight() {
        return flight;
    }
    
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    @Override
    public TicketDto toDto() {
        TicketDto t = new TicketDto();
        t.setId(id);
        t.setFlight(flight.getId());
        t.setUser(user.getId());
        t.setDateTime(date);
        return t;
    }
    
    

}
