package com.travel.booking.dao;

import com.travel.booking.dto.Flight;
import com.travel.booking.dto.FlightAvailability;
import com.travel.booking.dto.FlightBooking;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class FlightDAOImpl implements FlightDAO{

    private List<FlightAvailability> flightAvailabilities = new ArrayList<>(List.of(
            new FlightAvailability("FL123",
                    new HashMap<>(Map.of(parseDate("05/02/2025"), 20, parseDate("05/03/2025"), 15, parseDate("05/04/2025"), 10))),
            new FlightAvailability("FL456",
                    new HashMap<>(Map.of(parseDate("05/02/2025"), 25, parseDate("05/03/2025"), 18, parseDate("05/04/2025"), 12))),
            new FlightAvailability("FL789",
                    new HashMap<>(Map.of(parseDate("05/02/2025"), 30, parseDate("05/03/2025"), 20, parseDate("05/04/2025"), 15))),
            new FlightAvailability("FL101",
                    new HashMap<>(Map.of(parseDate("05/02/2025"), 10, parseDate("05/03/2025"), 8, parseDate("05/04/2025"), 5)))

    ));

    private List<FlightBooking> flightBookings =new ArrayList<>();

    private List<Flight> flights = new ArrayList<>(List.of(
            new Flight("FL123", "Airways International", "New York", "Los Angeles", 4.5f, 20, parseDate("05/02/2025"), parseDate("05/02/2025")),
            new Flight("FL456", "Skyline Airlines", "Chicago", "San Francisco", 4.2f, 25, parseDate("05/03/2025"), parseDate("05/03/2025")),
            new Flight("FL789", "Global Air", "Miami", "Houston", 4.8f, 30, parseDate("05/04/2025"), parseDate("05/04/2025")),
            new Flight("FL101", "Pacific Wings", "Seattle", "Denver", 4.0f, 10, parseDate("05/02/2025"), parseDate("05/02/2025"))
    ));

    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + dateString, e);
        }
    }

    @Override
    public Optional<FlightAvailability> getFlightAvailability(String flightId, Date date) {
        return flightAvailabilities.stream().filter(flight ->flight.getFlightId().equalsIgnoreCase(flightId) && flight.getAvailableSeats().get(date)>0).findFirst();
    }

    @Override
    public void bookFlight(String flightId, String customerId, Date bookingDate) {
        // Check if the flight is available on the specified date
        Optional<FlightAvailability> flightAvailability = flightAvailabilities.stream()
                .filter(flight -> flight.getFlightId().equalsIgnoreCase(flightId) && flight.getAvailableSeats().get(bookingDate)>0)
                .findFirst();
        if (flightAvailability.isEmpty()) {
            throw new RuntimeException("Flight not available on the selected date.");
        }

        flightAvailabilities.stream()
                .filter(flight -> flight.getFlightId().equalsIgnoreCase(flightId))
                .findFirst()
                .ifPresent(flight -> {
                    if(flight.getAvailableSeats().get(bookingDate)>0) {
                        flight.getAvailableSeats().compute(bookingDate, (k, availableSeats) -> availableSeats - 1);
                    }
                    else {
                        throw new RuntimeException("No available seats for this flight on the selected date.");
                    }
                });
        flightBookings.add(new FlightBooking(UUID.randomUUID().hashCode(),flightId, customerId, bookingDate));

    }

    @Override
    public List<Flight> getFlightsByDate(String source, String destination, Date date) {
        return flights.stream().filter(flight -> flight.getOrigin().equalsIgnoreCase(source) &&
                flight.getDestination().equalsIgnoreCase(destination) &&
                flight.getDepartureTime().compareTo(date)==0)
                .collect(Collectors.toList());
    }

    @Override
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public List<FlightBooking> getFlightBookings(String customerId) {
        return flightBookings.stream().filter(booking -> booking.getCustomerId().equalsIgnoreCase(customerId))
                .collect(Collectors.toList());
    }

    @Override
    public Flight getFlightById(String flightId) {
        return flights.stream().filter(flight -> flight.getFlightId().equalsIgnoreCase(flightId))
                .findFirst()
                .orElse(null);

    }

}
