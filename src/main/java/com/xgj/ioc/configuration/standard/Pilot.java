package com.xgj.ioc.configuration.standard;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Pilot {

	private Plane plane;

	@Resource(name = "plane")
	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public void drivePlane() {
		plane.fly();
	}

}
