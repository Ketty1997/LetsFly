package com.letsfly.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsfly.dto.AirportDto;
import com.letsfly.dto.UserDto;
import com.letsfly.form.FormAirportView;
import com.letsfly.model.*;
import com.letsfly.repository.AirportRepo;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("airport")
public class AirportCtr {

	@Autowired
	private AirportRepo airRep;

	@GetMapping("findAll")
	public String findAll(Model model) {
		List<Airport> airportList = airRep.findAll();

		FormAirportView formAirportView;

		List<FormAirportView> formAirportViewList = new ArrayList<>();

		for (Airport airport : airportList) {
			formAirportView = new FormAirportView(airport);

			formAirportViewList.add(formAirportView);
		}

		model.addAttribute("FormAirportViewL", formAirportViewList);

		return "airport/airportSearch";
	}

	@GetMapping("preInsert")
	public String insert(Model model, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			AirportDto airportDto = new AirportDto();
			model.addAttribute("airportForm", airportDto);
			return "airport/airportInsert";
		} else {
			return "/homeUtente";
		}
	}

	@PostMapping("insert")
	public String insert(Model model, @ModelAttribute("airportForm") AirportDto airportDto, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			Airport airport = airportDto.toEntity();
			airRep.save(airport);
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
			Airport airport = airRep.findById(id).orElse(new Airport());
			
			model.addAttribute("airportForm", airport.toDto());
			
			return "airport/airportUpdate";
		} else {
			return "/homeUtente";
		}
	}

	@PostMapping("update")
	public String update(@ModelAttribute("airportForm") AirportDto airportDto, HttpSession session) {
		
		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			Airport airport = airportDto.toEntity();
			airRep.save(airport);
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
			airRep.deleteById(id);
			return "OperationSuccess";
		} else {
			return "/homeUtente";
		}
	}
}
