package com.travel.booking.dao;

import java.sql.Date;
import java.util.List;

import com.travel.booking.dto.RentalCar;

public interface RentalCarDAO {
    List<RentalCar> getRentalCars(String location);
    
    RentalCar getRentalCarsById(String id);
    
    void addRentalCar(RentalCar rentalCar);
}
