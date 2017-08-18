package com.xgj.ioc.inject.construct.index;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructInjectTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/xgj/ioc/inject/construct/index/tank_index_match.xml");
		
		Tank tank = ctx.getBean("tank", Tank.class);
		
		tank.introduce();
	}

}
