package edu.sjsu.team6.flightfinder.models;

import java.util.Collections;
import java.util.List;

public class Airport
{
    private String name;
    private Address address;
    private String code;

    public List<Flight> getFlights() { return Collections.emptyList(); }
}
