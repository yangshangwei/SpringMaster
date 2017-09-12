package com.xgj.aop.spring.advisor.aspectJAdvance.bindProxyObj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BindProxyObjAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJAdvance/bindProxyObj/conf-bindProxyObj.xml");

		BussinessLogicService bussinessLogicService = ctx.getBean(
				"bussinessLogicService", BussinessLogicService.class);

		bussinessLogicService.doLogic();
	}
}
