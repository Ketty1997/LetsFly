package com.letsfly.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.dto.FlightDto;
import com.letsfly.dto.UserDto;
import com.letsfly.model.Flight;
import com.letsfly.model.Route;
import com.letsfly.repository.FlightRepo;
import com.letsfly.utils.FlightGenerator;
import com.letsfly.utils.restUtils.BaseRest;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("flight")
public class FlightRest extends BaseRest<Flight, Integer, FlightDto> {
    @Autowired
    FlightRepo repoF; //Il boomerang-lama di BaseRest in tutto il suo splendore!
    public FlightRest(JpaRepository<Flight, Integer> rep) {
        super(rep);
        // TODO Auto-generated constructor stub
    }

    @PostMapping("list")
    public String insertList(@RequestBody FlightGenerator fG,HttpSession session) {
    UserDto uD = (UserDto) session.getAttribute("userForm");
    if (uD == null){
    return "NOT AUTHORIZED!";
    }
    if (uD.getIsadmin() > 0) {
        int i=0;
        List<FlightDto> listDto = fG.getGenerated();
        List<Flight> listEntityClass = new ArrayList<>();
        Route r = new Route();
        for (FlightDto dto : listDto) {
            r.setId(dto.getRoute());
            if (!repoF.checkIfExist(dto.getDateTimeDeparture(),dto.getDateTimeArrival(),r)){
                listEntityClass.add(dto.toEntity());
            } else {
                i++;
            }
        }
        rep.saveAll(listEntityClass);
        return listEntityClass.size()+" flight inserted, "+i+" duplicate found";} else {
            return "NOT AUTHORIZED!";}
        
    }

}