package com.xgj.ioc.configuration.resourcePattern.noScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PilotNoScan {

	@Autowired
	private PlaneNoScan plane;

	public void drivePlane() {
		plane.fly();
	}
}
