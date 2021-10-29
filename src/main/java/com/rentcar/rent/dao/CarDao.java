package com.rentcar.rent.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rentcar.rent.model.Car;

public interface CarDao extends JpaRepository<Car, Integer> {
	
	Car findCarById(int id);
}
