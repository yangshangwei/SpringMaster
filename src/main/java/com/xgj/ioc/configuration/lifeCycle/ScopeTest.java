package com.xgj.ioc.configuration.lifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

	public static void main(String[] args) {
		// 启动容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/lifeCycle/beanLifeCycle.xml");

		System.out.println("isPrototype:" + ctx.isPrototype("teacher"));
		System.out.println("isSingleton:" + ctx.isSingleton("teacher"));
		// 关闭容器，对于singleton的Bean，容器管理，prototype由调用者管理，Spring不管理
		((ClassPathXmlApplicationContext) ctx).destroy();

	}
}
