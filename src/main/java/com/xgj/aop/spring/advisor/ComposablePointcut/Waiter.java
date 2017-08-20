package com.xgj.aop.spring.advisor.ComposablePointcut;

public class Waiter {

	public void greetTo(String name) {
		System.out.println("Waiter Greet To " + name);
	}

	public void serverTo(String name) {
		System.out.println("Waiter Server To " + name);
	}
}
