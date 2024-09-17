package com.letsfly.model;

import java.io.Serializable;
import java.util.List;

import com.letsfly.dto.AirportDto;
import com.letsfly.dto.RouteDto;
import com.letsfly.utils.conversionUtils.EntityDtoConverter;
import com.letsfly.utils.restUtils.EntityInterface;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Airport implements Serializable,EntityInterface<AirportDto> {
    @Transient
	private EntityDtoConverter<Route,RouteDto> routeConverter = new EntityDtoConverter<>();
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)//genera automaticamente chiave primaria
    private int id;

    private String country;

    private String city;
    @OneToMany(mappedBy = "airportArrival",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
    List<Route> listRouteArrival;
    @OneToMany(mappedBy = "airportDeparture",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
    List<Route> listRouteDeparture;

    public Airport(){

    }

    public Airport(int id, String country, String city) {
        this.id = id;
        this.country = country;
        this.city = city;
    }

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
    public List<Route> getListRouteArrival() {
        return listRouteArrival;
    }

    public void setListRouteArrival(List<Route> listArrival) {
        this.listRouteArrival = listArrival;
    }

    public List<Route> getListRouteDeparture() {
        return listRouteDeparture;
    }

    public void setListRouteDeparture(List<Route> listDeparture) {
        this.listRouteDeparture = listDeparture;
    }
    @Override
    public AirportDto toDto() {
        AirportDto a = new AirportDto();
        a.setId(id);
        a.setCity(city);
        a.setCountry(country);
        if(listRouteDeparture!=null){
        List<RouteDto> lRd = routeConverter.entityToDto(listRouteDeparture);
        a.setListRouteDeparture(lRd);}
        if(listRouteArrival!=null){
        List<RouteDto> lRa = routeConverter.entityToDto(listRouteArrival);
        a.setListRouteArrival(lRa);}
        return a;
    }


}

