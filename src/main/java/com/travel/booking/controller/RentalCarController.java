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

    /**
     * endpoint to get available rental cars for a location and date
     * 
     * @param location
     * @param bookingDate
     * @return
     */
    @GetMapping("/available")
    public List<RentalCar> getAvailableRentalCars(
            @RequestParam("location") @NotBlank String location,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate) {
    	if(bookingDate.compareTo(new Date(System.currentTimeMillis()).toLocalDate())<0) {
    	 throw new RuntimeException("Date cannot be in past");
    	}
    	return rentalCarBookingService.getAvailableRentalCars(location, Date.valueOf(bookingDate));
    }

    /**
     * 
     * endpoint to book an available rental car by providing below details
     * @param rentalCarId
     * @param bookingDate
     * @param userId
     */
    @PostMapping("/book")
    public String bookRentalCar(
            @RequestParam("rentalCarId") @NotBlank String rentalCarId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
            @RequestParam("customerId") String customerId) {
        return rentalCarBookingService.bookRentalCars(rentalCarId, Date.valueOf(bookingDate),customerId);
    }

    /**
     * 
     * Admin can add a new rental car for a location by providing all required details 
     * 
     * @param request
     */
    @PostMapping("/admin/add")
    public void addRentalCar(@Valid @RequestBody RentalCar request) {
        rentalCarBookingService.addRentalCars(
        		request
        );
    }
}
