package edu.sjsu.team6.flightfinder.models;

import javax.persistence.*;

import org.springframework.data.annotation.Transient;

import lombok.Data;

@Entity
@Data
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // private String alertType;

    private String communicationPreference;

    @Transient
    private String flightNumber;

    @ManyToOne
    private User setBy;

    @ManyToOne
    private Flight flightToTrack;
}
