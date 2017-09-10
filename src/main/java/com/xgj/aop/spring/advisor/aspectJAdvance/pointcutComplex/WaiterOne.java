package com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex;

import org.springframework.stereotype.Component;

@Component
public class WaiterOne implements IWaiter {

	@Override
	public void greetTo(String clientName) {
		System.out.println("WaterOne greetTo " + clientName);

	}

	@Override
	public void serverTo(String clientName) {
		System.out.println("WaterOne serverTo " + clientName);

	}

}
