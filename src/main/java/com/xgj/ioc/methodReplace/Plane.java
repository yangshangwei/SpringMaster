package com.xgj.ioc.methodReplace;

public class Plane {

	private String brand;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		System.out.println("brand:" + brand);
		return brand;
	}

}
