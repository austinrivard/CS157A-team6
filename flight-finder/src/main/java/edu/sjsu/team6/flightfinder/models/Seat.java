package edu.sjsu.team6.flightfinder.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String seatNumber;

    private boolean isExitRow;

    @ManyToOne
    private Zone zone;
}
