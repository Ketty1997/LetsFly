package com.letsfly.ctr;

import java.util.List;

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
import com.letsfly.dto.UserDto;
import com.letsfly.model.Airplane;
import com.letsfly.repository.AirplaneRepo;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("airplane")
public class AirplaneCtr {

	@Autowired
	private AirplaneRepo rep;
	@Autowired
	private EntityDtoConverter<Airplane, AirplaneDto> airplaneConverter;

	@GetMapping("findAll")
	public String findAll(Model model, HttpSession session) {
		
		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			List<AirplaneDto> airplaneDtoList = airplaneConverter.entityToDto(rep.findAll());
			model.addAttribute("airplaneListForm", airplaneDtoList);
			
			return "airplane/airplaneSearch";
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
			AirplaneDto airplaneDto = new AirplaneDto();

			model.addAttribute("airplaneForm", airplaneDto);

			return "airplane/airplaneInsert";

		} else {
			return "/homeUtente";
		}
	}

	@PostMapping("insert")
	public String insert(@ModelAttribute("airplaneForm") AirplaneDto airplaneDto, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			Airplane airplane = airplaneDto.toEntity();

			rep.save(airplane);

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
			Airplane airplane = rep.findById(id).orElse(new Airplane());

			model.addAttribute("airplaneForm", airplane.toDto());

			return "airplane/airplaneUpdate";
		} else {
			return "/homeUtente";
		}
	}

	@PostMapping("update")
	public String update(@ModelAttribute("airplaneForm") AirplaneDto airplaneDto, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			Airplane airplane = airplaneDto.toEntity();

			rep.save(airplane);

			return "OperationSuccess";
		} else {
			return "/homeUtente";
		}
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("userForm");
		if (userDto == null)
			return "/homeUtente";
		if (userDto.getIsadmin() > 0) {
			rep.deleteById(id);
			
			return "OperationSuccess";
		} else {
			return "/homeUtente";
		}
	}
}