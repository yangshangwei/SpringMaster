package com.xgj.ioc.configuration.resourcePattern.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PilotScan {

	@Autowired
	private PlaneScan plane;

	public void drivePlane() {
		plane.fly();
	}
}
