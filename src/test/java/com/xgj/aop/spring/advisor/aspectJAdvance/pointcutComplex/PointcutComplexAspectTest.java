package com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointcutComplexAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJAdvance/pointcutComplex/conf-pointcutComplex.xml");

		WaiterOne waiterOne = ctx.getBean("waiterOne", WaiterOne.class);
		WaiterTwo waiterTwo = ctx.getBean("waiterTwo", WaiterTwo.class);

		SellerOne sellerOne = ctx.getBean("sellerOne", SellerOne.class);
		SellerTwo sellerTwo = ctx.getBean("sellerTwo", SellerTwo.class);

		waiterOne.greetTo("XiaoGongJiang");
		System.out.println();

		waiterOne.serverTo("XiaoGongJiang");
		System.out.println();

		waiterTwo.greetTo("XiaoGongJiang");
		System.out.println();

		sellerOne.greetTo("XiaoGongJiang");
		System.out.println();

		sellerOne.greetTo("XiaoGongJiang");
		System.out.println();
	}
}
