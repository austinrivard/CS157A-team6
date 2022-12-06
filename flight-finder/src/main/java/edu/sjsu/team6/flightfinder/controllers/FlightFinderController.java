package edu.sjsu.team6.flightfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sjsu.team6.flightfinder.models.*;
import edu.sjsu.team6.flightfinder.repositories.FlightRepository;
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

	@Autowired
	FlightRepository flightRepository;

    public FlightFinderController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String viewHomePage() {
        return "index";
    }

	// @GetMapping("index")
	// public String viewHomePage(Model model) {
	// 	model.addAttribute("alert", new Alert());
	// 	// model.addAttribute("flightNumber", new String());
	// 	return "index";
	// }

	@PostMapping("/addAlert")
	public String addAlert(@ModelAttribute("alert") Alert alert, @RequestParam("flightNumber") String flightNumber) {
        System.out.printf("Received request to add alert: %s with flight number %s\n", alert, flightNumber);
		System.out.println("found flight by flight number? " + (flightRepository.findByFlightNumber(flightNumber).isPresent() ? "yes" : "no"));
		alert.setFlightToTrack(flightRepository.findByFlightNumber(flightNumber).get());
		User currentUser = ((MyUserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		alert.setSetBy(currentUser);

		int rowsAffected = jdbcTemplate.update(
			"INSERT INTO alert (communication_preference, flight_to_track_id, set_by_id) VALUES (?,?,?)",
			alert.getCommunicationPreference(), alert.getFlightToTrack().getId(), alert.getSetBy().getId()
		);

		System.out.println("updated " + rowsAffected + " rows.");
		return (rowsAffected == 0) ? "error" : "index";
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