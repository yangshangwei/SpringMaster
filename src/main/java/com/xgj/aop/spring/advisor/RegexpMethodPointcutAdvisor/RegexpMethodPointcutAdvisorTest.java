package com.xgj.aop.spring.advisor.RegexpMethodPointcutAdvisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @ClassName: RegexpMethodPointcutAdvisorTest
 * 
 * @Description: 单元测试类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月18日 下午11:30:01
 */
public class RegexpMethodPointcutAdvisorTest {
	@Test
	public void test() {
		// 加载配置文件,启动容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/RegexpMethodPointcutAdvisor/conf-advisor.xml");
		// 从容器中获取Bean
		Waiter waiter = ctx.getBean("waiter", Waiter.class);
		Seller seller = ctx.getBean("seller", Seller.class);
		// 调用业务方法
		waiter.greetTo("XiaoGongJiang");
		waiter.serverTo("XiaoGongJiang");
		seller.greetTo("XiaoGongJiang");
	}
}
