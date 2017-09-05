package com.xgj.aop.spring.advisor.aspectJ.function.atwithin2;


public class NaughtyWaiter extends NaiveWaiter {

	public void greetTo(String clientName) {
		System.out.println("NaughtyWaiter:greet to " + clientName + "...");
	}

}
