package com.xgj.ioc.beansRelation.reference;

public class Pilot {

	private String planeId;

	public String getPlaneId() {
		return planeId;
	}

	public void setPlaneId(String planeId) {
		this.planeId = planeId;
	}

	@Override
	public String toString() {
		System.out.println("*********" + getPlaneId());
		return "planeId:" + getPlaneId();
	}
}
