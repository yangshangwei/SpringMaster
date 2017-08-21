package com.xgj.aop.spring.advisor.autoCreateProxy.BeanNameAutoProxyCreator;

public class Waiter {

	public void greetTo(String name) {
		System.out.println("Waiter Greet To " + name);
	}

	public void serverTo(String name) {
		System.out.println("Waiter Server To " + name);
	}
}
