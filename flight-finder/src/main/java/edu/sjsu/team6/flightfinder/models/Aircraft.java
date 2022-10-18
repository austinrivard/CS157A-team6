package edu.sjsu.team6.flightfinder.models;

import java.util.Collections;
import java.util.List;

public class Aircraft
{
    private String name;
    private String model;
    private int manufacturingYear;
    private List<Seat> seats;

    public List<FlightInstance> getFlights() { return Collections.emptyList(); }
}
