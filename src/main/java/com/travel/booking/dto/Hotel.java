package com.travel.booking.dto;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String hotelId;
    private String hotelName;
    private String address;
    private double pricePerNight;
    private Map<String, Integer> roomAvailabilityByDate = new HashMap<>();
    private float rating;
    private String roomType;
    private int roomCount;
    private String bookingDate;


    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Map<String, Integer> getRoomAvailabilityByDate() {
        return roomAvailabilityByDate;
    }

    public void setRoomAvailabilityByDate(Map<String, Integer> roomAvailabilityByDate) {
        this.roomAvailabilityByDate = roomAvailabilityByDate;
    }
    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }



    // Getters and Setters
}
