package edu.sjsu.team6.flightfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.team6.flightfinder.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>
{
    User findUserByEmail(String email);
    User findUserByUsername(String username);

}
