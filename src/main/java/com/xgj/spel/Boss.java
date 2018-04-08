package com.xgj.spel;

public class Boss {

	private String name;
	private Car car;
	// 通过 Spring El 引用 Address的city
	private String city;
	// 通过 Car的price属性，确定info ,如果car.price>=500000 ,info 为CEO,否则为 Staff
	private String info;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Boss [name=" + name + ", car=" + car + ", city=" + city + ", info=" + info + "]";
	}

}
