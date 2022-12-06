package edu.sjsu.team6.flightfinder.repositories;

import org.springframework.stereotype.Repository;

import edu.sjsu.team6.flightfinder.models.Flight;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByFlightNumber(String flightNumber);
}
