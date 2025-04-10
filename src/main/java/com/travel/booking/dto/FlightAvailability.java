package com.travel.booking.dto;

import java.util.Date;
import java.util.Map;

public class FlightAvailability {
    private String flightId;
    private Map<Date, Integer> availableSeats;
    // Constructor
    public FlightAvailability(String flightId, Map<Date, Integer> availableSeats) {
        this.flightId = flightId;
        this.availableSeats = availableSeats;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Map<Date, Integer> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Map<Date, Integer> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
