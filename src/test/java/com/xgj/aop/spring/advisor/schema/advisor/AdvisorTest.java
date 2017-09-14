package com.xgj.aop.spring.advisor.schema.advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/schema/advisor/conf-advisor.xml");

		NaiveWaiter naiveWaiter = ctx.getBean("naiveWaiter", NaiveWaiter.class);
		naiveWaiter.greetTo("XiaoGongJiang");
		naiveWaiter.serverTo("XiaoGongJiang");

	}
}
