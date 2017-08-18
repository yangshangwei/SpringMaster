package com.xgj.ioc.configuration.standard;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StandardTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/standard/beans.xml");

		ctx.getBean("pilot", Pilot.class).drivePlane();
	}
}
