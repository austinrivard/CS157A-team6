package edu.sjsu.team6.flightfinder.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;


@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String flightNumber;

    private String name;

    private LocalDateTime departureTime, arrivalTime;

    @ManyToOne
    private Airport departsFrom, arrivesAt;

    @ManyToOne
    private Airline airline;

    @OneToMany(mappedBy = "flight")
    private List<Zone> zones;

    @OneToMany(mappedBy = "flight")
    private List<Alert> alerts;
}
