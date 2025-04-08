package com.travel.booking.dto;

import java.util.List;

public class Booking {
    private String bookingId;
    private float cost;
    private Customer customer;
    private List<Flight> flights;
    private List<Hotel> hotels;
    private List<RentalCar> rentalCars;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<RentalCar> getRentalCars() {
        return rentalCars;
    }

    public void setRentalCars(List<RentalCar> rentalCars) {
        this.rentalCars = rentalCars;
    }



    // Getters and Setters
}
