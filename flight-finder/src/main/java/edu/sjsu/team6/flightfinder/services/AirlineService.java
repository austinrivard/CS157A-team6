package edu.sjsu.team6.flightfinder.services;

import java.util.List;

import edu.sjsu.team6.flightfinder.models.Airline;

public interface AirlineService 
{
    public void saveAirline(Airline airline);

    List<Airline> findAllAirlines();
}