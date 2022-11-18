package edu.sjsu.team6.flightfinder.models;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String seatNumber;

    private boolean isExitRow;

    @ManyToOne
    private Zone zone;
}
