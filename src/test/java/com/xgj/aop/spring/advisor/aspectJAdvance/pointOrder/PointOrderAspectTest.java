package com.xgj.aop.spring.advisor.aspectJAdvance.pointOrder;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointOrderAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJAdvance/pointOrder/conf-pointOrder.xml");

		Bussiness bussiness = ctx.getBean("bussiness", Bussiness.class);

		bussiness.dealBussiness();
	}
}
