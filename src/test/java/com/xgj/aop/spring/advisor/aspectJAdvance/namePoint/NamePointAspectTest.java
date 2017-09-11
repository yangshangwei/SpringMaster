package com.xgj.aop.spring.advisor.aspectJAdvance.namePoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @ClassName: NamePointAspectTest
 * 
 * @Description: 命名切点测试类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月10日 下午11:56:50
 */

public class NamePointAspectTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJAdvance/namePoint/conf-namePoint.xml");

		CuteWaiter cuteWaiter = ctx.getBean("cuteWaiter", CuteWaiter.class);
		NaiveWaiter naiveWaiter = ctx.getBean("naiveWaiter", NaiveWaiter.class);

		naiveWaiter.greetTo("XiaoGongJiang");
		System.out.println("================");

		cuteWaiter.greetTo("XiaoGongJiang");
		System.out.println("================");

		naiveWaiter.serverTo("XiaoGongJiang");
		System.out.println("================");

		cuteWaiter.serverTo("XiaoGongJiang");
	}
}