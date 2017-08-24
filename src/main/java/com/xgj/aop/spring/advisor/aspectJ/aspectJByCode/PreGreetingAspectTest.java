package com.xgj.aop.spring.advisor.aspectJ.aspectJByCode;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * 
 * 
 * @ClassName: PreGreetingAspectTest
 * 
 * @Description:
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月24日 下午3:21:29
 */
public class PreGreetingAspectTest {

	@Test
	public void test() {
		// 目标类
		Waiter target = new NaiveWaiter();
		// 实例化切面代理工厂
		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
		// 设置目标对象
		aspectJProxyFactory.setTarget(target);
		// 添加切面类
		aspectJProxyFactory.addAspect(PreGreetingAspect.class);
		// 生成织入切面的代理对象
		Waiter proxy = aspectJProxyFactory.getProxy();
		// 调用业务方法
		proxy.greetTo("XiaoGongJiang");
		proxy.serverTo("XiaoGongJiang");
	}
}
