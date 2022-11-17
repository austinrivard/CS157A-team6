package edu.sjsu.team6.flightfinder.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // private String alertType;

    private String communicationPreference;

    @ManyToOne
    private User setBy;

    @ManyToOne
    private Flight flight;
}
