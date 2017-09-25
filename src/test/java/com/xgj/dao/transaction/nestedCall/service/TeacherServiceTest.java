package com.xgj.dao.transaction.nestedCall.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TeacherServiceTest {

	ClassPathXmlApplicationContext ctx = null;
	TeacherService teacherService = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/transaction/nestedCall/conf_tx_nestedCall.xml");
		teacherService = ctx.getBean("teacherService", TeacherService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testNestedCallInOneTransaction() {
		teacherService.doSomething();
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
