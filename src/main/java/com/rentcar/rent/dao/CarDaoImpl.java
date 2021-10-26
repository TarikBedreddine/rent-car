package com.rentcar.rent.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rentcar.rent.model.Car;



@Repository
public class CarDaoImpl implements CarDao {
	private List<Car> cars = new ArrayList<>();
	
	public CarDaoImpl() {
		cars.add(new Car(1, new String("Ferrari"), new String("Rouge"), 100000));
		cars.add(new Car(2, new String("Clio"), new String("Noir"), 20));
		cars.add(new Car(3, new String("Mercedes"), new String("Magenta"), 150000));
		cars.add(new Car(4, new String("Clio"), new String("Jaune"), 80));
		cars.add(new Car(5, new String("Dacia"), new String("Violet"), 800));
		cars.add(new Car(6, new String("Megane"), new String("Vert"), 900));
	}

	@Override
	public List<Car> findAll() {
		return cars;
	}

	@Override
	public Car CarfindById(int id) {
		return cars.get(id);
	}

	@Override
	public void Carsave(Car car) {
		cars.add(car);
	}
	
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
