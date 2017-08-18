package com.xgj.ioc.configuration.other;

import org.springframework.stereotype.Component;

@Component("otherPlane")
public class Plane {

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
		System.out.println("OtherPlane information¡¾ brand:" + brand + ",color:"
				+ color + ",speed:" + speed);
	}

	public void fly() {
		System.out.println("OtherPlane begins to  fly");
	}
}
