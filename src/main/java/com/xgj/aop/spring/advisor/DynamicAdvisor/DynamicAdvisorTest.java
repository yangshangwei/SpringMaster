package com.xgj.aop.spring.advisor.DynamicAdvisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DynamicAdvisorTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/DynamicAdvisor/conf-dynamicAdvisor.xml");

		Waiter waiter = ctx.getBean("waiter", Waiter.class);
		// list中的特殊客户
		waiter.greetTo("XiaoGongJiangOne");
		waiter.serverTo("XiaoGongJiangOne");
		// list中的特殊客户
		waiter.greetTo("XiaoGongJiangTwo");
		waiter.serverTo("XiaoGongJiangTwo");
		// 不在list中的客户
		waiter.greetTo("Smart");
		waiter.serverTo("Smart");

	}
}
