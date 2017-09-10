package com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex;

import org.springframework.stereotype.Component;

@Component
public class WaiterTwo implements IWaiter {

	@Override
	public void greetTo(String clientName) {
		System.out.println("WaterTwo greetTo " + clientName);

	}

	@Override
	public void serverTo(String clientName) {
		System.out.println("WaterTwo serverTo " + clientName);

	}

}
