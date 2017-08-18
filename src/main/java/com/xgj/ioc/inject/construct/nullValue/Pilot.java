package com.xgj.ioc.inject.construct.nullValue;

public class Pilot {
	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public void drivePlane() {
		System.out.println("Pilot is driving plane....");
		plane.info();
	}
}
