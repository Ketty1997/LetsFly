package com.letsfly.form;

import java.time.LocalDate;

public class FormFlightSearch {

  private LocalDate dateDeparture;

  private int airportDeparture;

  private int airportArrival;

  public LocalDate getDateDeparture() {
    return dateDeparture;
  }

  public void setDateDeparture(LocalDate dateDeparture) {
    this.dateDeparture = dateDeparture;
  }

  public int getAirportDeparture() {
    return airportDeparture;
  }

  public void setAirportDeparture(int airportDeparture) {
    this.airportDeparture = airportDeparture;
  }

  public int getAirportArrival() {
    return airportArrival;
  }

  public void setAirportArrival(int airportArrival) {
    this.airportArrival = airportArrival;
  }

  @Override
  public String toString() {
    return "FormFlightSearch{" +
            "dateDeparture=" + dateDeparture +
            ", airportDeparture=" + airportDeparture +
            ", airportArrival=" + airportArrival +
            '}';
  }

}
