package com.xgj.aop.spring.advisor.aspectJ.aspectJByConf;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PreGreetingAspectSchemaTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/aspectJByConf/conf-aspectJ_schema.xml");

		Waiter naiveWaiter = ctx.getBean("waiter", Waiter.class);

		naiveWaiter.greetTo("XiaoGongJiang");
		naiveWaiter.serverTo("XiaoGongJiang");
	}
}
