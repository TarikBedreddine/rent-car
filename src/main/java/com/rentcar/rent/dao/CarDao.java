package com.rentcar.rent.dao;


import java.util.List;

import com.rentcar.rent.model.Car;

public interface CarDao {
	
	public List<Car> findAll();
	public Car CarfindById(int id);
	public void Carsave(Car car);
	public void Cardelete(int carId);
	public void updateCar(int carId, Car updatedCar);
}
