package com.xgj.ioc.inject.construct.index;

public class Tank {

	private String brand;
	private double weight;
	private double speed;
	
	/**
	 * 
	 * @param brand
	 * @param weight
	 * @param speed
	 * 第二个参数和第三个参数同为double类型
	 */
	public Tank(String brand, double weight, double speed) {
		this.brand = brand;
		this.weight = weight;
		this.speed = speed;
	}

	public void introduce() {
		System.out.println("Tank information: brand:" + brand + ",weight:"
				+ weight + "KG,speed:" + speed + "km/h");
	}

}
