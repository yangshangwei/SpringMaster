package com.xgj.aop.spring.advisor.StaticMethodMatcherPointcutAdvisor;

public class Seller {
	/**
	 * 
	 * 
	 * @Title: greetTo
	 * 
	 * @Description: 和Waiter类中的同名的方法,目的是为了验证仅仅织入了Waiter类中的greetTo方法
	 * 
	 * @param name
	 * 
	 * @return: void
	 */
	public void greetTo(String name) {
		System.out.println("Seller Greet to " + name);
	}
}
