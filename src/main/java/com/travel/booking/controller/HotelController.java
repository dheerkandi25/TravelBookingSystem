package com.travel.booking.controller;

import com.travel.booking.dto.Hotel;
import com.travel.booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/Hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getHotels(@RequestParam(required = false) String city) {
        if (city != null && !city.isEmpty()) {
            return hotelService.getHotelsByCity(city);
        }
        return hotelService.getAllHotels();
    }

    @PostMapping("/bookings")
    public String bookHotel(@RequestBody Hotel hotel) {
        return hotelService.bookHotel(hotel);
    }
}
