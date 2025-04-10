package com.travel.booking.service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.travel.booking.dao.RentalCarBookingDAO;
import com.travel.booking.dao.RentalCarDAO;
import com.travel.booking.dto.RentalCar;
import com.travel.booking.dto.RentalCarBooking;

@Component
public class RentalCarBookingService {

	@Autowired
	public RentalCarDAO rentalCarDao;
	
	@Autowired
	public RentalCarBookingDAO rentalCarBooking;
	
	public List<RentalCar> getAvailableRentalCars(String location, Date date){
		
		List<RentalCar> allRentalCars=rentalCarDao.getRentalCars(location);
		List<RentalCarBooking> bookedCars=rentalCarBooking.getBooking(location, date);		
		
		return allRentalCars.stream().filter(availableCars->{
			
			if(!CollectionUtils.isEmpty(bookedCars)) {
				return !bookedCars.stream().anyMatch(bookedCar->bookedCar.getRentalCar().getRentalId().equalsIgnoreCase(availableCars.getRentalId()));
			}else {
				return true;
			}			
			
		}).collect(Collectors.toList());
		
	}
	
	public void bookRentalCars(String rentalCarId, Date date, String userId) {
		String location=rentalCarDao.getRentalCarsById(rentalCarId).getLocation();
		if(location==null) {
			throw new RuntimeException("Invaid id");
		}
		rentalCarBooking.addBooking(rentalCarId,location, date, userId);
		
	}
	
	public void addRentalCars(RentalCar rentalCar) {
		rentalCar.setRentalId(UUID.randomUUID().toString());
		rentalCarDao.addRentalCar(rentalCar);
	}
}	