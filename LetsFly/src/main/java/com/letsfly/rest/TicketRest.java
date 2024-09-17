package com.letsfly.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.dto.TicketDto;
import com.letsfly.model.Ticket;
import com.letsfly.utils.restUtils.BaseRest;

@RestController
@RequestMapping("ticket")
public class TicketRest extends BaseRest<Ticket,Integer,TicketDto>{

    public TicketRest(JpaRepository<Ticket, Integer> rep) {
        super(rep);
        //TODO Auto-generated constructor stub
    }


}