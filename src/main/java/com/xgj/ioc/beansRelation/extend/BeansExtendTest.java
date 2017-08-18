package com.xgj.ioc.beansRelation.extend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansExtendTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/beansRelation/extend/beans.xml");

		ctx.getBean("planeOne", Plane.class).introduce();
		ctx.getBean("planeTwo", Plane.class).introduce();
	}

}
