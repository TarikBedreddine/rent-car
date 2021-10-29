package com.rentcar.rent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.rent.dao.CarDao;
import com.rentcar.rent.model.Car;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarDao carDao;

	@Override
	public List<Car> getAllCars() {
		return carDao.findAll();
	}

	@Override
	public Car getOneCar(int carId) {
		return carDao.findCarById(carId);
	}

	@Override
	public Car saveCar(Car car) {
		return carDao.saveAndFlush(car);
	}

	@Override
	public void deleteOneCar(int carId) {
		carDao.delete(this.getOneCar(carId));
	}

	@Override
	public void updateOneCar(int carId, Car updatedCar) {
		updatedCar.setId(carId);
		carDao.saveAndFlush(updatedCar);
	}
}
