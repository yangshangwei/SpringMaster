package com.xgj.ioc.inject.construct.loop;

public class Plane {

	private Pilot pilot;
	private String planeBrand;
	
	public Plane(Pilot pilot, String planeBrand) {
		super();
		this.pilot = pilot;
		this.planeBrand = planeBrand;
	}
	
	public void fly() {
		System.out.println("Plane :" + planeBrand + " is reday to fly");
	}
}
