package com.letsfly.ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsfly.dto.FlightDto;
import com.letsfly.dto.UserDto;
import com.letsfly.model.Flight;
import com.letsfly.repository.FlightRepo;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/flight")

@Controller
public class FlightCtr {

	@Autowired
	private FlightRepo flightRep;
	@Autowired
	private EntityDtoConverter<Flight, FlightDto> flightConverter;

	@GetMapping("findAll")
	public String findAll(Model model, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			List<FlightDto> flightDtoList = flightConverter.entityToDto(flightRep.findAll());

			model.addAttribute("flightListForm", flightDtoList);

			return "flight/flightSearch";
		} else {
			return "/homeUtente";
		}
	}

	@GetMapping("preInsert")
	public String preInsert(Model model, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			FlightDto flightDto = new FlightDto();
			model.addAttribute("flightForm", flightDto);

			return "flight/flightInsert";
		} else {
			return "/homeUtente";
		}
	}

	@PostMapping("insert")
	public String inserisci(Model model, @ModelAttribute("flightForm") FlightDto flightDto, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			model.addAttribute("flightForm", flightDto);
			return "OperationSuccess";
		} else {
			return "/homeUtente";
		}
	}

	@GetMapping("preUpdate/{id}")
	public String preUpdate(Model model, @PathVariable int id, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			Flight flight = flightRep.findById(id).orElse(new Flight());

			model.addAttribute("flightForm", flight.toDto());

			return "flight/flightUpdate";
		} else {
			return "/homeUtente";
		}
	}

	@PostMapping("update")
	public String update(@ModelAttribute("flightForm") FlightDto flightDto, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			Flight flight = flightDto.toEntity();
			flightRep.save(flight);
			return "OperationSuccess";
		} else {
			return "/homeUtente";
		}
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			flightRep.deleteById(id);

			return "OperationSuccess";
		} else {
			return "/homeUtente";
		}
	}
}
