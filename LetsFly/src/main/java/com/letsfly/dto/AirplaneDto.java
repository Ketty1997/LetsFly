package com.letsfly.dto;

import com.letsfly.model.Airplane;
import com.letsfly.utils.restUtils.DtoInterface;

public class AirplaneDto implements DtoInterface<Airplane>{
	private int id, seatRow, seatColumn;
	
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
	@Override
	public Airplane toEntity() {
		Airplane a = new Airplane();
		a.setId(id);
		a.setSeatColumn(seatColumn);
		a.setSeatRow(seatRow);
		return a;
	}
	
}