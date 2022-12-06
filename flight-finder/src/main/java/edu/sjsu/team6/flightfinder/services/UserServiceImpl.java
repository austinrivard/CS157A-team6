package edu.sjsu.team6.flightfinder.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.sjsu.team6.flightfinder.models.User;
import edu.sjsu.team6.flightfinder.repositories.UserRepo;
import edu.sjsu.team6.flightfinder.models.Role;
import edu.sjsu.team6.flightfinder.repositories.RoleRepository;


@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo repo;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo repo, RoleRepository roleRepository, PasswordEncoder passwordEncoder)
    {
        this.repo = repo;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(User user)
    {
        // User newUser = new User();
        user.setName(user.getFirstName() + " " + user.getLastName());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        repo.save(user);
    }

    @Override
    public User findUserByEmail(String email) 
    {
        return repo.findUserByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = repo.findAll();
        return users.stream()
                .map((user) -> mapToUser(user))
                .collect(Collectors.toList());
    }

    private User mapToUser(User user){
        User userList = new User();
        String[] str = user.getName().split(" ");
        userList.setFirstName(str[0]);
        userList.setLastName(str[1]);
        userList.setEmail(user.getEmail());
        return user;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
