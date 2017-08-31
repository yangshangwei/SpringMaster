package com.xgj.aop.spring.advisor.aspectJ.function.execution.methodParam;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExcutionMethodParamAspectTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/execution/methodParam/conf-execution.xml");

		Worker worker = (Worker) ctx.getBean("worker");
		Farmer farmer = ctx.getBean("farmer", Farmer.class);

		worker.doSomething("digging", 30);
		farmer.doSomething("farming", 45);

	}

}
