package com.xgj.aop.spring.advisor.aspectJ.function.execution.end;

public class WaiterTwo {

	public void greetTo(String clientName) {
		System.out.println("WaiterTwo greetTo " + clientName);
	}

	public void serverTo(String clientName) {
		System.out.println("WaiterTwo serverTo " + clientName);
	}

	public void smile(String clientName) {
		System.out.println("WaiterTwo simle " + clientName);
	}
}
