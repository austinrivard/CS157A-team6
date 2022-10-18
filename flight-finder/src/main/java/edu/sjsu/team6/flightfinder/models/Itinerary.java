package edu.sjsu.team6.flightfinder.models;

import java.util.Date;
import java.util.List;

public class Itinerary
{
    private String customerId;
    private Airport startingAirport;
    private Airport finalAirport;
    private Date creationDate;
    private List<FlightReservation> reservations;

    public List<FlightReservation> getReservations() { return reservations; }
    // public boolean makeReservation() {}
    // public boolean makePayment() {}
}
