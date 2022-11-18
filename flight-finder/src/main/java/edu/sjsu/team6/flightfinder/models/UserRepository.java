package edu.sjsu.team6.flightfinder.models;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface UserRepository extends JpaRepository<User, String> {
 
}