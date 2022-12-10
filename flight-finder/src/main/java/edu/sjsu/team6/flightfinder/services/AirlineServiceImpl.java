package edu.sjsu.team6.flightfinder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.team6.flightfinder.models.Airline;
import edu.sjsu.team6.flightfinder.repositories.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineService
{
    @Autowired
    private AirlineRepository repository;

    @Override
    public List<Airline> findAllAirlines() 
    {
        List<Airline> airlines = repository.findAll();
        return airlines.stream()
                .map(this::mapToAirline)
                .collect(Collectors.toList());
    }

    @Override
    public void saveAirline(Airline airline)
    {
        airline.setContactNumber(airline.getContactNumber());
        airline.setName(airline.getName());
        airline.setWebsiteUrl(airline.getWebsiteUrl());
        repository.save(airline);
    }

    private Airline mapToAirline(Airline airline)
    {
        Airline airlineList = new Airline();
        airlineList.setContactNumber(airline.getContactNumber());
        airlineList.setName(airline.getName());
        airlineList.setWebsiteUrl(airline.getWebsiteUrl());
        return airline;
    }
}
