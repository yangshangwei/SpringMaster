package com.xgj.ioc.inject.construct.nullValue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NullValueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/nullValue/beans.xml");

		Pilot pilot = ctx.getBean("pilot", Pilot.class);

		pilot.drivePlane();

	}
}
