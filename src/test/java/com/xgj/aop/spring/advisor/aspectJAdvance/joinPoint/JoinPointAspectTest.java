package com.xgj.aop.spring.advisor.aspectJAdvance.joinPoint;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JoinPointAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJAdvance/joinPoint/conf-joinPoint.xml");

		LogicService logicService = ctx.getBean("logicService",
				LogicService.class);
		logicService.dealLogic("PROGRAMMING");

	}
}
