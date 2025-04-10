package com.travel.booking.dto;

import java.sql.Date;

public class RentalCarBooking {

	private RentalCar rentalCar;
	
	private Date bookingDate;
	
	private String userId;

	public RentalCar getRentalCar() {
		return rentalCar;
	}

	public void setRentalCar(RentalCar rentalCar) {
		this.rentalCar = rentalCar;
	}

	public RentalCarBooking(RentalCar rentalCar, Date bookingDate, String userId) {
		super();
		this.rentalCar = rentalCar;
		this.setBookingDate(bookingDate);
		this.userId=userId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
}
