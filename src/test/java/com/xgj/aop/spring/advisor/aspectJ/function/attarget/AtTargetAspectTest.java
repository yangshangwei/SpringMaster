package com.xgj.aop.spring.advisor.aspectJ.function.attarget;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtTargetAspectTest {

	private ApplicationContext ctx;

	@Test
	public void test() {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/attarget/conf-attarget.xml");

		C0 c0 = ctx.getBean("c0", C0.class);
		C1 c1 = ctx.getBean("c1", C1.class);
		C2 c2 = ctx.getBean("c2", C2.class);
		C3 c3 = ctx.getBean("c3", C3.class);

		// C0没有标注了@Mark，不会被织入增强
		c0.methodName();
		// C1标注了@Mark，会被织入增强
		c1.methodName();
		// C2标注了@Mark，会被织入增强
		c2.methodName();
		// C3没有标注了@Mark，不会被织入增强
		c3.methodName();
	}
}
