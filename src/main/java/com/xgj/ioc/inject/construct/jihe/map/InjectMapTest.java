package com.xgj.ioc.inject.construct.jihe.map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectMapTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/jihe/map/beans.xml");

		PetShop shop = ctx.getBean("petShop", PetShop.class);

		shop.petsInfo();

	}
}
