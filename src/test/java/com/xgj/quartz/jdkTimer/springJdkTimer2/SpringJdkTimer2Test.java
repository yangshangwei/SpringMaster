package com.xgj.quartz.jdkTimer.springJdkTimer2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdkTimer2Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/quartz/jdkTimer/springJdkTimer2/spring-jdkTimer.xml");
		System.out.println("initContext successfully");

		MyJobService job = ctx.getBean("myJobService", MyJobService.class);
		job.doJob();

	}

}
