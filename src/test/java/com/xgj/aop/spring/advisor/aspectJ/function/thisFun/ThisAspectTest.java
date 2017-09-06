package com.xgj.aop.spring.advisor.aspectJ.function.thisFun;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThisAspectTest {
	private ApplicationContext applicationContext;

	@Test
	public void test() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/thisFun/conf-this.xml");

		BussinessService bussinessService = (BussinessService) applicationContext
				.getBean("bussinessService");
		// ∆•≈‰ this
		bussinessService.doBussiness();
		// ∆•≈‰ this
		bussinessService.doAnother();

		// ∆•≈‰ this
		((ITransportService) bussinessService).doTransport();

	}
}
