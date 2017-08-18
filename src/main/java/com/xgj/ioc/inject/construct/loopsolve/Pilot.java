package com.xgj.ioc.inject.construct.loopsolve;

public class Pilot {

	private String pilotNname;
	private Plane plane;
	
	public void setPilotNname(String pilotNname) {
		this.pilotNname = pilotNname;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public void drivePlane() {
		System.out.println("pilotNname:" + pilotNname);
		plane.fly();
	}

}
