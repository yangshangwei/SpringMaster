package com.xgj.ioc.inject.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectTest {

	public static void main(String[] args) {
		// 加载配置文件,实例化bean
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/xgj/ioc/inject/set/plane.xml");
		// 从容器中获取bean
		Plane plane = ctx.getBean("plane",Plane.class);
		// 调用方法
		plane.introduce();
	}

}
