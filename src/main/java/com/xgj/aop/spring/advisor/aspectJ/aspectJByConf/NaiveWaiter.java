package com.xgj.aop.spring.advisor.aspectJ.aspectJByConf;

public class NaiveWaiter implements Waiter {

	@Override
	public void greetTo(String name) {
		System.out.println("NaiveWaiter Greet To " + name);
	}

	@Override
	public void serverTo(String name) {
		System.out.println("NaiveWaiter Server To " + name);
	}

}
