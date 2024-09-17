package com.letsfly.ctr;

import com.letsfly.dto.TicketDto;
import com.letsfly.dto.UserDto;
import com.letsfly.form.FormLogin;
import com.letsfly.form.FormTicketView;
import com.letsfly.form.FormUserData;
import com.letsfly.form.FormUserPassword;
import com.letsfly.model.Ticket;
import com.letsfly.model.User;
import com.letsfly.repository.TicketRepo;
import com.letsfly.repository.UserRepo;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("user")
public class UserCtr {

	@Autowired
	private UserRepo rep;
	@Autowired
	private TicketRepo repT;
  	@Autowired
  	private EntityDtoConverter<User,UserDto> userConverter;

	@GetMapping("findAll")
	public String findAll(Model model,HttpSession session) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		if(userDtoSession==null)
		return "/homeUtente";
		if(userDtoSession.getIsadmin()>0){
		List<UserDto> userDtoList = userConverter.entityToDto(rep.findAll());
		model.addAttribute("userListForm", userDtoList);

		return "user/userSearch";} else {
			return "/homeUtente";
		}
	}

	@GetMapping("preInsert")
	public String preInsert(Model model,HttpSession session) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		if(userDtoSession==null)
		return "/homeUtente";
		if(userDtoSession.getIsadmin()>0){
		UserDto userDto = new UserDto();

		model.addAttribute("userForm", userDto);

		return "user/userInsert";} else {
			return "/homeUtente";
		}
	}

	@PostMapping("insert")
	public String insert(Model model,@ModelAttribute("userForm") UserDto userDto,HttpSession session) {
		User user = userDto.toEntity();
		if(rep.checkIfUsernameExist(userDto.getUsername())){
			model.addAttribute("usernameMessage", "This Username is already in use");
			model.addAttribute("passswordinvalidMessage", "");
			model.addAttribute("loginBoolean", false);
			model.addAttribute("userForm", userDto);
			model.addAttribute("loginDto", new FormLogin());
			return "login";
		}
		
		user = rep.save(user);
		UserDto userDtoSession = user.toDto();
		session.setAttribute("userForm", userDtoSession);

		return "OperationSuccess";
	}

	@GetMapping("preUpdate/{id}")
	public String preUpdate(Model model, @PathVariable int id,HttpSession session) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		if(userDtoSession==null)
		return "/homeUtente";
		if(userDtoSession.getIsadmin()>0){
		User user = rep.findById(id).orElse(new User());

		model.addAttribute("modelUserForm", user.toDto());

		return "user/userUpdate";} else {
			return "/homeUtente";
		}
	}

	@PostMapping("update")
	public String update(@ModelAttribute("userForm") UserDto userDto,HttpSession session) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		if(userDtoSession==null)
		return "/homeUtente";
		if(userDtoSession.getIsadmin()>0){
		User user = userDto.toEntity();

		rep.save(user);

		return "OperationSuccess";} else {
			return "/homeUtente";
		}
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id,HttpSession session) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		if(userDtoSession==null)
		return "/homeUtente";
		if(userDtoSession.getIsadmin()>0){
		rep.deleteById(id);

		return "OperationSuccess";} else {
			return "/homeUtente";
		}
	}
	@GetMapping("remove")
	public String remove(HttpSession session) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		rep.delete(userDtoSession.toEntity());
		session.removeAttribute("userForm");

		return "homeUtente";
	}
	@GetMapping("editPassword")
	public String editPassword(Model model,HttpSession session) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		model.addAttribute("passswordinvalidMessage", "");
		model.addAttribute("passswordunequalMessage", "");
		session.setAttribute("userForm", userDtoSession);
		model.addAttribute("modelUserPasswordForm", new FormUserPassword());
		return "user/passwordUpdate";
	}
	
	@GetMapping("edit")
	public String edit(Model model,HttpSession session) {
		model.addAttribute("usernameMessage", "");
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		session.setAttribute("userForm", userDtoSession);
		FormUserData userDataForm = new FormUserData(userDtoSession);
		model.addAttribute("modelUserForm", userDataForm);
		return "user/userUpdate";
	}
	@PostMapping("modifyPassword")
	public String modifyPassword(Model model,HttpSession session,@ModelAttribute("modelUserPasswordForm") FormUserPassword userPassword) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		User user = rep.authorizeUser(userDtoSession.getUsername(), userPassword.getOldpassword());
		if (user==null){
			model.addAttribute("passswordinvalidMessage", "The password is wrong");
			session.setAttribute("userForm", userDtoSession);
			model.addAttribute("modelUserPasswordForm", new FormUserPassword());
			return "user/passwordUpdate";
		} else if(!userPassword.getNewpassword().equals(userPassword.getChecknewpassword())){
			model.addAttribute("passswordunequalMessage", "The two password are not equal");
			session.setAttribute("userForm", userDtoSession);
			model.addAttribute("modelUserPasswordForm", new FormUserPassword());
			return "user/passwordUpdate";
		} else{
			user.setPassword(userPassword.getNewpassword());
			userDtoSession = rep.save(user).toDto();
			session.setAttribute("userForm", userDtoSession);
			return "homeUtente";
		}

	}
	
	@PostMapping("modify")
	public String modify(Model model,@ModelAttribute("modelUserForm") FormUserData userDto,HttpSession session) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		if(!rep.checkIfUsernameExist(userDto.getUsername())||userDtoSession.getUsername().equals(userDto.getUsername())){
			User user = rep.findById(userDto.getId()).orElse(new User());
			user.setName(userDto.getName());
			user.setSurname(userDto.getSurname());
			user.setUsername(userDto.getUsername());
			UserDto newUserDto = rep.save(user).toDto();
			session.setAttribute("userForm", newUserDto);
			return "OperationSuccess";}
		else {
			session.setAttribute("userForm", userDtoSession);
			model.addAttribute("usernameMessage", "Username already in use");
			model.addAttribute("modelUserForm", userDto);
			return "user/userUpdate";
		}
	}
	
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("usernameMessage", "");
		model.addAttribute("passswordinvalidMessage", "");
		model.addAttribute("loginBoolean", true);
		model.addAttribute("userForm", new UserDto());
		model.addAttribute("loginDto", new FormLogin());
		return "login";
	}
	@PostMapping("authorize")
	public String authorize(Model model,@ModelAttribute("loginDto") FormLogin loginDto,HttpSession session) {
		User u = rep.authorizeUser(loginDto.getUsername(), loginDto.getPassword());
		if (u == null){
			model.addAttribute("usernameMessage", "");
			model.addAttribute("passswordinvalidMessage", "The password or username is wrong");
			loginDto.setPassword(null);
			model.addAttribute("loginBoolean", true);
			model.addAttribute("userForm", new UserDto());
			model.addAttribute("loginDto", loginDto);
			return "login";
		}
		session.setAttribute("userForm", u.toDto());
		return "homeUtente";
	}
	@GetMapping("logOut")
	public String logOut(HttpSession session) {
		session.removeAttribute("userForm");
		return "homeUtente";
	}
	@GetMapping("myTicket")
	public String listTicket(Model model,HttpSession session) {
		UserDto userDtoSession = (UserDto)session.getAttribute("userForm");
		List<Ticket> listTicket = repT.findUserTickets(userDtoSession.toEntity());
		List<FormTicketView> listFormTicketView = new ArrayList<>();
		for (Ticket ticket : listTicket) {
			listFormTicketView.add(new FormTicketView(ticket));
		}
		model.addAttribute("choosenTicket", new TicketDto());
		model.addAttribute("userTickets", listFormTicketView);
		return "user/listTicket";
	}
	
	
}