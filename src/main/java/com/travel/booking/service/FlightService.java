package com.travel.booking.service;

import com.travel.booking.dao.FlightDAOImpl;
import com.travel.booking.dto.Flight;
import com.travel.booking.dto.FlightBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightDAOImpl flightDAO;
    // Method to search for flights based on origin, destination, and departure date
    public List<Flight> searchFlights(String origin, String destination,String date) throws ParseException {
       Date bookingDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
       return flightDAO.getFlightsByDate(origin, destination, bookingDate);
    }

    // Method to book a flight
    public void bookFlight(String flightId, String userId, String bookingDate) throws ParseException{
        Date date=new SimpleDateFormat("MM/dd/yyyy").parse(bookingDate);
        flightDAO.bookFlight(flightId, userId, date);
    }

    public void addFlight(Flight flight)  {
        flightDAO.addFlight(flight);
    }

    public List<Flight> getBookings(String customerId) {
    	List<FlightBooking> flightBookings=flightDAO.getFlightBookings(customerId);

        return flightBookings.stream().map(flightBooking->{
            return flightDAO.getFlightById(flightBooking.getFlightId());
        }).collect(Collectors.toList());
    }
}