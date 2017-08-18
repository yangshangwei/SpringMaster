package com.xgj.ioc.configuration.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pilot {

	private Plane plane;

	// 自动将Plane类型传给方法入参
	@Autowired
	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public void drivePlane() {
		plane.fly();
	}

	// 自动将名为plane的Bean传给方法入参
	// @Autowired
	// @Qualifier("plane")
	// public void setPlane(Plane plane) {
	// this.plane = plane;
	// }
}
