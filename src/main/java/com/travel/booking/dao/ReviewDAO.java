package com.travel.booking.dao;

import com.travel.booking.dto.Review;

public interface ReviewDAO {
	
	public void addFlightReview(Review review);
	
	public void addRentalCarReview(Review review);
	
	public void addHotelReview(Review review);

}
