package edu.sjsu.team6.flightfinder.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;

    private String websiteUrl;

    private String contactNumber;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;
}
