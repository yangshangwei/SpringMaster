package com.xgj.ioc.inject.construct.loopsolve;

public class Plane {

	private Pilot pilot;
	private String planeBrand;
	
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public void setPlaneBrand(String planeBrand) {
		this.planeBrand = planeBrand;
	}

	public void fly() {
		System.out.println("planeBrand:" + planeBrand + " is reday to fly");
	}
}
