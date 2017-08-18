package com.xgj.ioc.inject.construct.loop;

public class Pilot {

	private String pilotNname;
	private Plane plane;

	public Pilot(String pilotNname, Plane plane) {
		super();
		this.pilotNname = pilotNname;
		this.plane = plane;
	}

	public void drivePlane() {

		plane.fly();
	}

}
