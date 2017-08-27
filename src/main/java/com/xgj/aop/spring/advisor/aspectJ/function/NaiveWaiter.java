package com.xgj.aop.spring.advisor.aspectJ.function;

public class NaiveWaiter implements Waiter {

	@NeedTest
	@Override
	public void greetTo(String clientName) {
		System.out.println("NaiveWaiter:greet to " + clientName);
	}

	@Override
	public void serverTo(String clientName) {
		System.out.println("NaiveWaiter:server to " + clientName);
	}

	public void smile(String clientName, int times) {
		System.out.println("NaiveWaiter:smile to  " + clientName + " " + times
				+ " times");
	}
}
