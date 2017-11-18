package com.xgj.quartz.jdkTimer.springJdkTimer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdkTimerTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/quartz/jdkTimer/springJdkTimer/spring-jdkTimer.xml");
		System.out.println("initContext successfully");

		MyTask task = ctx.getBean("timeTask", MyTask.class);
		task.run();

	}

}
