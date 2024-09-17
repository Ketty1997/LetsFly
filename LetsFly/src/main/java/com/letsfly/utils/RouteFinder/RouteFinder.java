package com.letsfly.utils.RouteFinder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.letsfly.model.Airport;
import com.letsfly.model.Route;
import com.letsfly.model.Flight;

public class RouteFinder {
    private Airport departure;
    private Airport arrival;
    private List<Flight> availableFlight;
    private Map<List<Flight>, List<Integer>> checkedAirport = new HashMap<List<Flight>, List<Integer>>(); // FlightId,List<AirportId>
    private LocalDateTime departureTime;
    private Hops validHops = new Hops();
    private Hops hops = new Hops();
    private boolean toIterate = true;
    private boolean debug = false; // abilinta print log

    public RouteFinder(Airport d, Airport a, List<Flight> lF, LocalDateTime departureTime) {
        this.arrival = a;
        this.departure = d;
        this.availableFlight = lF;
        this.departureTime = departureTime;
        init();
        while (toIterate) {
            trace();
        }
    }

    private void init() {
        for (Flight flight : availableFlight) {
            if (flight.getRoute().getAirportDeparture().getId() == departure.getId()
                    && flight.getDateDeparture().toLocalDate().equals(departureTime.toLocalDate())) {
                List<Flight> lF = new ArrayList<>();
                lF.add(flight);
                hops.availableHops.add(lF);
                println("init added " + flight.getId());
            }
        }
        println("init hops");
        print(hops);
        for (List<Flight> listFlight : hops.availableHops) {
            checkedAirport.put(listFlight, new ArrayList<Integer>(Arrays.asList(departure.getId())));
        }
        validateHops();

    }

    private void trace() {
        println("tracing");
        Map<List<Flight>, List<Integer>> listChecked = new HashMap<List<Flight>, List<Integer>>();
        List<List<Flight>> toAdd = new ArrayList<>();
        for (List<Flight> listFlight : hops.availableHops) {
            Flight lastflight = listFlight.get(listFlight.size() - 1);
            for (Route route : lastflight.getRoute().getAirportArrival().getListRouteDeparture()) {
                for (Flight flight : availableFlight) {
                    List<Flight> newListFlight = new ArrayList<>();
                    if (flight.getDateDeparture().isAfter(lastflight.getDateArrival().plusHours(1))
                            && flight.getRoute().getId() == route.getId()) { // &&!checkedAirport.contains(flight.getRoute().getAirportArrival())
                        for (Flight flight2 : listFlight) {
                            newListFlight.add(flight2);
                        }
                        newListFlight.add(flight);
                    }
                    if (listChecked.keySet().contains(listFlight))
                    listChecked.get(listFlight).add(route.getAirportArrival().getId());
                    else
                    listChecked.put(listFlight, new ArrayList<Integer>(Arrays.asList(route.getAirportArrival().getId())));
                    toAdd.add(newListFlight);
                }
            }

        }
        for (List<Flight> listFlight : toAdd) {
            if (listFlight.size() > 0)
                hops.availableHops.add(listFlight);
        }
        for (List<Flight> key : listChecked.keySet()) {
            if (checkedAirport.keySet().contains(key))
                for (int value : listChecked.get(key)) {
                    checkedAirport.get(key).add(value);
                }
            else
                checkedAirport.put(key, listChecked.get(key));
        }
        validateHops();
    }

    private void validateHops() {
        println("pre validation");
        println("unvalid:");
        print(hops);
        println("valid:");
        print(validHops);
        println(checkedAirport.keySet().toString());
        List<List<Flight>> toRemove = new ArrayList<>();
        for (List<Flight> listFlight : hops.availableHops) {
            boolean isValid = true;
            for (Flight flight : listFlight) {
                if (flight.getAvailableTickets() < 1) {
                    isValid = false;
                    toRemove.add(listFlight);
                    break;
                }
            }
            Flight lastflight = listFlight.get(listFlight.size() - 1);
            int toRemoveCount = 0;
            for (Route route : lastflight.getRoute().getAirportArrival().getListRouteDeparture()) {
                if (checkedAirport.keySet().contains(listFlight)) {
                    if (!checkedAirport.get(listFlight).contains(route.getAirportArrival().getId()))
                        toRemoveCount++;
                } else {
                    toRemoveCount++;
                }
            }
            if (toRemoveCount == 0) {
                toRemove.add(listFlight);
                println("toremovecounter");
                printlf(listFlight);
            }
            if (lastflight.getRoute().getAirportArrival().getId() == arrival.getId() && isValid) {
                validHops.availableHops.add(listFlight);
                toRemove.add(listFlight);
            }
        }
        for (List<Flight> listFlightToRemove : toRemove) {
            hops.availableHops.remove(listFlightToRemove);
        }
        if (hops.availableHops.size() == 0)
            toIterate = false;
        println("post validation");
        println("unvalid:");
        print(hops);
        println("valid:");
        print(validHops);
    }

    public List<List<Flight>> getHops() {
        return validHops.availableHops;
    }

    private void println(String s) {
        if (debug)
            System.out.println(s);
    }

    private void printlf(List<Flight> listFlight) {
        if (debug) {
            for (Flight flight : listFlight) {
                System.out.print("-" + flight.getId());
            }
            System.out.println();
        }
    }

    private void print(Hops h) {
        if (debug) {
            for (List<Flight> listFlight : h.availableHops) {
                for (Flight flight : listFlight) {
                    System.out.print("-" + flight.getId());
                }
                System.out.println();
            }
        }
    }
}
