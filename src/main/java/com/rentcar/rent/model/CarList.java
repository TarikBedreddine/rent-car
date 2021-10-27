package com.rentcar.rent.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {

	private List<Car> carList; 
	
	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public void CarList() {
		this.carList = new ArrayList<Car>();
	}
}
