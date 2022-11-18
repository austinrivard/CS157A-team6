package edu.sjsu.team6.flightfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.sjsu.team6.flightfinder.models.User;
import edu.sjsu.team6.flightfinder.repositories.UserRepository;

@Controller
public class FlightFinderController {
	
    @Autowired 
    UserRepository userRepo;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
    // Register form
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

    @PostMapping("/process_register")
	public String processRegister(User user, Model model) {	
        model.addAttribute("registrationForm", user);
		return "register_success";
	}

    // Login form  
	@GetMapping("/login")  
	public String login() {  
		 return "login";  
	}  
}