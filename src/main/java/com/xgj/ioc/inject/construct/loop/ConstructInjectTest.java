package com.xgj.ioc.inject.construct.loop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructInjectTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/xgj/ioc/inject/construct/loop/beans.xml");
		
		Pilot pilot = ctx.getBean("pilot", Pilot.class);
		
		pilot.drivePlane();
	}

}
