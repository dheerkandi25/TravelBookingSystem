package com.travel.booking.service;

import com.travel.booking.dto.Hotel;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class HotelService {

    private final List<Hotel> hotelList = new ArrayList<>();

    public HotelService() {
        // Dummy data initialization
        hotelList.add(createHotel("BLR101", "The Gardenia Grand", "MG Road, Bangalore", 3200.75, 12, 4.3f, "Executive Deluxe"));
        hotelList.add(createHotel("BLR102", "Silicon City Suites", "Electronic City, Bangalore", 2800.00, 8, 4.1f, "Superior Room"));
        hotelList.add(createHotel("BLR103", "Royal Orchid", "Old Airport Road, Bangalore", 4100.50, 5, 4.5f, "Premium King"));

        hotelList.add(createHotel("MUM201", "Sea Breeze Residency", "Juhu Tara Road, Mumbai", 4800.00, 7, 4.6f, "Sea View Suite"));
        hotelList.add(createHotel("MUM202", "The Gateway Mumbai", "Colaba, Mumbai", 5300.00, 4, 4.8f, "Luxury Heritage Room"));
        hotelList.add(createHotel("MUM203", "Palm Grove Hotel", "Bandra West, Mumbai", 3100.00, 10, 4.2f, "Deluxe Queen"));

        hotelList.add(createHotel("DEL301", "Capitol Heights Hotel", "Connaught Place, Delhi", 3900.50, 9, 4.4f, "Premium King"));
        hotelList.add(createHotel("DEL302", "Red Fort Residency", "Chandni Chowk, Delhi", 2700.00, 6, 4.0f, "Standard Room"));
        hotelList.add(createHotel("DEL303", "The Imperial Delhi", "Janpath Lane, Connaught Place, Delhi", 6100.00, 3, 4.9f, "Heritage Suite"));
    }

    private Hotel createHotel(String id, String name, String address, double price, int availability, float rating, String type) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(id);
        hotel.setHotelName(name);
        hotel.setAddress(address);
        hotel.setPricePerNight(price);
        hotel.setRoomAvailability(availability);
        hotel.setRating(rating);
        hotel.setRoomType(type);
        return hotel;
    }

    public List<Hotel> getAllHotels() {
        return hotelList;
    }

    public List<Hotel> getHotelsByCity(String city) {
        return hotelList.stream()
                .filter(h -> h.getAddress().toLowerCase().contains(city.toLowerCase()))
                .collect(Collectors.toList());
    }

    public String bookHotel(Hotel hotelRequest) {
        Optional<Hotel> hotelOpt = hotelList.stream()
                .filter(h -> h.getHotelName().equalsIgnoreCase(hotelRequest.getHotelName()))
                .findFirst();

        if (hotelOpt.isEmpty()) {
            return "Hotel not found: " + hotelRequest.getHotelName();
        }

        Hotel hotel = hotelOpt.get();

        if (hotel.getRoomAvailability() < hotelRequest.getRoomCount()) {
            return "Not enough rooms available at " + hotel.getHotelName() +
                    ". Only " + hotel.getRoomAvailability() + " room(s) left.";
        }

        hotel.setRoomAvailability(hotel.getRoomAvailability() - hotelRequest.getRoomCount());

        return "Booking confirmed at " + hotel.getHotelName() + " for " +
                hotelRequest.getRoomCount() + " room(s).";
    }
}

