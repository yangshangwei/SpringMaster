package com.xgj.ioc.i18n.reloadableResourceBundleMessageSource;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReloadableResourceBundleMessageSourceTest {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/i18n/reloadableResourceBundleMessageSource/beans.xml");

		MessageSource messageSource = ctx.getBean("resource",
				MessageSource.class);

		Object[] objects = { "XiaoGongJiang", new GregorianCalendar().getTime() };

		for (int i = 0; i < 2; i++) {
			String msg = messageSource.getMessage("greeting.common", objects,
					Locale.US);
			System.out.println(msg + "\nsleep 20S");
			Thread.sleep(20000);
		}
	}
}
