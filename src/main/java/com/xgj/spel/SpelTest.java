package com.xgj.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpelTest {

	public static void main(String[] args) {

		String configLocation = "com/xgj/spel/beans_spel.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

		Car car = (Car) ctx.getBean("car");
		System.out.println(car);

		Boss boss = (Boss) ctx.getBean("boss");
		System.out.println(boss);

	}

}
