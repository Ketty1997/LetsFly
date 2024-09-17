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

import com.letsfly.dto.TicketDto;
import com.letsfly.dto.UserDto;
import com.letsfly.form.FormTicketView;
import com.letsfly.model.Ticket;
import com.letsfly.repository.TicketRepo;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("ticket")
public class TicketCtr {

	@Autowired
	private TicketRepo rep;
	@Autowired
	private EntityDtoConverter<Ticket, TicketDto> ticketConverter;

	@GetMapping("findAll")
	public String findAll(Model model,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		List<TicketDto> ticketDtoList = ticketConverter.entityToDto(rep.findAll());
		model.addAttribute("ticketListForm", ticketDtoList);

		return "ticket/ticketSearch";} else {
			return "/homeUtente";
		}
	}

	@GetMapping("preInsert")
	public String preInsert(Model model,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		TicketDto ticketDto = new TicketDto();

		model.addAttribute("ticketForm", ticketDto);

		return "ticket/ticketInsert";} else {
			return "/homeUtente";
		}
	}

	@PostMapping("insert")
	public String insert(@ModelAttribute("ticketForm") TicketDto ticketDto,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		Ticket ticket = ticketDto.toEntity();

		rep.save(ticket);

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
		Ticket ticket = rep.findById(id).orElse(new Ticket());

		model.addAttribute("ticketForm", ticket.toDto());

		return "ticket/ticketUpdate";} else {
			return "/homeUtente";
		}
	}

	@PostMapping("update")
	public String update(@ModelAttribute("ticketForm") TicketDto ticketDto,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		Ticket ticket = ticketDto.toEntity();

		rep.save(ticket);

		return "OperationSuccess";} else {
			return "/homeUtente";
		}
	}

	@GetMapping("delete/{id}")
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

	@GetMapping("ticketView/{id}")
	public String ViewTicket(Model model, @PathVariable int id,HttpSession session) {
		UserDto userDto = (UserDto)session.getAttribute("userForm");
		if(userDto==null)
		return "/homeUtente";
		if(userDto.getIsadmin()>0){
		Ticket ticket = rep.findById(id).orElse(new Ticket());

		FormTicketView ticketViewDto = new FormTicketView(ticket);

		model.addAttribute("ticketViewForm", ticketViewDto);

		return "ticket/ticketView";} else {
			return "/homeUtente";
		}
	}

	@PostMapping("ticketView")
	public String ViewTicketN(Model model, @ModelAttribute("choosenTicket") TicketDto ticketDto) {
		Ticket ticket = rep.findById(ticketDto.getId()).orElse(new Ticket());
		model.addAttribute("ticketViewForm", new FormTicketView(ticket));

		return "ticket/ticketView";
	}
}