package com.xgj.ioc.beansRelation.reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansRefTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/beansRelation/reference/beans.xml");

		Pilot pilot = ctx.getBean("pilot", Pilot.class);
		pilot.setPlaneId("99");
		pilot.toString();
	}
}
