package com.xgj.aop.spring.advisor.schema.bindParameter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceMethodsBindParamTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/schema/bindParameter/conf-bindParam.xml");

		BussinessBindParam bussinessBindParam = ctx.getBean(
				"bussinessBindParam", BussinessBindParam.class);
		// args(name,num,..) 因此会匹配到
		bussinessBindParam.program("Spring", 8);

		// args(name,num,..) 因此会匹配到
		bussinessBindParam.fixbug("Spring4", 10, 20000);
	}
}
