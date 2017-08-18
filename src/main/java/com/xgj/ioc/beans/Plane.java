package com.xgj.ioc.beans;

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
	
	public void info(){
		System.out.println("brand:" + brand + ",color:" + color + ",speed" + speed);
	}
	
}
