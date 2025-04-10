package com.travel.booking.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.travel.booking.dto.RentalCar;
import com.travel.booking.dto.RentalCarBooking;

@Component
public class RentalCarBookingDAOImpl implements RentalCarBookingDAO{
	
	//Hardcoded value for testing 
	private List<RentalCarBooking> rentalCarsBooking=new ArrayList<>(Arrays.asList(
            new RentalCarBooking(new RentalCar("C001", null, null, "Bangalore", 0, 0, 0),new Date(System.currentTimeMillis()), "user1"))
        );

	@Override
	public List<RentalCarBooking> getBooking(String location,Date bookedDate) {
		
		return rentalCarsBooking.stream().filter(bookedCar->
		((bookedDate.toLocalDate().compareTo(bookedCar.getBookingDate().toLocalDate()))==0 && bookedCar.getRentalCar().getLocation().equalsIgnoreCase(location)))
				.collect(Collectors.toList());
	}

	@Override
	public void addBooking(String rentalCarId,String location, Date date, String userId) {
		rentalCarsBooking.add(new RentalCarBooking(new RentalCar(rentalCarId, null, null, location, 0, 0, 0),date,userId));
		
	}

}
