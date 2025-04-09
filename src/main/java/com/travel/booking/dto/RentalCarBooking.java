package com.travel.booking.dto;

import java.sql.Date;

public class RentalCarBooking {

	private RentalCar rentalCar;
	
	private Date bookingDate;

	public RentalCar getRentalCar() {
		return rentalCar;
	}

	public void setRentalCar(RentalCar rentalCar) {
		this.rentalCar = rentalCar;
	}

	public RentalCarBooking(RentalCar rentalCar, Date bookingDate) {
		super();
		this.rentalCar = rentalCar;
		this.setBookingDate(bookingDate);
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
	
	
}
