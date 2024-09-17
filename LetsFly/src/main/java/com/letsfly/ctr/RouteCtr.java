package com.letsfly.ctr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsfly.dto.AirplaneDto;
import com.letsfly.dto.AirportDto;
import com.letsfly.dto.RouteDto;
import com.letsfly.dto.UserDto;
import com.letsfly.model.Airplane;
import com.letsfly.model.Airport;
import com.letsfly.model.Route;
import com.letsfly.repository.AirplaneRepo;
import com.letsfly.repository.AirportRepo;
import com.letsfly.repository.RouteRepo;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("route")
public class RouteCtr {
	Set<String> days = Set.of("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY");
	@Autowired
	private RouteRepo rep;
	@Autowired
	private AirportRepo repA;
	@Autowired
	private AirplaneRepo repP;
	@Autowired
	private EntityDtoConverter<Airplane,AirplaneDto> airplaneConverter;
	@Autowired
	private EntityDtoConverter<Airport,AirportDto> airportConverter;
	@Autowired
	private EntityDtoConverter<Route,RouteDto> routeConverter;

	@GetMapping("findAll")
	public String findAll(Model model,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		List<RouteDto> routeDtoList = routeConverter.entityToDto(rep.findAll());
		model.addAttribute("routeListForm", routeDtoList);

		return "route/routeSearch";} else {
			return "/homeUtente";
		}
	}

	@GetMapping("preInsert")
	public String preInsertRoute(Model model,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		RouteDto routeDto = new RouteDto();
		List<AirportDto> listAirportDto = airportConverter.entityToDto(repA.findAll());
		List<AirplaneDto> listAirplaneDto = airplaneConverter.entityToDto(repP.findAll());
		model.addAttribute("listAirport", listAirportDto);
		model.addAttribute("listAirplane", listAirplaneDto);
		model.addAttribute("dayOfWeek", days);
		model.addAttribute("routeForm", routeDto);

		return "route/insertRoute";} else {
			return "/homeUtente";
		}
	}

	@PostMapping("insert")
	public String insertRoute(Model model, @ModelAttribute("routeForm") RouteDto routeDto,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		Route route = routeDto.toEntity();

		rep.save(route);
		return "OperationSuccess";} else {
			return "/homeUtente";
		}

	}
	@GetMapping("preUpdate/{id}")
	public String preUpdate(Model model, @PathVariable int id,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		Route route = rep.findById(id).orElse(new Route());
		List<String> missingDay = new ArrayList<>();
		for (String day : days ) {
			if(!route.getAvailability().contains(day)){
				missingDay.add(day);}
		}
		List<AirportDto> listAirportDto = airportConverter.entityToDto(repA.findAll());
		List<AirplaneDto> listAirplaneDto = airplaneConverter.entityToDto(repP.findAll());
		model.addAttribute("listAirport", listAirportDto);
		model.addAttribute("listAirplane", listAirplaneDto);
		model.addAttribute("routeForm", route.toDto());
		model.addAttribute("listAvailabilty", missingDay);

		return "route/updateRoute";} else {
			return "/homeUtente";
		}
	}

	@PostMapping("/update")
	public String updateRoute(Model model, @ModelAttribute("routeForm") RouteDto routeDto,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		Route route = routeDto.toEntity();

		rep.save(route);
		return "OperationSuccess";} else {
			return "/homeUtente";
		}
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		rep.deleteById(id);

		return "OperationSuccess";} else {
			return "/homeUtente";
		}
	}

}
