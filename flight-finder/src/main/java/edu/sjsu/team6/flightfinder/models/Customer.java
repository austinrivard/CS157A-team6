package edu.sjsu.team6.flightfinder.models;

import java.util.Collections;
import java.util.List;

public class Customer extends Person
{
    private String frequentFlyerNumber;

    public List<Itinerary> getItineraries() { return Collections.emptyList(); }
}
