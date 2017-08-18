package com.xgj.ioc.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// 加载配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		// 从容器中获取实例化后的bean
		Boss boss = ctx.getBean("boss", Boss.class);
		Plane plane = ctx.getBean("plane", Plane.class);
		
		// 设置属性
		boss.setName("XGJ");
		boss.setSex("MALE");
		boss.setAge(20);
		boss.setPlane(plane);
		// 设置属性
		plane.setBrand("A380");
		plane.setColor("red");
		plane.setSpeed(900);
		// 调用方法
		boss.introduce();

	}

}
