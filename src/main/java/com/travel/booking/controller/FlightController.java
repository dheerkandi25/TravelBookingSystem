package com.travel.booking.controller;

import com.travel.booking.dto.Flight;
import com.travel.booking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/searchFlights")
    public List<Flight> searchFlights(@RequestParam("origin") String origin,
                                      @RequestParam("destination") String destination,@RequestParam("date") String date) throws ParseException {
        return flightService.searchFlights(origin, destination,date);
    }

    @PostMapping("/bookFlight")
    public void bookFlight(@RequestParam("flightId") String flightId,
                           @RequestParam("userId") String userId, @RequestParam("date") String bookingDate) throws ParseException {
        flightService.bookFlight(flightId, userId, bookingDate);
    }
    @PostMapping("/addFlight")
    public void addFlight(@RequestBody Flight flight) throws IOException {
        flightService.addFlight(flight);
    }

    @GetMapping("/getFlightBookings")
    public List<Flight> getFlightBookings(@RequestParam("customerId") String customerId) {
        return flightService.getBookings(customerId);
    }
}