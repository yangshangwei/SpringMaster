package com.xgj.ioc.inject.construct.cascadeProperty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CascadePropertyTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/cascadeProperty/beans.xml");

		Pilot pilot = ctx.getBean("pilot", Pilot.class);

		pilot.introduce();

	}
}
