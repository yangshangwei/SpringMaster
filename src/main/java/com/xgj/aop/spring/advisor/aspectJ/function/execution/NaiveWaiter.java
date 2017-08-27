package com.xgj.aop.spring.advisor.aspectJ.function.execution;

public class NaiveWaiter {

	/**
	 * public方法，演示execution(public * *(..)),能匹配到
	 */
	public void greetTo(String clientName) {
		System.out.println("NaiveWaiter greet to " + clientName);
	}

}
