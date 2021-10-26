package com.rentcar.rent.model;

public class Car {
	private int id;
	private String immat;
	private String name;
	private String color;
	private double price;
	
	public Car() {}

	public Car(int id, String name, String color, double price, String immat) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.immat = immat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getImmat() {
		return immat;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + "]";
	}
}
