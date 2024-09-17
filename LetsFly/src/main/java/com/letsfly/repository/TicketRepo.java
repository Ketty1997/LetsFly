package com.letsfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.letsfly.model.Ticket;
import com.letsfly.model.User;



public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    @Query("SELECT t FROM Ticket t WHERE t.user = :userid")// la stessa "mente" che ha scritto questa
        List<Ticket> findUserTickets(
                        @Param("userid") User userid);

}
