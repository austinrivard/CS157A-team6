package edu.sjsu.team6.flightfinder.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String classType;

    private String fare;

    @ManyToOne
    private Flight flight;

    @OneToMany(mappedBy = "zone")
    private List<Seat> seats;
}
