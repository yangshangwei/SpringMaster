package com.xgj.ioc.methodReplace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodReplacerTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/methodReplace/beans.xml");

		ctx.getBean("pilotOne", PilotOne.class).getPlane().getBrand();
	}
}
