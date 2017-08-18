package com.xgj.aop.spring.advice.methodInterceptor;

public class NaiveWaiter implements Waiter {

	@Override
	public void greetTo(String name) {
		System.out.println("greetTo " + name);
	}

	@Override
	public void serverTo(String name) {
		System.out.println("serverTo " + name);
	}

}
