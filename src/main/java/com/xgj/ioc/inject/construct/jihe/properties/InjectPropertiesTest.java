package com.xgj.ioc.inject.construct.jihe.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectPropertiesTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/jihe/properties/beans.xml");

		PetShop shop = ctx.getBean("petShop", PetShop.class);

		shop.petsInfo();

	}
}
