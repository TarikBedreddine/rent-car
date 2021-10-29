package com.rentcar.rent.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rentcar.rent.model.Car;
import com.rentcar.rent.service.CarService;

@RestController
public class CarsController {

	@Autowired 
	private CarService carService;

	@GetMapping(value = "/cars")
	public Iterable<Car> allCars(Model model) {
		return carService.getAllCars();
	}

	@GetMapping(value = "/cars/{id}")
	public Car findCar(@PathVariable int id) {
		Car oneCar = carService.getOneCar(id);
		return carService.getOneCar(id);
	}

	@PostMapping(path = "/cars")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Car saveCar(@RequestBody Car car, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
		}
		return carService.saveCar(car);
	}
	
	@DeleteMapping(path = "/cars/{id}")
	public void deleteCar(@PathVariable int id) {
		this.carService.deleteOneCar(id);
	}
	
	@PutMapping(path = "/updateCar/{id}")
	public void updateCar(@PathVariable int id, @RequestBody Car car) {
		this.carService.updateOneCar(id, car);
	}
}
