package com.xgj.aop.spring.advisor.aspectJ.function.execution.classpoint;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecutionClassAspectTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJ/function/execution/classpoint/conf-execution.xml");

		CleanerOne cleanerOne = (CleanerOne) ctx.getBean("cleanerOne");
		CleanerTwo cleanerTwo = (CleanerTwo) ctx.getBean("cleanerTwo");

		cleanerOne.cleanTable();
		cleanerOne.cleanWindow();
		cleanerOne.cleanFloor();

		cleanerTwo.cleanTable();
		cleanerTwo.cleanWindow();
		cleanerTwo.cleanDoor();
	}
}
