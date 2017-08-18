package com.xgj.ioc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pilot {

	@Autowired
	private Plane plane;

	public void drivePlane() {
		plane.fly();
	}
}
