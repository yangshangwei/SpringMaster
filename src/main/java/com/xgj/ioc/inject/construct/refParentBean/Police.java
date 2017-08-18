package com.xgj.ioc.inject.construct.refParentBean;

public class Police {

	private Gun gun;

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public void introduceGun() {
		gun.gunInfo();
	}
}
