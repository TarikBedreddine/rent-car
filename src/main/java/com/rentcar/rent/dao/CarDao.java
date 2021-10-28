package com.rentcar.rent.dao;


import com.rentcar.rent.model.Car;
import com.rentcar.rent.model.CarList;

public interface CarDao {
	
	public CarList findAll();
	public Car CarfindById(int id);
	public Car Carsave(Car car);
	public void Cardelete(int carId);
	public void updateCar(int carId, Car updatedCar);
}
