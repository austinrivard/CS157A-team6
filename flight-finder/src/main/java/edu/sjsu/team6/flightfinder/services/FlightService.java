package edu.sjsu.team6.flightfinder.services;


import java.util.List;

import edu.sjsu.team6.flightfinder.models.Flight;

public interface FlightService 
{
    List<Flight> findAllFlights();
}
