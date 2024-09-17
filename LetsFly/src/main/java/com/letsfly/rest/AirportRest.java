package com.letsfly.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.dto.AirportDto;
import com.letsfly.model.Airport;
import com.letsfly.utils.restUtils.BaseRest;

@RestController
@RequestMapping("airport")
public class AirportRest extends BaseRest<Airport,Integer,AirportDto>{

    public AirportRest(JpaRepository<Airport, Integer> rep) {
        super(rep);
        //TODO Auto-generated constructor stub
    }


}
