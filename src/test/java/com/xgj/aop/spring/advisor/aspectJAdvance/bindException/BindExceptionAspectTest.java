package com.xgj.aop.spring.advisor.aspectJAdvance.bindException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BindExceptionAspectTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJAdvance/bindException/conf-bindException.xml");

		ctx.getBean("bussinessException", BussinessException.class)
				.dealBussiness("bug");
	}
}
