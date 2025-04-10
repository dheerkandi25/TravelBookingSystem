package com.travel.booking.dto;


public class RentalCar {
    private String rentalId;
    private String company;
    private String carModel;
    private String location;
    private double pricePerDay;
    private int capacity;
    private float rating;
    
    public RentalCar(String rentalId, String company, String carModel,String location, double pricePerDay, int capacity,
			 float rating) {
		super();
		this.rentalId = rentalId;
		this.company = company;
		this.carModel = carModel;
		this.location=location;
		this.pricePerDay = pricePerDay;
		this.capacity = capacity;
		this.rating = rating;
	}

	public RentalCar() {
		super();
		
	}



	public String getRentalId() {
        return rentalId;
    }

    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
