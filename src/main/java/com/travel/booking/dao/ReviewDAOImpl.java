package com.travel.booking.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;


import com.travel.booking.dto.Review;

@Component
public class ReviewDAOImpl implements ReviewDAO{
	
	//Hardcoded value for testing 
		private List<Review> customerReview=new ArrayList<>(Arrays.asList(
	            new Review("32fdfdf", "user1", "good", 4, "Flight","C001"))
	        );
		

	@Override
	public void addFlightReview(Review review) {
		// TODO Code to get total review for the respective Flight from DB and calculate average and update in DB
		customerReview.add(review);
		
		
	}

	@Override
	public void addRentalCarReview(Review review) {
		// TODO Code to get total review for the respective Rental Car from DB and calculate average and update in DB
				customerReview.add(review);
		
	}

	@Override
	public void addHotelReview(Review review) {
		// TODO Code to get total review for the respective Hotel from DB and calculate average and update in DB
				customerReview.add(review);
		
	}

}
