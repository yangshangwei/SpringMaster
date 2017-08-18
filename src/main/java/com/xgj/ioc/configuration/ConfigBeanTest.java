package com.xgj.ioc.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigBeanTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/beans.xml");

		Pilot pilot = ctx.getBean("pilot", Pilot.class);

		Plane plane = ctx.getBean("plane", Plane.class);
		plane.setBrand("A380");
		plane.setColor("White");
		plane.setSpeed(800);

		plane.introduce();

	}
}
