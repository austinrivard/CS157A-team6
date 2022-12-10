package edu.sjsu.team6.flightfinder.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;
import edu.sjsu.team6.flightfinder.models.Airline;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> 
{
    
}
