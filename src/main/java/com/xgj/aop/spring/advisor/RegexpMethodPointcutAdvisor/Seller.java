package com.xgj.aop.spring.advisor.RegexpMethodPointcutAdvisor;

public class Seller {
	/**
	 * 
	 * 
	 * @Title: greetTo
	 * 
	 * @Description:
	 * 
	 * @param name
	 * 
	 * @return: void
	 */
	public void greetTo(String name) {
		System.out.println("Seller Greet to " + name);
	}
}
