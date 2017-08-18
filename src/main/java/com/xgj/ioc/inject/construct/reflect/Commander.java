package com.xgj.ioc.inject.construct.reflect;

public class Commander {
	
	private Plane plane;
	private Tank tank;
	private String name;
	
	public Commander(Plane plane, Tank tank, String name) {
		super();
		this.plane = plane;
		this.tank = tank;
		this.name = name;
	}
	
	
	public void direct(){
		System.out.println("Commamder name:" + name);
		System.out.println("Commnader begins to direct the army");
		plane.attack();
		tank.attack();
		
	}
	
}
