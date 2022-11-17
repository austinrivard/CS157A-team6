package edu.sjsu.team6.flightfinder.models;

import javax.persistence.*;

import org.hibernate.annotations.Formula;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private String city;

    private String state;

    private String zipCode;

    @Formula("CONCAT(city, ', ', state, ' ', zipCode)")
    private String address;


}
