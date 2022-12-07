package edu.sjsu.team6.flightfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.sjsu.team6.flightfinder.models.*;
import edu.sjsu.team6.flightfinder.services.*;

import edu.sjsu.team6.flightfinder.repositories.FlightRepository;
import edu.sjsu.team6.flightfinder.repositories.UserRepo;
@Controller
public class FlightFinderController {
	
    @Autowired
    private UserService userService;
    private FlightService flightService;

    @Autowired 
    private UserRepo userRepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private FlightRepository flightRepository;

    public FlightFinderController(UserService userService, FlightService flightService) {
        this.userService = userService;
        this.flightService = flightService;
    }

    @GetMapping("/")
    public String viewIndex() {
        return "login";
    }

	@GetMapping("/index")
	public String viewHomePage(Model model) {
		model.addAttribute("alert", new Alert());
        model.addAttribute("flights", flightRepository.findAll());
		return "index";
	}

	@PostMapping("/addAlert")
	public String addAlert(@ModelAttribute("alert") Alert alert) {
        System.out.printf("Received request to add alert: %s\n", alert);

        Optional<Flight> flightOptional = flightRepository.findByFlightNumber(alert.getFlightNumber());
        System.out.println("found flight by flight number? " + (flightOptional.isPresent() ? "yes" : "no"));
        
        if (flightOptional.isEmpty()) {
            // errors.rejectValue("flightNumber", "No flights exist with the given flight number");
            // redirectAttributes.addFlashAttribute("errorMessage", );
            return "redirect:/index?error";
        }
        
        alert.setFlightToTrack(flightOptional.get());
		User currentUser = ((MyUserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		alert.setSetBy(currentUser);

		int rowsAffected = jdbcTemplate.update(
			"INSERT INTO alert (communication_preference, flight_to_track_id, set_by_id) VALUES (?,?,?)",
			alert.getCommunicationPreference(), alert.getFlightToTrack().getId(), alert.getSetBy().getId()
		);

		System.out.println("updated " + rowsAffected + " rows.");
		return (rowsAffected == 0) ? "redirect:/index?error" : "redirect:/index?success";
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
        List<Flight> flights = flightService.findAllFlights();
        model.addAttribute("flights", flights);
        model.addAttribute("flight", new Flight());
        return "flight";
    }

    @GetMapping("/search")
    public String openSearch(Model model)
    {
        model.addAttribute("flight", new Flight());
        return "search";
    }

    @PostMapping("/search")
    public ModelAndView submitSearch(Model model, @ModelAttribute("flight") Flight flight)
    {
        ModelAndView modelAndView = new ModelAndView();
        List<Flight> unorderedSuccessfulSearches = flightRepository.findAllByDepartsFromAirportCodeAndArrivesAtAirportCode
        (flight.getDepartsFromAirportCode(), flight.getArrivesAtAirportCode());
        TreeSet<Flight> orderedSuccessfulSearches = new TreeSet<>(unorderedSuccessfulSearches);
        modelAndView.addObject("flights", orderedSuccessfulSearches);
        modelAndView.setViewName("search_results");
        return modelAndView;
    }
    
    @PostMapping("/editFlight")
    public String editFlight(@ModelAttribute("flight") Flight flight) {
        Flight existingFlight = flightRepository.findById(flight.getId()).get();
        existingFlight.setPrice(flight.getPrice());
        flightRepository.save(existingFlight);
        return "redirect:/flight?editSuccess";
    }

    @PostMapping("/deleteFlight")
    public String deleteFlight(@ModelAttribute("flight") Flight flight) {
        flightRepository.deleteById(flight.getId());
        return "redirect:/flight?deleteSuccess";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("user") User user) {
        userRepo.deleteById(user.getId());
        return "redirect:/users?deleteSuccess";
    }
    
    @GetMapping("/addFlight")
    public String addFlight(Model model){
        Flight flight = new Flight();
        model.addAttribute("flight", flight);
        return "addFlight";
    }

    @PostMapping("/saveFlight")
    public String saveFlight(@ModelAttribute("flight") Flight flight, Model model)
    {
        System.out.println(flight);
        flightService.saveFlight(flight);
        return "redirect:/addFlight?success";
    }
}