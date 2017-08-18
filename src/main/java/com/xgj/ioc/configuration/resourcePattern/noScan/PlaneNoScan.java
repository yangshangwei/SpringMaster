package com.xgj.ioc.configuration.resourcePattern.noScan;

import org.springframework.stereotype.Component;

@Component
public class PlaneNoScan {

	private String brand;
	private String color;
	private int speed;

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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void introduce() {
		System.out.println("Plane information¡¾ brand:" + brand + ",color:"
				+ color + ",speed:" + speed);
	}

	public void fly() {
		System.out.println("Plane begins to  fly");
	}
}
