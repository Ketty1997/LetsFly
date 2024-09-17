package com.letsfly.rest;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.dto.RouteDto;
import com.letsfly.dto.UserDto;
import com.letsfly.model.Route;
import com.letsfly.utils.FlightGenerator;
import com.letsfly.utils.restUtils.BaseRest;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("route")
public class RouteRest extends BaseRest<Route, Integer, RouteDto> {
    public RouteRest(JpaRepository<Route, Integer> rep) {
        super(rep);
        // TODO Auto-generated constructor stub
    }

    @PostMapping("genflight")
    public FlightGenerator genFlight(@RequestBody FlightGenerator fG,HttpSession session) {
    UserDto uD = (UserDto) session.getAttribute("userForm");
    if (uD == null){
      FlightGenerator listDtoClass = null;
      return listDtoClass;
    }
    if (uD.getIsadmin() > 0) {
        fG.generateFlights(rep.findAll());
        return fG;} else {
            FlightGenerator listDtoClass = null;
            return listDtoClass;}
          }
}
