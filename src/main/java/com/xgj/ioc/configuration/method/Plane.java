package com.xgj.ioc.configuration.method;

import org.springframework.stereotype.Component;

@Component
// 通过注解标注为一个Bean，以便Spring扫描并实例化
public class Plane {

	public void fly() {
		System.out.println("Plane begins to  fly");
	}

}
