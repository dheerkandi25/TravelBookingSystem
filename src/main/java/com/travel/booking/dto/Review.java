package com.travel.booking.dto;

public class Review {
    private String reviewId;
    private String customerId;
    private String bookingId;
    private String comment;
    private int rating;
    private String serviceType; // "Flight", "Hotel", "CarRental"
    

    public Review(String reviewId, String customerId, String comment, int rating, String serviceType,String bookingId) {
		super();
		this.reviewId = reviewId;
		this.customerId = customerId;
		this.comment = comment;
		this.rating = rating;
		this.serviceType = serviceType;
		this.bookingId=bookingId;
	}

	// Getters and Setters

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

   
}
