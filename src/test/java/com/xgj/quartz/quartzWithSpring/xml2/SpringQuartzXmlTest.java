package com.xgj.quartz.quartzWithSpring.xml2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringQuartzXmlTest {

	public static void main(String[] args) {
		// Æô¶¯Spring ÈÝÆ÷
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/quartz/quartzWithSpring/xml2/spring-quartz.xml");
		System.out.println("initContext successfully");
	}
}
