package com.xgj.aop.spring.advisor.aspectJAdvance.namePoint;

import org.springframework.stereotype.Component;

@Component
public class CuteWaiter {
	public void greetTo(String clientName) {
		System.out.println("CuteWaiter greetTo " + clientName);
	}

	public void serverTo(String clientName) {
		System.out.println("CuteWaiter serverTo " + clientName);
	}
}
