package com.xgj.aop.spring.advisor.aspectJ.function.atwithin2;

public class NaiveWaiter implements Waiter {
	public void greetTo(String clientName) {
		System.out.println("NaiveWaiter:greet to " + clientName + "...");
	}

}
