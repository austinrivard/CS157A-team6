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

    private String price;

    private LocalDateTime departureTime, arrivalTime;

    @ManyToOne
    private Airport departsFrom, arrivesAt;

    @ManyToOne
    private Airline airline;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Zone> zones;

    @OneToMany(mappedBy = "flightToTrack", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alert> alerts;
}
