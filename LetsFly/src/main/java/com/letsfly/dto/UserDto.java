package com.letsfly.dto;
import java.util.List;

import com.letsfly.model.Ticket;
import com.letsfly.model.User;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;
import com.letsfly.utils.restUtils.DtoInterface;

public class UserDto implements DtoInterface<User>{
	private EntityDtoConverter<Ticket,TicketDto> ticketConverter = new EntityDtoConverter<>();
	private int id,isadmin;

	private String name, surname, username, password;
	
	private List<TicketDto> listTicket;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public List<TicketDto> getListTicket() {
		return listTicket;
	}

	public void setListTicket(List<TicketDto> listTicket) {
		this.listTicket = listTicket;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}

	@Override
	public User toEntity() {
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setSurname(surname);
		if (listTicket != null){
			List<Ticket> listTicketModel= ticketConverter.dtoToEntity(listTicket);
			u.setListTicket(listTicketModel);}
		u.setUsername(username);
		u.setPassword(password);
		u.setIsadmin(isadmin);
		return u;
	}




}