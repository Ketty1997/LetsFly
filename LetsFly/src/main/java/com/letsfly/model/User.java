package com.letsfly.model;

import java.io.Serializable;
import java.util.List;

import com.letsfly.dto.TicketDto;
import com.letsfly.dto.UserDto;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;
import com.letsfly.utils.restUtils.EntityInterface;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User implements Serializable, EntityInterface<UserDto> {

	@Transient
	private EntityDtoConverter<Ticket,TicketDto> ticketConverter = new EntityDtoConverter<>();
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private String surname;
	private String username;
	private String password;
	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
	private List<Ticket> listTicket;
	private int isadmin;
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

	public List<Ticket> getListTicket() {
		return listTicket;
	}

	public void setListTicket(List<Ticket> listTicket) {
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
	public UserDto toDto() {
		UserDto u = new UserDto();
		u.setId(id);
		u.setName(name);
		u.setSurname(surname);
		if(listTicket!=null){
			List<TicketDto> listTicketDto = ticketConverter.entityToDto(listTicket);
			u.setListTicket(listTicketDto);}
		u.setUsername(username);
		u.setPassword(password);
		u.setIsadmin(isadmin);
		return u;
	}

}
