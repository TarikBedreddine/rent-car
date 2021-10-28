package com.rentcar.rent.dao;


import java.util.List;

import com.rentcar.rent.model.Car;
import com.rentcar.rent.model.CarList;

public interface CarDao {
	
	public List<Car> findAll();
	public Car CarfindById(int id);
	public Car Carsave(Car car);
	public boolean Cardelete(int carId);
	public void updateCar(int carId, Car updatedCar);
}
