package com.xgj.ioc.inject.construct.jihe.merge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectStrongTypeTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/jihe/merge/beans.xml");

		PetShop shop = ctx.getBean("petShop", PetShop.class);

		shop.petsInfo();

	}
}
