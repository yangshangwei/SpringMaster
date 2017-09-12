package com.xgj.aop.spring.advisor.aspectJAdvance.bindTypeAnnoObj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BindTypeAnnoObjectAspectTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJAdvance/bindTypeAnnoObj/conf-bindTypeAnnoObj.xml");

		Bussiness bussiness = ctx.getBean("bussiness", Bussiness.class);

		bussiness.dealBussinessOne();
		bussiness.dealBussinessTwo();
	}
}
