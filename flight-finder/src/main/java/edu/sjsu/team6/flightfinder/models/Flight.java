package edu.sjsu.team6.flightfinder.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String flightNumber;

    private String name;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @ManyToOne
    private Airport departsFrom;
    @ManyToOne
    private Airport arrivesAt;

    @ManyToOne
    private Airline airline;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<Zone> zones;

    @OneToMany(mappedBy = "flightToTrack", fetch = FetchType.LAZY)
    private List<Alert> alerts;

    private String departsFromAirportCode;
    private String arrivesAtAirportCode;
    private double price;
}
