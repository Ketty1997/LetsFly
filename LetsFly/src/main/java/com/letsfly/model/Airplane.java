package com.letsfly.model;

import java.io.Serializable;

import com.letsfly.dto.AirplaneDto;
import com.letsfly.utils.restUtils.EntityInterface;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Airplane implements Serializable,EntityInterface<AirplaneDto> {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)//genera automaticamente chiave primaria
	private int id;

	private int seatRow;

	private int seatColumn;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}
	public int getSeatColumn() {
		return seatColumn;
	}
	public void setSeatColumn(int seatColumn) {
		this.seatColumn = seatColumn;
	}
	public int getCapacity(){
		return seatRow*seatColumn;
	}
	@Override
	public AirplaneDto toDto() {
		AirplaneDto a = new AirplaneDto();
		a.setId(id);
		a.setSeatColumn(seatColumn);
		a.setSeatRow(seatRow);
		return a;
	}
	
	
}
