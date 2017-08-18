package com.xgj.ioc.inject.construct.jihe.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectSetTest {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/jihe/set/beans.xml");

		PetShop shop = ctx.getBean("petShop", PetShop.class);

		shop.petsInfo();

	}
}
