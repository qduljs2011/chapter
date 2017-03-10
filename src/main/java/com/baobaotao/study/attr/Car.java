package com.baobaotao.study.attr;

import org.springframework.stereotype.Service;
@Service
public class Car {
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String brand, String color, double maxSpeed) {
		super();
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	private String brand;
	private String color;
	private double maxSpeed;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}
}
