package com.xgj.ioc.configuration.lazyLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Pilot {

	private Plane plane;

	// ÑÓ³Ù×¢Èë
	@Lazy
	@Autowired(required = false)
	public void setPlane(Plane plane) {
		this.plane = plane;
	}

}
