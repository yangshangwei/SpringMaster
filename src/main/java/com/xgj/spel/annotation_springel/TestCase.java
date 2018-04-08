package com.xgj.spel.annotation_springel;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {

	@Test
	public void test() {

		String configurationLocation = "com/xgj/spel/annotation_springel/beans_anno_spel.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configurationLocation);

		MyDataSource1 myDataSource = (MyDataSource1) ctx.getBean("myDataSource1");
		System.out.println(myDataSource);

		System.out.println("driverClassName:" + myDataSource.getDriverClass());
		System.out.println("url:" + myDataSource.getUrl());
		System.out.println("username:" + myDataSource.getUsername());
		System.out.println("password:" + myDataSource.getPassword());

	}

}
