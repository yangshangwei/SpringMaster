package com.xgj.ioc.inject.construct.refParentBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefParentBeanTest {

	public static void main(String[] args) {

		// 父容器
		ApplicationContext pFather = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/refParentBean/beans_father.xml");
		// 指定pFactory为该容器的父容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "com/xgj/ioc/inject/construct/refParentBean/beans_son.xml" },
				pFather);

		Police police = ctx.getBean("police", Police.class);
		// 观察是否输出为父容器设置的属性
		police.introduceGun();
	}

}
