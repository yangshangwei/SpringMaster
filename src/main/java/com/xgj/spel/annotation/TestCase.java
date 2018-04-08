package com.xgj.spel.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {

	@Test
	public void test() {

		String configurationLocation = "com/xgj/spel/annotation/beans_anno.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configurationLocation);

		MyDataSource myDataSource = (MyDataSource) ctx.getBean("myDataSource");
		System.out.println(myDataSource);

		System.out.println("driverClassName:" + myDataSource.getDriverClass());
		System.out.println("url:" + myDataSource.getUrl());
		System.out.println("username:" + myDataSource.getUsername());
		System.out.println("password:" + myDataSource.getPassword());

	}

}
