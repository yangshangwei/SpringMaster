package com.xgj.aop.spring.advisor.ComposablePointcut;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroductionAdvisorTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/ComposablePointcut/conf-composablePointcut.xml");

		Waiter waiter = ctx.getBean("waiter", Waiter.class);
		waiter.greetTo("XiaoGongJiang");
		waiter.serverTo("XiaoGongJiang");

		WaiterDelegate waiterDelegate = new WaiterDelegate();
		waiterDelegate.setWaiter(waiter);
		waiterDelegate.service("XiaoGongJiang");
	}

}
