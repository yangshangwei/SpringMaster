package com.xgj.aop.spring.advisor.aspectJ.function.execution.end;

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
public class ExecutionEndAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJ/function/execution/end/conf-execution.xml");

		WaiterOne waiterOne = (WaiterOne) ctx.getBean("waiterOne");

		WaiterTwo waiterTwo = (WaiterTwo) ctx.getBean("waiterTwo");

		waiterOne.greetTo("XiaoGongJiang");
		waiterOne.serverTo("XiaoGongJiang");
		waiterOne.smile("XiaoGongJiang");

		waiterTwo.greetTo("XiaoGongJiang");
		waiterTwo.serverTo("XiaoGongJiang");
		waiterTwo.smile("XiaoGongJiang");
	}
}
