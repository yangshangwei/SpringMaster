package com.xgj.ioc.inject.set;

public class Plane {

	private String brand;
	private String color;
	private int speed;
	
	/**
	 * 在没有其他显示构造函数的情况下，默认构造函数可省略
	 */
	public Plane(){
		
	}
	
	
	public Plane(String brand,String color,int speed){
		this.brand = brand;
		this.color = color;
		this.speed = speed;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void introduce() {
		System.out.println("Plane brand:" + brand + ",color:" + color
				+ ",speed," + speed );
	}
}
