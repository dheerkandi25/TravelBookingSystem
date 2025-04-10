package com.travel.booking.dto;

import java.util.Date;

public class FlightBooking {
    private Integer flightBookingId;
    private String flightId;
    private String customerId;

    //constructor
    public FlightBooking(Integer flightBookingId, String flightId, String customerId, Date bookingDate) {
        this.flightBookingId = flightBookingId;
        this.flightId = flightId;
        this.customerId = customerId;
        this.bookingDate = bookingDate;
    }
    public Integer getFlightBookingId() {
        return flightBookingId;
    }

    public void setFlightBookingId(Integer flightBookingId) {
        this.flightBookingId = flightBookingId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    private Date bookingDate;
}
