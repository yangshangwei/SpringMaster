package com.xgj.ioc.inject.construct.innerBean;

public class Gun {

	private String brand;
	private int bulletNum;
	private double price;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setBulletNum(int bulletNum) {
		this.bulletNum = bulletNum;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void gunInfo() {
		System.out.println("Gun Information brand:" + brand + ",bulletNum:"
				+ bulletNum + ",price:" + price);
	}
}
