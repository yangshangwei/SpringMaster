package com.xgj.ioc.inject.construct.reflect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructInjectTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/xgj/ioc/inject/construct/reflect/beans.xml");
		
		Commander commander = ctx.getBean("commander", Commander.class);
		
		commander.direct();
	}

}
