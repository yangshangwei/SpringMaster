package com.xgj.aop.spring.advisor.RegexpMethodPointcutAdvisor;

public class Waiter {
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
		System.out.println("Waiter Greet to " + name);
	}

	/**
	 * 
	 * 
	 * @Title: serverTo
	 * 
	 * @Description:
	 * 
	 * @param name
	 * 
	 * @return: void
	 */
	public void serverTo(String name) {
		System.out.println("Waiter Server to " + name);
	}
}
