package com.rentcar.rent.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rentcar.rent.dao.CarDaoImpl;
import com.rentcar.rent.model.Car;
import com.rentcar.rent.model.CarList;

@RestController
public class CarsController {

	@Autowired
	public CarDaoImpl carDao;

	@GetMapping(value = "/cars")
	public CarList allCars(Model model) {
		return carDao.findAll();
	}

	@GetMapping(value = "/cars/{id}")
	public Car findCar(@PathVariable int id) {
		return carDao.CarfindById(id);
	}

	@PostMapping(path = "/cars")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Car saveCar(@RequestBody Car car, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
		}
		return carDao.Carsave(car);
	}
	
	@DeleteMapping(path = "/cars/{id}")
	public void deleteCar(@PathVariable int id) {
		carDao.Cardelete(id);
	}
	
	@PutMapping(path = "/updateCar/{id}")
	public void updateCar(@PathVariable int id, @RequestBody Car car) {
		carDao.updateCar(id, car);
	}
}
