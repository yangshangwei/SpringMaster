package com.xgj.aop.spring.advisor.aspectJAdvance.bingReturnValue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BindReturnValueAspectTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJAdvance/bingReturnValue/conf-bindReturnValue.xml");

		BussinessRet bussinessRet = ctx.getBean("bussinessRet",
				BussinessRet.class);
		bussinessRet.dealBussiness();
	}
}
