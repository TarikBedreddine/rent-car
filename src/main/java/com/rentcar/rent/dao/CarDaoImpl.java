package com.rentcar.rent.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rentcar.rent.model.Car;
import com.rentcar.rent.model.CarList;



@Repository
public class CarDaoImpl implements CarDao {
	private List<Car> cars = new ArrayList<>();
	
	public CarDaoImpl() {
		cars.add(new Car(1, new String("Ferrari"), new String("Rouge"), 100000, "XD-125-FR"));
		cars.add(new Car(2, new String("Clio"), new String("Noir"), 20, "ZZ-154-SS"));
		cars.add(new Car(3, new String("Mercedes"), new String("Magenta"), 150000, "LH-897-DZ"));
		cars.add(new Car(4, new String("Clio"), new String("Jaune"), 80, "SD-258-UK"));
		cars.add(new Car(5, new String("Dacia"), new String("Violet"), 800, "ZE-125-KD"));
		cars.add(new Car(6, new String("Megane"), new String("Vert"), 900, "SD-875-LK"));
	}

	@Override
	public CarList findAll() {
		CarList carList = new CarList();
		carList.setCarList(cars);
		return carList;
	}

	@Override
	public Car CarfindById(int id) {
		for (Car car : cars) {
			if (car.getId() == id) {
				return car;
			}
		}
		return null;
	}

	@Override
	public Car Carsave(Car car) {
		car.setId(cars.size() + 1);
		cars.add(car);
		return car;
	}
	
	@Override
	public boolean Cardelete(int carId) {
		Car car = CarfindById(carId);
		if (car != null) {
			int carIndex = cars.indexOf(car);
			cars.remove(carIndex);
			return true;
		}
		return false;
	}
	
	@Override
	public void updateCar(int carId, Car updatedCar) {
		Car car = CarfindById(carId);
		if (car != null) {
			car.setImmat(updatedCar.getImmat());
			car.setName(updatedCar.getName());
			car.setColor(updatedCar.getColor());
			car.setPrice(updatedCar.getPrice());
		}
	}
	
	// Getters and Setters
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
