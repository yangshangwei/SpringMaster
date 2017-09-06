package com.xgj.aop.spring.advisor.aspectJ.function.target;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TargetAspectTest {

	private ApplicationContext applicationContext;

	@Test
	public void test() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/target/conf-target.xml");

		BussinessService bussinessService = applicationContext.getBean(
				"bussinessService", BussinessService.class);
		// 织入增强
		bussinessService.doSomething();
		// 织入增强
		bussinessService.doAnother();
	}
}
