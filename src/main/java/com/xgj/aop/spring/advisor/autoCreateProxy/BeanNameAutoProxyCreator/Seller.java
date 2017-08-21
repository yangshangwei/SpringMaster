package com.xgj.aop.spring.advisor.autoCreateProxy.BeanNameAutoProxyCreator;

public class Seller {

	public void greetTo(String name) {
		System.out.println("Seller Greet To " + name);
	}

	public void serverTo(String name) {
		System.out.println("Seller Server To " + name);
	}
}
