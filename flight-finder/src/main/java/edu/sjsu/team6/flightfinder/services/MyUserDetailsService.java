package edu.sjsu.team6.flightfinder.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.sjsu.team6.flightfinder.models.MyUserPrincipal;
import edu.sjsu.team6.flightfinder.models.User;
import edu.sjsu.team6.flightfinder.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        // if(user != null)
        // {
        //     return new org.springframework.security.core.userdetails.User(user.getEmail()
        //             , user.getPassword(),
        //             user.getRoles().stream()
        //                     .map((role) -> new SimpleGrantedAuthority(role.getName()))
        //                     .collect(Collectors.toList()));
        // }
        return new MyUserPrincipal(user);
    }
}