package com.xgj.dao.basicOperation.callProc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CallProcDemoWithCallableStatementCreatorTest {

	ClassPathXmlApplicationContext ctx = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/basicOperation/basicOperation.xml");
		System.out.println("initContext successfully");
	}

	@Test
	public void testCallProcWithCallableStatementCreator() {

		ctx.getBean("callProcDemoWithCallableStatementCreator",
				CallProcDemoWithCallableStatementCreator.class)
				.printUserInfo(1);

		System.out
				.println("testCallProcWithCallableStatementCreator successsfully");
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}

}
