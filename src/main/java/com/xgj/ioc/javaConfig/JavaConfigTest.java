package com.xgj.ioc.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigTest {

	public static void main(String[] args) {
		// 通过构造函数加载配置类
		// ApplicationContext ctx = new AnnotationConfigApplicationContext(
		// Teacher.class);

		// AnnotationConfigApplicationContext ctx = new
		// AnnotationConfigApplicationContext();
		// 注册@Configuration的配置类，可注册多个
		// ctx.register(Teacher.class);
		// 刷新容器以应用这些注册的配置类
		// ctx.refresh();

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/javaConfig/beans.xml");

		Teacher teacher = ctx.getBean("teacher", Teacher.class);
		teacher.arrangeStudent();

	}
}
