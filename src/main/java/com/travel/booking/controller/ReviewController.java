package com.travel.booking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.booking.dto.Review;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
	
	@PostMapping("/add")
	public void provideReview(@Valid @RequestBody Review request) {
		
		
		
	}

}
