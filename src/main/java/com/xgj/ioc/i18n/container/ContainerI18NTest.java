package com.xgj.ioc.i18n.container;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerI18NTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/i18n/container/beans.xml");
		// 动态参数
		Object[] params = { "XiaoGongJiang", new GregorianCalendar().getTime() };
		// 直接通过容器访问国际化信息
		String msg1 = ctx.getMessage("greeting.common", params, Locale.US);
		String msg2 = ctx.getMessage("greeting.morning", params, Locale.CHINA);
		System.out.println(msg1);
		System.out.println(msg2);
	}
}
