package com.letsfly.rest;
import com.letsfly.model.Airplane;
import com.letsfly.utils.restUtils.BaseRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.dto.AirplaneDto;

@RestController
@RequestMapping("airplane")
public class AirplaneRest extends BaseRest<Airplane,Integer,AirplaneDto>{

    public AirplaneRest(JpaRepository<Airplane, Integer> rep) {
        super(rep);
        //TODO Auto-generated constructor stub
    }


}