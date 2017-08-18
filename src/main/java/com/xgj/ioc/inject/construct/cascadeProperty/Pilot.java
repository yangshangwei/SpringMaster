package com.xgj.ioc.inject.construct.cascadeProperty;

public class Pilot {
	// 声明初始化对象
	private Plane plane = new Plane();

	// 获取实例
	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public void introduce() {
		plane.info();
	}

}
