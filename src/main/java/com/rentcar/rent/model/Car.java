package com.rentcar.rent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NotFound;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"immat"})})
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Column(name = "immat", length = 9, nullable = false, unique = true)
	private String immat;
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	@Column(name = "color", length = 255, nullable = false)
	private String color;
	@Column(name = "price", length = 255, nullable = false)
	private double price;
	
	public Car() {}

	public Car(int id, String name, String color, double price, String immat) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.immat = immat;
	}
	
	public Car(String name, String color, double price, String immat) {
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
