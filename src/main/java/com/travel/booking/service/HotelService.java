package com.travel.booking.service;

import com.travel.booking.dto.Hotel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

@Service
public class HotelService {

    private final List<Hotel> hotelList = new ArrayList<>();

    public HotelService() {
        String today = java.time.LocalDate.now().toString();

        hotelList.add(createHotel("BLR101", "The Gardenia Grand", "MG Road, Bangalore", 3200.75, 4.3f, "Executive Deluxe", today, 10));
        hotelList.add(createHotel("BLR102", "Silicon City Suites", "Electronic City, Bangalore", 2800.00, 4.1f, "Superior Room", today, 8));
        hotelList.add(createHotel("BLR103", "Royal Orchid", "Old Airport Road, Bangalore", 4100.50, 4.5f, "Premium King", today, 5));

        hotelList.add(createHotel("MUM201", "Sea Breeze Residency", "Juhu Tara Road, Mumbai", 4800.00, 4.6f, "Sea View Suite", today, 7));
        hotelList.add(createHotel("MUM202", "The Gateway Mumbai", "Colaba, Mumbai", 5300.00, 4.8f, "Luxury Heritage Room", today, 4));
        hotelList.add(createHotel("MUM203", "Palm Grove Hotel", "Bandra West, Mumbai", 3100.00, 4.2f, "Deluxe Queen", today, 10));

        hotelList.add(createHotel("DEL301", "Capitol Heights Hotel", "Connaught Place, Delhi", 3900.50, 4.4f, "Premium King", today, 9));
        hotelList.add(createHotel("DEL302", "Red Fort Residency", "Chandni Chowk, Delhi", 2700.00, 4.0f, "Standard Room", today, 6));
        hotelList.add(createHotel("DEL303", "The Imperial Delhi", "Janpath Lane, Connaught Place, Delhi", 6100.00, 4.9f, "Heritage Suite", today, 3));
    }


    private Hotel createHotel(String id, String name, String address,
                              double price, float rating, String type,
                              String date, int rooms) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(id);
        hotel.setHotelName(name);
        hotel.setAddress(address);
        hotel.setPricePerNight(price);
        hotel.setRating(rating);
        hotel.setRoomType(type);

        // Set availability by date
        Map<String, Integer> availabilityMap = new HashMap<>();
        availabilityMap.put(date, rooms);
        hotel.setRoomAvailabilityByDate(availabilityMap);

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

        String bookingDate = hotelRequest.getBookingDate();
        if (bookingDate == null || bookingDate.isBlank()) {
            bookingDate = java.time.LocalDate.now().toString(); // default to today
        }

        int requestedRooms = hotelRequest.getRoomCount();

        // Check current availability for that date
        int available = hotel.getRoomAvailabilityByDate().getOrDefault(bookingDate, 10); // default to 10 if not set

        if (available < requestedRooms) {
            return "Not enough rooms available at " + hotel.getHotelName() +
                    " on " + bookingDate + ". Only " + available + " room(s) left.";
        }

        // Reduce availability
        hotel.getRoomAvailabilityByDate().put(bookingDate, available - requestedRooms);

        return " Booking confirmed at " + hotel.getHotelName() +
                " for " + requestedRooms + " room(s) on " + bookingDate + ".";
    }


    public String addHotel(Hotel newHotel) {
        boolean alreadyExists = hotelList.stream()
                .anyMatch(h -> h.getHotelName().equalsIgnoreCase(newHotel.getHotelName()));

        if (alreadyExists) {
            return "Hotel already exists: " + newHotel.getHotelName();
        }

        hotelList.add(newHotel);
        return "✅ Hotel added successfully: " + newHotel.getHotelName();
    }

}

//http://localhost:8080/api/hotels?city=Delhi searchbycity
//{
//        "hotelId": "BLR104",
//        "hotelName": "Blue Lagoon Inn",
//        "address": "Indiranagar, Bangalore, Karnataka",
//        "pricePerNight": 3400.00,
//        "roomAvailability": 10,
//        "rating": 4.3,
//        "roomType": "Deluxe King",
//        "roomCount": 0
//        }  add hotel

//{
//        "hotelName": "Royal Orchid",
//        "roomCount": 2
//        } book hotel


