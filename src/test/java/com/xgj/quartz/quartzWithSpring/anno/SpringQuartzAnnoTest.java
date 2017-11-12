package com.xgj.quartz.quartzWithSpring.anno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringQuartzAnnoTest {
	public static void main(String[] args) {
		// Æô¶¯Spring ÈÝÆ÷
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/quartz/quartzWithSpring/anno/spring-quartz-anno.xml");
		System.out.println("initContext successfully");
	}
}
