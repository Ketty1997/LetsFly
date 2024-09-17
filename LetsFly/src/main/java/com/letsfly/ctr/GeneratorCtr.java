package com.letsfly.ctr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsfly.dto.FlightDto;
import com.letsfly.dto.UserDto;
import com.letsfly.model.Flight;
import com.letsfly.model.Route;
import com.letsfly.repository.FlightRepo;
import com.letsfly.repository.RouteRepo;
import com.letsfly.utils.FlightGenerator;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("genFlight")
public class GeneratorCtr {
	@Autowired
	RouteRepo repo;
	@Autowired
	FlightRepo repoF;

	@GetMapping("")
	public String init(Model model, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			FlightGenerator flightGenerator = new FlightGenerator();
			model.addAttribute("flightGenerator", flightGenerator);
			return "flight/generator";
		} else {
			return "/homeUtente";
		}
	}

	@PostMapping("inserimento")
	public String insert(@ModelAttribute("flightGenerator") FlightGenerator flightGenerator, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			flightGenerator.generateFlights(repo.findAll());
			List<FlightDto> listFlight = flightGenerator.getGenerated();
			List<Flight> listEntityClass = new ArrayList<>();
			Route route = new Route();
			for (FlightDto flightDto : listFlight) {
				route.setId(flightDto.getRoute());
				if (!repoF.checkIfExist(flightDto.getDateTimeDeparture(), flightDto.getDateTimeArrival(), route)) {
					listEntityClass.add(flightDto.toEntity());
				}
			}
			repoF.saveAll(listEntityClass);
			return "flight/list";
		} else {
			return "/homeUtente";
		}
	}

}
