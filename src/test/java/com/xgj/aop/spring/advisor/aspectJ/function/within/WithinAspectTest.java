package com.xgj.aop.spring.advisor.aspectJ.function.within;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.aop.spring.advisor.aspectJ.function.within.seller.SmartSeller;

public class WithinAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJ/function/within/conf-within.xml");

		NaiveWaiter naiveWaiter = ctx.getBean("naiveWaiter", NaiveWaiter.class);
		naiveWaiter.greetTo("XiaoGongJiang");
		naiveWaiter.serverTo("XiaoGongJiang");

		NaughtyWaiter naughtyWaiter = ctx.getBean("naughtyWaiter",
				NaughtyWaiter.class);
		naughtyWaiter.greetTo("XiaoGongJiang");
		naughtyWaiter.serverTo("XiaoGongJiang");

		SmartSeller smartSeller = ctx.getBean("smartSeller", SmartSeller.class);
		smartSeller.smileTo("XiaoGongJiang");
		smartSeller.jokeTo("XiaoGongJiang");
	}
}
