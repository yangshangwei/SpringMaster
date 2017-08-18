package com.xgj.ioc.inject.construct.joint;

public class Tank {

	private String brand;
	private double weight;
	private double speed;
	// 载人数量
	private int manned;
	
	
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
	
	/**
	 * 
	 * @param brand
	 * @param weight
	 * @param manned
	 */
	public Tank(String brand, double weight,int manned){
		this.brand =brand;
		this.weight = weight;
		this.manned = manned;
	}
	
	public void introduce() {
		System.out.println("Tank information: brand:" + brand + ",weight:"
				+ weight + "KG,speed:" + speed + "km/h");
	}
	
	public void introduce2() {
		System.out.println("Tank information: brand:" + brand + ",weight:"
				+ weight + "KG,manned:" + manned + "/person");
	}

	
}
