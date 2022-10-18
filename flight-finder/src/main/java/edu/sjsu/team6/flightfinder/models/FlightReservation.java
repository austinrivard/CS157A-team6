package edu.sjsu.team6.flightfinder.models;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FlightReservation
{
    private String reservationNumber;
    private FlightInstance flight;
    private Map<Passenger, Seat> seatMap;
    private Date creationDate;
    private ReservationStatus status;

    // public static FlightReservation fetchReservationDetails(String reservationNumber) {  }
    public List<Passenger> getPassengers() { return Collections.emptyList(); }
}
