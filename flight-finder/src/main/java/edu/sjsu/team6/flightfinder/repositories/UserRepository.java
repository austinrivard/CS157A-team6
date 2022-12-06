package edu.sjsu.team6.flightfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sjsu.team6.flightfinder.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User findUserByEmail(String email);
}
