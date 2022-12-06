package edu.sjsu.team6.flightfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
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
    private UserService userService;

    @Autowired 
    UserRepo userRepo;

	@Autowired
	JdbcTemplate jdbcTemplate;

    public FlightFinderController(UserService userService) {
        this.userService = userService;
    }

	@GetMapping("index")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
    public String register(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user, Model model)
    {
        // String result = "error";
        System.out.println(user);
        if (user.getPassword().equals(user.getCPassword()))
        {
            try
            {
                userService.registerUser(user);
            }
            catch(Exception e)
            {
                // result = "error";
                // return result;
                // return "register";
            }
        }
        // return result;
        return "redirect:/register?success";
    }

    // Login form  
	@GetMapping("/login")  
	public String login() {  
		 return "login";  
	}  

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/flight")
    public String flights(Model model){
        return "flight";
    }
}