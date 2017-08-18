package com.xgj.ioc.inject.construct.nullValue;

public class Plane {

	private String brand;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void info() {
		System.out.println("Plane brand:" + brand);
	}
}
