package com.travel.booking.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.booking.dao.ReviewDAO;
import com.travel.booking.dto.Review;

@Component
public class ReviewService {
	
	@Autowired
	private ReviewDAO reviewDao;

	public void addReview(Review review) {
		
		review.setBookingId(UUID.randomUUID().toString());
		
		if (review.getServiceType().equalsIgnoreCase("RentalCar")){
			reviewDao.addRentalCarReview(review);
			
		}else if (review.getServiceType().equalsIgnoreCase("Flight")) {
			
			reviewDao.addFlightReview(review);
			
		}else {
			
			reviewDao.addHotelReview(review);
		}
		
	}
	
	
}
