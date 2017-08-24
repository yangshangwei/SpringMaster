package com.xgj.aop.spring.advisor.autoCreateProxy.AnnotationAwareAspectJAutoProxyCreato;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.aop.spring.advisor.aspectJ.aspectJByConf.Waiter;

public class AnnotationAwareAspectJAutoProxyCreatorTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/autoCreateProxy/AnnotationAwareAspectJAutoProxyCreator/conf-aspectJ.xml");

		Waiter naiveWaiter = ctx.getBean("waiter", Waiter.class);

		naiveWaiter.greetTo("XiaoGongJiang");
		naiveWaiter.serverTo("XiaoGongJiang");
	}
}
