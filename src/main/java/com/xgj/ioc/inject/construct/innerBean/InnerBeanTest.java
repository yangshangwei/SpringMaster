package com.xgj.ioc.inject.construct.innerBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InnerBeanTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/innerBean/innerBean.xml");

		Police police = ctx.getBean("police", Police.class);
		police.introduceGun();
	}
}
