package com.rentcar.rent.web.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rentcar.rent.dao.CarDaoImpl;
import com.rentcar.rent.model.Car;

@Controller
public class CarsController {

	public CarDaoImpl carDao = new CarDaoImpl();

	@GetMapping(value = "/")
	public String homePage() {
		return "index";
	}

	@GetMapping(value = "/cars")
	public String allCars(Model model) {
		model.addAttribute("cars", carDao.findAll());
		model.addAttribute(new Car());
		return "cars";
	}

	@PostMapping(path = "/deleteCar", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteCar(@RequestBody MultiValueMap<String,String> paramMap) {
		String id = paramMap.get("list-vehicules").get(0);
		carDao.Cardelete(Integer.valueOf(id));
		return "redirect:/cars";
	}

	@GetMapping(value = "/cars/{id}")
	public String findCar(@PathVariable int id, Model model) {
		model.addAttribute("car", carDao.CarfindById(id));
		return "carDetails";
	}

	@PostMapping(path = "/cars")
	public String saveCar(@ModelAttribute Car car, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
		}
		List<Car> listCars = carDao.findAll();
		listCars.size();
		car.setId(listCars.size() + 1);
		
		carDao.Carsave(car);
		return "redirect:/cars";
	}
	
	@GetMapping(path = "/updateCar/{id}")
	public String updateCarView(@PathVariable int id, Model model) {
		model.addAttribute("car", carDao.CarfindById(id));
		return "updateCar";
	}
	
	@PostMapping(path = "/updateCar")
	public String updateCar(@ModelAttribute Car car, Model model) {
		carDao.updateCar(car.getId(), car);
		return "redirect:/cars";
	}
}
