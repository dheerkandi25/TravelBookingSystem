package com.travel.booking.dao;

import java.sql.Date;
import java.util.List;

import com.travel.booking.dto.RentalCarBooking;

public interface RentalCarBookingDAO {
	
	public List<RentalCarBooking> getBooking(String location,Date bookedDate);
	
	public void addBooking(String rentalCarId,String location, Date date, String userId);

}
