package com.xgj.aop.spring.advisor.aspectJ.function.thisFun2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointcutFunTest {

	@Test
	public void pointcut() {
		String configPath = "com/xgj/aop/spring/advisor/aspectJ/function/thisFun2/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");

		naiveWaiter.greetTo("John");
		naiveWaiter.serveTo("John");
		((Seller) naiveWaiter).sell("Beer", "John");

	}
}
