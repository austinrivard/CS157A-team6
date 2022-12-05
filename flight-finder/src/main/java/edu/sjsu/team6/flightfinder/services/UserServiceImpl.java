package edu.sjsu.team6.flightfinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.sjsu.team6.flightfinder.models.User;
import edu.sjsu.team6.flightfinder.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo repo;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo repo, PasswordEncoder passwordEncoder)
    {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(User user)
    {
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }
}
