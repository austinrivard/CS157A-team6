package edu.sjsu.team6.flightfinder.models;

import java.util.Date;

public class FlightInstance
{
    private Date departureTime;
    private String gate;
    private FlightStatus status;
    private Aircraft aircraft;

    public boolean cancel() { return true; }
    public void updateStatus(FlightStatus status) {}
}
