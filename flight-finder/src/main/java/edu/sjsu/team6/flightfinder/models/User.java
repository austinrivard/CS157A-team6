package edu.sjsu.team6.flightfinder.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Formula;

@Entity
public class User {
    @Id
    private String username;

    @Formula("concat_ws(' ', firstName, lastName)")
    private String name;

    private String firstName;

    private String lastName;

    private String gender;

    private LocalDate dob;

    private String mobileNumber;

    private String city;

    private String state;

    private String zipCode;

    @Formula("CONCAT(city, ', ', state, ' ', zipCode)")
    private String address;

    @OneToMany(mappedBy = "searchedBy")
    private List<Itinerary> itineraries;

    @OneToMany(mappedBy = "setBy")
    private List<Alert> alerts;
}
