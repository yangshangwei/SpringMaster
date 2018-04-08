package com.xgj.ioc.propertyplacehoder.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/propertyplacehoder/beans.xml");

		MyDataSource myDataSource = ctx.getBean("myDataSource",
				MyDataSource.class);

		System.out.println(myDataSource);

		myDataSource.getDriveClassName();
		myDataSource.getUrl();
		myDataSource.getUserName();
		myDataSource.getPassword();

	}
}
