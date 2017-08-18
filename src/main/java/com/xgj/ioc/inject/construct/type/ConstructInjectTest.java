package com.xgj.ioc.inject.construct.type;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructInjectTest {

	public static void main(String[] args) {
		// 加载配置文件,实例化Bean
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/xgj/ioc/inject/construct/type/tank.xml");
		// 从容器中获取Bean
		Tank tank = ctx.getBean("tank", Tank.class);
		
		tank.introduce();
	}

}
