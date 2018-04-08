package com.xgj.spel;

/**
 * 
 * 
 * @ClassName: Car
 * 
 * @Description: 车辆
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月7日 下午8:30:01
 */
public class Car {

	private String brand;
	private double price;
	// 调用静态方法或静态属性：通过 T() 调用一个类的静态方法，它将返回一个 Class Object，然后再调用相应的方法或属性
	private long weight;

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", weight=" + weight + "]";
	}


}
