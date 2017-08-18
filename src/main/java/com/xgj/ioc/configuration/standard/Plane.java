package com.xgj.ioc.configuration.standard;

import org.springframework.stereotype.Component;

@Component
public class Plane {

	public void fly() {
		System.out.println("plane begins to fly");
	}

}
