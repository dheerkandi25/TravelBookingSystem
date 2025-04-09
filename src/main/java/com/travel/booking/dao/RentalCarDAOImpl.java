package com.travel.booking.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.travel.booking.dto.RentalCar;

@Component
public class RentalCarDAOImpl implements RentalCarDAO {
	
	//Hardcoded values for trsting
		private List<RentalCar> rentalCars=new ArrayList<>(Arrays.asList(
	            new RentalCar("C001", "ZoomCar","Honda","Bangalore",25,5,4.5F),
	            new RentalCar("C002", "Ola","Tata","Mumbai",23,5,4.7F),
	            new RentalCar("C003", "Uber","Maruti","Delhi",21,7,4.2F),
	            new RentalCar("1a2b3c", "Hertz", "Toyota Camry", "Bangalore", 55.0, 5, 4.5f),
	            new RentalCar("2b3c4d", "Avis", "Honda Accord", "Mumbai", 60.0, 5, 4.3f),
	            new RentalCar("3c4d5e", "Enterprise", "Chevrolet Malibu", "Delhi", 52.0, 5, 4.2f)
	        ));
	
    @Override
    public List<RentalCar> getRentalCars(String location) {
    	
        return rentalCars.stream().filter(car->car.getLocation().
        		equalsIgnoreCase(location)).collect(Collectors.toList());
    }

	@Override
	public void addRentalCar(RentalCar rentalCar) {
		rentalCars.add(rentalCar);
		
	}

	@Override
	public RentalCar getRentalCarsById(String id) {
		
		return rentalCars.stream().filter(cars->cars.getRentalId().equalsIgnoreCase(id)).findFirst().orElseGet(null);
	}
}
