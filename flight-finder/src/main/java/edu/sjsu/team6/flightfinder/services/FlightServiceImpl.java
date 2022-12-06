package edu.sjsu.team6.flightfinder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.team6.flightfinder.models.Flight;
import edu.sjsu.team6.flightfinder.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService
{
    @Autowired
    private FlightRepository repository;

    @Override
    public List<Flight> findAllFlights() 
    {
        List<Flight> flights = repository.findAll();
        return flights.stream()
                .map((flight) -> mapToFlight(flight))
                .collect(Collectors.toList());
    }

    private Flight mapToFlight(Flight flight){
        Flight flightList = new Flight();
        flightList.setArrivalTime(flight.getArrivalTime());
        flightList.setDepartureTime(flight.getDepartureTime());
        flightList.setFlightNumber(flight.getFlightNumber());
        flightList.setName(flight.getName());
        return flight;
    }
}
