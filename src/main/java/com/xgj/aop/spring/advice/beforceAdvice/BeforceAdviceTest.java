package com.xgj.aop.spring.advice.beforceAdvice;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class BeforceAdviceTest {
	@Test
	public void test() {
		// 创建目标对象
		Waiter target = new NaiveWaiter();
		// 创建增强类对象
		BeforeAdvice advice = new GreetingBeforeAdvice();

		// (1)创建代理工厂对象 - Spring提供的代理工厂
		ProxyFactory factory = new ProxyFactory();

		// (2)设置代理目标
		factory.setTarget(target);

		// (3)为代理目标添加增强
		factory.addAdvice(advice);

		// (4)获取代理类
		Waiter proxy = (Waiter) factory.getProxy();

		// 调用目标类方法
		proxy.greetTo("Xiao");
		proxy.serverTo("GongJiang");
	}
}
