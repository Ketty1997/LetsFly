package com.letsfly.ctr;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsfly.dto.AirportDto;
import com.letsfly.dto.UserDto;
import com.letsfly.form.FormChosenFlights;
import com.letsfly.form.FormFlightSearch;
import com.letsfly.form.FormFlightView;
import com.letsfly.form.FormLogin;
import com.letsfly.model.Airport;
import com.letsfly.model.Flight;
import com.letsfly.model.Ticket;
import com.letsfly.model.User;
import com.letsfly.repository.AirportRepo;
import com.letsfly.repository.FlightRepo;
import com.letsfly.repository.RouteRepo;
import com.letsfly.repository.TicketRepo;
import com.letsfly.utils.RouteFinder.RouteFinder;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;


import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("findFlight")
public class FlightSearchCtr {
    @Autowired
    AirportRepo repoA;
    @Autowired
    RouteRepo repoR;
    @Autowired
    FlightRepo repoF;
    @Autowired
    TicketRepo repoT;
    @Autowired
	private EntityDtoConverter<Airport,AirportDto> airportConverter;


    @GetMapping("")
    public String searchFlight(Model model,HttpSession session) {
        UserDto userDto = (UserDto)session.getAttribute("userForm");
        if(userDto==null){
            model.addAttribute("loginBoolean", true);
            model.addAttribute("userForm", new UserDto());
            model.addAttribute("loginDto", new FormLogin());
            return "login";}
        List<AirportDto> airportDtoList = airportConverter.entityToDto(repoA.findAll());
        model.addAttribute("listAirport", airportDtoList);
        model.addAttribute("formFlightSearch", new FormFlightSearch());
        return "boh";
    }

    @PostMapping("flights")
    public String findFlight(Model model, @ModelAttribute("formFlightSearch") FormFlightSearch formFlightSearch) {
        LocalDateTime dateTimeDeparture = LocalDateTime.of(formFlightSearch.getDateDeparture(), LocalTime.of(0, 0, 0));
        Airport airportArrival = repoA.findById(formFlightSearch.getAirportArrival()).orElse(new Airport());
        Airport airportDeparture = repoA.findById(formFlightSearch.getAirportDeparture()).orElse(new Airport());

        List<Flight> availableFlight = repoF.findFlightsByDateRange(dateTimeDeparture,dateTimeDeparture.plusDays(2L));
        RouteFinder routeFinder = new RouteFinder(airportDeparture, airportArrival, availableFlight, dateTimeDeparture);
        List<List<FormFlightView>> listListFormFlightView = new ArrayList<>();
        for (List<Flight> listFlight : routeFinder.getHops()) {
            List<FormFlightView> listFormFlightView=new ArrayList<>();
            for (Flight flight : listFlight) {
                listFormFlightView.add(new FormFlightView(flight));
            }
            listListFormFlightView.add(listFormFlightView);        
        }
        model.addAttribute("chronoH", ChronoUnit.HOURS);
        model.addAttribute("chronoM", ChronoUnit.MINUTES);
        model.addAttribute("listListFlight", listListFormFlightView);
        model.addAttribute("choosenFlights", new FormChosenFlights());
        return "flightResult";
    }

    @PostMapping("tickets")
    public String genrateTickets(@ModelAttribute("choosenFlights") FormChosenFlights flights,HttpSession session) {
        for (int flightId : flights.getList()) {
            Ticket newTicket = new Ticket();
            Flight flight = repoF.getReferenceById(flightId);
            newTicket.setDate(flight.getDateDeparture());
            Flight newFlight = new Flight();
            newFlight.setId(flight.getId());
            newTicket.setFlight(newFlight);
            UserDto userDto = (UserDto)session.getAttribute("userForm");
            User newUser = userDto.toEntity();
            newTicket.setUser(newUser);
            repoT.save(newTicket);
        }
        return "OperationSuccess";
    }
}
