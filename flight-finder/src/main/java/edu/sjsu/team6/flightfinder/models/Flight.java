package edu.sjsu.team6.flightfinder.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude={"zones", "alerts"})
@Table(name="flight")
public class Flight implements Comparable<Flight> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String flightNumber;

    private String name;

    private String price;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime departureTime, arrivalTime;

    @ManyToOne
    private Airport departsFrom;
    @ManyToOne
    private Airport arrivesAt;

    @ManyToOne
    private Airline airline;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Zone> zones;

    @OneToMany(mappedBy = "flightToTrack", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alert> alerts;

    private String departsFromAirportCode;
    private String arrivesAtAirportCode;

    public int compareTo(Flight other)
    {
        return this.departureTime.compareTo(other.departureTime);
    }
}
