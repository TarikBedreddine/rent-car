package com.rentcar.rent.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rentcar.rent.dao.CarDaoImpl;
import com.rentcar.rent.model.Car;

@Controller
public class CarsController {

	public CarDaoImpl carDao;
	
	public CarsController() {
		this.carDao = new CarDaoImpl();
	}
	
    @GetMapping(value="/cars")
    public String allCars(Model model) {
    	model.addAttribute("cars", carDao.findAll());
    	return "home";
    }
    
    @GetMapping(value="/cars/{id}")
    public Car findCar(@PathVariable int id) {
    	return carDao.CarfindById(id);
    }
    
    @PostMapping(path = "cars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveCar(@RequestBody Car car) {
    	carDao.Carsave(car);
    }
    
    @RequestMapping("/")
    public String homePage(@RequestParam("name") String name, Model model) {
    	model.addAttribute("name", name);
    	return "home";
    }
}
