package com.xgj.ioc.inject.construct.ref;

public class Police {

	private Gun gun;

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public void userGun() {
		gun.fire();
	}

}
