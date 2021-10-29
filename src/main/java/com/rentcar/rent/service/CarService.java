package com.rentcar.rent.service;

import java.util.List;
import java.util.Optional;

import com.rentcar.rent.model.Car;

public interface CarService {
	
	public List<Car> getAllCars();
	public Car getOneCar(int carId);
	public Car saveCar(Car car);
	public void deleteOneCar(int carId);
	public void updateOneCar(int carId, Car updatedCar);
}
