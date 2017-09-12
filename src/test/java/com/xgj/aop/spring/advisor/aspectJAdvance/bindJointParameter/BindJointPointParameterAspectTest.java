package com.xgj.aop.spring.advisor.aspectJAdvance.bindJointParameter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BindJointPointParameterAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJAdvance/bindJointParameter/conf-joinPoint.xml");

		LogicBindService logicBindService = ctx.getBean("logicBindService",
				LogicBindService.class);

		logicBindService.dealLogic("PROGRAMMING", 5);

	}
}
