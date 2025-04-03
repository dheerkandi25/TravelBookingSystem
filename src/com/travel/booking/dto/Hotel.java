package com.travel.booking.dto;

public class Hotel {
    private String hotelId;
    private String hotelName;
    private String address;
    private double pricePerNight;
    private Integer roomAvailability;
    private float rating;
    private String roomType;

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

    public Integer getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(Integer roomAvailability) {
        this.roomAvailability = roomAvailability;
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
