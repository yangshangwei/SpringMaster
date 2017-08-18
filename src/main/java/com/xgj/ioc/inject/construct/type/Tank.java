package com.xgj.ioc.inject.construct.type;

public class Tank {

	private String brand;
	private double weight;

	public Tank(String brand, double weight) {
		super();
		this.brand = brand;
		this.weight = weight;
	}

	public void introduce() {
		System.out.println("Tank information: brand:" + brand + ",weight:"
				+ weight + "KG");
	}

}
