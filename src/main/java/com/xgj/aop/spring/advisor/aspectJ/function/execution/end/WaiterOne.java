package com.xgj.aop.spring.advisor.aspectJ.function.execution.end;

public class WaiterOne {
	public void greetTo(String clientName) {
		System.out.println("WaiterOne greetTo " + clientName);
	}

	protected void serverTo(String clientName) {
		System.out.println("WaiterOne serverTo " + clientName);
	}

	public void smile(String clientName) {
		System.out.println("WaiterOne simle " + clientName);
	}
}
