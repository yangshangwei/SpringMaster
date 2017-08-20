package com.xgj.aop.spring.advisor.ControlFlowAdvisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ControlFlowAdvisorTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/ControlFlowAdvisor/conf-controlFlowAdvisor.xml");

		Waiter waiter = ctx.getBean("waiter", Waiter.class);
		waiter.greetTo("XiaoGongJiang");
		waiter.serverTo("XiaoGongJiang");

		System.out.println("\n");

		WaiterDelegate waiterDelegate = new WaiterDelegate();
		waiterDelegate.setWaiter(waiter);

		waiterDelegate.service("XiaoGongJiang");

	}
}
