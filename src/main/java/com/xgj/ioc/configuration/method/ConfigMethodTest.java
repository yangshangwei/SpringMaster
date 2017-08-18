package com.xgj.ioc.configuration.method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigMethodTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/method/beans.xml");

		Pilot pilot = ctx.getBean("pilot", Pilot.class);

		pilot.drivePlane();

	}
}
