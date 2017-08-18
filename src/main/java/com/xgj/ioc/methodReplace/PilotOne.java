package com.xgj.ioc.methodReplace;

public class PilotOne {

	public Plane getPlane() {
		Plane plane = new Plane();
		plane.setBrand("PilotOne-F22");
		return plane;
	}
}
