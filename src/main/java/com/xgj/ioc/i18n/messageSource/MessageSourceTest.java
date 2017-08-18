package com.xgj.ioc.i18n.messageSource;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSourceTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/i18n/messageSource/beans.xml");

		// 获取MessageSource的Bean
		MessageSource messageSource = ctx.getBean("resource",
				MessageSource.class);

		// 动态参数
		Object[] objs = { "Xiaogongjiang", new GregorianCalendar().getTime() };

		// 获取格式化的国际化信息
		String msg1 = messageSource.getMessage("greeting.common", objs,
				Locale.CHINESE);

		String msg2 = messageSource.getMessage("greeting.morning", objs,
				Locale.US);

		String msg3 = messageSource.getMessage("greeting.afternoon", objs,
				Locale.CHINESE);

		System.out.println(msg1);
		System.out.println(msg2);
		System.out.println(msg3);

	}
}
