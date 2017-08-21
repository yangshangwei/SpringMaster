package com.xgj.aop.spring.advisor.autoCreateProxy.BeanNameAutoProxyCreator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanNameAutoProxyCreatorTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/autoCreateProxy/BeanNameAutoProxyCreator/conf-beanNameAutoProxy.xml");

		Waiter waiter = ctx.getBean("waiter", Waiter.class);
		waiter.greetTo("XiaoGongJiang");
		waiter.serverTo("XiaoGongJiang");

		System.out.println("\n");

		Seller seller = ctx.getBean("seller", Seller.class);
		seller.greetTo("XiaoGongJiang");
		seller.serverTo("XiaoGongJiang");
	}
}
