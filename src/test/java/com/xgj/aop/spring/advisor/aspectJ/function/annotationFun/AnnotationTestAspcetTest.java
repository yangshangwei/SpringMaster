package com.xgj.aop.spring.advisor.aspectJ.function.annotationFun;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.aop.spring.advisor.aspectJ.function.Waiter;

public class AnnotationTestAspcetTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJ/function/annotationFun/conf-annotation.xml");

		// 必须是接口类型,否则抛类型转换异常
		Waiter waiter = (Waiter) ctx.getBean("naiveWaiter");

		// 因为greetTo标注了@NeedTest,因此会被后置增强
		waiter.greetTo("XiaoGongJiang");
		waiter.serverTo("XiaoGongJiang");

		Waiter naughtWaiter = (Waiter) ctx.getBean("naughtWaiter");
		// serverTo标注了@NeedTest,因此会被后置增强
		naughtWaiter.serverTo("XiaoGongJiang");
	}
}
