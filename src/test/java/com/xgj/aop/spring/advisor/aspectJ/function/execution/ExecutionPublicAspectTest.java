package com.xgj.aop.spring.advisor.aspectJ.function.execution;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @ClassName: ExecutionPublicAspectTest
 * 
 * @Description: execution(public * *(..)) 测试类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月27日 下午1:52:25
 */
public class ExecutionPublicAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJ/function/execution/conf-execution.xml");

		SmartSeller smartSeller = (SmartSeller) ctx.getBean("smartSeller");
		// sell方法是public,会织入前置增强中的横切逻辑
		smartSeller.sell("bread");
		// smileTo方法是protec,不会织入前置增强中的横切逻辑
		smartSeller.smileTo("XiaoGongJiang");

		NaiveWaiter naiveWaiter = (NaiveWaiter) ctx.getBean("naiveWaiter");
		// greetTo方法是public,会织入前置增强中的横切逻辑
		naiveWaiter.greetTo("XiaoGongJiang");

	}

}
