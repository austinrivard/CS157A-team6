package edu.sjsu.team6.flightfinder.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime departureTime, arrivalTime;

    @ManyToOne
    private User searchedBy;

    @ManyToOne
    private Airport departsFrom, arrivesAt;
}
