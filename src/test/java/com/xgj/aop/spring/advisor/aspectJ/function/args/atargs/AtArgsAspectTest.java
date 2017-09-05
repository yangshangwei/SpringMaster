package com.xgj.aop.spring.advisor.aspectJ.function.args.atargs;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtArgsAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/args/atargs/conf-atargs.xml");

		T0 t0 = ctx.getBean("t0", T0.class);
		T1 t1 = ctx.getBean("t1", T1.class);
		T2 t2 = ctx.getBean("t2", T2.class);
		T3 t3 = ctx.getBean("t3", T3.class);

		// 因t1中的fun入参为t2,且注解标注在了T2类上，t3又是t2的子类，所以 下面两个调用都会织入增强
		t1.fun(t2);
		t1.fun(t3);

	}
}
