package com.rentcar.rent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.List;

import org.aspectj.weaver.Iterators;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rentcar.rent.model.Car;
import com.rentcar.rent.model.CarList;
import com.rentcar.rent.service.CarService;
import com.rentcar.rent.web.controller.CarsController;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;
	
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarsControllerTest {
	
	@LocalServerPort
	private int port;
	@Autowired
	private CarsController controller;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private CarService carService;
	
	@Test
	public void contextLoad() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test 
	public void shouldReturnAllCars() throws Exception {
		Iterable<Car> body = this.restTemplate.getForObject("/cars", Iterable.class);
		int carRegistred = 0;
		while(body.iterator().hasNext()) {
		    carRegistred++;
		    body.iterator().next();
		}
		assertThat(carRegistred+5).isEqualTo(5);
	}
//	
//	@Test 
//	public void shouldReturnOneCar() throws Exception {
//		Car body = this.restTemplate.getForObject("/cars/2", Car.class);
//		assertThat(body.toString()).isEqualTo(carService.CarfindById(2).toString());
//	}
//	
//	@Test 
//	public void shouldCreateACar() throws Exception {
//		Car newCar = new Car("Jeep", "Black", 1500, "RE-456-YE");
//		Car retrievedCar = this.restTemplate.postForObject("/cars", newCar, Car.class);
//		assertThat(newCar.getImmat()).isEqualTo(retrievedCar.getImmat());
//	}
//	
//	@Test 
//	public void shouldDeleteACar() throws Exception {
//		this.restTemplate.delete("/cars/2");;
//		assertThat(carService.CarfindById(2)).isEqualTo(null);
//	}
//	
//	@Test 
//	public void shouldUpdateACar() throws Exception {
//		Car updatedCar = new Car("Bentley", "Red", 1500000, "FZ-147-YE");
//		this.restTemplate.put("/updateCar/3", updatedCar);
//		assertThat(carService.CarfindById(3).getImmat()).isEqualTo(updatedCar.getImmat());
//		assertThat(carService.CarfindById(3).getPrice()).isEqualTo(updatedCar.getPrice());
//	}
}
