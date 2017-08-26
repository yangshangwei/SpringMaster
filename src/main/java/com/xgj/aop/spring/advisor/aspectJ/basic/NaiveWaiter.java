package com.xgj.aop.spring.advisor.aspectJ.basic;

public class NaiveWaiter implements Waiter {

	@Override
	public void greetTo(String name) {
		System.out.println("NaiveWaiter Greet to " + name);
	}

	@Override
	public void serverTo(String name) {
		System.out.println("NaiveWaiter Server to " + name);

	}

}
