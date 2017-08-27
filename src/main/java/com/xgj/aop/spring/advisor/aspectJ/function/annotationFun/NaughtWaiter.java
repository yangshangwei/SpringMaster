package com.xgj.aop.spring.advisor.aspectJ.function.annotationFun;

public class NaughtWaiter implements Waiter {

	@Override
	public void greetTo(String clientName) {
		System.out.println("NaughtWaiter:greet to " + clientName);
	}

	@NeedTest(true)
	@Override
	public void serverTo(String clientName) {
		System.out.println("NaughtWaiter:server to " + clientName);
	}

	public void joke(String clientName, int times) {
		System.out.println("NaughtyWaiter:play " + times + " jokes to "
				+ clientName);
	}
}
