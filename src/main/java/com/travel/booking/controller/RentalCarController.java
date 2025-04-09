package com.travel.booking.controller;

import com.travel.booking.dto.RentalCar;
import com.travel.booking.service.RentalCarBookingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/rental-cars")
public class RentalCarController {

    @Autowired
    private RentalCarBookingService rentalCarBookingService;

    @GetMapping("/available")
    public List<RentalCar> getAvailableRentalCars(
            @RequestParam("location") @NotBlank String location,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate) {
    	if(bookingDate.compareTo(new Date(System.currentTimeMillis()).toLocalDate())<0) {
    	 throw new RuntimeException("Date cannot be in past");
    	}
    	return rentalCarBookingService.getAvailableRentalCars(location, Date.valueOf(bookingDate));
    }

    @PostMapping("/book")
    public void bookRentalCar(
            @RequestParam("rentalCarId") @NotBlank String rentalCarId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate) {
        rentalCarBookingService.bookRentalCars(rentalCarId, Date.valueOf(bookingDate));
    }

    @PostMapping("/add")
    public void addRentalCar(@Valid @RequestBody RentalCar request) {
        rentalCarBookingService.addRentalCars(
        		request
        );
    }
}
