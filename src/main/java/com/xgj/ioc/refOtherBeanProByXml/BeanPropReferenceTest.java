package com.xgj.ioc.refOtherBeanProByXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPropReferenceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/refOtherBeanProByXml/beans.xml");
		ApplicationManager applicationManager = ctx.getBean(
				"applicationManager", ApplicationManager.class);
		applicationManager.getSessionTimeout();
		applicationManager.getMaxTabPageNum();

	}
}
