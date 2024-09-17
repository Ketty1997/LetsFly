package com.letsfly.dto;

import java.util.List;

import com.letsfly.model.Airport;
import com.letsfly.model.Route;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;
import com.letsfly.utils.restUtils.DtoInterface;

public class AirportDto implements DtoInterface<Airport>{
	private EntityDtoConverter<Route,RouteDto> routeConverter = new EntityDtoConverter<>();
	private int id;

	private String country, city;

	private List<RouteDto> listRouteArrival,listRouteDeparture;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<RouteDto> getListRouteArrival() {
		return listRouteArrival;
	}
	public void setListRouteArrival(List<RouteDto> listRouteArrival) {
		this.listRouteArrival = listRouteArrival;
	}
	public List<RouteDto> getListRouteDeparture() {
		return listRouteDeparture;
	}
	public void setListRouteDeparture(List<RouteDto> listRouteDeparture) {
		this.listRouteDeparture = listRouteDeparture;
	}

	@Override
	public Airport toEntity() {
		Airport a = new Airport();
		a.setId(id);
		a.setCity(city);
		a.setCountry(country);
		if(listRouteArrival!=null){
		List<Route> lRa = routeConverter.dtoToEntity(listRouteArrival);
		a.setListRouteArrival(lRa);}
		if(listRouteDeparture!=null){
		List<Route> lRd = routeConverter.dtoToEntity(listRouteDeparture);
		a.setListRouteDeparture(lRd);}
		return a;
	}
	
	
}