package edu.sjsu.team6.flightfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import edu.sjsu.team6.flightfinder.models.User;
import edu.sjsu.team6.flightfinder.repositories.UserRepo;
import edu.sjsu.team6.flightfinder.services.UserService;

@Controller
public class FlightFinderController {
	
    @Autowired
    private UserService service;
    @Autowired 
    UserRepo userRepo;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/registerUser")
    public String register(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user)
    {
        String result = "error";
        System.out.println(user);
        if (user.getPassword().equals(user.getCPassword()))
        {
            try
            {
                service.registerUser(user);
                result = "register_success";
            }
            catch(Exception e)
            {
                result = "error";
            }
        }
        return result;
        // service.registerUser(user);
    }

    // Login form  
	@GetMapping("/login")  
	public String login() {  
		 return "login";  
	}  
}