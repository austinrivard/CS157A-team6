package edu.sjsu.team6.flightfinder.services;

import java.util.List;

import edu.sjsu.team6.flightfinder.models.User;

public interface UserService 
{
    public void registerUser(User user);
    User findUserByEmail(String email);

    List<User> findAllUsers();
}
