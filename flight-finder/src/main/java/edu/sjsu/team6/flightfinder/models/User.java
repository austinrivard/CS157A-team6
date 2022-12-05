package edu.sjsu.team6.flightfinder.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Formula;

import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private String cPassword;

    @Formula("concat_ws(' ', first_name, last_name)")
    private String name;

    private String firstName;

    private String lastName;

    private String gender;

    private LocalDate dob;

    private String mobileNumber;

    private String city;

    private String state;

    private String zipCode;

    @Formula("CONCAT(city, ', ', state, ' ', zip_code)")
    private String address;

    @OneToMany(mappedBy = "searchedBy", fetch = FetchType.LAZY)
    private List<Itinerary> itineraries;

    @OneToMany(mappedBy = "setBy", fetch = FetchType.LAZY)
    private List<Alert> alerts;
}
