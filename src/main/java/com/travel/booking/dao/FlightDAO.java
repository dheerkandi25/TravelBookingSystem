package com.travel.booking.dao;

import com.travel.booking.dto.Flight;
import com.travel.booking.dto.FlightAvailability;
import com.travel.booking.dto.FlightBooking;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FlightDAO {

    public Optional<FlightAvailability> getFlightAvailability(String flightId, Date date);

    public void bookFlight(String flightId, String customerId, Date bookingDate);

    public List<Flight> getFlightsByDate(String source, String destination,Date date);

    public void addFlight(Flight flight);

    public List<FlightBooking> getFlightBookings(String customerId);

    public Flight getFlightById(String flightId);


}
