package com.xgj.aop.spring.advisor.schema.advices;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DifferentAdviceTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/schema/advices/conf-advices.xml");

		BussinessSvc bussinessSvc = ctx.getBean("bussinessSvc",
				BussinessSvc.class);
		// 方法执行前织入前置增强
		bussinessSvc.dealBussinessBefore();

		// 方法执行后织入后置增强
		bussinessSvc.dealWorkNumberForAfterReturring();

		// 方法执行时织入环绕增强
		bussinessSvc.dealWorkForAround("fixBug");

		// 方法执行时出现特定异常时织入异常抛出增强
		bussinessSvc.dealWorkForAfter();

		// 方法执行后，不管异常与否都执行的增强
		bussinessSvc.dealWorkForAfter();

		// 引介 --强制类型转换成功，说明也实现了另外的接口
		IntfBussinessImpl intfBussinessImpl = ctx.getBean("intfBussinessImpl",
				IntfBussinessImpl.class);
		((InterfaceOne) intfBussinessImpl).dealAnotherWork();
	}
}
